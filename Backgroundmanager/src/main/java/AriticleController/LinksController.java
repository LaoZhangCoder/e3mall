package AriticleController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import BlogService.AriticleSerivice;
import pojo.Links;

@Controller
public class LinksController {
	@Autowired
	private AriticleSerivice as;
@RequestMapping(value="/Links")
	public String tolinks() {
		return "Links";
	}
@RequestMapping(value="/addlinks")
public String addlink(Links link) {
	
	as.addlink(link);
	return "Links";
}
@RequestMapping(value="/shutdown")
public String shutdown(HttpSession session) {
	session.removeAttribute("username");
	
	return "redirect:/admin";
}
}
