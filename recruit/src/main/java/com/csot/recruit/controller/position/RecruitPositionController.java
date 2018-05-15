package com.csot.recruit.controller.position;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.pojo.LoginClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.common.exception.BusinessException;
import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.common.util.ExportExcelUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.position.DepartmentRequire;
import com.csot.recruit.model.position.PositionDistributeRecords;
import com.csot.recruit.model.position.PositionMana;
import com.csot.recruit.model.position.RecruitPosition;
import com.csot.recruit.model.position.RecruitSite;
import com.csot.recruit.model.position.RequireInfor;
import com.csot.recruit.service.datadict.DatadictGroupService;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandService;
import com.csot.recruit.service.position.DepartmentRequireService;
import com.csot.recruit.service.position.DistributeService;
import com.csot.recruit.service.position.RecruitInforService;
import com.csot.recruit.service.position.RecruitPositionService;
import com.csot.recruit.service.position.RequireInforService;

@Controller
@RequestMapping("position")
public class RecruitPositionController {
  private static final Logger logger = LoggerFactory.getLogger(RecruitPositionController.class);

  @Resource
  private RecruitPositionService recruitPositionService;
  @Resource
  private DatadictGroupService datadictGroupService;
  @Resource
  private DepartmentRequireService departmentRequireService;
  @Resource
  private DistributeService distributeService;
  @Resource
  private RecruitInforService recruitInforService;
  @Resource
  private RequireInforService requireInforService;
  @Resource
  private CommonService commonService;
  @Resource
  private RecruitDemandService recruitDemandService;

  @RequestMapping("positionMana")
  public ModelAndView positionManaPage() {

    return new ModelAndView("com/csot/position/positionManage");
  }

  /***
   * 职位管理查询
   * 
   * @param page 分页对象
   * @param positionMana 查询对象
   * @return
   */
  @ResponseBody
  @RequestMapping("queryPositionManaList")
  public MiniRtn2Grid<PositionMana> queryPositionManaList(MiniGridPageSort page,
      PositionMana positionMana) {
    if (null != positionMana.getPublisher() && positionMana.getPublisher().equals("请选择人员")) {
      positionMana.setPublisher(null);
    }
    if (null != positionMana.getDepartment() && positionMana.getDepartment().equals("选择部门"))
      positionMana.setDepartment(null);
    if (null != positionMana.getPositionLevel()
        && positionMana.getPositionLevel().trim().equals("002-000"))
      positionMana.setPositionLevel(null);
    if (null != positionMana.getPositionType()
        && positionMana.getPositionType().trim().equals("006-000"))
      positionMana.setPositionType(null);
    if (null != positionMana.getStatus() && positionMana.getStatus().trim().equals("011-006"))
      positionMana.setStatus(null);
    if ("0".equals(positionMana.getPositionType()))
      positionMana.setPositionType(null);
    if ("0".equals(positionMana.getPositionLevel()))
      positionMana.setPositionLevel(null);
    if (null != positionMana.getWorkPlace() && positionMana.getWorkPlace().trim().equals("023-000"))
      positionMana.setWorkPlace(null);
    if (StringUtil.isEmpty(page.getSortField())) {
      page.setSortField("releaseDate");
      page.setSortOrder("desc");
    }
    MiniRtn2Grid<PositionMana> minirtn2Grid =
        recruitPositionService.queryPositionManaListByPage(page, positionMana);
    logger.info("data:" + minirtn2Grid.getData() + "total:" + minirtn2Grid.getTotal());
    return minirtn2Grid;
  }

  @RequestMapping("positionEdit")
  public ModelAndView positionEditPage() {
    return new ModelAndView("com/csot/position/positionEdit");
  }

