package com.csot.recruit.service.job;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.service.resume.ResumeService;

/**
 * 解析邮箱中简历的定时任务
 * @author honglu
 *
 */
@Component
public class EmailParse {
  
  private Logger logger = LoggerFactory.getLogger(EmailParse.class);
  
  @Resource
  private ResumeService resumeService;
  
  @Scheduled(cron ="0 0/20 * * * ?" ) // 每20分钟一次
  public void task() {
    PropertiesUtil propertiesUtil = new PropertiesUtil();
    String userName = propertiesUtil.readProperty("username");
    String password = propertiesUtil.readProperty("password");
    String server = propertiesUtil.readProperty("server");
    resumeService.parseResumeByEmail(userName, password, server);
  }
}
