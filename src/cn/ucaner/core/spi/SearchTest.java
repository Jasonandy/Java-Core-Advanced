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

import java.util.ServiceLoader;

/**     
 * @Package：cn.ucaner.core.spi   
 * @ClassName：SearchTest   
 * @Description：   <p> SearchTest</p>
 * @Author： - Jason   
 * @Modify By：   
 * @Modify marker：   
 * @version    V1.0
 */
public class SearchTest {

	public static void main(String[] args) {    
        //Search search = SearchFactory.newSearch();    
        //search.serch("cn.ucaner.core.spi.SearchTest");  
        ServiceLoader<Search> loaders = ServiceLoader.load(Search.class);
        for (Search s : loaders) {
            s.echo();
        }
    }    
}
