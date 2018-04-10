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
* @ClassName：NoInitialization   
* @Description：   <p>  非主动使用类字段演示
* <br/>1. 静态字段只有直接定义这个字段的类才会被初始化
* <br/>2. 通过数组来定义引用类,不会触发类的初始化
* <br/>(-XX:+TraceClassLoading,对于 HotSpot 虚拟机可观察到子类的加载)
* 
* </p>
* @Author： - DaoDou   
* @CreatTime：2018年4月10日 下午9:53:05   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class NoInitialization {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
        SubClass[] sca = new SubClass[10];

        System.out.println(ConstClass.HELLOWORLD);
    }
}
/*
SuperClass init!
123
 */