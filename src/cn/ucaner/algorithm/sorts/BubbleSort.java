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


/**
* @Package：cn.ucaner.algorithm.sorts   
* @ClassName：BubbleSort   
* @Description：   <p> 冒泡排序算法 </p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 上午9:56:32   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class BubbleSort {
	
	public static void sort(int[] values){  
		int temp;  
		for (int i = 0; i < values.length; ++i) 
		{  
			for (int j = 0; j < values.length - i - 1; ++j)
			{  
				if (values[j] > values[j + 1]) 
				{  
					temp = values[j];  
					values[j] = values[j + 1];  
					values[j + 1] = temp;  
				}  
			}  
		}  
	} 
}
