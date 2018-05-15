package com.csot.gm.rawMaterial.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csot.gm.materialManage.model.extension.properties.PartPropertiesExt;
import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.model.original.partNo.PartNo;
import com.csot.gm.materialManage.service.gmlog.LogService;
import com.csot.gm.materialManage.service.part.PartService;
import com.csot.gm.materialManage.service.partClass.PartClassService;
import com.csot.gm.materialManage.service.partNo.PartNoService;
import com.csot.gm.materialManage.service.properties.PartPropertiesService;
import com.csot.gm.materialManage.service.propertiesM.PropertiesMService;
import com.csot.gm.materialManage.service.userInfo.UserInfoService;
import com.csot.gm.rawMaterial.model.PageRtn;
import com.csot.gm.rawMaterial.model.PartClassTree;
import com.csot.gm.rawMaterial.model.PropertyCombo;
import com.csot.gm.rawMaterial.model.Result4CheckPartType;
import com.csot.gm.rawMaterial.model.UserInfo;
import com.csot.gm.rawMaterial.service.CheckProAndCreateService;
import com.csot.gm.rawMaterial.service.DataShowService;
import com.csot.gm.util.Status;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("rawMaterial")
public class RawMaterialController {

  private static final Logger logger = LoggerFactory.getLogger(RawMaterialController.class);

  @Resource
  private PartService partService;
  @Resource
  private PropertiesMService propertiesMService;
  @Resource
  private DataShowService dataShowService;
  @Resource
  private PartPropertiesService partPropertiesService;
  @Resource
  private CheckProAndCreateService checkProAndCreateService;
  @Resource
  private PartClassService partClassService;
  @Resource
  private PartNoService partNoService;
  @Resource
  private UserInfoService userInfoService;
 
  /**
   * 跳转到物料属性页面
   * 
   * @param partId
   * @param uid
   * @param request
   * @return
   */
  @RequestMapping("propertyInfo/partId/{partId}/uid/{uid}/partType/{partType}/userCode/{userCode}/ppId/{ppId}")
  public
      ModelAndView propertyInfo(@PathVariable String partId, @PathVariable String uid,
          @PathVariable String partType, @PathVariable String userCode, @PathVariable String ppId,
          HttpServletRequest request) {

    if (!"C4".equals(partType) && !"C4_WXLH".equals(partType)) {
      // 判断所选分类是不是PLM传过来的partType
      Result4CheckPartType isPartType = partService.checkIsPLMType(partId, partType);
      if (!isPartType.isPLMPartType()) {
        request.setAttribute("partType", partType);
        request.setAttribute("uid", uid);
        if ("".equals(isPartType.getPartType())) {
          request.setAttribute("info", "MDM没有找到对应的物料类型");
          return new ModelAndView("com/csot/gm/noPartType");
        } else {
          request.setAttribute("partTypeDisName", isPartType.getPartType());
          return new ModelAndView("com/csot/gm/partTypeError");
        }
      }
    }

    String preCode = partService.getByPrimaryKey(partId).getPartPrefixCode();
    String partName = partService.getByPrimaryKey(partId).getPartDesc();
    String pageAddr = partService.getByPrimaryKey(partId).getPartUrl();
    String class1Name = "";
    String class2Name = "";
    if (null != ppId && !",".equals(ppId)) {
      String[] classId = ppId.split(",");
      if (classId != null && classId.length > 1) {
        class1Name = partClassService.getByPrimaryKey(classId[0]).getClassDesc();
        class2Name = partClassService.getByPrimaryKey(classId[1]).getClassDesc();
      }
    }
    // 根据partId获取该物料属性id的list
    List<PartPropertiesExt> list = partPropertiesService.getByPartId(partId);
    if (!list.isEmpty()) {
      for (int i = 0; i < list.size(); i++) {
        String propertyId = list.get(i).getId();
        String propertyName = list.get(i).getPropertyName();
        String isEnum = list.get(i).getIsEnum();
        if (isEnum.equals(Status.IS_ENUM)) {
          List<PropertiesMExt> listM = propertiesMService.getByPropertyId(propertyId);
          if (!listM.isEmpty()) {
            String propertyEnumTypeId = listM.get(0).getEnumId();
            // 将所有属性枚举类Id传给前台，以便获取属性的下拉值
            request.setAttribute(propertyName + "EnumTypeId", propertyEnumTypeId);
          }
        }
      }
    }

    // 根据工号查出创建人信息传到页面
    UserInfo user = userInfoService.getByUserCode(userCode);
    request.setAttribute("userCode", user.getUserCode());
    request.setAttribute("userName", user.getUserName());
    request.setAttribute("department", user.getDepartment());
    request.setAttribute("telephone", user.getTelephone());

    request.setAttribute("preCode", preCode);
    request.setAttribute("partId", partId);
    request.setAttribute("classId", ppId);
    request.setAttribute("partName", partName);
    request.setAttribute("class1Name", class1Name);
    request.setAttribute("class2Name", class2Name);
    request.setAttribute("uid", uid);
    logger.info("3+uid：" + uid);
    request.setAttribute("partType", partType);
    return new ModelAndView(pageAddr);
  }

