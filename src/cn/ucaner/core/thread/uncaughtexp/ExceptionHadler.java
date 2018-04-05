package cn.ucaner.core.thread.uncaughtexp;

import java.lang.Thread.UncaughtExceptionHandler;

/**
* @Package：cn.ucaner.core.thread.uncaughtexp   
* @ClassName：ExceptionHadler   
* @Description：   <p>处理运行时异常的类</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:18:46   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class ExceptionHadler implements UncaughtExceptionHandler{
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.printf("An exception has been captured\n");
        System.out.printf("Thread: %s\n",t.getId());
        System.out.printf("Exception: %s: %s\n",e.getClass().getName(),e.getMessage());
        System.out.printf("Stack Trace: \n");
        e.printStackTrace(System.out);
        System.out.printf("Thread status: %s\n",t.getState());
    }
}
