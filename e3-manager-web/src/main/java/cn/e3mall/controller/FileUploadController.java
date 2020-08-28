package cn.e3mall.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.ibatis.logging.log4j2.Log4j2AbstractLoggerImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.e3mall.common.utils.FastDFSClient;
import cn.e3mall.common.utils.MapToJsonUtil;

@Controller
public class FileUploadController {
	@Value(value = "${fastdfs_server}")
	private String fastdfs_server;

	@RequestMapping("/pic/upload")
	@ResponseBody
	public String picUpload(MultipartFile uploadFile, String Filename) {
		new Log4JLogger(this.getClass().toString()).debug("start");;
		Map<String, Object> resMap = new HashMap<>();
		MapToJsonUtil mapToJsonUtil = new MapToJsonUtil();
		try {
			FastDFSClient fscClient = new FastDFSClient("classpath:conf/client.conf");
			String fullname = uploadFile.getOriginalFilename();
			String extName = fullname.substring(fullname.indexOf(".") + 1);
			String url = fscClient.uploadFile(uploadFile.getBytes(), extName);
			url = fastdfs_server + url;
			resMap.put("error", 0);
			resMap.put("url", url);

			return mapToJsonUtil.toJsonString(resMap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			resMap.put("error", 1);
			resMap.put("message", "图片上传失败");
			return mapToJsonUtil.toJsonString(resMap);
		}

	}

}
