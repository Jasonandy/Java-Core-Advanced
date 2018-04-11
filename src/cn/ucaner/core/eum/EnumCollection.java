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
 * @ClassName：EnumCollection   
 * @Description：   <p> 关于枚举集合的使用</p>
 * @Author： - Jason   
 * @Modify By：   
 * @Modify marker：   
 * @version    V1.0
 */
public class EnumCollection {
	
   public static void main(String[] args) {  
        forEnum();  
        useEnumInJava();  
    }  
  
    /** 
     * 循环枚举,输出ordinal属性；若枚举有内部属性，则也输出。(说的就是我定义的TYPE类型的枚举的typeName属性) 
     */  
    private static void forEnum() {  
        for (SimpleEnum simpleEnum : SimpleEnum.values()) {  
            System.out.println(simpleEnum + "  ordinal  " + simpleEnum.ordinal());  
        }  
        System.out.println("------------------");  
        for (TYPE type : TYPE.values()) {  
            System.out.println("type = " + type + "    type.name = " + type.name() + "   typeName = " + type.getTypeName() + "   ordinal = " + type.ordinal());  
        }  
    }  
  
    /** 
     * 在Java代码使用枚举 
     */  
    private static void useEnumInJava() {  
        String typeName = "f5";  
        TYPE type = TYPE.fromTypeName(typeName);  
        if (TYPE.BALANCE.equals(type)) {  
            System.out.println("根据字符串获得的枚举类型实例跟枚举常量一致");  
        } else {  
            System.out.println("大师兄代码错误");  
        }  
  
    }  
  
    /** 
     * 季节枚举(不带参数的枚举常量)这个是最简单的枚举使用实例 
     * Ordinal 属性，对应的就是排列顺序，从0开始。 
     */  
    private enum SimpleEnum {  
        SPRING,  
        SUMMER,  
        AUTUMN,  
        WINTER  
    }  
  
  
    /** 
     * 常用类型(带参数的枚举常量，这个只是在书上不常见，实际使用还是很多的，看懂这个，使用就不是问题啦。) 
     */  
    private enum TYPE {  
        FIREWALL("firewall"),  
        SECRET("secretMac"),  
        BALANCE("f5");  
  
        private String typeName;  
  
        TYPE(String typeName) {  
            this.typeName = typeName;  
        }  
  
        /** 
         * 根据类型的名称，返回类型的枚举实例。 
         * @param typeName 类型名称 
         */  
        public static TYPE fromTypeName(String typeName) {  
            for (TYPE type : TYPE.values()) {  
                if (type.getTypeName().equals(typeName)) {  
                    return type;  
                }  
            }  
            return null;  
        }  
  
        public String getTypeName() {  
            return this.typeName;  
        }  
    }  
}
