package cn.e3mall.sso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.untils.E3Result;
import cn.e3mall.pojo.TbUser;
import cn.e3mall.sso.register.RegisterService;

@Controller
public class RegisterController {
	@Autowired
	private RegisterService registerservice;
	@RequestMapping(value="/user/check/{param}/{type}")
	@ResponseBody
	public E3Result Checkdata(@PathVariable String param,@PathVariable int type) {
		E3Result result = registerservice.register(param, type);
		
		return result;
		
		
	}
	@RequestMapping(value="/reg/page")
	public String reisterpage() {
		
		return "register";
	}
	@RequestMapping(value="/user/register")
	@ResponseBody
	public E3Result registeruser(TbUser user) {
		E3Result  result= registerservice.registeruser(user);
		return result;
	}
	@RequestMapping(value="/page/login")
	public String loginpage() {
		
		return "login";
	}

}
