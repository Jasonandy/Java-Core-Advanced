/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.datastructure.list;

/**
 * 
* @Package：cn.ucaner.datastructure.list   
* @ClassName：Node   
* @Description：   <p> 结点类  - 链表的基本元素 </p>
* @Author： -    
* @CreatTime：2018年6月8日 上午11:01:11   
* @Modify By：   
* @ModifyTime：  2018年6月8日
* @Modify marker：   
* @version    V1.0
 */
public class Node<T> {
	 
	/**
	 * 包可见性
	 */
	Node<T> next;
	
	/**
	 * 节点数据
	 */
	T data;

	
	/**
	* Node.         构造函数   构造一个新节点
	* @param data   新元素数据
	* @param next   新元素与链表结合节点
	 */
	public Node(T data) { 
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
}
