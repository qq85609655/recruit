package com.csot.recruit.service.flow.websitePost;

import java.util.Map;

import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstruct;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;

public interface PostWebsiteInstructService {
    MiniRtn2Grid<PostWebsiteInstruct> getGrid(MiniGridPageSort pageSort, Map<String, String> col);

    PostWebsiteInstruct getByPrimaryKey(String primaryKey);

    void create(PostWebsiteInstruct postWebsiteInstruct);

    void updateSelective(PostWebsiteInstruct postWebsiteInstruct);

    void remove(String primaryKey);

    /**
     * 完成指令操作
     * @param id
     * @param sysUser 
     */
    void changeInstructState(String ids, SysUser sysUser);
}