package com.csot.gm.materialManage.controller.gmPartDescRuleMap;

import com.csot.gm.materialManage.model.original.gmPartDescRuleMap.GmPartDescRuleMap;
import com.csot.gm.materialManage.service.gmPartDescRuleMap.GmPartDescRuleMapService;

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
@RequestMapping("gmPartDescRuleMap/gmPartDescRuleMap")
public class GmPartDescRuleMapController {
  private static final Logger logger = LoggerFactory.getLogger(GmPartDescRuleMapController.class);

  @Resource
  private GmPartDescRuleMapService gmPartDescRuleMapService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/gmPartDescRuleMap/gmPartDescRuleMapList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<GmPartDescRuleMap> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return gmPartDescRuleMapService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/gmPartDescRuleMap/gmPartDescRuleMapEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    GmPartDescRuleMap gmPartDescRuleMap = gmPartDescRuleMapService.getByPrimaryKey(id);
    request.setAttribute("gmPartDescRuleMap", gmPartDescRuleMap);
    return new ModelAndView("com/csot/gm/materialManage/gmPartDescRuleMap/gmPartDescRuleMapEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    GmPartDescRuleMap gmPartDescRuleMap = gmPartDescRuleMapService.getByPrimaryKey(id);
    request.setAttribute("gmPartDescRuleMap", gmPartDescRuleMap);
    return new ModelAndView("com/csot/gm/materialManage/gmPartDescRuleMap/gmPartDescRuleMapView");
  }

  /**
   * remove object by id.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      gmPartDescRuleMapService.remove(id);
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
  public AjaxRtnJson save(GmPartDescRuleMap gmPartDescRuleMap) {
    if (StringUtils.isEmpty(gmPartDescRuleMap.getId())) {
      try {
        gmPartDescRuleMapService.create(gmPartDescRuleMap);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        gmPartDescRuleMapService.updateSelective(gmPartDescRuleMap);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }
}