package cn.e3mall.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.pojo.EasyUIDataGridResult;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.common.untils.IDUtils;
import cn.e3mall.common.untils.JsonUtils;
import cn.e3mall.mapper.TbItemDescMapper;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemDesc;
import cn.e3mall.pojo.TbItemExample;
import cn.e3mall.pojo.TbItemExample.Criteria;
import cn.e3mall.service.ItemService;

/**
 * 商品管理Service
 * <p>Title: ItemServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: www.itcast.cn</p> 
 * @version 1.0
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;
	@Autowired
	private TbItemDescMapper itemdescmapper;
	@Autowired
	private JmsTemplate jmsTemplate;
	@Resource
	private Destination topicDestination;
	@Autowired
	private TbItemDescMapper descmapper;
	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public TbItem getItemById(long itemId) {
		try {
			//查询缓存
			String json = jedisClient.get("ITEM_INFO_PRE" + ":" + itemId + ":BASE");
			if (StringUtils.isNotBlank(json)) {
				//把json转换为java对象
				TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
				System.out.println(item);
				return item;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//根据主键查询
		//TbItem tbItem = itemMapper.selectByPrimaryKey(itemId);
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		//设置查询条件
		criteria.andIdEqualTo(itemId);
		//执行查询
		List<TbItem> list = itemMapper.selectByExample(example);
		if (list != null && list.size() > 0) {
			TbItem tbItem = list.get(0);
			jedisClient.set("ITEM_INFO_PRE" + ":" + itemId + ":BASE", JsonUtils.objectToJson(tbItem));
			//设置缓存的有效期
			jedisClient.expire("ITEM_INFO_PRE" + ":" + itemId + ":BASE", 1000);

			return tbItem;
		}
		return null;
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//执行查询
		TbItemExample example = new TbItemExample();
		List<TbItem> list = itemMapper.selectByExample(example);
		//创建一个返回值对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setRows(list);
		//取分页结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(list);
		//取总记录数
		long total = pageInfo.getTotal();
		result.setTotal(total);
		return result;
	}

	@Override
	public E3Result addItem(TbItem tbitem, String desc) {
		// 1、生成商品id
		final long genItemId = IDUtils.genItemId();
		tbitem.setId(genItemId);
		//商品状态，1-正常，2-下架，3-删除
		tbitem.setStatus((byte) 1);
		Date date=new Date();
		tbitem.setCreated(date);
		tbitem.setUpdated(date);
		// 3、向商品表插入数据
		itemMapper.insert(tbitem);
		// 4、创建一个TbItemDesc对象
		TbItemDesc tbItemDesc = new TbItemDesc();
		tbItemDesc.setItemId(genItemId);
		tbItemDesc.setCreated(date);
		tbItemDesc.setItemDesc(desc);
		tbItemDesc.setUpdated(date);
		itemdescmapper.insert(tbItemDesc);
		//发送一个商品添加消息
		jmsTemplate.send(topicDestination ,new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				
				// TODO Auto-generated method stub
				TextMessage createTextMessage = session.createTextMessage(genItemId+"");
				return createTextMessage;
			}
		});
		
		return E3Result.ok();
		
		
	}

	@Override
	public TbItemDesc getitemdescbyid(long itemId) {
		// TODO Auto-generated method stub
		TbItemDesc selectByPrimaryKey = descmapper.selectByPrimaryKey(itemId);
		return selectByPrimaryKey;

}
	}
