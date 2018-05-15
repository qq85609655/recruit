package org.amberframework.web.system.auth.service.group;

import java.util.List;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.system.auth.model.original.group.SysGroup;

public interface SysGroupService {
  List<SysGroup> getGrid(MiniGridPageSort pageSort, String searchKey);

  SysGroup getByPrimaryKey(String primaryKey);

  void create(SysGroup sysGroup);

  void updateSelective(SysGroup sysGroup);

  void remove(String primaryKey);
  
  String createParentIdsPathStr(Long parentId);
}
