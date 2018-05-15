package com.csot.recruit.dao.original.flow.recruitdemand;

import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandLog;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandLogCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RecruitDemandLogMapper extends MyBatisBaseMapper {
    int countByExample(RecruitDemandLogCriteria example);

    int deleteByExample(RecruitDemandLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(RecruitDemandLog record);

    int insertSelective(RecruitDemandLog record);

    List<RecruitDemandLog> selectByExample(RecruitDemandLogCriteria example);

    RecruitDemandLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RecruitDemandLog record, @Param("example") RecruitDemandLogCriteria example);

    int updateByExample(@Param("record") RecruitDemandLog record, @Param("example") RecruitDemandLogCriteria example);

    int updateByPrimaryKeySelective(RecruitDemandLog record);

    int updateByPrimaryKey(RecruitDemandLog record);
}