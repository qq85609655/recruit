package com.csot.recruit.service.impl.flow.recruitdemand;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.excel.poi.ExcelExportManager;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.csot.recruit.common.constant.Constant;
import com.csot.recruit.common.util.EnumUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.dao.original.flow.recruitdemand.RdARalationMapper;
import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandLogMapper;
import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandMapper;
import com.csot.recruit.dao.original.flow.recruitdemand.RecruitDemandShareMapper;
import com.csot.recruit.dao.position.RecruitPositionMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.original.flow.recruitdemand.DemandSelfState;
import com.csot.recruit.model.original.flow.recruitdemand.RdARalation;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandByHandler;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandColumns;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandCriteria;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandLog;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandShareCriteria;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandVo;
import com.csot.recruit.model.position.RecruitPosition;
import com.csot.recruit.model.position.RecruitPositionCriteria;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandService;

@Service("recruitDemandService")
public class RecruitDemandServiceImpl implements RecruitDemandService {
  private static final Logger logger = LoggerFactory.getLogger(RecruitDemandServiceImpl.class);

  @Resource
  private RecruitDemandMapper recruitDemandMapper;
  @Resource
  private RecruitDemandLogMapper recruitDemandLogMapper;
  @Resource
  private RdARalationMapper rdARalationMapper;
  @Resource
  private ExcelExportManager excelExportManager;
  @Resource
  private RecruitPositionMapper recruitPositionMapper;
  @Resource
  private RecruitDemandShareMapper recruitDemandShareMapper;

