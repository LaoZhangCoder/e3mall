package cn.e3mall.service;

import java.util.List;

import cn.e3mall.common.pojo.EasyUITreeNode;

public interface itemServiceCat {
	public List<EasyUITreeNode> getitemCat(Long parentid);

}
