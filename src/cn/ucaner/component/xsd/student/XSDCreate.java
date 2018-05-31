/**
 * <html>
 * <body>
 *  <P> Copyright 1994 JsonInternational</p>
 *  <p> All rights reserved.  - https://github.com/Jasonandy/Java-Core-Advanced </p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.component.xsd.student;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;  
import javax.xml.bind.JAXBException;  
import javax.xml.bind.SchemaOutputResolver;  
import javax.xml.transform.Result;  
import javax.xml.transform.stream.StreamResult;  

/**     
* @Package：cn.ucaner.component.xsd.student   
* @ClassName：XSDCreate   
* @Description：   <p> XSDCreate </p>
* @Author： - Jason   
* @CreatTime：2018年5月31日 上午9:16:48   
* @Modify By：   
* @ModifyTime：  2018年5月31日
* @Modify marker：   
* @version    V1.0
*/
public class XSDCreate {
	
	/**
	 * 自定义约束解析器 
	 */
	public CustomSchemaOutputResolver resolver;  
	  
    public static void main(String[] args) {
    	
    	@SuppressWarnings("rawtypes")
  		Class[] classes = { Student.class };  
        XSDCreate xsdCreate = new XSDCreate();  
        xsdCreate.resolver = xsdCreate.new CustomSchemaOutputResolver("resources/xsd", "student.xsd");  
      
        xsdCreate.createXSD(classes);  
  
        System.out.println("Yes Create Xsd success . by Jason.");  
    }  
  
    public void createXSD(@SuppressWarnings("rawtypes") Class[] classes) {  
        try {  
            JAXBContext context = JAXBContext.newInstance(classes);  
            context.generateSchema(resolver);  
        } catch (JAXBException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
  
    /**
    * @Package：cn.ucaner.component.xsd.student   
    * @ClassName：CustomSchemaOutputResolver   
    * @Description：   <p> CustomSchemaOutputResolver  解析器 </p>
    * @Author： - Jason   
    * @CreatTime：2018年5月31日 上午9:33:58   
    * @Modify By：   
    * @ModifyTime：  2018年5月31日
    * @Modify marker：   
    * @version    V1.0
     */
    public class CustomSchemaOutputResolver extends SchemaOutputResolver {  
  
        private File file;  
  
        public CustomSchemaOutputResolver(String dir, String fileName) {  
            try {  
                file = new File(dir, fileName);  
                if (!file.exists()) {  
                    file.createNewFile();  
                }  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
  
        @Override  
        public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException { 
        	
            return new StreamResult(file);  
        }  
  
    }  

}
