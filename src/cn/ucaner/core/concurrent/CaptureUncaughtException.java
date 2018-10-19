/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：CaptureUncaughtException   
* @Description：   <p> 捕捉异常</p>
* @Author： - Jason
* @CreatTime：2018年5月16日 下午6:10:37   
* @Modify By：   
* @ModifyTime：  2018年5月16日
* @Modify marker：   
* @version    V1.0
 */
public class CaptureUncaughtException {
	
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(
                new HandlerThreadFactory());
        exec.execute(new ExceptionThread());
    }
}

class ExceptionThread implements Runnable {
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by " + t);
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}

class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e + " in " + t);
    }
}

class HandlerThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        System.out.println(this + " creating new Thread");
        Thread t = new Thread(r);
        System.out.println("created " + t);
        t.setUncaughtExceptionHandler(
                new MyUncaughtExceptionHandler());
        System.out.println(
                "eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
}



/* Output: (90% match)
com.brianway.learning.java.concurrent.HandlerThreadFactory@266474c2 creating new Thread
created Thread[Thread-0,5,main]
eh = com.brianway.learning.java.concurrent.MyUncaughtExceptionHandler@6f94fa3e
run() by Thread[Thread-0,5,main]
eh = com.brianway.learning.java.concurrent.MyUncaughtExceptionHandler@6f94fa3e
com.brianway.learning.java.concurrent.HandlerThreadFactory@266474c2 creating new Thread
created Thread[Thread-1,5,main]
eh = com.brianway.learning.java.concurrent.MyUncaughtExceptionHandler@3ff961b5
caught java.lang.RuntimeException in Thread[Thread-0,5,main]
*///:~
