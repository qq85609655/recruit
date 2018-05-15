package com.csot.recruit.controller.campus;

import com.csot.recruit.model.original.campus.CampusSite;
import com.csot.recruit.model.original.campus.CampusTask;
import com.csot.recruit.service.campus.CampusSiteService;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.csot.recruit.service.campus.CampusTaskService;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
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
@RequestMapping("campusSiteController")
public class CampusSiteController {
  private static final Logger logger = LoggerFactory.getLogger(CampusSiteController.class);

  @Resource
  private CampusSiteService campusSiteService;
  @Resource
  private CampusTaskService campusTaskService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/campus/campusSiteList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<CampusSite> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String siteName = request.getParameter("siteName");
    String status = request.getParameter("status");
    return campusSiteService.getGrid(pageSort, siteName, status);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/recruit/campus/campusSiteEdit");
  }

  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    CampusSite campusSite = campusSiteService.getByPrimaryKey(id);
    request.setAttribute("campusSite", campusSite);
    return new ModelAndView("com/csot/recruit/campus/campusSiteEdit");
  }

  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    CampusSite campusSite = campusSiteService.getByPrimaryKey(id);
    request.setAttribute("campusSite", campusSite);
    return new ModelAndView("com/csot/recruit/campus/campusSiteView");
  }

  @RequestMapping("remove/{ids}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String ids) {
    try {
      int removeCount = 0;
      String[] idArr = ids.split(",");
      for (String id : idArr) {
        String siteId = campusSiteService.getByPrimaryKey(id).getSiteId();
        List<CampusTask> taskList = campusTaskService.getCampusTaskBySiteId(siteId);
        if (taskList.isEmpty()) {
          campusSiteService.remove(id);
          removeCount ++;
        } else {
          continue;
        }
      }      
      int failedCount = idArr.length - removeCount;     
      String msg = "成功删除" + removeCount + "个站点, " + failedCount + "个站点已在任务中，无法删除！";
      return new AjaxRtnJson(true, msg);
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(CampusSite campusSite) {
    if (StringUtils.hasText(campusSite.getId())) {
      try {
        campusSiteService.updateSelective(campusSite);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        campusSite.setId(UUID.randomUUID().toString().replace("-", ""));
        campusSiteService.create(campusSite);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * saveData
   * @param campusSiteArr
   * @return
   */
  @RequestMapping("saveData")
  @ResponseBody
  public AjaxRtnJson update(@RequestBody CampusSite[] campusSiteArr) {
    if (campusSiteArr.length > 0) {
      return campusSiteService.savaData(campusSiteArr);
    } else {
      return new AjaxRtnJson(false, "保存失败,无更新内容");
    }
  }

  /**
   * 跳转到站点状态更改页面
   * @return
   */
  @RequestMapping("editSiteStatus")
  public ModelAndView editSiteStatus() {
    return new ModelAndView("com/csot/campus/campusSiteStatusEdit");
  }

  /**
   * 对所选站点进行状态更改
   * @param ids
   * @return
   */
  @RequestMapping("updateStatus/{ids}")
  @ResponseBody
  public AjaxRtnJson updateStatus(@PathVariable String ids) {
    String[] idArr = ids.split(",");
    for (String id : idArr) {
      CampusSite site = campusSiteService.getByPrimaryKey(id);
      if (null == site) continue;
      if ("1".equals(site.getStatus())) {
        site.setStatus("0");
      } else {
        site.setStatus("1");
      }
      campusSiteService.updateSelective(site);
    }
    return new AjaxRtnJson(true, "成功更改" + idArr.length + "条站点状态");
  }
  
}
