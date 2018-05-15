package org.amberframework.web.system.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.model.BaseUser;

public interface BaseUserService {

  /**
   * 通过用户名和密码登录，登录成功后会将登录信息写入Session.
   * 
   * @param username
   * @param password
   * @param session
   * @return
   */
  public boolean login(String username, String password, HttpSession session);

  /**
   * 获取BaseUser的列表.
   * 
   * @return
   */
  public MiniRtn2Grid<BaseUser> getBaseUserList(MiniGridPageSort pageAndSort,BaseUser baseUser);

  /**
   * 通过主键获取用户.
   * 
   * @param pkey 主键
   * @return
   */
  public BaseUser getBaseUserByPrimaryKey(String pkey);

  /**
   * 创建用户.
   * 
   * @param user
   * @return 创建成功数
   */
  public int createBaseUser(BaseUser user);

  /**
   * 更新用户.
   * 
   * @param user
   * @return 更新成功数
   */
  public int updateBaseUser(BaseUser user);

  /**
   * 查找同名账号数，返回同名账号数量
   * 
   * @param account
   * @return 同名账号数量
   */
  public int findSameAccountUserCount(String account);

  /**
   * 查询所有的招聘专员
   * @return
   */
  public List<BaseUser> queryAllUser();

  /**
   * 验证原密码是否存在
   * @param id
   * @param password
   * @return
   */
  boolean validatePassowrd(String id,String password);
  
  /**
   * 判断该用户对该资源是否具有该权限
   * @param resource
   * @param permission
   * @return
   */
  public boolean validateUserPermission(String resource,String permission);
  
  /**
   * 禁用账号
   * @param id
   * @return
   */
  public boolean setStatus(String id);
  
  /**
   * 删除账号
   * @param id
   * @return
   */
  public boolean deleteUser(String id);
  
  /**在4A数据中获取账号信息*/
  List<BaseUser> selectFromAccount();

  public List<SysUser> getGroupMembers(Long parseLong);


  public MiniRtn2Grid<BaseUser> getBaseUserListByGroupId(MiniGridPageSort pageAndSort,
      Map<String, String> searchMap);

  /**
   * 根据工号获取员工信息
   * @param name
   * @return
   */
  public Map<String, String> getInfoByCode(String code);
  
}