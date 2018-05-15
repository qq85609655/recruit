package com.csot.recruit.dao.original.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployWork;
import com.csot.recruit.model.original.flow.employ.EmployWorkCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EmployWorkMapper extends MyBatisBaseMapper {
    int countByExample(EmployWorkCriteria example);

    int deleteByExample(EmployWorkCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(EmployWork record);

    int insertSelective(EmployWork record);

    List<EmployWork> selectByExample(EmployWorkCriteria example);

    EmployWork selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmployWork record, @Param("example") EmployWorkCriteria example);

    int updateByExample(@Param("record") EmployWork record, @Param("example") EmployWorkCriteria example);

    int updateByPrimaryKeySelective(EmployWork record);

    int updateByPrimaryKey(EmployWork record);
}