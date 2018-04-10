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

public class Convention 
{
	/** 
	 * 求两数的最大公约数 
	 */  
	int divisor(int m,int n)
	{   
		if(m%n==0){  
			return n;  
		}else{  
			return divisor(n,m%n);  
		}  
	} 
	
	/** 
	 * 求两数的最小公倍数 
	 */  
	int gbs(int a,int b)
	{  
		int gbs = 0;  
		gbs = a*b/divisor(a,b);  
		return gbs;  
	}  
}
