package org.amberframework.web.system.auth.service.role;

import java.util.List;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.role.SysGroupRole;
import org.amberframework.web.system.auth.model.original.role.SysRole;

public interface SysGroupRoleService {
  MiniRtn2Grid<SysGroupRole> getGrid(MiniGridPageSort pageSort, String searchKey);

  SysGroupRole getByPrimaryKey(String primaryKey);

  void create(SysGroupRole sysGroupRole);

  void updateSelective(SysGroupRole sysGroupRole);

  void remove(String primaryKey);

  List<SysRole> getGroupRoles(Long groupId);

  void updateGroupRoles(Long groupId, List<SysRole> sysRoleList);
}
