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

import java.lang.reflect.Array;
import java.util.Arrays;

/**
* @Package：cn.ucaner.core.base.generics   
* @ClassName：ArrayMaker   
* @Description：   <p> 对于泛型中创建数组,使用Array.newInstance()是推荐的方式 </p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:16:13   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker =
                new ArrayMaker<String>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
//system out:
//[null, null, null, null, null, null, null, null, null]

