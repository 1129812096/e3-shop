package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUiTreeNode;
import cn.e3mall.service.ItemCatService;

@Controller
public class ItemCatController {
	@Autowired
	private ItemCatService itemCatService;

	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<EasyUiTreeNode> getItemCatList(@RequestParam(value = "id", defaultValue = "0") Long parent_id) {

		List<EasyUiTreeNode> result = itemCatService.selectItemCatByParentId(parent_id);
		return result;
	}

}
