package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.utils.DataResult;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.pojo.TbItemParamItem;
import cn.e3mall.service.ItemParmService;

@Controller
public class tbItemParmController {
	@Autowired
	private ItemParmService itemParmService;

	@RequestMapping("/rest/item/param/item/query/{itemid}")
	@ResponseBody
	public String getItemParmPage(@PathVariable Long itemid) {
		TbItemParamItem itemParamItem = itemParmService.selectItemParmService(itemid);
		
		DataResult dataResult = DataResult.ok(itemParamItem);
		String result = JsonUtils.objectToJson(dataResult);
		System.out.println(result);
		return result;
		

	}
}
