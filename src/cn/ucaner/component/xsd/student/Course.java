/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.component.xsd.student;

/**     
* @Package：cn.ucaner.component.xsd.student   
* @ClassName：Course   
* @Description：   <p> Course </p>
* @Author： - wubin   
* @CreatTime：2018年5月31日 上午9:14:48   
* @Modify By：   
* @ModifyTime：  2018年5月31日
* @Modify marker：   
* @version    V1.0
*/
//@XmlRootElement(name="course",namespace="cn.ucaner.xsd.course")  
//@XmlType(namespace="course.ucaner.cn")  
public class Course {
	
	private String name;
	
	private String totalScore;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(String totalScore) {
		this.totalScore = totalScore;
	}

}
