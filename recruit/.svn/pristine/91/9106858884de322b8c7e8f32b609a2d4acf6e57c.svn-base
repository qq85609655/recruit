package org.amberframework.web.system.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.amberframework.core.common.controller.BaseController;
import org.amberframework.web.system.model.BaseRole;
import org.amberframework.web.system.model.BaseUser;
import org.amberframework.web.system.model.PageResource;
import org.amberframework.web.system.model.ResourcePermission;
import org.amberframework.web.system.pojo.LoginClient;
import org.amberframework.web.system.service.BaseRoleService;
import org.amberframework.web.system.service.BaseUserService;
import org.amberframework.web.system.service.ResourcePermissionService;
import org.amberframework.web.system.service.ResourceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("loginController")
public class LoginController extends BaseController {
  
  private static final Logger logger = LoggerFactory.getLogger(LoginController.class.getName());

  @Resource
  private BaseUserService baseUserService;
  
  @Resource
  private BaseRoleService baseRoleService;
  
  @Resource
  private ResourceService resourceService;
  
  @Resource
  private ResourcePermissionService resourcePermissionService;
  
  @RequestMapping("login")
  public ModelAndView login(String username, String password, HttpServletRequest request,
      HttpServletResponse response) {
    HttpSession session = request.getSession();
    String gotoUrl = (String) session.getAttribute(LoginClient.GOTO_URL_KEY);
    session.removeAttribute(LoginClient.GOTO_URL_KEY);
    session.removeAttribute("resource");
    session.removeAttribute(LoginClient.CLIENT_SESSION_ATTR);
    LoginClient loginClient = (LoginClient) session.getAttribute(LoginClient.CLIENT_SESSION_ATTR);
    String loginUserName = "";
    boolean isLoginSuccess = false;
    if (loginClient != null) {
      BaseUser loginUser = loginClient.getUser();
      if (loginUser != null) {
        loginUserName = loginUser.getAccount();
      }
      isLoginSuccess = true;
    } else if (null == username || null == password) {
      isLoginSuccess = false;
    } else {
      isLoginSuccess = baseUserService.login(username, password, session);
      loginUserName = username;
      if(isLoginSuccess){
        //获取权限访问资源
        LoginClient user = (LoginClient) session.getAttribute(LoginClient.CLIENT_SESSION_ATTR);
        if(user !=null){
          if(user.getUser() !=null){
            //将界面权限放到session中
            List<PageResource> pageResourceList = resourceService.getResourcesByUserId(user.getUser().getId());
            if(pageResourceList !=null && pageResourceList.size()>0){
              session.setAttribute("resource", pageResourceList);
            }else{
              return new ModelAndView("login");
            }
            //将所有资源和权限放到session中
            Map<String,String> allResourcePermission = resourcePermissionService.getAllResourcesPermission();
            if(allResourcePermission !=null && allResourcePermission.size()>0){
              for (String s : allResourcePermission.keySet()) {
                  String value = allResourcePermission.get(s);
                  s=s.replace("/", "_");
                  session.removeAttribute("u"+s);
                  session.setAttribute(s, value);
                }
            }
            //将该用户的资源和权限放入session
            Map<String,String> userResourcePermission =  resourcePermissionService.getResourcesPermissionByUserId(user.getUser().getId());
            if(userResourcePermission !=null && userResourcePermission.size()>0){
              for (String s : userResourcePermission.keySet()) {
                String value = userResourcePermission.get(s);
                s=s.replace("/", "_");
                session.setAttribute("u"+s, s);
                }
            }
          }
        }
      }
    }
    if (gotoUrl == null || gotoUrl.equals("") || gotoUrl.startsWith("login.jsp")) {
      gotoUrl = null;
    }
    request.setAttribute("loginUserName", loginUserName);
    if (isLoginSuccess) {
      try {
        if (null != gotoUrl) {
          // 需要添加“/”(因为要重新指向根目录)，然后跳转页面，不使用sendRedirect，因为请求是要重新转发，而不单纯是页面跳转
          RequestDispatcher dispatcher = request.getRequestDispatcher("/" + gotoUrl);
          dispatcher.forward(request, response);
          // response.sendRedirect("/" + gotoUrl);
        }
      } catch (IOException e) {
        logger.error(e.getMessage(), e);
      } catch (ServletException e) {
        logger.error(e.getMessage(), e);
      }
      return new ModelAndView("redirect:main");
    } else {
      return new ModelAndView("login");
    }
  }
  
  @RequestMapping("main")
  public ModelAndView mainPage() {
    return new ModelAndView("main_new");
  }

  @RequestMapping("logout")
  public ModelAndView logout(HttpServletRequest request) {
    HttpSession session = request.getSession();
    session.removeAttribute(LoginClient.CLIENT_SESSION_ATTR);
    return new ModelAndView("login");
  }
  
  @RequestMapping("index")
  public ModelAndView index() {
    return new ModelAndView("index");
  }
  
  @RequestMapping("menu")
  @ResponseBody
  public String getMenu(HttpServletRequest request) {
    HttpSession session = request.getSession();
    LoginClient loginClient = (LoginClient) session.getAttribute(LoginClient.CLIENT_SESSION_ATTR);
    if (loginClient == null) {
      return "[]";
    } else {
      BaseUser user = loginClient.getUser();
      if (user != null && user.getAccount().equals("admin")) {
        return "[{ id: \"handler\", text: \"Handler管理\"}, {id: \"handlerTreeList\", text: \"Handler列表\",  pid: \"handler\", url: \"handlerTreeController/treeList\" },{ id: \"right\", text: \"功能示例\"}, {id: \"base\", text: \"基础功能\",  pid: \"right\", url: \"testUserController/list\" },{id: \"user\", text: \"用户管理\"},{id: \"lists\", text: \"用户列表\", pid: \"user\", url: \"baseUserController/baseUserList\"}]";
      } else {
        return "[{ id: \"handler\", text: \"Handler管理\"}, {id: \"handlerTreeList\", text: \"Handler列表\",  pid: \"handler\", url: \"handlerTreeController/treeList\" },{ id: \"right\", text: \"功能示例\"}, {id: \"base\", text: \"基础功能\",  pid: \"right\", url: \"testUserController/list\" }]";
      }
    }
  }
}
