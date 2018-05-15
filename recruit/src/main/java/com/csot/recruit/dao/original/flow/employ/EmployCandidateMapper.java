package com.csot.recruit.dao.original.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployCandidate;
import com.csot.recruit.model.original.flow.employ.EmployCandidateCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EmployCandidateMapper extends MyBatisBaseMapper {
    int countByExample(EmployCandidateCriteria example);

    int deleteByExample(EmployCandidateCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(EmployCandidate record);

    int insertSelective(EmployCandidate record);

    List<EmployCandidate> selectByExample(EmployCandidateCriteria example);

    EmployCandidate selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmployCandidate record, @Param("example") EmployCandidateCriteria example);

    int updateByExample(@Param("record") EmployCandidate record, @Param("example") EmployCandidateCriteria example);

    int updateByPrimaryKeySelective(EmployCandidate record);

    int updateByPrimaryKey(EmployCandidate record);
}