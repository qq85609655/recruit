package com.csot.recruit.dao.extension.campus;

import com.csot.recruit.model.extension.campus.CampusAddressbookExtCriteria;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface CampusAddressbookExtMapper extends MyBatisBaseMapper {
    int countByExample(CampusAddressbookExtCriteria example);
}