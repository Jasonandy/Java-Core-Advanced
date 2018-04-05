package cn.ucaner.core.io.zip;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

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
* @Package：cn.ucaner.core.io.zip   
* @ClassName：GZIPcompress   
* @Description：   <p> GZIP简单使用</p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:37:14   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class GZIPcompress {
    public static void main(String[] args) throws IOException {
        // 用Reader读文件
        BufferedReader in = new BufferedReader(new  InputStreamReader(
                new  FileInputStream("data.gz" ),  "UTF-8" ));
        // 使用缓冲输出流，输出压缩流文件
        BufferedOutputStream out = new BufferedOutputStream(
                new GZIPOutputStream(new FileOutputStream("data.gz")));
        System.out.println("Writing File 压缩");
        int c;
        while ((c = in.read()) > 0)
            out.write(String.valueOf((char)c).getBytes("UTF-8"));
        in.close();
        out.close();

        System.out.println("Reading File 解压");
        // 用输入解压流读取文件
        BufferedReader in2 = new BufferedReader(
                new InputStreamReader(
                        new GZIPInputStream(new FileInputStream("data.gz")),"UTF-8"));// encoding question
        String s;
        while ((s=in2.readLine()) != null)
            System.out.println(s);
        in2.close();
    }
}
