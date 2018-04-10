/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.jvm.gc;

/**
* @Package：cn.ucaner.jvm.gc   
* @ClassName：FinalizeEscapeGC   
* @Description：   <p> 对象可以在被 GC 时自我拯救 </br> 这种自救的机会只有一次,因为一个对象的 finalize() 方法最多只会被系统自动调用一次</p>
* @Author： - DaoDou   
* @CreatTime：2018年4月10日 下午9:57:18   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizeEscapeGC();

        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        // finalize 优先级低,暂停 0.5 秒以等待
        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i ma dead :(");
        }

        //与上面完全相同,缺失败
        SAVE_HOOK = null;
        System.gc();

        // finalize 优先级低,暂停 0.5 秒以等待
        Thread.sleep(500);

        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no, i ma dead :(");
        }

    }
}

/*
finalize method executed
yes, i am still alive :)
no, i ma dead :(
 */