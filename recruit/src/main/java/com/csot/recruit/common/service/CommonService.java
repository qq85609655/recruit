package com.csot.recruit.common.service;

import java.io.File;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.web.system.model.BaseUser;

import com.csot.recruit.common.exception.BusinessException;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.model.nresume.EmailResume;
import com.csot.recruit.model.nresume.Resume;
import com.csot.recruit.model.position.PositionType;
import com.csot.recruit.model.position.RecruitSite;
import com.csot.recruit.model.position.RecruitSiteItem;

public interface CommonService {

  /**
   * 添加评论
   * @param LogContent 内容
   * @param loglevel 级别
   * @param operatetype 类型
   */
  public void addLog(String LogContent, Integer loglevel, Integer privacylevel, String operatetype, String operand);
  
  /**
   * 添加操作记录
   * @param LogContent
   * @param loglevel
   * @param operatetype
   * @param operand
   */
  public void addLog(String LogContent, Integer loglevel, String operatetype, String operand);
  
  /**
   * 根据类型编码和类型名称获取Type,如果为空则创建一个
   * @param typecode
   * @param typename
   * @return
   */
  public DatadictGroupType getType(String typecode,String typename,DatadictGroup tsTypegroup);
  /**
   * 根据类型分组编码和名称获取TypeGroup,如果为空则创建一个
   * @param typecode
   * @param typename
   * @return
   */
  public DatadictGroup getTypeGroup(String typegroupcode,String typgroupename);
  
  /**
   * 刷新数据字典数据
   */
  public void initAllDatadict();
  
  /**
   * 获取当前登录用户
   * @return
   */
  public BaseUser loginUser();
  
  /**
   * 获取站点职位分发所需字段信息
   * @param sites 站点
   * @return
   */
  public List<RecruitSite> getSiteInfo(HttpServletRequest request);
  
  /**
   * 获取有验证码的站点
   * @return
   */
  public String[] getCaptchaSite();
  
  /**
   * 获取指定站点的验证码
   * @param site
   * @return
   */
  public String getCaptcha(HttpServletRequest request, String site) throws BusinessException;
  
  /**
   * 获取指定站点额外的登录信息
   * @param site
   * @return
   */
  public List<RecruitSiteItem> getSiteLoginExtField(String site);
  
  /**
   * 获取指定站点发布职位所需额外的信息
   * @param site  
   * @return
   */
  public List<RecruitSiteItem> postJobSiteExtInfo(String site);
  
  /**
   * 获取指定站点的职位类别
   * @param site 站点
   * @param positionTypeId 系统内部的职位类别
   * @return 职位类别
   */
  public PositionType getPositionType(String site, String positionTypeId);
  
  /**
   * 获取指定站点的所有职位类别
   * @param site 站点
   * @return 所有职位类别的集合
   */
  public List<PositionType> getAllPositionType(String site);
  
  /**
   * 向指定站点分发职位
   * @param postData 发送的数据
   * @param site 分发的站点
   * @return 分发 状态
   */
  public String psotJob(String postData, String site);
  
  /**
   * 解析邮箱中的简历    文档格式是html
   * @param o
   * @return
   */
  public EmailResume parseResumeByMail(String data);
  
  /**
   * 简历解析  文件
   * @param o
   * @return
   */
  public Resume parseResumeByDocument(File file);
  
  /**
   * 简历解析 内容
   * @param resumeContent 简历内容
   * @return
   */
  public Resume parseResumeByContent(String resumeContent);
  
  /***
   * 人才库索引id创建
   */
  public void createPositionId();
  
  /***
   * 发送短信
   * @param mobiles 手机号码
   * @param smsContent 短信内容
   * @return
   */
  public boolean sendSms(String mobiles, String smsContent);

  /**
   * 查询所有用户 保存到文本中用于快速查询
   */
  public void queryAllUserForQuikSearch();
  /**
   * 导出excel
   * @param response
   * @param exportFileName
   * @param dataset
   * @param xmlPath
   * @param templatePath
   */
  public void exportByTemplate(HttpServletResponse response, String exportFileName,
      Collection<?> dataset, String xmlPath, String templatePath);
}