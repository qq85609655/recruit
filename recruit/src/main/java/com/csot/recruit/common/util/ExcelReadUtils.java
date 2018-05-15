package com.csot.recruit.common.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;

/**
 * excel 解析工具类，新添加
 * */
public class ExcelReadUtils {

  
  /**
   * 获取公式后文本的值，又要根据类型进行判断拿不同的值.传入数字格式
   * 
   * @Description: getFromulaValue方法.
   * @return String
   */
  public static String getFromulaValue(DecimalFormat numberformat, Cell cell) {
    String value = null;
    FormulaEvaluator evaluator =
        cell.getSheet().getWorkbook().getCreationHelper().createFormulaEvaluator();
    evaluator.evaluateFormulaCell(cell);
    CellValue cellValue = evaluator.evaluate(cell);
    if (cellValue.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
      value = String.valueOf(cellValue.getBooleanValue());
    } else if (cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
      // 获取公式后面为数字，也有可能为日期的数据
      value = getNumberDateCellValue(numberformat, cell, cellValue.getNumberValue());
    } else if (cellValue.getCellType() == Cell.CELL_TYPE_BLANK) {
      value = "";
    } else if (cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
      value = cellValue.getStringValue();
    }
    return value;
  }
  
  /**
   * 获取数字类型单元格的值，且这个单元格有可能为日期.
   * 
   * @Description: getNumberDateCellValue方法.
   * @return String
   */
  public static String getNumberDateCellValue(DecimalFormat numberformat, Cell cell, double val) {
    String value = null;
    // 单元格是否为日期
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    if (HSSFDateUtil.isCellDateFormatted(cell)) {
      double douValue = cell.getNumericCellValue();
      Date date = HSSFDateUtil.getJavaDate(douValue);
      value = dateFormat.format(date);
    } else {
      value = String.valueOf(numberformat.format(val));
    }
    return value;
  }
  
  /**
   * . 获取单元格的值.
   * 
   * @Description: getValue方法.
   * @return String
   */
  public static String getValue(Cell cell) {
    String value;
    if (null != cell) {
      // # 一个数字，不包括 0 取小数的三位
      DecimalFormat numberformat = new DecimalFormat("###.###");
      // 根据单元格类型获取不同的string值
      switch (cell.getCellType()) {
        // 如果是个公式，则取公式中最后的值
        case Cell.CELL_TYPE_FORMULA:
          value = getFromulaValue(numberformat, cell);
          break;
        case Cell.CELL_TYPE_STRING:
          value = cell.getStringCellValue();
          break;
        case Cell.CELL_TYPE_BOOLEAN:
          value = String.valueOf(cell.getBooleanCellValue());
          break;
          
        case Cell.CELL_TYPE_NUMERIC:
          // 含有科学计数法的进行format之后就正常了。。。cell.getNumericCellValue()
          value = getNumberDateCellValue(numberformat, cell, cell.getNumericCellValue());
          break;
          
        case Cell.CELL_TYPE_BLANK:
          value = "";
          break;
        default:
          return "";
      }
    } else {
      value = "";
    }
    return value;
  }
  
}
