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
* @ClassName：Convention   
* @Description：   <p>Convention - 公约 </p>
* @Author： - Jason   
* @CreatTime：2018年4月23日 下午8:40:19   
* @Modify By：   
* @ModifyTime：  2018年4月23日
* @Modify marker：   
* @version    V1.0
 */
public class Convention {
	
	/**
	 * @Description: 求两数的最大公约数
	 * @param m
	 * @param n
	 * @return int
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	static int divisor(int m,int n){   
		if(m%n==0){  
			return n;  
		}else{  
			return divisor(n,m%n);  
		}  
	} 
	
	/**
	 * @Description: 求两数的最小公倍数 
	 * @param a
	 * @param b
	 * @return int
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	static int gbs(int a,int b){  
		int gbs = 0;  
		gbs = a*b/divisor(a,b);  
		return gbs;  
	} 
	
	/**
	 * @Description: Just for test 
	 */
	public static void main(String[] args) {
		int m = 1115;
		int n =828;
		//int m = 8;
		//int n = 12;
		System.out.println(divisor(m,n));//最大公约数 
		System.out.println(gbs(m, n));//最小公倍数
	}
	
}
