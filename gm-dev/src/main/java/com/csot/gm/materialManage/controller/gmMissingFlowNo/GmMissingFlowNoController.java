package com.csot.gm.materialManage.controller.gmMissingFlowNo;

import com.csot.gm.materialManage.model.original.gmMissingFlowNo.GmMissingFlowNo;
import com.csot.gm.materialManage.service.gmMissingFlowNo.GmMissingFlowNoService;

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
@RequestMapping("gmMissingFlowNo/gmMissingFlowNo")
public class GmMissingFlowNoController {
  private static final Logger logger = LoggerFactory.getLogger(GmMissingFlowNoController.class);

  @Resource
  private GmMissingFlowNoService gmMissingFlowNoService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/gmMissingFlowNo/gmMissingFlowNoList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<GmMissingFlowNo> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return gmMissingFlowNoService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/gmMissingFlowNo/gmMissingFlowNoEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    GmMissingFlowNo gmMissingFlowNo = gmMissingFlowNoService.getByPrimaryKey(id);
    request.setAttribute("gmMissingFlowNo", gmMissingFlowNo);
    return new ModelAndView("com/csot/gm/materialManage/gmMissingFlowNo/gmMissingFlowNoEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    GmMissingFlowNo gmMissingFlowNo = gmMissingFlowNoService.getByPrimaryKey(id);
    request.setAttribute("gmMissingFlowNo", gmMissingFlowNo);
    return new ModelAndView("com/csot/gm/materialManage/gmMissingFlowNo/gmMissingFlowNoView");
  }

  /**
   * remove object by id.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      gmMissingFlowNoService.remove(id);
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
  public AjaxRtnJson save(GmMissingFlowNo gmMissingFlowNo) {
    if (StringUtils.isEmpty(gmMissingFlowNo.getId())) {
      try {
        gmMissingFlowNoService.create(gmMissingFlowNo);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        gmMissingFlowNoService.updateSelective(gmMissingFlowNo);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }
}