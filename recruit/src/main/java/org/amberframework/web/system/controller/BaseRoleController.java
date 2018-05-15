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
import org.amberframework.web.system.service.BaseRoleService;
import org.amberframework.web.system.service.BaseUserService;
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
@RequestMapping("baseRoleController")
public class BaseRoleController extends BaseController {

  private static final Logger logger = LoggerFactory.getLogger(BaseRoleController.class.getName());

  @Resource
  private BaseRoleService baseRoleService;

  /**
   * 跳转到用户查看维护页面.
   * 
   * @param request
   * @param response
   * @return
   */
  @RequestMapping("baseRoleList")
  @ResponseBody
  public ModelAndView baseUserList(HttpServletRequest request, HttpServletResponse response) {
    return new ModelAndView("org/amber/system/baseuser/baseRoleList");
  }

  /**
   * 获取角色列表
   * 
   * @param request
   * @param response
   */
  @RequestMapping("datagrid")
  @ResponseBody
  public MiniRtn2Grid datagrid(MiniGridPageSort pageAndSort, HttpServletRequest request,
      HttpServletResponse response) {
   return  baseRoleService.getBaseRoleList(pageAndSort);
  }
  
  /**
   * 新增角色
   * @param baseRole
   */
  @RequestMapping("/addRole")
  public String addRole(BaseRole baseRole){
     baseRoleService.cerateBaseRole(baseRole);
     return "redirect:/baseRoleController/baseRoleList";
  }

  /**
   * 更新角色
   * @param baseRole
   * @return
   */
  @RequestMapping("update")
  public String updateRole(BaseRole baseRole){
    baseRoleService.updateBaseRole(baseRole);
    return "redirect:/baseRoleController/baseRoleList";
  }
  
  /**
   * 删除角色
   * @param id
   * @return
   */
  @RequestMapping("delete")
  public String deleteRole(String id){
    baseRoleService.deleteBaseRoleById(id);
    return "redirect:/baseRoleController/baseRoleList";
  }
  
  /**
   * 获取所有的角色
   * @return
   */
  @RequestMapping("getAllRole")
  @ResponseBody
  public MiniRtn2Grid getAllRole(){
    return baseRoleService.getAllRole();
  }
}
