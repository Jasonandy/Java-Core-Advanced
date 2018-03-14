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
import java.util.ArrayList;
import java.util.List;

import cn.ucaner.fastdfs.data.GroupInfo;
import cn.ucaner.fastdfs.data.Result;

/**
* @Package：cn.ucaner.fastdfs.command   
* @ClassName：GroupInfoCmd   
* @Description：   <p> GroupInfoCmd</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午9:29:44   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class GroupInfoCmd extends AbstractCmd<List<GroupInfo>> {

	@Override
	public Result<List<GroupInfo>> exec(Socket socket) throws IOException {
		request(socket.getOutputStream());
		Response response = response(socket.getInputStream());
		if(response.isSuccess()){
			byte[] data = response.getData();
			int dataLength = data.length;
			if(dataLength%GroupInfo.BYTE_SIZE!=0){
				throw new IOException("recv body length: " + data.length + " is not correct");
			}
			List<GroupInfo> groupInfos = new ArrayList<GroupInfo>();
			int offset = 0;
			while(offset<dataLength){
				GroupInfo groupInfo = new GroupInfo(data,offset);
				groupInfos.add(groupInfo);
				offset += GroupInfo.BYTE_SIZE;
			}
			return new Result<List<GroupInfo>>(response.getCode(),groupInfos);
		}else{
			return new Result<List<GroupInfo>>(response.getCode(),"Error");
		}
	}

	public GroupInfoCmd() {
		super();
		this.requestCmd = TRACKER_PROTO_CMD_SERVER_LIST_GROUP;
		this.responseCmd = TRACKER_PROTO_CMD_RESP;
		this.responseSize = -1;
	}

}
