package cn.ucaner.core.thread.join;

/**
* @Package：cn.ucaner.core.thread.join   
* @ClassName：JoinTest   
* @Description：   <p> JoinTest</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:21:03   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DSLoader());
        Thread t2 = new Thread(new NetLoader());

        t1.start();
        t2.start();

        //可以注释其中一个加深理解
        t1.join();
        //t2.join();

        System.out.println("ending all");
    }
}
