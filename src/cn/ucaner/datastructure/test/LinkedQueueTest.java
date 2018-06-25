package cn.ucaner.datastructure.test;

import cn.ucaner.datastructure.queue.LinkedQueue;

/**
* @Package：cn.ucaner.datastructure.test   
* @ClassName：LinkedQueueTest   
* @Description：   <p> LinkedQueueTest </p>
* @Author： -    
* @CreatTime：2018年6月8日 上午10:42:47   
* @Modify By：   
* @ModifyTime：  2018年6月8日
* @Modify marker：   
* @version    V1.0
 */
public class LinkedQueueTest {
	
	
	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		queue.put(1);
		queue.put(2);
		queue.put(4);
		queue.put(3);
		queue.put(0);
		System.out.println(queue);
		System.out.println("\n ------------------- \n");

		
		queue.pop();
		System.out.println(queue);
		System.out.println("\n ------------------- \n");
		
		
		System.out.println(queue.peek());
		queue.put(121);
		System.out.println(queue);
		
	}
}
