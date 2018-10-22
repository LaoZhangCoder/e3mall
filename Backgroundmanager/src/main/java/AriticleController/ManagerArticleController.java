package AriticleController;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import javax.security.auth.login.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import BlogService.AriticleSerivice;
import BlogService.Managerarticle;
import pojo.Article;
import pojo.Comment;
import pojo.Links;
import pojo.Resultdata;
import pojo.User;

@Controller
public class ManagerArticleController {
	@Autowired
	private Managerarticle managerticle;
	@Autowired
	private AriticleSerivice as;
	@RequestMapping(value="/Mangermentarticles")
	public String Manager(Model model) {
		List<Article> list = managerticle.selectall();
		model.addAttribute("list", list);
	
		return "ManagerPage";
		
	}
	@RequestMapping(value="/Deletearticle")
	public String deletebyid(int id) {
		managerticle.deletebyid(id);
		return "redirect:/Mangermentarticles";
		
	}
	@RequestMapping(value="/topassword")
	public String topasswordpage() {
	
		return "password";
		
	}
	@RequestMapping(value="/updatepassword")
	public String updatepassword(String oldPassword,String newPassword,String username) throws LoginException {
	managerticle.updatepassword(oldPassword, newPassword,username);
		return "redirect:/topassword";
		
	}
	@RequestMapping(value="/homedata")
	@ResponseBody
	public Resultdata getdata(String tag,int thispage) {
		Resultdata resultdata = new Resultdata();
		managerticle.getthispageitem(resultdata,tag,thispage);
		return resultdata;
		
	} 
	@RequestMapping(value="/homedatacategory")
	@ResponseBody
	public Resultdata getcategory() {
		Resultdata resultdata = new Resultdata();
		managerticle.getallcategory(resultdata);
		return resultdata;
		
	} 
	@RequestMapping(value="/getcount")
	@ResponseBody
	public long getitemcount() {
		
		long getcount = managerticle.getcount();
		return getcount;
		
	} 
	@RequestMapping(value="/newarticle")
	@ResponseBody
	public Resultdata getnewitems() {
		Resultdata resultdata = new Resultdata();
	 managerticle.getnewsarticle(resultdata);
	return resultdata;
	 
		
		
	} 
	@RequestMapping(value="/Category")
	@ResponseBody
	public Resultdata gettagdata(String tag,int thispage) {
		Resultdata resultdata = new Resultdata();
		
		 managerticle.gettagdata(tag, thispage, resultdata);
		
		return resultdata;
	}
	@RequestMapping(value="/Category/count")
	@ResponseBody
	public long getcategorycount(String tag) {
		long getcount = managerticle.getcountbytag(tag);
		return getcount;
		
	} 
	@RequestMapping(value="/Category/detail")
	@ResponseBody
	public Article getdetailbyid(int id) {
	 Article article = managerticle.getdetailbyid(id);
		return article;
		
	} 
	@RequestMapping(value="/Category/leavemessage")
	@ResponseBody
	public  Resultdata  getmessage(String username,String email,String href,String comment,int id) throws Exception {
	 User user = new User();
	 username=new String(username.getBytes("ISO-8859-1"),"utf-8"); 
	comment=new String(comment.getBytes("ISO-8859-1"),"utf-8"); 
	
		user.setComment(comment);
		user.setDate(new Date());
		user.setEmail(email);
		user.setHref(href);
	user.setId(id);
		user.setUsername(username);
		managerticle.addusermessage(user);
		Resultdata resultdata = new Resultdata();
		resultdata.setOk(true);
		return resultdata;
		
	} 
	@RequestMapping(value="/Category/leavecomments")
	@ResponseBody
	public  Resultdata getusercomments(int id) {
 List<User> list = managerticle.getusercommentsbyid(id);
 Resultdata resultdata = new Resultdata();
 resultdata.setListcomments(list);
 resultdata.setOk(true);
 resultdata.setCount(list.size());
		return resultdata;
		
	} 
	@RequestMapping(value="/Category/getcommenttotal")
	@ResponseBody
	public List<Comment> getcommenttotal(){
		List<Comment> list = managerticle.getcommenttotals();
		return list;
	}
	@RequestMapping(value="/Category/getnewcomment")
	@ResponseBody
	public List<User> getnewcomment() {
	List<User> list = managerticle.getnewcomment();
		return list;
		
	} 
	@RequestMapping(value="/Category/getlinks")
	@ResponseBody
	public List<Links> getlinks() {
	 List<Links> list = managerticle.getalllinks();
	 return list;
		
		
	} 
	
	@RequestMapping(value="/Category/addpageviews")
	@ResponseBody
	public Resultdata addpageviews(int id) {
	managerticle.addpageviews(id);
	Resultdata resultdata = new Resultdata();
	resultdata.setOk(true);
	return resultdata;
	}
	
	@RequestMapping(value="/Category/search")
	@ResponseBody
	public Resultdata search(String searchcontent) throws UnsupportedEncodingException {
		Resultdata resultdata=null;
		String string=new String(searchcontent.getBytes("ISO-8859-1"),"utf-8"); 	
		try {
		 resultdata = as.queryarticlewithhighlingting(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return resultdata;
	
	}
}
