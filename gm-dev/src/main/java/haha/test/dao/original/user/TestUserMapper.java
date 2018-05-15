package haha.test.dao.original.user;

import haha.test.model.original.user.TestUser;
import haha.test.model.original.user.TestUserCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface TestUserMapper extends MyBatisBaseMapper {
  int countByExample(TestUserCriteria example);

  int deleteByExample(TestUserCriteria example);

  int deleteByPrimaryKey(String id);

  int insert(TestUser record);

  int insertSelective(TestUser record);

  List<TestUser> selectByExample(TestUserCriteria example);

  TestUser selectByPrimaryKey(String id);

  int updateByExampleSelective(@Param("record") TestUser record,
      @Param("example") TestUserCriteria example);

  int updateByExample(@Param("record") TestUser record, @Param("example") TestUserCriteria example);

  int updateByPrimaryKeySelective(TestUser record);

  int updateByPrimaryKey(TestUser record);
}
