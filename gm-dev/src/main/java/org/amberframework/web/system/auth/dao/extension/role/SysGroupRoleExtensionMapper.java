package org.amberframework.web.system.auth.dao.extension.role;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.extension.role.SysGroupRoleExtCriteria;
import org.amberframework.web.system.auth.model.original.role.SysRole;

public interface SysGroupRoleExtensionMapper extends MyBatisBaseMapper {
  int countByExample(SysGroupRoleExtCriteria example);

  /**
   * 根据groupId查询角色.
   */
  List<SysRole> selectRolesByGroupId(Long groupId);
}
