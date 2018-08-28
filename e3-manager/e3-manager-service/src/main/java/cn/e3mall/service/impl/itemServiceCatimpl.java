package cn.e3mall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.service.itemServiceCat;
@Service
public class itemServiceCatimpl implements itemServiceCat {
    @Autowired
	private TbItemCatMapper itemcatmapper;
	@Override
	public List<EasyUITreeNode> getitemCat(Long parentid) {
		// TODO Auto-generated method stub
	TbItemCatExample example=new TbItemCatExample();
	Criteria  criteria=example.createCriteria();
		criteria.andParentIdEqualTo(parentid);
		List<TbItemCat> litemcatist=itemcatmapper.selectByExample(example);
		// 2、转换成EasyUITreeNode列表。
				List<EasyUITreeNode> resultList = new ArrayList<>();
			
		for (TbItemCat tbItemCat : litemcatist) {
			EasyUITreeNode treenode=new EasyUITreeNode();
			treenode.setId(tbItemCat.getId());
			treenode.setText(tbItemCat.getName());
			treenode.setState(tbItemCat.getIsParent()?"closed":"open");
			resultList.add(treenode);
			
		}
		return resultList;
	}
	

}
