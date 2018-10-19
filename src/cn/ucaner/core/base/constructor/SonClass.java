/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason https://github.com/Jasonandy/patterns</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.base.constructor;

/**
* @Package：cn.ucaner.core.base.constructor   
* @ClassName：SonClass   
* @Description：   <p> 构造方法调用问题 </br>子类构造方法会首先默认调用父类的无参构造方法，无论是否显式写了super()</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 上午10:55:13   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class SonClass extends FatherClass {

    private static int countSon;

    static {
        System.out.println("子类可以访问父类的静态属性count " + count);//2- 子类可以访问父类的静态属性count 10
        System.out.println("子类的静态属性countSon初始化:" + countSon);//3- 子类的静态属性countSon初始化:0
    }

    public SonClass(String name) {
        //super(name);
        System.out.println("执行了子类的构造方法SonClass(String name) " + name);//5-执行了子类的构造方法SonClass(String name) aaa
    }

    public SonClass() {
        System.out.println("执行了子类的无参构造方法");// last - 执行了子类的无参构造方法
    }

    public static void main(String[] args) {
        new SonClass("aaa");
        new SonClass();
    }

}

/*
父类的静态属性count初始化:10
子类可以访问父类的静态属性count 10
子类的静态属性countSon初始化:0
执行了父类的无参构造方法
执行了子类的构造方法SonClass(String name) aaa
执行了父类的无参构造方法
执行了子类的无参构造方法
 */
