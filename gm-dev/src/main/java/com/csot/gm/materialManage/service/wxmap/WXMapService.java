package com.csot.gm.materialManage.service.wxmap;

import com.csot.gm.materialManage.model.original.wxmap.WXMap;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface WXMapService {
  MiniRtn2Grid<WXMap> getGrid(MiniGridPageSort pageSort, String searchKey);

  WXMap getByPrimaryKey(String primaryKey);

  void create(WXMap wxMap);

  void updateSelective(WXMap wxMap);

  void remove(String primaryKey);
}