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

public class AnnoDemo {
	
    @FieldMeta(id=true,name="序列号",order=1,description="ID")  
    private int id;  
    
    @FieldMeta(name="姓名",order=3,description="姓名")  
    private String name;  
    
    @FieldMeta(name="年龄",order=2)  
    private int age;  
    
    @FieldMeta(description="描述",order=4)  
    public String desc(){  
        return "java反射获取annotation的测试";  
    }  
    
    public int getId() {  
        return id;  
    }  
    public void setId(int id) {  
        this.id = id;  
    }  
    public String getName() {  
        return name;  
    }  
    public void setName(String name) {  
        this.name = name;  
    }  
    public int getAge() {  
        return age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  

}
