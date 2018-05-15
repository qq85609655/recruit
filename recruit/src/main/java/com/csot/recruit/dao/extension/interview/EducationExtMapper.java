package com.csot.recruit.dao.extension.interview;

import com.csot.recruit.model.extension.interview.EducationExtCriteria;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface EducationExtMapper extends MyBatisBaseMapper {
    int countByExample(EducationExtCriteria example);
}