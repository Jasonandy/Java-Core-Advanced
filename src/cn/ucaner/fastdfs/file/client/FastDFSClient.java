/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs.file.client;

import java.io.File;
import java.io.IOException;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import cn.ucaner.fastdfs.file.FastDFSFile;

import com.alibaba.fastjson.JSONArray;


/**     
 * @Package：cn.ucaner.fastdfs.file.client   
 * @ClassName：FastDFSClient   
 * @Description：   <p> FastDFSClient</p>
 * @Author： - Jason   
 * @CreatTime：2018年3月14日 下午1:54:55   
 * @Modify By：   
 * @ModifyTime：  2018年3月14日
 * @Modify marker：   
 * @version    V1.0
 */
public class FastDFSClient {
	
	private static Logger logger = LoggerFactory.getLogger(FastDFSClient.class);
	
	/**
	 * 客户端
	 */
	private static StorageClient1 storageClient1 = null;

	// 初始化客户端,加载类时候执行片段
	static {
		try {
			//dfs/fastDFSClient.properties
			Resource resource = new ClassPathResource("dfs/fastDFSClient.properties");
			File file = resource.getFile();
			String configFile = file.getAbsolutePath();
			ClientGlobal.init(configFile);
			//
			TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
			//
			TrackerServer trackerServer = trackerClient.getConnection();
			//
			StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
			//
			storageClient1 = new StorageClient1(trackerServer, storageServer);
			logger.info("fastDFS Client Init Success! -- thk.");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("fastDFS Client Init Fail! -- sorry.");
		}
	}

	/***
	 * 文件上传
	 * @param fastDSFile
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public static JSONArray upload(FastDFSFile fastDFSFile) throws IOException, MyException {
		String[] uploadResult = storageClient1.upload_file(fastDFSFile.getContent(), fastDFSFile.getExt(), null);
		JSONArray arr = (JSONArray) JSONArray.toJSON(uploadResult);
		return arr;
	}

	/**
	 * 文件下载
	 * 
	 * @param groupName
	 * @param remoteFileName
	 * @return
	 * @throws IOException
	 * @throws MyException
	 */
	public static byte[] download(String groupName, String remoteFileName) throws IOException, MyException {
		return storageClient1.download_file(groupName, remoteFileName);
	}

	/**
	 * 文件删除
	 * @param groupName
	 * @param remoteFileName
	 * @throws Exception
	 * @return 返回0成功;非0失败.
	 */
	public static int delete(String groupName, String remoteFileName) throws Exception {
		return storageClient1.delete_file(groupName, remoteFileName);
	}

}
