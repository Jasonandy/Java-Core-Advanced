/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs.file;

/**     
 * @Package：cn.ucaner.fastdfs.file   
 * @ClassName：FastDFSile   
 * @Description：   <p> FastDFSFile</p>
 * @Author： - Jason   
 * @CreatTime：2018年3月14日 下午1:52:43   
 * @Modify By：   
 * @ModifyTime：  2018年3月14日
 * @Modify marker：   
 * @version    V1.0
 */
public class FastDFSFile {
	
	/**
	 * 文件名
	 */
	private String name;

	/**
	 * 内容
	 */
	private byte[] content;

	/**
	 * 后缀
	 */
	private String ext;

	/**
	 * 文件信息摘要
	 */
	private String md5;

	/**  
	 * @return name  
	 */
	public String getName() {
		return name;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**  
	 * @return content  
	 */
	public byte[] getContent() {
		return content;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}

	/**  
	 * @return ext  
	 */
	public String getExt() {
		return ext;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setExt(String ext) {
		this.ext = ext;
	}

	/**  
	 * @return md5  
	 */
	public String getMd5() {
		return md5;
	}

	/**  
	 * @param paramtheparamthe{bare_field_name} to set  
	 */
	public void setMd5(String md5) {
		this.md5 = md5;
	}

}
