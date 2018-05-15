package com.csot.recruit.service.resume;

import com.csot.recruit.model.original.resume.Basicinfor;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface BasicinforService {
    MiniRtn2Grid<Basicinfor> getGrid(MiniGridPageSort pageSort, String searchKey);

    Basicinfor getByPrimaryKey(String primaryKey);

    void create(Basicinfor basicinfor);

    void updateSelective(Basicinfor basicinfor);

    void remove(String primaryKey);
}