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
package cn.ucaner.core.absinf;

/**     
* @Package：cn.ucaner.core.absinf   
* @ClassName：AbsInfDemo   
* @Description：   <p> AbsInfDemo - 接口和抽象类的学习 {@link https://www.cnblogs.com/danbing/p/5035189.html}
* 
* 最近学习Spring的源码 仿Spring实现
* 里面用到大量的抽象类和接口 概念比较模糊 故整理出来学习
* 
* 一.抽象类
* 	1、抽象类
* 		1).包含一个抽象方法的类就是抽象类
* 	2、抽象方法
* 		1).声明而未被实现的方法，抽象方法必须使用abstract关键词字声明
* 	3、抽象类被子类继承，子类（如果不是抽象类）必须重写抽象类中的所有抽象方法 
* 	4、抽象类不能被直接实例化，要通过其子类进行实例化
* 	5、只要包含一个抽象方法的抽象类，该方法必须要定义成抽象类，不管是否还包含有其他方法
* 	6、子类中的抽象方法不能与父类的抽象方法同名
* 	7、abstract不能与final并列修饰同一个类
* 	8、abstract 不能与private、static、final或native并列修饰同一个方法
* 
* 
* 
* 
* https://www.cnblogs.com/GreatKing/p/6077912.html
* 什么时候使用接口，什么时候使用抽象类?
* 	1.如果你想拥有一些方法，并且这些方法有默认实现，那么久使用抽象类
* 	2.如果你想实现多继承，那么就是用接口吧，java不支持多继承，但是可以实现多个接口
* 	3.接口主要用于模块与模块之间的调用
* 	4.抽象类主要用于当做基础类使用，即基类
* 
* consider: {@code cn.ucaner.alpaca.framework.utils.tools} 
* 
* @see https://github.com/Jasonandy/alpaca 可以参考alpaca common里的tools里面的代码规范.
* 
* </p>
* @Author： - Jason   
* @CreatTime：2018年6月2日 上午11:02:18   
* @Modify By：   
* @ModifyTime：  2018年6月2日
* @Modify marker：   
* @version    V1.0
*/
public class AbsInf {

}
