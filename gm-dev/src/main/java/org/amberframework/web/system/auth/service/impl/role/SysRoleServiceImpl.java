package org.amberframework.web.system.auth.service.impl.role;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.dao.original.permission.SysRoleResourcePermissionMapper;
import org.amberframework.web.system.auth.dao.original.resource.SysRoleResourceMapper;
import org.amberframework.web.system.auth.dao.original.role.SysGroupRoleMapper;
import org.amberframework.web.system.auth.dao.original.role.SysRoleMapper;
import org.amberframework.web.system.auth.model.original.permission.SysRoleResourcePermissionCriteria;
import org.amberframework.web.system.auth.model.original.resource.SysRoleResourceCriteria;
import org.amberframework.web.system.auth.model.original.role.SysGroupRoleCriteria;
import org.amberframework.web.system.auth.model.original.role.SysRole;
import org.amberframework.web.system.auth.model.original.role.SysRoleColumns;
import org.amberframework.web.system.auth.model.original.role.SysRoleCriteria;
import org.amberframework.web.system.auth.service.SysAuthService;
import org.amberframework.web.system.auth.service.role.SysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService {

  @Resource
  private SysRoleMapper sysRoleMapper;

  @Resource
  private SysAuthService sysAuthService;

  @Resource
  private SysGroupRoleMapper sysGroupRoleMapper;
  
  @Resource
  private SysRoleResourceMapper sysRoleResourceMapper;
  
  @Resource
  private SysRoleResourcePermissionMapper sysRoleResourcePermissionMapper;

  @Override
  public MiniRtn2Grid<SysRole> getGrid(MiniGridPageSort pageSort, String searchKey, String enabled) {
    MiniRtn2Grid<SysRole> grid = new MiniRtn2Grid<SysRole>();
    SysRoleCriteria criteria = new SysRoleCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      if (StringUtils.hasText(enabled)) {
        criteria.createCriteria().andNameLike("%" + searchKey + "%").andEnabledEqualTo(enabled);
        criteria.or().andRoleLike("%" + searchKey + "%").andEnabledEqualTo(enabled);
      } else {
        criteria.createCriteria().andNameLike("%" + searchKey + "%");
        criteria.or().andRoleLike("%" + searchKey + "%");
      }

    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = SysRoleColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(sysRoleMapper.selectByExample(criteria));
    grid.setTotal(sysRoleMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public SysRole getByPrimaryKey(String primaryKey) {
    Long pk = Long.parseLong(primaryKey);
    return sysRoleMapper.selectByPrimaryKey(pk);
  }

  @Override
  public void create(SysRole sysRole) {
    sysRoleMapper.insert(sysRole);

    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }

  @Override
  public void updateSelective(SysRole sysRole) {
    sysRoleMapper.updateByPrimaryKeySelective(sysRole);

    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }

  @Override
  public void remove(String primaryKey) {
    Long pk = Long.parseLong(primaryKey);
    sysRoleMapper.deleteByPrimaryKey(pk);

    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }

  @Override
  public boolean hasGroupDependOnRole(String primaryKey) {
    SysGroupRoleCriteria criteria = new SysGroupRoleCriteria();
    criteria.createCriteria().andRoleIdEqualTo(Long.parseLong(primaryKey));
    return sysGroupRoleMapper.countByExample(criteria) > 0;
  }

  @Override
  public boolean hasResourceDependOnRole(String primaryKey) {
    SysRoleResourceCriteria criteria = new SysRoleResourceCriteria();
    criteria.createCriteria().andRoleIdEqualTo(Long.parseLong(primaryKey));
    return sysRoleResourceMapper.countByExample(criteria) > 0;
  }

  @Override
  public boolean hasPermissionDependOnRole(String primaryKey) {
    SysRoleResourcePermissionCriteria criteria = new SysRoleResourcePermissionCriteria();
    criteria.createCriteria().andRoleIdEqualTo(Long.parseLong(primaryKey));
    return sysRoleResourcePermissionMapper.countByExample(criteria) > 0;
  }
}
