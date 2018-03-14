package cn.ucaner.fastdfs;

import java.io.File;
import java.util.Map;

/**
* @Package：cn.ucaner.fastdfs   
* @ClassName：FastdfsClient   
* @Description：   <p> FastdfsClient</p>
* @Author： - DaoDou   
* @CreatTime：2018年3月14日 上午10:34:04   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public interface FastdfsClient {
	
	public String upload(File file) throws Exception;
	public String upload(File file,String fileName) throws Exception;
	public String getUrl(String fileId) throws Exception;
	public Boolean setMeta(String fileId,Map<String,String> meta) throws Exception;
	public Map<String,String> getMeta(String fileId) throws Exception;
	public Boolean delete(String fileId) throws Exception;
	public void close();

}
