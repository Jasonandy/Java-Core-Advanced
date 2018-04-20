/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.component.rpc.service;

/**     
 * @Package：cn.ucaner.component.rpc.service   
 * @ClassName：EchoService   
 * @Description：   <p> EchoService 服务Echo接口类 </p>
 * @Author： - Jason   
 * @CreatTime：2018年4月5日 下午12:05:41   
 * @Modify By：   
 * @ModifyTime：  2018年4月5日
 * @Modify marker：   
 * @version    V1.0
 */
public interface EchoService {

	/**
	 * @Description: echo
	 * @param ping
	 * @return String
	 */
	public String echo(String ping);
	
	
	/**
	 * @Description: 定义接口（服务）    --- 远程impl 实现  - [tips: package need same.]
	 * @return String
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public String helloWorld();
	
}
