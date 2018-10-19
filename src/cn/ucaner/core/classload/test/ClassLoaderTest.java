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
package cn.ucaner.core.classload.test;  
  
/**
* @Package：cn.ucaner.core.classload.test   
* @ClassName：ClassLoaderTest   
* @Description：   <p> ClassLoaderTest </p>
* @Author： - Jason   
* @CreatTime：2018年10月19日 下午3:18:23   
* @Modify By：   
* @ModifyTime：  2018年10月19日
* @Modify marker：   
* @version    V1.0
 */
public class ClassLoaderTest {  
  
    public static void main(String[] args) {  
        try {  
        	
            //查看当前系统类路径中包含的路径条目  
            String property = System.getProperty("java.class.path");
            String[] split = property.split(";");
            for (String str : split) {
            	System.out.println(str);  
			}
            
            //调用加载当前类的类加载器（这里即为系统类加载器）加载TestBean  
            Class<?> typeLoaded = Class.forName("cn.ucaner.core.classload.TestBean");  
            
            //查看被加载的TestBean类型是被那个类加载器加载的  
            System.out.println(typeLoaded.getClassLoader());  
            //sun.misc.Launcher$AppClassLoader@2a139a55
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  