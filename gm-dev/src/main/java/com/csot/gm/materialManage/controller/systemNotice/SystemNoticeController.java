package com.csot.gm.materialManage.controller.systemNotice;

import java.util.Date;

import com.csot.gm.materialManage.model.original.systemNotice.SystemNotice;
import com.csot.gm.materialManage.service.systemNotice.SystemNoticeService;

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
@RequestMapping("systemNotice")
public class SystemNoticeController {
  private static final Logger logger = LoggerFactory.getLogger(SystemNoticeController.class);

  @Resource
  private SystemNoticeService systemNoticeService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/systemNotice/systemNoticeList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<SystemNotice> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return systemNoticeService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/systemNotice/systemNoticeEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    SystemNotice systemNotice = systemNoticeService.getByPrimaryKey(id);
    byte[] tt = systemNotice.getNoticeContents();
    String contents = new String(tt);
    contents = com.csot.gm.util.StringUtils.replaceBlank(contents);
    request.setAttribute("contents", contents);
    request.setAttribute("systemNotice", systemNotice);
    return new ModelAndView("com/csot/gm/materialManage/systemNotice/systemNoticeEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    SystemNotice systemNotice = systemNoticeService.getByPrimaryKey(id);
    request.setAttribute("systemNotice", systemNotice);
    return new ModelAndView("com/csot/gm/materialManage/systemNotice/systemNoticeView");
  }

  /**
   * remove object by id.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      systemNoticeService.remove(id);
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
  public AjaxRtnJson save(SystemNotice systemNotice) {
    systemNotice.setUpdateTime(new Date());
    systemNotice.setIsActive("1");
    if (StringUtils.isEmpty(systemNotice.getId())) {
      try {
        systemNoticeService.create(systemNotice);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        systemNoticeService.updateSelective(systemNotice);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }
}