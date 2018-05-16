package cn.ucaner.core.concurrent;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：CountDownLatchDemo   
* @Description：   <p> CountDownLatchDemo </p>
* @Author： -    
* @CreatTime：2018年5月16日 下午6:14:49   
* @Modify By：   
* @ModifyTime：  2018年5月16日
* @Modify marker：   
* @version    V1.0
 */
public class CountDownLatchDemo {
	
	
    static final int SIZE = 10;

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool();
        // All must share a single CountDownLatch object:
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++)
            exec.execute(new WaitingTask(latch));
        for (int i = 0; i < SIZE; i++)
            exec.execute(new TaskPortion(latch));
        System.out.println("Launched all tasks");
        exec.shutdown(); // Quit when all tasks complete
    }
}

// Performs some portion of a task:
class TaskPortion implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;

    TaskPortion(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            doWork();
            latch.countDown();
            latch.await();
            System.out.println(this + " TaskPortion after await");
        } catch (InterruptedException ex) {
            // Acceptable way to exit
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println(this + "completed");
    }

    public String toString() {
        return String.format("%1$-3d ", id);
    }
}

// Waits on the CountDownLatch:
class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    WaitingTask(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException ex) {
            System.out.println(this + " interrupted");
        }
    }

    public String toString() {
        return String.format("WaitingTask %1$-3d ", id);
    }
}

//Outputs
//Launched all tasks
//7   completed
//9   completed
//5   completed
//8   completed
//1   completed
//2   completed
//6   completed
//4   completed
//0   completed
//3   completed
//3    TaskPortion after await
//Latch barrier passed for WaitingTask 0   
//Latch barrier passed for WaitingTask 1   
//Latch barrier passed for WaitingTask 2   
//Latch barrier passed for WaitingTask 3   
//Latch barrier passed for WaitingTask 4   
//Latch barrier passed for WaitingTask 5   
//Latch barrier passed for WaitingTask 7   
//Latch barrier passed for WaitingTask 6   
//Latch barrier passed for WaitingTask 8   
//Latch barrier passed for WaitingTask 9   
//7    TaskPortion after await
//9    TaskPortion after await
//8    TaskPortion after await
//1    TaskPortion after await
//5    TaskPortion after await
//2    TaskPortion after await
//6    TaskPortion after await
//0    TaskPortion after await
//4    TaskPortion after await
