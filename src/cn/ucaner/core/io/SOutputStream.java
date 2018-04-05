package cn.ucaner.core.io;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

/**
* @Package：cn.ucaner.core.io   
* @ClassName：SOutputStream   
* @Description：   <p> 所有字节输出流实现类的基类</p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:30:06   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public abstract class SOutputStream implements Closeable, Flushable {

	// 将指定的字节写入输出流
    public abstract void write(int b) throws IOException;

    // 将指定的byte数组的字节全部写入输出流
    public void write(byte b[]) throws IOException {
        write(b, 0, b.length);
    }

    // 将指定的byte数组中从偏移量off开始的len个字节写入输出流
    public void write(byte b[], int off, int len) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if ((off < 0) || (off > b.length) || (len < 0) ||
                   ((off + len) > b.length) || ((off + len) < 0)) {
            throw new IndexOutOfBoundsException();
        } else if (len == 0) {
            return;
        }
        for (int i = 0 ; i < len ; i++) {
            write(b[off + i]);
        }
    }

    // 刷新输出流，并强制写出所有缓冲的输出字节
    public void flush() throws IOException {
    }

    // 关闭输出流，并释放与该流有关的所有资源
    public void close() throws IOException {
    }

}