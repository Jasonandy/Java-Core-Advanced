package cn.ucaner.core.thread.join;

import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.thread.join   
* @ClassName：DSLoader   
* @Description：   <p> DSLoader</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:20:42   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class DSLoader implements Runnable {
    @Override
    public void run() {
        System.out.println("begining the DSLoader");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DSLoader has finished");
    }
}
