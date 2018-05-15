package org.amberframework.web.system.auth.dao.original.role;

import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.original.role.SysRole;
import org.amberframework.web.system.auth.model.original.role.SysRoleCriteria;
import org.apache.ibatis.annotations.Param;

public interface SysRoleMapper extends MyBatisBaseMapper {
  int countByExample(SysRoleCriteria example);

  int deleteByExample(SysRoleCriteria example);

  int deleteByPrimaryKey(Long id);

  int insert(SysRole record);

  int insertSelective(SysRole record);

  List<SysRole> selectByExample(SysRoleCriteria example);

  SysRole selectByPrimaryKey(Long id);

  int updateByExampleSelective(@Param("record") SysRole record,
      @Param("example") SysRoleCriteria example);

  int updateByExample(@Param("record") SysRole record, @Param("example") SysRoleCriteria example);

  int updateByPrimaryKeySelective(SysRole record);

  int updateByPrimaryKey(SysRole record);
}
