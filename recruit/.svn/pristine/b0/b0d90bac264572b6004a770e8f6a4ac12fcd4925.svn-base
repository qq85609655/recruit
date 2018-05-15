package com.csot.recruit.service.flow.recruitdemand;

import java.util.List;
import java.util.Map;

import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.flow.recruitdemand.RdARalation;
import com.csot.recruit.model.original.flow.recruitdemand.RdARalationCriteria;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface RdARalationService {
    MiniRtn2Grid<RdARalation> getGrid(MiniGridPageSort pageSort, String searchKey);

    RdARalation getByPrimaryKey(String primaryKey);

    void create(RdARalation rdARalation);

    void updateSelective(RdARalation rdARalation);

    void remove(String primaryKey);

    List<Attachment> getList(RdARalationCriteria criteria);
}