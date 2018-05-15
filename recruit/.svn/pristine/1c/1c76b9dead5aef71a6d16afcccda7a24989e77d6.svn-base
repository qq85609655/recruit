package org.amberframework.web.system.auth.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.shiro.filter.AmberFormAuthenticationFilter;
import org.amberframework.core.shiro.filter.AmberFormAuthenticationFilter.GotoInfo;
import org.amberframework.web.system.auth.model.extension.resource.SysResourceTree;
import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.auth.service.SysAuthService;
import org.amberframework.web.system.util.WebPageContextUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.csot.recruit.model.original.flow.employ.Remind;
import com.csot.recruit.service.flow.employ.RemindService;

@Controller
@RequestMapping("sys/auth")
public class SysAuthController {

  private static final Logger logger = LoggerFactory.getLogger(SysAuthController.class);

  @Resource
  private SysAuthService sysAuthService;

  @Resource
  private AmberFormAuthenticationFilter formAuthenticationFilter;
  @Resource
  private RemindService remindService;
  /**
   * 跳转到首页.
   */
  @RequestMapping("main")
  public ModelAndView mainPage(@CurrentUser SysUser sysUser, HttpServletRequest request) {
    SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    List<Remind> reminds=remindService.getByUserAndDate(sysUser.getId(),dateFormat.format(new Date()));
    request.setAttribute("reminds", reminds);
    return new ModelAndView("main");
  }

  /**
   * Ajax登录的方法.
   */
  @RequestMapping(value = "ajaxlogin")
  @ResponseBody
  public AjaxRtnJson ajaxLogin(@RequestParam String username, @RequestParam String password,
      HttpServletRequest request) {
    Subject subject = SecurityUtils.getSubject();

    // 获取登录前请求的url，会作为AjaxRtnJson的msg属性传回客户端.
    GotoInfo gotoInformation = formAuthenticationFilter.getGotoInfomation(request, "sys/auth/main");
    String gotoUrl = getGotoUrlFromInfo(gotoInformation);

    if (subject.isAuthenticated()) {
      return new AjaxRtnJson(true, gotoUrl);
    } else {
      UsernamePasswordToken token = new UsernamePasswordToken(username, password);
      try {
        subject.login(token);
        WebPageContextUtil.setBasePathToSession(request);
      } catch (Exception ex) {
        logger.error(ex.getMessage(), ex);
        if (ex.getClass() == UnknownAccountException.class
            || ex.getClass() == IncorrectCredentialsException.class) {
          return new AjaxRtnJson(false, "用户名或密码错误");
        } else {
          return new AjaxRtnJson(false, "登录认证错误");
        }
      }
      return new AjaxRtnJson(true, gotoUrl);
    }
  }

  /**
   * 注销用户登录，这里只需要跳转到登录界面，shiro中配置可以完成对于这个请求的拦截和用户登出.
   */
  @RequestMapping("logout")
  public ModelAndView logout() {
    return new ModelAndView("login");
  }

  /**
   * 验证用户是否已经登录.
   */
  @RequestMapping("authenticated")
  @ResponseBody
  public boolean authenticated() {
    return SecurityUtils.getSubject().isAuthenticated();
  }

  @RequestMapping("menu")
  @ResponseBody
  public List<SysResource> getMenu(@CurrentUser SysUser sysUser) {
    return sysAuthService.findMenuByUserId(sysUser);
  }
  
  @RequestMapping("menutree")
  @ResponseBody
  public List<SysResourceTree> getMenuTree(@CurrentUser SysUser sysUser) {
    return sysAuthService.findMenuTreeByUserId(sysUser);
  }
  
  private String getGotoUrlFromInfo(GotoInfo gotoInformation) {
    String gotoUrl = "sys/auth/main";
    if (gotoInformation.isContextRelative()) {
      gotoUrl = gotoInformation.getGotoUrl();
      StringBuilder sb = new StringBuilder(gotoUrl);
      if (sb.length() > 0 && '/' == sb.charAt(0)) {
        gotoUrl = sb.substring(1);
      }
    }
    return gotoUrl;
  }
  
}
