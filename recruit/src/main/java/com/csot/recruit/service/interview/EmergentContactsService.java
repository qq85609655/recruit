package com.csot.recruit.service.interview;

import java.util.List;

import com.csot.recruit.model.original.interview.EmergentContacts;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EmergentContactsService {
    MiniRtn2Grid<EmergentContacts> getGrid(MiniGridPageSort pageSort, String searchKey);

    EmergentContacts getByPrimaryKey(String primaryKey);

    void create(EmergentContacts emergentContacts);

    void updateSelective(EmergentContacts emergentContacts);

    void remove(String primaryKey);

    List<EmergentContacts> queryByPersonCode(String personCode);

    void deleteByPersonCode(String personCode);
}