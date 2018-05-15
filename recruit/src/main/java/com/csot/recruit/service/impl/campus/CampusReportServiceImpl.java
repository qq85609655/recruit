package com.csot.recruit.service.impl.campus;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.csot.recruit.common.util.CommonConstant;
import com.csot.recruit.dao.original.campus.CampusPostMapper;
import com.csot.recruit.dao.original.campus.CampusSiteMapper;
import com.csot.recruit.dao.original.campus.CampusStudentMapper;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.model.extension.campus.CampusJobFamilyAchievement;
import com.csot.recruit.model.extension.campus.CampusReportExt;
import com.csot.recruit.model.original.campus.*;
import com.csot.recruit.service.campus.*;

import javax.annotation.Resource;

import com.csot.recruit.service.datadict.DatadictGroupTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("campusReportService")
public class CampusReportServiceImpl implements CampusReportService {
  private static final Logger logger = LoggerFactory.getLogger(CampusReportServiceImpl.class);
  private static final NumberFormat percentFormat = NumberFormat.getPercentInstance();

  @Resource
  private CampusPostMapper campusPostMapper;
  @Resource
  private CampusSiteMapper campusSiteMapper;
  @Resource
  private CampusStudentMapper campusStudentMapper;
  @Resource
  private CampusSiteService campusSiteService;
  @Resource
  private CampusTaskService campusTaskService;
  @Resource
  private DatadictGroupTypeService datadictGroupTypeService;
  @Resource
  private CampusPostService campusPostService;
  @Resource
  private CampusTaskFirstService campusTaskFirstService;

  @Override
  public List<CampusReportExt> getGrid4Site(String yearth, String postId, String organizationId) {
    List<CampusReportExt> list = new ArrayList<>();
    List<CampusSite> siteList =  campusSiteMapper.selectByExample(null);
    for(CampusSite cs : siteList) {
      String siteId = cs.getSiteId();
      CampusReportExt cre = getReportByOrganizationSitePostYearth4Type(organizationId, siteId, postId, yearth, "task");
      cre.setSiteStatus(cs.getStatus());
      list.add(cre);
    }
    return list;
  }

  @Override
  public List<CampusReportExt> getGrid4Post(String yearth, String siteId, String organizationId) {
    List<CampusReportExt> list = new ArrayList<>();
    List<CampusPost> postList = campusPostMapper.selectByExample(null);
    for (CampusPost cp : postList) {
      String postId = cp.getPostId();
      CampusReportExt cre = getReportByOrganizationSitePostYearth4Type(organizationId, siteId, postId, yearth, "firstTask");
      list.add(cre);
    }
    return list;
  }

