package com.csot.recruit.dao.original.flow.employ;

import com.csot.recruit.model.original.flow.employ.Employ;
import com.csot.recruit.model.original.flow.employ.EmployCriteria;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EmployMapper extends MyBatisBaseMapper {
    int countByExample(EmployCriteria example);

    int deleteByExample(EmployCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Employ record);

    int insertSelective(Employ record);

    List<Employ> selectByExample(EmployCriteria example);

    Employ selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Employ record, @Param("example") EmployCriteria example);

    int updateByExample(@Param("record") Employ record, @Param("example") EmployCriteria example);

    int updateByPrimaryKeySelective(Employ record);

    int updateByPrimaryKey(Employ record);

    List<Employ> selectByCandidatePostId(Map<String,Object> param);
}