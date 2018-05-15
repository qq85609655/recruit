package org.amberframework.web.system.auth.dao.original.resource;

import java.math.BigDecimal;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.original.resource.SysRoleResource;
import org.amberframework.web.system.auth.model.original.resource.SysRoleResourceCriteria;
import org.apache.ibatis.annotations.Param;

public interface SysRoleResourceMapper extends MyBatisBaseMapper {
  int countByExample(SysRoleResourceCriteria example);

  int deleteByExample(SysRoleResourceCriteria example);

  int deleteByPrimaryKey(BigDecimal id);

  int insert(SysRoleResource record);

  int insertSelective(SysRoleResource record);

  List<SysRoleResource> selectByExample(SysRoleResourceCriteria example);

  SysRoleResource selectByPrimaryKey(BigDecimal id);

  int updateByExampleSelective(@Param("record") SysRoleResource record,
      @Param("example") SysRoleResourceCriteria example);

  int updateByExample(@Param("record") SysRoleResource record,
      @Param("example") SysRoleResourceCriteria example);

  int updateByPrimaryKeySelective(SysRoleResource record);

  int updateByPrimaryKey(SysRoleResource record);
}
