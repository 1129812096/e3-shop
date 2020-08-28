package cn.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUiTreeNode;
import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;

@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	@Autowired
	private TbContentCategoryMapper contentCategoryMapper;

	@Override
	public List<EasyUiTreeNode> getEasyUiTreeNodes(Long parentid) {
		// TODO Auto-generated method stub

		TbContentCategoryExample example = new TbContentCategoryExample();
		example.createCriteria().andParentIdEqualTo(parentid);
		List<TbContentCategory> list = contentCategoryMapper.selectByExample(example);
		List<EasyUiTreeNode> lEasyUiTreeNodes=new ArrayList<>();
		for (TbContentCategory tb : list) {
			EasyUiTreeNode easyUiTreeNode = new EasyUiTreeNode();
			easyUiTreeNode.setId(tb.getId());
			easyUiTreeNode.setState(tb.getIsParent()?"closed":"open");
			easyUiTreeNode.setText(tb.getName());
			lEasyUiTreeNodes.add(easyUiTreeNode);
		}
		return lEasyUiTreeNodes;
	}

}
