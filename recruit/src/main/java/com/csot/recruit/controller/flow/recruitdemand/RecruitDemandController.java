package com.csot.recruit.controller.flow.recruitdemand;

import java.text.SimpleDateFormat;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.model.original.attachment.Attachment;
import com.csot.recruit.model.original.flow.recruitdemand.RdARalationCriteria;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemand;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandByHandler;
import com.csot.recruit.model.original.flow.recruitdemand.RecruitDemandVo;
import com.csot.recruit.service.flow.recruitdemand.RdARalationService;
import com.csot.recruit.service.flow.recruitdemand.RecruitDemandService;

/**
 * 招聘需求管理
 * 
 * @author 李耀东
 *
 */
@Controller
@RequestMapping("demand")
public class RecruitDemandController {
  private static final Logger logger = LoggerFactory.getLogger(RecruitDemandController.class);

  @Resource
  private RecruitDemandService recruitDemandService;
  @Resource
  private RdARalationService rdARalationService;
  @Resource
  private CommonService commonService;

  /**
   * 进入招聘需求列表页面
   * 
   * @return
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandList");
  }
  
  /**
   * 进入招聘需求列表页面
   * 
   * @return
   */
  @RequestMapping("listByHandler")
  public ModelAndView listByHandler() {
    return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandListByHandler");
  }

  /**
   * 选择需求列表
   * 
   * @return
   */
  @RequestMapping("chooseDemandList")
  public ModelAndView chooseDemandList(HttpServletRequest request) {
    String candidateId = request.getParameter("candidateId");
    String oldPositionId = request.getParameter("oldPositionId");
    ModelAndView mv = new ModelAndView("com/csot/candidate/chooseDemandList");
    mv.addObject("candidateId", candidateId);
    mv.addObject("oldPositionId", oldPositionId);
    return mv;
  }
  
  /**
   * 选择岗位列表
   * 
   * @return
   */
  @RequestMapping("choosePositions")
  public ModelAndView choosePositions(HttpServletRequest request) {
    ModelAndView mv = new ModelAndView("com/csot/candidate/choosePositions");
    return mv;
  }

  /**
   * 添加候选人
   * 
   * @return
   */
  @RequestMapping("choosePositionList")
  public ModelAndView choosePositionList(HttpServletRequest request) {
    String candidateId = request.getParameter("candidateId");
    ModelAndView mv = new ModelAndView("com/csot/candidate/addCandidatePostList");
    mv.addObject("candidateId", candidateId);
    return mv;
  }

  /**
   * 进入修改招聘需求申请人数页面
   * 
   * @return
   */
  @RequestMapping("updateApplyPersonNum/{id}")
  public ModelAndView updateApplyPersonNum(@PathVariable String id, HttpServletRequest request) {
    RecruitDemand recruitDemand = recruitDemandService.getByPrimaryKey(id);
    request.setAttribute("recruitDemand", recruitDemand);
    return new ModelAndView("com/csot/flow/recruitdemand/updateApplyPersonNum");
  }

  /**
   * 进入修改招聘需求期望到岗时间页面
   * 
   * @return
   */
  @RequestMapping("updateWantTime/{id}")
  public ModelAndView updateWantTime(@PathVariable String id, HttpServletRequest request) {
    RecruitDemand recruitDemand = recruitDemandService.getByPrimaryKey(id);
    request.setAttribute("recruitDemand", recruitDemand);
    return new ModelAndView("com/csot/flow/recruitdemand/updateWantTime");
  }


  /**
   * 进入历史岗位说明和岗位条件列表页面
   * 
   * @return
   */
  @RequestMapping("history")
  public ModelAndView history() {
    return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandHistory");
  }

