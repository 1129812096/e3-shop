package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUiTreeNode;

public interface ContentCategoryService {

	List<EasyUiTreeNode> getEasyUiTreeNodes(Long  parentid);
}
