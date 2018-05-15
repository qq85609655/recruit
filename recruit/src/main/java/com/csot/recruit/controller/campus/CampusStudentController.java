package com.csot.recruit.controller.campus;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csot.recruit.common.util.CommonConstant;
import jodd.servlet.URLDecoder;
import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.common.util.CampusUtils;
import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.common.util.SearchCondition;
import com.csot.recruit.dao.original.campus.CampusStudentMapper;
import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.campus.CampusStudent;
import com.csot.recruit.model.original.campus.CampusStudentCriteria;
import com.csot.recruit.model.template.Template;
import com.csot.recruit.service.attachment.AttachmentService;
import com.csot.recruit.service.campus.CampusStudentService;
import com.csot.recruit.service.campus.CampusTaskService;
import com.csot.recruit.service.mail.MailSendService;
import com.csot.recruit.service.template.TemplateService;
import com.google.common.collect.Lists;

@Controller
@RequestMapping("campusStudentController")
public class CampusStudentController {
  private static final Logger logger = LoggerFactory.getLogger(CampusStudentController.class);
  private static final String MAIL_ALL_SEND = "all";
  private static final String MAIL_SOME_SEND = "some";

  @Resource
  private CampusStudentService campusStudentService;

  @Resource
  private MailSendService mailSendService;

  @Resource
  private TemplateService templateService;

  @Resource
  private AttachmentService attachmentService;

  @Resource
  private CampusTaskService campusTaskService;

  @Resource
  private CampusStudentMapper campusStudentMapper;

  @Resource
  private SpringPropertyResourceReader springPropertyResourceReader;

