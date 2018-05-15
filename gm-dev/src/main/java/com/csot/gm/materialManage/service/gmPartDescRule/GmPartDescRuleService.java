package com.csot.gm.materialManage.service.gmPartDescRule;

import com.csot.gm.materialManage.model.original.gmPartDescRule.GmPartDescRule;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface GmPartDescRuleService {
  MiniRtn2Grid<GmPartDescRule> getGrid(MiniGridPageSort pageSort, String searchKey);

  GmPartDescRule getByPrimaryKey(String primaryKey);

  void create(GmPartDescRule gmPartDescRule);

  void updateSelective(GmPartDescRule gmPartDescRule);

  void remove(String primaryKey);
}