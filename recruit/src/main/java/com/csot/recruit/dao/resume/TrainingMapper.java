package com.csot.recruit.dao.resume;

import com.csot.recruit.model.nresume.Training;
import com.csot.recruit.model.resume.TrainingCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface TrainingMapper extends MyBatisBaseMapper {
    int countByExample(TrainingCriteria example);

    int deleteByExample(TrainingCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Training record);

    int insertSelective(Training record);

    List<Training> selectByExample(TrainingCriteria example);

    Training selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Training record, @Param("example") TrainingCriteria example);

    int updateByExample(@Param("record") Training record, @Param("example") TrainingCriteria example);

    int updateByPrimaryKeySelective(Training record);

    int updateByPrimaryKey(Training record);
}