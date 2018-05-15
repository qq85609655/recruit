package org.amberframework.web.system.auth.service.user;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;

/**
 * 使用了Ehcache缓存机制，通过Spring注解，直接加在Service的public方法上.
 */
public interface SysUserService {
  /**
   * 按照account模糊查询，status如果为空，则查询所有状态.
   * 
   * @param pageSort 储存分页和排序信息的对象
   * @param searchKey 按照account模糊查询
   * @param status 1 - 启用, 0 - 停用， 传空则都查询
   * @return 返回用于转成MiniGrid的对象
   */
  MiniRtn2Grid<SysUser> getGrid(MiniGridPageSort pageSort, String searchKey, String status);

  /**
   * 根据主键获取SysUser信息，不会返回密码相关信息
   */
  SysUser getByPrimaryKey(String primaryKey);

  SysUser create(SysUser sysUser);

  SysUser updateSelective(SysUser sysUser);

  void remove(String primaryKey);

  /**
   * 根据账号名查找系统用户(不包含密码信息)，理论上一个账号名只会有一个，所以返回查找结果的第一个，如果没找到，则返回null.
   */
  SysUser getUserByAccount(String username);

  /**
   * 根据用户主键修改密码.
   * 
   * @param userId 用户主键
   * @param newPassword 新密码
   */
  SysUser changePassword(String userId, String newPassword);
  
  /**
   * 修改用户状态.
   * 
   * @param userId 用户主键
   * @param status 状态，0 or 1
   */
  SysUser changeStatus(String userId, String status);
  
}
