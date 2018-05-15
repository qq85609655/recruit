package com.csot.recruit.dao.original.interview;

import com.csot.recruit.model.original.interview.Works;
import com.csot.recruit.model.original.interview.WorksCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface WorksMapper extends MyBatisBaseMapper {
    int countByExample(WorksCriteria example);

    int deleteByExample(WorksCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Works record);

    int insertSelective(Works record);

    List<Works> selectByExample(WorksCriteria example);

    Works selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Works record, @Param("example") WorksCriteria example);

    int updateByExample(@Param("record") Works record, @Param("example") WorksCriteria example);

    int updateByPrimaryKeySelective(Works record);

    int updateByPrimaryKey(Works record);
}