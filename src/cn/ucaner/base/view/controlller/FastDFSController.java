/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年3月13日 下午5:40:43</p>
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
 * @ClassName：FastDFSController   
 * @Description：   <p> FastDFSController </p>
 * @Author： - Jason   
 * @CreatTime：2018年3月13日 下午5:40:43   
 * @Modify By：   
 * @ModifyTime：  2018年3月13日
 * @Modify marker：   
 * @version    V1.0
 */
@Controller
@RequestMapping("/dfs")
public class FastDFSController {
	
	/**
	 * @Description: dfs 页面
	 * @return ModelAndView
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	@RequestMapping("/index")
    public ModelAndView testIndex() {
        ModelAndView model = new ModelAndView("dfs/index");
        return model;
    }

}
