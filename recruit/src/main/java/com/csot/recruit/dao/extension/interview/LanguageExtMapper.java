package com.csot.recruit.dao.extension.interview;

import com.csot.recruit.model.extension.interview.LanguageExtCriteria;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface LanguageExtMapper extends MyBatisBaseMapper {
    int countByExample(LanguageExtCriteria example);
}