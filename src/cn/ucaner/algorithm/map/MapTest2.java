/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年4月10日 上午9:46:32</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.algorithm.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MapTest2 {
	
	public static void main(String[] args){
		
		Map<Person, String> m = new HashMap<Person, String>();   
		Person p1 = new Person();   
		Person p2 = new Person();   
		               
		p1.setId("1");   
		p1.setName("name1");   
		p2.setId("2");   //注意这里设置了不同的ID
		p2.setName("name2");   
		                     
		m.put(p1, "person1");   
		m.put(p2, "person2");   
		
		System.out.println("Map m's size :" + m.size());   
		              
		p2.setId("1");   
		             
		System.out.println("Map m's size :" + m.size());   
		              
		for(Object o :m.entrySet())
		{   
			Entry<?, ?> e = (Entry<?, ?>)o;   
			System.out.println("key:"+ e.getKey());   
			System.out.println("value:"+ e.getValue());   
		}   

	}
}
