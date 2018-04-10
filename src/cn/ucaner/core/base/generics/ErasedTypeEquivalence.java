/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.base.generics;

import java.util.ArrayList;

/**
* @Package：cn.ucaner.core.base.generics   
* @ClassName：ErasedTypeEquivalence   
* @Description：   <p> ErasedTypeEquivalence</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:20:47   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        Class c3 = ArrayList.class;
        System.out.println(c1 == c2);
        System.out.println(c1 == c3);
    }
}
/* Output:
true
true
*///:~
