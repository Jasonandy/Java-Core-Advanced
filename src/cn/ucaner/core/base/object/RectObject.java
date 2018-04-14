/**
 *<html>
 * <body>
 *  <P> Copyright 1994-2018 JasonInternational</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 *</html>
 */
package cn.ucaner.core.base.object;

import java.util.HashSet;

/**
* @Package：cn.ucaner.core.base.object   
* @ClassName：RectObject   
* @Description：   <p> hashCode equals
* </br> {@link https://blog.csdn.net/jiangwei0910410003/article/details/22739953 }
* equals()和hashCode()方法是用来在同一类中做比较用的，尤其是在容器里如set存放同一类对象时用来判断放入的对象是否重复。
* 
* tips： equals()相等的两个对象，hashcode()一定相等，equals()不相等的两个对象，却并不能证明他们的hashcode()不相等。
* 
* Java系统首先调用对象的hashCode()方法获得该对象的哈希码表，然后根据哈希吗找到相应的存储区域，最后取得该存储区域内的每个元素与该对象进行equals方法比较
* 
* </p>
* @Author： - Jason   
* @ModifyTime：  2018年4月14日
* @version    V1.0
 */
public class RectObject {
	
	
	public int x;  
	
    public int y; 
    
    
    public RectObject(int x,int y){  
        this.x = x;  
        this.y = y;  
    }  
    
    
    @Override  
    public int hashCode(){  
        final int prime = 31;  
        int result = 1;  
        result = prime * result + x;  
        result = prime * result + y;  
        return result;  
    } 
    
    @Override  
    public boolean equals(Object obj){  
        if(this == obj)  
            return true;  
        if(obj == null)  
            return false;  
        if(getClass() != obj.getClass())  
            return false;
        
        final RectObject other = (RectObject)obj;  
        
        if(x != other.x){  
            return false;  
        }  
        if(y != other.y){  
            return false;  
        }  
        return true;  
    }  
    
    /**
     * @Description: Just for test equals and hashCode
     * @Autor: Jason - jasonandy@hotamil.com
     */
    public static void main(String[] args){  
        HashSet<RectObject> set = new HashSet<RectObject>();  
        RectObject r1 = new RectObject(3,3);  
        RectObject r2 = new RectObject(5,5);  
        RectObject r3 = new RectObject(3,3);  
        set.add(r1);  
        set.add(r2);  
        set.add(r3);  
        set.add(r1);  
        System.out.println("size:"+set.size());  
    }  
}
