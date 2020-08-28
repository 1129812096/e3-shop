package cn.e3mall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.utils.DataResult;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemDescService;

@Service
public class ItemDescServiceImpl implements ItemDescService {
	@Autowired
	private TbItemDescMapper ItemDescMapper;

	@Override
	public DataResult selectItemDescById(Long itemId) {
		try {
			TbItemDesc tbItemDesc = ItemDescMapper.selectByPrimaryKey(itemId);
			DataResult dataResult = DataResult.ok(tbItemDesc);
			return dataResult;
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			
		}
		// TODO Auto-generated method stub
		return DataResult.build(100, "查询时出现问题奥");

	}

}
