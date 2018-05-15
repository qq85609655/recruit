package com.csot.recruit.service.campus;

import com.csot.recruit.model.original.campus.CampusTaskHistory;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface CampusTaskHistoryService {
  MiniRtn2Grid<CampusTaskHistory> getGrid(MiniGridPageSort pageSort, String yearth, String organizationId,
                                          String siteId, String postId);

  CampusTaskHistory getByPrimaryKey(String primaryKey);

  void create(CampusTaskHistory campusTaskHistory);

  void updateSelective(CampusTaskHistory campusTaskHistory);

  void remove(String primaryKey);
}