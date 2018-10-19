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

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：CachedThreadPool   
* @Description：   <p> 
* https://blog.csdn.net/agoodcoolman/article/details/44082181
* https://www.zhihu.com/question/23212914
* 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
* 
* 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
*  Star ： https://www.cnblogs.com/baizhanshi/p/5469948.html</p>
* @Author： - Jason   
* @CreatTime：2018年5月16日 下午6:04:59   
* @Modify By：   
* @ModifyTime：  2018年5月16日
* @Modify marker：   
* @version    V1.0
 */
public class CachedThreadPool {
	
    public static void main(String[] args) {
    	
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
