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
* @ClassName：StringConvertT   
* @Description：   <p> String转换成byte数组</p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:39:16   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class StringConvertT {

	public static void main(String[] args){
		String str = "HOME";
		byte[] bytes = str.getBytes();
		// 打印字节数组
		System.out.println("UTF-8编码'HOME'的字节数组为：");
		for (int i = 0; i < bytes.length; i++) {
            System.out.println("\t" + bytes[i] + "|" + Integer.toBinaryString(bytes[i]));
        }
	}
}
