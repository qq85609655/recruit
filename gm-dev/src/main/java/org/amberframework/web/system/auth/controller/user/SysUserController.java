package org.amberframework.web.system.auth.controller.user;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.service.user.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("auth/user/sysUser")
public class SysUserController {
  private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
  
  private static final String RTN_SYS_USER_ATTR_NAME = "sysUser";

  @Resource
  private SysUserService sysUserService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("org/amber/system/auth/user/sysUserList");
  }

  /**
   * 返回用户列表信息.
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<SysUser> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    String status = request.getParameter("status");
    // 查询所有状态的，所以传null
    return sysUserService.getGrid(pageSort, searchKey, status);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("org/amber/system/auth/user/sysUserCreate");
  }

  /**
   * 转到编辑用户页面.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    SysUser sysUser = sysUserService.getByPrimaryKey(id);
    request.setAttribute(RTN_SYS_USER_ATTR_NAME, sysUser);
    return new ModelAndView("org/amber/system/auth/user/sysUserEdit");
  }

  /**
   * 转到用户修改密码页面.
   */
  @RequestMapping("changePassword/{id}")
  public ModelAndView changePassword(@PathVariable String id, HttpServletRequest request) {
    SysUser sysUser = sysUserService.getByPrimaryKey(id);
    request.setAttribute(RTN_SYS_USER_ATTR_NAME, sysUser);
    return new ModelAndView("org/amber/system/auth/user/sysUserChangePwd");
  }

  /**
   * 转到用户信息查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    SysUser sysUser = sysUserService.getByPrimaryKey(id);
    request.setAttribute(RTN_SYS_USER_ATTR_NAME, sysUser);
    return new ModelAndView("org/amberframework/web/system/auth/controller/user/sysUserView");
  }

  /**
   * 删除用户.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      sysUserService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 保存用户.
   */
  @RequestMapping("save")
  @ResponseBody
  public AjaxRtnJson save(SysUser sysUser) {
    if (!StringUtils.isEmpty(sysUser.getId())) {
      try {
        sysUserService.updateSelective(sysUser);
        return new AjaxRtnJson(true, "修改成功");
      } catch (RuntimeException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    } else {
      try {
        sysUser.setId(UUID.randomUUID().toString().replace("-", ""));
        sysUserService.create(sysUser);
        return new AjaxRtnJson(true, "新建成功");
      } catch (RuntimeException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "新建失败: " + e.getMessage());
      }
    }
  }

  /**
   * 保存密码.
   */
  @RequestMapping("savePassword")
  @ResponseBody
  public AjaxRtnJson savePassword(SysUser sysUser) {
    if (!StringUtils.isEmpty(sysUser.getId())) {
      if (StringUtils.isEmpty(sysUser.getPassword())) {
        return new AjaxRtnJson(false, "密码修改失败: 密码不能为空");
      }
      try {
        sysUserService.changePassword(sysUser.getId(), sysUser.getPassword());
        return new AjaxRtnJson(true, "密码修改成功");
      } catch (RuntimeException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "密码修改失败: " + e.getMessage());
      }
    } else {
      return new AjaxRtnJson(false, "密码修改失败: 不是有效账号");
    }
  }

  /**
   * 修改用户状态.
   */
  @RequestMapping("changeStatus/userId/{id}/status/{status}")
  @ResponseBody
  public AjaxRtnJson changeStatus(@PathVariable String id, @PathVariable String status) {
    try {
      sysUserService.changeStatus(id, status);
      return new AjaxRtnJson(true, "状态修改成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "状态修改失败: " + e.getMessage());
    }
  }
}
