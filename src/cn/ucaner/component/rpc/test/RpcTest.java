/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.component.rpc.test;

import java.io.IOException;
import java.net.InetSocketAddress;

import cn.ucaner.component.rpc.consumer.RpcImporter;
import cn.ucaner.component.rpc.provider.RpcExporter;
import cn.ucaner.component.rpc.service.EchoService;
import cn.ucaner.component.rpc.service.impl.EchoServiceImpl;

/**
* @Package：cn.ucaner.component.rpc.test   
* @ClassName：RpcTest   
* @Description：   <p> RPC测试代码类 </p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:11:46   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class RpcTest {
	
    public static void main(String[] args) {
    	
    	
    	/**
    	 * 启动服务提供者 
    	 * 
    	 * 同步阻塞 
    	 * 
    	 * opts. netty NIO 
    	 */
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    RpcExporter.exporter("localhost",8088);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        
        // follow code can opts. by 注册发现   add base on like dubbo protocol
        
        /**
         * 创建服务本地代理
         * 
         * 导出服务接口  EchoService
         */
        RpcImporter<EchoService> importer = new RpcImporter<EchoService>();

        /**
         * 从服务本地代理获取服务对象类
         * 
         * 获取接口（假想为远程的服务impl）
         */
        EchoService echo = importer.importer(EchoServiceImpl.class,new InetSocketAddress("localhost",8088));
        
        System.out.println(echo.echo(null));
        System.out.println(echo.echo("Are you OK?"));
        System.out.println(echo.helloWorld());//远程实现
    }
}
//Output
//I am ok.
//Are you OK? --> I am ok.
