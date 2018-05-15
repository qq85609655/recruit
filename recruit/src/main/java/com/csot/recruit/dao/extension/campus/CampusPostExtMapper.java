package com.csot.recruit.dao.extension.campus;

import com.csot.recruit.model.extension.campus.CampusPostExtCriteria;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface CampusPostExtMapper extends MyBatisBaseMapper {
    int countByExample(CampusPostExtCriteria example);
}