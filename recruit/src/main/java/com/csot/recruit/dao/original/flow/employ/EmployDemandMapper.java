package com.csot.recruit.dao.original.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployDemand;
import com.csot.recruit.model.original.flow.employ.EmployDemandCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EmployDemandMapper extends MyBatisBaseMapper {
    int countByExample(EmployDemandCriteria example);

    int deleteByExample(EmployDemandCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(EmployDemand record);

    int insertSelective(EmployDemand record);

    List<EmployDemand> selectByExample(EmployDemandCriteria example);

    EmployDemand selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmployDemand record, @Param("example") EmployDemandCriteria example);

    int updateByExample(@Param("record") EmployDemand record, @Param("example") EmployDemandCriteria example);

    int updateByPrimaryKeySelective(EmployDemand record);

    int updateByPrimaryKey(EmployDemand record);
}