package cn.e3mall.cart.service;

import cn.e3mall.common.untils.E3Result;

public interface CartService {
  E3Result addCarttoRedis(String itemId,int num,long id);
}
