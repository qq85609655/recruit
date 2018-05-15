package com.csot.recruit.dao.original.flow.websitePost;

import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstruct;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstructCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface PostWebsiteInstructMapper extends MyBatisBaseMapper {
    int countByExample(PostWebsiteInstructCriteria example);

    int deleteByExample(PostWebsiteInstructCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(PostWebsiteInstruct record);

    int insertSelective(PostWebsiteInstruct record);

    List<PostWebsiteInstruct> selectByExample(PostWebsiteInstructCriteria example);

    PostWebsiteInstruct selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") PostWebsiteInstruct record, @Param("example") PostWebsiteInstructCriteria example);

    int updateByExample(@Param("record") PostWebsiteInstruct record, @Param("example") PostWebsiteInstructCriteria example);

    int updateByPrimaryKeySelective(PostWebsiteInstruct record);

    int updateByPrimaryKey(PostWebsiteInstruct record);
}