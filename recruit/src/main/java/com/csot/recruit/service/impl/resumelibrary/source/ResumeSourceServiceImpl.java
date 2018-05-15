package com.csot.recruit.service.impl.resumelibrary.source;

import com.csot.recruit.dao.original.resumelibrary.source.ResumeSourceMapper;
import com.csot.recruit.model.original.resumelibrary.source.ResumeSource;
import com.csot.recruit.model.original.resumelibrary.source.ResumeSourceColumns;
import com.csot.recruit.model.original.resumelibrary.source.ResumeSourceCriteria;
import com.csot.recruit.service.resumelibrary.source.ResumeSourceService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service("resumeSourceService") public class ResumeSourceServiceImpl
    implements ResumeSourceService {
  private static final Logger logger = LoggerFactory.getLogger(ResumeSourceServiceImpl.class);

  @Resource private ResumeSourceMapper resumeSourceMapper;

  @Override
  public List<ResumeSource> getGrid(MiniGridPageSort pageSort, String sourceName) {
    ResumeSourceCriteria criteria = new ResumeSourceCriteria();
    // 查询条件
    if (StringUtils.hasText(sourceName)) {
      criteria.or().andSourceNameLike("%" + sourceName + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    //按照名称排序
    String nameColumn = ResumeSourceColumns.getColumn("sourceName");
    criteria.setOrderByClause(nameColumn + " asc");

    return resumeSourceMapper.selectByExample(criteria);
  }

  @Override public ResumeSource getByPrimaryKey(String primaryKey) {
    return resumeSourceMapper.selectByPrimaryKey(primaryKey);
  }

  @Override public void create(ResumeSource resumeSource) {
    if (!StringUtils.hasText(resumeSource.getParentId())) {
      resumeSource.setParentId("0");
    }
    resumeSource.setParentIds(createParentIdsPathStr(resumeSource.getParentId()));
    resumeSourceMapper.insert(resumeSource);
  }

  @Transactional
  @Override public void updateSelective(ResumeSource resumeSource) {
    if (resumeSource.getParentId() == null) {
      resumeSource.setParentId("0");
    }
    // 判断上级不能是本身
    if (resumeSource.getId().equals(resumeSource.getParentId())) {
      logger.warn("Modify ResumeSource[" + resumeSource.getId() + "] id == parentId");
    }
    ResumeSource origResumeSource = resumeSourceMapper.selectByPrimaryKey(resumeSource.getId());
    if (null == origResumeSource) {
      logger.error("Modify ResumeSource[" + resumeSource.getId() + "] is not exist");
    }
    // 如果修改上级，就需要更新所有子组的parentIds，否则不需要将所有子组的parentIds给重置
    if (!resumeSource.getParentId().equals(origResumeSource.getParentId())) {
      // 重新计算parentIdsPath
      resumeSource.setParentIds(createParentIdsPathStr(resumeSource.getParentId()));
      // 获取修改前简历来源的完整路径和修改后的完整路径
      String oldParentIdsPath = origResumeSource.getParentIds() + origResumeSource.getId() + "/";
      String newParentIdsPath = resumeSource.getParentIds() + resumeSource.getId().toString() + "/";
      // 更新所有子组的parentIds
      ResumeSourceCriteria criteria = new ResumeSourceCriteria();
      criteria.or().andParentIdsLike(oldParentIdsPath + "%");
      List<ResumeSource> childResumeSourceList = resumeSourceMapper.selectByExample(criteria);
      for (ResumeSource childResumeSource : childResumeSourceList) {
        childResumeSource.setParentIds(
            childResumeSource.getParentIds().replace(oldParentIdsPath, newParentIdsPath));
        resumeSourceMapper.updateByPrimaryKeySelective(childResumeSource);
      }
    } else {
      // parentId没变，更新时不更新parentId和parentIds字段
      resumeSource.setParentId(null);
      resumeSource.setParentIds(null);
    }
    resumeSourceMapper.updateByPrimaryKeySelective(resumeSource);
  }

  @Transactional
  @Override public void remove(String primaryKey) {
    ResumeSource resumeSource = resumeSourceMapper.selectByPrimaryKey(primaryKey);
    if (StringUtils.hasText(resumeSource.getParentIds())) {
      ResumeSourceCriteria criteria = new ResumeSourceCriteria();
      criteria.or().andParentIdsLike(resumeSource.getParentIds() + primaryKey + "/%");
      List<ResumeSource> childResumeSourceList = resumeSourceMapper.selectByExample(criteria);
      for (ResumeSource childResumeSource : childResumeSourceList) {
        resumeSourceMapper.deleteByPrimaryKey(childResumeSource.getId());
      }
    }
    resumeSourceMapper.deleteByPrimaryKey(primaryKey);
  }

  public String createParentIdsPathStr(String parentId) {
    ResumeSource resumeSource = resumeSourceMapper.selectByPrimaryKey(parentId);
    if (null == resumeSource) {
      return "0/";
    } else {
      String path = resumeSource.getParentIds() == null ? "" : resumeSource.getParentIds();
      return path + parentId + "/";
    }
  }
}
