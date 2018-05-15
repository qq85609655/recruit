package org.amberframework.core.excel.poi.anchor;

import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultExcelDataAnchorHandler implements ExcelDataAnchorHandler {

  private static final Logger logger = LoggerFactory.getLogger(DefaultExcelDataAnchorHandler.class);

  public static final String FILL_VALUE_ANCHOR_PREFIX = "{${";
  public static final String FILL_VALUE_ANCHOR_SUFFIX = "}}";
  public static final String INSERT_DATASET_ANCHOR = "[[+]]";

  /**
   * 根据占位符，向文件中插入数据.
   * <P>
   * 默认占位符标识：{${xxx}}.其中xxx是key，左右分别为“{${”，“}}”.
   */
  @Override
  public Workbook fillAnchorValueInExcel(Map<String, Object> valueMap, Workbook workbook) {
    Sheet sheet = workbook.getSheetAt(0);
    Iterator<Row> rows = sheet.rowIterator();
    Row row;
    while (rows.hasNext()) {
      row = rows.next();
      for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
        if (null != row.getCell(i)) {
          setValueForCellByMap(row.getCell(i), valueMap);
        }
      }
    }
    return workbook;
  }

  /**
   * 根据坐标占位符，确定数据源插入的起始行号(从0开始算起).如果没找到就返回最大行号加一（从0算起）.
   * <P>
   * 默认坐标占位符标识： [[+]]
   */
  @Override
  public int findDataRowStartLocation(Sheet sheet) {
    Iterator<Row> rows = sheet.rowIterator();
    Row row;
    while (rows.hasNext()) {
      row = rows.next();
      for (int i = row.getFirstCellNum(); i < row.getLastCellNum(); i++) {
        if (existDataRowStartAnchor(row.getCell(i))) {
          return row.getRowNum();
        }
      }
    }
    int lastRowNum = sheet.getLastRowNum();
    // 如果lastRowNum大于0则表示Sheet中有数据，需要从下一行起；如果为0表示Sheet中无数据，从第0行起
    return lastRowNum > 0 ? lastRowNum + 1 : 0;
  }

  private static void setValueForCellByMap(Cell cell, Map<String, Object> valueMap) {
    String oldStr;
    // 判断这个cell里面是不是函数
    try {
      oldStr = cell.getStringCellValue();
    } catch (RuntimeException ex) {
      logger.info(ex.getMessage(), ex);
      return;
    }
    if (oldStr != null && oldStr.indexOf(FILL_VALUE_ANCHOR_PREFIX) != -1) {
      String param;
      while (oldStr.indexOf(FILL_VALUE_ANCHOR_PREFIX) != -1) {
        param =
            new String(oldStr.substring(
                oldStr.indexOf(FILL_VALUE_ANCHOR_PREFIX) + FILL_VALUE_ANCHOR_PREFIX.length(),
                oldStr.indexOf(FILL_VALUE_ANCHOR_SUFFIX)));
        oldStr =
            oldStr.replace(FILL_VALUE_ANCHOR_PREFIX + param + FILL_VALUE_ANCHOR_SUFFIX,
                getParamsValue(param.trim(), valueMap));
      }
      cell.setCellValue(oldStr);
    }
  }

  private static String getParamsValue(String key, Map<String, Object> valueMap) {
    return valueMap.containsKey(key) ? valueMap.get(key).toString() : "";
  }

  private static boolean existDataRowStartAnchor(Cell cell) {
    if (null == cell) {
      return false;
    }
    String value = cell.getStringCellValue();
    if (null == value) {
      return false;
    }
    return value.contains(INSERT_DATASET_ANCHOR);
  }
}
