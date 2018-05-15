package org.amberframework.core.excel.poi;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.amberframework.core.excel.poi.anchor.ExcelDataAnchorHandler;
import org.amberframework.core.excel.poi.param.ExcelExportParamCollection;
import org.amberframework.core.excel.poi.param.ExcelExportParameter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.RichTextString;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Throwables;

public class StandardExcelExportService implements ExcelExportService {

  private static final Logger logger = LoggerFactory.getLogger(StandardExcelExportService.class);

  private ExcelDataAnchorHandler excelDataAnchorHandler;

  /**
   * 导出Excel的POI Workbook，2003版本(xls)支持表头表尾和单元格格式，2007版本(xlsx)只支持表头，不支持单元格格式和表尾.
   * 
   * <p>
   * 建议数据量少的对样式要求高的使用xls，如果是数据量大并对样式要求不高的则使用xlsx.
   */
  @Override
  public Workbook exportExcel(Collection<?> dataSet, Map<String, Object> valueMap, Workbook templateClone,
      ExcelExportParamCollection paramCollection) {
    logger.debug("Export Excel Start");

    // Step 1. 使用锚点填充器将固定数值填入Excel中
    Workbook workbook = excelDataAnchorHandler.fillAnchorValueInExcel(valueMap, templateClone);
    // Step 2. 正常填充数据
    Sheet sheet = workbook.getSheetAt(0);
    if (workbook instanceof HSSFWorkbook) {
      fillDataToHssfSheet(dataSet, sheet, workbook, paramCollection);
    } else {
      fillDataToXssfSheet(dataSet, sheet, workbook, paramCollection);
    }

    logger.debug("Export Excel Finish");
    return workbook;
  }

  /**
   * 将行数据填充到2000-2003格式(xls)的Excel中，支持表头表尾.
   * 
   * @param dataSet 要插入的数据集合
   * @param sheet excel sheet
   * @param workbook excel workbook
   * @param paramCollection 导入数据的映射配置
   */
  protected void fillDataToHssfSheet(Collection<?> dataSet, Sheet sheet, Workbook workbook,
      ExcelExportParamCollection paramCollection) {
    // 先记录表尾的行区间，数据先插入在表尾，最后再将表尾从前面移到最后面，再将数据行和表尾整体上移到坐标行位置
    // 最终行数据插入的坐标行位置
    int dataRowStartLocation = excelDataAnchorHandler.findDataRowStartLocation(sheet);
    // 插入行数据前的表尾位置
    int initLastRowLocation = sheet.getLastRowNum();
    // 行数据插入的位置，先插入到表尾后面，最后整体移动到前面的坐标位置
    int rowInsertLocation = initLastRowLocation + 1;

    // 初始化数据行的序号
    int rowIndexNum = 1;
    // 获取坐标行的单元格高度和样式，插入的数据行的格式和行高会按照坐标行的格式来进行设置
    Row plusRow = sheet.getRow(dataRowStartLocation);
    List<CellStyle> styleList = getRowCellsStyle(plusRow);
    short rowheight = plusRow.getHeight();

    // 将单元格高度和样式，sheet和workbook封装到对象中，用于传参
    ExcelRowSettings rowSettings = new ExcelRowSettings();

    rowSettings.setWorkbook(workbook);
    rowSettings.setSheet(sheet);
    rowSettings.setHeight(rowheight);
    rowSettings.setStyleList(styleList);

    // 插入数据行后移动的行步长，在没有子行集合的情况下，就是1
    int rowStepLength = 1;

    // 循环插入数据
    for (Object dataObj : dataSet) {
      rowStepLength = createRowCells(dataObj, paramCollection, rowInsertLocation, rowIndexNum, rowSettings);
      rowInsertLocation += rowStepLength;
      rowIndexNum += rowStepLength;
    }

    // 获取插入数据后的最后一行位置
    int afterLastRowLocation = sheet.getLastRowNum();
    // 把表尾移到插入的数据后面所需移动的长度
    int tailDownShiftLength = afterLastRowLocation - dataRowStartLocation;
    // 表尾移动到插入的数据后，数据和表尾需要上移的长度, 即初始的表尾长度加上[[+]]的那一行的长度
    int dataAndTailUpShiftLength = -(initLastRowLocation - dataRowStartLocation + 1);
    // 把表尾移到插入的数据后面
    if (dataRowStartLocation + 1 <= initLastRowLocation) {
      sheet.shiftRows(dataRowStartLocation + 1, initLastRowLocation, tailDownShiftLength, true, false);
    }
    // 数据和表尾上移，填充原来的[[+]]行和表尾行占据的空间
    sheet.removeRow(plusRow);
    if (initLastRowLocation + 1 <= sheet.getLastRowNum()) {
      sheet.shiftRows(initLastRowLocation + 1, sheet.getLastRowNum(), dataAndTailUpShiftLength, true, false);
    }
  }

