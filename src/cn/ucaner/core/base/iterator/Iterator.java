/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.base.iterator;

/**
* @Package：cn.ucaner.core.base.iterator   
* @ClassName：Iterator   
* @Description：   <p> Iterator </p>
* @Author： - Jason   
* @CreatTime：2018年10月18日 下午10:01:16   
* @Modify By：   
* @ModifyTime：  2018年10月18日
* @Modify marker：   
* @version    V1.0
 */
public interface Iterator<E> {

	/**
	 * @Description: 判断是否存在下一个对象元素
	 * @return boolean
	 * @Autor: jasonandy@hotmail.com
	 */
	boolean hasNext();
	
	/**
	 * @Description: next element
	 * @return E
	 * @Autor: jasonandy@hotmail.com
	 */
	E next();
	
	/**
	 * @Description: remove
	 * @Autor: jasonandy@hotmail.com
	 */
	void remove();
}
