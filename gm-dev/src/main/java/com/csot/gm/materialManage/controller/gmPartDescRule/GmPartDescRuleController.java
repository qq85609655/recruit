package com.csot.gm.materialManage.controller.gmPartDescRule;

import com.csot.gm.materialManage.model.original.gmPartDescRule.GmPartDescRule;
import com.csot.gm.materialManage.service.gmPartDescRule.GmPartDescRuleService;

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
@RequestMapping("gmPartDescRule/gmPartDescRule")
public class GmPartDescRuleController {
  private static final Logger logger = LoggerFactory.getLogger(GmPartDescRuleController.class);

  @Resource
  private GmPartDescRuleService gmPartDescRuleService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/gmPartDescRule/gmPartDescRuleList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<GmPartDescRule>
      datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return gmPartDescRuleService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/gmPartDescRule/gmPartDescRuleEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    GmPartDescRule gmPartDescRule = gmPartDescRuleService.getByPrimaryKey(id);
    request.setAttribute("gmPartDescRule", gmPartDescRule);
    return new ModelAndView("com/csot/gm/materialManage/gmPartDescRule/gmPartDescRuleEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    GmPartDescRule gmPartDescRule = gmPartDescRuleService.getByPrimaryKey(id);
    request.setAttribute("gmPartDescRule", gmPartDescRule);
    return new ModelAndView("com/csot/gm/materialManage/gmPartDescRule/gmPartDescRuleView");
  }

  /**
   * remove object by id.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      gmPartDescRuleService.remove(id);
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
  public AjaxRtnJson save(GmPartDescRule gmPartDescRule) {
    if (StringUtils.isEmpty(gmPartDescRule.getId())) {
      try {
        gmPartDescRuleService.create(gmPartDescRule);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        gmPartDescRuleService.updateSelective(gmPartDescRule);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }
}