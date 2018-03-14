package cn.ucaner.fastdfs.data;

/**
* @Package：cn.ucaner.fastdfs.data   
* @ClassName：Result   
* @Description：   <p> Result</p>
* @Author： - DaoDou   
* @CreatTime：2018年3月14日 上午10:32:51   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class Result<T> {

	private int code;
	private String message;
	private T data;
	
	public Result(int code) {
		super();
		this.code = code;
	}
	
	public Result(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public Result(int code, T data) {
		super();
		this.code = code;
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	
}
