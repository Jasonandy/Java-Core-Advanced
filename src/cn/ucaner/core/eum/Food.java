/**
 * <html>
 * <body>
 *  <P> Copyright 1994 - 2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.core.eum;

/**
* @Package：cn.ucaner.core.eum   
* @ClassName：Food   
* @Description：   <p> 使用接口组织枚举 </p>
* @Author： - Jason   
* @Modify By：   
* @Modify marker：   
* @version    V1.0
 */
public interface Food {

    enum Coffee implements Food{  
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO  
    }  
    
    enum Dessert implements Food{  
        FRUIT, CAKE, GELATO  
    } 
    
	    
}


