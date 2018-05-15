package org.amberframework.web.system.auth.dao.original.role;

import java.math.BigDecimal;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.original.role.SysGroupRole;
import org.amberframework.web.system.auth.model.original.role.SysGroupRoleCriteria;
import org.apache.ibatis.annotations.Param;

public interface SysGroupRoleMapper extends MyBatisBaseMapper {
  int countByExample(SysGroupRoleCriteria example);

  int deleteByExample(SysGroupRoleCriteria example);

  int deleteByPrimaryKey(BigDecimal id);

  int insert(SysGroupRole record);

  int insertSelective(SysGroupRole record);

  List<SysGroupRole> selectByExample(SysGroupRoleCriteria example);

  SysGroupRole selectByPrimaryKey(BigDecimal id);

  int updateByExampleSelective(@Param("record") SysGroupRole record,
      @Param("example") SysGroupRoleCriteria example);

  int updateByExample(@Param("record") SysGroupRole record,
      @Param("example") SysGroupRoleCriteria example);

  int updateByPrimaryKeySelective(SysGroupRole record);

  int updateByPrimaryKey(SysGroupRole record);
}
