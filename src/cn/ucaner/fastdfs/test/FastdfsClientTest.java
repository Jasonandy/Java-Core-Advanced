/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs.test;

import cn.ucaner.fastdfs.FastdfsClient;
import cn.ucaner.fastdfs.FastdfsClientFactory;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
* @Package：cn.ucaner.fastdfs.test   
* @ClassName：FastdfsClientTest   
* @Description：   <p> FastdfsClientTest</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午10:33:47   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class FastdfsClientTest {
	

	@Test
	public void testFastdfsClient() throws Exception {
		FastdfsClient fastdfsClient = FastdfsClientFactory.getFastdfsClient("dfs/fastDFSClient.properties");
		//URL fileUrl = this.getClass().getResource("dfs/Koala.jpg");
		File file = new File("E:\\Java-Advanced\\resources\\dfs\\Koala.jpg");
		String fileId = fastdfsClient.upload(file);
		System.out.println("fileId:"+fileId);
		assertNotNull(fileId);
		String url = fastdfsClient.getUrl(fileId);
		assertNotNull(url);
		System.out.println("url:"+url);
		Map<String,String> meta = new HashMap<String, String>();
		meta.put("fileName", file.getName());
		boolean result = fastdfsClient.setMeta(fileId, meta);
		assertTrue(result);
		Map<String,String> meta2 = fastdfsClient.getMeta(fileId);
		assertNotNull(meta2);
		System.out.println(meta2.get("fileName"));
		System.out.println(JSON.toJSONString(meta2));
		result = fastdfsClient.delete(fileId);
		assertTrue(result);
		fastdfsClient.close();
	}


}
