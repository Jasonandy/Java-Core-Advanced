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
* @ClassName：ChildInitialOrder   
* @Description：   <p> ChildInitialOrder 初始化顺序</p>
* @Author： - Jason   
* @CreatTime：2018年10月18日 下午9:59:25   
* @Modify By：   
* @ModifyTime：  2018年10月18日
* @Modify marker：   
* @version    V1.0
 */
public class ChildInitialOrder extends ParentInitialOrder{
	
	private static String staticField = "Child Static Field Initial - c1";

    private String field = "Child Field Initial -c2";

    static {
        System.out.println(staticField);
        System.out.println("Child Static Patch Initial -c3");
    }

    {
        System.out.println(field);
        System.out.println("Child Field Patch Initial -c4");
    }

    public ChildInitialOrder() {
        System.out.println("Child Structure Initial -c5");
    }

    public static void main(String argv[]) {
        new ChildInitialOrder();
    }
    

}
//Output
//Parent Static Field Initial -p1
//Parent Static Patch Initial -p3
//Child Static Field Initial - c1
//Child Static Patch Initial -c3
//Parent Field Initial -p2
//Parent Field Patch Initial -p4
//Parent Structure Initial -p5
//Child Field Initial -c2
//Child Field Patch Initial -c4
//Child Structure Initial -c5
