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


public interface Iterator<E> {

	/**
	 * @Description: 判断是否存在下一个对象元素
	 * @return boolean
	 * @Autor: DaoDou - wub@sun309.com
	 */
	boolean hasNext();
	
	/**
	 * @Description: next element
	 * @return E
	 * @Autor: DaoDou - wub@sun309.com
	 */
	E next();
	
	/**
	 * @Description: remove
	 * @Autor: DaoDou - wub@sun309.com
	 */
	void remove();
}