  /**
   * 将行数据填充到2007格式(xlsx)的Excel中，仅支持表头，不支持表尾，不支持单元格格式.
   * 
   * @param dataSet 要插入的数据集合
   * @param sheet excel sheet
   * @param workbook excel workbook
   * @param paramCollection 导入数据的映射配置
   */
  protected void fillDataToXssfSheet(Collection<?> dataSet, Sheet sheet, Workbook workbook,
      ExcelExportParamCollection paramCollection) {
    // 获取坐标行位置
    int dataRowStartLocation = excelDataAnchorHandler.findDataRowStartLocation(sheet);

    // 初始化数据行的序号
    int rowIndexNum = 1;
    // 获取坐标行的单元格高度，插入的数据行的行高会按照坐标行的格式来进行设置
    Row plusRow = sheet.getRow(dataRowStartLocation);
    short rowheight = plusRow.getHeight();

    // 数据和表尾上移，填充原来的[[+]]行和表尾行占据的空间
    sheet.removeRow(plusRow);

    // 将单元格高度和样式，sheet和workbook封装到对象中，用于传参
    ExcelRowSettings rowSettings = new ExcelRowSettings();

    rowSettings.setWorkbook(workbook);
    rowSettings.setSheet(sheet);
    rowSettings.setHeight(rowheight);

    // 插入数据行后移动的行步长，在没有子行集合的情况下，就是1
    int rowStepLength = 1;

    // 循环插入数据
    for (Object dataObj : dataSet) {
      rowStepLength =
          createRowCells(dataObj, paramCollection, dataRowStartLocation, rowIndexNum, rowSettings);
      dataRowStartLocation += rowStepLength;
      rowIndexNum += rowStepLength;
    }
  }


