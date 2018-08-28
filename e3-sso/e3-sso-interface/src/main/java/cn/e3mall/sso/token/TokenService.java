package cn.e3mall.sso.token;

import cn.e3mall.common.untils.E3Result;

public interface TokenService {
	 E3Result GetUserById(String token);
}
