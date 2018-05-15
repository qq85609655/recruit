package com.csot.recruit.dao.original.interview;

import com.csot.recruit.model.original.interview.Illustrate;
import com.csot.recruit.model.original.interview.IllustrateCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface IllustrateMapper extends MyBatisBaseMapper {
    int countByExample(IllustrateCriteria example);

    int deleteByExample(IllustrateCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Illustrate record);

    int insertSelective(Illustrate record);

    List<Illustrate> selectByExample(IllustrateCriteria example);

    Illustrate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Illustrate record, @Param("example") IllustrateCriteria example);

    int updateByExample(@Param("record") Illustrate record, @Param("example") IllustrateCriteria example);

    int updateByPrimaryKeySelective(Illustrate record);

    int updateByPrimaryKey(Illustrate record);

    Illustrate selectByPersonCode(String personCode);
}