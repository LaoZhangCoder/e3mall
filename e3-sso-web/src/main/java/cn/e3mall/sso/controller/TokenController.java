package cn.e3mall.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.untils.E3Result;
import cn.e3mall.common.untils.JsonUtils;
import cn.e3mall.sso.token.TokenService;
@Controller
public class TokenController {
	@Autowired
	private TokenService tokensevice;
	@RequestMapping(value="/user/token/{token}")
	@ResponseBody
	public String getuserbytoken(@PathVariable String token,String callback) {
		 E3Result result = tokensevice.GetUserById(token);
		if(StringUtils.isNotBlank(callback)) {
			String strresult=callback+"("+JsonUtils.objectToJson(result)+")";
			return strresult;
		}
		 
		  return JsonUtils.objectToJson(result);

	}

}
