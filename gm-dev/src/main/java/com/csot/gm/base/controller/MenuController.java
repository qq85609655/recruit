package com.csot.gm.base.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.service.SysAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.csot.gm.base.service.MenuService;

@Controller
@RequestMapping("base/menu")
public class MenuController {

  @Resource
  private SysAuthService sysAuthService;

  @Resource
  private MenuService menuService;

  /**
   * 通过用户类型，显示相应的菜单
   * 
   * @param sysUser
   * @return
   */
  @RequestMapping("getmenu")
  @ResponseBody
  public List<SysResource> getMenu(@CurrentUser SysUser sysUser) {

    List<SysResource> sysResourceList = new ArrayList<SysResource>();
    List<SysResource> sysResourceTopMenuList = new ArrayList<SysResource>();
    List<SysResource> sysResourcePartList = new ArrayList<SysResource>();
    List<SysResource> sysResourceSecondPartList = new ArrayList<SysResource>();
    // 若不为本地账户即为域账号，则为用户展示"用户查询料号信息页面"
    if (null == sysUser) {
      SysUser sysUserNew = new SysUser();
      sysUserNew.setId("-1-212-1-");
      sysResourceList = sysAuthService.findMenuByUserId(sysUserNew);
      sysResourceTopMenuList = menuService.getMenuByName("物料管理");
      sysResourcePartList = menuService.getMenuByName("用户查询料号信息页面");
      sysResourceSecondPartList = menuService.getMenuByName("文档管理");
      sysResourceList.addAll(sysResourceTopMenuList);
      sysResourceList.addAll(sysResourcePartList);
      sysResourceList.addAll(sysResourceSecondPartList);
    }
    // 若为本地账户，则展示其权限范围内的所有菜单
    if (null != sysUser) {
      sysResourceList = sysAuthService.findMenuByUserId(sysUser);
    }

    return sysResourceList;
  }

}
