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

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：LiftOff   
* @Description：   <p> LiftOff 启动起飞</p>
* @Author： - wubin   
* @CreatTime：2018年5月16日 下午6:05:59   
* @Modify By：   
* @ModifyTime：  2018年5月16日
* @Modify marker：   
* @version    V1.0
 */
public class LiftOff implements Runnable {
	
    protected int countDown = 10;
    
    private static int taskCount = 0;
    
    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + "), ";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
