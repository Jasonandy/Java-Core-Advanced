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

	public Result<UploadStorage> getUploadStorage() throws IOException;
	public Result<String> getUpdateStorageAddr(String group,String fileName) throws IOException;
	public Result<String> getDownloadStorageAddr(String group,String fileName) throws IOException;
	public Result<List<GroupInfo>> getGroupInfos() throws IOException;
	public Result<List<StorageInfo>> getStorageInfos(String group) throws IOException;
	public void close() throws IOException;
	
}
