package com.csot.recruit.dao.org;

import com.csot.recruit.model.org.Organazation;
import com.csot.recruit.model.org.OrganazationCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface OrganazationMapper extends MyBatisBaseMapper {
    int countByExample(OrganazationCriteria example);

    int deleteByExample(OrganazationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Organazation record);

    int insertSelective(Organazation record);

    List<Organazation> selectByExample(OrganazationCriteria example);

    Organazation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Organazation record, @Param("example") OrganazationCriteria example);

    int updateByExample(@Param("record") Organazation record, @Param("example") OrganazationCriteria example);

    int updateByPrimaryKeySelective(Organazation record);

    int updateByPrimaryKey(Organazation record);
    
    Organazation selectOrgAndUser(String id);
}