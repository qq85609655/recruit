package org.amberframework.web.system.auth.service.impl.group;

import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.system.auth.dao.original.group.SysGroupMapper;
import org.amberframework.web.system.auth.exception.AuthSysGroupServiceException;
import org.amberframework.web.system.auth.model.original.group.SysGroup;
import org.amberframework.web.system.auth.model.original.group.SysGroupColumns;
import org.amberframework.web.system.auth.model.original.group.SysGroupCriteria;
import org.amberframework.web.system.auth.service.group.SysGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("sysGroupService")
public class SysGroupServiceImpl implements SysGroupService {
  private static final Logger logger = LoggerFactory.getLogger(SysGroupServiceImpl.class);

  @Resource
  private SysGroupMapper sysGroupMapper;

  @Override
  public List<SysGroup> getGrid(MiniGridPageSort pageSort, String searchKey) {
    SysGroupCriteria criteria = new SysGroupCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andNameLike("%" + searchKey + "%");
    }
    // 分页
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    //按照名称排序
    String nameColumn = SysGroupColumns.getColumn("name");
    criteria.setOrderByClause(nameColumn + " asc");
    
    return sysGroupMapper.selectByExample(criteria);
  }

  @Override
  public SysGroup getByPrimaryKey(String primaryKey) {
    Long pk = Long.parseLong(primaryKey);
    return sysGroupMapper.selectByPrimaryKey(pk);
  }

  @Override
  public void create(SysGroup sysGroup) {
    if (sysGroup.getParentId() == null) {
      // 如果上级组id为空，则设置为0，0表示顶级组
      sysGroup.setParentId(0L);
    }
    sysGroup.setParentIds(this.createParentIdsPathStr(sysGroup.getParentId()));
    sysGroupMapper.insert(sysGroup);
  }

  @Transactional
  @Override
  public void updateSelective(SysGroup sysGroup) {
    if (sysGroup.getParentId() == null) {
      // 如果上级组id为空，则设置为0，0表示顶级组
      sysGroup.setParentId(0L);
    }
    // 判断上级组不能是本身
    if (sysGroup.getId().equals(sysGroup.getParentId())) {
      logger.warn("Modify SysGroup[" + sysGroup.getId() + "] id == parentId");
      throw new AuthSysGroupServiceException("上级组不能是本身");
    }
    SysGroup origSysGroup = sysGroupMapper.selectByPrimaryKey(sysGroup.getId());
    if (null == origSysGroup) {
      logger.error("Modify SysGroup[" + sysGroup.getId() + "] is not exist");
      throw new AuthSysGroupServiceException("组不存在");
    }
    // 如果修改上级Group，就需要更新所有子组的parentIds，否则不需要将所有子组的parentIds给重置
    if (!sysGroup.getParentId().equals(origSysGroup.getParentId())) {
      // 重新计算parentIdsPath
      sysGroup.setParentIds(this.createParentIdsPathStr(sysGroup.getParentId()));
      // 获取修改前group的完整路径和修改后的完整路径
      String oldParentIdsPath = origSysGroup.getParentIds() + origSysGroup.getId() + "/";
      String newParentIdsPath = sysGroup.getParentIds() + sysGroup.getId().toString() + "/";
      // 更新所有子组的parentIds
      SysGroupCriteria criteria = new SysGroupCriteria();
      criteria.createCriteria().andParentIdsLike(oldParentIdsPath + "%");
      List<SysGroup> childSysGroupList = sysGroupMapper.selectByExample(criteria);
      for (SysGroup childSysGroup : childSysGroupList) {
        childSysGroup.setParentIds(childSysGroup.getParentIds().replace(oldParentIdsPath, newParentIdsPath));
        sysGroupMapper.updateByPrimaryKeySelective(childSysGroup);
      }
    } else {
      // parentId没变，更新时不更新parentId和parentIds字段
      sysGroup.setParentId(null);
      sysGroup.setParentIds(null);
    }
    
    sysGroupMapper.updateByPrimaryKeySelective(sysGroup);
  }

  @Transactional
  @Override
  public void remove(String primaryKey) {
    Long pk = Long.parseLong(primaryKey);
    SysGroup sysGroup = sysGroupMapper.selectByPrimaryKey(pk);
    if (null != sysGroup.getParentIds()) {
      // 删除所有子组
      SysGroupCriteria criteria = new SysGroupCriteria();
      criteria.createCriteria().andParentIdsLike(sysGroup.getParentIds() + primaryKey + "/%");
      List<SysGroup> childSysGroupList = sysGroupMapper.selectByExample(criteria);
      for (SysGroup childSysGroup : childSysGroupList) {
        sysGroupMapper.deleteByPrimaryKey(childSysGroup.getId());
      }
    }
    sysGroupMapper.deleteByPrimaryKey(pk);
  }

  @Override
  public String createParentIdsPathStr(Long parentId) {
    SysGroup sysGroup = sysGroupMapper.selectByPrimaryKey(parentId);
    if (null == sysGroup) {
      return "0/";
    } else {
      String path = sysGroup.getParentIds() == null ? "" : sysGroup.getParentIds();
      return path + Long.toString(parentId) + "/";
    }
  }
}
