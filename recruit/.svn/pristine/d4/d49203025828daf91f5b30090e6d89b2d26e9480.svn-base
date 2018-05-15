package org.amberframework.web.system.auth.service.impl.resource;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.core.util.AmberBeanUtils;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.dao.extension.permission.SysRoleResourcePermissionExtensionMapper;
import org.amberframework.web.system.auth.dao.original.resource.SysResourceMapper;
import org.amberframework.web.system.auth.dao.original.resource.SysRoleResourceMapper;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.model.original.resource.SysResourceCriteria;
import org.amberframework.web.system.auth.model.original.resource.SysRoleResource;
import org.amberframework.web.system.auth.model.original.resource.SysRoleResourceColumns;
import org.amberframework.web.system.auth.model.original.resource.SysRoleResourceCriteria;
import org.amberframework.web.system.auth.service.SysAuthService;
import org.amberframework.web.system.auth.service.resource.SysRoleResourceService;
import org.amberframework.web.system.auth.vo.resource.SysResourceVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("sysRoleResourceService")
public class SysRoleResourceServiceImpl implements SysRoleResourceService {
  private static final Logger logger = LoggerFactory.getLogger(SysRoleResourceServiceImpl.class);

  @Resource
  private SysRoleResourceMapper sysRoleResourceMapper;

  @Resource
  private SysResourceMapper sysResourceMapper;

  @Resource
  private SysRoleResourcePermissionExtensionMapper sysRoleResourcePermissionExtMapper;

  @Resource
  private SysAuthService sysAuthService;

  @Override
  public MiniRtn2Grid<SysRoleResource> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<SysRoleResource> grid = new MiniRtn2Grid<SysRoleResource>();
    SysRoleResourceCriteria criteria = new SysRoleResourceCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      // 生成代码时未找到合适的搜索字段
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = SysRoleResourceColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(sysRoleResourceMapper.selectByExample(criteria));
    grid.setTotal(sysRoleResourceMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public SysRoleResource getByPrimaryKey(String primaryKey) {
    BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
    return sysRoleResourceMapper.selectByPrimaryKey(pk);
  }

  @Override
  public void create(SysRoleResource sysRoleResource) {
    sysRoleResourceMapper.insert(sysRoleResource);
  }

  @Override
  public void updateSelective(SysRoleResource sysRoleResource) {
    sysRoleResourceMapper.updateByPrimaryKeySelective(sysRoleResource);
  }

  @Override
  public void remove(String primaryKey) {
    BigDecimal pk = BigDecimal.valueOf(Long.parseLong(primaryKey));
    sysRoleResourceMapper.deleteByPrimaryKey(pk);
  }

  @Transactional
  @Override
  public void updateRoleMenu(Long roleId, List<SysResource> resourceList) {
    // 删除groupId已有的与role的关联，并重新添加
    SysRoleResourceCriteria criteria = new SysRoleResourceCriteria();
    criteria.createCriteria().andRoleIdEqualTo(roleId);
    sysRoleResourceMapper.deleteByExample(criteria);

    for (SysResource sysResource : resourceList) {
      // 只保存菜单
      if ("1".equals(sysResource.getShowAsMenu())) {
        SysRoleResource sysRoleResource = new SysRoleResource();
        sysRoleResource.setRoleId(roleId);
        sysRoleResource.setResourceId(sysResource.getId());
        sysRoleResourceMapper.insert(sysRoleResource);
      }
    }

    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }

  @Override
  public List<SysResourceVo> getCheckedResourceTree(Long roleId) {
    SysResourceCriteria resourceCriteria = new SysResourceCriteria();
    List<SysResource> resourceList = sysResourceMapper.selectByExample(resourceCriteria);

    SysRoleResourceCriteria roleResourceCriteria = new SysRoleResourceCriteria();
    roleResourceCriteria.createCriteria().andRoleIdEqualTo(roleId);
    List<SysRoleResource> roleResourceList = sysRoleResourceMapper.selectByExample(roleResourceCriteria);

    List<Long> hasPermResourceIdList =
        sysRoleResourcePermissionExtMapper.selectDistResourceIdByRoleId(roleId);

    Map<Long, SysResourceVo> resourceVoMap = new HashMap<Long, SysResourceVo>();
    for (SysResource sysResource : resourceList) {
      SysResourceVo sysResourceVo = new SysResourceVo();
      try {
        AmberBeanUtils.copyBeanPropertiesDeeply(sysResourceVo, sysResource);
        resourceVoMap.put(sysResourceVo.getId(), sysResourceVo);
      } catch (InstantiationException | IllegalAccessException | InvocationTargetException
          | NoSuchMethodException e) {
        logger.error(e.getMessage(), e);
      }
    }

    for (SysRoleResource roleResource : roleResourceList) {
      SysResourceVo resourceVo = resourceVoMap.get(roleResource.getResourceId());
      if (null != resourceVo) {
        resourceVo.setChecked(true);
      }
    }

    for (Long resourceId : hasPermResourceIdList) {
      SysResourceVo resourceVo = resourceVoMap.get(resourceId);
      if (null != resourceVo) {
        resourceVo.setHasPermissions(true);
      }
    }

    return new ArrayList<SysResourceVo>(resourceVoMap.values());
  }
}
