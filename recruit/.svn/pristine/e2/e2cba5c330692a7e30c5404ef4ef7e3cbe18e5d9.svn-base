package org.amberframework.web.system.auth.dao.original.permission;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.system.auth.model.original.permission.SysPermission;
import org.amberframework.web.system.auth.model.original.permission.SysPermissionCriteria;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper extends MyBatisBaseMapper {
  int countByExample(SysPermissionCriteria example);

  int deleteByExample(SysPermissionCriteria example);

  int deleteByPrimaryKey(Long id);

  int insert(SysPermission record);

  int insertSelective(SysPermission record);

  List<SysPermission> selectByExample(SysPermissionCriteria example);
  
  List<SysPermission> selectByMap(@Param("param")Map<String,String> param, @Param("page")Page page);
  
  int countByMap(@Param("param")Map<String,String> param);

  SysPermission selectByPrimaryKey(Long id);

  int updateByExampleSelective(@Param("record") SysPermission record,
      @Param("example") SysPermissionCriteria example);

  int updateByExample(@Param("record") SysPermission record,
      @Param("example") SysPermissionCriteria example);

  int updateByPrimaryKeySelective(SysPermission record);

  int updateByPrimaryKey(SysPermission record);
}
