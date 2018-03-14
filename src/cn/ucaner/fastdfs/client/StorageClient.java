package cn.ucaner.fastdfs.client;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import cn.ucaner.fastdfs.data.Result;

/**
* @Package：cn.ucaner.fastdfs.client   
* @ClassName：StorageClient   
* @Description：   <p> StorageClient</p>
* @Author： - DaoDou   
* @CreatTime：2018年3月14日 上午9:27:59   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public interface StorageClient {
	
	public Result<String> upload(File file,String fileName,byte storePathIndex) throws IOException;
	public Result<Boolean> delete(String group,String fileName) throws IOException;
	public Result<Boolean> setMeta(String group,String fileName,Map<String,String> meta) throws IOException;
	public Result<Map<String,String>> getMeta(String group,String fileName) throws IOException;
	public void close() throws IOException;
	
}
