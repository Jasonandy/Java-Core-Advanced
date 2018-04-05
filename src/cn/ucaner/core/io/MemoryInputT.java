package cn.ucaner.core.io;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
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
* @ClassName：MemoryInputT   
* @Description：   <p>  内存中输入</p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:31:54   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class MemoryInputT {
	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(BufferedInputFileT.read(
				"src" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"io" + File.separator +
				"BufferedInputFileT.java"));
		int c;
		while((c = in.read()) != -1)// int形式
			System.out.println((char)c);// int字节，转char显示
	}
}
