/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年3月13日 下午4:24:08</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.base.view.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**     
 * @Package：cn.ucaner.base.view.controlller   
 * @ClassName：CommonController   
 * @Description：   <p> 通用视图控制器</p>
 * @Author： - Jason   
 * @CreatTime：2018年3月13日 下午4:24:08   
 * @Modify By：   
 * @ModifyTime：  2018年3月13日
 * @Modify marker：   
 * @version    V1.0
 */
@Controller
@RequestMapping("/test")
public class CommonController {
	
	/**
	 * @Description: 测试路由跳转页面
	 * @return ModelAndView
	 * @Autor: Jason - wub@sun309.com
	 */
	@RequestMapping("/index")
    public ModelAndView testIndex() {
        ModelAndView model = new ModelAndView("test/index");
        return model;
    }
	

}
