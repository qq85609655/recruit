package com.csot.gm.materialManage.controller.propertiesM;

import java.util.List;

import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.model.original.propertiesM.PropertiesM;
import com.csot.gm.materialManage.service.gmlog.LogService;
import com.csot.gm.materialManage.service.properties.PartPropertiesService;
import com.csot.gm.materialManage.service.propertiesM.PropertiesMService;
import com.csot.gm.rawMaterial.model.PartClassTree;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("propertiesM")
public class PropertiesMController {
  private static final Logger logger = LoggerFactory.getLogger(PropertiesMController.class);

  @Resource
  private PropertiesMService propertiesMService;
  @Resource
  private PartPropertiesService partPropertiesService;
  @Resource
  private LogService logService;

  /**
   * Forward to propertyEnumTypeEdit page. 跳转到属性的枚举类编辑页面
   */
  @RequestMapping("propertyEnumTypeEdit/{proId}")
  public ModelAndView propertyEnumTypeEdit(@PathVariable String proId, HttpServletRequest request) {
    List<PropertiesMExt> pmList = propertiesMService.getByPropertyId(proId);
    String enumTypeId = "";
    if (!pmList.isEmpty()) {
      enumTypeId = pmList.get(0).getEnumId();
    }
    String propertyName = partPropertiesService.getByPrimaryKey(proId).getPropertyDisName();
    request.setAttribute("enumTypeId", enumTypeId);
    request.setAttribute("propertyId", proId);
    request.setAttribute("propertyName", propertyName);
    return new ModelAndView("com/csot/gm/materialManage/propertiesM/propertyEnumTypeEdit");
  }

  /**
   * update property's enumType. 更新属性的枚举类
   */
  @RequestMapping("updatePropertyEnumType/enumTypeId/{enumTypeId}/propertyId/{propertyId}")
  @ResponseBody
  public AjaxRtnJson updatePropertyEnumType(@PathVariable String propertyId,
      @PathVariable String enumTypeId, @CurrentUser SysUser sysUser) {
    try {
      // 更新属性对应的枚举类
      logService.logPropertyMap(sysUser, propertyId, enumTypeId, "更新");
      propertiesMService.updateEnumTypeByPropertyId(enumTypeId, propertyId);
      return new AjaxRtnJson(true, "更新成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "更新失败: 该枚举类不存在。 ");
    }
  }

  /**
   * Get enumTypeDatagrid. 返回枚举类列表供编辑选择
   */
  @RequestMapping("enumTypeList")
  @ResponseBody
  public List<PartClassTree> enumTypeList() {
    return propertiesMService.getEnumTypeList();
  }

  /**
   * Forward to list page. 暂不使用此方法
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/propertiesM/propertiesMList");
  }

  /**
   * Get datagrid. 暂不使用此方法
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<PropertiesM> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return propertiesMService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page. 暂不使用此方法
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/propertiesM/propertiesMEdit");
  }

  /**
   * Forward to modify page. 暂不使用此方法
   */
  @RequiresPermissions("enum:modifyPropertyMap")
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    PropertiesM propertiesM = propertiesMService.getByPrimaryKey(id);
    request.setAttribute("propertiesM", propertiesM);
    return new ModelAndView("com/csot/gm/materialManage/propertiesM/propertiesMEdit");
  }

  /**
   * Forward to view page. 暂不使用此方法
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    PropertiesM propertiesM = propertiesMService.getByPrimaryKey(id);
    request.setAttribute("propertiesM", propertiesM);
    return new ModelAndView("com/csot/gm/materialManage/propertiesM/propertiesMView");
  }

  /**
   * remove object by id. 暂不使用此方法
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      propertiesMService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * Save object: create or update 暂不使用此方法
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(PropertiesM propertiesM) {
    if (StringUtils.isEmpty(propertiesM.getId())) {
      try {
        propertiesMService.create(propertiesM);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        propertiesMService.updateSelective(propertiesM);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }
}
