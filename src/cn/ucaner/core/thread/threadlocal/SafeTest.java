package cn.ucaner.core.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.thread.threadlocal   
* @ClassName：SafeTest   
* @Description：   <p> 可以看到线程每个有不同的启动时间,但是结束时间也会不相同.</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:19:59   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class SafeTest {
	
    public static void main(String[] args) {
        SafeTask task = new SafeTask();
        for (int i = 0 ; i < 10; i++) {
            Thread thread = new Thread(task);
            thread.start();

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
//Outputs 
//Starting Thread:10 : Tue May 15 09:29:00 CST 2018
//Starting Thread:11 : Tue May 15 09:29:02 CST 2018
//Finish Thread:11 : Tue May 15 09:29:02 CST 2018
//Starting Thread:12 : Tue May 15 09:29:04 CST 2018
//Starting Thread:13 : Tue May 15 09:29:06 CST 2018
//Starting Thread:14 : Tue May 15 09:29:08 CST 2018
//Finish Thread:10 : Tue May 15 09:29:00 CST 2018
//Starting Thread:15 : Tue May 15 09:29:10 CST 2018
//Finish Thread:14 : Tue May 15 09:29:08 CST 2018
//Finish Thread:12 : Tue May 15 09:29:04 CST 2018
