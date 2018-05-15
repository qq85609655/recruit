package com.csot.recruit.dao.original.interview;

import com.csot.recruit.model.original.interview.FamilyMember;
import com.csot.recruit.model.original.interview.FamilyMemberCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface FamilyMemberMapper extends MyBatisBaseMapper {
    int countByExample(FamilyMemberCriteria example);

    int deleteByExample(FamilyMemberCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(FamilyMember record);

    int insertSelective(FamilyMember record);

    List<FamilyMember> selectByExample(FamilyMemberCriteria example);

    FamilyMember selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") FamilyMember record, @Param("example") FamilyMemberCriteria example);

    int updateByExample(@Param("record") FamilyMember record, @Param("example") FamilyMemberCriteria example);

    int updateByPrimaryKeySelective(FamilyMember record);

    int updateByPrimaryKey(FamilyMember record);

    List<FamilyMember> selectByPersonCode(String personCode);
}