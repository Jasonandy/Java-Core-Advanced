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

package cn.ucaner.core.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @Package：cn.ucaner.core.thread   
* @ClassName：FixedThreadPool   
* @Description：   <p> 线程池FixedThreadPool的简单使用-启动LiftOff线程{@link LiftOff}</p>
* @Author： - Jeff Lee   
* @CreatTime：2018年4月5日 下午1:14:14   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class FixedThreadPool {
	
    public static void main(String[] args) {
        // 创建固定线程为5的线程池
        ExecutorService exec = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5 ;i++) {
            exec.execute(new LiftOff());// 由线程池Ececutor决定执行给定的线程。
            // 顺序关闭，执行以前提交的线程，不接受新的线程。
            exec.shutdown();
        }
    }
}
