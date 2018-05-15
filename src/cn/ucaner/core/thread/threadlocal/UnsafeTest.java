package cn.ucaner.core.thread.threadlocal;

import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.thread.threadlocal   
* @ClassName：UnsafeTest   
* @Description：   <p> 可以看到线程每个有不同的启动时间,但是结束时间会有相同.</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:19:12   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class UnsafeTest {
	
    public static void main(String[] args) {
        UnsafeTask task = new UnsafeTask();
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
//Starting Thread:10 : Tue May 15 09:29:48 CST 2018
//Starting Thread:11 : Tue May 15 09:29:50 CST 2018
//Finish Thread:10 : Tue May 15 09:29:50 CST 2018
//Starting Thread:12 : Tue May 15 09:29:52 CST 2018
//Finish Thread:12 : Tue May 15 09:29:52 CST 2018
//Starting Thread:13 : Tue May 15 09:29:54 CST 2018
//Finish Thread:11 : Tue May 15 09:29:54 CST 2018
//Starting Thread:14 : Tue May 15 09:29:56 CST 2018
//Starting Thread:15 : Tue May 15 09:29:58 CST 2018
//Starting Thread:16 : Tue May 15 09:30:00 CST 2018
//Finish Thread:16 : Tue May 15 09:30:00 CST 2018
//Finish Thread:14 : Tue May 15 09:30:00 CST 2018
//Starting Thread:17 : Tue May 15 09:30:02 CST 2018