package cn.e3mall.controller.content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.content.serivice.ContentService;
import cn.e3mall.pojo.TbContent;

@Controller
public class ContentServiceController {
	@Autowired
	private ContentService contentserviceimpl;
	
	@RequestMapping(value="/content/query/list")
	@ResponseBody
	public EasyUIDataGridResult getContent(Long categoryId, int page, int rows ) {
		EasyUIDataGridResult contentList = contentserviceimpl.getContentList(categoryId, page, rows);
		return contentList;
		
	}
		
		
	@RequestMapping("/content/save")
	@ResponseBody
	public E3Result addContent(TbContent content) {
		E3Result result = contentserviceimpl.addContent(content);
		return result;
	}

	

}
