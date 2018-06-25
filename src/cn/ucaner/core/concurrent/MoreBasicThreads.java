package cn.ucaner.core.concurrent;

/**
* @Package：cn.ucaner.core.concurrent   
* @ClassName：MoreBasicThreads   
* @Description：   <p> MoreBasicThreads </p>
* @Author： -    
* @CreatTime：2018年6月12日 下午3:48:30   
* @Modify By：   
* @ModifyTime：  2018年6月12日
* @Modify marker：   
* @version    V1.0
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
