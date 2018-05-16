/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年5月16日 下午8:00:17</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.datastructure.loadbalance;

import java.util.HashMap;

/**     
* @Package：cn.ucaner.datastructure.loadbalance   
* @ClassName：IpMap   
* @Description：   <p> IpMap 
* https://www.cnblogs.com/szlbm/p/5588555.html
* </p>
* @Author： - Jasom   
* @CreatTime：2018年5月16日 下午8:00:17   
* @Modify By：   
* @ModifyTime：  2018年5月16日
* @Modify marker：   
* @version    V1.0
*/
public class IpMap {
	
	
	 // 待路由的Ip列表，Key代表Ip，Value代表该Ip的权重
    public static HashMap<String, Integer> serverWeightMap =  new HashMap<String, Integer>();
    
    static{
        serverWeightMap.put("192.168.1.100", 1);
        serverWeightMap.put("192.168.1.101", 1);
        // 权重为4
        serverWeightMap.put("192.168.1.102", 4);
        serverWeightMap.put("192.168.1.103", 1);
        serverWeightMap.put("192.168.1.104", 1);
        // 权重为3
        serverWeightMap.put("192.168.1.105", 3);
        serverWeightMap.put("192.168.1.106", 1);
        // 权重为2
        serverWeightMap.put("192.168.1.107", 2);
        serverWeightMap.put("192.168.1.108", 1);
        serverWeightMap.put("192.168.1.109", 1);
        serverWeightMap.put("192.168.1.110", 1);
    }

}
