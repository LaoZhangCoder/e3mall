package BlogService;

import LoginExection.LoginExection;

public interface LoginService {
public Boolean Checklogin(String username,String password) throws LoginExection;
}
