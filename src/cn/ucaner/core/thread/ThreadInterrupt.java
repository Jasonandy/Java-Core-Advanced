/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.thread;

/**
* @Package：cn.ucaner.core.thread   
* @ClassName：ThreadInterrupt   
* @Description：   <p> ThreadInterrupt</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:06:55   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class ThreadInterrupt {
	
    public static void main(String[] args) throws InterruptedException {
        Thread inThread = new Thread(new InterrupThread());
        inThread.start();
        Thread.sleep(1000);
        inThread.interrupt();
    }
    
}

class InterrupThread implements Runnable {

    private int num = 1;
    @Override
    public void run() {
        while (true)
            System.out.println("true ----> " + num++);
    }
}
