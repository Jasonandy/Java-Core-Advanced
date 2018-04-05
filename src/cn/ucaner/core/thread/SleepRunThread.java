package cn.ucaner.core.thread;

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
* @Package：cn.ucaner.core.thread   
* @ClassName：SleepRunThread   
* @Description：   <p> Thread中start和run的区别</p>
* @Author： - BYSocket   
* @CreatTime：2018年4月5日 下午1:08:01   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class SleepRunThread {
    public static void main(String[] args) {
        System.out.println("当前线程ID => " + Thread.currentThread().getId());

        SRThread t1 = new SRThread("t1");
        t1.start();
        SRThread t2 = new SRThread("t2");
        t2.run();
    }
}
class SRThread extends Thread {
    private String name;

    public SRThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:" + name +", 线程ID => " + Thread.currentThread().getId());
    }
}