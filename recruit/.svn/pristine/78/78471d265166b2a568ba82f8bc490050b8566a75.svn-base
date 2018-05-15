package com.csot.recruit.service.impl.flow.websitePost;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandMapper;
import com.csot.recruit.dao.original.flow.websitePost.PostWebsiteInstructMapper;
import com.csot.recruit.dao.original.flow.websitePost.PostWebsiteLogMapper;
import com.csot.recruit.dao.original.flow.websitePost.PostWebsiteMapper;
import com.csot.recruit.dao.position.RecruitPositionMapper;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandCriteria;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstruct;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstructColumns;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteInstructCriteria;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteLog;
import com.csot.recruit.model.original.flow.websitePost.PostWebsiteWithBLOBs;
import com.csot.recruit.model.position.RecruitPosition;
import com.csot.recruit.service.flow.websitePost.PostWebsiteInstructService;

@Service("postWebsiteInstructService")
public class PostWebsiteInstructServiceImpl implements PostWebsiteInstructService {
  private static final Logger logger = LoggerFactory
      .getLogger(PostWebsiteInstructServiceImpl.class);

  @Resource
  private PostWebsiteInstructMapper postWebsiteInstructMapper;
  @Resource
  private PostWebsiteMapper postWebsiteMapper;
  @Resource
  private PostWebsiteLogMapper postWebsiteLogMapper;
  @Resource
  private RecruitPositionMapper recruitPositionMapper;
  @Resource
  private RecruitDemandMapper recruitDemandMapper;

