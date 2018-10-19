/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.component.rpc.service.impl;

import cn.ucaner.component.rpc.service.EchoService;

/**
* @Package：cn.ucaner.component.rpc.service.impl   
* @ClassName：EchoServiceImpl   
* @Description：   <p> 服务Echo实现类 </p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:07:17   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class EchoServiceImpl implements EchoService {
    
	
	@Override
    public String echo(String ping) {
		
        return ping != null ? ping + " --> I am ok." : "I am ok.";
    }

	/**
	 * 假设有A B 系统 , 当前 B为A提供服务 , B服务实现  ,当前属于B端, 被A端RPC远程调用
	 * 
	 * 假装远程接口的实现类.  
	 */
	@Override
	public String helloWorld() {
		return "HelloWorld Rpc .  \r  -- Hi. I'am Jason .  \r  -- thks. ";
	}

	@Override
	public void show() {
		System.out.println("I'M RPC SHOW.");
	}
	
	
}
