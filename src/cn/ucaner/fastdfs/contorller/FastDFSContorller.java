/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs.contorller;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;

import cn.ucaner.fastdfs.data.RespBody;
import cn.ucaner.fastdfs.data.RespBody.Status;
import cn.ucaner.fastdfs.file.FastDFSFile;
import cn.ucaner.fastdfs.file.client.FastDFSClient;

/**     
 * @Package：cn.ucaner.fastdfs   
 * @ClassName：FastDFSContorller   
 * @Description：   <p> fastDFS 分布式文件上传下载控制类</p>
 * @Author： - Jason   
 * @CreatTime：2018年3月14日 下午2:10:25   
 * @Modify By：   
 * @ModifyTime：  2018年3月14日
 * @Modify marker：   
 * @version    V1.0
 */
@Controller
@RequestMapping("/file")
public class FastDFSContorller {
	
	
	private static Logger logger = LoggerFactory.getLogger(FastDFSContorller.class);
	
	/**
	 * @Description: dfs 页面
	 * @return ModelAndView
	 * @Autor: Jason - jasonandy@hotmail.com
	 */
	@RequestMapping("/uploadPage")
    public ModelAndView testIndex() {
        ModelAndView model = new ModelAndView("dfs/uploadPage");
        return model;
    }
	
	/**
	 * @Description: 上传接口
	 * @param request
	 * @return RespBody
	 * @Autor: DaoDou - wub@sun309.com
	 */
	@ResponseBody
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public RespBody uploadFile(@RequestParam MultipartFile fileName,HttpServletRequest request) {
		logger.info("(Tech by fastDFS)Starting upload file ...");
		JSONArray resultUpload =null;
		try {
			InputStream fis = fileName.getInputStream();
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] cache = new byte[4096];
			while (fis.read(cache) != -1) {
				bos.write(cache);
			}
			fis.close();
			//文件全名
			String originalFilename = fileName.getOriginalFilename();
			//获取扩展名
			String ext =originalFilename.substring(originalFilename.lastIndexOf(".")+1);
			FastDFSFile fastDFSFile = new FastDFSFile();
			fastDFSFile.setContent(bos.toByteArray());
			fastDFSFile.setExt(ext);
			
		    resultUpload = FastDFSClient.upload(fastDFSFile);
			
		} catch (Exception e) {
			logger.info("(Tech by fastDFS)Starting upload file exception erro ...,e:{}", e);
			return new RespBody(Status.ERROR);
		}
		return new RespBody(Status.OK,resultUpload,"fastDFS上传成功!");
	}

}
