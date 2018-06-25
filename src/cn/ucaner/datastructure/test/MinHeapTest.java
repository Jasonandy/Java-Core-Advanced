package cn.ucaner.datastructure.test;

import cn.ucaner.datastructure.heap.MinHeap;

/**
* @Package：cn.ucaner.datastructure.test   
* @ClassName：MinHeapTest   
* @Description：   <p> 堆排 </p>
* @Author： - Jason   
* @CreatTime：2018年6月8日 上午10:09:39   
* @Modify By：   
* @ModifyTime：  2018年6月8日
* @Modify marker：   
* @version    V1.0
 */
public class MinHeapTest {
	
	
	public static void main(String[] args) {
		int[] arr = {19, 94, 11, 15, 19, 49, 10, 01};
		MinHeap heap = new MinHeap(arr,20);
		System.out.println("堆：");
		heap.printMinHeap(0);
		System.out.println("\n---------------------------\n");
		System.out.println("向堆中插入元素7后，堆变为：");
		heap.insert(7);
		heap.printMinHeap(0);
		System.out.println("\n---------------------------\n");
		System.out.println("删除堆中末尾元素，堆变为：");
		heap.remove();
		heap.printMinHeap(0);
		System.out.println("\n---------------------------\n");
		System.out.println("堆排序结果为：");
		heap.sort();
	}
}
