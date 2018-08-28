package cn.e3mall.cart.serviceimpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.cart.service.CartService;
import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.common.untils.JsonUtils;
import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
@Service
public class CartServiceimpl implements CartService {
@Autowired
private JedisClient jedisclient;
@Autowired TbItemMapper itemmapper;
	@Override
	public E3Result addCarttoRedis(String itemId, int num,long id) {
		// TODO Auto-generated method stub
		Boolean hexists = jedisclient.hexists("cart:"+id, itemId+"");
		if(hexists) {
			String string = jedisclient.hget("cart:"+id, itemId+"");
			TbItem item = JsonUtils.jsonToPojo(string, TbItem.class);
			item.setNum(item.getNum()+num);
			String json = JsonUtils.objectToJson(item);
			jedisclient.hset("cart:"+id,itemId+"", json);
			return E3Result.ok();
			
		}
		TbItem item = itemmapper.selectByPrimaryKey(Long.parseLong(itemId));
		item.setNum(num);
		//取一张图片
				String image = item.getImage();
				if (StringUtils.isNotBlank(image)) {
					item.setImage(image.split(",")[0]);
				}
		jedisclient.hset("cart"+id, itemId+"",JsonUtils.objectToJson(item) );
		return E3Result.ok();
	}

}