  @RequestMapping("list")
  public ModelAndView list(HttpServletRequest request) {
    String yearth = request.getParameter("yearth");
    if (StringUtils.hasText(yearth)) {
      yearth = URLDecoder.decode(yearth, "utf-8");
    } else {
      yearth = "";
    }
    request.setAttribute("yearth", yearth);
    String type = request.getParameter("type");
    if ("offer".equals(type)) {
      request.setAttribute("offer", CommonConstant.YES);
    }
    if ("tril".equals(type)) {
      request.setAttribute("tril", CommonConstant.YES);
    }
    return new ModelAndView("com/csot/campus/campusStudentList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<CampusStudent>
      datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String siteId = request.getParameter("siteId");
    String postId = request.getParameter("postId");
    String stuName = request.getParameter("stuName");
    String school = request.getParameter("school");
    String org = request.getParameter("org");
    String center = request.getParameter("center");
    String yearth = request.getParameter("yearth");
    String showType = request.getParameter("showType");
    String radioValue1 = request.getParameter("radioValue1");
    String radioValue2 = request.getParameter("radioValue2");
    String radioValue3 = request.getParameter("radioValue3");
    String radioValue4 = request.getParameter("radioValue4");
    String radioValue5 = request.getParameter("radioValue5");
    String radioValue6 = request.getParameter("radioValue6");
    String radioValue7 = request.getParameter("radioValue7");
    String radioValue8 = request.getParameter("radioValue8");

    return campusStudentService.getGrid(pageSort, siteId, postId, stuName, school, org, center,
        yearth, showType, radioValue1, radioValue2, radioValue3, radioValue4, radioValue5,
        radioValue6, radioValue7, radioValue8);
  }

  @RequestMapping("create")
  public ModelAndView create(HttpServletRequest request) {
    // 创建时设置以下字段的默认值为无
    CampusStudent campusStudent = new CampusStudent();
    campusStudent.setOffer("无");
    campusStudent.setIdcardCopy("无");
    campusStudent.setBreakOff("无");
    campusStudent.setPhoto("无");
    campusStudent.setCetTranscript("无");
    campusStudent.setTranscript("无");
    campusStudent.setTrilateral("无");
    campusStudent.setReferenceForm("无");
    request.setAttribute("campusStudent", campusStudent);
    return new ModelAndView("com/csot/campus/campusStudentEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    CampusStudent campusStudent = campusStudentService.getByPrimaryKey(id);
    request.setAttribute("campusStudent", campusStudent);
    return new ModelAndView("com/csot/campus/campusStudentEdit");
  }

  @RequestMapping("modifyByMaster/{id}")
  public ModelAndView modifyByMaster(@PathVariable String id, HttpServletRequest request) {
    CampusStudent campusStudent = campusStudentService.getByPrimaryKey(id);
    request.setAttribute("campusStudent", campusStudent);
    return new ModelAndView("com/csot/campus/campusStudentEditByMaster");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    CampusStudent campusStudent = campusStudentService.getByPrimaryKey(id);
    request.setAttribute("campusStudent", campusStudent);
    return new ModelAndView("com/csot/recruit/campus/campusStudentView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    AjaxRtnJson ajaxRtn = new AjaxRtnJson();
    int count = 0;
    try {
      String[] idStr = id.split(",");
      for (int i = 0; i < idStr.length; i++) {
        String stuId = idStr[i];
        campusStudentService.remove(stuId);
        count++;
      }
      if (count == idStr.length) {
        ajaxRtn = new AjaxRtnJson(true, "成功删除" + count + "条数据。");
      } else {
        ajaxRtn =
            new AjaxRtnJson(true, "删除" + count + "条数据,有" + (idStr.length - count) + "条数据删除失败");
      }
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      ajaxRtn = new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
    return ajaxRtn;
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(@CurrentUser SysUser curUser, CampusStudent campusStudent) {

    campusStudent.setYearth(CampusUtils.getCurrentYearth());
    Date date = new Date();
    campusStudent.setChangeTime(date);
    // 若存在相同的身份证号，则更新
    if (null != campusStudentMapper.selectByPrimaryKey(campusStudent.getId())) {

      try {
        if (!StringUtils.isEmpty(campusStudent.getBreakOffReason())) {
          campusStudent.setBreakOffTime(date);
        }
        campusStudentService.updateSelective(campusStudent);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        campusStudent.setCreateUser(curUser.getId());
        campusStudentService.create(campusStudent);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  @RequestMapping("importStudentInfo")
  public ModelAndView importStudentInfo() {
    return new ModelAndView("com/csot/campus/campusStudentImport");
  }

  @RequestMapping("importStudentInfoExcel")
  @ResponseBody
  public AjaxRtnJson
      importStudentInfoExcel(HttpServletRequest request, @CurrentUser SysUser sysUser) {

    // 转型为MultipartHttpRequest：
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    MultipartFile multipartFile = multipartRequest.getFile("myFile");
    String basePath = request.getServletContext().getRealPath("/resources/upload");
    try {
      String message = campusStudentService.importStudentInfo(multipartFile, basePath, sysUser);
      return new AjaxRtnJson(true, message);
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new AjaxRtnJson(false, e.getMessage());
    }
  }

  /**
   * 下载学生资料导入模板
   */
  @RequestMapping("campusStuInfoTemplete")
  public void campusStuInfoTemplete(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    // 模板存放路径
    String filePath =
        request.getSession().getServletContext().getRealPath("")
            + "/excelTemplate/campusStudent.xls";
    File f = new File(filePath);
    if (!f.exists()) {
      response.sendError(404, "File not found!");
      return;
    }
    BufferedInputStream br = new BufferedInputStream(new FileInputStream(f));
    byte[] buf = new byte[1024];
    int len = 0;
    response.reset();
    response.setContentType("application/x-msdownload");
    response.setHeader("Content-Disposition",
        "attachment; filename=" + URLEncoder.encode("校招学生资料导入模板.xls", "utf-8").replace("+", "%20"));
    OutputStream out = response.getOutputStream();
    while ((len = br.read(buf)) > 0) {
      out.write(buf, 0, len);
    }
    br.close();
    out.close();
  }

  /**
   * 根据查询结果导出学生信息资料
   * 
   * @param request
   * @param response
   */
  @RequestMapping("exportCampusStudentInfo")
  @ResponseBody
  public void exportCampusStudentInfo(MiniGridPageSort pageSort, HttpServletRequest request,
      HttpServletResponse response) {

    List<CampusStudent> campusStuList = importDatagrid(pageSort, request).getData();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "CampusStudentInfo_" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/CampusStudentExportTemplate.xml";
    String templatePath = "excelTemplate/campusStudent.xls";
    campusTaskService.exportByTemplate(response, fileName, campusStuList, xmlPath, templatePath);

  }

  /**
   * 发送email给选择学生
   * 
   * @return
   */
  @RequestMapping("sendEmail")
  public ModelAndView sendEmail(HttpServletRequest request, MiniGridPageSort pageSort) {

    // 选中学生id
    String ids = request.getParameter("ids");
    // 发送类型
    String type = request.getParameter("type");

    ModelAndView mav = new ModelAndView("com/csot/campus/campusStuAllEmailSend");

    mav.addObject("ids", ids);
    mav.addObject("type", type);

    return mav;
  }

  /**
   * 弹出邮件模板选择界面
   * 
   * @return
   */
  @RequestMapping("sendByTemplate")
  public ModelAndView sendByTemplate(HttpServletRequest request) {

    return new ModelAndView("com/csot/campus/campusStuEmailSendByTemp");
  }

  // 自定义发送邮件
  @RequestMapping("sendEmailToStuByDef")
  @ResponseBody
  public AjaxRtnJson sendEmailToStuByDef(@CurrentUser SysUser sysUser, MiniGridPageSort pageSort,
      HttpServletRequest request, Template template, SearchCondition searchCondition) {

    String type = request.getParameter("type");
    String ids = request.getParameter("ids");
    String templateId = request.getParameter("relateId");

    String deleteId = request.getParameter("deleteId"); // 删除的附件id
    template.setId(templateId);

    String[] idArr = {};
    if (StringUtils.hasText(ids)) {
      idArr = ids.split(",");
    }

    List<Attachment> deleteAttachList = Lists.newArrayList();
    String[] deleteIdArr = {};
    if (StringUtils.hasText(deleteId)) {
      deleteIdArr = deleteId.split(",");
    }
    if (deleteIdArr.length > 0) {
      for (int k = 0; k < deleteIdArr.length; k++) {
        deleteAttachList.add(attachmentService.getByPrimaryKey(deleteIdArr[k]));
      }
    }
    List<Attachment> attachments = new ArrayList<Attachment>();
    attachments = attachmentService.findAttachsByRelateId(templateId);
    // 删除界面删除的附件
    if (deleteAttachList.size() > 0) {
      attachments.removeAll(deleteAttachList);
    }


    List<CampusStudent> campusStuList = Lists.newArrayList();
    // 如果type=“all”,则campusStuList为所有学生列表,当type=some,表示campusStuList查询学生列表,
    if (MAIL_ALL_SEND.equals(type)) {
      campusStuList = campusStudentMapper.selectByExample(null);
    } else if (MAIL_SOME_SEND.equals(type)) {
      campusStuList = searchStuInfoForEmail(pageSort, searchCondition);
    } else {
      campusStuList = campusStudentService.getStuInfoByStudentList(Arrays.asList(idArr));
    }
    int count = 0;
    try {

      for (int i = 0; i < campusStuList.size(); i++) {
        CampusStudent student = campusStuList.get(i);
        student.setNowDate(DataUtils.getDate("yyyy-mm-dd"));
        mailSendService.sendCommonEmail(student.getEmail(), template, student, attachments);
        count++;
      }
      if (count == campusStuList.size()) {
        return new AjaxRtnJson(true, "成功发送邮件给" + count + "个学生!");
      } else {
        return new AjaxRtnJson(true, "成功发邮件给" + count + "个学生!"
            + (campusStuList.size() - (count + 1)) + "个发送失败");
      }

    } catch (Exception e) {
      logger.error(e.getMessage());
      return new AjaxRtnJson(false, e.getMessage());
    }

  }

  // 选择模板发送邮件
  @RequestMapping("sendEmailToStuBytemplate")
  @ResponseBody
  public AjaxRtnJson sendEmailToStuBytemplate(@CurrentUser SysUser sysUser,
      MiniGridPageSort pageSort, HttpServletRequest request, SearchCondition searchCondition) {

    // 获取前端传过来的参数
    String type = request.getParameter("type");
    String ids = request.getParameter("ids"); // 选中的学生id
    String templateId = request.getParameter("relateId");
    String attachId = request.getParameter("attachId");
    String deleteId = request.getParameter("deleteId"); // 删除的附件id
    Template template = null;

    String[] idArr = {};
    if (StringUtils.hasText(ids)) {
      idArr = ids.split(",");
    }

    List<Attachment> deleteAttachList = Lists.newArrayList();
    String[] deleteIdArr = {};
    if (StringUtils.hasText(deleteId)) {
      deleteIdArr = deleteId.split(",");
    }
    if (deleteIdArr.length > 0) {
      for (int k = 0; k < deleteIdArr.length; k++) {
        deleteAttachList.add(attachmentService.getByPrimaryKey(deleteIdArr[k]));
      }
    }
    List<CampusStudent> campusStuList = Lists.newArrayList();
    // Template template = null;
    if (StringUtils.hasText(templateId)) {
      template = templateService.getByPrimaryKey(templateId);
    }
    List<Attachment> attachments = new ArrayList<Attachment>();
    attachments = attachmentService.findAttachsByRelateId(template.getId());
    attachments.addAll(attachmentService.findAttachsByRelateId(attachId));
    // 删除界面删除的附件
    if (deleteAttachList.size() > 0) {
      attachments.removeAll(deleteAttachList);
    }
    // 如果type="all",则campusStuList为所有学生列表(),当type=some是,表示campusStuList查询结果的学生列表
    if (MAIL_ALL_SEND.equals(type)) {
      campusStuList = campusStudentMapper.selectByExample(null);
    } else if (MAIL_SOME_SEND.equals(type)) {
      campusStuList = searchStuInfoForEmail(pageSort, searchCondition);
    } else {
      campusStuList = campusStudentService.getStuInfoByStudentList(Arrays.asList(idArr));
    }
    int faultCount = 0;
    try {
      for (int i = 0; i < campusStuList.size(); i++) {
        CampusStudent student = campusStuList.get(i);
        student.setNowDate(DataUtils.getDate("yyyy-mm-dd"));
        try{
          mailSendService.sendCommonEmail(campusStuList.get(i).getEmail(), template, student,
              attachments);
        }catch(Exception e){
          faultCount++ ;
        }
      }
      if (faultCount == 0) {
        return new AjaxRtnJson(true, "成功发送邮件给" + campusStuList.size() + "个学生!");
      } else {
        return new AjaxRtnJson(true, "成功发邮件给" + (campusStuList.size() - faultCount) + "个学生!" + faultCount
            + "个发送失败");
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new AjaxRtnJson(false, e.getMessage());
    }
  }

  /**
   * 发送邮件给资料未齐全的学生
   * 
   * @return
   */
  @RequestMapping("sendEmailToSome")
  @ResponseBody
  public AjaxRtnJson sendEmailToSome(HttpServletRequest request) {

    int count = 0;
    List<CampusStudent> campusStuList = Lists.newArrayList();
    Template template = new Template();
    campusStuList = campusStudentMapper.selectIncompleteInfo();

    try {
      // 武汉邮件模板id
      String whTemplateId =
          springPropertyResourceReader
              .getProperty("campus.campusStudent.sendEmailToSome.wuhan.templateId");
      // 深惠邮件模板id
      String shTemplateId =
          springPropertyResourceReader
              .getProperty("campus.campusStudent.sendEmailToSome.shenhui.templateId");
      for (int i = 0; i < campusStuList.size(); i++) {

        // 若缺少offer、三方、成绩单、就业推荐表、身份证复印件、四六级成绩单、照片
        if ("无".equals(campusStuList.get(i).getOffer())) {
          campusStuList.get(i).setOffer("offer");
        } else {
          campusStuList.get(i).setOffer(" ");
        }
        if ("无".equals(campusStuList.get(i).getTrilateral())) {
          campusStuList.get(i).setTrilateral("三方");
        } else {
          campusStuList.get(i).setTrilateral(" ");
        }
        if ("无".equals(campusStuList.get(i).getTranscript())) {
          campusStuList.get(i).setTranscript("成绩单");
        } else {
          campusStuList.get(i).setTranscript(" ");
        }
        if ("无".equals(campusStuList.get(i).getReferenceForm())) {
          campusStuList.get(i).setReferenceForm("就业推荐表");
        } else {
          campusStuList.get(i).setReferenceForm(" ");
        }
        if ("无".equals(campusStuList.get(i).getIdcardCopy())) {
          campusStuList.get(i).setIdcardCopy("身份证复印件");
        } else {
          campusStuList.get(i).setIdcardCopy(" ");
        }
        if ("无".equals(campusStuList.get(i).getCetTranscript())) {
          campusStuList.get(i).setCetTranscript("四六级成绩单");
        } else {
          campusStuList.get(i).setCetTranscript(" ");
        }
        if ("无".equals(campusStuList.get(i).getPhoto())) {
          campusStuList.get(i).setPhoto("照片");
        } else {
          campusStuList.get(i).setPhoto(" ");
        }
        if ("武汉".equals(campusStuList.get(i).getWorkingPlace())) {
          template = templateService.getByPrimaryKey(whTemplateId);
        } else {
          template = templateService.getByPrimaryKey(shTemplateId);
        }

        mailSendService.sendEmail(campusStuList.get(i).getEmail(), template, campusStuList.get(i));
        count++;
      }
      if (count == campusStuList.size()) {
        return new AjaxRtnJson(true, "成功发送邮件给" + count + "个学生!");
      } else {
        return new AjaxRtnJson(true, "成功发邮件给" + count + "个学生!" + (campusStuList.size() - count)
            + "个发送失败");
      }
    } catch (Exception e) {
      logger.error(e.getMessage());
      return new AjaxRtnJson(false, e.getMessage());
    }

  }

  /**
   * 填写违约原因
   * 
   * @return
   */
  @RequestMapping("doSetBreakOffReason")
  public ModelAndView doSetBreakOffReason(HttpServletRequest request) {

    String id = request.getParameter("id");
    request.setAttribute("id", id);
    return new ModelAndView("com/csot/campus/stuBreakOffReason");
  }

  /**
   * 设置显示字段
   * 
   * @return
   */
  @RequestMapping("showColumn")
  public ModelAndView showColumn() {
    return new ModelAndView("com/csot/campus/campusStudentSelectForm");
  }

  /**
   * 根据查询条件获取需要导出的数据
   * 
   * @param pageSort
   * @param request
   * @return
   */
  public MiniRtn2Grid<CampusStudent> importDatagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String siteId = request.getParameter("siteId");
    String postId = request.getParameter("postId");
    String stuName = request.getParameter("stuName");
    String school = request.getParameter("school");
    String org = request.getParameter("org");
    String center = request.getParameter("center");
    String yearth = request.getParameter("yearth");
    String showType = request.getParameter("showType");
    String radioValue1 = request.getParameter("radioValue1");
    String radioValue2 = request.getParameter("radioValue2");
    String radioValue3 = request.getParameter("radioValue3");
    String radioValue4 = request.getParameter("radioValue4");
    String radioValue5 = request.getParameter("radioValue5");
    String radioValue6 = request.getParameter("radioValue6");
    String radioValue7 = request.getParameter("radioValue7");
    String radioValue8 = request.getParameter("radioValue8");
    try {
      if (StringUtils.hasText(stuName)) {
        stuName = new String(stuName.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(school)) {
        school = new String(school.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(org)) {
        org = new String(org.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(center)) {
        center = new String(center.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(yearth)) {
        yearth = new String(yearth.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(showType)) {
        showType = new String(showType.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(radioValue1)) {
        radioValue1 = new String(radioValue1.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(radioValue2)) {
        radioValue2 = new String(radioValue2.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(radioValue3)) {
        radioValue3 = new String(radioValue3.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(radioValue4)) {
        radioValue4 = new String(radioValue4.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(radioValue5)) {
        radioValue5 = new String(radioValue5.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(radioValue6)) {
        radioValue6 = new String(radioValue6.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(radioValue7)) {
        radioValue7 = new String(radioValue7.toString().getBytes("iso8859_1"), "UTF-8");
      }
      if (StringUtils.hasText(radioValue8)) {
        radioValue8 = new String(radioValue8.toString().getBytes("iso8859_1"), "UTF-8");
      }
    } catch (UnsupportedEncodingException e) {
      logger.error(e.getMessage());
    }

    return campusStudentService.getGrid(pageSort, siteId, postId, stuName, school, org, center,
        yearth, showType, radioValue1, radioValue2, radioValue3, radioValue4, radioValue5,
        radioValue6, radioValue7, radioValue8);
  }

  @RequestMapping("importStuInfoByMaster")
  public ModelAndView importStuInfoByMaster(@CurrentUser SysUser currentUser,
      HttpServletRequest request) {
    String message = "";

    String yearth = CampusUtils.getCurrentYearth();
    String createUser = currentUser.getId();

    CampusStudentCriteria criteria = new CampusStudentCriteria();
    CampusStudentCriteria.Criteria criter = criteria.or();
    criter.andYearthEqualTo(yearth);
    criter.andCreateUserEqualTo(createUser);
    // 当历史数据中存在该站长导入过的消息，则不能再导入
    if (campusStudentMapper.selectByExample(criteria).size() > 0) {
      message = "每个站长只能导入本站信息1次，如要再次导入请联系管理员！";
    }
    request.setAttribute("msg", message);
    return new ModelAndView("com/csot/campus/campusStudentImport");
  }

  @ResponseBody
  public List<CampusStudent> searchStuInfoForEmail(MiniGridPageSort pageSort,
      SearchCondition searchCondit) {

    String siteId = searchCondit.getSiteId();
    String postId = searchCondit.getPostId();
    String stuName = searchCondit.getStuName();
    String school = searchCondit.getSchool();
    String org = searchCondit.getOrg();
    String center = searchCondit.getCenter();
    String yearth = searchCondit.getYearth();
    String showType = searchCondit.getShowType();
    String radioValue1 = searchCondit.getRadioValue1();
    String radioValue2 = searchCondit.getRadioValue2();
    String radioValue3 = searchCondit.getRadioValue3();
    String radioValue4 = searchCondit.getRadioValue4();
    String radioValue5 = searchCondit.getRadioValue5();
    String radioValue6 = searchCondit.getRadioValue6();
    String radioValue7 = searchCondit.getRadioValue7();
    String radioValue8 = searchCondit.getRadioValue8();
    return campusStudentService.getGrid(pageSort, siteId, postId, stuName, school, org, center,
        yearth, showType, radioValue1, radioValue2, radioValue3, radioValue4, radioValue5,
        radioValue6, radioValue7, radioValue8).getData();
  }

}
