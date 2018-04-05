package cn.ucaner.core.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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
* @Package：cn.ucaner.core.io   
* @ClassName：StoringAndRecoveringData   
* @Description：   <p> DataOutputStream和DataInputStream的使用案例</p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:29:50   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class StoringAndRecoveringData {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// 写入数据
		DataOutputStream outputStream = new DataOutputStream(
				new BufferedOutputStream(new FileOutputStream("data.txt")));
		outputStream.writeDouble(3.1415926);
		outputStream.writeUTF("你好");
		outputStream.writeInt(1);
		outputStream.close();
		
		// 写出数据
		DataInputStream inputStream = new DataInputStream(
				new BufferedInputStream(new FileInputStream("data.txt")));
		System.out.println(inputStream.readDouble());
		System.out.println(inputStream.readUTF());
		System.out.println(inputStream.readInt());
	}
}