  /**
   * 招聘需求页面点击发布岗位
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("positionEditByDemand/{id}")
  public ModelAndView positionEdit(@PathVariable String id, HttpServletRequest request) {
    RecruitDemand recruitDemand = recruitDemandService.getByPrimaryKey(id);
    RecruitPosition recruitPosition =
        recruitPositionService.queryPositionByPostId(recruitDemand.getApplyPostId());
    request.setAttribute("recruitDemand", recruitDemand);
    request.setAttribute("post", recruitPosition);
    if (recruitPosition != null && recruitPosition.getRecruitPositionId() != null
        && !recruitPosition.getRecruitPositionId().equals("")&&!recruitPosition.getStatus().equals("011-000")) {
      PositionMana pm = new PositionMana();
      pm.setRecruitPositionId(recruitPosition.getRecruitPositionId());
      MiniRtn2Grid<PositionMana> minirtn2Grid = recruitPositionService.queryPositionManaList(pm);
      if (null != minirtn2Grid.getData() && minirtn2Grid.getData().size() > 0) {
        PositionMana positionMana = minirtn2Grid.getData().get(0);
        request.setAttribute("positionMana", positionMana);
      } else {
        return new ModelAndView("com/csot/position/positionEdit2");
      }
      return new ModelAndView("com/csot/position/positionEditUpdate");
    }
    return new ModelAndView("com/csot/position/positionEdit2");
  }

  /**
   * 全部日程页面点击查看岗位修改点
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("showChange/{id}")
  public ModelAndView showChange(@PathVariable String id, HttpServletRequest request) {
    RecruitPosition recruitPosition = recruitPositionService.queryPositionByPostId(id);
    request.setAttribute("post", recruitPosition);
    PositionMana pm = new PositionMana();
    pm.setRecruitPositionId(recruitPosition.getRecruitPositionId());
    MiniRtn2Grid<PositionMana> minirtn2Grid = recruitPositionService.queryPositionManaList(pm);
    if (null != minirtn2Grid.getData() && minirtn2Grid.getData().size() > 0) {
      PositionMana positionMana = minirtn2Grid.getData().get(0);
      request.setAttribute("positionMana", positionMana);
    } 
    return new ModelAndView("com/csot/position/positionEdit3");
  }

  /**
   * 全部日程页面点击查看岗位信息
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("postInfo/{id}")
  public ModelAndView postInfo(@PathVariable String id, HttpServletRequest request) {
    RecruitPosition recruitPosition = recruitPositionService.queryPositionByPostId(id);
    request.setAttribute("post", recruitPosition);
    PositionMana pm = new PositionMana();
    pm.setRecruitPositionId(recruitPosition.getRecruitPositionId());
    MiniRtn2Grid<PositionMana> minirtn2Grid = recruitPositionService.queryPositionManaList(pm);
    if (null != minirtn2Grid.getData() && minirtn2Grid.getData().size() > 0) {
      PositionMana positionMana = minirtn2Grid.getData().get(0);
      request.setAttribute("positionMana", positionMana);
    }
    return new ModelAndView("com/csot/position/positionEdit4");
  }

  @RequestMapping("queryPosition")
  @ResponseBody
  public AjaxRtnJson queryPosition(String positonId) {
    AjaxRtnJson re;
    PositionMana pm = new PositionMana();
    pm.setRecruitPositionId(positonId);
    MiniRtn2Grid<PositionMana> minirtn2Grid = recruitPositionService.queryPositionManaList(pm);
    if (null != minirtn2Grid.getData() && minirtn2Grid.getData().size() > 0) {
      re = new AjaxRtnJson(true, "查询成功！");
      re.setObj(minirtn2Grid.getData().get(0));
    } else {
      re = new AjaxRtnJson(false, "职位不存在！");
    }
    return re;
  }

  /***
   * 职位发布
   * 
   * @param recruitPosition 职位基本信息
   * @param departmentRequire 需求信息
   * @param requireInfor 招聘流程角色
   * @return 跳转页面
   */
  @ResponseBody
  @RequestMapping("createRecruitPosition")
  public ModelAndView createRecruitPosition(RecruitPosition recruitPosition,
      DepartmentRequire departmentRequire, RequireInfor requireInfor) {
    recruitPositionService.createRecruitPosition(recruitPosition, departmentRequire, requireInfor);
    return new ModelAndView("com/csot/position/positionEdit");
  }

  @RequestMapping("positionPostRecords")
  public ModelAndView positionPostRecordsPage() {
    return new ModelAndView("com/csot/position/positionPostRecords");
  }

  @RequestMapping("positionInfor")
  public ModelAndView positionInforPage() {
    return new ModelAndView("com/csot/position/positionInfo");
  }