  /**
   * 进入共承岗位页面
   * 
   * @return
   */
  @RequestMapping("share")
  public ModelAndView share() {
    return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandShare");
  }
  
  

 
  /**
   * 查询招聘需求列表
   * 
   * @param pageSort
   * @param request
   * @return
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<RecruitDemandVo> datagrid(MiniGridPageSort pageSort,
      @CurrentUser SysUser sysUser, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    String stateSelf = request.getParameter("stateSelf"); // 列表查询状态
    String postId = request.getParameter("postId"); // 岗位id
    String postName = request.getParameter("postName"); // 岗位id
    String rankId = request.getParameter("rankId"); // 岗位id
    
   
    
    Map<String, String> searchMap = new HashMap<String, String>();
    String flowState = request.getParameter("flowState"); // 流程状态
    String isShare = request.getParameter("isShare"); // 是否共承
    String startDistributeDate = request.getParameter("startDistributeDate"); // 预计到到岗时间 开始
    String endDistributeDate = request.getParameter("endDistributeDate"); // 预计到岗时间 结束
    String orgCode = request.getParameter("orgCode"); // 部门code
    searchMap.put("orgCode", orgCode);
    searchMap.put("flowState", flowState);
    searchMap.put("isShare", isShare);
    searchMap.put("startDistributeDate", startDistributeDate);
    searchMap.put("endDistributeDate", endDistributeDate);
    
    
    searchMap.put("searchKey", searchKey);
    searchMap.put("stateSelf", stateSelf);
    searchMap.put("postId", postId);
    searchMap.put("postName", postName);
    searchMap.put("rankId", rankId);
    searchMap.put("userId", sysUser.getId());
    searchMap.put("userCode", sysUser.getWorkCode());
    
    return recruitDemandService.getGrid(pageSort, searchMap);
  }
  
  
  /**
   * 查询招聘需求列表
   * 
   * @param pageSort
   * @param request
   * @return
   */
  @RequestMapping("datagridByHandler")
  @ResponseBody
  public MiniRtn2Grid<RecruitDemandByHandler> datagridByHandler(MiniGridPageSort pageSort,
      @CurrentUser SysUser sysUser, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    String stateSelf = request.getParameter("stateSelf"); // 列表查询状态
    String postId = request.getParameter("postId"); // 岗位id
    String postName = request.getParameter("postName"); // 岗位id
    String rankId = request.getParameter("rankId"); // 岗位id
    String orgCode = request.getParameter("orgCode"); // 部门code
    Map<String, String> searchMap = new HashMap<String, String>();
    
    String flowState = request.getParameter("flowState"); // 流程状态
    String isShare = request.getParameter("isShare"); // 是否共承
    String startDistributeDate = request.getParameter("startDistributeDate"); // 预计到到岗时间 开始
    String endDistributeDate = request.getParameter("endDistributeDate"); // 预计到岗时间 结束
   
    searchMap.put("orgCode", orgCode);
    searchMap.put("flowState", flowState);
    searchMap.put("isShare", isShare);
    searchMap.put("startDistributeDate", startDistributeDate);
    searchMap.put("endDistributeDate", endDistributeDate);
    
    searchMap.put("searchKey", searchKey);
    searchMap.put("stateSelf", stateSelf);
    searchMap.put("postId", postId);
    searchMap.put("postName", postName);
    searchMap.put("rankId", rankId);
    searchMap.put("userId", sysUser.getId());
    searchMap.put("userCode", sysUser.getWorkCode());
    
    return recruitDemandService.getGridByHandler(pageSort, searchMap);
  }

