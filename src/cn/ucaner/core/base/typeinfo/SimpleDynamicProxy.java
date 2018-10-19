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
package cn.ucaner.core.base.typeinfo;//: typeinfo/SimpleDynamicProxy.java

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
* @Package：cn.ucaner.core.base.typeinfo   
* @ClassName：DynamicProxyHandler   
* @Description：   <p> DynamicProxyHandler </p>
* @Author： - Jason   
* @CreatTime：2018年10月18日 下午10:08:18   
* @Modify By：   
* @ModifyTime：  2018年10月18日
* @Modify marker：   
* @version    V1.0
 */
class DynamicProxyHandler implements InvocationHandler {
    private Object proxied;

    public DynamicProxyHandler(Object proxied) {
        this.proxied = proxied;
    }

    public Object
    invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("**** proxy: " + proxy.getClass().getSimpleName() +
                ", method: " + method + ", args: " + args);
        if (args != null) {
            for (Object arg : args)
                System.out.println("  " + arg);
        }
        return method.invoke(proxied, args);
    }
}

class SimpleDynamicProxy {
    public static void consumer(Interface iface) {
        iface.doSomething();
        iface.somethingElse("bonobo");
    }

    public static void main(String[] args) {
        RealObject real = new RealObject();
        consumer(real);
        // Insert a proxy and call again:
        Interface proxy = (Interface) Proxy.newProxyInstance(
                Interface.class.getClassLoader(),
                new Class[] {Interface.class},
                new DynamicProxyHandler(real));
        consumer(proxy);
    }
}
/* Output: (95% match)
doSomething
somethingElse bonobo
**** proxy: $Proxy0, method: public abstract void com.brianway.learning.java.base.typeinfo.Interface.doSomething(), args: null
doSomething
**** proxy: $Proxy0, method: public abstract void com.brianway.learning.java.base.typeinfo.Interface.somethingElse(java.lang.String), args: [Ljava.lang.Object;@d716361
  bonobo
somethingElse bonobo
*///:~
