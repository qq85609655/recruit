package org.amberframework.web.system.auth.controller.permission;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.permission.SysPermission;
import org.amberframework.web.system.auth.service.permission.SysPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("auth/permission/sysPermission")
public class SysPermissionController {
  private static final Logger logger = LoggerFactory.getLogger(SysPermissionController.class);

  @Resource
  private SysPermissionService sysPermissionService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("org/amber/system/auth/permission/sysPermissionList");
  }

  /**
   * 返回权限信息列表.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<SysPermission> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    String enabled = request.getParameter("enabled");
    String resourceId = request.getParameter("resourceId");
    // 搜索全部状态，enabled传null
    return sysPermissionService.getGrid(pageSort, searchKey, enabled, resourceId);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("org/amber/system/auth/permission/sysPermissionEdit");
  }

  /**
   * 转到编辑页面.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    SysPermission sysPermission = sysPermissionService.getByPrimaryKey(id);
    request.setAttribute("sysPermission", sysPermission);
    return new ModelAndView("org/amber/system/auth/permission/sysPermissionEdit");
  }

  /**
   * 转到查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    SysPermission sysPermission = sysPermissionService.getByPrimaryKey(id);
    request.setAttribute("sysPermission", sysPermission);
    return new ModelAndView("org/amberframework/web/system/auth/controller/permission/sysPermissionView");
  }

  /**
   * 删除权限操作.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      if (sysPermissionService.hasDependencyOnRole(id)) {
        return new AjaxRtnJson(false, "删除失败: 还有与此权限关联的角色资源关系！");
      }
      
      sysPermissionService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 保存权限操作.
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(SysPermission sysPermission) {
    if (null != sysPermission.getId()) {
      try {
        sysPermissionService.updateSelective(sysPermission);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        sysPermissionService.create(sysPermission);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }
}