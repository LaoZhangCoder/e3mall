package BlogService;

import java.util.List;

import javax.security.auth.login.LoginException;

import pojo.Article;
import pojo.Comment;
import pojo.Links;
import pojo.Resultdata;
import pojo.User;
import pojo.Vo;

public interface Managerarticle {
public List<Article> selectall();
public void deletebyid(int id);
void updatepassword(String oldPassword,String newPassword,String username) throws LoginException;
void getalldata(Resultdata data);
void getallcategory(Resultdata data);
long getcount();
void getthispageitem(Resultdata resultdata,String tag,int thispage);
void getnewsarticle(Resultdata data);
void gettagdata(String tag,int thispage,Resultdata resultdata);
long getcountbytag(String tag);
public Article getdetailbyid(int id);
public void addusermessage(User user);
List<User> getusercommentsbyid(int id);
List<Comment> getcommenttotals();
List <User> getnewcomment();
List<Links> getalllinks();
void addpageviews(int id);


}