  @Override
  public MiniRtn2Grid<PostWebsiteInstruct> getGrid(MiniGridPageSort pageSort,
      Map<String, String> col) {
    MiniRtn2Grid<PostWebsiteInstruct> grid = new MiniRtn2Grid<PostWebsiteInstruct>();
    PostWebsiteInstructCriteria criteria = new PostWebsiteInstructCriteria();
    PostWebsiteInstructCriteria.Criteria criteriaOr = criteria.or();
    // 查询条件
    if (StringUtils.hasText(col.get("tabState"))) {
      criteriaOr.andWebsiteTypeEqualTo(col.get("tabState"));
    }
    if (StringUtils.hasText(col.get("bState"))) {
      criteriaOr.andBeforeStateEqualTo(col.get("bState"));
    }
    if (StringUtils.hasText(col.get("aState"))) {
      criteriaOr.andAfterStateEqualTo(col.get("aState"));
    }
    if (StringUtils.hasText(col.get("instructType"))) {
      criteriaOr.andInstructTypeEqualTo(col.get("instructType"));
    }
    if (StringUtils.hasText(col.get("isDeal"))) {
      criteriaOr.andIsDealEqualTo(col.get("isDeal"));
    }
    if (StringUtils.hasText(col.get("postNameStr"))) {
      criteriaOr.andPostNameLike("%" + col.get("postNameStr") + "%");
    }
    if (StringUtils.hasText(col.get("webpostName"))) {
      criteriaOr.andWebsitePostNameLike("%" + col.get("webpostName") + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PostWebsiteInstructColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(postWebsiteInstructMapper.selectByExample(criteria));
    grid.setTotal(postWebsiteInstructMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public PostWebsiteInstruct getByPrimaryKey(String primaryKey) {
    return postWebsiteInstructMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PostWebsiteInstruct postWebsiteInstruct) {
    postWebsiteInstructMapper.insert(postWebsiteInstruct);
  }

  @Override
  public void updateSelective(PostWebsiteInstruct postWebsiteInstruct) {
    postWebsiteInstructMapper.updateByPrimaryKeySelective(postWebsiteInstruct);
  }

  @Override
  public void remove(String primaryKey) {
    postWebsiteInstructMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public void changeInstructState(String idsStr, SysUser sysUser) {
    String[] ids = idsStr.split(",");
    for (String id : ids) {
      // 修改指令数据状态
      PostWebsiteInstruct postWebsiteInstruct = postWebsiteInstructMapper.selectByPrimaryKey(id);
      if (PostWebsiteInstruct.isDeal.YES.getValueStr().equals(postWebsiteInstruct.getIsDeal())) {
        continue;
      }
      postWebsiteInstruct.setIsDeal(PostWebsiteInstruct.isDeal.YES.getValueStr());

      // 进行网站岗位详情的新增/修改
      String postWebsiteId = postWebsiteInstruct.getPostWebsiteId();
      // 获取岗位详情信息
      RecruitPosition recruitPosition =
          recruitPositionMapper.selectByPrimaryKey(postWebsiteInstruct.getRecruitPositionId());
      if (StringUtil.isEmpty(postWebsiteId)) {
        // 进行新增操作
        String relevanceId = UUID.randomUUID().toString().replace("-", "");
        postWebsiteInstruct.setPostWebsiteId(relevanceId); // 新增操作将网站岗位详情id填充到指令表
        PostWebsiteWithBLOBs newPostWebsiteWithBLOBs = new PostWebsiteWithBLOBs();
        newPostWebsiteWithBLOBs.setId(relevanceId);
        newPostWebsiteWithBLOBs.setContent(recruitPosition.getPositionDescription()); // 直接从岗位表获取外招岗位描述
        newPostWebsiteWithBLOBs.setContent2(recruitPosition.getPositionDescription2()); // 直接从岗位表获取外招岗位描述
        newPostWebsiteWithBLOBs.setCreateDate(new Date());
        newPostWebsiteWithBLOBs.setCreatorId(sysUser.getId());
        newPostWebsiteWithBLOBs.setDeputyId(postWebsiteInstruct.getDeputyId());
        newPostWebsiteWithBLOBs.setDeputyName(postWebsiteInstruct.getDeputyName());
        newPostWebsiteWithBLOBs.setLastInstruct(postWebsiteInstruct.getInstructType());
        newPostWebsiteWithBLOBs.setModifiedId(sysUser.getId());
        newPostWebsiteWithBLOBs.setPostId(postWebsiteInstruct.getPostId());
        newPostWebsiteWithBLOBs.setPostName(postWebsiteInstruct.getPostName());
        newPostWebsiteWithBLOBs.setRecruitPositionId(postWebsiteInstruct.getRecruitPositionId());
        newPostWebsiteWithBLOBs.setState(postWebsiteInstruct.getAfterState());
        newPostWebsiteWithBLOBs.setWebsitePostName(postWebsiteInstruct.getWebsitePostName());
        newPostWebsiteWithBLOBs.setWebsiteType(postWebsiteInstruct.getWebsiteType());
        newPostWebsiteWithBLOBs.setInstructDate(new Date());
        postWebsiteMapper.insert(newPostWebsiteWithBLOBs);
      } else {
        if(postWebsiteInstruct.getInstructType().equals(PostWebsiteInstruct.instructType.SC.getValueStr())){
          postWebsiteMapper.deleteByPrimaryKey(postWebsiteId);
        }else{
          // 进行修改操作
          PostWebsiteWithBLOBs postWebsiteWithBLOBs =
              postWebsiteMapper.selectByPrimaryKey(postWebsiteId);
          postWebsiteWithBLOBs.setUpdateDate(new Date());
          postWebsiteWithBLOBs.setWebsitePostName(postWebsiteInstruct.getWebsitePostName());
          postWebsiteWithBLOBs.setModifiedId(sysUser.getId());
          postWebsiteWithBLOBs.setInstructDate(new Date()); // 指令时间
          postWebsiteWithBLOBs.setLastInstruct(postWebsiteInstruct.getInstructType()); // 最后指令类型
          postWebsiteWithBLOBs.setState(postWebsiteInstruct.getAfterState()); // 操作后的状态
          postWebsiteWithBLOBs.setContent(recruitPosition.getPositionDescription()); // 直接从岗位表获取外招岗位描述
          postWebsiteWithBLOBs.setContent2(recruitPosition.getPositionDescription2()); // 直接从岗位表获取外招岗位描述
          postWebsiteMapper.updateByPrimaryKeySelective(postWebsiteWithBLOBs);
        }
      }
      postWebsiteInstructMapper.updateByPrimaryKey(postWebsiteInstruct);
      // 生成历史操作记录
      PostWebsiteLog postWebsiteLog = new PostWebsiteLog();
      postWebsiteLog.setId(UUID.randomUUID().toString().replace("-", ""));
      postWebsiteLog.setCreateDate(new Date());
      postWebsiteLog.setCreatorId(sysUser.getId());
      postWebsiteLog.setDeputyId(postWebsiteInstruct.getDeputyId());
      postWebsiteLog.setDeputyName(postWebsiteInstruct.getDeputyName());
      postWebsiteLog.setLastInstruct(postWebsiteInstruct.getInstructType());
      postWebsiteLog.setModifiedId(sysUser.getId());
      postWebsiteLog.setPostId(postWebsiteInstruct.getPostId());
      postWebsiteLog.setPostName(postWebsiteInstruct.getPostName());
      postWebsiteLog.setRecruitPositionId(postWebsiteInstruct.getRecruitPositionId());
      postWebsiteLog.setState(postWebsiteInstruct.getAfterState());
      postWebsiteLog.setWebsitePostName(postWebsiteInstruct.getWebsitePostName());
      postWebsiteLog.setWebsiteType(postWebsiteInstruct.getWebsiteType());
      postWebsiteLog.setBeforeState(postWebsiteInstruct.getBeforeState());
      postWebsiteLog.setInstructDate(new Date());
      postWebsiteLogMapper.insert(postWebsiteLog);
      // 将不是发布状态的招聘需求变为发布状态
      RecruitDemand recruitDemandUpdate = new RecruitDemand();
      recruitDemandUpdate.setInfoState(RecruitDemand.infoState.PUBLISHED.getValueStr()); // 修改为发布状态
      RecruitDemandCriteria recruitDemandExample = new RecruitDemandCriteria();
      recruitDemandExample.createCriteria().andApplyPostIdEqualTo(postWebsiteInstruct.getPostId())
          .andInfoStateNotEqualTo(RecruitDemand.infoState.PUBLISHED.getValueStr());
      recruitDemandMapper.updateByExampleSelective(recruitDemandUpdate, recruitDemandExample);
    }


  }
}
