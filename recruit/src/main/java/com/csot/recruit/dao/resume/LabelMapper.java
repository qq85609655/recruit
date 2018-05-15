package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.Label;
import com.csot.recruit.model.resume.LabelCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface LabelMapper extends MyBatisBaseMapper {
    int countByExample(LabelCriteria example);

    int deleteByExample(LabelCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Label record);

    int insertSelective(Label record);

    List<Label> selectByExample(LabelCriteria example);

    Label selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Label record, @Param("example") LabelCriteria example);

    int updateByExample(@Param("record") Label record, @Param("example") LabelCriteria example);

    int updateByPrimaryKeySelective(Label record);

    int updateByPrimaryKey(Label record);
    
    int getLabelCount(Label label);
    
    List<Label> getLabelListByIds(List<String> labels);
    
    List<Label> getLabelListByNames(List<String> names);
}