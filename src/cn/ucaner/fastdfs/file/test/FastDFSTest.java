/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs.file.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;

import cn.ucaner.fastdfs.file.FastDFSFile;
import cn.ucaner.fastdfs.file.client.FastDFSClient;


/**     
 * @Package：cn.ucaner.fastdfs.file.test   
 * @ClassName：FastDFSTest   
 * @Description：   <p> FastDFSTest 测试类 </p>
 * @Author： - Jason   
 * @CreatTime：2018年3月14日 下午1:58:12   
 * @Modify By：   
 * @ModifyTime：  2018年3月14日
 * @Modify marker：   
 * @version    V1.0
 */
public class FastDFSTest {
	
	/**
	 * @Description: 测试client端
	 * @see https://github.com/happyfish100/fastdfs-client-java
	 * @throws Exception void
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	@Test
	public void testFastDFSTestClient() throws Exception {
		
		try {
			//C:\Users\Jason\Pictures\design\chrome.ico
			FileInputStream fis = new FileInputStream(new File("C:/Users/Jason/Pictures/design/chrome.ico"));
			ByteArrayOutputStream bos = new ByteArrayOutputStream();

			byte[] cache = new byte[4096];
			while (fis.read(cache) != -1) {
				bos.write(cache);
			}
			fis.close();
			FastDFSFile fastDFSFile = new FastDFSFile();
			fastDFSFile.setContent(bos.toByteArray());
			fastDFSFile.setExt("ico");

			// -------上传----
			JSONArray rs = FastDFSClient.upload(fastDFSFile);
			System.out.println("上传结束:" + rs);

			// -------下载----
			byte[] dfile = FastDFSClient.download(rs.getString(0), rs.getString(1));
			
			FileOutputStream fos = new FileOutputStream(new File("C:/Users/Jason/Pictures/design/tx-chrome.ico"));
			fos.write(dfile);
			fos.flush();
			fos.close();
			
			// -------删除-----
			int ds=FastDFSClient.delete(rs.getString(0), rs.getString(1));
			//
			System.out.println("Delete:"+ds);
			System.out.println("---End----");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
