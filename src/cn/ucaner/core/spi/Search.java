/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.spi;

import java.util.List;

/**     
 * @Package：cn.ucaner.core.spi   
 * @ClassName：Search   
 * @Description：   <p> Search   spi学习</p>
 * @Author： - Jason   
 * @Modify By：   
 * @ModifyTime：  2018年4月23日
 * @Modify marker：   
 * @version    V1.0
 */
public interface Search {

	public List<?> serch(String keyword);
	
	void echo();
}
