package com.csot.recruit.dao.original.campus;

import com.csot.recruit.model.original.campus.CampusTaskFirst;
import com.csot.recruit.model.original.campus.CampusTaskFirstCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CampusTaskFirstMapper extends MyBatisBaseMapper {
    int countByExample(CampusTaskFirstCriteria example);

    int deleteByExample(CampusTaskFirstCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(CampusTaskFirst record);

    int insertSelective(CampusTaskFirst record);

    List<CampusTaskFirst> selectByExample(CampusTaskFirstCriteria example);

    CampusTaskFirst selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CampusTaskFirst record, @Param("example") CampusTaskFirstCriteria example);

    int updateByExample(@Param("record") CampusTaskFirst record, @Param("example") CampusTaskFirstCriteria example);

    int updateByPrimaryKeySelective(CampusTaskFirst record);

    int updateByPrimaryKey(CampusTaskFirst record);
}