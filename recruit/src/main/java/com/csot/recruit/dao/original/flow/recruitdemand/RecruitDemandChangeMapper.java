package com.csot.recruit.dao.original.flow.recruitdemand;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandChange;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandChangeCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RecruitDemandChangeMapper extends MyBatisBaseMapper {
    int countByExample(RecruitDemandChangeCriteria example);

    int deleteByExample(RecruitDemandChangeCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RecruitDemandChange record);

    int insertSelective(RecruitDemandChange record);

    List<RecruitDemandChange> selectByExample(RecruitDemandChangeCriteria example);

    RecruitDemandChange selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RecruitDemandChange record, @Param("example") RecruitDemandChangeCriteria example);

    int updateByExample(@Param("record") RecruitDemandChange record, @Param("example") RecruitDemandChangeCriteria example);

    int updateByPrimaryKeySelective(RecruitDemandChange record);

    int updateByPrimaryKey(RecruitDemandChange record);

    List<String> getSuperior(String workCode);
}