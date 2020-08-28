package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUiTreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.service.ItemCatService;


@Service
public class ItemCatServiceImpl implements ItemCatService {
	@Autowired
	private TbItemCatMapper itemCatMapper;

	@Override
	public List<EasyUiTreeNode> selectItemCatByParentId(Long cid) {
		// TODO Auto-generated method stub

		TbItemCatExample example = new TbItemCatExample();
		example.createCriteria().andParentIdEqualTo(cid);
		List<TbItemCat> catList = itemCatMapper.selectByExample(example);
		
		List<EasyUiTreeNode> easyNodes= new ArrayList<EasyUiTreeNode>();
		
		for (TbItemCat itemCat : catList) {
			EasyUiTreeNode easyUiTreeNode =new EasyUiTreeNode();
			easyUiTreeNode.setId(itemCat.getId());
			easyUiTreeNode.setState(itemCat.getIsParent()?"closed":"open");
			easyUiTreeNode.setText(itemCat.getName());
			easyNodes.add(easyUiTreeNode);
		}
		return easyNodes;
	}

}
