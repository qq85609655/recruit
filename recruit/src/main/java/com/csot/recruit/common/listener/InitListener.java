package com.csot.recruit.common.listener;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.csot.recruit.common.service.CommonService;


/**
 * 系统初始化监听器,在系统启动时运行,进行一些初始化工作
 * @author 
 *
 */
public class InitListener implements javax.servlet.ServletContextListener {

	
	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	
	public void contextInitialized(ServletContextEvent event) {
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		CommonService commonService = (CommonService) webApplicationContext.getBean("commonService");
		commonService.initAllDatadict(); // 对数据字典进行缓存
//		commonService.createPositionId(); // 人才库关键查询的索引创建
		commonService.queryAllUserForQuikSearch(); // 查询出所有人员信息
	}

}
