package com.csot.recruit.dao.position;

import com.csot.recruit.model.position.DepartmentRequire;
import com.csot.recruit.model.position.DepartmentRequireCriteria;

import java.math.BigDecimal;
import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface DepartmentRequireMapper extends MyBatisBaseMapper {
    int countByExample(DepartmentRequireCriteria example);

    int deleteByExample(DepartmentRequireCriteria example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(DepartmentRequire record);

    int insertSelective(DepartmentRequire record);

    List<DepartmentRequire> selectByExample(DepartmentRequireCriteria example);

    DepartmentRequire selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") DepartmentRequire record, @Param("example") DepartmentRequireCriteria example);

    int updateByExample(@Param("record") DepartmentRequire record, @Param("example") DepartmentRequireCriteria example);

    int updateByPrimaryKeySelective(DepartmentRequire record);

    int updateByPrimaryKey(DepartmentRequire record);
}