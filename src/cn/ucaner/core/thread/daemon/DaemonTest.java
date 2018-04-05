package cn.ucaner.core.thread.daemon;

import java.util.ArrayDeque;
import java.util.Deque;


/**
* @Package：cn.ucaner.core.thread.daemon   
* @ClassName：DaemonTest   
* @Description：   <p> 知道3个WriteTask线程休眠后,CleanerTask才执行 <br> 从结果中,可以看出队列维持在一定数量当中</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:22:35   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class DaemonTest {
	
    public static void main(String[] args) {
        Deque<Event> deque = new ArrayDeque<>();
        WriterTask writerTask = new WriterTask(deque);
        for (int i = 0; i < 3 ; i++) {
            Thread thread = new Thread(writerTask);
            thread.start();
        }

        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }
}
