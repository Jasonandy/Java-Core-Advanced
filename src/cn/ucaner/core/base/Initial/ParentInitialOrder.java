/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.base.Initial;

/**
* @Package：cn.ucaner.core.base.Initial   
* @ClassName：ParentInitialOrder   
* @Description：   <p> ParentInitialOrder 初始化顺序</p>
* @Author： - Jason   
* @CreatTime：2018年10月18日 下午9:58:22   
* @Modify By：   
* @ModifyTime：  2018年10月18日
* @Modify marker：   
* @version    V1.0
 */
public class ParentInitialOrder {
	
	private static String staticField = "Parent Static Field Initial -p1";

    private String field = "Parent Field Initial -p2";

    static {
        System.out.println(staticField);
        System.out.println("Parent Static Patch Initial -p3");
    }

    {
        System.out.println(field);
        System.out.println("Parent Field Patch Initial -p4");
    }

    public ParentInitialOrder() {
        System.out.println("Parent Structure Initial -p5");
    }
}
