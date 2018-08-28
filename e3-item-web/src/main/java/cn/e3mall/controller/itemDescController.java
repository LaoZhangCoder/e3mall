package cn.e3mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.e3mall.pojo.Item;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.service.ItemService;

@Controller
public class itemDescController {
	@Autowired
	private ItemService itemservice;
	
	
	@RequestMapping(value="/item/{itemId}")
	public String showinfo(@PathVariable Long itemId,Model model) {
		TbItem itemById = itemservice.getItemById(itemId);
		Item item = new Item(itemById);
		TbItemDesc tbItemDesc= itemservice.getitemdescbyid(itemId);
		model.addAttribute("item", item);
		model.addAttribute("tbItemDesc", tbItemDesc);
		
		return "item";
		
		
	}

}
