package com.csot.recruit.common.service.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.JSONUtils;
import net.sf.json.util.JavaIdentifierTransformer;

import org.amberframework.core.excel.poi.ExcelExportManager;
import org.amberframework.core.excel.poi.mapping.ClasspathXmlExcelDataMappingResolver;
import org.amberframework.core.excel.poi.mapping.ExcelDataMappingResolver;
import org.amberframework.core.excel.poi.template.ClasspathExcelTemplateProvider;
import org.amberframework.core.excel.poi.template.ExcelTemplateProvider;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.pojo.LoginClient;
import org.amberframework.web.system.service.BaseUserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csot.recruit.common.enums.PrivacyLevel;
import com.csot.recruit.common.exception.BusinessException;
import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.common.util.BrowserUtils;
import com.csot.recruit.common.util.ContextHolderUtils;
import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.common.util.FileUtils;
import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.common.util.OConvertUtils;
import com.csot.recruit.dao.datadict.DatadictGroupMapper;
import com.csot.recruit.dao.datadict.DatadictGroupTypeMapper;
import com.csot.recruit.dao.log.LogMapper;
import com.csot.recruit.dao.resume.MyResumeRepositoryMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.datadict.DatadictGroupCriteria;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.model.datadict.DatadictGroupTypeCriteria;
import com.csot.recruit.model.log.Log;
import com.csot.recruit.model.nresume.EmailResume;
import com.csot.recruit.model.nresume.Resume;
import com.csot.recruit.model.position.PositionDistributeResult;
import com.csot.recruit.model.position.PositionType;
import com.csot.recruit.model.position.RecruitSite;
import com.csot.recruit.model.position.RecruitSiteItem;
import com.csot.recruit.model.resume.ResumesData;
import com.csot.recruit.common.webservice.outside.accountExtra.ESBGYDGYDInquiryAccountExtraSrv;
import com.csot.recruit.common.webservice.outside.accountExtra.ESBGYDGYDInquiryAccountExtraSrvRequest;
import com.csot.recruit.common.webservice.outside.accountExtra.ESBGYDGYDInquiryAccountExtraSrvResponse;
import com.csot.recruit.common.webservice.outside.accountExtra.ESBGYDGYDInquiryAccountExtraSrvServiceagent;
import com.csot.recruit.common.webservice.outside.cjol_pt.ESBGYDGYDInquiryFunctionsSrv;
import com.csot.recruit.common.webservice.outside.cjol_pt.ESBGYDGYDInquiryFunctionsSrvRequest;
import com.csot.recruit.common.webservice.outside.cjol_pt.ESBGYDGYDInquiryFunctionsSrvResponse;
import com.csot.recruit.common.webservice.outside.cjol_pt.ESBGYDGYDInquiryFunctionsSrvServiceagent;
import com.csot.recruit.common.webservice.outside.cjol_pt_map.ESBGYDGYDInquiryFunctionMappingSrv;
import com.csot.recruit.common.webservice.outside.cjol_pt_map.ESBGYDGYDInquiryFunctionMappingSrvRequest;
import com.csot.recruit.common.webservice.outside.cjol_pt_map.ESBGYDGYDInquiryFunctionMappingSrvResponse;
import com.csot.recruit.common.webservice.outside.cjol_pt_map.ESBGYDGYDInquiryFunctionMappingSrvServiceagent;
import com.csot.recruit.common.webservice.outside.getCaptcha.ESBGYDGYDInquiryCaptchaSrv;
import com.csot.recruit.common.webservice.outside.getCaptcha.ESBGYDGYDInquiryCaptchaSrvRequest;
import com.csot.recruit.common.webservice.outside.getCaptcha.ESBGYDGYDInquiryCaptchaSrvResponse;
import com.csot.recruit.common.webservice.outside.getCaptcha.ESBGYDGYDInquiryCaptchaSrvServiceagent;
import com.csot.recruit.common.webservice.outside.hasCaptcha.ESBGYDGYDInquiryHasCaptchaSrv;
import com.csot.recruit.common.webservice.outside.hasCaptcha.ESBGYDGYDInquiryHasCaptchaSrvRequest;
import com.csot.recruit.common.webservice.outside.hasCaptcha.ESBGYDGYDInquiryHasCaptchaSrvResponse;
import com.csot.recruit.common.webservice.outside.hasCaptcha.ESBGYDGYDInquiryHasCaptchaSrvServiceagent;
import com.csot.recruit.common.webservice.outside.parseContent.ESBGYDGYDInquiryParseContentSrv;
import com.csot.recruit.common.webservice.outside.parseContent.ESBGYDGYDInquiryParseContentSrvRequest;
import com.csot.recruit.common.webservice.outside.parseContent.ESBGYDGYDInquiryParseContentSrvResponse;
import com.csot.recruit.common.webservice.outside.parseContent.ESBGYDGYDInquiryParseContentSrvServiceagent;
import com.csot.recruit.common.webservice.outside.parseDocument.ESBGYDGYDInquiryParseDocumentSrv;
import com.csot.recruit.common.webservice.outside.parseDocument.ESBGYDGYDInquiryParseDocumentSrvRequest;
import com.csot.recruit.common.webservice.outside.parseDocument.ESBGYDGYDInquiryParseDocumentSrvResponse;
import com.csot.recruit.common.webservice.outside.parseDocument.ESBGYDGYDInquiryParseDocumentSrvServiceagent;
import com.csot.recruit.common.webservice.outside.parseMail.ESBGYDGYDInquiryParseMailSrv;
import com.csot.recruit.common.webservice.outside.parseMail.ESBGYDGYDInquiryParseMailSrvRequest;
import com.csot.recruit.common.webservice.outside.parseMail.ESBGYDGYDInquiryParseMailSrvResponse;
import com.csot.recruit.common.webservice.outside.parseMail.ESBGYDGYDInquiryParseMailSrvServiceagent;
import com.csot.recruit.common.webservice.outside.postJobs.ESBGYDGYDInquiryPostJobsSrv;
import com.csot.recruit.common.webservice.outside.postJobs.ESBGYDGYDInquiryPostJobsSrvRequest;
import com.csot.recruit.common.webservice.outside.postJobs.ESBGYDGYDInquiryPostJobsSrvResponse;
import com.csot.recruit.common.webservice.outside.postJobs.ESBGYDGYDInquiryPostJobsSrvServiceagent;
import com.csot.recruit.common.webservice.outside.postingExtra.ESBGYDGYDInquiryPostingExtraSrv;
import com.csot.recruit.common.webservice.outside.postingExtra.ESBGYDGYDInquiryPostingExtraSrvRequest;
import com.csot.recruit.common.webservice.outside.postingExtra.ESBGYDGYDInquiryPostingExtraSrvResponse;
import com.csot.recruit.common.webservice.outside.postingExtra.ESBGYDGYDInquiryPostingExtraSrvServiceagent;
import com.csot.recruit.common.webservice.outside.sms.ESBESBSMSImportSmsSrv;
import com.csot.recruit.common.webservice.outside.sms.ESBESBSMSImportSmsSrvInputCollection;
import com.csot.recruit.common.webservice.outside.sms.ESBESBSMSImportSmsSrvInputItem;
import com.csot.recruit.common.webservice.outside.sms.ESBESBSMSImportSmsSrvRequest;
import com.csot.recruit.common.webservice.outside.sms.ESBESBSMSImportSmsSrvResponse;
import com.csot.recruit.common.webservice.outside.sms.ESBSMSSMSImportSmsSrvServiceagent;
import com.csot.recruit.common.webservice.outside.sms.MobileCollection;
import com.csot.recruit.common.webservice.outside.sms.MobileItem;
import com.csot.recruit.common.webservice.outside.sms.MsgHeader;

