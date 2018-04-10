/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 19941115</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.eum;

/**
* @Package：cn.ucaner.core.eum   
* @ClassName：EnumA   
* @Description：   <p> 枚举类的学习</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午10:16:51   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
public class  EnumA {
	
	public static void main(String[] args) {
		System.out.println(WeekDay.MONDAY);//WeekDay
	}
}
/**
* @Package：cn.ucaner.core.eum   
* @ClassName：WeekDay   
* @Description：   <p> 星期</p>
* @Author： - Jason   
* @CreatTime：2018年4月10日 下午10:19:03   
* @Modify By：   
* @ModifyTime：  2018年4月10日
* @Modify marker：   
* @version    V1.0
 */
enum WeekDay {
  MONDAY, TUESDAY, WEDNESDAY,
  THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
