package cn.ucaner.core.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

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
* @Package：cn.ucaner.core.nio   
* @ClassName：MappedIO   
* @Description：   <p>  MappedByteBuffer与Old IO的性能比</p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:23:37   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class MappedIO {
	
    private static int numOfInts = 4000000;
    private static int numOfUbuffInts = 200000;

    private abstract static class Tester {
        private String name;
        public Tester(String name){
            this.name = name;
        }

        // 打印测试时间
        public void runTests(){
            System.out.print(name + ": ");
            try {
                long start = System.nanoTime();
                test();
                double duration = System.nanoTime() - start;
                System.out.format("%.2f\n",duration/1.0e9);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        public abstract void test() throws IOException;
    }

    private static Tester[] tests = {
        new Tester("Stream Write") {
            @Override
            public void test() throws IOException {
                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(new FileOutputStream(new File("data.txt"))));
                for (int i = 0; i < numOfInts; i++)
                    dos.writeInt(i);
                dos.close();
            }
        },
        new Tester("Mapped Write") {
            @SuppressWarnings("resource")
			@Override
            public void test() throws IOException {
                FileChannel fc =
                        new RandomAccessFile("data.txt" , "rw").getChannel();
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE,
                        0,fc.size()).asIntBuffer();
                for (int i = 0; i < numOfInts; i++)
                    ib.put(i);
                fc.close();
            }
        },
        new Tester("Stream Read") {
            @Override
            public void test() throws IOException {
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(new FileInputStream(new File("data.txt"))));
                for (int i = 0; i < numOfInts; i++)
                    dis.readInt();
                dis.close();
            }
        },
        new Tester("Mapped Read") {
            @Override
            public void test() throws IOException {
                FileChannel fc =
                        new FileInputStream(new File("data.txt")).getChannel();
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_ONLY,
                        0 , fc.size()).asIntBuffer();
                while (ib.hasRemaining())
                    ib.get();
                fc.close();
            }
        },
        new Tester("Stream Read/Write") {
            @Override
            public void test() throws IOException {
                RandomAccessFile raf = new RandomAccessFile(
                        new File("data.txt"), "rw");
                raf.writeInt(1);
                for (int i = 0; i < numOfUbuffInts; i++) {
                    raf.seek(raf.length() - 4);
                    raf.writeInt(raf.readInt());
                }
                raf.close();
            }
        },
        new Tester("Mapped Read/Write") {
            @Override
            public void test() throws IOException {
                FileChannel fc = new RandomAccessFile(
                        new File("data.txt"),"rw").getChannel();
                IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE,
                        0,fc.size()).asIntBuffer();
                ib.put(0);
                for (int i = 1; i < numOfUbuffInts; i++)
                    ib.put(ib.get(i-1));
                fc.close();
            }
        }
    };

    public static void main(String[] args) {
        for (Tester tester : tests)
            tester.runTests();
    }
}