  /**
   * 检查属性唯一性及生成料号和物料描述
   * 
   * @param pageRtn
   * @return
   */
  @RequestMapping("checkProAndCreate")
  @ResponseBody
  public AjaxRtnJson checkProAndCreate(PageRtn pageRtn) {

    AjaxRtnJson ajax = new AjaxRtnJson();
    ajax.setSuccess(true);
    if ("C4_SparePart".equals(pageRtn.getPartType())
        || "C4_Consumptive".equals(pageRtn.getPartType())) {
      ajax = checkProAndCreateService.checkMassAndSingle(null, ajax, pageRtn);
    } else {
      ajax = checkProAndCreateService.checkProAndCreate(ajax, pageRtn);
    }
    // 让用户等1秒，保证数据库事物提交完毕
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      logger.error(e.getMessage(), e);
    }
    return ajax;
  }


  /**
   * 物料分类树
   * 
   * @param request
   * @param response
   */
  @RequestMapping("partClassTree")
  public void partClassTree(HttpServletRequest request, HttpServletResponse response) {
    String partType = request.getParameter("partType");
    List<PartClassTree> list = dataShowService.getPartClassData(partType);
    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
    String treeJson = gson.toJson(list);
    response.setContentType("application/json");
    response.setHeader("Cache-Control", "no-store");
    PrintWriter pw;
    try {
      pw = response.getWriter();
      pw.write(treeJson);
      pw.flush();
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    }
  }

  
  /**
   * 获取属性的下拉值
   * 
   * @param request
   * @return
   */
  @RequestMapping("getComboData")
  @ResponseBody
  public List<PropertyCombo> getComboData(HttpServletRequest request) {
    String enumTypeId = request.getParameter("enumTypeId");
    return dataShowService.getComboData(enumTypeId);
  }

  @RequestMapping("rawMaterial")
  public ModelAndView rawMaterial(HttpServletRequest request) {
    String uid = request.getParameter("uid");
    String partType = request.getParameter("partType");
    String userCode = request.getParameter("userCode");
    if (null == userCode || "".equals(userCode)) {
      userCode = "KeyIn";
    }
    logger.info("1+uid：" + uid);
    if (null == uid || "".equals(uid)) {
      uid = UUID.randomUUID().toString().replace("-", "");
    }
    if (null == partType || "".equals(partType)) {
      partType = "C4";
    }
    logger.info("2+uid：" + uid + "partType:" + partType);
    request.setAttribute("partType", partType);
    request.setAttribute("uid", uid);
    request.setAttribute("userCode", userCode);
    return new ModelAndView("com/csot/gm/rawMaterial/rawMaterial");
  }

  @RequestMapping("createComplete")
  public ModelAndView createComplete() {
    return new ModelAndView("com/csot/gm/finishSuccess");
  }

  @RequestMapping("finishFail")
  public ModelAndView finishFail() {
    return new ModelAndView("com/csot/gm/finishFail");
  }

  @RequestMapping("getAllSpareConsumptivePartNo")
  @ResponseBody
  public MiniRtn2Grid<PartNo> getAllSpareConsumptivePartNo(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String partType = request.getParameter("partType");
    return partNoService.getAllSpareConsumptive(pageSort, partType);
  }

  /**
   * 检查并生成维修料号
   * 
   * @param oldNumberId
   * @param wxlh
   * @return
   */
  @RequestMapping("checkMaintainAndCreate/oldNumberId/{oldNumberId}/wxlh/{wxlh}")
  @ResponseBody
  public AjaxRtnJson checkMaintainAndCreate(PageRtn pageRtn, @PathVariable String oldNumberId,
      @PathVariable String wxlh) {

    AjaxRtnJson ajax = new AjaxRtnJson();
    ajax.setSuccess(true);
    ajax = checkProAndCreateService.checkMaintainAndCreate(ajax, oldNumberId, wxlh, pageRtn);
    // 让用户等1秒，保证数据库事物提交完毕
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      logger.error(e.getMessage(), e);
    }
    return ajax;
  }

  @RequestMapping("createConsumptive72")
  @ResponseBody
  public AjaxRtnJson createConsumptive72(PageRtn pageRtn) {
    AjaxRtnJson ajax = new AjaxRtnJson();
    ajax.setSuccess(true);
    ajax = checkProAndCreateService.createConsumptive72(ajax, pageRtn);
    // 让用户等1秒，保证数据库事物提交完毕
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      logger.error(e.getMessage(), e);
    }
    return ajax;
  }

  /**
   * OA签核时请求查看料号属性值信息
   * 
   * @param request
   * @return
   */
  @RequestMapping("propertyValueDetail")
  public ModelAndView propertyValueDetail(HttpServletRequest request) {
    String partNo = request.getParameter("partNo");
    logger.info("partNo：" + partNo);
    String partNoId = partNoService.getIdByPartNo(partNo);
    request.setAttribute("partNoId", partNoId);
    return new ModelAndView("com/csot/gm/materialManage/propertyInfo4OA");
  }

}
