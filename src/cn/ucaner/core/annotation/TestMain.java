/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.annotation;

import java.lang.reflect.Field;

/**
* @Package：cn.ucaner.core.annotation   
* @ClassName：TestMain   
* @Description：   <p> TestMain </p>
* @Author： - Jason   
* @CreatTime：2018年10月19日 下午3:17:20   
* @Modify By：   
* @ModifyTime：  2018年10月19日
* @Modify marker：   
* @version    V1.0
 */
public class TestMain {

    @FieldMeta(name="Jason")//注解的使用
    private Object obj;
    
    @FieldMeta(name="Andy",description="Intersting")
    private String name;
    
    @FruitName(value="Apple")
    @FieldMeta
    private String profile;
    
	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}


	/**
	 * @Description: Just for test   注解反射的方式拿到元信息数据
	 * @throws Exception void
	 */
	public static void main(String[] args) throws Exception{
		
		 Field[] fields = TestMain.class.getDeclaredFields();
		 for (Field field : fields) {
			System.out.println(field.getName());
			 if(field.isAnnotationPresent(FieldMeta.class)){
			     FieldMeta fieldMeta = field.getAnnotation(FieldMeta.class);
			     String str = fieldMeta.name();
			     String description = fieldMeta.description();
			     System.out.println(str);
			     System.out.println(description);
	          }if (field.isAnnotationPresent(FruitName.class)) {
	        	  FruitName fruitName = field.getAnnotation(FruitName.class);
	        	  System.out.println(fruitName.value());
			}else{
	        	  //FruitName fruitName = field.getAnnotation(FruitName.class);
	        	  //System.out.println(fruitName.value());
	          }
		 }
		 
	  }

}
//Output
//obj
//Jason
//
//name
//Andy
//Intersting
//profile
//default_name
//
//Apple


