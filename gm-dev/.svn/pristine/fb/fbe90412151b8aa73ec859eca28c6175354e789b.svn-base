package com.csot.gm.materialManage.service.partNoRule;

import com.csot.gm.materialManage.model.original.partNoRule.PartNoRule;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface PartNoRuleService {
  MiniRtn2Grid<PartNoRule> getGrid(MiniGridPageSort pageSort, String searchKey);

  PartNoRule getByPrimaryKey(String primaryKey);

  void create(PartNoRule partNoRule);

  void updateSelective(PartNoRule partNoRule);

  void remove(String primaryKey);
}