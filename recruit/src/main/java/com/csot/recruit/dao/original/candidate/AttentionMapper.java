package com.csot.recruit.dao.original.candidate;

import com.csot.recruit.model.original.candidate.Attention;
import com.csot.recruit.model.original.candidate.AttentionCriteria;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AttentionMapper extends MyBatisBaseMapper {
    int countByExample(AttentionCriteria example);

    int deleteByExample(AttentionCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Attention record);

    int insertSelective(Attention record);

    List<Attention> selectByExample(AttentionCriteria example);

    Attention selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Attention record, @Param("example") AttentionCriteria example);

    int updateByExample(@Param("record") Attention record, @Param("example") AttentionCriteria example);

    int updateByPrimaryKeySelective(Attention record);

    int updateByPrimaryKey(Attention record);

    Attention selectAttentionByMap(Map<String, Object> param);

    void batchDelete(Map<String, Object> param);
}