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

import java.io.IOException;
import java.io.InputStream;

/**
* @Package：cn.ucaner.jvm.classloading   
* @ClassName：ClassLoaderTest   
* @Description：   <p> 不同的类加载器对 instanceof 关键字运算结果的影响</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:47:58   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class ClassLoaderTest {
	
    public static void main(String[] args) throws Exception {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("cn.ucaner.jvm.classloading.ClassLoaderTest").newInstance();
        System.out.println(obj.getClass());
    }
}

//Outputs
//class cn.ucaner.jvm.classloading.ClassLoaderTest