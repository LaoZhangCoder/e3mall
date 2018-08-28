package cn.e3mall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.service.itemServiceCat;

@Controller
public class itemcatController {
	@Autowired
	private itemServiceCat isc;
	@RequestMapping(value="/item/cat/list")
	@ResponseBody
	public List<EasyUITreeNode > getitemcat( @RequestParam(value="id",defaultValue="0")Long parentid){
		
		List<EasyUITreeNode> list=isc.getitemCat(parentid);
		
		return list;
		
	}

}
