package cn.ucaner.core.nio;

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

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
* @Package：cn.ucaner.core.nio   
* @ClassName：LargeMappedFiles   
* @Description：   <p> 内存映射文件的使用</p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:24:18   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class LargeMappedFiles {
    static int length = 0x8FFFFFF; // 128 MB

    @SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
        // 将此通道的文件区域直接映射到内存映射区域中。
        MappedByteBuffer out = new RandomAccessFile("data.txt","rw").getChannel()
                .map(FileChannel.MapMode.READ_WRITE, 0, length);
        // 写入128MB的字符串
        for (int i = 0;i < length; i++)
            out.put((byte)'x');
        System.out.println("Finished writing");
        // 打印其中6个字符
        for (int i = length/2; i < length/2 + 6; i++)
            System.out.print((char)out.get(i));
    }
}
