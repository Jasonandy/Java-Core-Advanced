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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：FixedThreadPool   
* @Description：   <p> FixedThreadPool </p>
* @Author： -    
* @CreatTime：2018年6月12日 下午3:49:55   
* @Modify By：   
* @ModifyTime：  2018年6月12日
* @Modify marker：   
* @version    V1.0
 */
public class FixedThreadPool {
	
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