  @Override
  public MiniRtn2Grid<RecruitDemandVo> getGrid(MiniGridPageSort pageSort,
      Map<String, String> searchMap) {
    MiniRtn2Grid<RecruitDemandVo> recruitDemandVoGrid = new MiniRtn2Grid<RecruitDemandVo>();// 页面视图对象
    RecruitDemandCriteria criteria = new RecruitDemandCriteria();
    // 查询条件
    String stateSelf = searchMap.get("stateSelf");
    String postId = searchMap.get("postId");
    String postName = searchMap.get("postName");
    String rankId = searchMap.get("rankId");
    String userId = searchMap.get("userId");
    String userCode = searchMap.get("userCode");

    String flowState = searchMap.get("flowState");
    String isShare = searchMap.get("isShare");
    String startDistributeDate = searchMap.get("startDistributeDate");
    String endDistributeDate = searchMap.get("endDistributeDate");
    String orgCode = searchMap.get("orgCode"); // 部门code
    RecruitDemandCriteria.Criteria orCriteria = criteria.or();
    criteria.setUserId(userId);
    criteria.setUserCode(userCode);
    if (StringUtils.hasText(flowState)) { // 根据岗位id查询列表（岗位条件历史记录）
      orCriteria.andFlowStateEqualTo(flowState);
    }
    if (StringUtils.hasText(isShare)) {// 是否共承
      if (isShare.equals("1")) { // 1.代表查询已经共承了的数据
        orCriteria.andHasShare();
      } else {
        orCriteria.andNotShare();
      }
    }

    if (StringUtils.hasText(orgCode)) { // 部门code
      orCriteria.andApplyOrganizationIdEqualTo(orgCode);
    }
    if (StringUtils.hasText(startDistributeDate)) { // 预计到岗时间 开始时间
      orCriteria.andStartDistributeDate(startDistributeDate);
    }
    if (StringUtils.hasText(endDistributeDate)) { // 预计到岗时间 结束时间
      orCriteria.andEndDistributeDate(endDistributeDate);
    }
    if (StringUtils.hasText(postId)) { // 根据岗位id查询列表（岗位条件历史记录）
      orCriteria.andApplyPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(postName)) { // 根据岗位名称模糊查询
      orCriteria.andApplyPostNameLikeInsensitive("%" + postName + "%");
    }
    if (StringUtils.hasText(rankId)) { // 根据职级查询
      orCriteria.andRankIdEqualTo(rankId);
    }
    if (StringUtils.hasText(postId)) { // 根据岗位id查询列表（岗位条件历史记录）
      orCriteria.andApplyPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(postId)) { // 根据岗位id查询列表（岗位条件历史记录）
      orCriteria.andApplyPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(stateSelf)) { // 根据状态查询列表 （招聘需求列表页）
      if (DemandSelfState.DRAFT.value().equals(stateSelf)) { // 草稿状态的需求
        orCriteria.andFlowStateEqualTo(RecruitDemand.flowState.UNCOMMITTED.valueStr());
      }
      if (DemandSelfState.AUDIT.value().equals(stateSelf)) { // 审批中状态的需求
        orCriteria.andFlowStateEqualTo(RecruitDemand.flowState.AUDIT.valueStr());
      }
      if (DemandSelfState.APPROVE.value().equals(stateSelf)) { // 审批完成状态的需求
        orCriteria.andFlowStateEqualTo(RecruitDemand.flowState.APPROVE.valueStr());
      }
      if (DemandSelfState.NOTFINISHED.value().equals(stateSelf)) { // 未完成状态的需求
        orCriteria.andIsFinishEqualTo(RecruitDemand.isFinish.NOTFINISHED.valueStr());
      }
      if (DemandSelfState.FINISHED.value().equals(stateSelf)) { // 已完成状态的需求
        orCriteria.andIsFinishEqualTo(RecruitDemand.isFinish.FINISHED.valueStr());
      }
      if (DemandSelfState.PASSANDNOTFINISHED.value().equals(stateSelf)) { // 审批通过并且未完成状态的需求
        orCriteria.andIsFinishEqualTo(RecruitDemand.isFinish.NOTFINISHED.valueStr())
            .andFlowStateEqualTo(RecruitDemand.flowState.APPROVE.valueStr());
      }
      if (DemandSelfState.DISCARD.value().equals(stateSelf)) { // 审批不通过的需求
        orCriteria.andFlowStateEqualTo(RecruitDemand.flowState.DISCARD.valueStr());
      }
      
      if (DemandSelfState.CANCEL.value().equals(stateSelf)) { // 取消的需求
        orCriteria.andIsFinishEqualTo(RecruitDemand.isFinish.CANCEL.valueStr());
      }
      


    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = RecruitDemandColumns.getColumn(pageSort.getSortField());
    if (StringUtil.isEmpty(sortColumn)) {
      sortColumn = "CREATE_DATE desc";
    }
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    // 需求id集合
    List<String> postIds = new ArrayList<String>();
    Map<String, RecruitPosition> mapRecruitPosition = new HashMap<String, RecruitPosition>();
    // 转换视图对象
    List<RecruitDemandVo> recruitdemands = recruitDemandMapper.selectByExampleVo(criteria);
    List<RecruitDemandVo> recruitDemandVos = new ArrayList<RecruitDemandVo>();
    for (RecruitDemandVo recruitDemand : recruitdemands) {
      if (StringUtil.isNotEmpty(recruitDemand.getApplyPostId())) {
        postIds.add(recruitDemand.getApplyPostId());
      }
      recruitDemand.setRankName(DatadictGroup.getTypeNameByTypeCode(recruitDemand.getRankId(),
          Constant.RANK_RECRUIT_DEMAND));
      recruitDemand.setSharePerson(recruitDemand.getSharePerson());
      recruitDemand.setShareRemark(recruitDemand.getShareRemark());
      recruitDemandVos.add(recruitDemand);
    }
    if (postIds.size() > 0) {
      RecruitPositionCriteria example = new RecruitPositionCriteria();
      example.createCriteria().andPositionCodeIn(postIds);
      List<RecruitPosition> recruitPositions = recruitPositionMapper.selectByExample(example);
      for (RecruitPosition recruitPosition : recruitPositions) {
        mapRecruitPosition.put(recruitPosition.getPositionCode(), recruitPosition);
      }
    }
    SimpleDateFormat yyyyMMddhhmm = new SimpleDateFormat("yyyy-MM-dd hh:ss");
    for (RecruitDemandVo recruitDemandVo : recruitDemandVos) {
      // 封装岗位信息
      RecruitPosition recruitPosition = mapRecruitPosition.get(recruitDemandVo.getApplyPostId());
      if (recruitPosition != null) {
        recruitDemandVo.setWebsitePostName(recruitPosition.getWebsitePostName());
        recruitDemandVo.setReleaseDate(yyyyMMddhhmm.format(recruitPosition.getReleaseDate()));
        // 发布的渠道
        if (StringUtil.isNotEmpty(recruitPosition.getTrench())) {
          String trench = recruitPosition.getTrench();
          String[] trenchIds = trench.split(",");
          List<String> trenchNames = new ArrayList<String>();
          if (trenchIds != null && trenchIds.length > 0) {
            for (String trenchId : trenchIds) {
              trenchNames.add(EnumUtil.getWebsiteNameByType(trenchId));
            }
          }
          recruitDemandVo.setWebsiteTypes(StringUtil.joinString(trenchNames, ","));
        }
      }
    }
    recruitDemandVoGrid.setData(recruitDemandVos);
    recruitDemandVoGrid.setTotal(recruitDemandMapper.countByExample(criteria));
    return recruitDemandVoGrid;
  }

  @Override
  public RecruitDemand getByPrimaryKey(String primaryKey) {
    return recruitDemandMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(RecruitDemand recruitDemand, SysUser sysUser) {
    // 设置主题
    String orgName = recruitDemand.getApplyOrganizationName();
    if (StringUtil.isNotEmpty(orgName)) {
      String orgNameTemp = orgName.substring(1, orgName.length());
      recruitDemand.setTheme(orgNameTemp.substring(0, orgNameTemp.indexOf("\\"))
          + recruitDemand.getApplyPostName() + "招聘需求申请");
    }
    // 添加附件
    if (recruitDemand.getAttchmentIds() != null && (!recruitDemand.getAttchmentIds().equals(""))) {
      String[] ids = recruitDemand.getAttchmentIds().split(",");
      RdARalation rdARalation = null;
      for (String id : ids) {
        rdARalation = new RdARalation();
        rdARalation.setCreateDate(new Date());
        rdARalation.setCreatorId(sysUser.getId());
        rdARalation.setId(UUID.randomUUID().toString().replace("-", ""));;
        rdARalation.setAttachmentId(id);
        rdARalation.setRecruitDemandId(recruitDemand.getId());
        rdARalationMapper.insertSelective(rdARalation);
      }
    }
    // 根据岗位id获取招聘需求
    RecruitDemandCriteria example = new RecruitDemandCriteria();
    example.createCriteria().andApplyPostIdEqualTo(recruitDemand.getApplyPostId());
    List<RecruitDemand> recruitDemands = recruitDemandMapper.selectByExample(example);
    if (recruitDemands != null && recruitDemands.size() > 0) {
      // 同步招聘状态
      recruitDemand.setInfoState(recruitDemands.get(0).getInfoState());
    }
    // 添加招聘需求
    recruitDemandMapper.insert(recruitDemand);

  }

  @Override
  public void updateSelective(RecruitDemand recruitDemand, SysUser sysUser) {
    // 删除原有附件
    rdARalationMapper.deleteByRecruitDemandId(recruitDemand.getId());
    // 添加附件
    if (recruitDemand.getAttchmentIds() != null && (!recruitDemand.getAttchmentIds().equals(""))) {
      String[] ids = recruitDemand.getAttchmentIds().split(",");
      RdARalation rdARalation = null;
      for (String id : ids) {
        rdARalation = new RdARalation();
        rdARalation.setCreateDate(new Date());
        rdARalation.setCreatorId(sysUser.getId());
        rdARalation.setId(UUID.randomUUID().toString().replace("-", ""));;
        rdARalation.setAttachmentId(id);
        rdARalation.setRecruitDemandId(recruitDemand.getId());
        rdARalationMapper.insertSelective(rdARalation);
      }
    }
    // 修改招聘需求
    recruitDemandMapper.updateByPrimaryKeySelective(recruitDemand);
  }

  @Override
  public void remove(String primaryKey) {
    recruitDemandMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public void updateSelectiveSelf(RecruitDemand recruitDemand, RecruitDemand recruitDemandOld,
      SysUser sysUser) {
    RecruitDemandLog recruitDemandLog = new RecruitDemandLog();
    recruitDemandLog.setDemandId(recruitDemand.getId());
    recruitDemandLog.setUpdateDate(new Date());
    recruitDemandLog.setModifiedId(sysUser.getId());
    recruitDemandLog.setModifiedName(sysUser.getAccount());
    if (!recruitDemandOld.getWorkRemark().equals(recruitDemand.getWorkRemark())) {
      // 岗位描述有变动 进行日志记录
      recruitDemandLog.setId(UUID.randomUUID().toString().replace("-", ""));
      recruitDemandLog.setNewStr(recruitDemand.getWorkRemark());
      recruitDemandLog.setOldStr(recruitDemandOld.getWorkRemark());
      recruitDemandLog.setUpdateField("岗位工作描述");
      recruitDemandLogMapper.insertSelective(recruitDemandLog);
    }
    if (!recruitDemandOld.getGender().equals(recruitDemand.getGender())) {
      // 性别有变动 进行日志记录
      recruitDemandLog.setId(UUID.randomUUID().toString().replace("-", ""));
      recruitDemandLog.setNewStr(recruitDemand.getGender());
      recruitDemandLog.setOldStr(recruitDemandOld.getGender());
      recruitDemandLog.setUpdateField("性别");
      recruitDemandLogMapper.insertSelective(recruitDemandLog);
    }
    if (!recruitDemandOld.getEducation().equals(recruitDemand.getEducation())) {
      // 学历有变动 进行日志记录
      recruitDemandLog.setId(UUID.randomUUID().toString().replace("-", ""));
      recruitDemandLog.setNewStr(recruitDemand.getEducation());
      recruitDemandLog.setOldStr(recruitDemandOld.getEducation());
      recruitDemandLog.setUpdateField("学历");
      recruitDemandLogMapper.insertSelective(recruitDemandLog);
    }
    if (!recruitDemandOld.getProfession().equals(recruitDemand.getProfession())) {
      // 专业有变动 进行日志记录
      recruitDemandLog.setId(UUID.randomUUID().toString().replace("-", ""));
      recruitDemandLog.setNewStr(recruitDemand.getProfession());
      recruitDemandLog.setOldStr(recruitDemandOld.getProfession());
      recruitDemandLog.setUpdateField("专业");
      recruitDemandLogMapper.insertSelective(recruitDemandLog);
    }
    if (!recruitDemandOld.getWorkExperience().equals(recruitDemand.getWorkExperience())) {
      // 工作经验有变动 进行日志记录
      recruitDemandLog.setId(UUID.randomUUID().toString().replace("-", ""));
      recruitDemandLog.setNewStr(recruitDemand.getWorkExperience());
      recruitDemandLog.setOldStr(recruitDemandOld.getWorkExperience());
      recruitDemandLog.setUpdateField("工作经验");
      recruitDemandLogMapper.insertSelective(recruitDemandLog);
    }
    if (!recruitDemandOld.getRequiredSkill().equals(recruitDemand.getRequiredSkill())) {
      // 必备技能有变动 进行日志记录
      recruitDemandLog.setId(UUID.randomUUID().toString().replace("-", ""));
      recruitDemandLog.setNewStr(recruitDemand.getRequiredSkill());
      recruitDemandLog.setOldStr(recruitDemandOld.getRequiredSkill());
      recruitDemandLog.setUpdateField("必备技能");
      recruitDemandLogMapper.insertSelective(recruitDemandLog);
    }
    if (!recruitDemandOld.getAbilityDemanded().equals(recruitDemand.getAbilityDemanded())) {
      // 素质及能力要求有变动 进行日志记录
      recruitDemandLog.setId(UUID.randomUUID().toString().replace("-", ""));
      recruitDemandLog.setNewStr(recruitDemand.getAbilityDemanded());
      recruitDemandLog.setOldStr(recruitDemandOld.getAbilityDemanded());
      recruitDemandLog.setUpdateField("素质及能力");
      recruitDemandLogMapper.insertSelective(recruitDemandLog);
    }
    // 删除原有附件
    rdARalationMapper.deleteByRecruitDemandId(recruitDemand.getId());
    // 添加附件
    if (recruitDemand.getAttchmentIds() != null && (!recruitDemand.getAttchmentIds().equals(""))) {
      String[] ids = recruitDemand.getAttchmentIds().split(",");
      RdARalation rdARalation = null;
      for (String id : ids) {
        rdARalation = new RdARalation();
        rdARalation.setCreateDate(new Date());
        rdARalation.setCreatorId(sysUser.getId());
        rdARalation.setId(UUID.randomUUID().toString().replace("-", ""));;
        rdARalation.setAttachmentId(id);
        rdARalation.setRecruitDemandId(recruitDemand.getId());
        rdARalationMapper.insertSelective(rdARalation);
      }
    }
    // 修改招聘需求
    recruitDemandMapper.updateByPrimaryKeySelective(recruitDemand);
  }

  /**
   * 根据招聘单号获取招聘需求
   * 
   * @param demandId
   * @return
   */
  @Override
  public RecruitDemand getByDemandId(String demandId, SysUser sysUser) {
    RecruitDemandCriteria example = new RecruitDemandCriteria();
    example.createCriteria().andDemandIdEqualTo(demandId);
    example.setUserId(sysUser.getId());
    example.setUserCode(sysUser.getWorkCode());
    List<RecruitDemand> recruitDemands = recruitDemandMapper.selectByExample(example);
    if (recruitDemands != null && recruitDemands.size() > 0) {
      return recruitDemands.get(0);
    }
    return null;
  }

  @Override
  public MiniRtn2Grid<RecruitDemandByHandler> getGridByHandler(MiniGridPageSort pageSort,
      Map<String, String> searchMap) {
    MiniRtn2Grid<RecruitDemandByHandler> recruitDemandVoGrid =
        new MiniRtn2Grid<RecruitDemandByHandler>();// 页面视图对象
    RecruitDemandCriteria criteria = new RecruitDemandCriteria();
    // 查询条件
    String stateSelf = searchMap.get("stateSelf");
    String postId = searchMap.get("postId");
    String postName = searchMap.get("postName");
    String rankId = searchMap.get("rankId");
    String userId = searchMap.get("userId");
    String userCode = searchMap.get("userCode");

    String flowState = searchMap.get("flowState");
    String isShare = searchMap.get("isShare");
    String startDistributeDate = searchMap.get("startDistributeDate");
    String endDistributeDate = searchMap.get("endDistributeDate");
    String orgCode = searchMap.get("orgCode"); // 部门code

    RecruitDemandCriteria.Criteria orCriteria = criteria.or();
    criteria.setUserId(userId);
    criteria.setUserCode(userCode);

    if (StringUtils.hasText(flowState)) { // 根据岗位id查询列表（岗位条件历史记录）
      orCriteria.andFlowStateEqualTo(flowState);
    }
    if (StringUtils.hasText(isShare)) {// 是否共承
      if (isShare.equals("1")) { // 1.代表查询已经共承了的数据
        orCriteria.andHasShare();
      } else {
        orCriteria.andNotShare();
      }
    }

    if (StringUtils.hasText(orgCode)) { // 部门code
      orCriteria.andApplyOrganizationIdEqualTo(orgCode);
    }
    if (StringUtils.hasText(startDistributeDate)) { // 预计到岗时间 开始时间
      orCriteria.andStartDistributeDate(startDistributeDate);
    }
    if (StringUtils.hasText(endDistributeDate)) { // 预计到岗时间 结束时间
      orCriteria.andEndDistributeDate(endDistributeDate);
    }
    if (StringUtils.hasText(postId)) { // 根据岗位id查询列表（岗位条件历史记录）
      orCriteria.andApplyPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(postName)) { // 根据岗位名称模糊查询
      orCriteria.andApplyPostNameLikeInsensitive("%" + postName + "%");
    }
    if (StringUtils.hasText(rankId)) { // 根据职级查询
      orCriteria.andRankIdEqualTo(rankId);
    }
    if (StringUtils.hasText(postId)) { // 根据岗位id查询列表（岗位条件历史记录）
      orCriteria.andApplyPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(stateSelf)) { // 根据状态查询列表 （招聘需求列表页）
      if (DemandSelfState.DRAFT.value().equals(stateSelf)) { // 草稿状态的需求
        orCriteria.andFlowStateEqualTo(RecruitDemand.flowState.UNCOMMITTED.valueStr());
      }
      if (DemandSelfState.AUDIT.value().equals(stateSelf)) { // 审批中状态的需求
        orCriteria.andFlowStateEqualTo(RecruitDemand.flowState.AUDIT.valueStr());
      }
      if (DemandSelfState.APPROVE.value().equals(stateSelf)) { // 审批完成状态的需求
        orCriteria.andFlowStateEqualTo(RecruitDemand.flowState.APPROVE.valueStr());
      }
      if (DemandSelfState.NOTFINISHED.value().equals(stateSelf)) { // 未完成状态的需求
        orCriteria.andIsFinishEqualTo(RecruitDemand.isFinish.NOTFINISHED.valueStr());
      }
      if (DemandSelfState.FINISHED.value().equals(stateSelf)) { // 已完成状态的需求
        orCriteria.andIsFinishEqualTo(RecruitDemand.isFinish.FINISHED.valueStr());
      }
      if (DemandSelfState.PASSANDNOTFINISHED.value().equals(stateSelf)) { // 审批通过并且未完成状态的需求
        orCriteria.andIsFinishEqualTo(RecruitDemand.isFinish.NOTFINISHED.valueStr())
            .andFlowStateEqualTo(RecruitDemand.flowState.APPROVE.valueStr());
      }
      if (DemandSelfState.DISCARD.value().equals(stateSelf)) { // 审批不通过的需求
        orCriteria.andFlowStateEqualTo(RecruitDemand.flowState.DISCARD.valueStr());
      }
      if (DemandSelfState.CANCEL.value().equals(stateSelf)) { // 取消的需求
        orCriteria.andIsFinishEqualTo(RecruitDemand.isFinish.CANCEL.valueStr());
      }
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = RecruitDemandColumns.getColumn(pageSort.getSortField());
    if (StringUtil.isEmpty(sortColumn)) {
      sortColumn = "CREATE_DATE desc";
    }
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    // 转换视图对象
    List<RecruitDemandByHandler> recruitdemands =
        recruitDemandMapper.selectByExampleByHandler(criteria);
    for (RecruitDemandByHandler recruitDemandByHandler : recruitdemands) {
      recruitDemandByHandler.setRankName(DatadictGroup.getTypeNameByTypeCode(
           recruitDemandByHandler.getRankId(),Constant.RANK_RECRUIT_DEMAND));
    }
    recruitDemandVoGrid.setData(recruitdemands);
    recruitDemandVoGrid.setTotal(recruitDemandMapper.countByExampleByHandler(criteria));
    return recruitDemandVoGrid;
  }

  @Override
  public void updateStatusByOA(RecruitDemand demand) {
    recruitDemandMapper.updateByPrimaryKeySelective(demand);
  }


}