package com.csot.recruit.dao.original.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployRefuseOffer;
import com.csot.recruit.model.original.flow.employ.EmployRefuseOfferCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EmployRefuseOfferMapper extends MyBatisBaseMapper {
    int countByExample(EmployRefuseOfferCriteria example);

    int deleteByExample(EmployRefuseOfferCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(EmployRefuseOffer record);

    int insertSelective(EmployRefuseOffer record);

    List<EmployRefuseOffer> selectByExample(EmployRefuseOfferCriteria example);

    EmployRefuseOffer selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmployRefuseOffer record, @Param("example") EmployRefuseOfferCriteria example);

    int updateByExample(@Param("record") EmployRefuseOffer record, @Param("example") EmployRefuseOfferCriteria example);

    int updateByPrimaryKeySelective(EmployRefuseOffer record);

    int updateByPrimaryKey(EmployRefuseOffer record);

    EmployRefuseOffer getByEmployeId(String employId);
}