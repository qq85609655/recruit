package com.csot.recruit.dao.extension.interview;

import com.csot.recruit.model.extension.interview.FamilyMemberExtCriteria;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface FamilyMemberExtMapper extends MyBatisBaseMapper {
    int countByExample(FamilyMemberExtCriteria example);
}