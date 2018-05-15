package com.csot.recruit.service.flow.interview;

import java.util.List;

import com.csot.recruit.model.original.flow.interview.IbARalation;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface IbARalationService {
    MiniRtn2Grid<IbARalation> getGrid(MiniGridPageSort pageSort, String searchKey);

    IbARalation getByPrimaryKey(String primaryKey);

    void create(IbARalation ibARalation);

    void updateSelective(IbARalation ibARalation);

    void remove(String primaryKey);

    List<IbARalation> getListByInterviewBookId(String interviewBookId);
}