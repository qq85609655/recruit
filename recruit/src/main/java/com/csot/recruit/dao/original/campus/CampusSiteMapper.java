package com.csot.recruit.dao.original.campus;

import com.csot.recruit.model.original.campus.CampusSite;
import com.csot.recruit.model.original.campus.CampusSiteCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CampusSiteMapper extends MyBatisBaseMapper {
    int countByExample(CampusSiteCriteria example);

    int deleteByExample(CampusSiteCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(CampusSite record);

    int insertSelective(CampusSite record);

    List<CampusSite> selectByExample(CampusSiteCriteria example);

    CampusSite selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CampusSite record, @Param("example") CampusSiteCriteria example);

    int updateByExample(@Param("record") CampusSite record, @Param("example") CampusSiteCriteria example);

    int updateByPrimaryKeySelective(CampusSite record);

    int updateByPrimaryKey(CampusSite record);
}