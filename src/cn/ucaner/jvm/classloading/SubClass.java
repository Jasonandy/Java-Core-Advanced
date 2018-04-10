/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.jvm.classloading;

/**
* @Package：cn.ucaner.jvm.classloading   
* @ClassName：SubClass   
* @Description：   <p> 子类</p>
* @Author： - Jason   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class SubClass extends SuperClass {
	
    static {
        System.out.println("SubClass init!");
    }
}
