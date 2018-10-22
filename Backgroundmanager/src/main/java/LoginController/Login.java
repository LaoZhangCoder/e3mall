package LoginController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import BlogService.LoginService;
import LoginExection.LoginExection;

@Controller
public class Login {
	@Autowired
	private LoginService loginservice;
   @RequestMapping(value="/tologin")
	public String tologin(String username,String password,HttpSession session) throws LoginExection {
	  loginservice.Checklogin(username, password);
	
	  session.setAttribute("username", username);
		  return "cms";
	  
		
		
		
	}
}
