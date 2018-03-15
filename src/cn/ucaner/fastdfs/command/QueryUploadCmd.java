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
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Arrays;

import cn.ucaner.fastdfs.data.Result;
import cn.ucaner.fastdfs.data.UploadStorage;


/**
* @Package：cn.ucaner.fastdfs.command   
* @ClassName：QueryUploadCmd   
* @Description：   <p> QueryUploadCmd</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午10:32:02   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class QueryUploadCmd extends AbstractCmd<UploadStorage>  {
	

	@Override
	public Result<UploadStorage> exec(Socket socket) throws IOException {
		request(socket.getOutputStream());
		Response response = response(socket.getInputStream());
		if(response.isSuccess()){
			byte[] data = response.getData();
			String ip_addr = new String(data,FDFS_GROUP_NAME_MAX_LEN,FDFS_IPADDR_SIZE - 1).trim();
			int port = (int) buff2long(data,FDFS_GROUP_NAME_MAX_LEN	+ FDFS_IPADDR_SIZE - 1);
			byte storePath = data[TRACKER_QUERY_STORAGE_STORE_BODY_LEN - 1];
			UploadStorage uploadStorage = new UploadStorage(ip_addr+":"+String.valueOf(port), storePath);
			return new Result<UploadStorage>(response.getCode(),uploadStorage);
		}else{
			return new Result<UploadStorage>(response.getCode(),"Error");
		}
	}


	/**
	* QueryUploadCmd. 初始化属性参数
	 */
	public QueryUploadCmd() {
		super();
		this.requestCmd = TRACKER_PROTO_CMD_SERVICE_QUERY_STORE_WITHOUT_GROUP_ONE;
		this.responseCmd = TRACKER_PROTO_CMD_RESP;
		this.responseSize = TRACKER_QUERY_STORAGE_STORE_BODY_LEN;
	}
	
	public QueryUploadCmd(String group) throws UnsupportedEncodingException {
		super();
		int group_len;
		byte[] bs = group.getBytes("UTF-8");
		body1 = new byte[FDFS_GROUP_NAME_MAX_LEN];
		if (bs.length <= FDFS_GROUP_NAME_MAX_LEN) {
			group_len = bs.length;
		} else {
			group_len = FDFS_GROUP_NAME_MAX_LEN;
		}
		Arrays.fill(body1, (byte) 0);
		System.arraycopy(bs, 0, body1, 0, group_len);
		this.requestCmd = TRACKER_PROTO_CMD_SERVICE_QUERY_STORE_WITH_GROUP_ONE;
		this.responseCmd = TRACKER_PROTO_CMD_RESP;
		this.responseSize = TRACKER_QUERY_STORAGE_STORE_BODY_LEN;
	}
	
	
}
