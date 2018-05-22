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
* @ClassName：DeadLoopClass   
* @Description：   <p> 字段解析
* </br> 多个线程同时初始化一个类,只有一个线程会执行 <clinit>()方法,其他被阻塞
* </p>
* @Author： -    
* @CreatTime：2018年4月10日 下午9:51:17   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class DeadLoopClass {
   
	static {
        if (true) {
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = () -> {
            System.out.println(Thread.currentThread() + " start");
            DeadLoopClass dlc = new DeadLoopClass();
            System.out.println(Thread.currentThread() + " run over");
        };

       Thread thread1 = new Thread(script);
       Thread thread2 = new Thread(script);
       thread1.start();
       thread2.start();
    }
}
//Output
//Thread[main,5,main] init DeadLoopClass
