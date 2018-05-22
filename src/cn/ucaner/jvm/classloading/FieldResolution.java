/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.jvm.classloading;

/**
* @Package：cn.ucaner.jvm.classloading   
* @ClassName：FieldResolution   
* @Description：   <p> 字段解析 </br>如果注释了 Sub 类中的 "public static int A = 4",会编译错误 </p>
* @Author： -    
* @CreatTime：2018年4月10日 下午9:52:16   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class FieldResolution {
	
    interface Interface0 {
        int A = 0;
    }

    interface Interface1 extends Interface0 {
        int A = 1;
    }

    interface Interface2 {
        int A = 2;
    }

    static class Parent implements Interface1 {
        public static int A = 3;
    }

    static class Sub extends Parent implements Interface2 {
        public static int A = 4;// 注释此句试试
    }

    public static void main(String[] args) {
        System.out.println(Sub.A);
    }
}
