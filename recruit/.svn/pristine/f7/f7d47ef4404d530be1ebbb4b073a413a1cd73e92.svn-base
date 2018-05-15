package org.amberframework.web.system.dao;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.model.BaseRole;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.BaseUserCriteria;
import org.apache.ibatis.annotations.Param;

public interface BaseRoleMapper extends MyBatisBaseMapper {
 /**
  * 更具ids查询角色
  * @param ids
  * @return
  */
  List<BaseRole> getRolesByIds(String ids);
  
  /**
   * 
   * @param mapParam
   * @return
   */
  List<BaseRole> getBaseRoleList(Map<String,Object> mapParam);
  
  /**
   * 获取角色总数
   * @return
   */
  Integer getBaseRoleCount();
  
  /**
   * 根据Id删除角色
   * @param id
   * @return
   */
  int deleteByPrimaryKey(String id);
  
  /**
   * 添加角色
   * @param baseRole
   * @return
   */
  int insertSelective(BaseRole baseRole);
  
  /**
   * 更新角色
   * @param baseRole
   * @return
   */
  int updateSelective(BaseRole baseRole);
  
  /**
   * 获取所有角色
   * @return
   */
  List<BaseRole> getAllRole();
  
}