  public int getOffer(String yearth, String postId, String siteId, String education, String hasOffer, String orgId) {
    CampusStudentCriteria criteria = new CampusStudentCriteria();
    CampusStudentCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(yearth)) {
      criter.andYearthEqualTo(yearth);
    }
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(siteId)) {
      criter.andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(education)) {
      criter.andEducationEqualTo(education);
    }
    if (StringUtils.hasText(hasOffer)) {
      criter.andOfferEqualTo(hasOffer);
    }
    if (StringUtils.hasText(orgId)) {
      criter.andOrgIdEqualTo(orgId);
    }
    List<CampusStudent> list = campusStudentMapper.selectByExample(criteria);
    return list.size();
  }

  public int getTrilateral(String yearth, String postId, String siteId, String education, String hasTrilateral, String orgId) {
    CampusStudentCriteria criteria = new CampusStudentCriteria();
    CampusStudentCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(yearth)) {
      criter.andYearthEqualTo(yearth);
    }
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(siteId)) {
      criter.andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(education)) {
      criter.andEducationEqualTo(education);
    }
    if (StringUtils.hasText(hasTrilateral)) {
      criter.andTrilateralEqualTo(hasTrilateral);
    }
    if (StringUtils.hasText(orgId)) {
      criter.andOrgIdEqualTo(orgId);
    }
    List<CampusStudent> list = campusStudentMapper.selectByExample(criteria);
    return list.size();
  }

  public int getBreakOff(String yearth, String postId, String siteId, String education, String hasBreakOff, String orgId) {
    CampusStudentCriteria criteria = new CampusStudentCriteria();
    CampusStudentCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(yearth)) {
      criter.andYearthEqualTo(yearth);
    }
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(siteId)) {
      criter.andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(education)) {
      criter.andEducationEqualTo(education);
    }
    if (StringUtils.hasText(hasBreakOff)) {
      criter.andBreakOffEqualTo(hasBreakOff);
    }
    if (StringUtils.hasText(orgId)) {
      criter.andOrgIdEqualTo(orgId);
    }
    List<CampusStudent> list = campusStudentMapper.selectByExample(criteria);
    return list.size();
  }
  @Override
  public CampusReportExt getReportByOrganizationSitePostYearth4Type(String organizationId, String siteId, String postId,
                                                               String yearth, String type) {
    CampusReportExt cre = new CampusReportExt();
    String postName = "";
    DatadictGroupType post = datadictGroupTypeService.getByPrimaryKey(postId);
    if (null != post) {
      postName = post.getTypeName();
    }
    String siteName = "";
    if (StringUtils.hasText(siteId)) {
      CampusSite site = campusSiteService.getBySiteIdOrName(siteId, "");
      if (null != site) {
        siteName = site.getSiteName();
      }
    }

    Integer taskBa = 0;
    Integer taskMa = 0;
    Integer taskDo = 0;
    Integer taskSum = 0;
    if ("firstTask".equals(type)) {
      List<CampusTaskFirst> taskFirstList = campusTaskFirstService.getTaskFirstByOrganizationSitePostYearth(organizationId,
              siteId, postId, yearth);
      if (!taskFirstList.isEmpty()) {
        for (CampusTaskFirst ctf : taskFirstList) {
          if (CommonConstant.EDUCATION_BA.equals(ctf.getReserved1())) {
            taskBa = taskBa + ctf.getTaskNumberSum();
          } else if (CommonConstant.EDUCATION_MA.equals(ctf.getReserved1())) {
            taskMa = taskMa + ctf.getTaskNumberSum();
          } else if (CommonConstant.EDUCATION_DO.equals(ctf.getReserved1())) {
            taskDo = taskDo + ctf.getTaskNumberSum();
          }
        }
        taskSum = taskBa + taskMa + taskDo;
      }
    } else {
      List<CampusTask> taskList = campusTaskService.getTaskByOrganizationSitePostYearth(organizationId, siteId, postId,
              yearth);
      if (!taskList.isEmpty()) {
        for (CampusTask ct : taskList) {
          if (CommonConstant.EDUCATION_BA.equals(ct.getReserved1())) {
            taskBa = taskBa + ct.getTaskNumberSum();
          } else if (CommonConstant.EDUCATION_MA.equals(ct.getReserved1())) {
            taskMa = taskMa + ct.getTaskNumberSum();
          } else if (CommonConstant.EDUCATION_DO.equals(ct.getReserved1())) {
            taskDo = taskDo + ct.getTaskNumberSum();
          }
        }
        taskSum = taskBa + taskMa + taskDo;
      }
    }

    Integer offerBa = getOffer(yearth, postId, siteId, CommonConstant.EDUCATION_BA, CommonConstant.YES, organizationId);
    Integer offerMa = getOffer(yearth, postId, siteId, CommonConstant.EDUCATION_MA, CommonConstant.YES, organizationId);
    Integer offerDo = getOffer(yearth, postId, siteId, CommonConstant.EDUCATION_DO, CommonConstant.YES, organizationId);
    Integer offerSum = offerBa + offerMa + offerDo;

    Integer trilateralBa = getTrilateral(yearth, postId, siteId, CommonConstant.EDUCATION_BA, CommonConstant.YES, organizationId);
    Integer trilateralMa = getTrilateral(yearth, postId, siteId, CommonConstant.EDUCATION_MA, CommonConstant.YES, organizationId);
    Integer trilateralDo = getTrilateral(yearth, postId, siteId, CommonConstant.EDUCATION_DO, CommonConstant.YES, organizationId);
    Integer trilateralSum = trilateralBa + trilateralMa + trilateralDo;

    Integer breakOffBa = getBreakOff(yearth, postId, siteId, CommonConstant.EDUCATION_BA, CommonConstant.YES, organizationId);
    Integer breakOffMa = getBreakOff(yearth, postId, siteId, CommonConstant.EDUCATION_MA, CommonConstant.YES, organizationId);
    Integer breakOffDo = getBreakOff(yearth, postId, siteId, CommonConstant.EDUCATION_DO, CommonConstant.YES, organizationId);
    Integer breakOffSum = breakOffBa + breakOffMa + breakOffDo;

    // 拟入职 = 三方  - 违约
    Integer proposedEntryBa = trilateralBa - breakOffBa;
    Integer proposedEntryMa = trilateralMa - breakOffMa;
    Integer proposedEntryDo = trilateralDo - breakOffDo;
    Integer proposedEntrySum = proposedEntryBa + proposedEntryMa + proposedEntryDo;

    // offer率 = offer/任务
    // 检查任务为0，offer率为0
    String achievementBa = "0";
    String achievementMa = "0";
    String achievementDo = "0";
    String achievementSum = "0";
    float achievementPercentSum = 0;

    // 三方率 = 三方/任务
    // 检查任务为0，三方率为0
    String trilTaskBa = "0";
    String trilTaskMa = "0";
    String trilTaskDo = "0";
    String trilTaskSum = "0";

    percentFormat.setMaximumFractionDigits(2);
    if (taskBa != 0) {
      achievementBa = percentFormat.format((float)offerBa/(float)taskBa);
      trilTaskBa = percentFormat.format((float)trilateralBa/(float)taskBa);
    }
    if (taskMa != 0) {
      achievementMa = percentFormat.format((float)offerMa/(float)taskMa);
      trilTaskMa = percentFormat.format((float)trilateralMa/(float)taskMa);
    }
    if (taskDo != 0) {
      achievementDo = percentFormat.format((float)offerDo/(float)taskDo);
      trilTaskDo = percentFormat.format((float)trilateralDo/(float)taskDo);
    }

    if (taskSum != 0) {
      achievementSum = percentFormat.format((float)offerSum/(float)taskSum);
      trilTaskSum = percentFormat.format((float)trilateralSum/(float)taskSum);
      achievementPercentSum = (float)offerSum/(float)taskSum * 100;
      achievementPercentSum = (float)(Math.round(achievementPercentSum*100))/100; // 保留两位小数
    }

    // 签约率 = 三方/offer
    String signatureSum = "0";
    percentFormat.setMaximumFractionDigits(2);
    if (offerSum != 0) {
      signatureSum = percentFormat.format((float)trilateralSum/(float)offerSum);
    }

    cre.setYearth(yearth);
    cre.setPostId(postId);
    cre.setPostName(postName);
    cre.setSiteId(siteId);
    cre.setSiteName(siteName);
    cre.setTaskBa(taskBa);
    cre.setTaskMa(taskMa);
    cre.setTaskDo(taskDo);
    cre.setTaskSum(taskSum);
    cre.setOfferBa(offerBa);
    cre.setOfferMa(offerMa);
    cre.setOfferDo(offerDo);
    cre.setOfferSum(offerSum);
    cre.setTrilateralBa(trilateralBa);
    cre.setTrilateralMa(trilateralMa);
    cre.setTrilateralDo(trilateralDo);
    cre.setTrilateralSum(trilateralSum);
    cre.setBreakOffBa(breakOffBa);
    cre.setBreakOffMa(breakOffMa);
    cre.setBreakOffDo(breakOffDo);
    cre.setBreakOffSum(breakOffSum);
    cre.setProposedEntryBa(proposedEntryBa);
    cre.setProposedEntryMa(proposedEntryMa);
    cre.setProposedEntryDo(proposedEntryDo);
    cre.setProposedEntrySum(proposedEntrySum);
    cre.setAchievementBa(achievementBa);
    cre.setAchievementMa(achievementMa);
    cre.setAchievementDo(achievementDo);
    cre.setAchievementSum(achievementSum);
    cre.setTrilTaskBa(trilTaskBa);
    cre.setTrilTaskMa(trilTaskMa);
    cre.setTrilTaskDo(trilTaskDo);
    cre.setTrilTaskSum(trilTaskSum);
    cre.setAchievementPercentSum(achievementPercentSum);
    cre.setSignatureSum(signatureSum);
    return cre;
  }

  @Override
  public List<CampusJobFamilyAchievement> getJobFamilyAchievementByYearth(String yearth) {
    List<CampusJobFamilyAchievement> list =  new ArrayList<CampusJobFamilyAchievement>();
    Map<String, String> map = datadictGroupTypeService.getTypeId2NameMapByGroupCode("post_family");
    percentFormat.setMaximumFractionDigits(2);
    // 职能类特殊处理
    Integer offerSumFunction = 0;
    Integer taskSumFunction = 0;
    String achievementSumFunction = "0";
    for (Map.Entry<String, String> entry : map.entrySet()) {
      String jobFamilyId = entry.getKey();
      String jobFamilyName = entry.getValue();
      Integer taskSum = 0;
      Integer offerSum = 0;
      String achievementSum = "0";
      List<CampusPost> posts = campusPostService.getPostByJobFamily(jobFamilyId);
      if (!posts.isEmpty()) {
        for (CampusPost post : posts) {
          String postId = post.getPostId();
          CampusReportExt cre = getReportByOrganizationSitePostYearth4Type("", "", postId, yearth, "firstTask");
          taskSum += cre.getTaskSum();
          offerSum += cre.getOfferSum();
        }
      }

      // 专业职能族、技术职能族、战略营销族合并为“职能类”
      if ("045-002".equals(jobFamilyId) || "045-003".equals(jobFamilyId) || "045-004".equals(jobFamilyId)) {
        offerSumFunction += offerSum;
        taskSumFunction += taskSum;
        continue;
      }

      if (taskSum != 0) {
        achievementSum = percentFormat.format((float)offerSum/(float)taskSum);
      }
      CampusJobFamilyAchievement jobFamilyAchievement = new CampusJobFamilyAchievement();
      jobFamilyAchievement.setJobFamily(jobFamilyName);
      jobFamilyAchievement.setAchievement(achievementSum);
      list.add(jobFamilyAchievement);
    }

    // 添加计算合并职能类达成率
    if (taskSumFunction != 0) {
      achievementSumFunction = percentFormat.format((float)offerSumFunction/(float)taskSumFunction);
    }
    CampusJobFamilyAchievement achievementFunction = new CampusJobFamilyAchievement();
    achievementFunction.setJobFamily("职能类");
    achievementFunction.setAchievement(achievementSumFunction);
    list.add(achievementFunction);

    return list;
  }
}
