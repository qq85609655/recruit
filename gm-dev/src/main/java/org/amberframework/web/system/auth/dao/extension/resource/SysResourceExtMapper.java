package org.amberframework.web.system.auth.dao.extension.resource;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.extension.resource.SysResourceExtCriteria;

public interface SysResourceExtMapper extends MyBatisBaseMapper {
  int countByExample(SysResourceExtCriteria example);
}
