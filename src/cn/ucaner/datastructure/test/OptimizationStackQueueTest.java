package cn.ucaner.datastructure.test;

import cn.ucaner.datastructure.queue.OptimizationStackQueue;

/**
* @Package：cn.ucaner.datastructure.test   
* @ClassName：OptimizationStackQueueTest   
* @Description：   <p> OptimizationStackQueueTest </p>
* @Author： -    
* @CreatTime：2018年6月8日 上午10:21:15   
* @Modify By：   
* @ModifyTime：  2018年6月8日
* @Modify marker：   
* @version    V1.0
 */
public class OptimizationStackQueueTest {
	
	public static void main(String[] args) {
		OptimizationStackQueue<Integer> queue = new OptimizationStackQueue<Integer>();
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
		queue.put(5);
		System.out.println(queue);
		System.out.println("\n------------------\n");
	}
}
