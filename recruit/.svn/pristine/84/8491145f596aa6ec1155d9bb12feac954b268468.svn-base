package com.csot.recruit.common.util;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;

public class ExcelWriteDemo {

  
  /**
   * 根据数据库查询数据，格式化生成excel并放到输出流中
   * 如果是页面导出，输出流从response中获取，
   *  
   * HSSFWorkbook workbook = openPoMainService.getGridForExport(opvbo, sysUser);
   * OutputStream os;
   * response.setContentType("APPLICATION/vnd.ms-excel");
   * response.setHeader("content-disposition", "attachment;filename=" + sdf.format(new Date()) + ".xls");
   * try {
   *   os = response.getOutputStream();
   *   workbook.write(os);
   *   os.flush();
   *   os.close();
   * } catch (IOException e) {
   *   logger.error(e.getMessage(), e);
   *   throw Throwables.propagate(e);
   * }
   *  
   * 如果是输出写成文件，需申明本地文件输出流
   *  os = new FileOutputStream("d:\\workbook.xls"); 
   * 
   * 
   * */
  public void writeExcel(OutputStream os) {
    
    HSSFWorkbook wb = new HSSFWorkbook();  //--->创建了一个excel文件
    HSSFSheet sheet = wb.createSheet("excel表文件名称");   //--->创建了一个工作簿 
    HSSFDataFormat format= wb.createDataFormat();   //--->单元格内容格式  
    sheet.setColumnWidth((short)3, 20* 256);    //---》设置单元格宽度，因为一个单元格宽度定了那么下面多有的单元格高度都确定了所以这个方法是sheet的    
    sheet.setColumnWidth((short)4, 20* 256);    //--->第一个参数是指哪个单元格，第二个参数是单元格的宽度    
    sheet.setDefaultRowHeight((short)300);    // ---->有得时候你想设置统一单元格的高度，就用这个方法    
    //样式1    
    HSSFCellStyle style = wb.createCellStyle(); // 样式对象    
    style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);// 垂直    
    style.setAlignment(HSSFCellStyle.ALIGN_CENTER);// 水平    
    //设置标题字体格式    
    Font font = wb.createFont();       
    //设置字体样式   ,根据需要选择或添加  
    font.setFontHeightInPoints((short)20);   //--->设置字体大小    
    font.setFontName("Courier New");   //---》设置字体，是什么类型例如：宋体    
    font.setItalic(true);     //--->设置是否是加粗    
    //样式根据需要进行添加，可申明多个样式style进行切换选择
    style.setFont(font);     //--->将字体格式加入到style中       
    //style.setFillForegroundColor(IndexedColors.DARK_YELLOW.getIndex());    
    //style.setFillPattern(CellStyle.SOLID_FOREGROUND);设置单元格颜色    
    style.setWrapText(true);   //设置是否能够换行，能够换行为true    
    style.setBorderBottom((short)1);   //设置下划线，参数是黑线的宽度    
    style.setBorderLeft((short)1);   //设置左边框    
    style.setBorderRight((short)1);   //设置有边框    
    style.setBorderTop((short)1);   //设置下边框    
    style.setDataFormat(format.getFormat("￥#,##0"));    //--->设置为单元格内容为货币格式    
    style.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00%"));    //--->设置单元格内容为百分数格式    
    
    //表格第一行    
    HSSFRow row1 = sheet.createRow(0);   //--->创建一行    
    // 四个参数分别是：起始行，起始列，结束行，结束列   
    sheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 0, (short) 15));//设置单元格合并，首行1到16列
    row1.setHeightInPoints(25);    
    HSSFCell cell1 = row1.createCell(1);   //--->创建一个单元格    
    cell1.setCellStyle(style);    
    cell1.setCellValue("总公司资金运用日报明细表（理财资金）"); 
    
    //填充表头和数据行 
    //表头，title值
    String[] titles = {"代码/品种","投资类型","证券账户","xxxx"};
    //表格第二行 ,设置列名
    HSSFRow row2 = sheet.createRow(1);    
    HSSFCell cell2 = row2.createCell(0);
    for(int j=0;j<=15;j++){
      cell2.setCellStyle(style); //如有其它的样式需求，需要另外创建一个style
      cell2.setCellValue(titles[j]);
    }
    
    //业务数据集合，用于迭代生成excel
    List<String> ls = new ArrayList<String>();
    //表格3到10行
    for(int i=0;i<8;i++){
      //创建第i行
      HSSFRow row = sheet.createRow(i+2);
      
      //单行中1到16列
      for(int j=0;j<=15;j++){
        //创建第j列
        HSSFCell cell = row.createCell(j);
        cell.setCellStyle(style);//如有需要可设置单元格样式
        cell.setCellValue(ls.get(i));   
      }
    }
    
    try {
      //将表格写到输出流中
      wb.write(os);
    } catch (IOException e) {
      //不能直接打印异常，需记录日志，向上抛出异常或者返回页面提示
      e.printStackTrace();
    }
    finally{    
      if(os != null){    
          try {    
            os.close();    
          } catch (IOException e) {    
              e.printStackTrace();    
          }    
      }    
    }
  }
}
