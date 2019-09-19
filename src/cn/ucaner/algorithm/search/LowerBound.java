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
 * Lower bound search algorithm.<br>
 * Lower bound is kind of binary search algorithm but:<br>
 * -If searched element doesn't exist function returns index of first element which is bigger than searched value.<br>
 * -If searched element is bigger than any array element function returns first index after last element.<br>
 * -If searched element is lower than any array element function returns index of first element.<br>
 * -If there are many values equals searched value function returns first occurrence.<br>
 * Behaviour for unsorted arrays is unspecified.
 * <p>
 * Complexity O(log n).
 * <p>
 * @author Bartlomiej Drozd <mail@bartlomiejdrozd.pl>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class LowerBound {

    private LowerBound() { }

    /**
     * lowerBound
     * @param array
     * @param length
     * @param value
     * @return
     */
    public static int lowerBound(int[] array, int length, int value) {
        int low = 0;
        int high = length;
        while (low < high) {
            final int mid = (low + high) / 2;
            if (value <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
