package org.amberframework.core.excel.poi.anchor;

import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelDataAnchorHandler {

  /**
   * 根据占位符，向文件中插入数据.
   * 
   * @param valueMap 数据键值对集合
   * @param workbook 带有占位符的Excel workbook
   * @return 添加数据后的Excel workbook
   */
  Workbook fillAnchorValueInExcel(Map<String, Object> valueMap, Workbook workbook);
  
  /**
   * 根据坐标占位符，确定数据源插入的起始行号(从0开始算起).
   * 
   * @param sheet POI sheet
   * @return 行号，从0开始算
   */
  int findDataRowStartLocation(Sheet sheet);
}
