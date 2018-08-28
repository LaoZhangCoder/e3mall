package cn.e3mall.sso.login;

import cn.e3mall.common.untils.E3Result;

public interface LoginService {
 E3Result login(String username,String password);
}
