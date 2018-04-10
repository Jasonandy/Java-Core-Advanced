/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
* @Package：cn.ucaner.core.annotation   
* @ClassName：SayHiAnnotation   
* @Description：   <p> 自定义注解，用来配置方法</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:39:10   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
@Retention(RetentionPolicy.RUNTIME) // 表示注解在运行时依然存在
@Target(ElementType.METHOD) // 表示注解可以被使用于方法上
public @interface SayHiAnnotation {
	
     String paramValue() default "Jason"; 
    // 表示我的注解需要一个参数 名为"paramValue" 默认值为"Jason"
}