package com.csot.recruit.dao.extension.interview;

import com.csot.recruit.model.extension.interview.RewardExtCriteria;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface RewardExtMapper extends MyBatisBaseMapper {
    int countByExample(RewardExtCriteria example);
}