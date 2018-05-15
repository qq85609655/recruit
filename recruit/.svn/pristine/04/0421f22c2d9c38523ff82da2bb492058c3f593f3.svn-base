package com.csot.recruit.dao.position;

import com.csot.recruit.model.position.RecruitInfor;
import com.csot.recruit.model.position.RecruitInforCriteria;

import java.math.BigDecimal;
import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RecruitInforMapper extends MyBatisBaseMapper {
    int countByExample(RecruitInforCriteria example);

    int deleteByExample(RecruitInforCriteria example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(RecruitInfor record);

    int insertSelective(RecruitInfor record);

    List<RecruitInfor> selectByExample(RecruitInforCriteria example);

    RecruitInfor selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") RecruitInfor record, @Param("example") RecruitInforCriteria example);

    int updateByExample(@Param("record") RecruitInfor record, @Param("example") RecruitInforCriteria example);

    int updateByPrimaryKeySelective(RecruitInfor record);

    int updateByPrimaryKey(RecruitInfor record);
}