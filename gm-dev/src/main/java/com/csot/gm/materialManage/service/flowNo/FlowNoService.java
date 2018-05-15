package com.csot.gm.materialManage.service.flowNo;

import com.csot.gm.materialManage.model.original.flowNo.FlowNo;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface FlowNoService {
  MiniRtn2Grid<FlowNo> getGrid(MiniGridPageSort pageSort, String searchKey);

  FlowNo getByPrimaryKey(String primaryKey);

  void create(FlowNo flowNo);

  void updateSelective(FlowNo flowNo);

  void remove(String primaryKey);
}