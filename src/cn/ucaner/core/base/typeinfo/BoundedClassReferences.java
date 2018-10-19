/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.base.typeinfo;

/**
* @Package：cn.ucaner.core.base.typeinfo   
* @ClassName：BoundedClassReferences   
* @Description：   <p> BoundedClassReferences </p>
* @Author： - Jason   
* @CreatTime：2018年10月18日 下午10:02:43   
* @Modify By：   
* @ModifyTime：  2018年10月18日
* @Modify marker：   
* @version    V1.0
 */
public class BoundedClassReferences {
	
    public static void main(String[] args) {
        Class<? extends Number> bounded = int.class;
        bounded = double.class;
        bounded = Number.class;
        // Or anything else derived from Number.
    }
} ///:~
