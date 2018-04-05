package cn.ucaner.core.thread.threadlocal;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.thread.threadlocal   
* @ClassName：UnsafeTask   
* @Description：   <p> 私有变量会被所有线程共享</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:19:32   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class UnsafeTask implements Runnable{
    private Date startDate;

    @Override
    public void run() {
        startDate = new Date();
        System.out.printf("Starting Thread:%s : %s\n",Thread.currentThread().getId(),startDate);
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Finish Thread:%s : %s\n",Thread.currentThread().getId(),startDate);
    }
}
