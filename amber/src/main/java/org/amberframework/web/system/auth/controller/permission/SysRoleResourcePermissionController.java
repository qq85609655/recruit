package org.amberframework.web.system.auth.controller.permission;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.permission.SysPermission;
import org.amberframework.web.system.auth.model.original.permission.SysRoleResourcePermission;
import org.amberframework.web.system.auth.service.permission.SysRoleResourcePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

@Controller
@RequestMapping("auth/permission/sysRoleResourcePermission")
public class SysRoleResourcePermissionController {
  private static final Logger logger = LoggerFactory
      .getLogger(SysRoleResourcePermissionController.class);
  private static final GsonBuilder gsonBuilder = new GsonBuilder();
  private static final Gson gson;

  static {
    gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  }

  @Resource
  private SysRoleResourcePermissionService sysRoleResourcePermissionService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView(
        "org/amberframework/web/system/auth/permission/sysRoleResourcePermissionList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<SysRoleResourcePermission> datagrid(MiniGridPageSort pageSort,
      HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return sysRoleResourcePermissionService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView(
        "org/amberframework/web/system/auth/permission/sysRoleResourcePermissionEdit");
  }

  /**
   * 根据roleId和resourceId转到编辑页面.
   */
  @RequestMapping("modify/roleId/{roleId}/resourceId/{resourceId}")
  public ModelAndView modify(@PathVariable Long roleId, @PathVariable Long resourceId) {
    ModelAndView mav =
        new ModelAndView("org/amber/system/auth/permission/sysRoleResourcePermissionEdit");
    mav.addObject("roleId", roleId);
    mav.addObject("resourceId", resourceId);
    return mav;
  }

  /**
   * 转到查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    SysRoleResourcePermission sysRoleResourcePermission =
        sysRoleResourcePermissionService.getByPrimaryKey(id);
    request.setAttribute("sysRoleResourcePermission", sysRoleResourcePermission);
    return new ModelAndView(
        "org/amberframework/web/system/auth/permission/sysRoleResourcePermissionView");
  }

  /**
   * 删除角色的资源权限.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      sysRoleResourcePermissionService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 保存角色的资源权限.
   */
  @RequestMapping("save/roleId/{roleId}/resourceId/{resourceId}")
  @ResponseBody
  public AjaxRtnJson save(@PathVariable Long roleId, @PathVariable Long resourceId, String json) {
    if (null == json) {
      return new AjaxRtnJson(false, "修改失败:提交内容为空");
    }

    List<SysPermission> sysPermissionList =
        gson.fromJson(json, new TypeToken<List<SysPermission>>() {}.getType());
    if (null != sysPermissionList) {
      try {
        sysRoleResourcePermissionService.updateRoleResourcePerms(roleId, resourceId,
            sysPermissionList);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
    return new AjaxRtnJson(true, "修改成功，<br>没有权限！");
  }

  @RequestMapping("roleResourcePerms/roleId/{roleId}/resourceId/{resourceId}")
  @ResponseBody
  public List<SysPermission> getRoleResourcePerms(@PathVariable Long roleId,
      @PathVariable Long resourceId) {
    return sysRoleResourcePermissionService.getRoleResourcePerms(roleId, resourceId);
  }
}
