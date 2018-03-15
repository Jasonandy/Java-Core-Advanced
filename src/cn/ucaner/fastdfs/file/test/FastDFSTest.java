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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	
	private static Logger logger = LoggerFactory.getLogger(FastDFSClient.class);
	
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
			
			/**
			 * 文件内容
			 * 文件扩展名
			 * 文件md5信息摘要
			 */
			fastDFSFile.setContent(bos.toByteArray());
			fastDFSFile.setExt("ico");

			// -------上传----
			JSONArray rs = FastDFSClient.upload(fastDFSFile);
			logger.info("上传成功！ 详细数据为{} . - By Jason",rs);

			// -------下载---- 下载为byte[] 数据
			byte[] dfile = FastDFSClient.download(rs.getString(0), rs.getString(1));
			
			
			FileOutputStream fos = new FileOutputStream(new File("C:/Users/Jason/Pictures/design/tx-chrome.ico"));
			fos.write(dfile);
			fos.flush();
			fos.close();
			
			// -------删除-----
			int ds=FastDFSClient.delete(rs.getString(0), rs.getString(1));
			
			logger.info("删除成功！ 受影响的数据为 {} . - By Jason",ds);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
