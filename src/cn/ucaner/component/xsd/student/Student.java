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

import java.util.List;

/**     
* @Package：cn.ucaner.component.xsd.student   
* @ClassName：Student   
* @Description：   <p> Student </p>
* @Author： - Jason
* @CreatTime：2018年5月31日 上午9:13:42   
* @Modify By：   
* @ModifyTime：  2018年5月31日
* @Modify marker：   
* @version    V1.0
*/
//@XmlRootElement(name="student",namespace="cn.ucaner.xsd.student")  
//@XmlType(namespace="student.ucaner.cn")  
public class Student {
	
	 private String name;  
	 
	 private String number; 
	 
	 private String gender;  
	 
	 private String age;  
	 
	 private List<Course> courses;

	 public String getName() {
		return name;
	}

	 public void setName(String name) {
		this.name = name;
	}

	 public String getNumber() {
		return number;
	}

	 public void setNumber(String number) {
		this.number = number;
	}
	 
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public List<Course> getCourses() {
		return courses;
	}
	
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	/**  
	* Student. 
	* @param name
	* @param number
	* @param gender
	* @param age
	* @param courses  
	*/  
	public Student(String name, String number, String gender, String age, List<Course> courses) {
		super();
		this.name = name;
		this.number = number;
		this.gender = gender;
		this.age = age;
		this.courses = courses;
	}

	/**  
	* Student.   
	*/  
	public Student() {
		super();
	} 
}
