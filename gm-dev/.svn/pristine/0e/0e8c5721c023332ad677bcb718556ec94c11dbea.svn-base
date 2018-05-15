package com.csot.gm.materialManage.controller.partClass;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csot.gm.materialManage.model.original.partClass.PartClass;
import com.csot.gm.materialManage.service.partClass.PartClassService;

@Controller
@RequestMapping("partClass")
public class PartClassController {
  private static final Logger logger = LoggerFactory.getLogger(PartClassController.class);

  @Resource
  private PartClassService partClassService;

  /**
   * Forward to list page.
   */
  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("com/csot/gm/materialManage/partClass/partClassList");
  }

  /**
   * Get datagrid.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<PartClass> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return partClassService.getGrid(pageSort, searchKey);
  }

  /**
   * Forward to create page.
   */
  @RequiresPermissions("partManage:createPartClass")
  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("com/csot/gm/materialManage/partClass/partClassEdit");
  }

  /**
   * Forward to modify page.
   */
  @RequiresPermissions("partManage:modifyPartClass")
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    PartClass partClass = partClassService.getByPrimaryKey(id);
    request.setAttribute("partClass", partClass);
    return new ModelAndView("com/csot/gm/materialManage/partClass/partClassEdit");
  }

  /**
   * Forward to view page.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    PartClass partClass = partClassService.getByPrimaryKey(id);
    request.setAttribute("partClass", partClass);
    return new ModelAndView("com/csot/gm/materialManage/partClass/partClassView");
  }

  /**
   * remove object by id.
   */
  @RequiresPermissions("partManage:removePartClass")
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      partClassService.remove(id);
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
  public AjaxRtnJson save(PartClass partClass) {
    if (StringUtils.isEmpty(partClass.getId())) {
      try {
        partClassService.create(partClass);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        partClassService.updateSelective(partClass);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }

  /**
   * 新增及修改level2信息
   * 
   * @param partClass
   * @return
   */
  @RequestMapping("saveLevel2")
  @ResponseBody
  public AjaxRtnJson saveLevel2(PartClass partClass) {
    if (StringUtils.isEmpty(partClass.getId())) {
      try {
        partClassService.createLevel2(partClass);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    } else {
      try {
        partClassService.updateSelective(partClass);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
  }

  /**
   * 跳转至level2新增界面
   * 
   * @param parentId
   * @param request
   * @return
   */
  // @RequiresPermissions("partManage:createPartClass")
  @RequestMapping("createLevel2/{parentId}")
  @ResponseBody
  public ModelAndView createLevel2(@PathVariable String parentId, HttpServletRequest request) {

    request.setAttribute("parentId", parentId);
    return new ModelAndView("com/csot/gm/materialManage/partClass/partLevel2Edit");
  }

  /**
   * 跳转至level3新增界面
   * 
   * @param parentId
   * @param request
   * @return
   */
  @RequestMapping("createLevel3/{parentId}")
  @ResponseBody
  public ModelAndView createLevel3(@PathVariable String parentId, HttpServletRequest request) {

    request.setAttribute("parentId", parentId);
    return new ModelAndView("com/csot/gm/materialManage/partClass/partLevel3Edit");
  }
}
