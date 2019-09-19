/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.component.rpc.consumer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * RPC（Remote Procedure Call Protocol） -- 远程过程调用协议，它是一种通过网络从远程计算机程序上请求服务，
 * 而不需要了解底层网络技术的协议。RPC协议假定某些传输协议的存在，如TCP或UDP，为通信程序之间携带信息数据。
 * 在OSI网络通信模型中，RPC跨越了传输层和应用层。RPC使得开发包括网络分布式多程序在内的应用程序更加容易。//应用层面协议  add by Jason
 * 
 * RPC采用客户机/服务器模式
 * 	-- 服务化 、微服务 和分布式系统架构   Service之间的通信实现Rpc
 * 
 * RPC 服务方通过 RpcServer 去导出（export）远程接口方法，而客户方通过 RpcClient 去引入（import）远程接口方法
 * 客户方像调用本地方法一样去调用远程接口方法，RPC 框架提供接口的代理实现，实际的调用将委托给代理RpcProxy.
 * 代理封装调用信息并将调用转交给RpcInvoker 去实际执行。
 * 在客户端的RpcInvoker 通过连接器RpcConnector 去维持与服务端的通道RpcChannel，
 * 并使用RpcProtocol 执行协议编码（encode）并将编码后的请求消息通过通道发送给服务方。
 * 
 * RPC 服务端接收器 RpcAcceptor 接收客户端的调用请求，同样使用RpcProtocol 执行协议解码（decode）。
 * 解码后的调用信息传递给RpcProcessor 去控制处理调用过程，最后再委托调用给RpcInvoker 去实际执行并返回调用结果。
 * 
 * 部件拆析
 * 1) RpcServer - 负责导出（export）远程接口  
 * 2) RpcClient - 负责导入（import）远程接口的代理实现  
 * 3) RpcProxy  - 远程接口的代理实现  
 * 4) RpcInvoker
 * 		客户方实现：负责编码调用信息和发送调用请求到服务方并等待调用结果返回 
 * 		服务方实现：负责调用服务端接口的具体实现并返回调用结果
 * 5) RpcProtocol -  负责协议编/解码
 * 6) RpcConnector  - 负责维持客户方和服务方的连接通道和发送数据到服务方
 * 7) RpcAcceptor  - 负责接收客户方请求并返回请求结果
 * 8) RpcProcessor - 负责在服务方控制调用过程，包括管理调用线程池、超时时间等  
 * 9) RpcChannel  - 数据传输通道
 * 
 * @author https://blog.csdn.net/kingcat666/article/details/78577079
 * 
 * 描述:Rpc本地服务代理类
 * 1. 将本地接口调用转化为JDK的动态调用,在动态调用中实现接口的远程调用
 * 2. 创建Socket客户端,根据制定地址连接远程服务提供者
 * 3. 将远程服务调用所需的接口类,方法名,参数列表等编码后发送给服务提供者
 * 4. 同步阻塞等待服务端返回应答,获取应答后返回 // netty 异步方案可以优化
 */
public class RpcImporter<S> {
	
	
	/**
	 * @Description: Rpc本地服务代理类
	 * @param serviceClass             serviceClass 服务类
	 * @param address                  远程地址 - InetSocketAddress
	 * @return S
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
    @SuppressWarnings("unchecked")
	public S importer(final Class<?> serviceClass, final InetSocketAddress address) {
        // JDK动态代理,实现接口的远程调用
        return (S) Proxy.newProxyInstance(serviceClass.getClassLoader(),
                new Class<?>[]{serviceClass.getInterfaces()[0]},
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Socket socket = null;
                        /**
                         * 对象输出流
                         */
                        ObjectOutputStream output = null;
                        /**
                         * 对象输入流
                         */
                        ObjectInputStream  input  = null;

                        try {
                        	
                        	/**
                        	 * 创建Socket客户端,根据制定地址连接远程服务提供者
                        	 */
                            socket = new Socket();
                            socket.connect(address);

                            /**
                             * 对象输出流
                             * 将远程服务调用所需的接口类,方法名,参数列表等编码后发送给服务提供者
                             */
                            output = new ObjectOutputStream(socket.getOutputStream());
                            output.writeUTF(serviceClass.getName());
                            output.writeUTF(method.getName());
                            output.writeObject(method.getParameterTypes());
                            output.writeObject(args);

                            /**
                             * 远程服务调用所需的接口类,方法名,参数列表等编码后发送给服务提供者
                             */
                            input = new ObjectInputStream(socket.getInputStream());
                            return input.readObject();
                        } finally {
                            if (socket != null) {
                                socket.close();
                            }
                            if (output != null) {
                                output.close();
                            }
                            if (input != null) {
                                input.close();
                            }
                        }
                    }
                });
    }
}
