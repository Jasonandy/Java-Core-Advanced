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
package cn.ucaner.algorithm.KMP;

/**
* @Package：cn.ucaner.algorithm.KMP   
* @ClassName：KMP   
* @Description：   <p> https://blog.csdn.net/yutianzuijin/article/details/11954939/ </p>
* @Author： - Jason   
* @CreatTime：2018年4月23日 下午8:34:50   
* @Modify By：   
* @ModifyTime：  2018年4月23日
* @Modify marker：   
* @version    V1.0
 */
public class KMP {

	/**
	 * 前置处理
	 * @param B
	 * @return
	 */
	public static int[] preProcess(char[] B){
		int size = B.length;
		int[] P = new int[size];
		P[0] = 0;
		int j = 0;
		/**
		 * KMP中的核心算法 获得记录跳转状态的next数组
		 * i表示字符串的下标，从0开始
		 */
		for(int i=1;i<size;i++){
			/**
			 * j在每次循环开始都表示next[i]的值，同时也表示需要比较的下一个位置
			 */
			while(j>0 && B[j]!=B[i]){
				j = P[j];
			}
			if(B[j] == B[i]){
				j++;
			}
			P[i] = j;
		}
		return P;
	}

	/**
	 * kmp
	 * @param parStr  父串
	 * @param subStr  子串
	 */
	public static void kmp(String parStr,String subStr){
		int subSize = subStr.length();
		int parSize = parStr.length();
		char[] B = subStr.toCharArray();
		char[] A = parStr.toCharArray();
		int[] P = preProcess(B);
		System.out.println("P 的列表如下：");
		for(int single:P){
			System.out.println("single = " + single);
		}
		System.out.println("==========================");
		int j=0;
		int k=0;
		for(int i=0;i<parSize;i++)
		{
			while(j>0&&B[j]!=A[i])
			{
				j = P[j-1];
			}
			if(B[j] == A[i])
			{
				j++;
			}
			if(j == subSize)
			{
				j = P[j-1];
				k++;
				System.out.printf("Find  subString '%s' at %d\n",subStr,i-subSize+1);
			}
		}
		System.out.printf("Totally found %d times for '%s'.\n", k,subStr);
	}
	
	public static void main(String[] args){
		kmp("HelloWorld ! I'm Jason . what's you name. You are what you want to be .", "a");
	}
}
