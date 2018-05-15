package com.csot.gm.materialManage.controller.gmPartNoPrecode;

import com.csot.gm.materialManage.model.original.gmPartNoPrecode.GmPartNoPrecode;
import com.csot.gm.materialManage.service.gmPartNoPrecode.GmPartNoPrecodeService;

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
@RequestMapping("gmPartNoPrecode/gmPartNoPrecode")
public class GmPartNoPrecodeController {
  private static final Logger logger = LoggerFactory.getLogger(GmPartNoPrecodeController.class);

  @Resource
  private GmPartNoPrecodeService gmPartNoPrecodeService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/gmPartNoPrecode/gmPartNoPrecodeList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<GmPartNoPrecode> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return gmPartNoPrecodeService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/gmPartNoPrecode/gmPartNoPrecodeEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    GmPartNoPrecode gmPartNoPrecode = gmPartNoPrecodeService.getByPrimaryKey(id);
    request.setAttribute("gmPartNoPrecode", gmPartNoPrecode);
    return new ModelAndView("com/csot/gm/materialManage/gmPartNoPrecode/gmPartNoPrecodeEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    GmPartNoPrecode gmPartNoPrecode = gmPartNoPrecodeService.getByPrimaryKey(id);
    request.setAttribute("gmPartNoPrecode", gmPartNoPrecode);
    return new ModelAndView("com/csot/gm/materialManage/gmPartNoPrecode/gmPartNoPrecodeView");
  }

  /**
   * remove object by id.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      gmPartNoPrecodeService.remove(id);
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
  public AjaxRtnJson save(GmPartNoPrecode gmPartNoPrecode) {
    if (StringUtils.isEmpty(gmPartNoPrecode.getId())) {
      try {
        gmPartNoPrecodeService.create(gmPartNoPrecode);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        gmPartNoPrecodeService.updateSelective(gmPartNoPrecode);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }
}