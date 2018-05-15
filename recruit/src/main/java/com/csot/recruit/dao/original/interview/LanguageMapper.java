package com.csot.recruit.dao.original.interview;

import com.csot.recruit.model.original.interview.Language;
import com.csot.recruit.model.original.interview.LanguageCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface LanguageMapper extends MyBatisBaseMapper {
    int countByExample(LanguageCriteria example);

    int deleteByExample(LanguageCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Language record);

    int insertSelective(Language record);

    List<Language> selectByExample(LanguageCriteria example);

    Language selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Language record, @Param("example") LanguageCriteria example);

    int updateByExample(@Param("record") Language record, @Param("example") LanguageCriteria example);

    int updateByPrimaryKeySelective(Language record);

    int updateByPrimaryKey(Language record);

    List<Language> selectByPersonCode(String personCode);
}