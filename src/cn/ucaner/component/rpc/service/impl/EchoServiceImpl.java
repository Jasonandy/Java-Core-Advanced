package cn.ucaner.component.rpc.service.impl;

import cn.ucaner.component.rpc.service.EchoService;

/**
* @Package：cn.ucaner.component.rpc.service.impl   
* @ClassName：EchoServiceImpl   
* @Description：   <p> 服务Echo实现类 </p>
* @Author： - Jason   
* @CreatTime：2018年4月5日 下午12:07:17   
* @Modify By：   
* @ModifyTime：  2018年4月5日
* @Modify marker：   
* @version    V1.0
 */
public class EchoServiceImpl implements EchoService {
    
	
	@Override
    public String echo(String ping) {
		
        return ping != null ? ping + " --> I am ok." : "I am ok.";
    }
	
	
}
