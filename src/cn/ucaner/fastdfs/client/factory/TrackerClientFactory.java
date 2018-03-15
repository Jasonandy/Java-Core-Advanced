/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs.client.factory;

import java.io.IOException;

import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import cn.ucaner.fastdfs.FastdfsClientConfig;
import cn.ucaner.fastdfs.client.TrackerClient;
import cn.ucaner.fastdfs.client.impl.TrackerClientImpl;

/**
* @Package：cn.ucaner.fastdfs.client   
* @ClassName：TrackerClientFactory   
* @Description：   <p> TrackerClientFactory TrackerClient工厂类 </p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午9:28:32   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class TrackerClientFactory implements KeyedPooledObjectFactory<String,TrackerClient> {
	
	private Integer connectTimeout = FastdfsClientConfig.DEFAULT_CONNECT_TIMEOUT * 1000;
	private Integer networkTimeout = FastdfsClientConfig.DEFAULT_NETWORK_TIMEOUT * 1000;

	public TrackerClientFactory() {
		super();
	}
	
	public TrackerClientFactory(Integer connectTimeout, Integer networkTimeout) {
		super();
		this.connectTimeout = connectTimeout;
		this.networkTimeout = networkTimeout;
	}

	/**
	 * 创建对象
	 */
	@Override
	public PooledObject<TrackerClient> makeObject(String key){
		TrackerClient trackerClient = new TrackerClientImpl(key,connectTimeout,networkTimeout);
		PooledObject<TrackerClient> pooledTrackerClient = new DefaultPooledObject<TrackerClient>(trackerClient);
		return pooledTrackerClient;
	}

	/**
	 * 销毁对象
	 */
	@Override
	public void destroyObject(String key, PooledObject<TrackerClient> pooledTrackerClient) throws IOException{
		TrackerClient trackerClient = pooledTrackerClient.getObject();
		trackerClient.close();
	}

	/**
	 * 校验
	 */
	@Override
	public boolean validateObject(String key, PooledObject<TrackerClient> p) {
		return true;
	}

	/**
	 * 激活
	 */
	@Override
	public void activateObject(String key, PooledObject<TrackerClient> p)
			throws Exception {
		
	}

	
	@Override
	public void passivateObject(String key, PooledObject<TrackerClient> p)
			throws Exception {
		
	}

}
