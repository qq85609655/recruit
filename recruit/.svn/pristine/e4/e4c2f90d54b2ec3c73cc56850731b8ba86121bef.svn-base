package com.csot.recruit.dao.original.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployBlacklist;
import com.csot.recruit.model.original.flow.employ.EmployBlacklistCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EmployBlacklistMapper extends MyBatisBaseMapper {
    int countByExample(EmployBlacklistCriteria example);

    int deleteByExample(EmployBlacklistCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(EmployBlacklist record);

    int insertSelective(EmployBlacklist record);

    List<EmployBlacklist> selectByExample(EmployBlacklistCriteria example);

    EmployBlacklist selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmployBlacklist record, @Param("example") EmployBlacklistCriteria example);

    int updateByExample(@Param("record") EmployBlacklist record, @Param("example") EmployBlacklistCriteria example);

    int updateByPrimaryKeySelective(EmployBlacklist record);

    int updateByPrimaryKey(EmployBlacklist record);
}