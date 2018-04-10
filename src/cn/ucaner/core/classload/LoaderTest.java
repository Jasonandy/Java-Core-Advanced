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
package cn.ucaner.core.classload;

import java.net.URL;

/**
* @Package：cn.ucaner.core.classload   
* @ClassName：LoaderTest   
* @Description：   <p> 类加载器学习</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:44:12   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class LoaderTest {  
  
    public static void main(String[] args) {  
        try {  
            System.out.println(ClassLoader.getSystemClassLoader());  
            System.out.println(ClassLoader.getSystemClassLoader().getParent());  
            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
            URL systemResource = ClassLoader.getSystemClassLoader().getSystemResource("spring-mvc.xml");
            System.out.println(systemResource);
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  