package cn.ucaner.core.base.String; 


/*
 * Copyright [2015] [Jeff Lee]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
* @Package：cn.ucaner.core.base.String   
* @ClassName：StringT2   
* @Description：   <p>  对象含有String作为方法参数传递</p>
* @Author： - BYSocket   
* @CreatTime：2018年4月5日 下午1:42:29   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class StringT2 {

    public static void main(String[] args) {
        StringObject sb = new StringObject();
        sb.setName("123");
        change(sb);
        System.out.println(sb.getName());//123
        changeObj(sb);
        System.out.println(sb.getName());//123  
        StringObject changeObj = changeObj(sb);
        System.out.println(changeObj.getName());//789
    }

    /**
     * 
     * @Description: 浅copy
     * @param sb void
     */
    public static void change(StringObject sb) {
        sb = new StringObject();//
        sb.setName("456");
    }
    
    public static StringObject changeObj(StringObject sb) {
        sb = new StringObject();//
        sb.setName("789");
        return sb;
    }

}


class StringObject {
	
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}