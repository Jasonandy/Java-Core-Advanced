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
* @ClassName：Random   
* @Description：   <p> Random 
* 
* 基于概率统计的理论，吞吐量越大，随机算法的效果越接近于轮询算法的效果
* </p>
* @Author： - 随机算法   
* @CreatTime：2018年5月16日 下午8:36:48   
* @Modify By：   
* @ModifyTime：  2018年5月16日
* @Modify marker：   
* @version    V1.0
*/
public class Random {

	public static String getServer(){
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        java.util.Random random = new java.util.Random();//获取随机数
        int randomPos = random.nextInt(keyList.size());
        return keyList.get(randomPos);
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
