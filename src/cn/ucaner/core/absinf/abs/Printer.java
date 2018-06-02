/**
 * <html>
 * <body>
 *  <P> Copyright JasonInternational Since 1994 https://github.com/Jasonandy/Spring-Core</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年</p>
 *  <p> Created by Jason </p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.absinf.abs;

/**     
* @Package：cn.ucaner.core.absinf   
* @ClassName：Printer   
* @Description：   <p> Printer 打印的抽象类 - 接口是抽象类的形式. 
* https://www.cnblogs.com/beanmoon/archive/2012/12/06/2805221.html
* </p>
* @Author： - Jason   
* @CreatTime：2018年6月2日 上午11:10:08   
* @Modify By：   
* @ModifyTime：  2018年6月2日
* @Modify marker：   
* @version    V1.0
*/
public abstract class Printer {
	
	public void open() {
		System.out.println("Printer Open.");
	}

	public void close() {
		System.out.println("Printer Closed.");
	}
	
	/**
	 * @Description: 抽象方法 - print - 子类必须实现 
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
    abstract void print();
	 
}
