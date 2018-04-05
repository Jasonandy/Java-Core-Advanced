package cn.ucaner.core.collection.queue;

import java.util.PriorityQueue;
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
* @Package：cn.ucaner.core.collection.queue   
* @ClassName：PriorityQueueT   
* @Description：   <p> PriorityQueue的使用  优先队列？</p>
* @Author： - Jeff Lee   
* @CreatTime：2018年4月5日 下午12:49:39   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class PriorityQueueT {
	public static void main(String[] args) {
		int[] ia = { 1, 10, 5, 3, 4, 7, 6, 9, 8 };
		PriorityQueue<Integer> pq1 = new PriorityQueue<Integer>();
 
		for (int x : ia) 
			pq1.offer(x);
		// 注意排序
		System.out.println("pq1: " + pq1);
	}
}