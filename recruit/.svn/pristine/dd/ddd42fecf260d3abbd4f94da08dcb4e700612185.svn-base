package com.csot.recruit.dao.position;

import com.csot.recruit.model.position.RequireInfor;
import com.csot.recruit.model.position.RequireInforCriteria;

import java.math.BigDecimal;
import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RequireInforMapper extends MyBatisBaseMapper {
    int countByExample(RequireInforCriteria example);

    int deleteByExample(RequireInforCriteria example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(RequireInfor record);

    int insertSelective(RequireInfor record);

    List<RequireInfor> selectByExample(RequireInforCriteria example);

    RequireInfor selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") RequireInfor record, @Param("example") RequireInforCriteria example);

    int updateByExample(@Param("record") RequireInfor record, @Param("example") RequireInforCriteria example);

    int updateByPrimaryKeySelective(RequireInfor record);

    int updateByPrimaryKey(RequireInfor record);
}