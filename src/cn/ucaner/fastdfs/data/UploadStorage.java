package cn.ucaner.fastdfs.data;

/**
* @Package：cn.ucaner.fastdfs.data   
* @ClassName：UploadStorage   
* @Description：   <p> UploadStorage</p>
* @Author： - DaoDou   
* @CreatTime：2018年3月14日 上午10:33:11   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class UploadStorage {
	
	private String address;
	private byte pathIndex;
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
