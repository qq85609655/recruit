package com.csot.recruit.service.impl.flow.recruitdemand;

import java.util.Date;
import java.util.List;

import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandShareMapper;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandShare;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandShareColumns;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandShareCriteria;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandShareService;

import javax.annotation.Resource;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("recruitDemandShareService")
public class RecruitDemandShareServiceImpl implements RecruitDemandShareService {
  private static final Logger logger = LoggerFactory.getLogger(RecruitDemandShareServiceImpl.class);

  @Resource
  private RecruitDemandShareMapper recruitDemandShareMapper;

  @Override
  public MiniRtn2Grid<RecruitDemandShare> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<RecruitDemandShare> grid = new MiniRtn2Grid<RecruitDemandShare>();
    RecruitDemandShareCriteria criteria = new RecruitDemandShareCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = RecruitDemandShareColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(recruitDemandShareMapper.selectByExample(criteria));
    grid.setTotal(recruitDemandShareMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public RecruitDemandShare getByPrimaryKey(String primaryKey) {
    return recruitDemandShareMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(RecruitDemandShare recruitDemandShare,SysUser sysUser) {
    RecruitDemandShareCriteria example = new RecruitDemandShareCriteria();
    example.createCriteria().andRecruitDemandIdEqualTo(recruitDemandShare.getRecruitDemandId());
    List<RecruitDemandShare> recruitDemandShares = recruitDemandShareMapper.selectByExample(example);
    if(recruitDemandShares!=null&&recruitDemandShares.size()>0){
      RecruitDemandShare recruitDemandShareOld = recruitDemandShares.get(0);
      recruitDemandShareOld.setRemark(recruitDemandShare.getRemark());
      recruitDemandShareOld.setShaerPersonId(recruitDemandShare.getShaerPersonId());
      recruitDemandShareOld.setShaerPersonName(recruitDemandShare.getShaerPersonName());
      recruitDemandShareOld.setCreateDate(new Date());
      recruitDemandShareOld.setPostId(recruitDemandShare.getPostId());
      recruitDemandShareMapper.updateByPrimaryKeySelective(recruitDemandShareOld);
    }else{
      recruitDemandShareMapper.insert(recruitDemandShare);
    }
  }

  @Override
  public void updateSelective(RecruitDemandShare recruitDemandShare) {
    recruitDemandShareMapper.updateByPrimaryKeySelective(recruitDemandShare);
  }

  @Override
  public void remove(String primaryKey) {
    recruitDemandShareMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public AjaxRtnJson removeShare(String demandId) {
    RecruitDemandShareCriteria example=new RecruitDemandShareCriteria();
    example.createCriteria().andRecruitDemandIdEqualTo(demandId);
    List<RecruitDemandShare> selectByExample = recruitDemandShareMapper.selectByExample(example);
    if(selectByExample==null||selectByExample.size()<=0){
      return new AjaxRtnJson(false, "取消失败，该岗位暂未被共承！");
    }
    recruitDemandShareMapper.deleteByExample(example);
    return new AjaxRtnJson(true, "取消共承成功！");
   
  }
}