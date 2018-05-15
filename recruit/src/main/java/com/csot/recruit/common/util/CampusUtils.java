package com.csot.recruit.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CampusUtils {
  public static String getCurrentYearth() {
    // 获取年份
    String yearth = "";
    Calendar calendar = Calendar.getInstance();
    Date date = new Date(System.currentTimeMillis());
    String yearth1 = new SimpleDateFormat("yyyy").format(date);
    calendar.setTime(date);
    calendar.add(Calendar.YEAR, +1);
    date = calendar.getTime();
    String yearth2 = new SimpleDateFormat("yyyy").format(date);
    int month = date.getMonth();
    if (month < 6) {
      yearth = yearth1 + "春季";
    } else {
      yearth = yearth2 + "秋季";
    }
    return yearth;
  }
}
