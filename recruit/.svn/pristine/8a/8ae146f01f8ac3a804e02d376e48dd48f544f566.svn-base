package org.amberframework.web.system.auth.service.impl.permission;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.dao.original.permission.SysPermissionMapper;
import org.amberframework.web.system.auth.dao.original.permission.SysRoleResourcePermissionMapper;
import org.amberframework.web.system.auth.model.original.permission.SysPermission;
import org.amberframework.web.system.auth.model.original.permission.SysPermissionColumns;
import org.amberframework.web.system.auth.model.original.permission.SysRoleResourcePermissionCriteria;
import org.amberframework.web.system.auth.service.SysAuthService;
import org.amberframework.web.system.auth.service.permission.SysPermissionService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {

  @Resource
  private SysPermissionMapper sysPermissionMapper;
  
  @Resource
  private SysAuthService sysAuthService;
  
  @Resource
  private SysRoleResourcePermissionMapper sysRoleResourcePermissionMapper;

  @Override
  public MiniRtn2Grid<SysPermission> getGrid(MiniGridPageSort pageSort, String searchKey,
      String enabled, String resourceId) {
    MiniRtn2Grid<SysPermission> grid = new MiniRtn2Grid<SysPermission>();
    Map<String,String> param = new HashMap<String,String>();
    
    
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      param.put("searchKey", searchKey);
    }
    
    if (StringUtils.hasText(enabled)) {
      param.put("enabled", enabled);
    }
    
    if (StringUtils.hasText(resourceId)) {
      param.put("resourceId", resourceId);
    }
    
    // 分页和排序
    Page page = null;
    if (pageSort.isShowPager()) {
      page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      
    }
    String sortColumn = SysPermissionColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      param.put("orderByClause", sortStrBldr.toString());
    }
    grid.setData(sysPermissionMapper.selectByMap(param, page));
    grid.setTotal(sysPermissionMapper.countByMap(param));
    return grid;
  }

  @Override
  public SysPermission getByPrimaryKey(String primaryKey) {
    Long pk = Long.parseLong(primaryKey);
    return sysPermissionMapper.selectByPrimaryKey(pk);
  }

  @Override
  public void create(SysPermission sysPermission) {
    sysPermissionMapper.insert(sysPermission);
    
    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }

  @Override
  public void updateSelective(SysPermission sysPermission) {
    sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
    
    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }

  @Override
  public void remove(String primaryKey) {
    Long pk = Long.parseLong(primaryKey);
    sysPermissionMapper.deleteByPrimaryKey(pk);
    
    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }

  @Override
  public boolean hasDependencyOnRole(String primaryKey) {
    SysRoleResourcePermissionCriteria criteria = new SysRoleResourcePermissionCriteria();
    criteria.createCriteria().andPermissionIdEqualTo(Long.parseLong(primaryKey));
    return sysRoleResourcePermissionMapper.countByExample(criteria) > 0;
  }
}
