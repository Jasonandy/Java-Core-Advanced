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

import cn.ucaner.fastdfs.data.Result;

/**
* @Package：cn.ucaner.fastdfs.command   
* @ClassName：DeleteCmd   
* @Description：   <p> DeleteCmd</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午9:29:23   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class DeleteCmd extends AbstractCmd<Boolean> {

	@Override
	public Result<Boolean> exec(Socket socket) throws IOException {
		request(socket.getOutputStream());
		Response response = response(socket.getInputStream());
		if(response.isSuccess()){
			return new Result<Boolean>(response.getCode(),true);
		}else{
			/**
			 * delete error exception
			 */
			return new Result<Boolean>(response.getCode(),"Delete Error");
		}
	}

	/**
	* DeleteCmd.  Delete comand
	* @param group 
	* @param fileName
	 */
	public DeleteCmd(String group,String fileName) {
		super();
		/**
		 * 字符集utf-8
		 */
		byte[] groupByte = group.getBytes(charset);
		int group_len = groupByte.length;
		if (group_len > FDFS_GROUP_NAME_MAX_LEN) {
			group_len = FDFS_GROUP_NAME_MAX_LEN;
		}
		byte[] fileNameByte = fileName.getBytes(charset);
		body1 = new byte[FDFS_GROUP_NAME_MAX_LEN + fileNameByte.length];
		Arrays.fill(body1, (byte) 0);
		System.arraycopy(groupByte, 0, body1, 0, group_len);
		System.arraycopy(fileNameByte, 0, body1, FDFS_GROUP_NAME_MAX_LEN, fileNameByte.length);
		this.requestCmd = STORAGE_PROTO_CMD_DELETE_FILE;
		this.responseCmd = STORAGE_PROTO_CMD_RESP;
		this.responseSize = 0;
	}

}
