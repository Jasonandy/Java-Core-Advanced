/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年4月10日 上午9:46:32</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.algorithm.fibonacci;

/**
* @Package：cn.ucaner.algorithm.fibonacci   
* @ClassName：Fibonacci   
* @Description：   <p> Fibonacci - 斐波那契亚</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 上午9:45:51   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class Fibonacci {
	
	public static void main(String[] args){
		
		int[] fib = new int[10];
		
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i= 2;i<fib.length;i++){
			fib[i] = fib[i-1] + fib[i-2];//Core 第3个数等于前两个数之和
		}
	
		System.out.print("斐波那契亚数列: ");
		
		for(int i = 0;i<fib.length;i++){
			System.out.print(fib[i] + " ");
		}
		
		System.out.println();
	}
}
//Output
//斐波那契亚数列: 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765 10946 17711 
