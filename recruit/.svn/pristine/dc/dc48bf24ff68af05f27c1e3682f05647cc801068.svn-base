package com.csot.recruit.dao.original.campus;

import com.csot.recruit.model.original.campus.CampusTask;
import com.csot.recruit.model.original.campus.CampusTaskCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CampusTaskMapper extends MyBatisBaseMapper {
  int countByExample(CampusTaskCriteria example);

  int deleteByExample(CampusTaskCriteria example);

  int deleteByPrimaryKey(String id);

  int insert(CampusTask record);

  int insertSelective(CampusTask record);

  List<CampusTask> selectByExample(CampusTaskCriteria example);

  CampusTask selectByPrimaryKey(String id);

  int updateByExampleSelective(@Param("record") CampusTask record,
      @Param("example") CampusTaskCriteria example);

  int updateByExample(@Param("record") CampusTask record,
      @Param("example") CampusTaskCriteria example);

  int updateByPrimaryKeySelective(CampusTask record);

  int updateByPrimaryKey(CampusTask record);

  List<CampusTask> getTaskSum(@Param("orgId") String orgId, @Param("postId") String postId,
      @Param("siteId") String siteId, @Param("yearth") String yearth);
}
