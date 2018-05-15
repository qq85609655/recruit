package com.csot.recruit.dao.original.flow.recruitdemand;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandShare;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandShareCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RecruitDemandShareMapper extends MyBatisBaseMapper {
    int countByExample(RecruitDemandShareCriteria example);

    int deleteByExample(RecruitDemandShareCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RecruitDemandShare record);

    int insertSelective(RecruitDemandShare record);

    List<RecruitDemandShare> selectByExample(RecruitDemandShareCriteria example);

    RecruitDemandShare selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RecruitDemandShare record, @Param("example") RecruitDemandShareCriteria example);

    int updateByExample(@Param("record") RecruitDemandShare record, @Param("example") RecruitDemandShareCriteria example);

    int updateByPrimaryKeySelective(RecruitDemandShare record);

    int updateByPrimaryKey(RecruitDemandShare record);
}