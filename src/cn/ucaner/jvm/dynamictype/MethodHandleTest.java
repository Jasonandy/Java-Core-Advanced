/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.jvm.dynamictype;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
* @Package：cn.ucaner.jvm.dynamictype   
* @ClassName：MethodHandleTest   
* @Description：   <p>  MethodHandle 演示 </p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:56:56   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println("classA " + s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();
        getPrintlnMH(obj).invokeExact("brianway");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {
        // 方法类型
        MethodType mt = MethodType.methodType(void.class, String.class);

        return lookup().findVirtual(receiver.getClass(), "println", mt)
                .bindTo(receiver);
    }
}
