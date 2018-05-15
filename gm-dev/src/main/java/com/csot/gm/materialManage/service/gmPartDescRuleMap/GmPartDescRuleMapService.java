package com.csot.gm.materialManage.service.gmPartDescRuleMap;

import com.csot.gm.materialManage.model.original.gmPartDescRuleMap.GmPartDescRuleMap;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface GmPartDescRuleMapService {
  MiniRtn2Grid<GmPartDescRuleMap> getGrid(MiniGridPageSort pageSort, String searchKey);

  GmPartDescRuleMap getByPrimaryKey(String primaryKey);

  void create(GmPartDescRuleMap gmPartDescRuleMap);

  void updateSelective(GmPartDescRuleMap gmPartDescRuleMap);

  void remove(String primaryKey);
}