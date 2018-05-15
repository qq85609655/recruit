package org.amberframework.web.system.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.common.controller.BaseController;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.model.BaseRole;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.PageResource;
import org.amberframework.web.system.model.RoleResourcePermission;
import org.amberframework.web.system.service.BaseRoleResourcePermissionService;
import org.amberframework.web.system.service.BaseRoleService;
import org.amberframework.web.system.service.BaseUserResourcePermissionService;
import org.amberframework.web.system.service.BaseUserService;
import org.amberframework.web.system.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller
@RequestMapping("permission")
public class PermissionController extends BaseController {

  private static final Logger logger = LoggerFactory.getLogger(PermissionController.class.getName());

  @Resource
  private ResourceService resourceService;
  
  @Resource
  private BaseRoleResourcePermissionService  baseRoleResourcePermissionService;
  
  @Resource
  private BaseUserResourcePermissionService  baseUserResourcePermissionService;
  
  /**
   * 获取菜单权限或操作权限
   * @param roleId
   * @param flag
   * @param request
   * @return
   */
  @RequestMapping("permission")
  public ModelAndView getRolePermission(@RequestParam(value="roleId", required = false)String roleId,
                                        @RequestParam(value="flag", required = false)String flag,HttpServletRequest request){
    List<PageResource> pageResourceList = resourceService.getResourceByFlag(flag);
    request.setAttribute("roleId", roleId);
    request.setAttribute("flag",flag);
    request.setAttribute("pageResourceList", pageResourceList);
    return new ModelAndView("org/amber/system/permission/permission");
  }
  
  /**
   * 获取用户的操作权限
   * @param userId
   * @param flag
   * @param request
   * @return
   */
  @RequestMapping("userOperatePermission")
  public ModelAndView getUserPermission(@RequestParam(value="userId", required = false)String userId,
                                        @RequestParam(value="flag", required = false)String flag,HttpServletRequest request){
    String roleId = "";
    if(userId !=null){
      roleId = resourceService.getRoleIdByUserId(userId);
      request.setAttribute("roleId", roleId);
      request.setAttribute("userId", userId);
    }
    request.setAttribute("flag",flag);
    List<PageResource> pageResourceList = resourceService.getResourceByFlag(flag);
    request.setAttribute("pageResourceList", pageResourceList);
    return new ModelAndView("org/amber/system/permission/permission");
  }
  
  /**
   * 新增角色，资源，权限的关系
   * @param roleId
   * @param resourceId
   * @param permissionId
   * @return
   */
  @RequestMapping(value="roleResourcePermission")
  @ResponseBody
  public AjaxRtnJson addRoleResourcePermission(@RequestParam(value="roleId", required = false) String roleId,
                                               @RequestParam(value="resourceId", required = false) String resourceId,
      @RequestParam(value="permissionId") String permissionId,@RequestParam(value="flag")String flag){
    //新增RoelResourcePermission
      int count = baseRoleResourcePermissionService.addRoleResourcePermission(roleId, resourceId, permissionId,flag);
    if(count >0){
      return new AjaxRtnJson(true,"保存成功");
    }else{
      return new AjaxRtnJson(false,"保存失败");
    }
  }
  
  @RequestMapping("userRoleResourcePermission")
  @ResponseBody
  public AjaxRtnJson addUesrResourcePermission(
                                               @RequestParam(value="userId", required = false) String userId,
                                               @RequestParam(value="resourceId", required = false) String resourceId,
                                               @RequestParam(value="permissionId", required = false) String permissionId,
                                               @RequestParam(value="roleId", required = false)String roleId){
    int count = baseUserResourcePermissionService.addUserResourcePermission(roleId, resourceId, permissionId,userId);
    if(count >0){
      return new AjaxRtnJson(true,"保存成功");
    }else{
      return new AjaxRtnJson(false,"保存失败");
    }
  }
  
  @RequestMapping("retainRolePermission")
  @ResponseBody
  public AjaxRtnJson retainRolePermission(@RequestParam(value="userId", required = false)String userId ){
    int count = baseUserResourcePermissionService.deleteUserResourcePermissionByUserid(userId);
    if(count >0){
      return new AjaxRtnJson(true,"恢复成功");
    }else{
      return new AjaxRtnJson(false,"恢复失败");
    }
  }
  
  /**
   * 初始化角色的资源和权限
   * @return
   */
  @RequestMapping(value="resourceIds")
  @ResponseBody
  public List<String> getCheckedResourcePermission(@RequestParam(value="roleId", required = false )String roleId,
                                                   @RequestParam(value="flag", required = false)String flag,
                                                   @RequestParam(value="userId" ,required = false)String userId){
    List<String> resourceIds = resourceService.getRRPByRoleIdAndFlag(roleId,flag);
    if(userId !=null && !"".equals(userId)){
      List<String> uResourceIds = baseUserResourcePermissionService.getUPPByUserId(userId);
      if(uResourceIds !=null && uResourceIds.size()>0){
        resourceIds.addAll(uResourceIds);
      }
    }
    return resourceIds;
  }
}
