package com.csot.recruit.dao.original.log;

import com.csot.recruit.model.original.log.OperateHistory;
import com.csot.recruit.model.original.log.OperateHistoryCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface OperateHistoryMapper extends MyBatisBaseMapper {
    int countByExample(OperateHistoryCriteria example);

    int deleteByExample(OperateHistoryCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(OperateHistory record);

    int insertSelective(OperateHistory record);

    List<OperateHistory> selectByExample(OperateHistoryCriteria example);

    OperateHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") OperateHistory record, @Param("example") OperateHistoryCriteria example);

    int updateByExample(@Param("record") OperateHistory record, @Param("example") OperateHistoryCriteria example);

    int updateByPrimaryKeySelective(OperateHistory record);

    int updateByPrimaryKey(OperateHistory record);

    List<OperateHistory> selectOperateHistoryListBycandidateId(String id);
}