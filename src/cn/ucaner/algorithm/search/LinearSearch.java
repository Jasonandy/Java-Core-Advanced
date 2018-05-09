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
package cn.ucaner.algorithm.search;

/**
 * In computer science, linear search or sequential search is a method for finding a target value within a list. It sequentially checks each element of the list for the target value until a match is 
 * found or until all the elements have been searched.
 * <p>
 * Worst-case performance      O(n)<br>
 * Best-case performance       O(1)<br>
 * Average performance         O(n)<br>
 * Worst-case space complexity O(1)<br>
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Linear_search">Linear Search (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class LinearSearch {

    public static final int find(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            int iValue = array[i];
            if (value == iValue)
                return i;
        }
        return Integer.MAX_VALUE;
    }
    
    //Just for test
    public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8,9,0};
		int finds = 8;
		System.out.printf("数字:%d 在数组中的位置为:%d %n", finds,find(2, nums)+1);  
	}
}
//Outputs 
//数字:8 在数组中的位置为:2 