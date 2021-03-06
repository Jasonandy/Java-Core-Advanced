package cn.ucaner.datastructure.test;

import java.util.Comparator;

import cn.ucaner.datastructure.stack.LinkedStack;

/**
* @Package：cn.ucaner.datastructure.test   
* @ClassName：LinkedStackTest   
* @Description：   <p> LinkedStackTest </p>
* @Author： -    
* @CreatTime：2018年6月8日 上午10:43:02   
* @Modify By：   
* @ModifyTime：  2018年6月8日
* @Modify marker：   
* @version    V1.0
 */
public class LinkedStackTest {
	
	public static void main(String[] args) throws Exception {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		Comparator<Integer> c = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1 > o2)
					return 1;
				else if(o1 < o2)
					return -1;
				else
					return 0;
			}
		};
		
		stack.push(7,c);
		stack.push(6,c);
		stack.push(8,c);
		stack.push(5,c);
		stack.push(3,c);
		
		System.out.println("原栈(最左边元素是栈顶元素)：");
		stack.print();
		System.out.println();
		
		System.out.println("弹出栈顶元素：");
		System.out.println(stack.peek());
		System.out.println("栈中的最小值：" + stack.min());
		System.out.println();

		System.out.println("弹出并删除栈顶元素后的链表：");
		stack.pop(c);
		stack.print();
		System.out.println("栈中的最小值：" + stack.min());
		System.out.println();
	}
}
