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
* @ClassName：UncaughtTest   
* @Description：   <p> 描述:实现异常类Test</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:17:43   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class UncaughtTest {
	
    public static void main(String[] args) {
        UncaughtTask uncaughtTask = new UncaughtTask();
        Thread thread = new Thread(uncaughtTask);
        thread.setUncaughtExceptionHandler(new ExceptionHadler());
        thread.start();
    }
}

//Outputs
//An exception has been captured
//Thread: 10
//Exception: java.lang.NumberFormatException: For input string: "TTTT"
//Stack Trace: 
//java.lang.NumberFormatException: For input string: "TTTT"
//	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
//	at java.lang.Integer.parseInt(Integer.java:580)
//	at java.lang.Integer.parseInt(Integer.java:615)
//	at cn.ucaner.core.thread.uncaughtexp.UncaughtTask.run(UncaughtTask.java:19)
//	at java.lang.Thread.run(Thread.java:745)
//Thread status: RUNNABLE