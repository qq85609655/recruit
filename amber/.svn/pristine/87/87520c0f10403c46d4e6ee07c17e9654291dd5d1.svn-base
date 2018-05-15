package org.amberframework.web.system.auth.controller.role;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.role.SysGroupRole;
import org.amberframework.web.system.auth.model.original.role.SysRole;
import org.amberframework.web.system.auth.service.role.SysGroupRoleService;
import org.apache.shiro.util.StringUtils;
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
@RequestMapping("auth/role/sysGroupRole")
public class SysGroupRoleController {
  private static final Logger logger = LoggerFactory.getLogger(SysGroupRoleController.class);
  private static final GsonBuilder gsonBuilder = new GsonBuilder();
  private static final Gson gson;

  static {
    gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  }

  @Resource
  private SysGroupRoleService sysGroupRoleService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("org/amberframework/web/system/auth/controller/role/sysGroupRoleList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<SysGroupRole> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return sysGroupRoleService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("org/amberframework/web/system/auth/controller/role/sysGroupRoleEdit");
  }

  /**
   * 转到修改页面.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    SysGroupRole sysGroupRole = sysGroupRoleService.getByPrimaryKey(id);
    request.setAttribute("sysGroupRole", sysGroupRole);
    return new ModelAndView("org/amberframework/web/system/auth/controller/role/sysGroupRoleEdit");
  }

  /**
   * 转到查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    SysGroupRole sysGroupRole = sysGroupRoleService.getByPrimaryKey(id);
    request.setAttribute("sysGroupRole", sysGroupRole);
    return new ModelAndView("org/amberframework/web/system/auth/controller/role/sysGroupRoleView");
  }

  /**
   * 删除组角色.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      sysGroupRoleService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 保存组角色.
   */
  @RequestMapping("save/groupId/{groupId}")
  @ResponseBody
  public AjaxRtnJson save(@PathVariable Long groupId, String json) {
    if (null == json) {
      return new AjaxRtnJson(false, "修改失败:提交内容为空");
    }
    
    List<SysRole> sysRoleList = gson.fromJson(json, new TypeToken<List<SysRole>>() {}.getType());
    if (null != sysRoleList) {
      try {
        sysGroupRoleService.updateGroupRoles(groupId, sysRoleList);
        return new AjaxRtnJson(true, "修改成功");
      } catch (DataAccessException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
    return new AjaxRtnJson(true, "修改成功，<br>没有角色！");
  }

  @RequestMapping("groupRoles/groupId/{groupId}")
  @ResponseBody
  public List<SysRole> groupMembers(@PathVariable Long groupId) {
    return sysGroupRoleService.getGroupRoles(groupId);
  }

  /**
   * 返回组的角色信息列表.
   */
  @RequestMapping("groupRoles")
  @ResponseBody
  public List<SysRole> groupMembers(String groupId) {
    if (StringUtils.hasText(groupId)) {
      return sysGroupRoleService.getGroupRoles(Long.parseLong(groupId));
    } else {
      return new ArrayList<SysRole>();
    }
  }
}
