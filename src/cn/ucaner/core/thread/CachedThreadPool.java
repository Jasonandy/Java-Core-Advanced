package cn.ucaner.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @Package：cn.ucaner.core.thread   
* @ClassName：CachedThreadPool   
* @Description：   <p> 线程池CachedThreadPool的简单使用-启动LiftOff线程{@link LiftOff} </p>
* @Author： - Jeff Lee   
* @CreatTime：2018年4月5日 下午1:16:46   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class CachedThreadPool {
	
    public static void main(String[] args) {
        // 创建新线程的线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0 ; i < 5; i++)
            exec.execute(new LiftOff()); // 由线程池Ececutor决定执行给定的线程。
        // 顺序关闭，执行以前提交的线程，不接受新的线程。
        exec.shutdown();
    }
}
