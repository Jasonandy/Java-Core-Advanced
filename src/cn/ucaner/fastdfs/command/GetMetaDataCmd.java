package cn.ucaner.fastdfs.command;

import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cn.ucaner.fastdfs.data.Result;

/**
* @Package：cn.ucaner.fastdfs.command   
* @ClassName：GetMetaDataCmd   
* @Description：   <p> GetMetaDataCmd</p>
* @Author： - DaoDou   
* @CreatTime：2018年3月14日 上午9:29:34   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class GetMetaDataCmd extends AbstractCmd<Map<String, String>> {

	@Override
	public Result<Map<String, String>> exec(Socket socket) throws IOException {
		request(socket.getOutputStream());
		Response response = response(socket.getInputStream());
		if(response.isSuccess()){
			String metaStr = new String(response.getData(),charset);
			Map<String, String> metaData = new HashMap<String, String>();
			String[] rows = metaStr.split(FDFS_RECORD_SEPERATOR);
			for(String row:rows){
				String[] cols = row.split(FDFS_FIELD_SEPERATOR);
				metaData.put(cols[0], cols[1]);
			}
			return new Result<Map<String, String>>(response.getCode(),metaData);
		}else{
			return new Result<Map<String, String>>(response.getCode(),"GetMetaData Error");
		}
	}

	public GetMetaDataCmd(String group, String fileName) {
		super();
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
		this.requestCmd = STORAGE_PROTO_CMD_GET_METADATA;
		this.responseCmd = STORAGE_PROTO_CMD_RESP;
		this.responseSize = -1;
	}

}
