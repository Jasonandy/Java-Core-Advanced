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
* @ClassName：ReferenceCountingGC   
* @Description：   <p> 引用计数算法缺陷</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午9:57:43   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class ReferenceCountingGC {
	
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 占点内存,以便  GC 日志观看
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        testGC();
    }

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
