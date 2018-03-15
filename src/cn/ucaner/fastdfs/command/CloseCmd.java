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

import cn.ucaner.fastdfs.data.Result;

/**
* @Package：cn.ucaner.fastdfs.command   
* @ClassName：CloseCmd   
* @Description：   <p> CloseCmd</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午9:28:59   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class CloseCmd extends AbstractCmd<Boolean> {
	
	public CloseCmd() {
		super();
		this.requestCmd = FDFS_PROTO_CMD_QUIT;
	}

	/**
	 * execute
	 */
	@Override
	public Result<Boolean> exec(Socket socket) throws IOException {
		request(socket.getOutputStream());
		return new Result<Boolean>(SUCCESS_CODE,true);
	}


}
