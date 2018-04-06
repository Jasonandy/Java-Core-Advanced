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
* @ClassName：ProcessorInter   
* @Description：   <p> 使用接口的接口案例</p>
* @Author： - Jeff Lee   
* @CreatTime：2018年4月5日 下午1:41:21   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
interface ProcessorInter {
	
    String name();
    Object process(Object input);
}

// implement 1 
class UpcaseImpl implements ProcessorInter {
   
	@Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

// implement 2 
class SplitcaseImpl implements ProcessorInter {
    @Override
    public String name() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class ApplyInter {
	
    public static void process(ProcessorInter p , Object input){
        System.out.println("调用对象名：" + p.name());
        System.out.println(p.process(input));
    }

    public static String s = "My test website is javacore.ucaner.cn . just test for Jason.";
    
    public static void main(String[] args) {
        process(new UpcaseImpl(),s);//转换为大写
        process(new SplitcaseImpl(),s);//转换为数组
       /*   调用对象名：UpcaseImpl
        	MY TEST WEBSITE IS JAVACORE.UCANER.CN . JUST TEST FOR JASON.
        	调用对象名：SplitcaseImpl
            [My, test, website, is, javacore.ucaner.cn, ., just, test, for, Jason.]*/
    }
}
