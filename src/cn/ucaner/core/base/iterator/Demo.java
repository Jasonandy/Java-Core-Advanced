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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 迭代器是一种模式，它可以使得对于序列类型的数据结构的遍历行为与被遍历的对象分离，即我们无需关心该序列的底层结构是什么样子的。
 * 只要拿到这个对象,使用迭代器就可以遍历这个对象的内部.
 * Java提供一个专门的迭代器«interface»Iterator，我们可以对某个序列实现该interface，来提供标准的Java迭代器。
 * Iterator接口实现后的功能是“使用”一个迭代器.
 * 
 * 迭代器（Iterator）模式，又叫做游标模式，它的含义是，提供一种方法访问一个容器对象中各个元素，而又不需暴露该对象的内部细节。
 * (Java的集合框架的集合类，有的时候也称为容器。)
 * 
 * 迭代器是为容器而生，它本质上就是一种遍历的算法。
 * 因为容器的实现千差万别，很多时候不可能知道如何去遍历一个集合对象的元素。
 * Java为我们提供了使用迭代的接口，Java的所有集合类丢失进行迭代的。
 * 
 * 迭代器就是一个接口Iterator，实现了该接口的类就叫做可迭代类
 * 
 * 1)hasNext() 该方法英语判断集合对象是否还有下一个元素，如果已经是最后一个元素则返回false
 * 2)next() 把迭代器的指向移到下一个位置，同时，该方法返回下一个元素的引用
 * 3)remove()  从迭代器指向的Collection中移除迭代器返回的最后一个元素，该操作使用的比较少
 * 
 * 从Java5.0开始，迭代器可以被foreach循环所替代，但是foreach循环的本质也是使用Iterator进行遍历的。
 * 
 */
public class Demo {
	
	/*
	 * Just for test by Jason
	 */
	public static void main(String[] args) {
		
		List<String> list=new ArrayList<String>();
		Map<Integer,String> map=new HashMap<Integer,String>();
		for(int i=0;i<10;i++){
			list.add(new String("list"+i) );
			map.put(i, new String("map"+i));
		} 
		java.util.Iterator<?> iterList= (java.util.Iterator<?>) list.iterator();//List接口实现了Iterable接口
		 while(iterList.hasNext()){
		   String strList=(String)iterList.next();  
		   System.out.println(strList.toString());  

		  } 
		 
		List<String> list2=new ArrayList<>();  
        list2.add("a");  
        list2.add("b");  
        java.util.Iterator<String>it=list2.iterator();//得到lits的迭代器  
        //调用迭代器的hasNext方法，判断是否有下一个元素  
        while (it.hasNext()) {  
            //将迭代器的下标移动一位，并得到当前位置的元素值  
            System.out.println(it.next());    
        }     
	}

}
