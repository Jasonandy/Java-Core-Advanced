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

import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.thread.join   
* @ClassName：NetLoader   
* @Description：   <p> NetLoader</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:21:28   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class NetLoader implements Runnable {
	
    @Override
    public void run() {
        System.out.println("begining the NetLoader");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("NetLoader has finished");
    }
}
