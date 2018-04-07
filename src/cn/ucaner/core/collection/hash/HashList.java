package cn.ucaner.core.collection.hash;

import java.util.ArrayList;
import java.util.List;

/**
* @Package：cn.ucaner.core.collection.hash   
* @ClassName：HashList   
* @Description：   <p> HashList</p>
* @Author： - bysocket   
* @CreatTime：2018年4月5日 下午12:45:22   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class HashList {

	public static void main(String[] args) {
    	// init data list
        List<SkuObj> reqSkuObjList = new ArrayList<>();
        List<SkuObj> existSkuObjList = new ArrayList<>();
        for (int i = 0 ; i < 1000; i++) {
            SkuObj skuObj = new SkuObj();
            skuObj.setId(i);
            skuObj.setName("name" + i);
            skuObj.setAge(i + 666);
            skuObj.setDesc("desc" + i);
            reqSkuObjList.add(skuObj);
        }

        for (int i = 0 ; i < 1000; i++) {
            SkuObj skuObj = new SkuObj();
            skuObj.setId(i);
            skuObj.setName("nameexist" + i);
            skuObj.setAge(i + 888);
            skuObj.setDesc("descexist" + i);
            existSkuObjList.add(skuObj);
        }
        
       // System.out.println(JSON.toJSONString(reqSkuObjList));
       // System.out.println(JSON.toJSONString(existSkuObjList));
        
    }
}
