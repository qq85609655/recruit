package com.csot.recruit.service.impl.flow.employ;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.dao.org.OrganazationMapper;
import com.csot.recruit.dao.original.candidate.CandidatePostMapper;
import com.csot.recruit.dao.original.flow.employ.EmployARalationMapper;
import com.csot.recruit.dao.original.flow.employ.EmployBlacklistMapper;
import com.csot.recruit.dao.original.flow.employ.EmployCandidateMapper;
import com.csot.recruit.dao.original.flow.employ.EmployDemandMapper;
import com.csot.recruit.dao.original.flow.employ.EmployEducationMapper;
import com.csot.recruit.dao.original.flow.employ.EmployMapper;
import com.csot.recruit.dao.original.flow.employ.EmployWorkMapper;
import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandMapper;
import com.csot.recruit.dao.original.uniform.JobMapper;
import com.csot.recruit.dao.original.uniform.OrganizationMapper;
import com.csot.recruit.model.original.candidate.CandidatePost;
import com.csot.recruit.model.original.flow.employ.Employ;
import com.csot.recruit.model.original.flow.employ.EmployARalation;
import com.csot.recruit.model.original.flow.employ.EmployARalationCriteria;
import com.csot.recruit.model.original.flow.employ.EmployBlacklist;
import com.csot.recruit.model.original.flow.employ.EmployBlacklistCriteria;
import com.csot.recruit.model.original.flow.employ.EmployCandidate;
import com.csot.recruit.model.original.flow.employ.EmployCandidateCriteria;
import com.csot.recruit.model.original.flow.employ.EmployColumns;
import com.csot.recruit.model.original.flow.employ.EmployCriteria;
import com.csot.recruit.model.original.flow.employ.EmployDemandCriteria;
import com.csot.recruit.model.original.flow.employ.EmployEducation;
import com.csot.recruit.model.original.flow.employ.EmployEducationCriteria;
import com.csot.recruit.model.original.flow.employ.EmployWork;
import com.csot.recruit.model.original.flow.employ.EmployCriteria.Criteria;
import com.csot.recruit.model.original.flow.employ.EmployDemand;
import com.csot.recruit.model.original.flow.employ.EmployWorkCriteria;
import com.csot.recruit.model.original.flow.recruitdemand.RdARalation;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.uniform.Job;
import com.csot.recruit.model.original.uniform.Organization;
import com.csot.recruit.model.original.uniform.OrganizationCriteria;
import com.csot.recruit.service.flow.employ.EmployService;

@Service("employService")
public class EmployServiceImpl implements EmployService {
  private static final Logger logger = LoggerFactory.getLogger(EmployServiceImpl.class);

  @Resource
  private EmployMapper employMapper;
  @Resource
  private JobMapper jobMapper;
  @Resource
  private OrganizationMapper organizationMapper;
  @Resource
  private CandidatePostMapper candidatePostMapper;
  @Resource
  private EmployCandidateMapper employCandidateMapper;
  @Resource
  private EmployDemandMapper employDemandMapper;
  @Resource
  private EmployEducationMapper employEducationMapper;
  @Resource
  private EmployWorkMapper employWorkMapper;
  @Resource
  private EmployBlacklistMapper employBlacklistMapper;
  @Resource
  private EmployARalationMapper employARalationMapper;
  @Resource
  private RecruitDemandMapper recruitDemandMapper;

