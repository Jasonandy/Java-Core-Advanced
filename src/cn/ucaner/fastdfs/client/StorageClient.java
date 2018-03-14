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

import java.io.File;
import java.io.IOException;
import java.util.Map;

import cn.ucaner.fastdfs.data.Result;

/**
* @Package：cn.ucaner.fastdfs.client   
* @ClassName：StorageClient   
* @Description：   <p> StorageClient</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午9:27:59   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public interface StorageClient {
	
	/**
	 * @Description: upload
	 * @param file
	 * @param fileName
	 * @param storePathIndex
	 * @return
	 * @throws IOException Result<String>
	 * @Autor: Jason - jasonandy@hotamil.com
	 */
	public Result<String> upload(File file,String fileName,byte storePathIndex) throws IOException;
	
	/**
	 * @Description: delete
	 * @param group
	 * @param fileName
	 * @return
	 * @throws IOException Result<Boolean>
	 * @Autor: Jason - jasonandy@hotamil.com
	 */
	public Result<Boolean> delete(String group,String fileName) throws IOException;
	
	/**
	 * @Description: setMeta
	 * @param group
	 * @param fileName
	 * @param meta
	 * @return
	 * @throws IOException Result<Boolean>
	 * @Autor: Jason - jasonandy@hotamil.com
	 */
	public Result<Boolean> setMeta(String group,String fileName,Map<String,String> meta) throws IOException;
	
	/**
	 * @Description: getMeta
	 * @param group
	 * @param fileName
	 * @return
	 * @throws IOException Result<Map<String,String>>
	 * @Autor: Jason - jasonandy@hotamil.com
	 */
	public Result<Map<String,String>> getMeta(String group,String fileName) throws IOException;
	
	/**
	 * @Description: close
	 * @throws IOException void
	 * @Autor: Jason - jasonandy@hotamil.com
	 */
	public void close() throws IOException;
	
}
