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
* @Description：   <p> 类加载器学习
* https://blog.csdn.net/eff666/article/details/52203406
* 
* 一个java文件从被加载到被卸载这个生命过程，总共要经历5个阶段，JVM将类加载过程分为：
* 加载->链接（验证+准备+解析）->初始化（使用前的准备）->使用->卸载 
* 
* （1）加载 
　　首先通过一个类的全限定名来获取此类的二进制字节流；其次将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构；
	最后在java堆中生成一个代表这个类的Class对象，作为方法区这些数据的访问入口。总的来说就是查找并加载类的二进制数据。 
（2）链接： 
　　验证：确保被加载类的正确性； 
　　准备：为类的静态变量分配内存，并将其初始化为默认值； 
　　解析：把类中的符号引用转换为直接引用； 
（3）为类的静态变量赋予正确的初始值 

3、类的初始化 
（1）类什么时候才被初始化 
　　1）创建类的实例，也就是new一个对象 
　　2）访问某个类或接口的静态变量，或者对该静态变量赋值 
　　3）调用类的静态方法 
　　4）反射Class.forName("cn.ucaner.core.classload.LoaderTest")
　　5）初始化一个类的子类（会首先初始化子类的父类） 
　　6）JVM启动时标明的启动类，即文件名和类名相同的那个类 
（2）类的初始化顺序 
　　1）如果这个类还没有被加载和链接，那先进行加载和链接 
　　2）假如这个类存在直接父类，并且这个类还没有被初始化（注意：在一个类加载器中，类只能初始化一次），那就初始化直接的父类（不适用于接口） 
　　3）加入类中存在初始化语句（如static变量和static块），那就依次执行这些初始化语句。 
　　4）总的来说，初始化顺序依次是：（静态变量、静态初始化块）–>（变量、初始化块）–> 构造器；如果有父类，则顺序是：父类static方法 –> 子类static方法 –> 父类构造方法- -> 子类构造方法 
4、类的加载 
　　类的加载指的是将类的.class文件中的二进制数据读入到内存中，将其放在运行时数据区的方法区内，然后在堆区创建一个这个类的java.lang.Class对象，用来封装类在方法区类的对象。如： 
	
	类的加载的最终产品是位于堆区中的Class对象。Class对象封装了类在方法区内的数据结构，并且向Java程序员提供了访问方法区内的数据结构的接口。加载类的方式有以下几种： 
　　1）从本地系统直接加载 
　　2）通过网络下载.class文件 
　　3）从zip，jar等归档文件中加载.class文件 
　　4）从专有数据库中提取.class文件 
　　5）将Java源文件动态编译为.class文件（服务器） 

5、加载器 
　　JVM的类加载是通过ClassLoader及其子类来完成的，类的层次关系和加载顺序可以由下图来描述： 

（1）加载器介绍 
1）BootstrapClassLoader（启动类加载器）   - 父加载器  -Top 
　　负责加载$JAVA_HOME中jre/lib/rt.jar里所有的class，加载System.getProperty("sun.boot.class.path")所指定的路径或jar。 
2）ExtensionClassLoader（标准扩展类加载器） 
　　负责加载java平台中扩展功能的一些jar包，包括$JAVA_HOME中jre/lib/*.jar或-Djava.ext.dirs指定目录下的jar包。载System.getProperty(“java.ext.dirs”)所指定的路径或jar。 
3）AppClassLoader（系统类加载器） 
　　负责记载classpath中指定的jar包及目录中class 
4）CustomClassLoader（自定义加载器） 
　　属于应用程序根据自身需要自定义的ClassLoader，如tomcat、jboss都会根据j2ee规范自行实现。

（2）类加载器的顺序 
1）加载过程中会先检查类是否被已加载，[检查顺序][自底向上]，从Custom ClassLoader到BootStrap ClassLoader逐层检查，只要某个classloader已加载就视为已加载此类，保证此类只所有ClassLoader加载一次。
而[加载]的顺序是[自顶向下]，也就是由上层来逐层尝试加载此类。 
2）在加载类时，每个类加载器会将加载任务上交给其父，如果其父找不到，再由自己去加载。 

3）Bootstrap Loader（启动类加载器）是最顶级的类加载器了，其父加载器为null。
* </p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:44:12   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class LoaderTest {  
  
    @SuppressWarnings("static-access")
	public static void main(String[] args) {  
        try {  
            System.out.println(ClassLoader.getSystemClassLoader());  
            System.out.println(ClassLoader.getSystemClassLoader().getParent());  
            System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
            URL systemResource1 = ClassLoader.getSystemClassLoader().getSystemResource("spring-mvc.xml");
            URL systemResource2 = ClassLoader.getSystemClassLoader().getSystemResource("classpath:spring-mvc.xml");
            System.out.println(systemResource1);
            System.out.println(systemResource2);
            
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}  
//Outputs 
//sun.misc.Launcher$AppClassLoader@2a139a55
//sun.misc.Launcher$ExtClassLoader@7852e922
//null
//null