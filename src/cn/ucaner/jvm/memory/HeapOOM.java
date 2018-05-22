/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
* @Package：cn.ucaner.jvm.memory   
* @ClassName：HeapOOM   
* @Description：   <p> 
*    Java 堆内存溢出异常测试 
*    VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
*    (限制堆大小为 20 MB)
* </p>
* @Author： -    
* @CreatTime：2018年4月10日 下午10:00:10   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}

/*
java.lang.OutOfMemoryError: Java heap space
Dumping heap to java_pid25599.hprof ...
Heap dump file created [27802397 bytes in 0.106 secs]
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3210)
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at com.brianway.learning.java.jvm.memory.HeapOOM.main(HeapOOM.java:19)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:144)

Process finished with exit code 1
 */