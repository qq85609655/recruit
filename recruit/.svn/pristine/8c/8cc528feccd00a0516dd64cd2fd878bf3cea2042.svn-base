package com.csot.recruit.service.interview;

import java.util.List;

import com.csot.recruit.model.original.interview.FamilyMember;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface FamilyMemberService {
    MiniRtn2Grid<FamilyMember> getGrid(MiniGridPageSort pageSort, String searchKey);

    FamilyMember getByPrimaryKey(String primaryKey);

    void create(FamilyMember familyMember);

    void updateSelective(FamilyMember familyMember);

    void remove(String primaryKey);

    List<FamilyMember> queryByPersonCode(String personCode);
}