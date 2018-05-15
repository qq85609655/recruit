package com.csot.recruit.dao.original.campus;

import com.csot.recruit.model.original.campus.CampusTaskHistory;
import com.csot.recruit.model.original.campus.CampusTaskHistoryCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CampusTaskHistoryMapper extends MyBatisBaseMapper {
    int countByExample(CampusTaskHistoryCriteria example);

    int deleteByExample(CampusTaskHistoryCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(CampusTaskHistory record);

    int insertSelective(CampusTaskHistory record);

    List<CampusTaskHistory> selectByExample(CampusTaskHistoryCriteria example);

    CampusTaskHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CampusTaskHistory record, @Param("example") CampusTaskHistoryCriteria example);

    int updateByExample(@Param("record") CampusTaskHistory record, @Param("example") CampusTaskHistoryCriteria example);

    int updateByPrimaryKeySelective(CampusTaskHistory record);

    int updateByPrimaryKey(CampusTaskHistory record);
}