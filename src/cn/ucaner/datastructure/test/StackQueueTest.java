package cn.ucaner.datastructure.test;

import cn.ucaner.datastructure.queue.StackQueue;

/**
* @Package：cn.ucaner.datastructure.test   
* @ClassName：StackQueueTest   
* @Description：   <p> stackQueue  栈队列  </p>
* @Author： - Jason   
* @CreatTime：2018年6月8日 上午10:18:05   
* @Modify By：   
* @ModifyTime：  2018年6月8日
* @Modify marker：   
* @version    V1.0
 */
public class StackQueueTest {
	
	
	public static void main(String[] args) {
		
		StackQueue<Integer> queue = new StackQueue<Integer>();
		queue.put(1);
		queue.put(3);
		queue.put(5);
		queue.put(2);
		queue.put(8);
		queue.put(6);
		System.out.println(queue);
		System.out.println("\n------------------\n");
		
		queue.pop();
		System.out.println(queue);
		System.out.println("\n------------------\n");
		
		queue.put(4);
		System.out.println(queue);
		System.out.println("\n------------------\n");
	}
}
