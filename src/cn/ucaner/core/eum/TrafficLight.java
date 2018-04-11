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
 * @ClassName：TrafficLight   
 * @Description：   <p> 枚举类的使用  swith</p>
 * @Author： - Jason   
 * @Modify By：   
 * @Modify marker：   
 * @version    V1.0
 */
public class TrafficLight {
	
	//JDK1.6之前的switch语句只支持int,char,enum类型，使用枚举，能让我们的代码可读性更强。
	
    Signal color = Signal.RED;  
    public void change() {  
        switch (color) {  
        case RED:  
            color = Signal.GREEN;  
            break;  
        case YELLOW:  
            color = Signal.RED;  
            break;  
        case GREEN:  
            color = Signal.YELLOW;  
            break;  
        }  
    }  
}

enum Signal {  
    GREEN, YELLOW, RED  
}  