  @RequestMapping("positionPreview")
  public ModelAndView positionPreview(RecruitPosition recruitPosition, HttpServletRequest request) {
    request.setAttribute("recruitPosition", recruitPosition);
    return new ModelAndView("com/csot/position/positionPreview");
  }

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/recruit/controller/position/recruitPositionList");
  }

  @RequestMapping("posiCode")
  @ResponseBody
  public String getPosiCode() {
    return recruitPositionService.getPosiCode();
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<RecruitPosition> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return recruitPositionService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/controller/position/recruitPositionEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    RecruitPosition recruitPosition = recruitPositionService.getByPrimaryKey(id);
    request.setAttribute("recruitPosition", recruitPosition);
    return new ModelAndView("com/csot/recruit/controller/position/recruitPositionEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    RecruitPosition recruitPosition = recruitPositionService.getByPrimaryKey(id);
    request.setAttribute("recruitPosition", recruitPosition);
    return new ModelAndView("com/csot/recruit/controller/position/recruitPositionView");
  }

  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      recruitPositionService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(@RequestBody RecruitPosition recruitPosition, HttpServletRequest request) {
    if (StringUtils.hasText(recruitPosition.getRecruitPositionId())) {
      try {
        // 如果是已分发的职位，如果没有暂停，先暂停职位分发
        RecruitPosition oPosition =
            recruitPositionService.getByPrimaryKey(recruitPosition.getRecruitPositionId());
        /*
         * if(PositionStatus.PUBLISHING.equals(oPosition.getStatus())) { // 调接口暂停分发,没实现 // // // }
         */
        recruitPositionService.updateSelective(recruitPosition);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        recruitPosition.setRecruitPositionId(UUID.randomUUID().toString().replace("-", ""));
        LoginClient loginClient =
            (LoginClient) request.getSession().getAttribute(LoginClient.CLIENT_SESSION_ATTR);
        if (loginClient != null && loginClient.getUser() != null) {
          recruitPosition.setCreater(loginClient.getUser().getId());
        }
        recruitPositionService.create(recruitPosition);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException | ParseException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  @RequestMapping("save2")
  @ResponseBody
  public AjaxRtnJson save2(@CurrentUser SysUser sysUser,
      @RequestBody RecruitPosition recruitPosition, HttpServletRequest request) {
    String demandId = request.getParameter("demandId");
    Map<String, String> colMap = new HashMap<String, String>();
    colMap.put("demandId", demandId);
    colMap.put("sysUserId", sysUser.getId());
    if (StringUtils.hasText(recruitPosition.getRecruitPositionId())) {
      try {
        // 如果是已分发的职位，如果没有暂停，先暂停职位分发
        recruitPositionService.updateSelective(recruitPosition, colMap);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        recruitPosition.setRecruitPositionId(UUID.randomUUID().toString().replace("-", ""));
        recruitPosition.setCreater(sysUser.getId());
        recruitPositionService.create2(recruitPosition, colMap);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException | ParseException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /***
   * 职位管理(保密设置)
   * 
   * @param recruitPositionId 职位id
   * @param secrecy 是否保密(0:公开,1:对内公开,2:保密)
   * @return
   */
  @ResponseBody
  @RequestMapping("setSecurity")
  public void setSecurity(
      @RequestParam(value = "recruitPositionId", required = true) String recruitPositionId,
      @RequestParam(value = "secrecy", required = true) String secrecy) {
    RecruitPosition recruitPosition = new RecruitPosition();
    String[] recruitPositionIds = recruitPositionId.split(",");
    recruitPosition.setSecrecy(secrecy);
    for (int i = 0; i < recruitPositionIds.length; i++) {
      recruitPosition.setRecruitPositionId(recruitPositionIds[i]);
      recruitPositionService.updateSelective(recruitPosition);

    }
  }

  /***
   * 职位重新发布
   * 
   * @param recruitPositionId 职位ID
   * @param validity 有效期
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping("againRelease")
  public void againRelease(
      @RequestParam(value = "recruitPositionId", required = true) String recruitPositionId,
      @RequestParam(value = "validity", required = true) String validity) throws Exception {
    String[] recruitPositionIds = recruitPositionId.split(",");
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    if (validity.equals("0")) {
      // 有效期一周
      calendar.add(Calendar.DATE, 7);
      date = calendar.getTime();
    } else if (validity.equals("1")) {
      // 有效期两周
      calendar.add(Calendar.DATE, 14);
      date = calendar.getTime();
    } else if (validity.equals("2")) {
      // 有效期一个月
      calendar.add(Calendar.MONDAY, 1);
      date = calendar.getTime();
    } else if (validity.equals("3")) {
      // 有效期两个月
      calendar.add(Calendar.MONDAY, 2);
      date = calendar.getTime();
    } else if (validity.equals("4")) {
      // 有效期三个月
      calendar.add(Calendar.MONDAY, 3);
      date = calendar.getTime();
    } else if (validity.equals("5")) {
      date = null;
      // 有效期永久
    }
    RecruitPosition recruitPosition = new RecruitPosition();
    recruitPosition.setExpireDate(date);
    recruitPosition.setStatus("011-002");
    for (int i = 0; i < recruitPositionIds.length; i++) {
      recruitPosition.setRecruitPositionId(recruitPositionIds[i]);
      recruitPositionService.updateSelective(recruitPosition);
    }
  }

  /***
   * 职位管理(启用职位)
   * 
   * @param recruitPositionId 职位ID
   * @param effectiveDate 生效时间
   * @throws ParseException
   */
  @ResponseBody
  @RequestMapping("enablePosition")
  public void enablePosition(
      @RequestParam(value = "recruitPositionId", required = true) String recruitPositionId,
      @RequestParam(value = "effectiveDate", required = true) String effectiveDate)
      throws Exception {
    String[] recruitPositionIds = recruitPositionId.split(",");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    for (int i = 0; i < recruitPositionIds.length; i++) {
      DepartmentRequire departmentRequire =
          departmentRequireService.getByRecruitPositionId(recruitPositionIds[i]);
      departmentRequire.setEffectiveDate(sdf.parse(effectiveDate));
      departmentRequireService.updateSelective(departmentRequire);
    }
  }

  /***
   * 职位管理(职位招聘完成、招聘暂停)
   * 
   * @param recruitPositionId 职位id
   * @param status 职位状态(0:草稿箱,1:已完成,2:发布中,3:已过期,4:即将到期,5:已暂停)
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping("updatePositionStatus")
  public void completePosition(
      @RequestParam(value = "recruitPositionId", required = true) String recruitPositionId,
      @RequestParam(value = "status", required = true) String status) throws Exception {
    String[] recruitPositionIds = recruitPositionId.split(",");
    RecruitPosition recruitPosition = new RecruitPosition();
    recruitPosition.setStatus(status);
    for (int i = 0; i < recruitPositionIds.length; i++) {
      recruitPosition.setRecruitPositionId(recruitPositionIds[i]);
      recruitPositionService.updateSelective(recruitPosition);
    }
  }

  /***
   * 删除职位
   * 
   * @param recruitPositionId 职位id
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping("delPosition")
  public void delPosition(
      @RequestParam(value = "recruitPositionId", required = true) String recruitPositionId)
      throws Exception {
    recruitPositionService.removeByPositionId(recruitPositionId);
  }

  /***
   * 职位管理导出excel
   * 
   * @param page 分页对象
   * @param positionMana 查询对象
   * @return
   */
  @ResponseBody
  @RequestMapping("queryPositionManaListExcel")
  public ModelAndView queryPositionManaListExcel(HttpServletResponse response,
      MiniGridPageSort page, PositionMana positionMana) {
    logger.info(positionMana + "" + positionMana.getPositionName());
    if (null != positionMana.getPublisher() && positionMana.getPublisher().equals("请选择人员"))
      positionMana.setPublisher(null);
    /*
     * if (null != positionMana.getRecruiter() && positionMana.getRecruiter().equals("付亮"))
     */
    positionMana.setRecruiter(null);
    if (null != positionMana.getDepartment() && positionMana.getDepartment().equals("选择部门"))
      positionMana.setDepartment(null);
    if (null != positionMana.getPositionLevel()
        && positionMana.getPositionLevel().trim().equals("002-000"))
      positionMana.setPositionLevel(null);
    if (null != positionMana.getPositionType()
        && positionMana.getPositionType().trim().equals("006-000"))
      positionMana.setPositionType(null);
    if (null != positionMana.getStatus() && positionMana.getStatus().trim().equals("011-006"))
      positionMana.setStatus(null);
    if ("0".equals(positionMana.getPositionType()))
      positionMana.setPositionType(null);
    if ("0".equals(positionMana.getPositionLevel()))
      positionMana.setPositionLevel(null);
    if ("0".equals(positionMana.getWorkPlace()))
      positionMana.setWorkPlace(null);
    if ("undefined".equals(positionMana.getStatus()))
      positionMana.setStatus(null);
    MiniRtn2Grid<PositionMana> minirtn2Grid =
        recruitPositionService.queryPositionManaList(positionMana);
    logger.info("data:" + minirtn2Grid.getData());
    String[] headersName =
        new String[] {"职位名称", "职位编码", "内部编码", "招聘专员", "发布者", "接收简历邮箱", "标记", "部门", "用人部门主管",
            "保密设置", "招聘数量", "地区", "状态", "职能类别", "职位级别", "需求人数", "职位生效日期", "期望到岗日期", "发布日期", "修改日期",
            "截止日期"};
    String[] headersId =
        new String[] {"positionName", "positionCode", "departmentCode", "recruiter", "publisher",
            "receiveEmail", "label", "department", "departmentManager", "secrecy",
            "recruitNumbers", "workPlace", "status", "positionType", "positionLevel", "demands",
            "effectiveDate", "expectDate", "distributeDate", "modifyDate", "expireDate"};
    ExportExcelUtil excelUtil = new ExportExcelUtil();
    excelUtil.exportExcel("职位列表", headersName, headersId, minirtn2Grid.getData(), response);
    return null;
  }

  /***
   * 跳转到职位分发页面
   * 
   * @param recruitPositionId 职位ID
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "distribute", method = RequestMethod.GET)
  public ModelAndView positionDistribute(
      @RequestParam(value = "recruitPositionId", required = true) String recruitPositionId,
      @RequestParam(value = "sites", required = false) String sites, HttpServletRequest request) {
    List<RecruitSite> showlist = new ArrayList<RecruitSite>();
    RecruitPosition position = recruitPositionService.getByPrimaryKey(recruitPositionId);
    List<RecruitSite> recruitSites = commonService.getSiteInfo(request);
    if (StringUtil.isNotEmpty(sites)) {
      List<String> sitelist = Arrays.asList(sites.split(","));
      for (RecruitSite rs : recruitSites) {
        if (sitelist.contains("www." + rs.getUrl())) {
          showlist.add(rs);
        }
      }
    } else {
      showlist = recruitSites;
    }
    ModelAndView view = new ModelAndView("com/csot/position/positionDistribute");
    view.addObject("position", position);
    view.addObject("recruitSites", showlist);
    return view;
  }

  /**
   * 获取验证码
   * 
   * @param site 站点
   * @return 验证码图片名
   */
  @ResponseBody
  @RequestMapping(value = "getCaptcha")
  public AjaxRtnJson refreshCaptcha(String site, HttpServletRequest request) {
    AjaxRtnJson re = new AjaxRtnJson(true, "查询成功！");
    try {
      String imgName = commonService.getCaptcha(request, site);
      re.setObj(imgName);
    } catch (BusinessException e) {
      re.setSuccess(false);
      re.setMsg(e.getMessage());
    }
    return re;
  }

  /***
   * 职位分发
   * 
   * @param recruitPositionId 职位ID
   * @param siteId 发布网站代号(1:前程无忧,2:中华英才网,3:中国人才热线,4:智联招聘,5:猎聘网,6:赶集网,7:58同城)
   * @param session
   */
  @ResponseBody
  @RequestMapping(value = "addPositionDistribute", method = RequestMethod.POST)
  public AjaxRtnJson addPositionDistribute(@RequestBody RecruitSite rs) {
    String result = recruitPositionService.positionDistribute(rs);
    AjaxRtnJson re = null;
    if ("true".equals(result)) {
      re = new AjaxRtnJson(true, "分发成功!");
    } else {
      re = new AjaxRtnJson(false, result);
    }
    return re;
  }


  /***
   * 添加标签
   * 
   * @param recruitPositionId 职位ID
   * @param label 标记
   * @throws Exception
   */
  @ResponseBody
  @RequestMapping(value = "addLabels", method = RequestMethod.POST)
  public void addLabels(
      @RequestParam(value = "recruitPositionId", required = true) String recruitPositionId,
      @RequestParam(value = "label", required = true) String label) throws Exception {
    String[] recruitPositionIds = recruitPositionId.split(",");
    RecruitPosition recruitPosition = new RecruitPosition();
    recruitPosition.setLabel(label);
    for (int i = 0; i < recruitPositionIds.length; i++) {
      recruitPosition.setRecruitPositionId(recruitPositionIds[i]);
      recruitPositionService.updateSelective(recruitPosition);
    }
  }

  /***
   * 职位分发查询
   * 
   * @param page 分页对象
   * @param positionMana 查询对象
   * @return
   */
  @ResponseBody
  @RequestMapping("queryPositionDistributeList")
  public MiniRtn2Grid<PositionDistributeRecords> queryPositionDistributeList(MiniGridPageSort page,
      PositionDistributeRecords positionDistribute) {
    Integer pageIndex = page.getPageIndex();
    Integer pageSize = page.getPageSize();
    logger.info("pageIndex:" + pageIndex);
    logger.info("pageSize:" + pageSize);
    if (null != positionDistribute.getPublisher()
        && positionDistribute.getPublisher().equals("选择部门"))
      positionDistribute.setPublisher(null);
    if (null != positionDistribute.getPublishSite()
        && positionDistribute.getPublishSite().equals("请选择"))
      positionDistribute.setPublishSite(null);
    if (null != positionDistribute.getDepartment()
        && positionDistribute.getDepartment().equals("选择部门"))
      positionDistribute.setDepartment(null);
    if (StringUtil.isEmpty(page.getSortField())) {
      page.setSortField("distributeDate");
      page.setSortOrder("desc");
    }
    MiniRtn2Grid<PositionDistributeRecords> minirtn2Grid =
        recruitPositionService.queryPositionDistributeListByPage(page, positionDistribute);
    return minirtn2Grid;
  }

  /**
   * 职位预览
   * 
   * @param page
   * @param positionDistribute
   * @return
   */
  @ResponseBody
  @RequestMapping("preview")
  public ModelAndView queryPositionPreview(@RequestParam(value = "recruitPositionId",
      required = true) String recruitPositionId) {
    MiniGridPageSort page = new MiniGridPageSort();
    PositionMana positionMana = new PositionMana();
    positionMana.setRecruitPositionId(recruitPositionId);
    MiniRtn2Grid<PositionMana> minirtn2Grid =
        recruitPositionService.queryPositionManaListByPage(page, positionMana);
    logger.info("data:" + minirtn2Grid.getData() + "total:" + minirtn2Grid.getTotal());
    PositionMana positionManage = minirtn2Grid.getData().get(0);
    return new ModelAndView("com/csot/position/positionInfo").addObject("positionManage",
        positionManage);
  }

  /**
   * 职位编辑
   * 
   * @param page
   * @param positionDistribute
   * @return
   */
  @ResponseBody
  @RequestMapping("positionInfoEdit")
  public ModelAndView editsPositionPreview(@RequestParam(value = "recruitPositionId",
      required = true) String recruitPositionId) {
    MiniGridPageSort page = new MiniGridPageSort();
    PositionMana positionMana = new PositionMana();
    positionMana.setRecruitPositionId(recruitPositionId);
    MiniRtn2Grid<PositionMana> minirtn2Grid =
        recruitPositionService.queryPositionManaListByPage(page, positionMana);
    logger.info("data:" + minirtn2Grid.getData() + "total:" + minirtn2Grid.getTotal());
    PositionMana positionManage = minirtn2Grid.getData().get(0);
    return new ModelAndView("com/csot/position/positionEdit").addObject("positionManage",
        positionManage);
  }

  /**
   * 根据状态获取发布中的职位
   * 
   * @param status
   * @return
   */
  @RequestMapping("positionByStatus")
  @ResponseBody
  public AjaxRtnJson getPositionByStatus(String status) {
    List<PositionMana> positionManaList = recruitPositionService.getPositionByStatus(status);
    AjaxRtnJson re = new AjaxRtnJson(true, "成功");
    re.setObj(positionManaList);
    return re;
  }
}
