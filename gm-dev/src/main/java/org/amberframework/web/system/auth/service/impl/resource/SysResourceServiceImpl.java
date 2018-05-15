package org.amberframework.web.system.auth.service.impl.resource;

import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.system.auth.dao.original.permission.SysRoleResourcePermissionMapper;
import org.amberframework.web.system.auth.dao.original.resource.SysResourceMapper;
import org.amberframework.web.system.auth.dao.original.resource.SysRoleResourceMapper;
import org.amberframework.web.system.auth.exception.AuthSysResourceServiceException;
import org.amberframework.web.system.auth.model.original.permission.SysRoleResourcePermissionCriteria;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.model.original.resource.SysResourceColumns;
import org.amberframework.web.system.auth.model.original.resource.SysResourceCriteria;
import org.amberframework.web.system.auth.model.original.resource.SysRoleResourceCriteria;
import org.amberframework.web.system.auth.service.SysAuthService;
import org.amberframework.web.system.auth.service.resource.SysResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("sysResourceService")
public class SysResourceServiceImpl implements SysResourceService {
  private static final Logger logger = LoggerFactory.getLogger(SysResourceServiceImpl.class);

  @Resource
  private SysResourceMapper sysResourceMapper;

  @Resource
  private SysAuthService sysAuthService;

  @Resource
  private SysRoleResourceMapper sysRoleResourceMapper;

  @Resource
  private SysRoleResourcePermissionMapper sysRoleResourcePermissionMapper;

  @Override
  public List<SysResource> getGrid(MiniGridPageSort pageSort, String searchKey) {
    SysResourceCriteria criteria = new SysResourceCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andNameLike("%" + searchKey + "%");
    }
    // 分页
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    // 按照菜单顺序排序
    String sortColumn = SysResourceColumns.getColumn("weight");
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    return sysResourceMapper.selectByExample(criteria);
  }

  @Override
  public SysResource getByPrimaryKey(String primaryKey) {
    Long pk = Long.parseLong(primaryKey);
    return sysResourceMapper.selectByPrimaryKey(pk);
  }

  @Override
  public void create(SysResource sysResource) {
    // 如果上级资源id为空，则设置为0，0表示顶级资源
    if (sysResource.getParentId() == null) {
      sysResource.setParentId(0L);
    }
    if (sysResource.getWeight() == null) {
      sysResource.setWeight(0);
    }
    sysResource.setParentIds(this.createParentIdsPathStr(sysResource.getParentId()));
    sysResourceMapper.insert(sysResource);

    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }

  @Transactional
  @Override
  public void updateSelective(SysResource sysResource) {
    // 如果上级资源id为空，则设置为0，0表示顶级资源
    if (sysResource.getParentId() == null) {
      sysResource.setParentId(0L);
    }
    // 判断上级组不能是本身
    if (sysResource.getId().equals(sysResource.getParentId())) {
      logger.warn("Modify SysResource[" + sysResource.getId() + "] id == parentId");
      throw new AuthSysResourceServiceException("上级资源不能是本身");
    }
    SysResource origSysResource = sysResourceMapper.selectByPrimaryKey(sysResource.getId());
    if (null == origSysResource) {
      logger.error("Modify SysResource[" + sysResource.getId() + "] is not exist");
      throw new AuthSysResourceServiceException("资源不存在");
    }
    // 如果修改上级Resource，就需要更新所有子资源的parentIds，否则不需要将所有子资源的parentIds给重置
    if (!sysResource.getParentId().equals(origSysResource.getParentId())) {
      // 重新计算parentIdsPath
      sysResource.setParentIds(this.createParentIdsPathStr(sysResource.getParentId()));
      // 获取修改前resource的完整路径和修改后的完整路径
      String oldParentIdsPath = origSysResource.getParentIds() + origSysResource.getId() + "/";
      String newParentIdsPath = sysResource.getParentIds() + sysResource.getId().toString() + "/";
      // 更新所有子资源的parentIds
      SysResourceCriteria criteria = new SysResourceCriteria();
      criteria.createCriteria().andParentIdsLike(oldParentIdsPath + "%");
      List<SysResource> childSysResourceList = sysResourceMapper.selectByExample(criteria);
      for (SysResource childSysResource : childSysResourceList) {
        childSysResource.setParentIds(childSysResource.getParentIds().replace(oldParentIdsPath,
            newParentIdsPath));
        sysResourceMapper.updateByPrimaryKeySelective(childSysResource);
      }
    } else {
      // parentId没变，更新时不更新parentId和parentIds字段
      sysResource.setParentId(null);
      sysResource.setParentIds(null);
    }

    sysResourceMapper.updateByPrimaryKeySelective(sysResource);

    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }

  @Override
  public void remove(String primaryKey) {
    Long pk = Long.parseLong(primaryKey);
    SysResource sysResource = sysResourceMapper.selectByPrimaryKey(pk);
    if (null != sysResource.getParentIds()) {
      // 删除所有子资源
      SysResourceCriteria criteria = new SysResourceCriteria();
      criteria.createCriteria().andParentIdsLike(sysResource.getParentIds() + primaryKey + "/%");
      List<SysResource> childSysResourceList = sysResourceMapper.selectByExample(criteria);
      for (SysResource childSysResource : childSysResourceList) {
        sysResourceMapper.deleteByPrimaryKey(childSysResource.getId());
      }
    }
    sysResourceMapper.deleteByPrimaryKey(pk);

    // 清空Authorization缓存.
    sysAuthService.clearRealmCachedAuthorizationInfo();
  }

  @Override
  public String createParentIdsPathStr(Long parentId) {
    SysResource sysResource = sysResourceMapper.selectByPrimaryKey(parentId);
    if (null == sysResource) {
      return "0/";
    } else {
      String path = sysResource.getParentIds() == null ? "" : sysResource.getParentIds();
      return path + Long.toString(parentId) + "/";
    }
  }

  @Override
  public boolean hasRoleDependOnResource(String primaryKey) {
    SysRoleResourceCriteria criteria = new SysRoleResourceCriteria();
    criteria.createCriteria().andResourceIdEqualTo(Long.parseLong(primaryKey));
    return sysRoleResourceMapper.countByExample(criteria) > 0;
  }

  @Override
  public boolean hasPermissionDependOnResource(String primaryKey) {
    SysRoleResourcePermissionCriteria criteria = new SysRoleResourcePermissionCriteria();
    criteria.createCriteria().andResourceIdEqualTo(Long.parseLong(primaryKey));
    return sysRoleResourcePermissionMapper.countByExample(criteria) > 0;
  }
}
