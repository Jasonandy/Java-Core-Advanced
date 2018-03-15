/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs.client.impl;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Map;

import cn.ucaner.fastdfs.FastdfsClientConfig;
import cn.ucaner.fastdfs.client.StorageClient;
import cn.ucaner.fastdfs.command.CloseCmd;
import cn.ucaner.fastdfs.command.Command;
import cn.ucaner.fastdfs.command.DeleteCmd;
import cn.ucaner.fastdfs.command.GetMetaDataCmd;
import cn.ucaner.fastdfs.command.SetMetaDataCmd;
import cn.ucaner.fastdfs.command.UploadCmd;
import cn.ucaner.fastdfs.data.Result;

/**
* @Package：cn.ucaner.fastdfs.client   
* @ClassName：StorageClientImpl   
* @Description：   <p> StorageClientImpl</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午9:28:12   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class StorageClientImpl implements StorageClient{
	
	private Socket socket;
	private String host;
	private Integer port;
	private Integer connectTimeout = FastdfsClientConfig.DEFAULT_CONNECT_TIMEOUT * 1000;
	private Integer networkTimeout = FastdfsClientConfig.DEFAULT_NETWORK_TIMEOUT * 1000;
	
	private Socket getSocket() throws IOException{
		if(socket==null){
			socket = new Socket();
			socket.setSoTimeout(networkTimeout);
			socket.connect(new InetSocketAddress(host, port),connectTimeout);
		}
		return socket;
	}
	
	public StorageClientImpl(String address){
		super();
		String[] hostport = address.split(":");
		this.host = hostport[0];
		this.port = Integer.valueOf(hostport[1]);
	}
	
	public StorageClientImpl(String address,Integer connectTimeout, Integer networkTimeout){
		this(address);
		this.connectTimeout = connectTimeout;
		this.networkTimeout = networkTimeout;
	}

	public void close() throws IOException{
		Socket socket = getSocket();
		Command<Boolean> command = new CloseCmd();
		command.exec(socket);
		socket.close();
		socket = null;
	}

	public Result<String> upload(File file,String fileName,byte storePathIndex) throws IOException{
		Socket socket = getSocket();
		UploadCmd uploadCmd = new UploadCmd(file, fileName,storePathIndex);
		return uploadCmd.exec(socket);
	}
	
	public Result<Boolean> delete(String group,String fileName) throws IOException{
		Socket socket = getSocket();
		DeleteCmd deleteCmd = new DeleteCmd(group,fileName);
		return deleteCmd.exec(socket);
	}

	@Override
	public Result<Boolean> setMeta(String group, String fileName,
			Map<String, String> meta) throws IOException {
		Socket socket = getSocket();
		SetMetaDataCmd setMetaDataCmd = new SetMetaDataCmd(group, fileName, meta);
		return setMetaDataCmd.exec(socket);
	}

	@Override
	public Result<Map<String, String>> getMeta(String group, String fileName)
			throws IOException {
		Socket socket = getSocket();
		GetMetaDataCmd getMetaDataCmd = new GetMetaDataCmd(group, fileName);
		return getMetaDataCmd.exec(socket);
	}

}
