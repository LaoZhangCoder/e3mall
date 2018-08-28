package cn.e3mall.content.serivice;

import java.util.List;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.pojo.TbContent;

public interface ContentService {
	public EasyUIDataGridResult getContentList(Long categoryId,int page,int rows);
	public E3Result addContent(TbContent content);
	List<TbContent> getContentListByCid(long cid);
}
