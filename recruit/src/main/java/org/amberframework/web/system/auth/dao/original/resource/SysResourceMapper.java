package org.amberframework.web.system.auth.dao.original.resource;

import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.model.original.resource.SysResourceCriteria;
import org.apache.ibatis.annotations.Param;

public interface SysResourceMapper extends MyBatisBaseMapper {
  int countByExample(SysResourceCriteria example);

  int deleteByExample(SysResourceCriteria example);

  int deleteByPrimaryKey(Long id);

  int insert(SysResource record);

  int insertSelective(SysResource record);

  List<SysResource> selectByExample(SysResourceCriteria example);

  SysResource selectByPrimaryKey(Long id);

  int updateByExampleSelective(@Param("record") SysResource record,
      @Param("example") SysResourceCriteria example);

  int updateByExample(@Param("record") SysResource record,
      @Param("example") SysResourceCriteria example);

  int updateByPrimaryKeySelective(SysResource record);

  int updateByPrimaryKey(SysResource record);
}
