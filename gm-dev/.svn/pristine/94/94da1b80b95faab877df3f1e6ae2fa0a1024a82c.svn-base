package org.amberframework.web.system.auth.service.group;

import java.util.List;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.group.SysUserGroup;
import org.amberframework.web.system.auth.model.original.user.SysUser;

public interface SysUserGroupService {
  MiniRtn2Grid<SysUserGroup> getGrid(MiniGridPageSort pageSort, String searchKey);

  SysUserGroup getByPrimaryKey(String primaryKey);

  void create(SysUserGroup sysUserGroup);

  void updateSelective(SysUserGroup sysUserGroup);

  void remove(String primaryKey);

  List<SysUser> getGroupMembers(Long groupId);

  void updateGroupMembers(Long groupId, List<SysUser> sysUserList);
}
