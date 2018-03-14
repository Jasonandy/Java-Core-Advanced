package cn.ucaner.fastdfs.test.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import org.junit.Test;

import cn.ucaner.fastdfs.client.TrackerClient;
import cn.ucaner.fastdfs.client.TrackerClientImpl;
import cn.ucaner.fastdfs.data.GroupInfo;
import cn.ucaner.fastdfs.data.Result;
import cn.ucaner.fastdfs.data.UploadStorage;

/**
* @Package：cn.ucaner.fastdfs.test.client   
* @ClassName：TrackerClientTest   
* @Description：   <p> TrackerClientTest</p>
* @Author： - DaoDou   
* @CreatTime：2018年3月14日 上午10:33:26   
* @Modify By：   
* @ModifyTime：  2018年3月14日
* @Modify marker：   
* @version    V1.0
 */
public class TrackerClientTest {

	@Test
	public void testGetUploadStorageAddr() throws NumberFormatException, UnknownHostException, IOException {
		TrackerClient trackerClient = new TrackerClientImpl("67.218.158.137:22122");
		Result<UploadStorage> result = trackerClient.getUploadStorage();
		assertEquals(0, result.getCode());
		assertEquals("67.218.158.137:23000",result.getData().getAddress());
		trackerClient.close();
	}
	
	@Test
	public void testGetDownloadStorageAddr() throws IOException {
		TrackerClient trackerClient = new TrackerClientImpl("67.218.158.137:22122");
		Result<String> result = trackerClient.getDownloadStorageAddr("group1","M00/00/00/Cn2wilM00puAa0xSAANVQ4eIxAM143.jpg");
		assertEquals(0, result.getCode());
		assertEquals("67.218.158.137:23000",result.getData());
		trackerClient.close();
	}
	
	@Test
	public void testGetUpdateStorageAddr() throws IOException {
		TrackerClient trackerClient = new TrackerClientImpl("10.125.176.138:22122");
		Result<String> result = trackerClient.getUpdateStorageAddr("group1","M00/00/00/Cn2wilM00puAa0xSAANVQ4eIxAM143.jpg");
		assertEquals(0, result.getCode());
		assertEquals("10.125.176.138:23000",result.getData());
		trackerClient.close();
	}
	
	@Test
	public void testGetGroupInfos() throws NumberFormatException, UnknownHostException, IOException{
		TrackerClient trackerClient = new TrackerClientImpl("10.125.176.138:22122");
		Result<List<GroupInfo>> groupInfos = trackerClient.getGroupInfos();
		assertNotNull(groupInfos);
		trackerClient.close();
	}
}
