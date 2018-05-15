package haha.test.dao.original.user;

import haha.test.model.original.user.TestBook;
import haha.test.model.original.user.TestBookCriteria;
import java.math.BigDecimal;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface TestBookMapper extends MyBatisBaseMapper {
  int countByExample(TestBookCriteria example);

  int deleteByExample(TestBookCriteria example);

  int deleteByPrimaryKey(BigDecimal id);

  int insert(TestBook record);

  int insertSelective(TestBook record);

  List<TestBook> selectByExample(TestBookCriteria example);

  TestBook selectByPrimaryKey(BigDecimal id);

  int updateByExampleSelective(@Param("record") TestBook record,
      @Param("example") TestBookCriteria example);

  int updateByExample(@Param("record") TestBook record, @Param("example") TestBookCriteria example);

  int updateByPrimaryKeySelective(TestBook record);

  int updateByPrimaryKey(TestBook record);
}
