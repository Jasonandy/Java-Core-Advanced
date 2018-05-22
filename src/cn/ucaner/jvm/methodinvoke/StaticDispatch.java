/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.jvm.methodinvoke;

/**
* @Package：cn.ucaner.jvm.methodinvoke   
* @ClassName：StaticDispatch   
* @Description：   <p> 方法静态分派演示 </br> Method Overload Resolution</p>
* @Author： -    
* @CreatTime：2018年4月10日 下午10:04:08   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {
    }

    static class Woman extends Human {
    }

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sr = new StaticDispatch();

        sr.sayHello(man);
        sr.sayHello(woman);
        sr.sayHello((Man)man);
        sr.sayHello((Woman) woman);
    }
}

/*
hello,guy!
hello,guy!
hello,gentleman!
hello,lady!
 */