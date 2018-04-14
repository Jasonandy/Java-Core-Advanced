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
