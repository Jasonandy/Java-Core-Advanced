package cn.ucaner.core.collection.set;

import java.util.Iterator;
import java.util.TreeSet;
/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
* @Package：cn.ucaner.core.collection.set   
* @ClassName：TreeSetT   
* @Description：   <p> TreeSet操作已实现Comparable接口的对象</p>
* @Author： - Jeff Lee   
* @CreatTime：2018年4月5日 下午12:53:50   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class TreeSetT{
	public static void main(String[] args){
		TreeSet<Bird> bSet = new TreeSet<Bird>();
		bSet.add(new Bird(1));
		bSet.add(new Bird(3));
		bSet.add(new Bird(2));
		
		// 注意排序
		Iterator<Bird> iter = bSet.iterator();
		while (iter.hasNext()){
			Bird bird = (Bird) iter.next();
			System.out.println(bird);
		}
	}
}
/**
 * Bird对象 实现了Comparable接口
 */
class Bird implements Comparable<Bird>{
	int size;
	public Bird(int s){
		size = s;
	}
	
	public String toString(){
		return size + "号鸟";
	}

	@Override
	public int compareTo(Bird o){
		return size - o.size;
	}
}