@Service("commonService")
@Transactional
public class CommonServiceImpl implements CommonService {


  private DatadictGroupCriteria dgc = new DatadictGroupCriteria();
  
  private DatadictGroupTypeCriteria dgct = new DatadictGroupTypeCriteria();
  
  private static String[] captchSite = null;
  
  private static List<RecruitSite> recruitSites = null;
  
  private static String appKey = null;
  
  private static final Logger logger = LoggerFactory.getLogger(CommonServiceImpl.class);
  
  @Resource 
  LogMapper logMapper;
  
  /*@Resource
  private BaseUserService baseUserService;*/
  
  @Resource
  private DatadictGroupMapper datadictGroupMapper;
  @Resource
  private ExcelExportManager excelExportManager;
  @Resource
  private DatadictGroupTypeMapper datadictGroupTypeMapper;
  
  @Resource
  private MyResumeRepositoryMapper myResumeRepositoryMapper;
  
  /**
   * 添加操作记录
   */
  public void addLog(String logcontent, Integer loglevel, String operatetype, String operand) {
    addLog(logcontent,loglevel,PrivacyLevel.PUBLIC.getValue(),operatetype,operand);
  }
  
  /**
   * 添加评论
   */
  public void addLog(String logcontent, Integer loglevel, Integer privacylevel, String operatetype, String operand) {
    HttpServletRequest request = ContextHolderUtils.getRequest();
    String broswer = BrowserUtils.checkBrowse(request);
    Log log = new Log();
    log.setLogid(UUID.randomUUID().toString().replace("-", ""));
    log.setLogcontent(logcontent);
    log.setLoglevel(loglevel);
    log.setPrivacylevel(privacylevel);
    log.setOperatetype(operatetype);
    log.setNote(OConvertUtils.getIp());
    log.setBroswer(broswer);
    log.setOperatetime(DataUtils.gettimestamp());
    log.setAccount(loginUser().getAccount());
    log.setOperand(operand);
    logMapper.insert(log);
  }
  
  /**
   * 获取登录用户
   * @return
   */
  public BaseUser loginUser() {
    HttpSession session = ContextHolderUtils.getSession();
    LoginClient loginClient = (LoginClient) session.getAttribute(LoginClient.CLIENT_SESSION_ATTR);
    return loginClient.getUser();
  }

  /**
   * 根据类型编码和类型名称获取Type,如果为空则创建一个
   * 
   * @param typecode
   * @param typename
   * @return
   */
  public DatadictGroupType getType(String typecode, String typename, DatadictGroup tsTypegroup) {
    dgct.clear();
    dgct.createCriteria().andTypeCodeEqualTo(typecode).andTypeNameEqualTo(typename);
    DatadictGroupType actType = datadictGroupTypeMapper.selectByExample(dgct).get(0);
    if (actType == null) {
      actType = new DatadictGroupType();
      actType.setTypeCode(typecode);
      actType.setTypeName(typename);
      actType.setGroupId(tsTypegroup.getGroupId());
      datadictGroupTypeMapper.insert(actType);
    }
    return actType;
  }