  /**
   * 创建数据行和数据行的单元格.
   * 
   * @param dataObj 数据对象
   * @param paramCollection 导出映射配置集合
   * @param rowNum 插入数据的行号
   * @param indexNum 序号
   * @param rowSettings 行格式设置集合，包含sheet和workbook对象
   * @return 插入行的步长，没有子行集合的情况下就是1
   */
  protected int createRowCells(Object dataObj, ExcelExportParamCollection paramCollection, int rowNum,
      int indexNum, ExcelRowSettings rowSettings) {
    Row row = rowSettings.getSheet().createRow(rowNum);
    // 行号先设置为350，之后会根据坐标行格式进行调整
    row.setHeight((short) 350);
    if (paramCollection.isShowIndex()) {
      // 设置序号
      Cell cell = row.createCell(paramCollection.getIndexColumnNum());
      cell.setCellValue(String.valueOf(indexNum));
    }

    List<ExcelExportParameter> paramList = paramCollection.getEntityList();
    for (ExcelExportParameter param : paramList) {
      String value = null;
      Object data = null;
      Collection<?> extColumns = null;
      switch (param.getType()) {
        case ExcelExportParameter.EXPORT_TYPE_CONSTANT_TEXT:
          // 获取常量分支
          value = null == param.getConstantValue() ? "" : param.getConstantValue();
          break;
        // 从集合类中获取动态扩展列
        case ExcelExportParameter.EXPORT_TYPE_DYNAMIC_EXT_COLUMN:
          data = doGetObjectParamData(dataObj, param);
          if (data != null && data instanceof Collection) {
            extColumns = (Collection<?>) data;
          }
          break;
        case ExcelExportParameter.EXPORT_TYPE_PROPERTY_TEXT:
          // 其他情况都获取属性值
        default:
          data = doGetObjectParamData(dataObj, param);
          value = doGetCellValue(data, param);
      }
      if (null != extColumns) {
        // 生成动态扩展列的单元格
        createDynamicExtensionCell(row, extColumns, param, rowSettings.getWorkbook());
      } else {
        // 正常生成单元格
        createStringCell(row, value, param, rowSettings.getWorkbook());
      }
    }
    // 如果是xls，则设置单元格格式和行高；如果是xlsx，则只设置行高
    if (rowSettings.getWorkbook() instanceof HSSFWorkbook) {
      setRowCellsStyle(row, rowSettings.getStyleList());
    }
    row.setHeight(rowSettings.getHeight());
    // 目前没有子行集合，所以一次就新增一行
    return 1;
  }

  /**
   * 循环获取到的扩展列单元格，并创建单元格，赋值.
   * 
   * @param row 数据行对象
   * @param extColumns 扩展列集合对象
   * @param param 数据映射设置
   * @param workbook excel workbook
   */
  protected void createDynamicExtensionCell(Row row, Collection<?> extColumns, ExcelExportParameter param,
      Workbook workbook) {
    Iterator<?> iter = extColumns.iterator();
    int offset = 0;
    Object value = null;
    while (iter.hasNext()) {
      value = iter.next();
      if (value != null) {
        createStringCell(row, value.toString(), param, workbook, offset);
      } else {
        createStringCell(row, StringUtils.EMPTY, param, workbook, offset);
      }
      offset++;
    }
  }

  /**
   * 从数据对象中取出对应属性对象，要求有get方法.
   * 
   * @param dataObj 数据对象
   * @param param 数据映射配置
   * @return 返回属性对象
   */
  private static Object doGetObjectParamData(Object dataObj, ExcelExportParameter param) {
    // 通过反射获取属性，不需要Get方法，很黄很暴力.
    // 具体代码：PropertyUtils的getSimpleProperty(dataObj, param.getName())完毕
    // 以下为通过反射获取Get方法来得到属性
    Class<?> clazz = dataObj.getClass();
    try {
      PropertyDescriptor pd = new PropertyDescriptor(param.getName(), clazz);
      // 获得get方法
      Method getMethod = pd.getReadMethod();
      // 通过Get获取属性值
      return getMethod.invoke(dataObj);
    } catch (IntrospectionException | IllegalAccessException | IllegalArgumentException
        | InvocationTargetException ex) {
      throw Throwables.propagate(ex);
    }
  }

  /**
   * 从属性对象中获取值，如果是日期，就按照映射中的源格式和目标格式转化，否则直接toString.
   * 
   * @param data 属性对象
   * @param param 数据映射设置
   * @return 属性的String类型值
   */
  private static String doGetCellValue(Object data, ExcelExportParameter param) {
    String value = null == data ? "" : data.toString();
    if (StringUtils.isNotEmpty(param.getExportDateFormat())
        && StringUtils.isNotEmpty(param.getSourceDateFormat())) {
      Date tempDate = null;
      if (data instanceof String) {
        SimpleDateFormat format = new SimpleDateFormat(param.getSourceDateFormat());
        try {
          tempDate = format.parse(data.toString());
        } catch (ParseException ex) {
          throw Throwables.propagate(ex);
        }
      } else if (data instanceof Date) {
        tempDate = (Date) data;
      }
      if (tempDate != null) {
        SimpleDateFormat format = new SimpleDateFormat(param.getExportDateFormat());
        value = format.format(tempDate);
      }
    }
    return null == value ? "" : value;
  }

