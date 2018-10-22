package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Article;
import pojo.ArticleExample;

public interface ArticleMapper {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);
}