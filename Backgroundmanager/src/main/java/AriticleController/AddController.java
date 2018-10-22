package AriticleController;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import BlogService.AriticleSerivice;
import pojo.Article;

@Controller
public class AddController {
@Autowired
private AriticleSerivice ari;
@RequestMapping(value="/addariticle")
public String addariticle(Article article, MultipartFile pictureFile,HttpServletRequest request) throws Exception {
	String path = request.getSession().getServletContext().getRealPath("/")+ "imgs/";;
	String picName = UUID.randomUUID().toString();
	// 获取文件名
		String oriName = pictureFile.getOriginalFilename();
		// 获取图片后缀
		String extName = oriName.substring(oriName.lastIndexOf("."));
		pictureFile.transferTo(new File(path + picName + extName));
		article.setImghref(picName + extName);
	ari.addariticle(article);
	return "redirect:www.shendehaizi.com/#/";
	
}
@RequestMapping(value="/toaddariticle")
public String toaddariticle() {
	return "addarticle";
	
}
@RequestMapping(value="/admin")
public String index() {
	
	return "login";
}
}
