package com.csot.recruit.service.flow.websitePost;

import java.util.Map;

import com.csot.recruit.model.original.flow.websitePost.PostWebsiteLog;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface PostWebsiteLogService {
    MiniRtn2Grid<PostWebsiteLog> getGrid(MiniGridPageSort pageSort, Map<String, String> col);

    PostWebsiteLog getByPrimaryKey(String primaryKey);

    void create(PostWebsiteLog postWebsiteLog);

    void updateSelective(PostWebsiteLog postWebsiteLog);

    void remove(String primaryKey);
}