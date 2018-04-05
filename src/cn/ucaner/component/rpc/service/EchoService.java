/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternation.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年4月5日</p>
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
	
}
