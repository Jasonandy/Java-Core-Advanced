/**
 * <html>
 * <body>
 *  <P> Copyright 1994-2018. JasonInternational.</p>
 *  <p> All rights reserved.</p>
 *  <p> Created by Jason</p>
 *  </body>
 * </html>
 */
package cn.ucaner.fastdfs;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

import cn.ucaner.fastdfs.client.StorageClient;
import cn.ucaner.fastdfs.client.StorageClientFactory;
import cn.ucaner.fastdfs.client.TrackerClient;
import cn.ucaner.fastdfs.client.TrackerClientFactory;

/**
* @Package：cn.ucaner.fastdfs   
* @ClassName：FastdfsClientFactory   
* @Description：   <p> FastdfsClientFactory</p>
* @Author： - Jason   
* @CreatTime：2018年3月14日 上午10:34:24   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class FastdfsClientFactory {
	
	private static volatile FastdfsClient fastdfsClient;

	public static FastdfsClient getFastdfsClient(List<String> trackerAddrs){
		FastdfsClientConfig config = new FastdfsClientConfig();
		config.setTrackerAddrs(trackerAddrs);
		return getFastdfsClient(new FastdfsClientConfig());
	}
	
	public static FastdfsClient getFastdfsClient(String configFileName) throws ConfigurationException{
		FastdfsClientConfig config = new FastdfsClientConfig(configFileName);
		return getFastdfsClient(config);
	}
	
	public static FastdfsClient getFastdfsClient(FastdfsClientConfig config){
		if (fastdfsClient == null) {
			synchronized (FastdfsClient.class) {
				if (fastdfsClient == null) {
					int connectTimeout = config.getConnectTimeout();
					int networkTimeout = config.getNetworkTimeout();
					TrackerClientFactory trackerClientFactory = new TrackerClientFactory(connectTimeout, networkTimeout);
					StorageClientFactory storageClientFactory = new StorageClientFactory(connectTimeout, networkTimeout);
					GenericKeyedObjectPoolConfig trackerClientPoolConfig = config.getTrackerClientPoolConfig();
					GenericKeyedObjectPoolConfig storageClientPoolConfig = config.getStorageClientPoolConfig();
					GenericKeyedObjectPool<String,TrackerClient> trackerClientPool = new GenericKeyedObjectPool<>(trackerClientFactory, trackerClientPoolConfig);
					GenericKeyedObjectPool<String,StorageClient> storageClientPool = new GenericKeyedObjectPool<>(storageClientFactory, storageClientPoolConfig);
					List<String> trackerAddrs = config.getTrackerAddrs();
					fastdfsClient = new FastdfsClientImpl(trackerAddrs,trackerClientPool,storageClientPool);
				}
			}
		}
		return fastdfsClient;
	}
	
}
