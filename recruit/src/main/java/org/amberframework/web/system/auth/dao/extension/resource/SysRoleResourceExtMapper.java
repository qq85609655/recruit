package org.amberframework.web.system.auth.dao.extension.resource;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.extension.resource.SysRoleResourceExtCriteria;

public interface SysRoleResourceExtMapper extends MyBatisBaseMapper {
  int countByExample(SysRoleResourceExtCriteria example);
}
