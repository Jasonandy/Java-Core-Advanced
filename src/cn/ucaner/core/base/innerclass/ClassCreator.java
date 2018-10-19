/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason https://github.com/Jasonandy/patterns</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.base.innerclass;

/**
* @Package：cn.ucaner.core.base.innerclass   
* @ClassName：ClassCreator   
* @Description：   <p> 内部类的测试类</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 上午10:57:23   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class ClassCreator {
	
    public static void main(String[] args) {
        //在其他类里创建非静态内部类和静态内部类
        EnclosingOne eo = new EnclosingOne();
        EnclosingOne.InsideOne io = eo.new InsideOne();
        EnclosingOne.InsideTwo it = new EnclosingOne.InsideTwo();
        System.out.println(eo);
        System.out.println(io);
        System.out.println(it);
    }

}
//out put
//cn.ucaner.core.base.innerclass.EnclosingOne@15db9742
//cn.ucaner.core.base.innerclass.EnclosingOne$InsideOne@6d06d69c
//cn.ucaner.core.base.innerclass.EnclosingOne$InsideTwo@7852e922
