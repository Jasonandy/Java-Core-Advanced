/**
 * <html>
 * <body>
 *  <P> Copyright 1994 - 2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.eum;

/**     
 * @Package：cn.ucaner.core.eum   
 * @ClassName：ColorMethod   
 * @Description：   <p> 枚举  - 方法 </p>
 * @Author： - Jason   
 * @Modify By：   
 * @Modify marker：   
 * @version    V1.0
 */
public enum ColorMethod {

   //如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。而且 Java 要求必须先定义 enum 实例。
   RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);  
   
   // 成员变量  
    private String name;  
    private int index;  
   
    // 构造方法  
    private ColorMethod(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  
    
    // 普通方法  
    public static String getName(int index) {  
        for (ColorMethod c : ColorMethod.values()) {  
            if (c.getIndex() == index) {  
                return c.name;  
            }  
        }  
        return null;  
    }  
    
    // get set 方法  
    public String getName() {  
        return name;  
    }  
    
    
    public void setName(String name) {  
        this.name = name;  
    }  
    
    public int getIndex() {  
        return index;  
    } 
    
    
    public void setIndex(int index) {  
        this.index = index;  
    }  
    
    
    //覆盖方法    
    @Override  
    public String toString() {  
        return this.index+"_"+this.name;  
    }  
    
    
    /**
     * @Description: Just for Test
     * @param args void
     */
    public static void main(String[] args) {
    	System.out.println(ColorMethod.RED.toString());//1_红色
	}
}
