package com.csot.recruit.dao.original.flow.recruitdemand;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandByHandler;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandCriteria;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandVo;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RecruitDemandMapper extends MyBatisBaseMapper {
    int countByExample(RecruitDemandCriteria example);

    int deleteByExample(RecruitDemandCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RecruitDemand record);

    int insertSelective(RecruitDemand record);

    List<RecruitDemand> selectByExample(RecruitDemandCriteria example);

    RecruitDemand selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RecruitDemand record, @Param("example") RecruitDemandCriteria example);

    int updateByExample(@Param("record") RecruitDemand record, @Param("example") RecruitDemandCriteria example);

    int updateByPrimaryKeySelective(RecruitDemand record);

    int updateByPrimaryKey(RecruitDemand record);

    RecruitDemand selectByDemandId(String demandId);

    List<RecruitDemandByHandler> selectByExampleByHandler(RecruitDemandCriteria criteria);

    int countByExampleByHandler(RecruitDemandCriteria criteria);

    List<RecruitDemandVo> selectByExampleVo(RecruitDemandCriteria criteria);
}