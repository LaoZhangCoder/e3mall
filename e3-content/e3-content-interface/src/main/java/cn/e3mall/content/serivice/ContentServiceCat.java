package cn.e3mall.content.serivice;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.untils.E3Result;

public interface ContentServiceCat {
	public  List<EasyUITreeNode> getContentCat(Long parentid);
	public E3Result addContentCatogry(Long parentId,String name);

}
