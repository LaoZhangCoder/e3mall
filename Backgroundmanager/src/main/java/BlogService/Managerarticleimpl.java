package BlogService;
import java.io.IOException;
import java.util.List;
import javax.security.auth.login.LoginException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Untils.MD5Utils;
import mapper.ArticleMapper;
import mapper.CategoryMapper;
import mapper.LinksMapper;
import mapper.RootuserMapper;
import mapper.UserMapper;
import pojo.Article;
import pojo.ArticleExample;
import pojo.ArticleExample.Criteria;
import pojo.Categorye;
import pojo.Comment;
import pojo.Links;
import pojo.Resultdata;
import pojo.Rootuser;
import pojo.RootuserExample;
import pojo.User;
import pojo.UserExample;
import pojo.Vo;
@Service
public class Managerarticleimpl implements Managerarticle {
@Autowired
private ArticleMapper articlemapper;
@Autowired 
private CategoryMapper cm;
@Autowired
private RootuserMapper rm;
@Autowired
private UserMapper um;
@Autowired
private LinksMapper lm;
@Autowired
private SolrServer solrserver;

	public List<Article> selectall() {
		// TODO Auto-generated method stub
		List<Article> list = articlemapper.selectByExample(null);
		
		return list;
	}
	public void deletebyid(int id) {
		ArticleExample example=new ArticleExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andIdEqualTo(id);
		// TODO Auto-generated method stub
		articlemapper.deleteByExample(example);
		try {
			solrserver.deleteById(id+"");
			solrserver.commit();
		} catch (SolrServerException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void updatepassword(String oldPassword,String newPassword,String username) throws LoginException {
		// TODO Auto-generated method stub
		
		List<Rootuser> selectByExample = rm.selectByExample(null);
		Rootuser rootuser = selectByExample.get(0);
		String password = rootuser.getPassword();
		
		String md5oldPassword = MD5Utils.md5(oldPassword);
		String md5newPassword = MD5Utils.md5(newPassword);
		
		if(md5oldPassword.equals(password)) {
			rootuser.setPassword(md5newPassword);
			rootuser.setUsername(MD5Utils.md5(username));
			RootuserExample example1=new RootuserExample();
			pojo.RootuserExample.Criteria  a=example1.createCriteria();
			a.andPasswordEqualTo(password);
			rm.updateByExample(rootuser, example1);
		}else {
			throw new LoginException("danger change!");
		}
}
	public void getalldata(Resultdata data) {
		// TODO Auto-generated method stub
		List<Article> list = articlemapper.selectByExampleWithBLOBs(null);
		if(list!=null) {
		data.setList(list);
		data.setOk(true);
	 }
		
	}
	public void getallcategory(Resultdata data) {
		// TODO Auto-generated method stub
		List<Categorye> category = cm.getCategory();
		if(category!=null) {
			data.setListcategory(category);
			data.setOk(true);
		 }
	}
	public long getcount() {
		int getallsize = cm.getallsize();
		
		return getallsize;
		// TODO Auto-generated method stub
		
	}
	public void getthispageitem(Resultdata data,String tag, int thispage) {
		// TODO Auto-generated method stub
		int startpage=(thispage-1)*12;
		Vo vo = new Vo();
		if("".equals(tag)) {
			tag=null;
		}
		vo.setTag(tag);
		vo.setThispage(startpage);
		
 List<Article> list = cm.getthispagecontent(vo);

	if(list!=null) {
		
		data.setList(list);
		data.setOk(true);
	 }
}
	public void getnewsarticle(Resultdata data) {
		// TODO Auto-generated method stub
		List<Article> getnewdata = cm.getnewdata();
		if(getnewdata!=null) {
			data.setList(getnewdata);
			data.setOk(true);
		 
		}
		
	}
	public void gettagdata(String tag, int thispage,Resultdata data) {
		// TODO Auto-generated method stub
		Vo vo = new Vo();
		vo.setTag(tag);
		vo.setThispage(thispage);
		List<Article> gettagdata = cm.gettagdata(vo);
		if(gettagdata!=null) {
			data.setList(gettagdata);
			data.setOk(true);
		 
		}
		
	}
	public long getcountbytag(String tag) {
		// TODO Auto-generated method stub
		Vo vo = new Vo();
		if("".equals(tag)) {
			tag=null;
		}
		vo.setTag(tag);
		 
		long getcoutbytag = cm.getcoutbytag(vo);
		
		return getcoutbytag;
	}
	public Article getdetailbyid(int id) {
		// TODO Auto-generated method stub
		List<Article> getdetailbyid = cm.getdetailbyid(id);
		Article article=new Article();
		if(getdetailbyid!=null) {
			 article = getdetailbyid.get(0);
			
		}
	
		return article;
	}
	public void addusermessage(User user) {
		// TODO Auto-generated method stub
		um.insert(user);
		
	}
	@Override
	public List<User> getusercommentsbyid(int id) {
		// TODO Auto-generated method stub
		List<User> list = cm.getcomments(id);
		return list;
	}
	@Override
	public List<Comment> getcommenttotals() {
		// TODO Auto-generated method stub
		List<Comment> list = cm.getcountcomment();
		return list;
	}
	@Override
	public List<User> getnewcomment() {
	List<User> list = cm.getnewcomments();
		return list;
	}
	@Override
	public List<Links> getalllinks() {
		// TODO Auto-generated method stub
		List<Links> list = lm.selectByExample(null);
		
		return list;
	}
	@Override
	public void addpageviews(int id) {
		// TODO Auto-generated method stub
		ArticleExample example=new ArticleExample();
		 Criteria criteria = example.createCriteria();
		  criteria.andIdEqualTo(id);
		  Article article = new Article();
		  List<Article> list = articlemapper.selectByExample(example);
		  Article article2 = list.get(0);
		  if(article2.getLiulanliang()==null) {
			  article2.setLiulanliang(0);
		  }
		  article=article2;
		  int pageviews=article2.getLiulanliang();
		  pageviews=pageviews+1;
		  article.setLiulanliang(pageviews);
		articlemapper.updateByExample(article, example);
		
		
	}
		
	
}