package org.amberframework.web.system.auth.service.permission;

import java.util.List;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.permission.SysPermission;
import org.amberframework.web.system.auth.model.original.permission.SysRoleResourcePermission;

public interface SysRoleResourcePermissionService {
  MiniRtn2Grid<SysRoleResourcePermission> getGrid(MiniGridPageSort pageSort, String searchKey);

  SysRoleResourcePermission getByPrimaryKey(String primaryKey);

  void create(SysRoleResourcePermission sysRoleResourcePermission);

  void updateSelective(SysRoleResourcePermission sysRoleResourcePermission);

  void remove(String primaryKey);

  List<SysPermission> getRoleResourcePerms(Long roleId, Long resourceId);

  void updateRoleResourcePerms(Long roleId, Long resourceId, List<SysPermission> sysPermissionList);
}
