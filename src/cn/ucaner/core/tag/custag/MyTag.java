/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational </p>
 *  <p> All rights reserved.</p>
 *  <p> Created on 2018年5月5日 下午3:11:25</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.tag.custag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

/**     
* @Package：cn.ucaner.core.tag.custag   
* @ClassName：MyTag   
* @Description：   <p> MyTag </p>
* @Author： - Jason   
* @CreatTime：2018年5月5日 下午3:11:25   
* @Modify By：   
* @ModifyTime：  2018年5月5日
* @Modify marker：   
* @version    V1.0
*/
public class MyTag extends TagSupport{

	private static final long serialVersionUID = -1072447572747287532L;

	private PageContext pageContext;
	
    @Override
    public void setPageContext(PageContext pageContext) {
        this.pageContext=pageContext;
    }
    
    @Override
    public int doStartTag() throws JspException {
    	try {
    		pageContext.getResponse().getWriter().write("This is My Customer Tag Just for test By Jason!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return super.doStartTag();
    }
}
