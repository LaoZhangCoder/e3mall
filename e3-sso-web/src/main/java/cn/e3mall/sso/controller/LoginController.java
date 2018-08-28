package cn.e3mall.sso.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.untils.CookieUtils;
import cn.e3mall.common.untils.E3Result;
import cn.e3mall.sso.login.LoginService;

@Controller
public class LoginController {
	@Autowired
	private LoginService loginservice;
	@RequestMapping(value="/user/login")
	@ResponseBody
	public  E3Result login(String username,String password,HttpServletRequest request, HttpServletResponse response,HttpSession session) {
		
		E3Result result = loginservice.login(username, password);
		String data = (String) result.getData();
		Cookie cookie = new Cookie("token", data);
		cookie.setPath("/");
		response.addCookie(cookie);
		//CookieUtils.setCookie(request, response, "token", data);
		return result;
		
	}

}
