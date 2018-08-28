package cn.e3mall.sso.loginimpl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.e3mall.common.jedis.JedisClient;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.common.untils.JsonUtils;
import cn.e3mall.mapper.TbUserMapper;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.pojo.TbUserExample;
import cn.e3mall.pojo.TbUserExample.Criteria;
import cn.e3mall.sso.login.LoginService;
@Service
public class LoginServiceimpl implements LoginService{
    @Autowired
    private TbUserMapper usermapper;
    @Autowired
    private JedisClient jedis;
	@Override
	public E3Result login(String username, String password) {
		TbUserExample example=new TbUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		List<TbUser> list = usermapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			TbUser tbUser = list.get(0);
			String passwordmid5=DigestUtils.md5DigestAsHex(password.getBytes());
			if(tbUser.getPassword().equals(passwordmid5)) {
				// 2、登录成功后生成token。Token相当于原来的jsessionid，字符串，可以使用uuid。
				String token=UUID.randomUUID().toString();
			  tbUser.setPassword(null);
			  jedis.set("session_id"+ ":" + token,JsonUtils.objectToJson(tbUser));
			  jedis.expire("session_id"+ ":" + token,1800);
				
				return E3Result.ok(token);
				
			}else {
				return E3Result.build(500, "密码错误!!");
			}
			
		}else {
			return E3Result.build(500, "用户名不存在!!");
		}
		
	}

}
