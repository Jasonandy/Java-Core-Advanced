/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs.client;

import java.io.IOException;
import java.util.List;

import cn.ucaner.fastdfs.data.GroupInfo;
import cn.ucaner.fastdfs.data.Result;
import cn.ucaner.fastdfs.data.StorageInfo;
import cn.ucaner.fastdfs.data.UploadStorage;

/**
* @Package：cn.ucaner.fastdfs.client   
* @ClassName：TrackerClient   
* @Description：   <p> TrackerClient</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午9:28:23   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public interface TrackerClient {

	/**
	 * @Description: getUploadStorage  
	 * @return
	 * @throws IOException Result<UploadStorage>
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public Result<UploadStorage> getUploadStorage() throws IOException;
	
	/**
	 * @Description: getUpdateStorageAddr   
	 * @param group 	获取资源根据group
	 * @param fileName 	文件名字 fileName
	 * @throws IOException Result<String>
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public Result<String> getUpdateStorageAddr(String group,String fileName) throws IOException;
	
	/**
	 * @Description: getDownloadStorageAddr
	 * @param group		获取资源根据group
	 * @param fileName	文件名字 fileName
	 * @return
	 * @throws IOException Result<String>
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public Result<String> getDownloadStorageAddr(String group,String fileName) throws IOException;
	
	/**
	 * @Description: getGroupInfos 获取group信息
	 * @return
	 * @throws IOException Result<List<GroupInfo>>
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public Result<List<GroupInfo>> getGroupInfos() throws IOException;
	
	/**
	 * @Description: getStorageInfos
	 * @param group  group 获取存储信息
	 * @return
	 * @throws IOException Result<List<StorageInfo>>
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	public Result<List<StorageInfo>> getStorageInfos(String group) throws IOException;
	
	/**
	 * @Description: close 关闭客户端释放资源
	 * @throws IOException void
	 * @Autor: Jason - jasonandy@hotmail.com 
	 */
	public void close() throws IOException;
	
}
