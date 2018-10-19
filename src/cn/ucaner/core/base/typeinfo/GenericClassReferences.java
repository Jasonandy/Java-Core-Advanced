/*
 * Copyright [1994] [Jason - https://github.com/Jasonandy/patterns ]
 * 
 * ************** Author Jason - jasonandy@hotmail.com ************
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
package cn.ucaner.core.base.typeinfo;

/**
* @Package：cn.ucaner.core.base.typeinfo   
* @ClassName：GenericClassReferences   
* @Description：   <p> GenericClassReferences </p>
* @Author： - Jason   
* @CreatTime：2018年10月18日 下午10:07:59   
* @Modify By：   
* @ModifyTime：  2018年10月18日
* @Modify marker：   
* @version    V1.0
 */
public class GenericClassReferences {
	
    public static void main(String[] args) {

        Class<Integer> genericIntClass = int.class;
        genericIntClass = Integer.class; // Same thing

        Class intClass = int.class;
        intClass = double.class;
        // genericIntClass = double.class; // Illegal

        System.out.println(int.class == Integer.class);
    }
} ///:~
