package cn.e3mall.service;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.utils.DataResult;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;

public interface ItemService {
	 TbItem getItemById(long id);
	
	 EasyUIDataGridResult getItemList(int page, int rows);
	 DataResult addItem(TbItem item, String desc);
	 TbItemDesc getItemDescById(long itemId);
}
