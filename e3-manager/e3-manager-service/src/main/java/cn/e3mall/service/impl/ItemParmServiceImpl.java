package cn.e3mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.mapper.TbItemParamItemMapper;
import cn.e3mall.pojo.TbItemParamItem;
import cn.e3mall.pojo.TbItemParamItemExample;
import cn.e3mall.pojo.TbItemParamItemExample.Criteria;
import cn.e3mall.service.ItemParmService;

@Service
public class ItemParmServiceImpl implements ItemParmService {
	@Autowired
	private TbItemParamItemMapper tbItemParamItemMapper;

	@Override
	public TbItemParamItem selectItemParmService(Long itemid) {

		TbItemParamItemExample example =new TbItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemid);
		List<TbItemParamItem> tbItemParamItem = tbItemParamItemMapper.selectByExampleWithBLOBs(example);
		if (tbItemParamItem !=null &&tbItemParamItem.size()>=1) {
			return tbItemParamItem.get(0);
		}
		return null;
		// TODO Auto-generated method stub
	
	}

}
