package cn.ucaner.core.base.constructor;


/**
* @Package：cn.ucaner.core.base.constructor   
* @ClassName：FatherClass   
* @Description：   <p> FatherClass</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 上午10:54:55   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class FatherClass {
    protected static int count = 10;
    private String name;

    static {
        System.out.println("父类的静态属性count初始化:" + count);
    }

    public FatherClass() {
        System.out.println("执行了父类的无参构造方法");
    }

    public FatherClass(String name) {
        this.name = name;
        System.out.println("执行了父类的构造方法FatherClass(String name) " + name);
    }
}
