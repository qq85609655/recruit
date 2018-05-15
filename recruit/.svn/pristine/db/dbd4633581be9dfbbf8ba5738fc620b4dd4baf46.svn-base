package com.csot.recruit.service.position;

import com.csot.recruit.model.position.RequireInfor;
import com.csot.recruit.model.position.RequireInforCriteria;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface RequireInforService {
    MiniRtn2Grid<RequireInfor> getGrid(MiniGridPageSort pageSort, String searchKey);

    RequireInfor getByPrimaryKey(String primaryKey);

    void create(RequireInfor requireInfor);

    void updateSelective(RequireInfor requireInfor);

    void remove(String primaryKey);
    
    /***
     * 根据条件删除招聘职位的基本要求
     * @param example
     */
    void removeByExample(RequireInforCriteria example);
}