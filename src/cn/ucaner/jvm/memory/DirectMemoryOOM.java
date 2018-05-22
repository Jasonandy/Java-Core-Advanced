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

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
* @Package：cn.ucaner.jvm.memory   
* @ClassName：DirectMemoryOOM   
* @Description：   <p> 使用 unsafe 分配本机内存   VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M</p>
* @Author： -    
* @CreatTime：2018年4月10日 下午9:58:31   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class DirectMemoryOOM {
	
	
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
/*
Exception in thread "main" java.lang.OutOfMemoryError
at sun.misc.Unsafe.allocateMemory(Native Method)
at cn.ucaner.jvm.memory.DirectMemoryOOM.main(DirectMemoryOOM.java:27)*/