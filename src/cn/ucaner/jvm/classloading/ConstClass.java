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
* @ClassName：ConstClass   
* @Description：   <p> 被动使用类字段演示 
* </br>	常量在编译阶段会存入调用类的常量池,本质上没有引用调用常量的类,不会触发定义常量的类的初始化
* </p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:49:48   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class ConstClass {
	
    static {
        System.out.println("ConsClass init!");
    }

    public static final String HELLOWORLD = "hello world";
    
    
    public static void main(String[] args) {
		new ConstClass();
	}
    
}
//Output
//ConsClass init!
