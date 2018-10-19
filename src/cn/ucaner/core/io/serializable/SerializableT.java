/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.io.serializable;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
* @Package：cn.ucaner.core.io.serializable   
* @ClassName：SerializableT   
* @Description：   <p> Java序列化和反序列化的小例子 </p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:38:43   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class SerializableT {
	
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        for (int i = 0;i < 10;i++) {
            AObjcet aObjcet = new AObjcet();
            long beginTime = System.currentTimeMillis();

            ByteOutputStream byteOutput = new ByteOutputStream();
            ObjectOutputStream objectOutput = new ObjectOutputStream(byteOutput);
            objectOutput.writeObject(aObjcet);
            objectOutput.close();
            byteOutput.close();
            byte[] bytes = byteOutput.toByteArray();
            System.out.println("Java序列化耗时：" + (System.currentTimeMillis() - beginTime) + "ms");
            System.out.println("Java序列化后的字节大小为：" + bytes.length);

            beginTime = System.currentTimeMillis();
            ByteArrayInputStream byteInput = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInput = new ObjectInputStream(byteInput);
            objectInput.readObject();
            objectInput.close();
            byteInput.close();
            System.out.println("Java反序列化耗时：" + (System.currentTimeMillis() - beginTime) + "ms");

        }
    }
}

class AObjcet implements Serializable {
    private String a = "bysocket";
    private String b = "likes";
    private String c = "java";
    private String d = "world";

    private int i = 100;
    private int j = 10;
    private long m = 100L;

    private boolean isA = true;
    private boolean isB = false;
    private boolean isC = false;

    private BObject aObject = new BObject();
    private BObject bObject = new BObject();
    private BObject cObject = new BObject();
    private BObject dObject = new BObject();

}

class BObject implements Serializable {

}
