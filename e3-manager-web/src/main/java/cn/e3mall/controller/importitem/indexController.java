package cn.e3mall.controller.importitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.untils.E3Result;
import cn.e3mall.importindex.Importitem;

@Controller
public class indexController {
@Autowired
private Importitem importitem;
@RequestMapping(value="/index/item/import")
@ResponseBody
public E3Result improtdata() {
	
	E3Result  result= importitem.importdate();
	return result;
}

}
