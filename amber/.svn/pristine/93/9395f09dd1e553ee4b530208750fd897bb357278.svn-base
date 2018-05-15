package org.amberframework.web.system.auth.dao.original.group;

import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.original.group.SysGroup;
import org.amberframework.web.system.auth.model.original.group.SysGroupCriteria;
import org.apache.ibatis.annotations.Param;

public interface SysGroupMapper extends MyBatisBaseMapper {
  int countByExample(SysGroupCriteria example);

  int deleteByExample(SysGroupCriteria example);

  int deleteByPrimaryKey(Long id);

  int insert(SysGroup record);

  int insertSelective(SysGroup record);

  List<SysGroup> selectByExample(SysGroupCriteria example);

  SysGroup selectByPrimaryKey(Long id);

  int updateByExampleSelective(@Param("record") SysGroup record,
      @Param("example") SysGroupCriteria example);

  int updateByExample(@Param("record") SysGroup record, @Param("example") SysGroupCriteria example);

  int updateByPrimaryKeySelective(SysGroup record);

  int updateByPrimaryKey(SysGroup record);
}
