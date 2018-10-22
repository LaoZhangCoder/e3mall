package BlogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import LoginExection.LoginExection;
import Untils.MD5Utils;
import mapper.RootuserMapper;
import pojo.Rootuser;

@Service
public class LoginServiceimpl implements LoginService {
@Autowired
private RootuserMapper rootmapper;
	public Boolean Checklogin(String username, String password) throws LoginExection {
		
		String md5 = MD5Utils.md5(username);
		String md5pass = MD5Utils.md5(password);
	
		Rootuser rootuser = rootmapper.selectByPrimaryKey(md5);
		if(rootuser==null) {
			
			throw new LoginExection("username is not exist!");
		}else if(md5pass.equals(rootuser.getPassword())) {
			
			return true;
		}else {
			
			throw new LoginExection("password error!");
		}
		
		
		
	}

}