  /**
   * 根据类型分组编码和名称获取TypeGroup,如果为空则创建一个
   * 
   * @param typecode
   * @param typename
   * @return
   */
  public DatadictGroup getTypeGroup(String groupCode, String groupeName) {
    dgc.clear();
    dgc.createCriteria().andGroupCodeEqualTo(groupCode).andGroupNameEqualTo(groupeName);
    DatadictGroup tsTypegroup = datadictGroupMapper.selectByExample(dgc).get(0);
    if (tsTypegroup == null) {
      tsTypegroup = new DatadictGroup();
      tsTypegroup.setGroupCode(groupCode);
      tsTypegroup.setGroupName(groupeName);
      datadictGroupMapper.insert(tsTypegroup);
    }
    return tsTypegroup;
  }

  /**
   * 
   * @param groupCode
   * @return
   */
  public DatadictGroup getTypeGroupByCode(String groupCode) {
    dgc.clear();
    dgc.createCriteria().andGroupCodeEqualTo(groupCode);
    DatadictGroup tsTypegroup = datadictGroupMapper.selectByExample(dgc).get(0);
    return tsTypegroup;
  }

  /**
   * 加载数据字典
   */
  @Override
  public void initAllDatadict() {
    List<DatadictGroup> typeGroups =
        datadictGroupMapper.selectByExample(new DatadictGroupCriteria());
    for (DatadictGroup tsTypegroup : typeGroups) {
      DatadictGroup.allTypeGroups.put(tsTypegroup.getGroupCode().toLowerCase(), tsTypegroup);
      dgct.clear();
      dgct.createCriteria().andGroupIdEqualTo(tsTypegroup.getGroupId());
      dgct.setOrderByClause("type_code");
      List<DatadictGroupType> types = datadictGroupTypeMapper.selectByExample(dgct);
      DatadictGroup.allTypes.put(tsTypegroup.getGroupCode().toLowerCase(), types);
    }
    PropertiesUtil propertiesUtil = new PropertiesUtil();
    appKey = propertiesUtil.readProperty("appKey");
  }

  /**
   * 
   * @param type
   */
  public void refleshTypesCach(DatadictGroupType type) {
    dgc.clear();
    dgc.createCriteria().andGroupIdEqualTo(type.getGroupId());
    DatadictGroup tsTypegroup = datadictGroupMapper.selectByExample(dgc).get(0);
    dgct.clear();
    dgct.createCriteria().andGroupIdEqualTo(tsTypegroup.getGroupId());
    List<DatadictGroupType> types = datadictGroupTypeMapper.selectByExample(dgct);;
    DatadictGroup.allTypes.put(tsTypegroup.getGroupCode().toLowerCase(), types);
  }

  /**
   * 
   */
  public void refleshTypeGroupCach() {
    DatadictGroup.allTypeGroups.clear();
    List<DatadictGroup> typeGroups = datadictGroupMapper.selectByExample(new DatadictGroupCriteria());
    for (DatadictGroup tsTypegroup : typeGroups) {
      DatadictGroup.allTypeGroups.put(tsTypegroup.getGroupCode().toLowerCase(), tsTypegroup);
    }
  }
  
  // 51job.com zhaopin.com ChinaHR.com cjol.com liepin.com 
 /* public static void main(String[] args) throws Exception {
    PropertiesUtil propertiesUtil = new PropertiesUtil();
    CommonServiceImpl c = new CommonServiceImpl();
    appKey = propertiesUtil.readProperty("appKey");
    c.getCaptchaSite().toString();
    //System.out.println(c.getCaptcha(null,"zhaopin.com"));
    System.out.println(c.getSiteLoginExtField("51job.com"));
    System.out.println(c.postJobSiteExtInfo("ganji.com"));
    System.out.println(c.getAllPositionType("51job.com"));
    System.out.println(c.getPositionType("51job.com", "4"));
    System.out.println(c.psotJob(null,"51job"));
    System.out.println(c.parseResumeByMail(null));
    System.out.println(c.parseResumeByDocument(null));
    System.out.println(c.parseResumeByContent(null));
    c.sendSms("15926148549;18565637774", "kkk");
  }*/
  
