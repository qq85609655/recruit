package com.csot.gm.materialManage.controller.clean;

import com.csot.gm.materialManage.model.original.clean.Clean;
import com.csot.gm.materialManage.service.clean.CleanService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@RequestMapping("clean")
public class CleanController {
  private static final Logger logger = LoggerFactory.getLogger(CleanController.class);

  @Resource
  private CleanService cleanService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/clean/cleanList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<Clean> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return cleanService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/clean/cleanEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    Clean clean = cleanService.getByPrimaryKey(id);
    request.setAttribute("clean", clean);
    return new ModelAndView("com/csot/gm/materialManage/clean/cleanEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    Clean clean = cleanService.getByPrimaryKey(id);
    request.setAttribute("clean", clean);
    return new ModelAndView("com/csot/gm/materialManage/clean/cleanView");
  }

  /**
   * remove object by id.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      String[] ids = id.split(",");
      if (null != ids && ids.length > 0) {
        for (int i = 0; i < ids.length; i++) {
          cleanService.remove(ids[i]);
        }
      }
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
  public AjaxRtnJson save(Clean clean) {
    if (StringUtils.isEmpty(clean.getId())) {
      try {
        cleanService.create(clean);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        cleanService.updateSelective(clean);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }
  
  /**
   * export
   */
  @RequestMapping("exportClean")
  @ResponseBody
  public void exportClean(HttpServletResponse response) {
    try {
      cleanService.exportClean(response);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
    }
  }
}