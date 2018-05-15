package org.amberframework.core.interceptor;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.amberframework.web.system.pojo.LoginClient;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

  private List<String> excludeUris;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    if (excludeUris != null && excludeUris.contains(request.getServletPath().substring(1))) {
      return true;
    }
    StringBuilder gotoUrl = new StringBuilder(request.getServletPath().substring(1));
    HttpSession session = request.getSession();
    if (session.getAttribute(LoginClient.CLIENT_SESSION_ATTR) == null) {

      Map<String, String[]> zzMap = request.getParameterMap();
      if (zzMap != null) {
        gotoUrl.append('?');
        for (String s : zzMap.keySet()) {
          String[] value = zzMap.get(s);
          for (String val : value) {
            gotoUrl.append(s);
            gotoUrl.append("=");
            gotoUrl.append(val);
            gotoUrl.append("&");
          }
        }
      }
      session.setAttribute(LoginClient.GOTO_URL_KEY, gotoUrl.toString());
      //将权限和资源加入session
      response.sendRedirect(request.getContextPath() + "/webpage/login.jsp");
      return false;
    }else{
      String s = request.getRequestURL().toString() ;
      //切割有效字符串
      String key = "";
      String[] sa =  s.split("/");
      if(sa !=null && sa.length>=5){
        key = "_"+sa[4]+"_"+sa[5];
      }
     //查询该资源是否存在，请求具有相应的权限
      String url  = (String)session.getAttribute(key);
      //查看该资源是否属于被限制访问的权限访问范围之内
      if(url !=null && !"".equals(url) ){
        //验证该用户是否具有此资源的访问权限
        url = (String)session.getAttribute("u"+key);
        if(url==null || "".equals(url)){
          response.sendRedirect(request.getContextPath() + "/webpage/org/amber/system/baseuser/error.jsp");
          return false;
        }
      }else{
        return true;
      }
    }
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    
    super.postHandle(request, response, handler, modelAndView);
  }

  private void forward(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("webpage/login.jsp").forward(request, response);
  }

  public List<String> getExcludeUris() {
    return excludeUris;
  }

  public void setExcludeUris(List<String> excludeUris) {
    this.excludeUris = excludeUris;
  }
}
