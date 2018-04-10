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


/**
* @Package：cn.ucaner.jvm.memory   
* @ClassName：JavaVMStackSOF   
* @Description：   <p> 虚拟机栈和本地方法栈 OOM 测试 </br>VM Args: -Xss256k </p>
* @Author： - DaoDou   
* @CreatTime：2018年4月10日 下午10:01:24   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();

        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }

}

/*
stack length:18552
Exception in thread "main" java.lang.StackOverflowError
	at cn.ucaner.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:20)
	at cn.ucaner.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:20)
	at cn.ucaner.jvm.memory.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:20)
 */