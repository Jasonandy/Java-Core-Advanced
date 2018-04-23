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
        //search.serch("serch");  
        ServiceLoader<Search> loaders = ServiceLoader.load(Search.class);
        for (Search s : loaders) {
            s.echo();
            String ping = s.ping("Spi");
            System.out.println(ping);
        }
        System.out.println(loaders.toString());
    }    
}
//Output放置位置为src
//HelloWorld!
//Spi  > Hi I'm Spi.
//java.util.ServiceLoader[cn.ucaner.core.spi.Search]


//add other spiImpl Result
//HelloWorld!
//Spi  > Hi I'm Spi.
//cn.ucaner.core.spi.impl.SearchOtherImpl
//Spi  > Hi I'm Other Spi.
//java.util.ServiceLoader[cn.ucaner.core.spi.Search]
