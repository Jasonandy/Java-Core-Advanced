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

import java.util.Iterator;
import java.util.ServiceLoader;

/**     
 * @Package：cn.ucaner.core.spi   
 * @ClassName：SearchFactory   
 * @Description：   <p> SearchFactory</p>
 * @Author： - Jason   
 * @Modify By：   
 * @ModifyTime：  2018年4月23日
 * @Modify marker：   
 * @version    V1.0
 */
public class SearchFactory {

    public static Search newSearch() {    
        Search search = null;    
        ServiceLoader<Search> serviceLoader = ServiceLoader.load(Search.class);    
        Iterator<Search> searchs = serviceLoader.iterator();    
        if (searchs.hasNext()) {    
            search = searchs.next();    
        }    
        return search;    
    }
    
    private SearchFactory() {}
}
