package com.csot.recruit.dao.original.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployEducation;
import com.csot.recruit.model.original.flow.employ.EmployEducationCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EmployEducationMapper extends MyBatisBaseMapper {
    int countByExample(EmployEducationCriteria example);

    int deleteByExample(EmployEducationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(EmployEducation record);

    int insertSelective(EmployEducation record);

    List<EmployEducation> selectByExample(EmployEducationCriteria example);

    EmployEducation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmployEducation record, @Param("example") EmployEducationCriteria example);

    int updateByExample(@Param("record") EmployEducation record, @Param("example") EmployEducationCriteria example);

    int updateByPrimaryKeySelective(EmployEducation record);

    int updateByPrimaryKey(EmployEducation record);
}