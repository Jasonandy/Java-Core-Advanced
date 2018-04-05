package cn.ucaner.core.io.byteoper;
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
* @Package：cn.ucaner.core.io.byteoper   
* @ClassName：IntegerOperT   
* @Description：   <p> Integer类的进制转换</p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:39:53   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class IntegerOperT {

	public static void main(String[] args) {
		System.out.println("17的十六进制： " + Integer.toHexString(17));
		System.out.println("17的八进制：     " 	+ Integer.toOctalString(17));
		System.out.println("17的二进制：     " 	+ Integer.toBinaryString(17));

		System.out.println(Integer.valueOf("11", 16));
		System.out.println(Integer.valueOf("21", 8));
		System.out.println(Integer.valueOf("00010001", 2));
	}

}
