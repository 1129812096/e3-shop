package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUiTreeNode;
import cn.e3mall.content.service.ContentCategoryService;

@Controller
public class ContentController {
	@Autowired
	private ContentCategoryService contentCategoryService;
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<EasyUiTreeNode> getContentCatList(
			@RequestParam(name="id",defaultValue="0")Long  parentId){
		List<EasyUiTreeNode> result = contentCategoryService.getEasyUiTreeNodes(parentId);
		return result;
	}
}
