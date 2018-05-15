package com.csot.gm.materialManage.controller.valueEnumM;

import com.csot.gm.materialManage.model.original.valueEnumM.ValueEnumM;
import com.csot.gm.materialManage.service.enumValue.EnumValueService;
import com.csot.gm.materialManage.service.valueEnumM.ValueEnumMService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
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
@RequestMapping("valueEnumM")
public class ValueEnumMController {
  private static final Logger logger = LoggerFactory.getLogger(ValueEnumMController.class);

  @Resource
  private ValueEnumMService valueEnumMService;
  @Resource
  private EnumValueService enumValueService;

  /**
   * Forward to valueEnumMEdit page.
   * 跳转到枚举值联动枚举类配置页面
   */
  @RequestMapping("valueEnumMEdit/{valueId}")
  public ModelAndView valueEnumMEdit(@PathVariable String valueId, HttpServletRequest request) {
    String valueText = enumValueService.getByPrimaryKey(valueId).getEnumText();
    request.setAttribute("valueText", valueText);
    request.setAttribute("valueId", valueId);
    return new ModelAndView("com/csot/gm/materialManage/valueEnumM/valueEnumMEdit");
  }
  
  /**
   * update value's enumType.
   * 更新下拉值的枚举类
   */
  @RequestMapping("updateValueEnumM/valueId/{valueId}/enumTypeId/{enumTypeId}")
  @ResponseBody
  public AjaxRtnJson
      updateValueEnumM(@PathVariable String valueId, @PathVariable String enumTypeId) {
    try {
      // 更新枚举值对应的枚举类
      valueEnumMService.updateValueEnumMByValueId(enumTypeId, valueId);
      return new AjaxRtnJson(true, "更新成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "更新失败: " + e.getMessage());
    }
  }
  
  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/valueEnumM/valueEnumMList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<ValueEnumM> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return valueEnumMService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/valueEnumM/valueEnumMEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    ValueEnumM valueEnumM = valueEnumMService.getByPrimaryKey(id);
    request.setAttribute("valueEnumM", valueEnumM);
    return new ModelAndView("com/csot/gm/materialManage/valueEnumM/valueEnumMEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    ValueEnumM valueEnumM = valueEnumMService.getByPrimaryKey(id);
    request.setAttribute("valueEnumM", valueEnumM);
    return new ModelAndView("com/csot/gm/materialManage/valueEnumM/valueEnumMView");
  }

  /**
   * remove object by id.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      valueEnumMService.remove(id);
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
  public AjaxRtnJson save(ValueEnumM valueEnumM) {
    if (StringUtils.isEmpty(valueEnumM.getId())) {
      try {
        valueEnumMService.create(valueEnumM);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        valueEnumMService.updateSelective(valueEnumM);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }
}