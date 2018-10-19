/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.thread.uncaughtexp;

/**
* @Package：cn.ucaner.core.thread.uncaughtexp   
* @ClassName：UncaughtTask   
* @Description：   <p> 描述:抛出运行时异常的线程类</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:18:08   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class UncaughtTask implements Runnable {
	
    @Override
    public void run() {
        @SuppressWarnings("unused")
		int numero = Integer.parseInt("TTTT");
    }
}
