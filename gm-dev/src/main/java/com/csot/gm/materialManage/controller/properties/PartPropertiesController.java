package com.csot.gm.materialManage.controller.properties;

import com.csot.gm.materialManage.model.original.properties.PartProperties;
import com.csot.gm.materialManage.service.part.PartService;
import com.csot.gm.materialManage.service.properties.PartPropertiesService;

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
@RequestMapping("partProperties")
public class PartPropertiesController {
  private static final Logger logger = LoggerFactory.getLogger(PartPropertiesController.class);

  @Resource
  private PartPropertiesService partPropertiesService;
  @Resource
  private PartService partService;

  /**
   * Forward to list page.
   * 暂不使用此方法
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/properties/partPropertiesList");
  }

  /**
   * Get datagrid.
   * 暂不使用此方法
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<PartProperties>
      datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return partPropertiesService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   * 新增物料的属性
   */
  @RequestMapping("create/{partId}")
  public ModelAndView create(@PathVariable String partId, HttpServletRequest request) {
    String partName = partService.getByPrimaryKey(partId).getPartDesc();
    PartProperties pp = new PartProperties();
    pp.setPartId(partId);
    request.setAttribute("pp", pp);
    request.setAttribute("partName", partName);
    return new ModelAndView("com/csot/gm/materialManage/properties/partPropertiesEdit");
  }
  
  /**
   * Forward to addPropertyValue page.
   * 新增level3的历史料的属性值
   */
  @RequestMapping("addProValue/{partId}")
  public ModelAndView addProValue(@PathVariable String partId, HttpServletRequest request) {
    request.setAttribute("partId", partId);
    return new ModelAndView("com/csot/gm/materialManage/properties/addPropertiesValues");
  }

  /**
   * Forward to modify page.
   * 编辑物料属性
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    PartProperties partProperties = partPropertiesService.getByPrimaryKey(id);
    String partName = partService.getByPrimaryKey(partProperties.getPartId()).getPartDesc();
    request.setAttribute("partName", partName);
    request.setAttribute("pp", partProperties);
    return new ModelAndView("com/csot/gm/materialManage/properties/partPropertiesEdit");
  }

  /**
   * Forward to view page.
   * 暂不使用此方法
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    PartProperties partProperties = partPropertiesService.getByPrimaryKey(id);
    request.setAttribute("partProperties", partProperties);
    return new ModelAndView("com/csot/gm/materialManage/properties/partPropertiesView");
  }

  /**
   * remove object by id.
   * 删除物料属性
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      partPropertiesService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * Save object: create or update
   * 保存新增或者更新的物料属性
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(PartProperties partProperties) {
    if (StringUtils.isEmpty(partProperties.getId())) {
      try {
        partPropertiesService.create(partProperties);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        partPropertiesService.updateSelective(partProperties);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }
}