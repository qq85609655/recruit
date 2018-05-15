package org.amberframework.web.system.auth.service.role;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.role.SysRole;

public interface SysRoleService {
  MiniRtn2Grid<SysRole> getGrid(MiniGridPageSort pageSort, String searchKey, String enabled);

  SysRole getByPrimaryKey(String primaryKey);

  void create(SysRole sysRole);

  void updateSelective(SysRole sysRole);

  void remove(String primaryKey);

  boolean hasGroupDependOnRole(String primaryKey);

  boolean hasResourceDependOnRole(String primaryKey);

  boolean hasPermissionDependOnRole(String primaryKey);
}