  @Override
  public List<RecruitSite> getSiteInfo(HttpServletRequest request) {
    if(null == recruitSites || 0 == recruitSites.size()) {
      this.querySiteInfo(request);
    }
    else { // 更新验证码
      for(String siteUrl : captchSite) {
        try {
          String captchaName = getCaptcha(request,siteUrl);
          for(RecruitSite rs : recruitSites) {
            if(rs.getUrl().equals(siteUrl)) {
              rs.setCaptchaName(captchaName);
            }
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return recruitSites;
  }
  
  /**
   * 查询所有站点信息
   * @param request
   * @return
   */
  public List<RecruitSite> querySiteInfo(HttpServletRequest request) {
    PropertiesUtil propertiesUtil = new PropertiesUtil();
    recruitSites = new ArrayList<RecruitSite>();
    appKey = propertiesUtil.readProperty("appKey");
    if(null == captchSite) {
      captchSite = getCaptchaSite();
    }
    String sites = propertiesUtil.readProperty("recruitSite");
    String[] siteArray = new String[]{};
    if(StringUtil.isNotEmpty(sites)) {
      siteArray = sites.split(",");
    }
    RecruitSiteItem rsi1 = new RecruitSiteItem("用户名","LoginName","text",true,1);
    RecruitSiteItem rsi2 = new RecruitSiteItem("密码","LoginPassword","password",true,1);
    RecruitSiteItem rsi3 = new RecruitSiteItem("是否保存账号","SaveAccount","checkbox",false,0);
    String siteUrl = null;
    String captchaName;
    for(String siteStr : siteArray) {
      siteUrl = siteStr + ".com";
      RecruitSite rs = new RecruitSite();
      List<RecruitSiteItem> rsil = new ArrayList<RecruitSiteItem>();
      List<RecruitSiteItem> rsil1 = getSiteLoginExtField(siteUrl);
      List<RecruitSiteItem> rsil2 = postJobSiteExtInfo(siteUrl);
      if("51job".equals(siteStr)) {
        rsi1 = new RecruitSiteItem("会员名","LoginName","text",true,1);
      }
      rsil.add(rsi1);     // 用户名字段
      rsil.addAll(rsil1); // 登录所需的额外字段
      rsil.add(rsi2);     // 密码字段
      rsil.addAll(rsil2); // 分发职位所需的额外字段
      rs.setUrl(siteUrl);
      rs.setSiteName(siteStr);
      rs.setTips(propertiesUtil.readProperty(siteStr+"DistributeTips"));
      captchaName = null;
      int index = Arrays.binarySearch(captchSite, siteUrl); 
      if(index > -1) {   // 有验证码
        try {
          captchaName = getCaptcha(request,siteUrl);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      rsil.add(rsi3);     // 是否保存账号字段
      rs.setRsItem(rsil);
      rs.setCaptchaName(captchaName);
      recruitSites.add(rs);
    }
    return recruitSites;
  }
  
  @Override
  public String[] getCaptchaSite() {
    ESBGYDGYDInquiryHasCaptchaSrvServiceagent ss = new ESBGYDGYDInquiryHasCaptchaSrvServiceagent();
    ESBGYDGYDInquiryHasCaptchaSrv port = ss.getESBGYDGYDInquiryHasCaptchaSrv();  
    ESBGYDGYDInquiryHasCaptchaSrvRequest _process_payload = new ESBGYDGYDInquiryHasCaptchaSrvRequest();
    _process_payload.setMsgHeader(new com.csot.recruit.common.webservice.outside.hasCaptcha.MsgHeader());
    _process_payload.setPARAMATERS("hasCaptcha=true&appkey=" + appKey);
    _process_payload.setRESULTTYPE("application/json");
    ESBGYDGYDInquiryHasCaptchaSrvResponse _process__return = port.process(_process_payload);
    String[] rs = new String[]{};
    if(_process__return.getSERVICEFLAG().equals("TRUE")) {
      if(_process__return.getESBGYDGYDInquiryHasCaptchaSrvOutputCollection().getESBGYDGYDInquiryHasCaptchaSrvOutputItem().size() > 0) {
        String returnStr = _process__return.getESBGYDGYDInquiryHasCaptchaSrvOutputCollection().getESBGYDGYDInquiryHasCaptchaSrvOutputItem().get(0).getASCIICONTENT();
        JSONArray jsonArray = JSONArray.fromObject(returnStr);   
        rs = (String[])jsonArray.toArray(new String[jsonArray.size()]);
        System.out.println(returnStr);
      }
    }
    else {
      logger.error(_process__return.getSERVICEMESSAGE());
    }
    return rs;
  }
  
  @Override
  public String getCaptcha(HttpServletRequest request, String site) throws BusinessException {
    int index = Arrays.binarySearch(captchSite, site); 
    if(index < 0) { // 判断该站点是否需要验证码
      throw new BusinessException("该站点不需要验证码");
    }
    ESBGYDGYDInquiryCaptchaSrvServiceagent ss = new ESBGYDGYDInquiryCaptchaSrvServiceagent();
    ESBGYDGYDInquiryCaptchaSrv port = ss.getESBGYDGYDInquiryCaptchaSrv();  
    ESBGYDGYDInquiryCaptchaSrvRequest _process_payload = new ESBGYDGYDInquiryCaptchaSrvRequest();
    String imgName = null;
    _process_payload.setMsgHeader(new com.csot.recruit.common.webservice.outside.getCaptcha.MsgHeader());
    _process_payload.setPARAMATERS("appkey=" + appKey);
    _process_payload.setSITE(site);
    _process_payload.setRESULTTYPE("application/x-jpg");
    ESBGYDGYDInquiryCaptchaSrvResponse _process__return = port.process(_process_payload);
    if(_process__return.getSERVICEFLAG().equals("TRUE")) { 
      if(_process__return.getESBGYDGYDInquiryCaptchaSrvOutputCollection().getESBGYDGYDInquiryCaptchaSrvOutputItem().size() > 0) {
        String returnStr = _process__return.getESBGYDGYDInquiryCaptchaSrvOutputCollection().getESBGYDGYDInquiryCaptchaSrvOutputItem().get(0).getASCIICONTENT();
        String imgPath = "";
        if(site !=null && !"".equals(site)) {
          imgPath = request.getSession().getServletContext().getRealPath("/") + File.separator + "resources" + File.separator + "captcha" + File.separator + site.substring(0,site.indexOf(".com"));
        }
        imgName = returnStr.substring(returnStr.indexOf("filename=") + "filename=".length());
        if(null != request) {
          File file = new File(imgPath);
          if(!file.isDirectory()) {
            file.mkdirs(); // 创建存放验证码图片的文件夹
          }
        }
        // 将二进制，还原成图片并存储                  
        byte[] imgByte = _process__return.getESBGYDGYDInquiryCaptchaSrvOutputCollection().getESBGYDGYDInquiryCaptchaSrvOutputItem().get(0).getBINARYCONTENT(); 
        File file=new File(imgPath,imgName);//可以是任何图片格式.jpg,.png等              
        FileOutputStream fos = null;                                   
        InputStream fis = null;  
        byte[] b = new byte[1024];                 
        int nRead = 0;                 
        try { 
          fos=new FileOutputStream(file); 
          fis = new ByteArrayInputStream(imgByte);
          while ((nRead = fis.read(b)) != -1) {                     
            fos.write(b, 0, nRead);                 
          }                 
        } catch (Exception e) {                 
          throw new BusinessException(e.getMessage());
        } finally{
          try {
            if(null != fos) {
              fos.flush();                 
              fos.close();                 
            }
            if(null != fis) {
              fis.close();
            }
          } catch (IOException e) {
            throw new BusinessException(e.getMessage());
          }
        } 
      }
    }
    else {
      logger.error(_process__return.getSERVICEMESSAGE());
    }
    return imgName;
  }

  @Override
  public List<RecruitSiteItem> getSiteLoginExtField(String site) {
    ESBGYDGYDInquiryAccountExtraSrvServiceagent ss = new ESBGYDGYDInquiryAccountExtraSrvServiceagent();
    ESBGYDGYDInquiryAccountExtraSrv port = ss.getESBGYDGYDInquiryAccountExtraSrv();  
    ESBGYDGYDInquiryAccountExtraSrvRequest _process_payload = new ESBGYDGYDInquiryAccountExtraSrvRequest();
    _process_payload.setMsgHeader(new com.csot.recruit.common.webservice.outside.accountExtra.MsgHeader());
    _process_payload.setPARAMATERS("appkey=" + appKey);
    _process_payload.setSITE(site);
    _process_payload.setRESULTTYPE("application/json");
    ESBGYDGYDInquiryAccountExtraSrvResponse _process__return = port.process(_process_payload);
    List<RecruitSiteItem> rs = new ArrayList<RecruitSiteItem>();
    if(_process__return.getSERVICEFLAG().equals("TRUE")) { 
      if(_process__return.getESBGYDGYDInquiryAccountExtraSrvOutputCollection().getESBGYDGYDInquiryAccountExtraSrvOutputItem().size() > 0) {
        String returnStr = _process__return.getESBGYDGYDInquiryAccountExtraSrvOutputCollection().getESBGYDGYDInquiryAccountExtraSrvOutputItem().get(0).getASCIICONTENT();
        JSONArray jsonArray = JSONArray.fromObject(returnStr);   
        for(int i = 0; i < jsonArray.size(); i++) {
          JSONObject jso = jsonArray.getJSONObject(i);
          RecruitSiteItem rsi = (RecruitSiteItem)JSONObject.toBean(jso,jsonConfig(RecruitSiteItem.class));
          rsi.setType(2);
          rs.add(rsi);
        }
      }
    }
    else {
      logger.error(_process__return.getSERVICEMESSAGE());
    }
    return rs;
  }
  
  @Override
  public List<RecruitSiteItem> postJobSiteExtInfo(String site) {
    ESBGYDGYDInquiryPostingExtraSrvServiceagent ss = new ESBGYDGYDInquiryPostingExtraSrvServiceagent();
    ESBGYDGYDInquiryPostingExtraSrv port = ss.getESBGYDGYDInquiryPostingExtraSrv();  
    ESBGYDGYDInquiryPostingExtraSrvRequest _process_payload = new ESBGYDGYDInquiryPostingExtraSrvRequest();
    _process_payload.setMsgHeader(new com.csot.recruit.common.webservice.outside.postingExtra.MsgHeader());
    _process_payload.setPARAMATERS("appkey=" + appKey);
    _process_payload.setSITE(site);
    _process_payload.setRESULTTYPE("application/json");
    ESBGYDGYDInquiryPostingExtraSrvResponse _process__return = port.process(_process_payload);
    List<RecruitSiteItem> rs = new ArrayList<RecruitSiteItem>();
    if(_process__return.getSERVICEFLAG().equals("TRUE")) { 
      if(_process__return.getESBGYDGYDInquiryPostingExtraSrvOutputCollection().getESBGYDGYDInquiryPostingExtraSrvOutputItem().size() > 0) {
        String returnStr = _process__return.getESBGYDGYDInquiryPostingExtraSrvOutputCollection().getESBGYDGYDInquiryPostingExtraSrvOutputItem().get(0).getASCIICONTENT();
        JSONArray jsonArray = JSONArray.fromObject(returnStr);  
        for(int i = 0; i < jsonArray.size(); i++) {
          JSONObject jso = jsonArray.getJSONObject(i);
          RecruitSiteItem rsi = (RecruitSiteItem)JSONObject.toBean(jso,jsonConfig(RecruitSiteItem.class));
          rsi.setType(3);
          rs.add(rsi);
        }
      }
    }
    else {
      logger.error(_process__return.getSERVICEMESSAGE());
    }
    return rs;
  }
  
  @Override
  public PositionType getPositionType(String site, String positionTypeId) {
    ESBGYDGYDInquiryFunctionMappingSrvServiceagent ss = new ESBGYDGYDInquiryFunctionMappingSrvServiceagent();
    ESBGYDGYDInquiryFunctionMappingSrv port = ss.getESBGYDGYDInquiryFunctionMappingSrv();  
    ESBGYDGYDInquiryFunctionMappingSrvRequest _process_payload = new ESBGYDGYDInquiryFunctionMappingSrvRequest();
    _process_payload.setMsgHeader(new com.csot.recruit.common.webservice.outside.cjol_pt_map.MsgHeader());
    _process_payload.setPARAMATERS("appkey=" + appKey);
    _process_payload.setSITE(site);
    _process_payload.setFUNCTIONID(positionTypeId);
    _process_payload.setRESULTTYPE("application/json");
    ESBGYDGYDInquiryFunctionMappingSrvResponse _process__return = port.process(_process_payload);
    PositionType pt = new PositionType();
    if(_process__return.getSERVICEFLAG().equals("TRUE")) { 
      if(_process__return.getESBGYDGYDInquiryFunctionMappingSrvOutputCollection().getESBGYDGYDInquiryFunctionMappingSrvOutputItem().size() > 0) {
        String returnStr = _process__return.getESBGYDGYDInquiryFunctionMappingSrvOutputCollection().getESBGYDGYDInquiryFunctionMappingSrvOutputItem().get(0).getASCIICONTENT();
        JSONObject jso = JSONObject.fromObject(returnStr);
        pt = (PositionType)JSONObject.toBean(jso,jsonConfig(PositionType.class));
      }
    }
    else {
      logger.error(_process__return.getSERVICEMESSAGE());
    }
    return pt;
  }

  @Override
  public List<PositionType> getAllPositionType(String site) {
    ESBGYDGYDInquiryFunctionsSrvServiceagent ss = new ESBGYDGYDInquiryFunctionsSrvServiceagent();
    ESBGYDGYDInquiryFunctionsSrv port = ss.getESBGYDGYDInquiryFunctionsSrv();  
    ESBGYDGYDInquiryFunctionsSrvRequest _process_payload = new ESBGYDGYDInquiryFunctionsSrvRequest();
    _process_payload.setMsgHeader(new com.csot.recruit.common.webservice.outside.cjol_pt.MsgHeader());
    _process_payload.setPARAMATERS("appkey=" + appKey);
    _process_payload.setSITE(site);
    _process_payload.setRESULTTYPE("application/json");
    List<PositionType> rs = new ArrayList<PositionType>();
    ESBGYDGYDInquiryFunctionsSrvResponse _process__return = port.process(_process_payload);
    if(_process__return.getSERVICEFLAG().equals("TRUE")) {
      if(_process__return.getESBGYDGYDInquiryFunctionsSrvOutputCollection().getESBGYDGYDInquiryFunctionsSrvOutputItem().size() > 0) {
        String returnStr = _process__return.getESBGYDGYDInquiryFunctionsSrvOutputCollection().getESBGYDGYDInquiryFunctionsSrvOutputItem().get(0).getASCIICONTENT();
        JSONArray jsonArray = JSONArray.fromObject(returnStr);  
        for(int i = 0; i < jsonArray.size(); i++) {
          JSONObject jso = jsonArray.getJSONObject(i);
          PositionType pt = (PositionType)JSONObject.toBean(jso,jsonConfig(PositionType.class));
          rs.add(pt);
        }
      }
    }
    else {
      logger.error(_process__return.getSERVICEMESSAGE());
    }
    return rs;
  };

  @Override
  public String psotJob(String postData, String site) {
    logger.info(postData);
    ESBGYDGYDInquiryPostJobsSrvServiceagent ss = new ESBGYDGYDInquiryPostJobsSrvServiceagent();
    ESBGYDGYDInquiryPostJobsSrv port = ss.getESBGYDGYDInquiryPostJobsSrv();  
    ESBGYDGYDInquiryPostJobsSrvRequest _process_payload = new ESBGYDGYDInquiryPostJobsSrvRequest();
    _process_payload.setMsgHeader(new com.csot.recruit.common.webservice.outside.postJobs.MsgHeader());
    _process_payload.setPARAMATERS("appkey=" + appKey);
    _process_payload.setPOSTDATA(postData);
    _process_payload.setRESULTTYPE("application/json");
    ESBGYDGYDInquiryPostJobsSrvResponse _process__return = port.process(_process_payload);
    if(_process__return.getSERVICEFLAG().equals("TRUE")) { 
      if(_process__return.getESBGYDGYDInquiryPostJobsSrvOutputCollection().getESBGYDGYDInquiryPostJobsSrvOutputItem().size() > 0) {
        String returnStr = _process__return.getESBGYDGYDInquiryPostJobsSrvOutputCollection().getESBGYDGYDInquiryPostJobsSrvOutputItem().get(0).getASCIICONTENT();
        JSONObject jso = JSONObject.fromObject(returnStr);
        PositionDistributeResult pr = (PositionDistributeResult)JSONObject.toBean(jso,jsonConfig(PositionDistributeResult.class));
        if(pr.getResult().equals("false")) {
          return pr.getFailedReason();
        }
      }
      logger.info("分发职位成功：" + postData);
      return "true";
    }
    else {
      logger.error(_process__return.getSERVICEMESSAGE());
      return _process__return.getSERVICEMESSAGE();
    } 
  }

  @Override
  public EmailResume parseResumeByMail(String data) {
    ESBGYDGYDInquiryParseMailSrvServiceagent ss = new ESBGYDGYDInquiryParseMailSrvServiceagent();
    ESBGYDGYDInquiryParseMailSrv port = ss.getESBGYDGYDInquiryParseMailSrv();  
    ESBGYDGYDInquiryParseMailSrvRequest _process_payload = new ESBGYDGYDInquiryParseMailSrvRequest();
    EmailResume resume = null;
    String[] dateFormats = new String[] {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-ddTHH:mm:ss"}; 
    _process_payload.setMsgHeader(new com.csot.recruit.common.webservice.outside.parseMail.MsgHeader());
    _process_payload.setPARAMATERS("appkey=" + appKey);
    _process_payload.setPOSTDATA(data);
    _process_payload.setRESULTTYPE("application/json");
    System.out.println(data);
    ESBGYDGYDInquiryParseMailSrvResponse _process__return = port.process(_process_payload);
    if(_process__return.getSERVICEFLAG().equals("TRUE")) { 
      if(_process__return.getESBGYDGYDInquiryParseMailSrvOutputCollection().getESBGYDGYDInquiryParseMailSrvOutputItem().size() > 0) {
        String returnStr = _process__return.getESBGYDGYDInquiryParseMailSrvOutputCollection().getESBGYDGYDInquiryParseMailSrvOutputItem().get(0).getASCIICONTENT();
        logger.info(returnStr);
        JSONObject jso = JSONObject.fromObject(returnStr);
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        resume = (EmailResume)JSONObject.toBean(jso,jsonConfig(EmailResume.class));
      }
    }
    else {
      logger.error(_process__return.getSERVICEMESSAGE());
    }
    return resume;
  }

  @Override
  public Resume parseResumeByContent(String resumeContent) {
    ESBGYDGYDInquiryParseContentSrvServiceagent ss = new ESBGYDGYDInquiryParseContentSrvServiceagent();
    ESBGYDGYDInquiryParseContentSrv port = ss.getESBGYDGYDInquiryParseContentSrv();  
    ESBGYDGYDInquiryParseContentSrvRequest _process_payload = new ESBGYDGYDInquiryParseContentSrvRequest();
    Resume resume = null;
    String[] dateFormats = new String[] {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-ddTHH:mm:ss"}; 
    _process_payload.setMsgHeader(new com.csot.recruit.common.webservice.outside.parseContent.MsgHeader());
    _process_payload.setPARAMATERS("appkey=" + appKey);
    _process_payload.setPOSTDATA("{'content':'" + resumeContent + "'}");
    _process_payload.setRESULTTYPE("application/json");
    ESBGYDGYDInquiryParseContentSrvResponse _process__return = port.process(_process_payload);
    if(_process__return.getSERVICEFLAG().equals("TRUE")) { 
      if(_process__return.getESBGYDGYDInquiryParseContentSrvOutputCollection().getESBGYDGYDInquiryParseContentSrvOutputItem().size() > 0) {
        String returnStr = _process__return.getESBGYDGYDInquiryParseContentSrvOutputCollection().getESBGYDGYDInquiryParseContentSrvOutputItem().get(0).getASCIICONTENT();
        JSONObject jso = JSONObject.fromObject(returnStr);
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats)); 
        resume = (Resume)JSONObject.toBean(jso,jsonConfig(Resume.class));
      }
    }
    else {
      logger.error(_process__return.getSERVICEMESSAGE());
    }
    return resume;
  }

  @Override
  public Resume parseResumeByDocument(File file) {
    ESBGYDGYDInquiryParseDocumentSrvServiceagent ss = new ESBGYDGYDInquiryParseDocumentSrvServiceagent();
    ESBGYDGYDInquiryParseDocumentSrv port = ss.getESBGYDGYDInquiryParseDocumentSrv();  
    ESBGYDGYDInquiryParseDocumentSrvRequest _process_payload = new ESBGYDGYDInquiryParseDocumentSrvRequest();
    //byte [] data = null;
    String strData = null;
    Resume resume = null;
    String[] dateFormats = new String[] {"yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-ddTHH:mm:ss"}; 
    try {
      //data = FileUtils.toByteArray(file);
      strData = FileUtils.toBase64String(file);
    } catch (IOException e) {
      logger.info(e.getMessage());
    }
    com.csot.recruit.common.webservice.outside.parseDocument.MsgHeader head = new com.csot.recruit.common.webservice.outside.parseDocument.MsgHeader();
    head.setAPPID("recruit");
    head.setAPPNAME("recruit");
    _process_payload.setMsgHeader(head);
    _process_payload.setPARAMATERS("appkey=" + appKey);
    _process_payload.setPOSTDATA("{'Name':'" + file.getName() + "','Data':'" + strData + "','Encoding':'UTF-8'}");
    _process_payload.setRESULTTYPE("application/json");
    System.out.println(_process_payload.getPOSTDATA());
    ESBGYDGYDInquiryParseDocumentSrvResponse _process__return = port.process(_process_payload);
    if(_process__return.getSERVICEFLAG().equals("TRUE")) { 
      if(_process__return.getESBGYDGYDInquiryParseDocumentSrvOutputCollection().getESBGYDGYDInquiryParseDocumentSrvOutputItem().size() > 0) {
        String returnStr = _process__return.getESBGYDGYDInquiryParseDocumentSrvOutputCollection().getESBGYDGYDInquiryParseDocumentSrvOutputItem().get(0).getASCIICONTENT();
        JSONObject jso = JSONObject.fromObject(returnStr);
        JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
        resume = (Resume)JSONObject.toBean(jso,jsonConfig(Resume.class));
      }
    }
    else {
      logger.error(_process__return.getSERVICEMESSAGE());
    }
    return resume;
  }
  

  @SuppressWarnings("rawtypes")
  private JsonConfig jsonConfig(Class c ) {
    JsonConfig config = new JsonConfig();
    config.setJavaIdentifierTransformer(new JavaIdentifierTransformer(){

      @Override
      public String transformToJavaIdentifier(String str) {
        char[] chars = str.toCharArray();
        chars[0] = Character.toLowerCase(chars[0]);
        return new String(chars);
      }
    });
    config.setRootClass(c);
    return config;
  }

  @Override
  public void createPositionId() {
      List<ResumesData> list = myResumeRepositoryMapper.queryResumesData();
      for(int i = 0; i < list.size(); i++){
          int count = myResumeRepositoryMapper.querySearchPositionById(list.get(i).getId());
          if(count <= 0){
              myResumeRepositoryMapper.insertPositionSearch(list.get(i).getId());
          }
      }
  }

@Override
public boolean sendSms(String mobiles, String smsContent) {
	 ESBSMSSMSImportSmsSrvServiceagent ss = new ESBSMSSMSImportSmsSrvServiceagent();
     ESBESBSMSImportSmsSrv port = ss.getESBSMSSMSImportSmsSrv();  
     {
     logger.info("Invoking process...");
     ESBESBSMSImportSmsSrvRequest _process_payload = new ESBESBSMSImportSmsSrvRequest();
     ESBESBSMSImportSmsSrvInputCollection ic = new ESBESBSMSImportSmsSrvInputCollection();
     ArrayList<ESBESBSMSImportSmsSrvInputItem> listi = new ArrayList<ESBESBSMSImportSmsSrvInputItem>();
     ESBESBSMSImportSmsSrvInputItem ii = new ESBESBSMSImportSmsSrvInputItem();
     MobileCollection mc = new MobileCollection();
     ArrayList<MobileItem> list = new ArrayList<MobileItem>();
     String [] mobile = mobiles.split(";");
     for (int i = 0; i < mobile.length; i++) {
    	 MobileItem mi = new MobileItem();
         mi.mobile = mobile[i];
         list.add(mi);
	 }
     mc.mobileItem = list;
     ii.mobileCollection = mc;
     ii.setSmsContent("【华星光电】"+smsContent);
     ii.setSmsPriority(new BigDecimal(5));
     ii.setSrcCharset("utf-8");
     ii.setSmsID(new BigDecimal(12));
     listi.add(ii);
     ic.esbesbsmsImportSmsSrvInputItem = listi;
     _process_payload.setESBESBSMSImportSmsSrvInputCollection(ic);
     _process_payload.setMsgHeader(new MsgHeader());
     ESBESBSMSImportSmsSrvResponse _process__return = port.process(_process_payload);
     String flag = _process__return.serviceflag;
     if(!flag.toLowerCase().equals("true")){
    	 logger.info("flag:"+flag);
    	 return false;
     }
     logger.info("process.result=" + _process__return);
     }
	return true;
}

@Override
public void queryAllUserForQuikSearch() {
  //List<BaseUser> recruiters = baseUserService.queryAllUser();
}

@Override
public void exportByTemplate(HttpServletResponse response, String exportFileName,
    Collection<?> dataset, String xmlPath, String templatePath) {
  ExcelTemplateProvider classpathExcelTemplateProvider =
      ClasspathExcelTemplateProvider.newInstance(templatePath, 0);
  ExcelDataMappingResolver classpathXmlExcelDataMappingResolver =
      ClasspathXmlExcelDataMappingResolver.newInstance(xmlPath);
  Workbook wb =
      excelExportManager.exportExcel(dataset, null, classpathExcelTemplateProvider,
          classpathXmlExcelDataMappingResolver);
  response.setContentType("application/vnd.ms-excel");
  OutputStream ops = null;
  try {
    response.setHeader("content-disposition", "attachment;filename=" + exportFileName);
    ops = response.getOutputStream();
    wb.write(ops);
  } catch (IOException e) {
    logger.error(e.getMessage(), e);
  } finally {
    try {
      ops.close();
      wb.close();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }
}

}
