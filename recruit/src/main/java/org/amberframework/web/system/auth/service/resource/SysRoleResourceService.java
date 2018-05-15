package org.amberframework.web.system.auth.service.resource;

import java.util.List;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.model.original.resource.SysRoleResource;
import org.amberframework.web.system.auth.vo.resource.SysResourceVo;

public interface SysRoleResourceService {
  MiniRtn2Grid<SysRoleResource> getGrid(MiniGridPageSort pageSort, String searchKey);

  SysRoleResource getByPrimaryKey(String primaryKey);

  void create(SysRoleResource sysRoleResource);

  void updateSelective(SysRoleResource sysRoleResource);

  void remove(String primaryKey);
  
  List<SysResourceVo> getCheckedResourceTree(Long roleId);

  void updateRoleMenu(Long roleId, List<SysResource> resourceList);
}
