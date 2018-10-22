package mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Rootuser;
import pojo.RootuserExample;

public interface RootuserMapper {
    int countByExample(RootuserExample example);

    int deleteByExample(RootuserExample example);

    int deleteByPrimaryKey(String username);

    int insert(Rootuser record);

    int insertSelective(Rootuser record);

    List<Rootuser> selectByExample(RootuserExample example);

    Rootuser selectByPrimaryKey(String username);

    int updateByExampleSelective(@Param("record") Rootuser record, @Param("example") RootuserExample example);

    int updateByExample(@Param("record") Rootuser record, @Param("example") RootuserExample example);

    int updateByPrimaryKeySelective(Rootuser record);

    int updateByPrimaryKey(Rootuser record);
}