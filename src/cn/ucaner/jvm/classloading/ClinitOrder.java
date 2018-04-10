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
* @ClassName：ClinitOrder   
* @Description：   <p> <clinit>() 方法执行顺序</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:48:54   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class ClinitOrder {
	
    static class Parent {
    	
        public static int A = 1;

        static {
            System.out.println("execute before A = 2, A now is " + A);
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }


    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
//execute before A = 2, A now is 1   2


