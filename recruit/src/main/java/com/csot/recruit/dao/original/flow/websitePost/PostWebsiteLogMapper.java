package com.csot.recruit.dao.original.flow.websitePost;

import com.csot.recruit.model.original.flow.websitePost.PostWebsiteLog;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteLogCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface PostWebsiteLogMapper extends MyBatisBaseMapper {
    int countByExample(PostWebsiteLogCriteria example);

    int deleteByExample(PostWebsiteLogCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(PostWebsiteLog record);

    int insertSelective(PostWebsiteLog record);

    List<PostWebsiteLog> selectByExample(PostWebsiteLogCriteria example);

    PostWebsiteLog selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PostWebsiteLog record, @Param("example") PostWebsiteLogCriteria example);

    int updateByExample(@Param("record") PostWebsiteLog record, @Param("example") PostWebsiteLogCriteria example);

    int updateByPrimaryKeySelective(PostWebsiteLog record);

    int updateByPrimaryKey(PostWebsiteLog record);
}