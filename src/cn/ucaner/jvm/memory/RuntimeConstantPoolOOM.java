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
* @ClassName：RuntimeConstantPoolOOM   
* @Description：   <p> 运行时常量池导致的内存溢出异常
* VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
* 这两个配置项在 JDK 1.8 已经不支持了
* </p>
* @Author： - wubin   
* @CreatTime：2018年5月22日 上午9:26:02   
* @Modify By：   
* @ModifyTime：  2018年5月22日
* @Modify marker：   
* @version    V1.0
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {

        testEqual();

        //使用 List 保持着常量引用,避免被 Full GC 回收常量池行为
        List<String> list = new ArrayList<>();

        //10MB 的 PermSize 在 integer 范围内足够产生 OOM 了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    /**
     * JDK 1.8
     * true
     * false
     * intern()不会再复制实例,只是在常量池中记录首次出现的实例引用
     */
    private static void testEqual(){
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);// true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);// false
    }
}



/*
 * true
 * false
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
 */