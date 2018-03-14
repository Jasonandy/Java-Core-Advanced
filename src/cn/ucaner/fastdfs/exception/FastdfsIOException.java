package cn.ucaner.fastdfs.exception;

/**
* @Package：cn.ucaner.fastdfs.exception   
* @ClassName：FastdfsIOException   
* @Description：   <p> FastdfsIOException</p>
* @Author： - DaoDou   
* @CreatTime：2018年3月14日 上午9:39:11   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class FastdfsIOException extends Exception {

	private static final long serialVersionUID = 4234899139606659965L;

	public FastdfsIOException() {
		super();
	}

	public FastdfsIOException(String message, Throwable cause) {
		super(message, cause);
	}

	public FastdfsIOException(String message) {
		super(message);
	}

	public FastdfsIOException(Throwable cause) {
		super(cause);
	}


}
