package cn.ucaner.core.concurrent;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：PipedIO   
* @Description：   <p> PipedIO </p>
* @Author： -    
* @CreatTime：2018年6月12日 下午3:47:31   
* @Modify By：   
* @ModifyTime：  2018年6月12日
* @Modify marker：   
* @version    V1.0
 */
public class PipedIO {
	
    public static void main(String[] args) throws Exception {
        Sender sender = new Sender();
        Receiver receiver = new Receiver(sender);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(sender);
        exec.execute(receiver);
        TimeUnit.SECONDS.sleep(4);
        exec.shutdownNow();
    }
}

class Sender implements Runnable {
    private Random rand = new Random(47);
    private PipedWriter out = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return out;
    }

    public void run() {
        try {
            while (true)
                for (char c = 'A'; c <= 'z'; c++) {
                    out.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
        } catch (IOException e) {
            System.out.println(e + " Sender write exception");
        } catch (InterruptedException e) {
            System.out.println(e + " Sender sleep interrupted");
        }
    }
}

class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        in = new PipedReader(sender.getPipedWriter());
    }

    public void run() {
        try {
            while (true) {
                // Blocks until characters are there:
                System.out.print("Read: " + (char) in.read() + ", ");
            }
        } catch (IOException e) {
            System.out.println(e + " Receiver read exception");
        }
    }
}

/* Output: (65% match)
Read: A, Read: B, Read: C, Read: D, Read: E, Read: F, Read: G, Read: H, Read: I, Read: J, Read: K, Read: L, Read: M, java.lang.InterruptedException: sleep interrupted Sender sleep interrupted
java.io.InterruptedIOException Receiver read exception
*///:~
