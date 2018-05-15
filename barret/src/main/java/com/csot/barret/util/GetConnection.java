package com.csot.barret.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by xiongyinchun on 2018/2/8.
 */
public class GetConnection {
  public static Connection getConnection() {
    String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
    String DBURL = "jdbc:oracle:thin:@10.108.4.208:1521:tcdb";
//    String DBURL = "jdbc:oracle:thin:@10.108.7.16:1521:plmdb";
    String DBUSER = "int_sap";
    String DBPASS = "int_sap";
    Connection con = null;
    try {
      Class.forName(DBDRIVER);
      try {
        con = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println("哈勒个哈");
    return con;
  }
}
