package com.csot.barret.service;

import com.csot.barret.model.Report;
import com.csot.barret.model.SumReport;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xiongyinchun on 2018/2/7.
 */
public interface ReportService {
  List<Report> getBaseUser();

  List<SumReport> getSumReport(String startTime, String endTime, String status);

  void exportSumReport(String startTime, String endTime, String status, HttpServletResponse response);

  List<List<Integer>> getData(String startDate, String endDate, String status);
}
