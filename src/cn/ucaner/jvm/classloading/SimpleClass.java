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
* @ClassName：SimpleClass   
* @Description：   <p> 分析字节码  javap -verbose SimpleClass.java</p>
* @Author： -    
* @CreatTime：2018年4月10日 下午9:54:52   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class SimpleClass {
	
    private int m;

    public int inc() {
        return m + 1;
    }
}
