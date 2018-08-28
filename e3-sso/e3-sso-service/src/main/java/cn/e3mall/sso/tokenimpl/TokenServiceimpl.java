package cn.e3mall.sso.tokenimpl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.common.untils.JsonUtils;
import cn.e3mall.pojo.TbUser;

import cn.e3mall.sso.token.TokenService;
@Service
public class TokenServiceimpl implements TokenService {
	@Autowired
	private JedisClient jedisClient;
	@Override
	public E3Result GetUserById(String token) {
		// 2、根据token查询redis。
		String json = jedisClient.get("session_id" + ":" + token);
		if (StringUtils.isBlank(json)) {
			// 3、如果查询不到数据。返回用户已经过期。
			return E3Result.build(400, "用户登录已经过期，请重新登录。");
		}
		// 4、如果查询到数据，说明用户已经登录。
		// 5、需要重置key的过期时间。
		jedisClient.expire("session_id"+":" + token, 3600);
		// 6、把json数据转换成TbUser对象，然后使用e3Result包装并返回。
		TbUser user = JsonUtils.jsonToPojo(json, TbUser.class);
		return E3Result.ok(user);
	}

}
