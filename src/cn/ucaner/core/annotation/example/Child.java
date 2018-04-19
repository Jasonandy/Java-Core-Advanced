/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.annotation.example;

/**     
 * @Package：cn.ucaner.core.annotation.example   
 * @ClassName：Child   
 * @Description：   <p> Child </p>
 * @Author： - Jason   
 * @CreatTime：2018年4月19日 下午3:27:42   
 * @Modify By：   
 * @ModifyTime：  2018年4月19日
 * @Modify marker：   
 * @version    V1.0
 */
public class Child implements People{

	@Override
	public String name() {
		return null;
	}

	public int age() {
		return 0;
	}

	@Deprecated
	@Override
	public void work() {
		
	}

}
