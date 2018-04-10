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
import java.util.List;

/**
* @Package：cn.ucaner.core.base.generics   
* @ClassName：SuperTypeWildcards   
* @Description：   <p> 逆变 </br> 超类型通配符</p>
* @Author： - DaoDou   
* @CreatTime：2018年4月10日 下午9:24:58   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        // apples.add(new Fruit()); // Error
    }

    public static void main(String[] args) {
        SuperTypeWildcards.writeTo(new ArrayList<Fruit>());
    }
} ///:~
