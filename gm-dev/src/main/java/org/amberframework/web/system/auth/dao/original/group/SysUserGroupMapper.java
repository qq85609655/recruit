package org.amberframework.web.system.auth.dao.original.group;

import java.math.BigDecimal;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.original.group.SysUserGroup;
import org.amberframework.web.system.auth.model.original.group.SysUserGroupCriteria;
import org.apache.ibatis.annotations.Param;

public interface SysUserGroupMapper extends MyBatisBaseMapper {
  int countByExample(SysUserGroupCriteria example);

  int deleteByExample(SysUserGroupCriteria example);

  int deleteByPrimaryKey(BigDecimal id);

  int insert(SysUserGroup record);

  int insertSelective(SysUserGroup record);

  List<SysUserGroup> selectByExample(SysUserGroupCriteria example);

  SysUserGroup selectByPrimaryKey(BigDecimal id);

  int updateByExampleSelective(@Param("record") SysUserGroup record,
      @Param("example") SysUserGroupCriteria example);

  int updateByExample(@Param("record") SysUserGroup record,
      @Param("example") SysUserGroupCriteria example);

  int updateByPrimaryKeySelective(SysUserGroup record);

  int updateByPrimaryKey(SysUserGroup record);
}
