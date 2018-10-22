package mapper;

import java.util.List;

import pojo.Article;
import pojo.Categorye;
import pojo.Comment;
import pojo.Resultdata;
import pojo.User;
import pojo.Vo;

public interface CategoryMapper {
    List<Categorye> getCategory();
    int getallsize();
    List<Article> getthispagecontent(Vo vo);
    List<Article> getnewdata();
    List<Article> gettagdata(Vo vo);
    long getcoutbytag(Vo vo);
    List<Article> getdetailbyid(int id);
    List<User> getcomments(int id);
    List<Comment> getcountcomment();
    List<User> getnewcomments();
}
