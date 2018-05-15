package org.amberframework.web.system.auth.service.impl.group;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.dao.extension.group.SysUserGroupExtensionMapper;
import org.amberframework.web.system.auth.dao.original.group.SysUserGroupMapper;
import org.amberframework.web.system.auth.model.original.group.SysUserGroup;
import org.amberframework.web.system.auth.model.original.group.SysUserGroupColumns;
import org.amberframework.web.system.auth.model.original.group.SysUserGroupCriteria;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.service.group.SysUserGroupService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("sysUserGroupService")
public class SysUserGroupServiceImpl implements SysUserGroupService {

  @Resource
  private SysUserGroupMapper sysUserGroupMapper;

  @Resource
  private SysUserGroupExtensionMapper sysUserGroupExtensionMapper;

  @Override
  public MiniRtn2Grid<SysUserGroup> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<SysUserGroup> grid = new MiniRtn2Grid<SysUserGroup>();
    SysUserGroupCriteria criteria = new SysUserGroupCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andUserIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = SysUserGroupColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(sysUserGroupMapper.selectByExample(criteria));
    grid.setTotal(sysUserGroupMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public SysUserGroup getByPrimaryKey(String primaryKey) {
    BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
    return sysUserGroupMapper.selectByPrimaryKey(pk);
  }

  @Override
  public void create(SysUserGroup sysUserGroup) {
    sysUserGroupMapper.insert(sysUserGroup);
  }

  @Override
  public void updateSelective(SysUserGroup sysUserGroup) {
    sysUserGroupMapper.updateByPrimaryKeySelective(sysUserGroup);
  }

  @Override
  public void remove(String primaryKey) {
    BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
    sysUserGroupMapper.deleteByPrimaryKey(pk);
  }

  @Override
  public List<SysUser> getGroupMembers(Long groupId) {
    return sysUserGroupExtensionMapper.selectUsersByGroupId(groupId);
  }

  @Transactional
  @Override
  public void updateGroupMembers(Long groupId, List<SysUser> sysUserList) {
    // 删除groupId已有的与user的关联，并重新添加
    SysUserGroupCriteria criteria = new SysUserGroupCriteria();
    criteria.createCriteria().andGroupIdEqualTo(groupId);
    sysUserGroupMapper.deleteByExample(criteria);
    for (SysUser sysUser : sysUserList) {
      SysUserGroup sysUserGroup = new SysUserGroup();
      sysUserGroup.setGroupId(groupId);
      sysUserGroup.setUserId(sysUser.getId());
      sysUserGroupMapper.insert(sysUserGroup);
    }
  }
}
