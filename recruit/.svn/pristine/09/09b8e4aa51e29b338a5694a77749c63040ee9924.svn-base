package com.csot.recruit.common.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

/**
* 这个类的init法在系统启动时候执行的，一些读取配置文件，监听端口，初始化连接之类的可以在此处做
*/
public class ApplicationServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private Logger log = Logger.getLogger(getClass());

    ServletContext application;

    public void init(ServletConfig config) throws ServletException {
        
      // 预置项目名称
      application = config.getServletContext();
      application.setAttribute("ctx", application.getContextPath());
      log.info("ctx:" + application.getContextPath());
        
    }

    public void destroy() {
      application.removeAttribute("ctx");
      super.destroy();
    }

}
