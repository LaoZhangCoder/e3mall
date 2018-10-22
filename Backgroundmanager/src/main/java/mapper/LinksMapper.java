package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Links;
import pojo.LinksExample;

public interface LinksMapper {
    int countByExample(LinksExample example);

    int deleteByExample(LinksExample example);

    int deleteByPrimaryKey(String url);

    int insert(Links record);

    int insertSelective(Links record);

    List<Links> selectByExample(LinksExample example);

    Links selectByPrimaryKey(String url);

    int updateByExampleSelective(@Param("record") Links record, @Param("example") LinksExample example);

    int updateByExample(@Param("record") Links record, @Param("example") LinksExample example);

    int updateByPrimaryKeySelective(Links record);

    int updateByPrimaryKey(Links record);
}