package org.amberframework.web.system.auth.dao.extension.permission;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.extension.permission.SysRoleResourcePermissionExtCriteria;
import org.amberframework.web.system.auth.model.original.permission.SysPermission;
import org.apache.ibatis.annotations.Param;

public interface SysRoleResourcePermissionExtensionMapper extends MyBatisBaseMapper {
  int countByExample(SysRoleResourcePermissionExtCriteria example);

  List<SysPermission> getPermissions(@Param("roleId") Long roleId,
      @Param("resourceId") Long resourceId);
  
  List<Long> selectDistResourceIdByRoleId(Long roleId);
}
