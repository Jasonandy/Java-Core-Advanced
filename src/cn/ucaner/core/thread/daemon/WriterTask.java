package cn.ucaner.core.thread.daemon;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.thread.daemon   
* @ClassName：WriterTask   
* @Description：   <p> 写事件到一个队列</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:21:52   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class WriterTask implements Runnable {
    private Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 1; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date());
            event.setEvent(String.format("The thread  %s has generated an event",Thread.currentThread().getId()));
            deque.addFirst(event);

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
