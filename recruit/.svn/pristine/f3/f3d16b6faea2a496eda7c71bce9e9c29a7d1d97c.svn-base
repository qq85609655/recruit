package org.amberframework.web.system.auth.dao.extension;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.extension.SysAuthPermission;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.model.original.role.SysRole;

public interface SysAuthMapper extends MyBatisBaseMapper {

  List<SysRole> selectRoleByUserId(String userId);
  
  List<SysAuthPermission> selectResourcePermByUserId(String userId);
  
  List<SysResource> selectResourceByUserId(String userId);
  
  List<SysResource> selectMenuByUserId(String userId);
  
  List<SysResource> selectAllMenus();
}
