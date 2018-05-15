package org.amberframework.web.system.auth.dao.original.permission;

import java.math.BigDecimal;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.original.permission.SysRoleResourcePermission;
import org.amberframework.web.system.auth.model.original.permission.SysRoleResourcePermissionCriteria;
import org.apache.ibatis.annotations.Param;

public interface SysRoleResourcePermissionMapper extends MyBatisBaseMapper {
  int countByExample(SysRoleResourcePermissionCriteria example);

  int deleteByExample(SysRoleResourcePermissionCriteria example);

  int deleteByPrimaryKey(BigDecimal id);

  int insert(SysRoleResourcePermission record);

  int insertSelective(SysRoleResourcePermission record);

  List<SysRoleResourcePermission> selectByExample(SysRoleResourcePermissionCriteria example);

  SysRoleResourcePermission selectByPrimaryKey(BigDecimal id);

  int updateByExampleSelective(@Param("record") SysRoleResourcePermission record,
      @Param("example") SysRoleResourcePermissionCriteria example);

  int updateByExample(@Param("record") SysRoleResourcePermission record,
      @Param("example") SysRoleResourcePermissionCriteria example);

  int updateByPrimaryKeySelective(SysRoleResourcePermission record);

  int updateByPrimaryKey(SysRoleResourcePermission record);
}
