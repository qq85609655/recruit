package com.csot.gm.timeTask;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.csot.gm.materialManage.model.original.partNo.PartNo;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.csot.gm.esbws.entity.AccountInfoEntity;
import com.csot.gm.esbws.service.AccountInfoService;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.materialManage.model.original.clean.Clean;
import com.csot.gm.materialManage.service.clean.CleanService;
import com.csot.gm.materialManage.service.partNo.PartNoService;
import com.csot.gm.materialManage.service.propertyRtn.PropertyRtnService;
import com.csot.gm.rawMaterial.service.PartNoManageService;
import com.csot.gm.util.Status;

public class TimeTask extends QuartzJobBean {

  private static final Logger logger = LoggerFactory.getLogger(TimeTask.class);
  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Resource
  private AccountInfoService accountInfoService;
  @Resource
  private PartNoManageService partNoManageService;
  @Resource
  private PropertyRtnService propertyRtnService;
  @Resource
  private PartNoService partNoService;
  @Resource
  private CleanService cleanService;


  /**
   * 清理超时的状态为"生成中"的料号
   */
  @Override
  protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
    logger.info("定时任务开始----");

    InetAddress address = null;
    String hostAddress = "";
    String hostName = "";
    try {
      address = InetAddress.getLocalHost();
      hostName = address.getHostName();
      hostAddress = address.getHostAddress();
      logger.info(hostName);
      logger.info(hostAddress);
    } catch (UnknownHostException e) {
      logger.error(e.getMessage());
    }

    // 判断是否需要执行定时任务
    if ("GMPRDAP2".equals(hostName)) {
      logger.info("StandBy服务器不执行定时任务----");
    } else {
      WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
      partNoService = (PartNoService) webApplicationContext.getBean("partNoService");
      partNoManageService =
          (PartNoManageService) webApplicationContext.getBean("PartNoManageService");

      List<PartNoExt> list = partNoManageService.selectPartNoListByStatus(Status.IS_CREATING);
      if (!list.isEmpty()) {
        for (int i = 0; i < list.size(); i++) {
          String partNoId = list.get(i).getId();
          partNoService.remove(partNoId, "定时任务");
        }
      }

      // 每天定时清空数据库返给PLM的属性缓存信息
      propertyRtnService = (PropertyRtnService) webApplicationContext.getBean("propertyRtnService");
      propertyRtnService.removeAll();

      // 每天更新Clean表
      updateClean();
      logger.info("定时任务结束++++");
    }
  }


  private void updateClean() {
    WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
    partNoService = (PartNoService) webApplicationContext.getBean("partNoService");
    cleanService = (CleanService) webApplicationContext.getBean("cleanService");
    List<PartNo> partNoList = partNoService.getAll6171PartNo();
    List<Clean> cleanList = cleanService.getAllClean();
    HashMap<String, Clean> map = new HashMap<String, Clean>();
    for (Clean clean : cleanList) {
      map.put(clean.getPartNo(), clean);
    }
    List<PartNo> checkList = new ArrayList<PartNo>();
    for (PartNo pne : partNoList) {
      if (!map.containsKey(pne.getPartNo())) {
        checkList.add(pne);
      }
    }
    logger.info("待检查更新清洗的新建备品耗材料号有" + checkList.size() + "条");
    for (PartNo pn : checkList) {
      cleanService.checkPartNoAndInsert(pn);
    }
  }


  @Transactional
  private void updateUserInfoFromPm() {
    WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
    accountInfoService = (AccountInfoService) webApplicationContext.getBean("accountInfoService");
    Connection con = GetConnection.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    try {
      String sqlO = "select ORG_CODE, ORG_NAME, ORG_PARENT_CODE from SSO_BI_ORG";
      ps = con.prepareStatement(sqlO);
      rs = ps.executeQuery();
      rs.last();
      rs.first();
      if (rs != null) {
        while (rs.next()) {
          AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
          accountInfoEntity.setCode(rs.getString(1));
          accountInfoEntity.setName(rs.getString(2));
          accountInfoEntity.setPcode(rs.getString(3));
          accountInfoEntity.setUpdateTime(format.format(new Date()));
          accountInfoEntity.setId(UUID.randomUUID().toString().replace("-", ""));
          accountInfoEntity.setType("O");
          accountInfoService.createAccount(accountInfoEntity);
        }
      }

      String sqlP = "select USER_ID, USER_NAME, UNIT_CODE, MOBILE, TELEPHONE from SSO_BI_EMPLOYEE";
      ps = con.prepareStatement(sqlP);
      rs = ps.executeQuery();
      rs.last();
      rs.first();
      if (rs != null) {
        while (rs.next()) {
          AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
          accountInfoEntity.setCode(rs.getString(1));
          accountInfoEntity.setName(rs.getString(2));
          accountInfoEntity.setPcode(rs.getString(3));
          accountInfoEntity.setMobile(rs.getString(4));
          accountInfoEntity.setTelephone(rs.getString(5));
          accountInfoEntity.setUpdateTime(format.format(new Date()));
          accountInfoEntity.setId(UUID.randomUUID().toString().replace("-", ""));
          accountInfoEntity.setType("P");
          accountInfoService.createAccount(accountInfoEntity);
        }
      }
      rs.close();
      ps.close();
    } catch (SQLException e) {
      logger.error(e.getMessage());
    } finally {
      try {
        if (con != null && !con.isClosed()) {
          con.close();
        }
      } catch (SQLException e) {
        logger.error(e.getMessage());
      }
    }

  }
}
