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

class Building {
}

class House extends Building {
}

/**
* @Package：cn.ucaner.core.base.typeinfo   
* @ClassName：ClassCasts   
* @Description：   <p> ClassCasts </p>
* @Author： - Jason   
* @CreatTime：2018年10月18日 下午10:03:12   
* @Modify By：   
* @ModifyTime：  2018年10月18日
* @Modify marker：   
* @version    V1.0
 */
public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        h = (House) b; // ... or just do this.

        try {
            Class<House> hClass = House.class;
            //Produces exact type
            House house = hClass.newInstance();
            Class<? super House> up = hClass.getSuperclass();
            // won't compile:
            //Class<Building> up2 = hClass.getSuperclass();

            //Only produces Object
            Object obj = up.newInstance();

            System.out.println(house);
            System.out.println(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
} ///:~
//Outputs
//cn.ucaner.core.base.typeinfo.House@7852e922
//cn.ucaner.core.base.typeinfo.Building@4e25154f