  /**
   * 创建单元格，将值值放入单元格.
   * 
   * <P>
   * 判断Excel的类型，选择插入值的方式，HSSFRichTextString或XSSFRichTextString.
   * 
   * @param row 数据行对象
   * @param value 要插入的属性值
   * @param param 数据映射设置
   * @param workbook excel workbook
   */
  private static void createStringCell(Row row, String value, ExcelExportParameter param, Workbook workbook) {
    createStringCell(row, value, param, workbook, 0);
  }

  /**
   * 创建单元格，将值值放入单元格.
   * 
   * <P>
   * 判断Excel的类型，选择插入值的方式，HSSFRichTextString或XSSFRichTextString.
   * 
   * @param row 数据行对象
   * @param value 要插入的属性值
   * @param param 数据映射设置
   * @param workbook excel workbook
   * @param offset 实际生成列单元格的偏移量，正向右，负向左
   */
  private static void createStringCell(Row row, String value, ExcelExportParameter param, Workbook workbook,
      int offset) {
    Cell cell = null;
    cell = row.getCell(param.getCellIndex() + offset);
    if (null == cell) {
      cell = row.createCell(param.getCellIndex() + offset);
    }
    if (workbook instanceof HSSFWorkbook) {
      RichTextString richTextStr = new HSSFRichTextString(value);
      cell.setCellValue(richTextStr);
    } else {
      cell.setCellValue(value);
    }
  }

  /**
   * 获取一行中所有单元格的格式.
   * 
   * @param row excel row
   * @return 单元格格式集合
   */
  private static List<CellStyle> getRowCellsStyle(Row row) {
    List<CellStyle> styleList = new ArrayList<CellStyle>();
    for (int i = 0; i < row.getLastCellNum(); i++) {
      if (null == row.getCell(i)) {
        styleList.add(null);
      } else {
        styleList.add(row.getCell(i).getCellStyle());
      }
    }
    return styleList;
  }

  /**
   * 为一行的所有单元格，按照格式集合设置单元格格式.
   * 
   * @param row excel row
   * @param styleList 单元格格式集合
   */
  private static void setRowCellsStyle(Row row, List<CellStyle> styleList) {
    for (int i = 0; i < styleList.size(); i++) {
      if (null == row.getCell(i)) {
        // 某一列可能没有配置导入，所以导入数据的时候没有创建这一列的cell，这里要创建一个cell补在这个位置上
        row.createCell(i);
      }
      if (null != styleList.get(i)) {
        row.getCell(i).setCellStyle(styleList.get(i));
      }
    }
  }

  /**
   * 行格式设置集合类，包含sheet和workbook对象属性
   */
  protected class ExcelRowSettings {
    // 行高
    private short height;
    // 行单元格格式
    private List<CellStyle> styleList;
    // sheet
    private Sheet sheet;
    // workbook
    private Workbook workbook;

    public short getHeight() {
      return height;
    }

    public void setHeight(short height) {
      this.height = height;
    }

    public List<CellStyle> getStyleList() {
      return styleList;
    }

    public void setStyleList(List<CellStyle> styleList) {
      this.styleList = styleList;
    }

    public Sheet getSheet() {
      return sheet;
    }

    public void setSheet(Sheet sheet) {
      this.sheet = sheet;
    }

    public Workbook getWorkbook() {
      return workbook;
    }

    public void setWorkbook(Workbook workbook) {
      this.workbook = workbook;
    }
  }

  public ExcelDataAnchorHandler getExcelDataAnchorHandler() {
    return excelDataAnchorHandler;
  }

  public void setExcelDataAnchorHandler(ExcelDataAnchorHandler excelDataAnchorHandler) {
    this.excelDataAnchorHandler = excelDataAnchorHandler;
  }
}
