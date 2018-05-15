package com.csot.recruit.service.flow.employ;

import java.util.List;

import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.flow.employ.EmployARalation;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EmployARalationService {
    MiniRtn2Grid<EmployARalation> getGrid(MiniGridPageSort pageSort, String searchKey);

    EmployARalation getByPrimaryKey(String primaryKey);

    void create(EmployARalation employARalation);

    void updateSelective(EmployARalation employARalation);

    void remove(String primaryKey);

    List<Attachment> getListByEmployeId(String id);
}