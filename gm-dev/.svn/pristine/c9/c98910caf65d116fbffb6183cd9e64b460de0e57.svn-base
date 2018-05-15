package com.csot.gm.materialManage.service.gmPartNoRuleMap;

import com.csot.gm.materialManage.model.original.gmPartNoRuleMap.GmPartNoRuleMap;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface GmPartNoRuleMapService {
  MiniRtn2Grid<GmPartNoRuleMap> getGrid(MiniGridPageSort pageSort, String searchKey);

  GmPartNoRuleMap getByPrimaryKey(String primaryKey);

  void create(GmPartNoRuleMap gmPartNoRuleMap);

  void updateSelective(GmPartNoRuleMap gmPartNoRuleMap);

  void remove(String primaryKey);
}