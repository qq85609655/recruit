package org.amberframework.web.system.auth.service.impl.role;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.dao.extension.role.SysGroupRoleExtensionMapper;
import org.amberframework.web.system.auth.dao.original.role.SysGroupRoleMapper;
import org.amberframework.web.system.auth.model.original.role.SysGroupRole;
import org.amberframework.web.system.auth.model.original.role.SysGroupRoleColumns;
import org.amberframework.web.system.auth.model.original.role.SysGroupRoleCriteria;
import org.amberframework.web.system.auth.model.original.role.SysRole;
import org.amberframework.web.system.auth.service.role.SysGroupRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("sysGroupRoleService")
public class SysGroupRoleServiceImpl implements SysGroupRoleService {

  @Resource
  private SysGroupRoleMapper sysGroupRoleMapper;

  @Resource
  private SysGroupRoleExtensionMapper sysGroupRoleExtensionMapper;

  @Override
  public MiniRtn2Grid<SysGroupRole> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<SysGroupRole> grid = new MiniRtn2Grid<SysGroupRole>();
    SysGroupRoleCriteria criteria = new SysGroupRoleCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andExtendedEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = SysGroupRoleColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(sysGroupRoleMapper.selectByExample(criteria));
    grid.setTotal(sysGroupRoleMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public SysGroupRole getByPrimaryKey(String primaryKey) {
    BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
    return sysGroupRoleMapper.selectByPrimaryKey(pk);
  }

  @Override
  public void create(SysGroupRole sysGroupRole) {
    sysGroupRoleMapper.insert(sysGroupRole);
  }

  @Override
  public void updateSelective(SysGroupRole sysGroupRole) {
    sysGroupRoleMapper.updateByPrimaryKeySelective(sysGroupRole);
  }

  @Override
  public void remove(String primaryKey) {
    BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
    sysGroupRoleMapper.deleteByPrimaryKey(pk);
  }

  @Override
  public List<SysRole> getGroupRoles(Long groupId) {
    return sysGroupRoleExtensionMapper.selectRolesByGroupId(groupId);
  }

  @Transactional
  @Override
  public void updateGroupRoles(Long groupId, List<SysRole> sysRoleList) {
    // 删除groupId已有的与role的关联，并重新添加
    SysGroupRoleCriteria criteria = new SysGroupRoleCriteria();
    criteria.createCriteria().andGroupIdEqualTo(groupId);
    sysGroupRoleMapper.deleteByExample(criteria);
    for (SysRole sysRole : sysRoleList) {
      SysGroupRole sysGroupRole = new SysGroupRole();
      sysGroupRole.setGroupId(groupId);
      sysGroupRole.setRoleId(sysRole.getId());
      sysGroupRoleMapper.insert(sysGroupRole);
    }

  }
}
