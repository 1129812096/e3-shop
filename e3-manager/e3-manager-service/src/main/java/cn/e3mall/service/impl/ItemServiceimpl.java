package cn.e3mall.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.DataResult;
import cn.e3mall.common.utils.IDUtils;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.service.ItemService;
@Service
public class ItemServiceimpl implements ItemService {
    @Autowired
	public TbItemMapper itemMapper;
    @Autowired
    public TbItemDescMapper  itemDescMapper;
    @Autowired
    public JmsTemplate JmsTemplate;
    @Resource
    public Destination topicDestination;
	@Override
	public TbItem getItemById(long id) {
		// TODO Auto-generated method stub
		
		TbItemExample example=new TbItemExample();
		example.createCriteria().andIdEqualTo(id);
		List<TbItem> list = itemMapper.selectByExample(example);
		if(list != null&& list.size()>0) {
			return list.get(0);
		}
		return null;
			
	}
	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		
		PageHelper.startPage(page, rows);
		
		TbItemExample example= new TbItemExample() ;
		List<TbItem> list = itemMapper.selectByExample(example);
		// TODO Auto-generated method stub
		EasyUIDataGridResult result=new  EasyUIDataGridResult();
		result.setRows(list);
		PageInfo<TbItem> pageInfo=new PageInfo<>(list);
		long total = pageInfo.getTotal();
		result.setTotal(total);
		return result;
	}
	@Override
	public DataResult addItem(TbItem item, String desc) {
		
		long itemId = IDUtils.genItemId();
		item.setId(itemId);
		//1-正常，2-下架，3-删除
		item.setStatus((byte)1);
		item.setCreated(new Date());
		item.setUpdated(new Date());
		itemMapper.insert(item);
		TbItemDesc itemDesc=new TbItemDesc();
		itemDesc.setItemId(itemId);
		itemDesc.setItemDesc(desc);
		itemDesc.setCreated(new Date());
		itemDesc.setUpdated(new Date());
		itemDescMapper.insert(itemDesc);
		// TODO Auto-generated method stub
		return DataResult.ok();
		
	}
	@Override
	public TbItemDesc getItemDescById(long itemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
