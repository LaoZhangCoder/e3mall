package cn.e3mall.controller.content;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.content.serivice.ContentServiceCat;

@Controller
public class ContentcatController {
	@Autowired
	private ContentServiceCat contentservicecat;
	@RequestMapping(value="/content/category/list")
	@ResponseBody
	public  List<EasyUITreeNode> getcontentcat(@RequestParam(value="id",defaultValue="0") long parentid){
		List<EasyUITreeNode> contentCat = contentservicecat.getContentCat(parentid);
		return contentCat;
		
		
	}
	@RequestMapping("/content/category/create")
	@ResponseBody
	public E3Result createCategory(Long parentId, String name) {
		E3Result result = contentservicecat.addContentCatogry(parentId, name);
		return result;
	}

	

}
