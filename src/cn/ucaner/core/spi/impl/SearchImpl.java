/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.spi.impl;

import java.util.List;

import cn.ucaner.core.spi.Search;

/**     
 * @Package：cn.ucaner.core.spi.impl   
 * @ClassName：SearchImpl   
 * @Description：   <p> SearchImpl spi 接口的具体实现 </p>
 * @Author： - Jason   
 * @Modify By：   
 * @Modify marker：   
 * @version    V1.0
 */
public class SearchImpl implements Search{

	@Override
	public List<?> serch(String keyword) {
		return null;
	}

	@Override
	public void echo() {
		System.out.println("HelloWorld!");
	}

}
