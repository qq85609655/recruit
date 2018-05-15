package com.csot.recruit.dao.position;

import com.csot.recruit.model.position.PositionMana;
import com.csot.recruit.model.position.RecruitPosition;
import com.csot.recruit.model.position.RecruitPositionCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RecruitPositionMapper extends MyBatisBaseMapper {
    int countByExample(RecruitPositionCriteria example);

    int deleteByExample(RecruitPositionCriteria example);

    int deleteByPrimaryKey(String recruitPositionId);

    int insert(RecruitPosition record);

    int insertSelective(RecruitPosition record);

    List<RecruitPosition> selectByExample(RecruitPositionCriteria example);

    RecruitPosition selectByPrimaryKey(String recruitPositionId);

    int updateByExampleSelective(@Param("record") RecruitPosition record, @Param("example") RecruitPositionCriteria example);

    int updateByExample(@Param("record") RecruitPosition record, @Param("example") RecruitPositionCriteria example);

    int updateByPrimaryKeySelective(RecruitPosition record);

    int updateByPrimaryKey(RecruitPosition record);
    
    String maxPosiCode();
    
    RecruitPosition getPositionByCode(String positionCode);
    
    List<PositionMana> getPositionByStatus(String status);
}