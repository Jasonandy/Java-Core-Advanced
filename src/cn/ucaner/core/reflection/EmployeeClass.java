package cn.ucaner.core.reflection;

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
* @Package：cn.ucaner.core.reflection   
* @ClassName：Employee   
* @Description：   <p> 反射在继承中的案例</p>
* @Author： - Jeff Lee   
* @CreatTime：2018年4月5日 下午1:02:00   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
class Employee {
    private String name;
    public Employee(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }
}
public class EmployeeClass {
    public static void main(String[] args) {
        Employee employee = new Employee("Jeff");
        Employee manager = new Manager("Boss");
        System.out.println(employee.getClass().getName() + " " + employee.getName());
        System.out.println(manager.getClass().getName() + " " + manager.getName());
    }
}
