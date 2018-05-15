package com.csot.recruit.service.flow.employ;

import com.csot.recruit.model.original.flow.employ.EmployRefuseOffer;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface EmployRefuseOfferService {
    MiniRtn2Grid<EmployRefuseOffer> getGrid(MiniGridPageSort pageSort, String searchKey);

    EmployRefuseOffer getByPrimaryKey(String primaryKey);

    void create(EmployRefuseOffer employRefuseOffer);

    void updateSelective(EmployRefuseOffer employRefuseOffer);

    void remove(String primaryKey);

    EmployRefuseOffer getByEmployeId(String id);

    void refuseOffer(EmployRefuseOffer employRefuseOffer);

    void refuseEntry(EmployRefuseOffer employRefuseOffer);
}