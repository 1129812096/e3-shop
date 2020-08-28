package cn.e3mall.common.utils;

import java.util.Map;
import java.util.Set;


public class MapToJsonUtil {
	private String jsonString = "{";

	public String toJsonString(Map<String, Object> resMap) {
		// TODO Auto-generated method stub
		Set<String> set = resMap.keySet();
		int cnt = 0;
		for (String key : set) {

			Object value = resMap.get(key);
			if (cnt > 0) {
				jsonString = jsonString + ",";
			}
			if (value instanceof Integer) {
				jsonString = jsonString + "\"" + key + "\":" + value + "";
			} else {
				jsonString = jsonString + "\"" + key + "\":\"" + value + "\"";
			}
			cnt++;
		}
		return jsonString + "}";
	}

}
