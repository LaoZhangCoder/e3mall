package cn.e3mall.content.service.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.pojo.EasyUITreeNode;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.content.serivice.ContentServiceCat;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;
import cn.e3mall.pojo.TbContentCategoryExample.Criteria;

@Service
public class ContentSeiviceCatimpl  implements ContentServiceCat{
	@Autowired
	private TbContentCategoryMapper contentmapper;;

	@Override
	public List<EasyUITreeNode> getContentCat(Long parentid) {
		
		TbContentCategoryExample example = new TbContentCategoryExample();
	                 Criteria createCriteria = example.createCriteria();
	                   createCriteria.andParentIdEqualTo(parentid);
		
		List<TbContentCategory> list = contentmapper.selectByExample(example);
		
		List<EasyUITreeNode> listnode=new ArrayList<EasyUITreeNode>();
for (TbContentCategory tb : list) {
	EasyUITreeNode node=new EasyUITreeNode();
	node.setId(tb.getId());
node.setText(tb.getName());
node.setState(tb.getIsParent()?"closed":"open");
	listnode.add(node);
			
		}
		
		// TODO Auto-generated method stub
		return listnode;
	}

	@Override
	public E3Result addContentCatogry(Long parentId, String name) {
		
		// 1、接收两个参数：parentId、name
				// 2、向tb_content_category表中插入数据。
				// a)创建一个TbContentCategory对象
				TbContentCategory tbContentCategory = new TbContentCategory();
				// b)补全TbContentCategory对象的属性
				tbContentCategory.setIsParent(false);
				tbContentCategory.setName(name);
				tbContentCategory.setParentId(parentId);
				//排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
				tbContentCategory.setSortOrder(1);
				//状态。可选值:1(正常),2(删除)
				tbContentCategory.setStatus(1);
				tbContentCategory.setCreated(new Date());
				tbContentCategory.setUpdated(new Date());
				// c)向tb_content_category表中插入数据
				contentmapper.insert(tbContentCategory);
				// 3、判断父节点的isparent是否为true，不是true需要改为true。
				TbContentCategory parentNode = contentmapper.selectByPrimaryKey(parentId);
				if (!parentNode.getIsParent()) {
					parentNode.setIsParent(true);
					//更新父节点
					contentmapper.updateByPrimaryKey(parentNode);
				}
				// 4、需要主键返回。
				// 5、返回E3Result，其中包装TbContentCategory对象
				return E3Result.ok(tbContentCategory);

	}

}
