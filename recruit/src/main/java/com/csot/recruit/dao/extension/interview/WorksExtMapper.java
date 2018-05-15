package com.csot.recruit.dao.extension.interview;

import com.csot.recruit.model.extension.interview.WorksExtCriteria;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface WorksExtMapper extends MyBatisBaseMapper {
    int countByExample(WorksExtCriteria example);
}