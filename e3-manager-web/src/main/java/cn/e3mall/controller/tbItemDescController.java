package cn.e3mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.utils.DataResult;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.service.ItemDescService;

@Controller
public class tbItemDescController {
    @Autowired
	public ItemDescService itemDescService;
	
    @RequestMapping(value= {"/rest/page/{url}"})
    public String pathEditDesc(@PathVariable String url) {
		return url;
    }
    @RequestMapping(value= {"/rest/item/query/item/desc/{id}"})
    @ResponseBody
    public String getItemDesc(@PathVariable Long id) {
    	System.out.println(id);
		DataResult dataResult = itemDescService.selectItemDescById(id);
		String resString = JsonUtils.objectToJson(dataResult);
		System.out.println(resString);
    	return resString;
    	
    }
    
	
}
