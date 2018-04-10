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

/**
* @Package：cn.ucaner.core.base.generics   
* @ClassName：GenericArrayWithTypeToken   
* @Description：   <p> GenericArrayWithTypeToken</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:22:16   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    // Expose the underlying representation:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai =
                new GenericArrayWithTypeToken<Integer>(
                        Integer.class, 10);
        // This now works:
        Integer[] ia = gai.rep();
    }
} ///:~
