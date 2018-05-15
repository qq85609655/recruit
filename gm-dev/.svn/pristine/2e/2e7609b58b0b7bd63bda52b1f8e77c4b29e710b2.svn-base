package com.csot.gm.timeTask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetConnection {
  private static final Logger logger = LoggerFactory.getLogger(GetConnection.class);
  private static final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
  private static final String DBURL = "jdbc:oracle:thin:@10.108.5.188:1521:P1PIPMDB";
  private static final String DBUSER = "userinfo";
  private static final String DBPASS = "userinfo";

  public static Connection getConnection() {
    Connection con = null;
    try {
      Class.forName(DBDRIVER);
      try {
        con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
      } catch (SQLException e) {
        logger.error(e.getMessage());
      }
    } catch (ClassNotFoundException e) {
      logger.error(e.getMessage());
    }
    return con;
  }
}
