package AriticleController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import BlogService.AriticleSerivice;
import pojo.Article;

@Controller
public class ChangeArticleController {
	@Autowired
	private AriticleSerivice as;
	
	
@RequestMapping(value="/Changearticles")
	private String toupdate(int id,Article article) {
		as.toupdate(id, article);
		return "redirect:/Mangermentarticles";
		
	}
@RequestMapping(value="/changearticlecontent")
private String toeditor(int articles_id,Model model) {
	
	Article toeditor1 = as.toeditor(articles_id);
	
	model.addAttribute("article", toeditor1);
	
	return "changeArticle";
	
}
}
