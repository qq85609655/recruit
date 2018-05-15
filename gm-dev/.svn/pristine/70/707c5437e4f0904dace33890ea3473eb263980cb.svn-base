package org.amberframework.web.system.auth.service.impl.user;

import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.annotation.cache.SysUserSaveCachePut;
import org.amberframework.web.system.auth.dao.original.user.SysUserMapper;
import org.amberframework.web.system.auth.exception.UserAccountRepeatException;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.model.original.user.SysUserColumns;
import org.amberframework.web.system.auth.model.original.user.SysUserCriteria;
import org.amberframework.web.system.auth.service.user.SysUserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

  @Resource
  private SysUserMapper sysUserMapper;

  @Resource
  private PasswordHelper passwordHelper;

  @Override
  public MiniRtn2Grid<SysUser> getGrid(MiniGridPageSort pageSort, String searchKey, String status) {
    MiniRtn2Grid<SysUser> grid = new MiniRtn2Grid<SysUser>();
    SysUserCriteria criteria = new SysUserCriteria();
    SysUserCriteria.Criteria orCriteria =
        criteria.createCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      orCriteria.andAccountLikeInsensitive("%" + searchKey + "%");
    }
    if (StringUtils.hasText(status)) {
      orCriteria.andStatusEqualTo(status);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = SysUserColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    List<SysUser> userList = sysUserMapper.selectByExample(criteria);
    for (SysUser sysUser : userList) {
      clearPwdInfo(sysUser);
    }
    grid.setData(userList);
    grid.setTotal(sysUserMapper.countByExample(criteria));
    return grid;
  }

  @Cacheable(value = "sys-user", key = "#primaryKey")
  @Override
  public SysUser getByPrimaryKey(String primaryKey) {
    return clearPwdInfo(sysUserMapper.selectByPrimaryKey(primaryKey));
  }

  @SysUserSaveCachePut
  @Override
  public SysUser create(SysUser sysUser) {
    SysUserCriteria criteria = new SysUserCriteria();
    criteria.createCriteria().andAccountEqualTo(sysUser.getAccount());
    if (sysUserMapper.countByExample(criteria) > 0) {
      throw new UserAccountRepeatException("账号重复");
    }
    passwordHelper.encryptPassword(sysUser);
    sysUserMapper.insert(sysUser);
    return clearPwdInfo(sysUser);
  }

  @SysUserSaveCachePut
  @Override
  public SysUser updateSelective(SysUser sysUser) {
    sysUserMapper.updateByPrimaryKeySelective(sysUser);
    return clearPwdInfo(sysUserMapper.selectByPrimaryKey(sysUser.getId()));
  }

  @CacheEvict(value = "sys-user", allEntries = true)
  @Override
  public void remove(String primaryKey) {
    sysUserMapper.deleteByPrimaryKey(primaryKey);
  }

  @Cacheable(value = "sys-user", key = "#account")
  @Override
  public SysUser getUserByAccount(String account) {
    SysUserCriteria criteria = new SysUserCriteria();
    criteria.createCriteria().andAccountEqualTo(account);
    List<SysUser> users = sysUserMapper.selectByExample(criteria);
    if (users.isEmpty()) {
      return null;
    } else {
      return clearPwdInfo(users.get(0));
    }
  }

  @SysUserSaveCachePut
  @Override
  public SysUser changePassword(String userId, String newPassword) {
    SysUser user = sysUserMapper.selectByPrimaryKey(userId);
    user.setPassword(newPassword);
    passwordHelper.encryptPassword(user);
    sysUserMapper.updateByPrimaryKey(user);
    return clearPwdInfo(user);
  }

  @SysUserSaveCachePut
  @Override
  public SysUser changeStatus(String userId, String status) {
    SysUser user = sysUserMapper.selectByPrimaryKey(userId);
    // 只更新用户状态
    user.setAccount(null);
    user.setPassword(null);
    user.setSalt(null);
    user.setStatus(status);
    sysUserMapper.updateByPrimaryKeySelective(user);
    user = sysUserMapper.selectByPrimaryKey(userId);
    return clearPwdInfo(user);
  }

  /**
   * 清理SysUser对象中的密码相关信息，密码和盐.
   */
  private SysUser clearPwdInfo(SysUser sysUser) {
    sysUser.setPassword(null);
    sysUser.setSalt(null);
    return sysUser;
  }
}
