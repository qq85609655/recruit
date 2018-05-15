package org.amberframework.web.system.auth.controller.group;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.group.SysUserGroup;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.service.group.SysUserGroupService;
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
@RequestMapping("auth/group/sysUserGroup")
public class SysUserGroupController {
  private static final Logger logger = LoggerFactory.getLogger(SysUserGroupController.class);
  private static final GsonBuilder gsonBuilder = new GsonBuilder();
  private static final Gson gson;

  static {
    gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  }

  @Resource
  private SysUserGroupService sysUserGroupService;

  @RequestMapping("list")
  public ModelAndView list() {
    return new ModelAndView("org/amberframework/web/system/auth/controller/group/sysUserGroupList");
  }

  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid<SysUserGroup> datagrid(MiniGridPageSort pageSort, HttpServletRequest request) {
    String searchKey = request.getParameter("searchKey");
    return sysUserGroupService.getGrid(pageSort, searchKey);
  }

  @RequestMapping("create")
  public ModelAndView create() {
    return new ModelAndView("org/amberframework/web/system/auth/controller/group/sysUserGroupEdit");
  }

  /**
   * 转到编辑页面.
   */
  @RequestMapping("modify/{id}")
  public ModelAndView modify(@PathVariable String id, HttpServletRequest request) {
    SysUserGroup sysUserGroup = sysUserGroupService.getByPrimaryKey(id);
    request.setAttribute("sysUserGroup", sysUserGroup);
    return new ModelAndView("org/amberframework/web/system/auth/controller/group/sysUserGroupEdit");
  }

  /**
   * 转到查看页面.
   */
  @RequestMapping("view/{id}")
  public ModelAndView view(@PathVariable String id, HttpServletRequest request) {
    SysUserGroup sysUserGroup = sysUserGroupService.getByPrimaryKey(id);
    request.setAttribute("sysUserGroup", sysUserGroup);
    return new ModelAndView("org/amberframework/web/system/auth/controller/group/sysUserGroupView");
  }

  /**
   * 删除用户的组信息.
   */
  @RequestMapping("remove/{id}")
  @ResponseBody
  public AjaxRtnJson remove(@PathVariable String id) {
    try {
      sysUserGroupService.remove(id);
      return new AjaxRtnJson(true, "删除成功");
    } catch (DataAccessException e) {
      logger.error(e.getMessage(), e);
      return new AjaxRtnJson(false, "删除失败: " + e.getMessage());
    }
  }

  /**
   * 根据groupId保存用户的组信息.
   */
  @RequestMapping("save/groupId/{groupId}")
  @ResponseBody
  public AjaxRtnJson save(@PathVariable Long groupId, String json) {
    if (null == json) {
      return new AjaxRtnJson(false, "修改失败:提交内容为空");
    }

    List<SysUser> sysUserList = gson.fromJson(json, new TypeToken<List<SysUser>>() {}.getType());
    if (null != sysUserList) {
      try {
        sysUserGroupService.updateGroupMembers(groupId, sysUserList);
        return new AjaxRtnJson(true, "修改成功");
      } catch (RuntimeException e) {
        logger.error(e.getMessage(), e);
        return new AjaxRtnJson(false, "修改失败: " + e.getMessage());
      }
    }
    return new AjaxRtnJson(true, "修改成功，<br>没有成员！");
  }

  @RequestMapping("groupMembers/groupId/{groupId}")
  @ResponseBody
  public List<SysUser> groupMembers(@PathVariable Long groupId) {
    return sysUserGroupService.getGroupMembers(groupId);
  }

  /**
   * 返回组成员信息列表.
   */
  @RequestMapping("groupMembers")
  @ResponseBody
  public List<SysUser> groupMembers(String groupId) {
    if (StringUtils.hasText(groupId)) {
      return sysUserGroupService.getGroupMembers(Long.parseLong(groupId));
    } else {
      return new ArrayList<SysUser>();
    }
  }
}
