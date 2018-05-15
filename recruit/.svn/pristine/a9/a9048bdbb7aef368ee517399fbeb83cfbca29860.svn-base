package com.csot.recruit.dao.original.campus;

import com.csot.recruit.model.original.campus.CampusPost;
import com.csot.recruit.model.original.campus.CampusPostCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CampusPostMapper extends MyBatisBaseMapper {
    int countByExample(CampusPostCriteria example);

    int deleteByExample(CampusPostCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(CampusPost record);

    int insertSelective(CampusPost record);

    List<CampusPost> selectByExample(CampusPostCriteria example);

    CampusPost selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CampusPost record, @Param("example") CampusPostCriteria example);

    int updateByExample(@Param("record") CampusPost record, @Param("example") CampusPostCriteria example);

    int updateByPrimaryKeySelective(CampusPost record);

    int updateByPrimaryKey(CampusPost record);
}