package cn.e3mall.sso.register;

import cn.e3mall.common.untils.E3Result;
import cn.e3mall.pojo.TbUser;

public interface RegisterService {
	E3Result register(String param,int tyep);
	E3Result registeruser(TbUser user);

}
