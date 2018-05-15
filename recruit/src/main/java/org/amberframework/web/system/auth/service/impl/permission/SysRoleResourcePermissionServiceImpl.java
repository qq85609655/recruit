package org.amberframework.web.system.auth.service.impl.permission;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.dao.extension.permission.SysRoleResourcePermissionExtensionMapper;
import org.amberframework.web.system.auth.dao.original.permission.SysRoleResourcePermissionMapper;
import org.amberframework.web.system.auth.model.original.permission.SysPermission;
import org.amberframework.web.system.auth.model.original.permission.SysRoleResourcePermission;
import org.amberframework.web.system.auth.model.original.permission.SysRoleResourcePermissionColumns;
import org.amberframework.web.system.auth.model.original.permission.SysRoleResourcePermissionCriteria;
import org.amberframework.web.system.auth.service.SysAuthService;
import org.amberframework.web.system.auth.service.permission.SysRoleResourcePermissionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("sysRoleResourcePermissionService")
public class SysRoleResourcePermissionServiceImpl implements SysRoleResourcePermissionService {

  @Resource
  private SysRoleResourcePermissionMapper sysRoleResourcePermissionMapper;

  @Resource
  private SysRoleResourcePermissionExtensionMapper sysRoleResourcePermissionExtensionMapper;
  
  @Resource
  private SysAuthService sysAuthService;

  @Override
  public MiniRtn2Grid<SysRoleResourcePermission> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<SysRoleResourcePermission> grid = new MiniRtn2Grid<SysRoleResourcePermission>();
    SysRoleResourcePermissionCriteria criteria = new SysRoleResourcePermissionCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      // 生成代码时未找到合适的搜索字段
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = SysRoleResourcePermissionColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(sysRoleResourcePermissionMapper.selectByExample(criteria));
    grid.setTotal(sysRoleResourcePermissionMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public SysRoleResourcePermission getByPrimaryKey(String primaryKey) {
    BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
    return sysRoleResourcePermissionMapper.selectByPrimaryKey(pk);
  }

  @Override
  public void create(SysRoleResourcePermission sysRoleResourcePermission) {
    sysRoleResourcePermissionMapper.insert(sysRoleResourcePermission);
  }

  @Override
  public void updateSelective(SysRoleResourcePermission sysRoleResourcePermission) {
    sysRoleResourcePermissionMapper.updateByPrimaryKeySelective(sysRoleResourcePermission);
  }

  @Override
  public void remove(String primaryKey) {
    BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
    sysRoleResourcePermissionMapper.deleteByPrimaryKey(pk);
  }

  @Override
  public List<SysPermission> getRoleResourcePerms(Long roleId, Long resourceId) {
    return sysRoleResourcePermissionExtensionMapper.getPermissions(roleId, resourceId);
  }

  @Transactional
  @Override
  public void updateRoleResourcePerms(Long roleId, Long resourceId,
      List<SysPermission> sysPermissionList) {
    //先删除此角色对应资源下的所有权限操作配置，然后再重新insert一遍
    SysRoleResourcePermissionCriteria criteria = new SysRoleResourcePermissionCriteria();
    criteria.createCriteria().andRoleIdEqualTo(roleId).andResourceIdEqualTo(resourceId);
    sysRoleResourcePermissionMapper.deleteByExample(criteria);
    
    for (SysPermission sysPermission : sysPermissionList) {
      SysRoleResourcePermission sysRoleResourcePermission = new SysRoleResourcePermission();
      sysRoleResourcePermission.setRoleId(roleId);
      sysRoleResourcePermission.setResourceId(resourceId);
      sysRoleResourcePermission.setPermissionId(sysPermission.getId());
      sysRoleResourcePermissionMapper.insert(sysRoleResourcePermission);
    }
    
    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }
}
