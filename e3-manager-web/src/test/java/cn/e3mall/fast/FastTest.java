package cn.e3mall.fast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

public class FastTest {
	@Test
	public void testFast() throws FileNotFoundException, IOException, MyException {

		ClientGlobal.init("E:/workspace/e3-manager-web/src/main/resources/conf/client.conf");
		TrackerClient tClient = new TrackerClient();
		TrackerServer tServer = tClient.getConnection();
		StorageServer storageServer = null;
		StorageClient sClient = new StorageClient(tServer, storageServer);

		NameValuePair str = new NameValuePair("name", "meinv");
		NameValuePair str1 = new NameValuePair("nihao", "nihao");

		NameValuePair[] metalist = { str, str1 };
		String[] upload_file = sClient.upload_file("E:/用户文件/Download/620833cf70166d256821f3a3c3c4fab6.mp4", "mp4",
				metalist);

		for (int i = 0; i < upload_file.length; i++) {
			System.out.println(upload_file[i]);
		}
	}

}
