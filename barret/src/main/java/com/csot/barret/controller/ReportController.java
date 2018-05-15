package com.csot.barret.controller;

import com.csot.barret.service.ReportService;
import com.sun.istack.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by xiongyinchun on 2018/2/5.
 */
@Controller
@RequestMapping("reportController")
public class ReportController {

  private static Logger logger = Logger.getLogger(ReportController.class);

  @Resource
  private ReportService reportService;

  @RequestMapping("report")
  public ModelAndView report(HttpServletRequest request) {
    Integer a=0;
    logger.info("hello");
    String startDate = request.getParameter("sd");
    String endDate = request.getParameter("ed");
    String status = request.getParameter("status");
    ModelAndView view = new ModelAndView();
    String[] titles = new String[]{"Site/审核通过", "物料类别", "属性值新增（个）", "物料新建（个）", "料号变更（个）", "跨厂扩展（单纯工厂扩展，不包含新建）（个）",
            "工厂视图变更（个）", "状态冻结（个）", "解冻（个）", "禁止下单（个）", "恢复下单（个）"};
    String[] company = new String[]{"深圳华星", "武汉华星", "深圳华星半导体", "武汉华星半导体", "惠州华星", "武汉华显"};
    // 前台展示数据
    List<List<Integer>> data = reportService.getData(startDate, endDate, status);
    view.setViewName("report");
    view.addObject("titles", titles);
    view.addObject("company", company);
    view.addObject("type", new String[]{"BOM材", "非BOM材", "非生产用物料"});
    view.addObject("data", data);
    view.addObject("sd", startDate);
    view.addObject("ed", endDate);
    return view;
  }

  @RequestMapping("getData")
  @ResponseBody
  public List<List<Integer>> getData(HttpServletRequest request) {
    String startDate = request.getParameter("sd");
    String endDate = request.getParameter("ed");
    String status = request.getParameter("status");
    return reportService.getData(startDate, endDate, status);
  }

  @RequestMapping("exportSumReport")
  @ResponseBody
  public void exportSumReport(HttpServletRequest request, HttpServletResponse response) {
    String startDate = request.getParameter("sd");
    String endDate = request.getParameter("ed");
    String status = request.getParameter("status");
    reportService.exportSumReport(startDate, endDate, status, response);
  }

}
