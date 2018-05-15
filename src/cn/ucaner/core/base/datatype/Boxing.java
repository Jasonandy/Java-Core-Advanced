package cn.ucaner.core.base.datatype;

/**
* @Package：cn.ucaner.core.base.datatype   
* @ClassName：Boxing   
* @Description：   <p> 主要是考装箱和拆箱</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 上午10:55:49   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class Boxing {
	
    @SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);//true                自动装箱,缓存
        System.out.println(e == f);//false               自动装箱,未缓存
        System.out.println(c == (a + b));//true
        System.out.println(c.equals(a + b));//true       调用 equals(),比较的是值,而不是对象地址
        System.out.println(g == (a + b));//true
        System.out.println(g.equals(a + b));//false
        System.out.println(new Integer(2) == new Integer(2));//false   比较的是对象地址

    }
}

/*
输出：               原因:
true                自动装箱,缓存
false               自动装箱,未缓存
true
true                调用 equals(),比较的是值,而不是对象地址
true
false
false               比较的是对象地址

 */