package com.csot.recruit.dao.extension.interview;

import com.csot.recruit.model.extension.interview.InterviewInfoExtCriteria;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface InterviewInfoExtMapper extends MyBatisBaseMapper {
    int countByExample(InterviewInfoExtCriteria example);
}