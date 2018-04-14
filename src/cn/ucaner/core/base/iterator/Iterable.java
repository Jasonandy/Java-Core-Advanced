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

/*
 * Iterable接口实现后的功能是“返回”一个迭代器,我们常用的实现了该接口的子接口有: Collection, Deque, List, Queue, Set 等
 * iterator()方法返回一个标准的Iterator实现
 * 实现这个接口允许对象成为 For each 语句的目标。
 * 就可以通过For each语法遍历你的底层序列。
 * 
 * Iterable接口包含一个能够产生Iterator的iterator()方法，并且Iterable接口被foreach用来在序列中移动。
 * 因此如果创建了任何实现Iterable接口的类，都可以将它用于foreach语句中。
 * 
 */
public interface Iterable<T> {

	Iterator<T> iterator();
	
}
