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
* @ClassName：WildcardClassReferences   
* @Description：   <p> WildcardClassReferences </p>
* @Author： - Jason   
* @CreatTime：2018年10月18日 下午10:08:37   
* @Modify By：   
* @ModifyTime：  2018年10月18日
* @Modify marker：   
* @version    V1.0
 */
public class WildcardClassReferences {
    public static void main(String[] args) {
        Class<?> intClass = int.class;
        intClass = double.class;
    }
} ///:~
