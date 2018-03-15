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

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.ucaner.fastdfs.data.RespBody;
import cn.ucaner.fastdfs.data.RespBody.Status;

import com.alibaba.fastjson.JSONArray;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;

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
	
	private static Logger logger = LoggerFactory.getLogger(FastDFSController.class);
	
	@Autowired
    FastFileStorageClient fastFileStorageClient;
	
	
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
	
	/**
	 * @Description: uploadFile SpringBean 的方式管理fastDFS 上传
	 * <p> Based on com.github.tobato.fastdfs.service    from github.</p>
	 * @param fileName
	 * @param request
	 * @return RespBody
	 * @Autor: Jason - jsonandy@hotmail.com
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public RespBody uploadFile(@RequestParam MultipartFile fileName,HttpServletRequest request) {
		logger.info("(Tech by fastDFS)Starting upload file ...");
		JSONArray resultUpload =null;
		try {
			InputStream fis = fileName.getInputStream();
			StorePath uploadFile = fastFileStorageClient.uploadFile("Jason", fis, fileName.getSize(), ".test");
			logger.info("上传成功,{} 为全路径！",uploadFile.getFullPath());
			logger.info("上传成功-{} 为path路径！",uploadFile.getPath());
			//group1/M00/00/00/Q9qeiVqqIMGAVvaVAAEQAJ-8krY7
		} catch (Exception e) {
			logger.info("(Tech by fastDFS)Starting upload file exception erro ...,e:{}", e);
			return new RespBody(Status.ERROR);
		}
		return new RespBody(Status.OK,resultUpload,"fastDFS上传成功!");
	}

}
