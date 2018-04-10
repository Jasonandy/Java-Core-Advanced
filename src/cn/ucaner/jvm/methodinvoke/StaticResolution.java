/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.jvm.methodinvoke;

/**
* @Package：cn.ucaner.jvm.methodinvoke   
* @ClassName：StaticResolution   
* @Description：   <p> 方法静态解析演示</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午10:04:34   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class StaticResolution {
	
    public static void sayHello() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        StaticResolution.sayHello();
    }
}
