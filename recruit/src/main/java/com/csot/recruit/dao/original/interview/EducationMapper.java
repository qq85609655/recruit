package com.csot.recruit.dao.original.interview;

import com.csot.recruit.model.original.interview.Education;
import com.csot.recruit.model.original.interview.EducationCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EducationMapper extends MyBatisBaseMapper {
    int countByExample(EducationCriteria example);

    int deleteByExample(EducationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Education record);

    int insertSelective(Education record);

    List<Education> selectByExample(EducationCriteria example);

    Education selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Education record, @Param("example") EducationCriteria example);

    int updateByExample(@Param("record") Education record, @Param("example") EducationCriteria example);

    int updateByPrimaryKeySelective(Education record);

    int updateByPrimaryKey(Education record);
}