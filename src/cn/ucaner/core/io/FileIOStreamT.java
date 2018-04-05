package cn.ucaner.core.io;

import java.io.File;
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
* @ClassName：FileIOStreamT   
* @Description：   <p> FileInputStream&FileOutputStream使用案例 </p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:34:36   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class FileIOStreamT {
	private static final String thisFilePath = 
			"src" + File.separator +
			"org" + File.separator +
			"javacore" + File.separator +
			"io" + File.separator +
			"FileIOStreamT.java";
	public static void main(String[] args) throws IOException {
		// 创建文件输入流
		FileInputStream fileInputStream = new FileInputStream(thisFilePath);
		// 创建文件输出流
		FileOutputStream fileOutputStream =  new FileOutputStream("data.txt");
		
		// 创建流的最大字节数组
		byte[] inOutBytes = new byte[fileInputStream.available()];
		// 将文件输入流读取，保存至inOutBytes数组
		fileInputStream.read(inOutBytes);
		// 将inOutBytes数组，写出到data.txt文件中
		fileOutputStream.write(inOutBytes);
		
		fileOutputStream.close();
		fileInputStream.close();
	}
}
