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
package cn.ucaner.datastructure.loadbalance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**     
* @Package：cn.ucaner.datastructure.loadbalance   
* @ClassName：RoundRobin   
* @Description：   <p> 轮询算法
* https://www.cnblogs.com/szlbm/p/5588555.html
* </p>
* @Author： - Jason   
* @CreatTime：2018年5月16日 下午8:33:15   
* @Modify By：   
* @ModifyTime：  2018年5月16日
* @Modify marker：   
* @version    V1.0
*/
public class RoundRobin {
	
	private static Integer pos = 0;
	    
	public static String getServer(){
	    // 重建一个Map，避免服务器的上下线导致的并发问题
	    Map<String, Integer> serverMap = new HashMap<String, Integer>();
	    serverMap.putAll(IpMap.serverWeightMap);
	    // 取得Ip地址List
	    Set<String> keySet = serverMap.keySet();
	    ArrayList<String> keyList = new ArrayList<String>();
	    keyList.addAll(keySet);
	    String server = null;
	    synchronized (pos){
	        if (pos > keySet.size())
	            pos = 0;
	        server = keyList.get(pos);
	        pos ++;
	    }
	    return server;
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
