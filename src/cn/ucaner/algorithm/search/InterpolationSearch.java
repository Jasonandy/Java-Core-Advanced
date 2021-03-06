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
 * Interpolation search is an algorithm for searching for a given key in an indexed array that has been ordered by numerical values assigned to the keys (key values). It parallels how humans search 
 * through a telephone book for a particular name, the key value by which the book's entries are ordered.
 * <p>
 * Worst-case performance      O(n)<br>
 * Average performance         O(log(log(n)))<br>
 * <p>
 * @see <a href="https://en.wikipedia.org/wiki/Interpolation_search">Interpolation Search (Wikipedia)</a>
 * <br>
 * @author Justin Wetherell <phishman3579@gmail.com>
 */
public class InterpolationSearch {

    private static int[] sorted = null;

    /**
     * Assuming the array is sorted
     * @param value
     * @param array
     * @return
     */
    public static final int find(int value, int[] array) {
        InterpolationSearch.sorted = array;
        try {
            return recursiveFind(value, 0, InterpolationSearch.sorted.length - 1);
        } finally {
            InterpolationSearch.sorted = null;
        }
    }

    /**
     * recursiveFind
     * @param value
     * @param start
     * @param end
     * @return
     */
    private static int recursiveFind(int value, int start, int end) {
        if (start == end) {
            /**
             * start==end
             */
            int lastValue = sorted[start];
            if (value == lastValue){
                /**
                 * start==end
                 */
                return start;
            }
            return Integer.MAX_VALUE;
        }

        final int mid = start + ((value - sorted[start]) * (end - start)) / (sorted[end] - sorted[start]);
        if (mid < 0 || mid > end) {
            return Integer.MAX_VALUE;
        }
        int midValue = sorted[mid];
        if (value == midValue) {
            return mid;
        }
        if (value > midValue) {
            return recursiveFind(value, mid + 1, end);
        }
        return recursiveFind(value, start, mid - 1);
    }
}
