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

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：CountDownLatchT   
* @Description：   
* <p> 同步辅助类:完成一组线程执行前,使得一个或多个线程一直等待 </br> {@link https://www.cnblogs.com/cuglkb/p/8572239.html https://blog.csdn.net/yanyan19880509/article/details/52349056}
* </p>
* @Author：    
* @CreatTime：2018年4月5日 下午12:57:20   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class CountDownLatchT {
 
    // 线程中止的计数器
    private final static int COUNT = 10;
    
    private final static CountDownLatch count = new CountDownLatch(COUNT);

    // 线程池
    private final static ExecutorService service = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            service.execute(() -> {
                try {
                    int time = new Random().nextInt(5);
                    TimeUnit.SECONDS.sleep(time);
                    System.out.printf("Thread %s ## 耗时:%d\n", Thread.currentThread().getId(), time);
                    // 线程结束后,计数器减一
                    count.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }

        // 主线程一直被阻塞,直到count为0,实现线程同步
        count.await();
        service.shutdown();

        System.out.println("同步线程执行组结束!");

    }
}
//Outputs
//Thread 12 ## 耗时:0
//Thread 10 ## 耗时:1
//Thread 10 ## 耗时:0
//Thread 12 ## 耗时:1
//Thread 12 ## 耗时:0
//Thread 14 ## 耗时:2
//Thread 10 ## 耗时:2
//Thread 13 ## 耗时:4
//Thread 11 ## 耗时:4
//Thread 12 ## 耗时:4
//同步线程执行组结束!


