package org.amberframework.web.system.auth.service.permission;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.permission.SysPermission;

public interface SysPermissionService {
  MiniRtn2Grid<SysPermission> getGrid(MiniGridPageSort pageSort, String searchKey, String enabled);

  SysPermission getByPrimaryKey(String primaryKey);

  void create(SysPermission sysPermission);

  void updateSelective(SysPermission sysPermission);

  void remove(String primaryKey);
  
  boolean hasDependencyOnRole(String primaryKey);
}
