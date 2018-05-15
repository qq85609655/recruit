package org.amberframework.web.system.auth.dao.original.user;

import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.model.original.user.SysUserCriteria;
import org.apache.ibatis.annotations.Param;

public interface SysUserMapper extends MyBatisBaseMapper {
  int countByExample(SysUserCriteria example);

  int deleteByExample(SysUserCriteria example);

  int deleteByPrimaryKey(String id);

  int insert(SysUser record);

  int insertSelective(SysUser record);

  List<SysUser> selectByExample(SysUserCriteria example);

  SysUser selectByPrimaryKey(String id);

  int updateByExampleSelective(@Param("record") SysUser record,
      @Param("example") SysUserCriteria example);

  int updateByExample(@Param("record") SysUser record, @Param("example") SysUserCriteria example);

  int updateByPrimaryKeySelective(SysUser record);

  int updateByPrimaryKey(SysUser record);
}