  @Override
  public MiniRtn2Grid<Employ> getGrid(MiniGridPageSort pageSort, Map<String, String> col) {
    MiniRtn2Grid<Employ> grid = new MiniRtn2Grid<Employ>();
    EmployCriteria criteria = new EmployCriteria();
    // 查询条件
    criteria.setUserId(col.get("userId"));
    boolean needStage = true;
    if (StringUtils.hasText(col.get("postName"))) {
      criteria.createCriteria().andEmployPostNameLike("%" + col.get("postName") + "%")
          .andStageEqualTo(col.get("stage"));
      needStage = false;
    }
    if (StringUtils.hasText(col.get("candidateName"))) {
      criteria.createCriteria().andCandidateNameLike("%" + col.get("candidateName") + "%")
          .andStageEqualTo(col.get("stage"));
      needStage = false;
    }
    if (needStage) {
      criteria.createCriteria().andStageEqualTo(col.get("stage"));
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = EmployColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(employMapper.selectByExample(criteria));
    grid.setTotal(employMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public Employ getByPrimaryKey(String primaryKey) {
    return employMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public AjaxRtnJson create(Employ employ) {
    EmployBlacklistCriteria example2 = new EmployBlacklistCriteria();
    example2.createCriteria().andCandidateIdEqualTo(employ.getCandidateId())
        .andStateEqualTo(EmployBlacklist.state.YES.valueStr());
    List<EmployBlacklist> employBlacklists = employBlacklistMapper.selectByExample(example2);
    if (employBlacklists != null && employBlacklists.size() > 0) {
      // 该候选人已经列入黑名单
      return new AjaxRtnJson(false, "申请失败，该候选人已经列入黑名单");
    }
    EmployCriteria example1 = new EmployCriteria();
    example1.createCriteria().andCandidateIdEqualTo(employ.getCandidateId());
    List<Employ> employs = employMapper.selectByExample(example1);
    if (employs != null && employs.size() > 0) {
      // 该候选人已经申请
      return new AjaxRtnJson(false, "申请失败，该候选人已经申请");
    }
    // 获取职位信息进行数据初始化
    Job job = jobMapper.selectByCode(employ.getEmployPostId());
    employ.setEmployPostName(job.getcJobname());
    employ.setEmployOrgId(job.getcOrgcode());

    OrganizationCriteria example = new OrganizationCriteria();
    example.createCriteria().andCOrgcodeEqualTo(job.getcOrgcode());
    List<Organization> organizations = organizationMapper.selectByExample(example);
    if (organizations != null && organizations.size() > 0) {
      employ.setEmployOrgName(organizations.get(0).getcOrgname());
    }
    employ.setStage(Employ.stage.EMPLOY.valueStr()); // 默认创建为未提交的草稿状态
    employ.setFlowState(Employ.flowState.UNCOMMITTED.valueStr()); // 默认创建为未提交的草稿状态
    employMapper.insert(employ);
    // 申请成功
    AjaxRtnJson ajaxRtnJson = new AjaxRtnJson();
    ajaxRtnJson.setMsg("录用申请成功");
    ajaxRtnJson.setSuccess(true);
    ajaxRtnJson.setAttribute("id", employ.getId());
    return ajaxRtnJson;
  }

  @Override
  public void updateSelective(Employ employ) {
    employMapper.updateByPrimaryKeySelective(employ);
  }

  @Override
  public AjaxRtnJson remove(String ids) {
    String[] split = ids.split(",");
    int count = 0;
    for (String employeId : split) {
      Employ employ = employMapper.selectByPrimaryKey(employeId);
      if (Employ.flowState.UNCOMMITTED.valueStr().equals(employ.getFlowState())) {
        employMapper.deleteByPrimaryKey(employeId);
        EmployCandidateCriteria example = new EmployCandidateCriteria();
        EmployEducationCriteria example1 = new EmployEducationCriteria();
        EmployDemandCriteria example2 = new EmployDemandCriteria();
        EmployWorkCriteria example3 = new EmployWorkCriteria();
        // 关联录用id
        example.createCriteria().andEmployIdEqualTo(employeId);
        example1.createCriteria().andEmployIdEqualTo(employeId);
        example2.createCriteria().andEmployIdEqualTo(employeId);
        example3.createCriteria().andEmployIdEqualTo(employeId);
        // 联合删除所有从表
        employCandidateMapper.deleteByExample(example);
        employEducationMapper.deleteByExample(example1);
        employDemandMapper.deleteByExample(example2);
        employWorkMapper.deleteByExample(example3);
        count++;
      }
    }

    return new AjaxRtnJson(true, "成功删除" + count + "条数据!");
  }

  /**
   * 保存录用详情信息
   */
  @Override
  public void saveEmployInfo(EmployCandidate employCandidate, Employ employ,
      RecruitDemand recruitDemand, List<EmployWork> works, List<EmployEducation> edus,
      String attchmentIds, SysUser sysUser) {
    // 设置候选人岗位状态为录用流程中
    if (employ.getFlowState().equals(Employ.flowState.AUDIT.valueStr())) {
      CandidatePost candidatePost = new CandidatePost();
      candidatePost.setCandidateId(employ.getCandidateId());
      candidatePost.setInterviewStatus(CandidatePost.interviewStatus.EMPLOYING.valueStr());
      candidatePost.setPositionId(employ.getEmployPostId());
      candidatePost.setOperatorDate(new Date());
      candidatePostMapper.updateByUnion(candidatePost);
    }
    // 设置录用候选人信息
    employCandidate.setEmployId(employ.getId());
    employCandidate.setId(UUID.randomUUID().toString().replace("-", ""));
    employCandidate.setCreateDate(new Date());
    employCandidate.setCreatorId(sysUser.getId());
    employCandidateMapper.insert(employCandidate);
    // 新增录用需求信息
    EmployDemand employDemand = new EmployDemand();
    employDemand.setId(UUID.randomUUID().toString().replace("-", ""));
    employDemand.setEmployId(employ.getId());
    employDemand.setApplyOrganizationId(recruitDemand.getApplyOrganizationId());
    employDemand.setApplyOrganizationName(recruitDemand.getApplyOrganizationName());
    employDemand.setApplyPostId(recruitDemand.getApplyPostId());
    employDemand.setApplyPostName(recruitDemand.getApplyPostName());
    employDemand.setCreateDate(new Date());
    employDemand.setDemandId(recruitDemand.getDemandId());
    employDemand.setDistrict(recruitDemand.getDistrict());
    employDemand.setEmployeeType(recruitDemand.getEmployeeType());
    employDemand.setRankId(recruitDemand.getRankId());
    employDemand.setRecruitDemandReason(recruitDemand.getRecruitDemandReason());
    employDemand.setCreatorId(sysUser.getId());
    employDemandMapper.insert(employDemand);
    // 修改录用主体信息
    employMapper.updateByPrimaryKey(employ);
    // 删除录用教育经历和工作经历
    EmployEducationCriteria employEducationExample = new EmployEducationCriteria();
    employEducationExample.createCriteria().andEmployIdEqualTo(employ.getId());
    employEducationMapper.deleteByExample(employEducationExample);
    EmployWorkCriteria employWorkExample = new EmployWorkCriteria();
    employWorkExample.createCriteria().andEmployIdEqualTo(employ.getId());
    employWorkMapper.deleteByExample(employWorkExample);
    // 循环录入教育经历和工作经历
    if (edus != null && edus.size() > 0) {
      for (EmployEducation employEducation : edus) {
        employEducation.setId(UUID.randomUUID().toString().replace("-", ""));
        employEducation.setCreateDate(new Date());
        employEducation.setCreatorId(sysUser.getId());
        employEducation.setEmployId(employ.getId());
        employEducationMapper.insert(employEducation);
      }
    }
    if (works != null && works.size() > 0) {
      for (EmployWork employWork : works) {
        employWork.setId(UUID.randomUUID().toString().replace("-", ""));
        employWork.setEmployId(employ.getId());
        employWork.setCreateDate(new Date());
        employWork.setCreatorId(sysUser.getId());
        employWorkMapper.insert(employWork);
      }
    }
    // 删除原有附件
    EmployARalationCriteria example = new EmployARalationCriteria();
    example.createCriteria().andEmployIdEqualTo(employ.getId());
    employARalationMapper.deleteByExample(example);
    // 添加附件
    if (attchmentIds != null && (!attchmentIds.equals(""))) {
      String[] ids = attchmentIds.split(",");
      EmployARalation employARalation = null;
      for (String id : ids) {
        employARalation = new EmployARalation();
        employARalation.setCreateDate(new Date());
        employARalation.setCreatorId(sysUser.getId());
        employARalation.setId(UUID.randomUUID().toString().replace("-", ""));;
        employARalation.setAttachmentId(id);
        employARalation.setEmployId(employ.getId());
        employARalationMapper.insertSelective(employARalation);
      }
    }
  }

  @Override
  public void updateEmployInfo(EmployCandidate employCandidate, Employ employ,
      RecruitDemand recruitDemand, List<EmployWork> works, List<EmployEducation> edus,
      String attchmentIds, SysUser sysUser) {
    // 设置候选人岗位状态为录用流程中
    if (employ.getFlowState().equals(Employ.flowState.AUDIT.valueStr())) {
      CandidatePost candidatePost = new CandidatePost();
      candidatePost.setCandidateId(employ.getCandidateId());
      candidatePost.setInterviewStatus(CandidatePost.interviewStatus.EMPLOYING.valueStr());
      candidatePost.setPositionId(employ.getEmployPostId());
      candidatePost.setOperatorDate(new Date());
      candidatePostMapper.updateByUnion(candidatePost);
    }
    employCandidate.setUpdateDate(new Date());
    employCandidate.setModifiedId(sysUser.getId());
    employCandidateMapper.updateByPrimaryKeySelective(employCandidate); // 修改录用候选人信息
    if (!employ.getDemandId().equals(recruitDemand.getDemandId())) { // 招聘需求有修改
      EmployDemand employDemand = new EmployDemand();
      // 获取录用招聘表
      EmployDemandCriteria example = new EmployDemandCriteria();
      example.createCriteria().andEmployIdEqualTo(employ.getId());
      List<EmployDemand> employDemands = employDemandMapper.selectByExample(example);
      if (employDemands != null && employDemands.size() > 0) {
        employDemand = employDemands.get(0);
      }
      // 设置新需求信息
      employDemand.setApplyOrganizationId(recruitDemand.getApplyOrganizationId());
      employDemand.setApplyOrganizationName(recruitDemand.getApplyOrganizationName());
      employDemand.setApplyPostId(recruitDemand.getApplyPostId());
      employDemand.setApplyPostName(recruitDemand.getApplyPostName());
      employDemand.setUpdateDate(new Date());
      employDemand.setDemandId(recruitDemand.getDemandId());
      employDemand.setDistrict(recruitDemand.getDistrict());
      employDemand.setEmployeeType(recruitDemand.getEmployeeType());
      employDemand.setRankId(recruitDemand.getRankId());
      employDemand.setRecruitDemandReason(recruitDemand.getRecruitDemandReason());
      employDemand.setModifiedId(sysUser.getId());
      employDemandMapper.updateByPrimaryKey(employDemand);
      employ.setDemandId(recruitDemand.getDemandId());
    }
    // 修改录用主体信息
    employMapper.updateByPrimaryKeySelective(employ);
    // 删除录用教育经历和工作经历
    EmployEducationCriteria employEducationExample = new EmployEducationCriteria();
    employEducationExample.createCriteria().andEmployIdEqualTo(employ.getId());
    employEducationMapper.deleteByExample(employEducationExample);
    EmployWorkCriteria employWorkExample = new EmployWorkCriteria();
    employWorkExample.createCriteria().andEmployIdEqualTo(employ.getId());
    employWorkMapper.deleteByExample(employWorkExample);
    // 循环录入教育经历和工作经历
    if (edus != null && edus.size() > 0) {
      for (EmployEducation employEducation : edus) {
        employEducation.setId(UUID.randomUUID().toString().replace("-", ""));
        employEducation.setCreateDate(new Date());
        employEducation.setEmployId(employ.getId());
        employEducationMapper.insert(employEducation);
      }
    }
    if (works != null && works.size() > 0) {
      for (EmployWork employWork : works) {
        employWork.setId(UUID.randomUUID().toString().replace("-", ""));
        employWork.setEmployId(employ.getId());
        employWork.setCreateDate(new Date());
        employWorkMapper.insert(employWork);
      }
    }
    // 删除原有附件
    EmployARalationCriteria example = new EmployARalationCriteria();
    example.createCriteria().andEmployIdEqualTo(employ.getId());
    employARalationMapper.deleteByExample(example);
    // 添加附件
    if (attchmentIds != null && (!attchmentIds.equals(""))) {
      String[] ids = attchmentIds.split(",");
      EmployARalation employARalation = null;
      for (String id : ids) {
        employARalation = new EmployARalation();
        employARalation.setCreateDate(new Date());
        // employARalation.setCreatorId(sysUser.getId());
        employARalation.setId(UUID.randomUUID().toString().replace("-", ""));;
        employARalation.setAttachmentId(id);
        employARalation.setEmployId(employ.getId());
        employARalationMapper.insertSelective(employARalation);
      }
    }

  }

  @Override
  public AjaxRtnJson saveOffer(String ids) {
    String[] split = ids.split(",");
    int count = 0;
    for (String employeId : split) {
      Employ employ = employMapper.selectByPrimaryKey(employeId);
      employ.setStage(Employ.stage.OFFER.valueStr()); // 修改为发了offer的状态
      employ.setEntryDate(employ.getEntryDateHide()); // 入职时间 oa回传的预存字段获取
      employMapper.updateByPrimaryKeySelective(employ);
      // 将招聘需求的拟入职字段进行数据叠加
      RecruitDemand recruitDemand = recruitDemandMapper.selectByDemandId(employ.getDemandId());
      int oldNumber = recruitDemand.getOfferNumber() == null ? 0 : recruitDemand.getOfferNumber();
      recruitDemand.setOfferNumber(oldNumber + 1);
      recruitDemandMapper.updateByPrimaryKeySelective(recruitDemand);
      count++;
    }
    return new AjaxRtnJson(true, "成功发送" + count + "条offer!");
  }

  @Override
  public AjaxRtnJson entry(String ids) {
    String[] split = ids.split(",");
    int count = 0;
    List<String> errorStr = new ArrayList<String>();
    for (String employeId : split) {
      Employ employ = employMapper.selectByPrimaryKey(employeId);
      // 将招聘需求的入职字段进行数据叠加
      RecruitDemand recruitDemand = recruitDemandMapper.selectByDemandId(employ.getDemandId());
      if (RecruitDemand.isFinish.CANCEL.valueStr().equals(recruitDemand.getIsFinish())) {
        errorStr.add(employ.getCandidateName() + "(" + employ.getEmployPostName()
            + ")无法入职,招聘需求已经取消");
      } else {
        int oldNumber = recruitDemand.getEntryNumber() == null ? 0 : recruitDemand.getEntryNumber();
        recruitDemand.setEntryNumber(oldNumber + 1);
        // 如果人数和已经入职的人数相同 将需求变成已完成状态
        if (recruitDemand.getApplyPersonNumber().equals(recruitDemand.getEntryNumber())) {
          recruitDemand.setIsFinish(RecruitDemand.isFinish.FINISHED.valueStr());
        }
        recruitDemandMapper.updateByPrimaryKeySelective(recruitDemand);
        // 修改候选人岗位为入职状态
        CandidatePost candidatePost = new CandidatePost();
        candidatePost.setCandidateId(employ.getCandidateId());
        candidatePost.setInterviewStatus(CandidatePost.interviewStatus.ENTRY.valueStr());
        candidatePost.setPositionId(employ.getEmployPostId());
        candidatePost.setOperatorDate(new Date());
        candidatePostMapper.updateByUnion(candidatePost);
        employ.setStage(Employ.stage.ENTRY.valueStr()); // 修改为入职状态
        employ.setOfferDate(new Date()); // 发offer时间
        employMapper.updateByPrimaryKeySelective(employ);
        count++;
      }
    }
    return new AjaxRtnJson(true, "成功入职" + count + "人!"
        + (errorStr.isEmpty() ? "" : "<br/>"+StringUtil.joinString(errorStr, "<br/>")));
  }

  @Override
  public AjaxRtnJson isBlackList(Employ employ) {
    EmployBlacklistCriteria example2 = new EmployBlacklistCriteria();
    example2.createCriteria().andCandidateIdEqualTo(employ.getCandidateId())
        .andStateEqualTo(EmployBlacklist.state.YES.valueStr());
    List<EmployBlacklist> employBlacklists = employBlacklistMapper.selectByExample(example2);
    if (employBlacklists != null && employBlacklists.size() > 0) {
      // 该候选人列入过黑名单
      return new AjaxRtnJson(false, "申请失败，该候选人已经列入黑名单");
    }
    EmployBlacklistCriteria example1 = new EmployBlacklistCriteria();
    example1.createCriteria().andCandidateIdEqualTo(employ.getCandidateId())
        .andStateEqualTo(EmployBlacklist.state.NO.valueStr());
    List<EmployBlacklist> employBlacklists1 = employBlacklistMapper.selectByExample(example1);
    if (employBlacklists1 != null && employBlacklists1.size() > 0) {
      // 该候选人列入过黑名单
      return new AjaxRtnJson(true, "1");
    } else {
      return new AjaxRtnJson(true, "2");
    }
  }

  @Override
  public List<Employ> getEmployByCandidatePostId(Map<String, Object> param) {
    // TODO Auto-generated method stub
    return employMapper.selectByCandidatePostId(param);
  }


}