  /**
   * 进去新增招聘需求页面
   * 
   * @return
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandEdit");
  }

  /**
   * 进入修改招聘需求页面
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    RecruitDemand recruitDemand = recruitDemandService.getByPrimaryKey(id);
    RdARalationCriteria criteria = new RdARalationCriteria();
    criteria.or().andRecruitDemandIdEqualTo(id);
    request.setAttribute("recruitDemand", recruitDemand);
    List<Attachment> list = rdARalationService.getList(criteria);
    request.setAttribute("attachments", list);
    if (RecruitDemand.flowState.UNCOMMITTED.valueStr().equals(recruitDemand.getFlowState())) {
      // 只有待提交状态需求才可以修改所有字段
      return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandEdit");
    }
    return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandUpdateAstrict");
  }
  

  /**
   * 进入修改招聘需求页面
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("modifyByHandler/{id}")
  public ModelAndView modifyByHandler(@PathVariable String id, HttpServletRequest request) {
    RecruitDemand recruitDemand = recruitDemandService.getByPrimaryKey(id);
    RdARalationCriteria criteria = new RdARalationCriteria();
    criteria.or().andRecruitDemandIdEqualTo(id);
    request.setAttribute("recruitDemand", recruitDemand);
    List<Attachment> list = rdARalationService.getList(criteria);
    request.setAttribute("attachments", list);
    if (RecruitDemand.flowState.UNCOMMITTED.valueStr().equals(recruitDemand.getFlowState())) {
      // 只有待提交状态需求才可以修改所有字段
      return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandEdit");
    }
    return new ModelAndView("com/csot/flow/recruitdemand/recruitDemandUpdateAstrictByHandler");
  }
  
  

  /**
   * 暂未使用
   * 
   * @param id
   * @param request
   * @return
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    RecruitDemand recruitDemand = recruitDemandService.getByPrimaryKey(id);
    request.setAttribute("recruitDemand", recruitDemand);
    return new ModelAndView("com/csot/recruit/flow/recruitdemand/recruitDemandView");
  }

  /**
   * 暂未使用
   * 
   * @param id
   * @return
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      recruitDemandService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 招聘需求申请/修改
   * 
   * @param sysUser 当前登录人
   * @param recruitDemand 招聘需求对象
   * @return
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(@CurrentUser SysUser sysUser, RecruitDemand recruitDemand,
      HttpServletRequest request) {
    String typeStr = request.getParameter("typeStr"); // 获取提交类型（暂存/提交/提交之后的修改）
    if (typeStr.equals("ZC")) {
      recruitDemand.setFlowState(RecruitDemand.flowState.UNCOMMITTED.valueStr()); // 暂存操作 未提交状态
    } else if (typeStr.equals("TJ")) {
      recruitDemand.setFlowState(RecruitDemand.flowState.AUDIT.valueStr()); // 提交操作 审核中状态
    }
    if (StringUtils.isEmpty(recruitDemand.getApplyDate())) { // 没有填写申请时间 默认为当前时间
      recruitDemand.setApplyDate(DataUtils.getDate("yyyy-MM-dd"));
    }
    if (StringUtils.hasText(recruitDemand.getId())) {
      try {
        recruitDemand.setUpdateDate(new Date()); // 修改时间
        recruitDemand.setModifiedId(sysUser.getId()); // 修改人
        if (typeStr.equals("XG")) {
          // 提交之后的修改只修改岗位工作描述和任职条件
          RecruitDemand recruitDemandOld =
              recruitDemandService.getByPrimaryKey(recruitDemand.getId());
          recruitDemandService.updateSelectiveSelf(recruitDemand, recruitDemandOld, sysUser);
        } else {
          // 暂存状态下的修改
          recruitDemandService.updateSelective(recruitDemand, sysUser);
        }
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        recruitDemand.setId(UUID.randomUUID().toString().replace("-", ""));
        recruitDemand.setDutyPersonId(sysUser.getWorkCode() == null ? "0000" : sysUser
            .getWorkCode()); // 负责人员工编号（无法取值设置为0000）
        recruitDemand.setDemandId(UUID.randomUUID().toString().replace("-", ""));// 招聘流程ID
        recruitDemand.setCreateDate(new Date()); // 创建世间
        recruitDemand.setCreatorId(sysUser.getId()); // 创建人
        recruitDemand.setInfoState(RecruitDemand.infoState.DRAFT.valueStr()); // 默认草稿招聘状态
        recruitDemand.setIsFinish(RecruitDemand.isFinish.NOTFINISHED.valueStr()); // 默认招聘需求未完成流程状态
        recruitDemandService.create(recruitDemand, sysUser);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * 导出招聘需求
   * 
   * @param sysUser
   * @param request
   * @param response
   */
  @RequestMapping("exportDemand")
  @ResponseBody
  public void exportDemand(@CurrentUser SysUser sysUser, HttpServletRequest request,
      HttpServletResponse response) {
    String searchKey = request.getParameter("searchKey");
    String stateSelf = request.getParameter("stateSelf"); // 列表查询状态
    String postId = request.getParameter("postId"); // 岗位id
    String postName = request.getParameter("postName"); // 岗位id
    String rankId = request.getParameter("rankId"); // 岗位id
    Map<String, String> searchMap = new HashMap<String, String>();
    String flowState = request.getParameter("flowState"); // 流程状态
    String isShare = request.getParameter("isShare"); // 是否共承
    String startDistributeDate = request.getParameter("startDistributeDate"); // 预计到到岗时间 开始
    String endDistributeDate = request.getParameter("endDistributeDate"); // 预计到岗时间 结束
    String orgCode = request.getParameter("orgCode"); // 部门code
    searchMap.put("orgCode", orgCode);
    searchMap.put("flowState", flowState);
    searchMap.put("isShare", isShare);
    searchMap.put("startDistributeDate", startDistributeDate);
    searchMap.put("endDistributeDate", endDistributeDate);
    searchMap.put("searchKey", searchKey);
    searchMap.put("stateSelf", stateSelf);
    searchMap.put("postId", postId);
    searchMap.put("postName", postName);
    searchMap.put("rankId", rankId);
    searchMap.put("userId", sysUser.getId());
    searchMap.put("userCode", sysUser.getWorkCode());
    MiniRtn2Grid<RecruitDemandVo> grid =
        recruitDemandService.getGrid(new MiniGridPageSort(), searchMap);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
    String fileName = "exportDemand" + sdf.format(new Date()) + ".xls";
    String xmlPath = "excelTemplate/recruitDemandExportTemplate.xml";
    String templatePath = "excelTemplate/recruitDemandExportTemplate.xls";
    for (RecruitDemandVo item : grid.getData()) {
      item.setFlowStateStr(RecruitDemandVo.getFlowStateStr(Integer.valueOf(item.getFlowState())));
      item.setInfoStateStr(RecruitDemandVo.getInfoStateStr(Integer.valueOf(item.getInfoState())));
    }
    commonService.exportByTemplate(response, fileName, grid.getData(), xmlPath, templatePath);
  }
}
