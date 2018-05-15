package cn.ucaner.core.base.datatype;

/**
* @Package：cn.ucaner.core.base.datatype   
* @ClassName：NumberEquation   
* @Description：   <p> 包装类的“==”运算在不遇到算术运算的情况下不会自动拆箱 </br>包装类的equals()方法不处理数据转型 </p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 上午10:56:33   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class NumberEquation {
	
    public static void main(String[] args) {
        Integer i = 42;
        Long l = 42l;
        Double d = 42.0;

        System.out.println(i.equals(d)); // false
        System.out.println(d.equals(l)); // false
        System.out.println(i.equals(l)); // false
        System.out.println(l.equals(42L)); // true
    }
}

// (i == l),(i == d),(l == d)会出现编译错误