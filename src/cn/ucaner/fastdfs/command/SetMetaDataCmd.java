/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs.command;

import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Map;

import cn.ucaner.fastdfs.data.Result;

/**
* @Package：cn.ucaner.fastdfs.command   
* @ClassName：SetMetaDataCmd   
* @Description：   <p> SetMetaDataCmd  设置元信息</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午10:32:12   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class SetMetaDataCmd extends AbstractCmd<Boolean> {

	@Override
	public Result<Boolean> exec(Socket socket) throws IOException {
		request(socket.getOutputStream());
		Response response = response(socket.getInputStream());
		if(response.isSuccess()){
			return new Result<Boolean>(response.getCode(),true);
		}else{
			return new Result<Boolean>(response.getCode(),"SetMetaData Error");
		}
	}

	public SetMetaDataCmd(String group,String fileName,Map<String,String> metaData) {
		super();
		byte[] groupByte = group.getBytes(charset);
		int group_len = groupByte.length;
		if (group_len > FDFS_GROUP_NAME_MAX_LEN) {
			group_len = FDFS_GROUP_NAME_MAX_LEN;
		}
		byte[] fileNameByte = fileName.getBytes(charset);
		byte[] fileNameSizeByte = long2buff(fileNameByte.length);
		byte[] metaDataByte = metaDataToStr(metaData).getBytes(charset);
		byte[] metaDataSizeByte = long2buff(metaDataByte.length); 
		
		body1 = new byte[2 * FDFS_PROTO_PKG_LEN_SIZE + 1 + FDFS_GROUP_NAME_MAX_LEN + fileNameByte.length + metaDataByte.length];
		
		Arrays.fill(body1, (byte) 0);
		int pos = 0;
		System.arraycopy(fileNameSizeByte, 0, body1, pos, fileNameSizeByte.length);
		pos += FDFS_PROTO_PKG_LEN_SIZE;
		System.arraycopy(metaDataSizeByte, 0, body1, pos, metaDataSizeByte.length);
		pos += FDFS_PROTO_PKG_LEN_SIZE;
		body1[pos] = STORAGE_SET_METADATA_FLAG_OVERWRITE;
		pos += 1;
		System.arraycopy(groupByte, 0, body1, pos, group_len);
		pos += FDFS_GROUP_NAME_MAX_LEN;
		System.arraycopy(fileNameByte, 0, body1, pos, fileNameByte.length);
		pos += fileNameByte.length;
		System.arraycopy(metaDataByte, 0, body1, pos, metaDataByte.length);
		
		this.requestCmd = STORAGE_PROTO_CMD_SET_METADATA;
		this.responseCmd = STORAGE_PROTO_CMD_RESP;
		this.responseSize = 0;
	}
	
	/**
	 * @Description: 元数据拼接为字符串
	 * @param metaData
	 * @return String
	 * @Autor: Jason - jaonandy@hotmail.com
	 */
	private String metaDataToStr(Map<String,String> metaData){
		StringBuffer sb = new StringBuffer();
		for(String key:metaData.keySet()){
			sb.append(FDFS_RECORD_SEPERATOR);
			sb.append(key);
			sb.append(FDFS_FIELD_SEPERATOR);
			sb.append(metaData.get(key));
		}
		
		return sb.toString().substring(FDFS_RECORD_SEPERATOR.length());
	}
	

}
