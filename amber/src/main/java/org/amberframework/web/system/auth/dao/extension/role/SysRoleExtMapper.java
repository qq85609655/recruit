package org.amberframework.web.system.auth.dao.extension.role;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.extension.role.SysRoleExtCriteria;

public interface SysRoleExtMapper extends MyBatisBaseMapper {
  int countByExample(SysRoleExtCriteria example);
}
