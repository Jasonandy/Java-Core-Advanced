package cn.ucaner.fastdfs.test;

import static org.junit.Assert.assertEquals;

import org.apache.commons.configuration.ConfigurationException;
import org.junit.Test;

import cn.ucaner.fastdfs.FastdfsClientConfig;

/**
* @Package：cn.ucaner.fastdfs.test   
* @ClassName：FastdfsClientConfigTest   
* @Description：   <p> FastdfsClientConfigTest</p>
* @Author： - DaoDou   
* @CreatTime：2018年3月14日 上午10:33:37   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class FastdfsClientConfigTest {

	@Test
	public void testFastdfsClientConfigString() throws ConfigurationException {
		FastdfsClientConfig fastdfsClientConfig = new FastdfsClientConfig("dfs/fastDFSClient.properties");
		assertEquals(5*1000, fastdfsClientConfig.getConnectTimeout());
		assertEquals(30*1000,fastdfsClientConfig.getNetworkTimeout());
	}

}
