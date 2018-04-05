package cn.ucaner.core.thread;

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
* @Package：cn.ucaner.core.thread   
* @ClassName：MyThread   
* @Description：   <p> 	Thread的简单使用 </br> 	Thread的简单使用  {@link MyThreadTest}</p>
* @Author： - Jeff Lee   
* @CreatTime：2018年4月5日 下午1:11:50   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class MyThread extends Thread{

	@Override
	public void run() {
		System.out.println("MyThread --> run()");
	}

}
