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

import java.util.concurrent.ThreadFactory;

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：DaemonThreadFactory   
* @Description：   <p> DaemonThreadFactory </p>
* @Author： -    
* @CreatTime：2018年6月12日 下午3:50:06   
* @Modify By：   
* @ModifyTime：  2018年6月12日
* @Modify marker：   
* @version    V1.0
 */
public class DaemonThreadFactory implements ThreadFactory {
	
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
