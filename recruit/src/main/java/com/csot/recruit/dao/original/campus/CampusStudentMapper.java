package com.csot.recruit.dao.original.campus;

import com.csot.recruit.model.original.campus.CampusStudent;
import com.csot.recruit.model.original.campus.CampusStudentCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CampusStudentMapper extends MyBatisBaseMapper {
    int countByExample(CampusStudentCriteria example);

    int deleteByExample(CampusStudentCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(CampusStudent record);

    int insertSelective(CampusStudent record);

    List<CampusStudent> selectByExample(CampusStudentCriteria example);

    CampusStudent selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CampusStudent record, @Param("example") CampusStudentCriteria example);

    int updateByExample(@Param("record") CampusStudent record, @Param("example") CampusStudentCriteria example);

    int updateByPrimaryKeySelective(CampusStudent record);

    int updateByPrimaryKey(CampusStudent record);
    
    List<CampusStudent> selectIncompleteInfo();
    
    List<CampusStudent> selectStuInfoByStudentList(
        @Param(value = "studentIdList") List<String> studentIdList);
}