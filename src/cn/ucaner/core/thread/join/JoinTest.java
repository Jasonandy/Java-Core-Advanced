/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.thread.join;

/**
* @Package：cn.ucaner.core.thread.join   
* @ClassName：JoinTest   
* @Description：   <p> JoinTest
* https://www.cnblogs.com/lcplcpjava/p/6896904.html
* Thread类中的join方法的主要作用就是同步，它可以使得线程之间的并行执行变为串行执行
* </p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午1:21:03   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class JoinTest {
	
    public static void main(String[] args) throws InterruptedException {
    	
        Thread t1 = new Thread(new DSLoader()); //4s
        Thread t2 = new Thread(new NetLoader()); //6s

        t1.start();
        t2.start();

        //可以注释其中一个加深理解
        /** join的意思是使得放弃当前线程的执行，并返回对应的线程，例如下面代码的意思就是：
        	程序在main线程中调用t1线程的join方法，则main线程放弃cpu控制权，并返回t1线程继续执行直到线程t1执行完毕
        	所以结果是t1线程执行完后，才到主线程执行，相当于在main线程中同步t1线程，t1执行完了，main线程才有执行的机会
        */
        t1.join(); //4s<6s也就是先t1上完  后面才开始t2
        //t2.join();

        System.out.println("ending all");
    }
}
//Outputs
//begining the NetLoader
//begining the DSLoader
//DSLoader has finished
//ending all
//NetLoader has finished