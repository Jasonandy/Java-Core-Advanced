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
 * @ClassName：ColorImpl   
 * @Description：   <p> ColorImpl 实现接口  </br> 所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类。  </p>
 * @Author： - DaoDou   
 * @Modify By：   
 * @Modify marker：   
 * @version    V1.0
 */


public enum  ColrImpl implements Behaviour{
	
	RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);  
    // 成员变量  
    private String name; 
    
    private int index;  
    // 构造方法  
    private ColrImpl(String name, int index) {  
        this.name = name;  
        this.index = index;  
    }  

	@Override
	public void print() {
		System.out.println(this.index+":"+this.name); 
	}

	@Override
	public String getInfo() {
		return this.name;
	}
	
	public static void main(String[] args) {
		ColrImpl.RED.print();
		System.out.println(ColrImpl.RED.getInfo());
		
		//Output
		//1:红色
		//红色
	}
	

}

interface Behaviour {  
    void print();  
    String getInfo();  
}


