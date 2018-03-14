/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs.data;

/**
* @Package：cn.ucaner.fastdfs.data   
* @ClassName：UploadStorage   
* @Description：   <p> UploadStorage</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午10:33:11   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class UploadStorage {
	
	/**
	 * 上传地址
	 */
	private String address;
	
	/**
	 * 数据byte
	 */
	private byte pathIndex;
	
	/**
	* UploadStorage. 
	* @param address 上传地址
	* @param pathIndex 数据byte
	 */
	public UploadStorage(String address, byte pathIndex) {
		super();
		this.address = address;
		this.pathIndex = pathIndex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public byte getPathIndex() {
		return pathIndex;
	}
	public void setPathIndex(byte pathIndex) {
		this.pathIndex = pathIndex;
	}
	
	

}
