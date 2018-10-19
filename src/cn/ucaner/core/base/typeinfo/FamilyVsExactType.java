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
* @ClassName：FamilyVsExactType   
* @Description：   <p> The difference between instanceof and class. </p>
* @Author： - Jason   
* @CreatTime：2018年10月18日 下午10:06:44   
* @Modify By：   
* @ModifyTime：  2018年10月18日
* @Modify marker：   
* @version    V1.0
 */
public class FamilyVsExactType {
    static void test(Object x) {
        System.out.println("Testing x of type " + x.getClass());
        System.out.println("x instanceof Base " + (x instanceof Base));
        System.out.println("x instanceof Derived " + (x instanceof Derived));
        System.out.println("Base.isInstance(x) " + Base.class.isInstance(x));
        System.out.println("Derived.isInstance(x) "
                + Derived.class.isInstance(x));
        System.out.println("x.getClass() == Base.class "
                + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Derived.class "
                + (x.getClass() == Derived.class));
        System.out.println("x.getClass().equals(Base.class)) "
                + (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Derived.class)) "
                + (x.getClass().equals(Derived.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        test(new Derived());
    }
}

class Base {
}

class Derived extends Base {
}
/* Output:
Testing x of type class typeinfo.Base
x instanceof Base true
x instanceof Derived false
Base.isInstance(x) true
Derived.isInstance(x) false
x.getClass() == Base.class true
x.getClass() == Derived.class false
x.getClass().equals(Base.class)) true
x.getClass().equals(Derived.class)) false
Testing x of type class typeinfo.Derived
x instanceof Base true
x instanceof Derived true
Base.isInstance(x) true
Derived.isInstance(x) true
x.getClass() == Base.class false
x.getClass() == Derived.class true
x.getClass().equals(Base.class)) false
x.getClass().equals(Derived.class)) true
*///:~
