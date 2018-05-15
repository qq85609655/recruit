package com.csot.gm.timeTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.csot.gm.esbws.dao.AccountInfoDao;
import com.csot.gm.esbws.entity.AccountInfoEntity;

public class UpdateUserInfo {
  private static final Logger logger = LoggerFactory.getLogger(TimeTask.class);
  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  @Resource
  private AccountInfoDao accountInfoDao;

  @Transactional
  private void updateUserInfoFromPm() {
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
          accountInfoDao.createAccountInfo(accountInfoEntity);
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
          accountInfoDao.createAccountInfo(accountInfoEntity);
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
