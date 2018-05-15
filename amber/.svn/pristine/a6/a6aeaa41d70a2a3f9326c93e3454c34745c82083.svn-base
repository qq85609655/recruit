package org.amberframework.web.system.auth.controller.role;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.role.SysRole;
import org.amberframework.web.system.auth.service.role.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("auth/role/sysRole")
public class SysRoleController {
  private static final Logger logger = LoggerFactory.getLogger(SysRoleController.class);

  @Resource
  private SysRoleService sysRoleService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("org/amber/system/auth/role/sysRoleList");
  }

  /**
   * 返回角色列表信息.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<SysRole> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    String enabled = request.getParameter("enabled");
    // 查询所有状态，enabled传null
    return sysRoleService.getGrid(pageSort, searchKey, enabled);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("org/amber/system/auth/role/sysRoleEdit");
  }

  /**
   * 转到编辑页面.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    SysRole sysRole = sysRoleService.getByPrimaryKey(id);
    request.setAttribute("sysRole", sysRole);
    return new ModelAndView("org/amber/system/auth/role/sysRoleEdit");
  }

  /**
   * 转到查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    SysRole sysRole = sysRoleService.getByPrimaryKey(id);
    request.setAttribute("sysRole", sysRole);
    return new ModelAndView("org/amber/system/auth/role/sysRoleView");
  }

  /**
   * 删除角色.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      if (sysRoleService.hasGroupDependOnRole(id)) {
        return new AjaxRtnJson(false, "删除失败: 还有与此角色关联的组关系！");
      } else if (sysRoleService.hasResourceDependOnRole(id)) {
        return new AjaxRtnJson(false, "删除失败: 还有与此角色关联的资源（菜单）关系！");
      } else if (sysRoleService.hasPermissionDependOnRole(id)) {
        return new AjaxRtnJson(false, "删除失败: 还有与此角色关联的权限关系！");
      }
      
      sysRoleService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 保存角色信息.
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(SysRole sysRole) {
    if (null != sysRole.getId()) {
      try {
        sysRoleService.updateSelective(sysRole);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        sysRoleService.create(sysRole);
        return new AjaxRtnJson(true, "新建成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }
  
  /**
   * 转到角色授权和菜单访问页面.
   */
  @RequestMapping("roleAuthorizationList")
  public ModelAndView roleAuthorizationList() {
    return new ModelAndView("org/amber/system/auth/role/sysRoleAuthorizationList");
  }
}
