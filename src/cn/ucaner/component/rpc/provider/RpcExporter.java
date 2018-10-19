/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.component.rpc.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
* @Package：cn.ucaner.component.rpc.provider   
* @ClassName：RpcExporter   
* @Description：   <p> RPC服务发布者  负责导出（export）远程接口</p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:09:38   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class RpcExporter {
	
	/**
	 * 创建固定大小的线程池 大小为CPU处理器的Runtime.getRuntime().availableProcessors()核心线程数
	 *  创建线程池 用来处理 客服端发送过来的二进制流数据
	 */
    static Executor executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    /**
     * @Description: exporter  - 用来监听tcp连接   - 二进制流反序列化成对象,反射调用服务实现者,获取执行结果
     * @param hostName         被监听的主机名称
     * @param port             被监听的端口
     * @throws IOException     
     * @Autor: Jason
     */
    public static void exporter(String hostName,int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(hostName,port));
        try {
            while (true) {
                /**
                 * 监听Client的TCP连接,将其封装成Task,由线程池执行.
                 */
                executor.execute(new ExporterTask(serverSocket.accept()));
            }
        } finally {
          serverSocket.close();  
        }
    }

    /**
     * 线程Task:
     * 1. 将客户端发送的二进制流反序列化成对象,反射调用服务实现者,获取执行结果
     * 2. 将执行结果对象反序列化,通过Socket发送给客户端
     * 3. 远程服务调用完成之后,释放Socket等连接资源,防止句柄泄漏
     */
    private static class ExporterTask implements Runnable {
        Socket client = null;
        public ExporterTask(Socket accept) {
            this.client = accept;
        }

        /**
         * 可自定义 通信协议  比如dubbo协议等
         * 
         *  
         */
        @Override
        public void run() {
            ObjectInputStream   input  = null;
            ObjectOutputStream  output = null;
            try {
                // 对象输入流
                input = new ObjectInputStream(client.getInputStream());
                // 获取接口名
                String interfaceName = input.readUTF();
                // 获取方法名
                String methodName = input.readUTF();
                // 获取方法的参数数组
                Class<?>[] paramTypes = (Class<?>[]) input.readObject();
                // 获取传入参数对象数组
                Object[] arguments = (Object[]) input.readObject();

                // 获取服务对象类
                Class<?> service = Class.forName(interfaceName);
                
                /**
                 * 通过 methodName 和 paramTypes 获取具体的方法
                 */
                Method method = service.getMethod(methodName,paramTypes);
                
                // 获取服务方法返回对象  //so interfaces 接口应该的包全名 和 serviceImpl远程对应的要一致
                /**
                 * 反射的方式调用需要调用的远程的方法
                 */
                Object result = method.invoke(service.newInstance(),arguments);

                // 对象输出流
                output = new ObjectOutputStream(client.getOutputStream());
                
                /**
                 * 将结果写出去
                 */
                output.writeObject(result);

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                // 关闭流的操作
                if (output != null) {
                    try {
                        output.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (input != null) {
                    try {
                        input.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (client != null) {
                    try {
                        client.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
