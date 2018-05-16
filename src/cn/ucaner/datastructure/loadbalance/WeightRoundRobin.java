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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**     
* @Package：cn.ucaner.datastructure.loadbalance   
* @ClassName：WeightRoundRobin   
* @Description：   <p> WeightRoundRobin </p>
* @Author： - Jason   
* @CreatTime：2018年5月16日 下午8:39:44   
* @Modify By：   
* @ModifyTime：  2018年5月16日
* @Modify marker：   
* @version    V1.0
*/
public class WeightRoundRobin {
	
	private static Integer pos;
    
    public static String getServer(){
    	
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        
        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        
        List<String> serverList = new ArrayList<String>();
        while (iterator.hasNext())
        {
            String server = iterator.next();
            int weight = serverMap.get(server);
            for (int i = 0; i < weight; i++)
                serverList.add(server);
        }
        
        String server = null;
        synchronized (pos){
            if (pos > keySet.size())
                pos = 0;
            server = serverList.get(pos);
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
		//for (int i = 0; i < 10; i++) {
			System.out.println(getServer());
		//}
	}
	

}
