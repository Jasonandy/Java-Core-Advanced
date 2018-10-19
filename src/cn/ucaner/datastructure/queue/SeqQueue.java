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

import java.util.Arrays;

/**
* @Package：cn.ucaner.datastructure.queue   
* @ClassName：SeqQueue   
* @Description：   <p> 基于数组的队列实现  </p>
* @Author： - Jason   
* @CreatTime：2018年10月19日 下午3:54:37   
* @Modify By：   
* @ModifyTime：  2018年10月19日
* @Modify marker：   
* @version    V1.0
 */
public class SeqQueue<E> {

	
	/**  队列的存储结构 */      
	private Object[] queue;         
	private int size;
	private int maxSize;    // 最大容量
	
	public SeqQueue(int maxSize){
		this.maxSize = maxSize;
		queue = new Object[maxSize];
	}
	
	  
	/**
	 * @Description: 添加元素到队尾
	 * @param data 
	 * @Autor: Jason
	 */
	public void put(E data){
		if(!isFull()){
			queue[size] = data;
			size ++;
		}
	}
	
	  
	/**
	 * @Description: 删除队头并返回队头元素的值
	 * @return E
	 * @Autor: Jason
	 */
	public E pop(){
		if (!isEmpty()) {
			E temp = (E) queue[0];
			for (int i = 0; i < size - 1; i++) {
				queue[i] = queue[i+1];
			}
			queue[size-1] = null;
			size--;
			return temp;
		}
		return null;
	}
	
	/**
	 * @Description: 返回队头元素
	 * @return E
	 * @Autor: Jason
	 */
	public E peek(){
		if (!isEmpty()) {
			return (E) queue[0];
		}
		return null;
	}
	
	  
	/**
	 * @Description: 队列是否已满
	 * @return boolean
	 * @Autor: Jason
	 */
	public boolean isFull(){
		return size == maxSize;
	}
	
	/**
	 * @Description: 队列是否为空
	 * @return boolean
	 * @Autor: Jason
	 */
	public boolean isEmpty(){
		return size == 0;
	}
	
	  
	/**
	 * @Description:  队列的大小
	 * @return int
	 * @Autor: Jason
	 */
	public int size(){
		return size;
	}

	@Override
	public String toString() {
		return Arrays.toString(queue);
	}
}
