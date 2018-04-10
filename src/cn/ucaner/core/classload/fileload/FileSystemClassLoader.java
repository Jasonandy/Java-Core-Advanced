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
package cn.ucaner.core.classload.fileload;  
  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.ByteArrayOutputStream;  

/**
* @Package：cn.ucaner.core.classload.fileload   
* @ClassName：FileSystemClassLoader   
* @Description：   <p> 文件系统类加载器  </p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:42:47   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class FileSystemClassLoader extends ClassLoader {  
  
    private String rootDir;  
  
    public FileSystemClassLoader(String rootDir) {  
        this.rootDir = rootDir;  
    }  
  
    // 获取类的字节码  
    @Override  
    protected Class<?> findClass(String name) throws ClassNotFoundException {  
        byte[] classData = getClassData(name);  // 获取类的字节数组  
        if (classData == null) {  
            throw new ClassNotFoundException();  
        } else {  
            return defineClass(name, classData, 0, classData.length);  
        }  
    }  
  
    private byte[] getClassData(String className) {  
        // 读取类文件的字节  
        String path = classNameToPath(className);  
        try {  
            InputStream ins = new FileInputStream(path);  
            ByteArrayOutputStream baos = new ByteArrayOutputStream();  
            int bufferSize = 4096;  
            byte[] buffer = new byte[bufferSize];  
            int bytesNumRead = 0;  
            // 读取类文件的字节码  
            while ((bytesNumRead = ins.read(buffer)) != -1) {  
                baos.write(buffer, 0, bytesNumRead);  
            }  
            return baos.toByteArray();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
  
    private String classNameToPath(String className) {  
        // 得到类文件的完全路径  
        return rootDir + File.separatorChar  
                + className.replace('.', File.separatorChar) + ".class";  
    }  
}  