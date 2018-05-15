package com.csot.recruit.dao.original.flow.websitePost;

import com.csot.recruit.model.original.flow.websitePost.PostWebsite;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteCriteria;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteWithBLOBs;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface PostWebsiteMapper extends MyBatisBaseMapper {
    int countByExample(PostWebsiteCriteria example);

    int deleteByExample(PostWebsiteCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(PostWebsiteWithBLOBs record);

    int insertSelective(PostWebsiteWithBLOBs record);

    List<PostWebsiteWithBLOBs> selectByExampleWithBLOBs(PostWebsiteCriteria example);

    List<PostWebsite> selectByExample(PostWebsiteCriteria example);

    PostWebsiteWithBLOBs selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PostWebsiteWithBLOBs record, @Param("example") PostWebsiteCriteria example);

    int updateByExampleWithBLOBs(@Param("record") PostWebsiteWithBLOBs record, @Param("example") PostWebsiteCriteria example);

    int updateByExample(@Param("record") PostWebsite record, @Param("example") PostWebsiteCriteria example);

    int updateByPrimaryKeySelective(PostWebsiteWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PostWebsiteWithBLOBs record);

    int updateByPrimaryKey(PostWebsite record);
}