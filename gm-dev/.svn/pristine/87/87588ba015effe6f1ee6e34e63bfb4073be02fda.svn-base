package com.csot.gm.materialManage.service.systemNotice;

import com.csot.gm.materialManage.model.original.systemNotice.SystemNotice;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface SystemNoticeService {
  MiniRtn2Grid<SystemNotice> getGrid(MiniGridPageSort pageSort, String searchKey);

  SystemNotice getByPrimaryKey(String primaryKey);

  void create(SystemNotice systemNotice);

  void updateSelective(SystemNotice systemNotice);

  void remove(String primaryKey);
}