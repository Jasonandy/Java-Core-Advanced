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
 * 
* @Package：cn.ucaner.core.base.innerclass   
* @ClassName：EnclosingOne   
* @Description：   <p> EnclosingOne</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 上午10:57:42   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class EnclosingOne {

    public class InsideOne {

    }

    static public class InsideTwo {

    }

    public static void main(String[] args) {
        EnclosingOne eo = new EnclosingOne();
        InsideOne io = eo.new InsideOne();
        InsideTwo it = new InsideTwo();
        System.out.println(eo);
        System.out.println(io);
        System.out.println(it);
    }
}

//out put 
//cn.ucaner.core.base.innerclass.EnclosingOne@15db9742
//cn.ucaner.core.base.innerclass.EnclosingOne$InsideOne@6d06d69c
//cn.ucaner.core.base.innerclass.EnclosingOne$InsideTwo@7852e922
