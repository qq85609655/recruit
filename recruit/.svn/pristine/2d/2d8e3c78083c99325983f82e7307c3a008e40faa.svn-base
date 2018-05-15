package org.amberframework.web.system.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.model.BaseRole;
import org.amberframework.web.system.model.BaseUser;

public interface BaseRoleService {

  /**
   * 根据Id查询角色
   * @param id
   * @return
   */
  public BaseRole getBaseRoleByPrimaryKey(String id);
  
  /**
   * 新增角色
   * @param baseUser
   * @return
   */
  public int cerateBaseRole(BaseRole baseUser);
  
  /**
   * 更新角色
   * @param baseRole
   * @return
   */
  public int updateBaseRole(BaseRole baseRole);
  
  /**
   * 删除角色
   * @param id
   * @return
   */
  public int deleteBaseRoleById(String id);
  
  /**
   * 查询所有角色
   * @return
   */
  public List<BaseRole> queryAllBaseRole();
  
  /**
   * 根据userId查询Roles
   * @param userId
   * @return
   */
  List<BaseRole> getRolesByUserId(String userId);
  
  /**
   * 分页获取BaseRole的列表.
   * 
   * @return
   */
  public MiniRtn2Grid<BaseRole> getBaseRoleList(MiniGridPageSort pageAndSort);
  
  /**
   * 获取所有的角色
   * @return
   */
  public MiniRtn2Grid<BaseRole> getAllRole();
  
}
