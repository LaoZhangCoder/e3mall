package cn.e3mall.sso.registerimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import cn.e3mall.common.untils.E3Result;
import cn.e3mall.mapper.TbUserMapper;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.pojo.TbUserExample;
import cn.e3mall.pojo.TbUserExample.Criteria;
import cn.e3mall.sso.register.RegisterService;
@Service
public class RegisterServiceimpl implements RegisterService {
	@Autowired
   private TbUserMapper usermapper;
	@Override
	public E3Result register(String param, int type) {
		// TODO Auto-generated method stub
		TbUserExample example = new TbUserExample();
		Criteria createCriteria = example.createCriteria();
		if(type==1) {
			createCriteria.andUsernameEqualTo(param);
			
		}else if(type==2) {
			createCriteria.andPhoneEqualTo(param);
			
		}else if(type==3) {
			createCriteria.andEmailEqualTo(param);
		}else {
			return E3Result.build(400, "非法的参数");
		}
		
	List<TbUser> listuser = usermapper.selectByExample(example);
	//执行查询
	List<TbUser> list = usermapper.selectByExample(example);
	// 3、判断查询结果，如果查询到数据返回false。
	if (list == null || list.size() == 0) {
		// 4、如果没有返回true。
		return E3Result.ok(true);
	} 
	// 5、使用e3Result包装，并返回。
	return E3Result.ok(false);

	}
	@Override
	public E3Result registeruser(TbUser user) {
		// TODO Auto-generated method stub
		TbUser u=new TbUser();
		u.setUpdated(new Date());
		u.setCreated(new Date());
		u.setUsername(user.getUsername());
		String md5Pass = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
		u.setPassword(md5Pass);
		u.setPhone(user.getPhone());
		 usermapper.insert(u);
		return E3Result.ok();
	}

}
