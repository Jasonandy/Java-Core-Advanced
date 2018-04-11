/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 注解会在class字节码文件中存在，在运行时可以通过反射获取到  
@Target({ElementType.FIELD,ElementType.METHOD})//定义注解的作用目标**作用范围字段、枚举的常量/方法  
@Documented//说明该注解将被包含在javadoc中  
public @interface FieldMeta {
	
	/** 
     * 是否为序列号 
     * @return 
     */  
    boolean id() default false; 
    
    /** 
     * 字段名称 
     * @return 
     */  
    String name() default "default_name";  
    
    /** 
     * 是否可编辑 
     * @return 
     */  
    boolean editable() default true;  
    
    /** 
     * 是否在列表中显示 
     * @return 
     */  
    boolean summary() default true;  
    
    /** 
     * 字段描述 
     * @return 
     */  
    String description() default ""; 
    
    /** 
     * 排序字段 
     * @return 
     */  
    int order() default 0;  

}
