/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.annotation.example;

/**     
 * @Package：cn.ucaner.core.annotation.example   
 * @ClassName：Test   
 * @Description：   <p> Test  @Override、@Deprecated、@SuppressWarnings 都属于编译时注解 | @Autowired 自动注入的这样一种注解就属于运行时注解  </p>
 * @Author： - Jason   
 * @CreatTime：2018年4月19日 下午3:36:28   
 * @Modify By：   
 * @ModifyTime：  2018年4月19日
 * @Modify marker：   
 * @version    V1.0
 */
public class Test {
	
	/**
	 * 注解不同时期的作用
	 * @Description: 源码注解→编译时注解→运行时注解
	 * @param args void
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	@SuppressWarnings("deprecation")//忽略了deprecation这样的一个警告
	public static void main(String[] args) {
		
		Child child = new Child();
		child.work();
	}

}
