package cn.ucaner.core.thread.uncaughtexp;

/**
* @Package：cn.ucaner.core.thread.uncaughtexp   
* @ClassName：UncaughtTest   
* @Description：   <p> 描述:实现异常类Test</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午1:17:43   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class UncaughtTest {
    public static void main(String[] args) {
        UncaughtTask uncaughtTask = new UncaughtTask();
        Thread thread = new Thread(uncaughtTask);
        thread.setUncaughtExceptionHandler(new ExceptionHadler());
        thread.start();
    }
}
