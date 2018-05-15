package com.csot.recruit.service.flow.websitePost;

import java.util.List;
import java.util.Map;

import com.csot.recruit.model.original.flow.websitePost.InstructSimpleDetail;
import com.csot.recruit.model.original.flow.websitePost.PostWebsite;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteWithBLOBs;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface PostWebsiteService {
    MiniRtn2Grid<PostWebsite> getGrid(MiniGridPageSort pageSort, Map<String, String> col);

    PostWebsite getByPrimaryKey(String primaryKey);

    void create(PostWebsiteWithBLOBs postWebsite);

    void updateSelective(PostWebsiteWithBLOBs postWebsite);

    void remove(String primaryKey);

    List<InstructSimpleDetail>
        getGridByPostId(MiniGridPageSort pageSort, Map<String, String> colMap);
}