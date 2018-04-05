package cn.ucaner.core.io;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;

/**
* @Package：cn.ucaner.core.io   
* @ClassName：FormatteMemoryInput   
* @Description：   <p> 格式化内存输入</p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:32:39   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class FormatteMemoryInput {
	public static void main(String[] args) throws IOException {
		String filePath = "src" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"io" + File.separator +
				"FormatteMemoryInput.java";
		try {
			DataInputStream in = new DataInputStream(
					// 缓冲区字节输入
					new ByteArrayInputStream(
							BufferedInputFileT.read(filePath).getBytes()));
			while(true)
				System.out.println((char)in.readByte());
		} catch (EOFException e) {
			System.out.println("End of Stream");
		}
	}
}
