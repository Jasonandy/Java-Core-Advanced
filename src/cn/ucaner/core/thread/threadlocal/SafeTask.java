package cn.ucaner.core.thread.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.thread.threadlocal   
* @ClassName：SafeTask   
* @Description：   <p> 看类里面说明</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:20:22   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class SafeTask implements Runnable{
    /**
     * ThreadLocal对象不会被所有线程共享
     * --> 线程局部变量 <--
     */
    private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
        /**
         * 隐式实现初始化对象
         * @return
         */
        @Override
        protected Date initialValue() {
            return new Date();
        }
    };

    @Override
    public void run() {
        System.out.printf("Starting Thread:%s : %s\n",Thread.currentThread().getId(),startDate.get());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Finish Thread:%s : %s\n",Thread.currentThread().getId(),startDate.get());
    }
}
