/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.datastructure.queue;

import cn.ucaner.datastructure.stack.LinkedStack;
  
/**
* @Package：cn.ucaner.datastructure.queue   
* @ClassName：StackQueue   
* @Description：   <p>  使用两个栈模拟一个队列     - 其中一个栈作存储空间，另一个栈作临时缓冲区 </p>
* @Author： - Jason   
* @CreatTime：2018年10月19日 下午3:56:06   
* @Modify By：   
* @ModifyTime：  2018年10月19日
* @Modify marker：   
* @version    V1.0
 */
public class StackQueue<E> {

	private LinkedStack<E> stack1;    // 存储空间
	private LinkedStack<E> stack2;  //临时缓冲区

	public StackQueue() {
		stack1 = new LinkedStack<E>();
		stack2 = new LinkedStack<E>();
	}

	  
	/**     
	 * @description 添加元素到队尾。先检查stack2是否为空：
	 * 				若为空，则直接对stack1执行压栈操作
	 * 				否则，先将stack2中的元素倒回stack1，再对stack1执行压栈操作
	 * @param e     
	 */
	public void put(E e) {
		if (!stack2.isEmpty()) {
			while (stack2.size() > 0) {
				stack1.push(stack2.pop().getData());
			}
		}
		stack1.push(e);
	}

	  
	/**     
	 * @description 删除队头并返回队头元素的值。先检查stack2是否为空：
	 * 				若为空，先将stack1中的size-1个元素倒回stack2，再对stack1中栈底元素执行弹栈操作
	 * 				否则，则直接对stack2执行弹栈操作
	 * @return     
	 */
	public E pop() {
		if (stack2.isEmpty()) {
			if (!stack1.isEmpty()) {
				while (stack1.size() > 1) {
					stack2.push(stack1.pop().getData());
				}
				return stack1.pop().getData();
			}
			return null;
		} else {
			return stack2.pop().getData();
		}
	}

	@Override
	public String toString() {
		if (!stack1.isEmpty()) {
			return new StringBuilder(stack1.toString()).reverse().toString();
		}
		return stack2.toString();
	}
}
