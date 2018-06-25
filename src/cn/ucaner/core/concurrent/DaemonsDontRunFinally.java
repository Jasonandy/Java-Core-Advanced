package cn.ucaner.core.concurrent;

import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：DaemonsDontRunFinally   
* @Description：   <p> Daemon threads don't run the finally clause output:"Starting ADaemon" or nothing </p>
* @Author： - wubin   
* @CreatTime：2018年6月12日 下午3:50:19   
* @Modify By：   
* @ModifyTime：  2018年6月12日
* @Modify marker：   
* @version    V1.0
 */
public class DaemonsDontRunFinally {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}

class ADaemon implements Runnable {
    public void run() {
        try {
            System.out.println("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via InterruptedException");
        } finally {
            System.out.println("This should always run?");
        }
    }
}
/* Output:
Starting ADaemon

or

output nothing
*///:~
