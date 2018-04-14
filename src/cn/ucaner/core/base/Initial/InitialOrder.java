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
 * @ClassName：InitialOrder   
 * @Description：   <p> class 类的初始化顺序 </p>
 * @Author： - Jason   
 * @ModifyTime：  2018年4月14日
 * @version    V1.0
 */
public class InitialOrder {

	private static String staticField = "Static Field Initial 静态变量1";

    private String field = "Field Initial 变量2 ";

    /**
     * 静态初始化块
     */
    static {
        System.out.println(staticField);
        System.out.println("Static Patch Initial 静态初始化块3 ");
    }

    /**
     * 初始化块
     */
    {
        System.out.println(field);
        System.out.println("Field Patch Initial 初始化块4");
    }

    
    public InitialOrder() {
        System.out.println("Structure Initial 构造器5");
    }

    /**
     * @Description: Just for test by Jason
     * @Autor: Jason - jasonandy@hotmail.com
     */
    public static void main(String[] argc) {
        new InitialOrder();
    }
    
}
//Output
//Static Field Initial 静态变量1
//Static Patch Initial 静态初始化块3 
//Field Initial 变量2 
//Field Patch Initial 初始化块4
//Structure Initial 构造器5
