package org.amberframework.web.system.auth.dao.extension.group;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.extension.group.SysUserGroupExtCriteria;
import org.amberframework.web.system.auth.model.original.user.SysUser;

public interface SysUserGroupExtensionMapper extends MyBatisBaseMapper {
  int countByExample(SysUserGroupExtCriteria example);

  /**
   * 根据groupId查询用户.
   */
  List<SysUser> selectUsersByGroupId(Long groupId);
}
