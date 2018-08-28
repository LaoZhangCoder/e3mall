package cn.e3mall.content.service.serviceimpl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.jedis.JedisClient;

import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.common.untils.JsonUtils;
import cn.e3mall.content.serivice.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentExample;
import cn.e3mall.pojo.TbContentExample.Criteria;
@Service
public class ContentServiceimpl implements ContentService{
	@Autowired
	private TbContentMapper contentmapper;
	@Autowired
	private JedisClient jedisClient;

	@Override
	public EasyUIDataGridResult getContentList(Long categoryId, int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		TbContentExample example=new TbContentExample();
		Criteria createCriteria = example.createCriteria();
	createCriteria.andCategoryIdEqualTo(categoryId);
		List<TbContent> list = contentmapper.selectByExample(example);
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
		easyUIDataGridResult.setRows(list);
		PageInfo<TbContent> pageInfo = new PageInfo<>(list);
		easyUIDataGridResult.setTotal(pageInfo.getTotal());
		return easyUIDataGridResult;
	}

	@Override
	public E3Result addContent(TbContent content) {
		//补全属性
		content.setCreated(new Date());
		content.setUpdated(new Date());
		//插入数据
		contentmapper.insert(content);
		return E3Result.ok();

	}

	@Override
	public List<TbContent> getContentListByCid(long cid) {
		try {
			String json = jedisClient.hget("content", cid+"");
			if (StringUtils.isNotBlank(json)) {
				//把json转换成list
				List<TbContent> list = JsonUtils.jsonToList(json, TbContent.class);
				return list;
			}
		} catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();

		}
		
		TbContentExample example = new TbContentExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		criteria.andCategoryIdEqualTo(cid);
		//执行查询
		List<TbContent> list = contentmapper.selectByExampleWithBLOBs(example);
		//向缓存中添加数据
		try {
			jedisClient.hset("content", cid+"", JsonUtils.objectToJson(list));
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return list;
	
	}
	
	
	

}
