package cn.e3mall.cart.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.cart.service.CartService;
import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.untils.CookieUtils;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.common.untils.JsonUtils;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.service.ItemService;

@Controller
public class CartController {
	@Autowired
	private ItemService itemservice;
	@Autowired
	private CartService cartservice;
	@RequestMapping(value="/cart/add/{itemId}")//536563
  public String addcart(@PathVariable String itemId,int num,HttpServletRequest request, HttpServletResponse response) {
	  List<TbItem> getcookies = getcookies(request, "cart");
	  TbUser user = (TbUser) request.getAttribute("user");
	  if(user!=null) {
	  cartservice.addCarttoRedis(itemId, num, user.getId());
	  return "cartSuccess";
	  }
	  boolean flag=false;
	  for (TbItem tbItem : getcookies) {
		if(tbItem.getId().toString().equals(itemId)) {
			tbItem.setNum(tbItem.getNum()+num);
			flag=true;
			break;
		}
	}
	  if(!flag) {
		  TbItem item = itemservice.getItemById(Long.parseLong(itemId));
			//取一张图片
			String image =item.getImage();
			if (StringUtils.isNoneBlank(image)) {
				String[] images = image.split(",");
				item.setImage(images[0]);
			}
			//设置购买商品数量
			item.setNum(num);

		  getcookies.add(item);
	  }
	  String string = JsonUtils.objectToJson(getcookies);
	  CookieUtils.setCookie(request, response, "cart", string, 3600, true);

	return "cartSuccess";
	  
	  
	  
  }
	public List<TbItem> getcookies(HttpServletRequest request,String cookieName){
		String cookieValue = CookieUtils.getCookieValue(request, cookieName, true);
		System.out.println(cookieValue);
		if(StringUtils.isNotBlank(cookieValue)) {
			
			List<TbItem> list = JsonUtils.jsonToList(cookieValue, TbItem.class);
			return list;
		}else {
			return new ArrayList<>();
		}
		
		
	}
	@RequestMapping(value="/cart/cart")
	public String showcartPage(HttpServletRequest request) {
		 List<TbItem> getcookies = getcookies(request,"cart");
		 request.setAttribute("cartList", getcookies);
		 return "cart";
	}
	@RequestMapping(value="/cart/update/num/{itemId}/{newnum}")
	@ResponseBody
	public E3Result updateCokkie(@PathVariable String itemId,@PathVariable int newnum,HttpServletRequest request,HttpServletResponse response) {
		List<TbItem> list = getcookies(request, "cart");
		for (TbItem tbItem : list) {
			if(tbItem.getId().toString().equals(itemId)) {
				tbItem.setNum(newnum);
				break;
			}
		}
		CookieUtils.setCookie(request, response, "cart", JsonUtils.objectToJson(list), 3600, true);
		
		return E3Result.ok();
		
		
	}
	@RequestMapping(value="/cart/delete/{itemId}")
	public String deletecartitem(@PathVariable String itemId,HttpServletRequest request,HttpServletResponse response){
		List<TbItem> list = getcookies(request, "cart");
		for (TbItem tbItem : list) {
			if(tbItem.getId().toString().equals(itemId)) {
				list.remove(tbItem);
				break;
			}
		}
		CookieUtils.setCookie(request, response, "cart", JsonUtils.objectToJson(list), 3600, true);
		return "redirect:/cart/cart.action";
	}
}
