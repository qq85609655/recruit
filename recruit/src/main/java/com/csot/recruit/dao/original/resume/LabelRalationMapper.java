package com.csot.recruit.dao.original.resume;

import com.csot.recruit.model.original.resume.LabelRalation;
import com.csot.recruit.model.original.resume.LabelRalationCriteria;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface LabelRalationMapper extends MyBatisBaseMapper {
    int countByExample(LabelRalationCriteria example);

    int deleteByExample(LabelRalationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(LabelRalation record);

    int insertSelective(LabelRalation record);

    List<LabelRalation> selectByExample(LabelRalationCriteria example);

    LabelRalation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LabelRalation record, @Param("example") LabelRalationCriteria example);

    int updateByExample(@Param("record") LabelRalation record, @Param("example") LabelRalationCriteria example);

    int updateByPrimaryKeySelective(LabelRalation record);

    int updateByPrimaryKey(LabelRalation record);

    LabelRalation selectByReservseId(String candidateId);

    void updateTags(Map<String,Object> param);
}