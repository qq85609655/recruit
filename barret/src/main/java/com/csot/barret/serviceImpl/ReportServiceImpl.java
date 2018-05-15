package com.csot.barret.serviceImpl;

import com.csot.barret.dao.ReportMapper;
import com.csot.barret.dao.SumReportMapper;
import com.csot.barret.model.Report;
import com.csot.barret.model.SumReport;
import com.csot.barret.service.ReportService;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by xiongyinchun on 2018/2/7.
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {

  public static final  String[] companys = new String[] {"深圳市华星光电技术有限公司", "武汉华星光电技术有限公司",
          "深圳市华星光电半导体显示技术有限公司", "武汉华星光电半导体显示技术有限公司", "惠州市华星光电技术有限公司",
   "华显项目组"};
  public static final String[] partType = new String[] {"BOM材", "非BOM材", "非生产用物料"};

  @Resource
  private ReportMapper reportMapper;
  @Resource
  private SumReportMapper sumReportMapper;

  @Override
  public List<Report> getBaseUser() {
    return reportMapper.selectBaseUser();
  }

  @Override
  public List<SumReport> getSumReport(String startTime, String endTime, String status) {
    List<SumReport> list = new ArrayList<>();
    for (int i = 0; i < companys.length; i++) {
      for (int j = 0; j < partType.length; j++) {
        SumReport sr = new SumReport();
        sr.setCompany(companys[i]);
        sr.setPartType(partType[j]);
        sr.setPartPropValue(getPropValue(startTime, endTime, status, companys[i], partType[j]));
        sr.setPartNoAdd(getPartNoAdd(startTime, endTime, status, companys[i], partType[j]));
        sr.setPartNoUpdate(getPartNoUpdate(startTime, endTime, status, companys[i], partType[j]));
        sr.setPlantExtend(getPlantExtend(startTime, endTime, status, companys[i], partType[j]));
        sr.setPlantUpdate(getPlantUpdate(startTime, endTime, status, companys[i], partType[j]));
        sr.setStatusFreeze(getStatusFreeze(startTime, endTime, status, companys[i], partType[j]));
        sr.setReleaseFreeze(getReleaseFreeze(startTime, endTime, status, companys[i], partType[j]));
        sr.setForbidOrder(getForbidOrder(startTime, endTime, status, companys[i], partType[j]));
        sr.setReleaseOrder(getReleaseOrder(startTime, endTime, status, companys[i], partType[j]));
        list.add(sr);
      }
    }
    return list;
  }

  /**
   * 属性值新增统计
   * @param startTime
   * @param endTime
   * @param company
   * @param partType
   * @return
   */
  public int getPropValue(String startTime, String endTime, String status, String company, String partType) {
    int n = 0;
    if ("BOM材".equals(partType)) {
      n = sumReportMapper.getBomValueAdd(startTime, endTime, status, company);
    } else if ("非BOM材".equals(partType)) {
      n = sumReportMapper.getNotBomValueAdd(startTime, endTime, status, company);
    } else if ("非生产用物料".equals(partType)) {
      n = sumReportMapper.getNotProductValueAdd(startTime, endTime, status, company);
    }
    return n;
  }

  /**
   * 物料号新增统计
   * @param startTime
   * @param endTime
   * @param company
   * @param partType
   * @return
   */
  public int getPartNoAdd(String startTime, String endTime, String status, String company, String partType) {
    int n = 0;
    if ("BOM材".equals(partType)) {
      n = sumReportMapper.getBomPartNoAdd(startTime, endTime, status, company);
    } else if ("非BOM材".equals(partType)) {
      n = sumReportMapper.getNotBomPartNoAdd(startTime, endTime, status, company);
    } else if ("非生产用物料".equals(partType)) {
      n = sumReportMapper.getNotProductPartNoAdd(startTime, endTime, status, company);
    }
    return n;
  }

  /**
   * 物料号变更统计
   * @param startTime
   * @param endTime
   * @param company
   * @param partType
   * @return
   */
  public int getPartNoUpdate(String startTime, String endTime, String status, String company, String partType) {
    int n = 0;
    if ("BOM材".equals(partType)) {
      n = sumReportMapper.getBomPartNoUpdate(startTime, endTime, status, company);
    } else if ("非BOM材".equals(partType)) {
      n = sumReportMapper.getNotBomPartNoUpdate(startTime, endTime, status, company);
    } else if ("非生产用物料".equals(partType)) {
      n = sumReportMapper.getNotProductPartNoUpdate(startTime, endTime, status, company);
    }
    return n;
  }

  /**
   * 跨厂扩展统计
   * @param startTime
   * @param endTime
   * @param company
   * @param partType
   * @return
   */
  public int getPlantExtend(String startTime, String endTime, String status, String company, String partType) {
    int n = 0;
    if ("BOM材".equals(partType)) {
      n = sumReportMapper.getBomPlantExtend(startTime, endTime, status, company);
    } else if ("非BOM材".equals(partType)) {
      n = sumReportMapper.getNotBomPlantExtend(startTime, endTime, status, company);
    } else if ("非生产用物料".equals(partType)) {
      n = sumReportMapper.getNotProductPlantExtend(startTime, endTime, status, company);
    }
    return n;
  }

  /**
   * 工厂变更统计
   * @param startTime
   * @param endTime
   * @param company
   * @param partType
   * @return
   */
  public int getPlantUpdate(String startTime, String endTime, String status, String company, String partType) {
    int n = 0;
    if ("BOM材".equals(partType)) {
      n = sumReportMapper.getBomPlantUpdate(startTime, endTime, status, company);
    } else if ("非BOM材".equals(partType)) {
      n = sumReportMapper.getNotBomPlantUpdate(startTime, endTime, status, company);
    } else if ("非生产用物料".equals(partType)) {
      n = sumReportMapper.getNotProductPlantUpdate(startTime, endTime, status, company);
    }
    return n;
  }

  /**
   * 状态冻结统计
   * @param startTime
   * @param endTime
   * @param company
   * @param partType
   * @return
   */
  public int getStatusFreeze(String startTime, String endTime, String status, String company, String partType) {
    int n = 0;
    if ("BOM材".equals(partType)) {
      n = 0;   //BOM材暂时无冻结流程
    } else if ("非BOM材".equals(partType)) {
      n = sumReportMapper.getNotBomStatusFreeze(startTime, endTime, status, company);
    } else if ("非生产用物料".equals(partType)) {
      n = sumReportMapper.getNotProductStatusFreeze(startTime, endTime, status, company);
    }
    return n;
  }

  /**
   * 解冻统计
   * @param startTime
   * @param endTime
   * @param company
   * @param partType
   * @return
   */
  public int getReleaseFreeze(String startTime, String endTime, String status, String company, String partType) {
    int n = 0;
    if ("BOM材".equals(partType)) {
      n = 0;   //BOM材暂时无解冻流程
    } else if ("非BOM材".equals(partType)) {
      n = sumReportMapper.getNotBomReleaseFreeze(startTime, endTime, status, company);
    } else if ("非生产用物料".equals(partType)) {
      n = sumReportMapper.getNotProductReleaseFreeze(startTime, endTime, status, company);
    }
    return n;
  }

  /**
   * 禁止下单统计
   * @param startTime
   * @param endTime
   * @param company
   * @param partType
   * @return
   */
  public int getForbidOrder(String startTime, String endTime, String status, String company, String partType) {
    int n = 0;
    if ("BOM材".equals(partType)) {
      n = 0;   //BOM材暂时无禁止下单流程
    } else if ("非BOM材".equals(partType)) {
      n = sumReportMapper.getNotBomForbidOrder(startTime, endTime, status, company);
    } else if ("非生产用物料".equals(partType)) {
      n = sumReportMapper.getNotProductForbidOrder(startTime, endTime, status, company);
    }
    return n;
  }

  /**
   * 恢复下单统计
   * @param startTime
   * @param endTime
   * @param company
   * @param partType
   * @return
   */
  public int getReleaseOrder(String startTime, String endTime, String status, String company, String partType) {
    int n = 0;
    if ("BOM材".equals(partType)) {
      n = 0;   //BOM材暂时无恢复下单流程
    } else if ("非BOM材".equals(partType)) {
      n = sumReportMapper.getNotBomReleaseOrder(startTime, endTime, status, company);
    } else if ("非生产用物料".equals(partType)) {
      n = sumReportMapper.getNotProductReleaseOrder(startTime, endTime, status, company);
    }
    return n;
  }


  /**
   * 导出物料统计报表
   * @param startTime
   * @param endTime
   */
  @Override
  public void exportSumReport(String startTime, String endTime, String status, HttpServletResponse response) {
    // 新文件写入数据，并下载
    File file = null;
    InputStream is = null;
    XSSFWorkbook workbook = null;
    XSSFSheet sheet = null;
    try {
      String classpath = Thread.currentThread().getContextClassLoader().getResource("").toURI().getPath();
      // 把WEB-INF/classes截取获得webapp目录
      String webappRoot = classpath.replaceAll("WEB-INF/classes/", "");

      file = new File (webappRoot + "excelTemplate/MaterialCount.xlsx");
      is = new FileInputStream(file);
      workbook = new XSSFWorkbook(is);
      sheet = workbook.getSheetAt(0);
    } catch (Exception e) {
      e.printStackTrace();
    }

    if (sheet != null) {
      try {
        // 写数据
        FileOutputStream fos = new FileOutputStream(file);
        List<List<Integer>> data = getData(startTime, endTime, status);
        for (int i = 1; i < 20; i++) {
          XSSFRow row = sheet.getRow(i);
          if (row == null) {
            row = sheet.createRow(i);
          }
          for (int j = 2; j < 11; j++) {
            XSSFCell cell = row.getCell(j);
            if (cell == null) {
              cell = row.createCell(j);
            }
            cell.setCellValue(data.get(i-1).get(j-2));
          }
        }
        workbook.write(fos);
        fos.flush();
        fos.close();
        // 下载
        download(file, response, status);
      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        try {
          if (null != is) {
            is.close();
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }

  /**
   * 获取统计数据
   * @param
   * @return
   */
  @Override
  public List<List<Integer>> getData(String startDate, String endDate, String status) {
    List<List<Integer>> data = new ArrayList<List<Integer>>();
    if (startDate == null || endDate == null) {
      for (int i = 0; i < 19; i++) {
        List<Integer> row = new ArrayList<Integer>();
        for (int j = 0; j < 9; j++) {
          row.add(null);
        }
        data.add(row);
      }

    } else  {
      List<SumReport> sumReportList = this.getSumReport(startDate, endDate, status);
      // 前台展示数据
      List<Integer> sum = new ArrayList<Integer>();
      for (int i = 0; i < 9; i++) {
        sum.add(new Integer(0));
      }
      for (int i = 0; i < 18; i++) {
        List<Integer> row = new ArrayList<Integer>();
        SumReport report = sumReportList.get(i);
        row.add(report.getPartPropValue());
        row.add(report.getPartNoAdd());
        row.add(report.getPartNoUpdate());
        row.add(report.getPlantExtend());
        row.add(report.getPlantUpdate());
        row.add(report.getStatusFreeze());
        row.add(report.getReleaseFreeze());
        row.add(report.getForbidOrder());
        row.add(report.getReleaseOrder());
        for (int j = 0; j < 9; j++) {
          sum.set(j, sum.get(j) + row.get(j));
        }
        data.add(row);
      }
      data.add(sum);
    }
    return data;
  }

  /**
   * 下载文件
   * @param file
   * @param response
   */
  public void download(File file, HttpServletResponse response, String status) {
    try {
      InputStream fis = new BufferedInputStream(new FileInputStream(file));
      byte[] buffer = new byte[fis.available()];
      fis.read(buffer);
      fis.close();
      response.reset();
      response.setContentType("text/html;charset=UTF-8");
      OutputStream os = new BufferedOutputStream(response.getOutputStream());
      response.setContentType("application/x-msdownload");
      SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
      String newName = "";
      if ("0".equals(status)) {
        newName = URLEncoder.encode("未提交物料统计表" + sdf.format(new Date()) + ".xlsx","UTF-8");
      } else if ("1".equals(status)) {
        newName = URLEncoder.encode("流程中物料统计表" + sdf.format(new Date()) + ".xlsx","UTF-8");
      } else if ("2".equals(status)) {
        newName = URLEncoder.encode("已生效物料统计表" + sdf.format(new Date()) + ".xlsx","UTF-8");
      }
      response.addHeader("Content-Disposition","attachment;filename=\"" + newName + "\"");
      response.addHeader("Content-Length", "" + file.length());
      os.write(buffer);
      os.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


}
