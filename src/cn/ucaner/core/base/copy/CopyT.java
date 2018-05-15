package cn.ucaner.core.base.copy;

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
* @Package：cn.ucaner.core.base.copy   
* @ClassName：Family   
* @Description：   <p> 深拷贝与浅拷贝 
* {@link https://blog.csdn.net/XIAXIA__/article/details/41652057}
* {@link https://blog.csdn.net/u014727260/article/details/55003402}
* {@link https://blog.csdn.net/baiye_xing/article/details/71788741}
* </p>
* @Author： - Jeff Lee   
* @CreatTime：2018年4月5日 下午1:40:35   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
class Family implements Cloneable{
	
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 深拷贝
     * @return
     */
    /*@Override
    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }*/
}

class Student implements Cloneable{
	
    private String name;
    private Family family;//Family  Cloneable

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    /**
     * 浅拷贝 对其对象的引用却没有拷贝
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * 深拷贝
     */
    /*@Override
    protected Object clone() {
        Student o = null;
        try {
            o = (Student)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        o.family = (Family) family.clone();
        return o;
    }*/
}

public class CopyT {
	
    public static void main(String[] args) throws CloneNotSupportedException {
        Family family = new Family();
        family.setName("Jeff Family obj ");
        Student student1 = new Student();
        student1.setFamily(family);
        student1.setName("Jeff String");

        Student student2 = (Student) student1.clone();//
        student2.setName("Jeff2");
        student2.getFamily().setName("Jeff2 Family");
        System.out.println(student1.getName() + " " + student1.getFamily().getName());
        System.out.println(student2.getName() + " " + student2.getFamily().getName());
       /* Jeff Jeff2 Family
        Jeff2 Jeff2 Family*/
    }
}

//Outputs 
//Jeff String Jeff2 Family
//Jeff2 Jeff2 Family