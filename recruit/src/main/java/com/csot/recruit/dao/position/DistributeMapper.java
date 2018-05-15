package com.csot.recruit.dao.position;

import com.csot.recruit.model.position.Distribute;
import com.csot.recruit.model.position.DistributeCriteria;

import java.math.BigDecimal;
import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface DistributeMapper extends MyBatisBaseMapper {
    int countByExample(DistributeCriteria example);

    int deleteByExample(DistributeCriteria example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(Distribute record);

    int insertSelective(Distribute record);

    List<Distribute> selectByExample(DistributeCriteria example);

    Distribute selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") Distribute record, @Param("example") DistributeCriteria example);

    int updateByExample(@Param("record") Distribute record, @Param("example") DistributeCriteria example);

    int updateByPrimaryKeySelective(Distribute record);

    int updateByPrimaryKey(Distribute record);
}