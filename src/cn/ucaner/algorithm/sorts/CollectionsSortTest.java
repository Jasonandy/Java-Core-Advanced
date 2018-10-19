/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年4月10日 </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.algorithm.sorts;

import java.util.Arrays;
import java.util.Collections;

/**
* @Package：cn.ucaner.algorithm.sorts   
* @ClassName：CollectionsSortTest   
* @Description：   <p> CollectionsSortTest </p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 上午9:55:56   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class CollectionsSortTest {
	
	public static void main(String[] args){
        Integer[] num = {5,8,3,9,1,2,3,4,5,5,6,6,7,7,8,12,34,45,67,44,32};
        //double[] num = {4.4,2.9,6.3};  //不可以
        //Double[] num = {4.4,2.9,6.3};  //可以
        Arrays.sort(num,Collections.reverseOrder()); //对整形数组按降序排序
        for(int i=0;i<num.length;i++){
            System.out.println(num[i]);
        }  
	}
}
