package com.csot.gm.materialManage.controller.propertyValue;

import java.util.List;

import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;
import com.csot.gm.materialManage.service.propertyValue.PropertyValueService;
import com.csot.gm.rawMaterial.model.PropertyValueShow;
import com.csot.gm.rawMaterial.model.Result4UpdatePropertyValue;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("propertyValue")
public class PropertyValueController {
  private static final Logger logger = LoggerFactory.getLogger(PropertyValueController.class);

  @Resource
  private PropertyValueService propertyValueService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/propertyValue/propertyValueList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<PropertyValue>
      datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return propertyValueService.getGrid(pageSort, searchKey);
  }

  /**
   * 根据partNoId获取属性值
   * 
   * @param partNoId
   * @return
   */
  @RequestMapping("proValuedatagrid")
  @ResponseBody
  public List<PropertyValueShow> partNoProValuedatagrid(String partNoId) {
    return propertyValueService.getByPartNoId(partNoId);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/propertyValue/propertyValueEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    PropertyValue propertyValue = propertyValueService.getByPrimaryKey(id);
    request.setAttribute("propertyValue", propertyValue);
    return new ModelAndView("com/csot/gm/materialManage/propertyValue/propertyValueEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    PropertyValue propertyValue = propertyValueService.getByPrimaryKey(id);
    request.setAttribute("propertyValue", propertyValue);
    return new ModelAndView("com/csot/gm/materialManage/propertyValue/propertyValueView");
  }

  /**
   * remove object by id.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      propertyValueService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * Save object: create or update
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(PropertyValue propertyValue) {
    if (StringUtils.isEmpty(propertyValue.getId())) {
      try {
        propertyValueService.create(propertyValue);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        propertyValueService.updateSelective(propertyValue);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }


  /**
   * update propertyValue
   */
  @RequestMapping("update")
  @ResponseBody
  public AjaxRtnJson update(@RequestBody PropertyValue[] propertyValueList,
      @CurrentUser SysUser sysUser) {
    if (propertyValueList.length > 0) {
      Result4UpdatePropertyValue result =
          propertyValueService.isSuccessUpdatePartNoProValue(propertyValueList, sysUser);
      if (result.isResult()) {
        return new AjaxRtnJson(true, "保存成功！");
      } else {
        return new AjaxRtnJson(false, result.getMsg());
      }
    } else {
      return new AjaxRtnJson(false, "保存失败,无更新内容");
    }

  }

  /**
   * addHistoryDataPropertyValues.
   */
  @RequestMapping("addPropertyValues")
  @ResponseBody
  public AjaxRtnJson addPropertyValues(HttpServletRequest request) {
    String partId = request.getParameter("partId");
    String propertyName = request.getParameter("propertyName");
    String propertyValue = request.getParameter("propertyValue");
    try {
      boolean isSuccess = propertyValueService.addPropertyValues(partId, propertyName, propertyValue);
      if (isSuccess) {
        return new AjaxRtnJson(true, "更新成功");
      } else {
        return new AjaxRtnJson(false, "更新失败:更新数据有误 ");
      }
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "更新失败: " + e.getMessage());
    }
  }
}