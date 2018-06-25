package cn.ucaner.datastructure.test;

import cn.ucaner.datastructure.queue.SeqQueue;

/**
* @Package：cn.ucaner.datastructure.test   
* @ClassName：SeqQueueTest   
* @Description：   <p> SeqQueueTest </p>
* @Author： -    
* @CreatTime：2018年6月8日 上午10:21:04   
* @Modify By：   
* @ModifyTime：  2018年6月8日
* @Modify marker：   
* @version    V1.0
 */
public class SeqQueueTest {

	public static void main(String[] args) {

		SeqQueue<Integer> queue = new SeqQueue<Integer>(5);
		queue.put(1);
		queue.put(2);
		queue.put(3);
		queue.put(4);
		queue.put(3);
		queue.put(4);
		System.out.println(queue);
		System.out.println("\n----------------\n");

		queue.pop();
		System.out.println(queue);
		System.out.println("\n----------------\n");

		System.out.println(queue.peek());
		System.out.println(queue);
	}
}
