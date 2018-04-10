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
    }
}
