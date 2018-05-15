package org.amberframework.web.system.auth.service.resource;

import java.util.List;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.system.auth.model.original.resource.SysResource;

public interface SysResourceService {
  List<SysResource> getGrid(MiniGridPageSort pageSort, String searchKey);

  SysResource getByPrimaryKey(String primaryKey);

  void create(SysResource sysResource);

  void updateSelective(SysResource sysResource);

  void remove(String primaryKey);

  String createParentIdsPathStr(Long parentId);
  
  boolean hasRoleDependOnResource(String primaryKey);
  
  boolean hasPermissionDependOnResource(String primaryKey);
}
