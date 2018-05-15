package com.csot.recruit.dao.original.interview;

import com.csot.recruit.model.original.interview.Recommend;
import com.csot.recruit.model.original.interview.RecommendCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RecommendMapper extends MyBatisBaseMapper {
    int countByExample(RecommendCriteria example);

    int deleteByExample(RecommendCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Recommend record);

    int insertSelective(Recommend record);

    List<Recommend> selectByExample(RecommendCriteria example);

    Recommend selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Recommend record, @Param("example") RecommendCriteria example);

    int updateByExample(@Param("record") Recommend record, @Param("example") RecommendCriteria example);

    int updateByPrimaryKeySelective(Recommend record);

    int updateByPrimaryKey(Recommend record);

    List<Recommend> selectByPersonCode(String personCode);
    
    void deleteByPersonCode(String personCode);
}