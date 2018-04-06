package cn.ucaner.core.base.inter;

import java.util.Arrays;

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
* @Package：cn.ucaner.core.base.inter   
* @ClassName：Processor   
* @Description：   <p> 不使用接口的接口案例</p>
* @Author： - Jeff Lee   
* @CreatTime：2018年4月5日 下午1:40:58   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
class Processor {
    public String name(){
        return getClass().getSimpleName();
    }

    Object process(Object input){return input;}
}

class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Splitcase extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class ApplyClass {
    public static void process(Processor p , Object input){
        System.out.println("调用对象名：" + p.name());
        System.out.println(p.process(input));
    }

    public static String s = "BYSocket's Blog is www.bysocket.com";
    public static void main(String[] args) {
        process(new Upcase(),s);
        process(new Splitcase(),s);
    }
}
