/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年5月16日 下午8:33:15</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.component.loadbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**     
* @Package：cn.ucaner.datastructure.loadbalance   
* @ClassName：Hash   
* @Description：   <p> Hash</p>
* @Author： - Jason   
* @CreatTime：2018年5月16日 下午8:38:29   
* @Modify By：   
* @ModifyTime：  2018年5月16日
* @Modify marker：   
* @version    V1.0
*/
public class Hash {

	public static String getServer(){
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        // 在Web应用中可通过HttpServlet的getRemoteIp方法获取
        String remoteIp = "127.0.0.1";
        int hashCode = remoteIp.hashCode();
        int serverListSize = keyList.size();
        int serverPos = hashCode % serverListSize;
        return keyList.get(serverPos);
    }
	

	/**
	 * @Description: Just for Test
	 * @param args void
	 * @Autor: Jason - Jasonandy@hotmail.com
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(getServer());
		}
	}
}
