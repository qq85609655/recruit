package com.csot.recruit.dao.original.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployARalation;
import com.csot.recruit.model.original.flow.employ.EmployARalationCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EmployARalationMapper extends MyBatisBaseMapper {
    int countByExample(EmployARalationCriteria example);

    int deleteByExample(EmployARalationCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(EmployARalation record);

    int insertSelective(EmployARalation record);

    List<EmployARalation> selectByExample(EmployARalationCriteria example);

    EmployARalation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmployARalation record, @Param("example") EmployARalationCriteria example);

    int updateByExample(@Param("record") EmployARalation record, @Param("example") EmployARalationCriteria example);

    int updateByPrimaryKeySelective(EmployARalation record);

    int updateByPrimaryKey(EmployARalation record);
}