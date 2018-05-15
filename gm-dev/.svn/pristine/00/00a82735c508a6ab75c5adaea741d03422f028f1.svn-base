package org.amberframework.core.excel.poi;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.amberframework.core.excel.poi.anchor.ExcelDataAnchorHandler;
import org.amberframework.core.excel.poi.param.ExcelExportParamCollection;
import org.amberframework.core.excel.poi.param.ExcelExportParameter;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class StandardExcelExportServiceTest {

  private StandardExcelExportService standardExcelExportService = new StandardExcelExportService();

  @Mock
  private ExcelDataAnchorHandler mockAnchorHandler;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    standardExcelExportService.setExcelDataAnchorHandler(mockAnchorHandler);
  }

  @After
  public void tearDown() throws Exception {

  }

  @SuppressWarnings({ "unchecked", "deprecation" })
  @Test
  public void testExportExcel4HSSF() throws IOException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    List<ExportTestStaff> dataSet = new ArrayList<ExportTestStaff>();
    for (int i = 1; i <= 8; i++) {
      ExportTestStaff staff = new ExportTestStaff();
      if (i == 5) {
        staff.setName(null);
      } else {
        staff.setName("Employee" + i);
      }
      staff.setGender(i % 2 != 0);
      staff.setHeight(170.789 + i);
      String indexStr = Integer.toString(i);
      // 小数点前8位，小数点后8位
      staff.setSalary(new BigDecimal(indexStr + indexStr + indexStr + indexStr + indexStr + indexStr
          + indexStr + indexStr + "." + indexStr + indexStr + indexStr + indexStr + indexStr + indexStr
          + indexStr + indexStr));
      Date birthday = new Date();
      birthday.setHours(i);
      staff.setBirthday(birthday);
      Date entryDate = new Date();
      entryDate.setDate(i);
      staff.setEntryDate(format.format(entryDate));
      dataSet.add(staff);
    }

    Map<String, Object> valueMap = new HashMap<String, Object>();
    valueMap.put("creator", "Tester");
    valueMap.put("total", 8);

    HSSFWorkbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet();
    sheet.setDefaultColumnWidth((short) 15);
    Row row0 = sheet.createRow(0);
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
    Cell cell00 = row0.createCell(0, Cell.CELL_TYPE_STRING);
    cell00.setCellValue("Title");
    Row row1 = sheet.createRow(1);
    Cell cell10 = row1.createCell(0, Cell.CELL_TYPE_STRING);
    cell10.setCellValue("Index");
    Cell cell11 = row1.createCell(1, Cell.CELL_TYPE_STRING);
    cell11.setCellValue("Name");
    Cell cell12 = row1.createCell(2, Cell.CELL_TYPE_STRING);
    cell12.setCellValue("Gender");
    Cell cell13 = row1.createCell(3, Cell.CELL_TYPE_STRING);
    cell13.setCellValue("Height");
    Cell cell14 = row1.createCell(4, Cell.CELL_TYPE_STRING);
    cell14.setCellValue("Salary");
    Cell cell15 = row1.createCell(5, Cell.CELL_TYPE_STRING);
    cell15.setCellValue("Birthday");
    Cell cell16 = row1.createCell(6, Cell.CELL_TYPE_STRING);
    cell16.setCellValue("EntryDate");

    Row row2 = sheet.createRow(2);

    {
      Cell cell20 = row2.createCell(0);
      cell20.setCellValue("[[+]]");
      // name style
      Cell cell21 = row2.createCell(1, Cell.CELL_TYPE_STRING);
      CellStyle style21 = workbook.createCellStyle();
      style21.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.index);
      style21.setFillPattern(CellStyle.SOLID_FOREGROUND);
      Font font21 = workbook.createFont();
      font21.setColor(HSSFColor.VIOLET.index);
      font21.setFontHeightInPoints((short) 12);
      font21.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
      style21.setFont(font21);
      cell21.setCellStyle(style21);
    }

    {
      Cell cell22 = row2.createCell(2, Cell.CELL_TYPE_BOOLEAN);
      // gender style
      CellStyle style22 = workbook.createCellStyle();
      style22.setFillForegroundColor(IndexedColors.LIGHT_ORANGE.index);
      style22.setFillPattern(CellStyle.SOLID_FOREGROUND);
      Font font22 = workbook.createFont();
      font22.setColor(HSSFColor.VIOLET.index);
      font22.setFontHeightInPoints((short) 12);
      font22.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
      style22.setFont(font22);
      cell22.setCellStyle(style22);
    }

    {
      Cell cell23 = row2.createCell(3, Cell.CELL_TYPE_NUMERIC);
      // height style
      CellStyle style23 = workbook.createCellStyle();
      style23.setFillForegroundColor(IndexedColors.LIGHT_BLUE.index);
      style23.setFillPattern(CellStyle.SOLID_FOREGROUND);
      Font font23 = workbook.createFont();
      font23.setColor(HSSFColor.VIOLET.index);
      font23.setFontHeightInPoints((short) 12);
      font23.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
      style23.setFont(font23);
      cell23.setCellStyle(style23);
    }

    {
      Cell cell24 = row2.createCell(4, Cell.CELL_TYPE_NUMERIC);
      // salary style
      CellStyle style24 = workbook.createCellStyle();
      style24.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
      style24.setFillPattern(CellStyle.SOLID_FOREGROUND);
      Font font24 = workbook.createFont();
      font24.setFontHeightInPoints((short) 16);
      style24.setFont(font24);
      cell24.setCellStyle(style24);
    }

    {
      Cell cell25 = row2.createCell(5, Cell.CELL_TYPE_STRING);
      // birthday style
      CellStyle style25 = workbook.createCellStyle();
      style25.setFillForegroundColor(IndexedColors.PINK.index);
      style25.setFillPattern(CellStyle.SOLID_FOREGROUND);
      Font font25 = workbook.createFont();
      font25.setFontHeightInPoints((short) 10);
      style25.setFont(font25);
      cell25.setCellStyle(style25);
    }

    {
      Cell cell26 = row2.createCell(6, Cell.CELL_TYPE_STRING);
      // birthday style
      CellStyle style26 = workbook.createCellStyle();
      style26.setFillForegroundColor(IndexedColors.PINK.index);
      style26.setFillPattern(CellStyle.SOLID_FOREGROUND);
      Font font26 = workbook.createFont();
      font26.setFontHeightInPoints((short) 10);
      style26.setFont(font26);
      cell26.setCellStyle(style26);
    }

    Row row3 = sheet.createRow(3);
    Cell cell30 = row3.createCell(0, Cell.CELL_TYPE_STRING);
    cell30.setCellValue("IndexEnd");
    Cell cell31 = row3.createCell(1, Cell.CELL_TYPE_STRING);
    cell31.setCellValue("NameEnd");
    Cell cell32 = row3.createCell(2, Cell.CELL_TYPE_STRING);
    cell32.setCellValue("GenderEnd");
    Cell cell33 = row3.createCell(3, Cell.CELL_TYPE_STRING);
    cell33.setCellValue("HeightEnd");
    Cell cell34 = row3.createCell(4, Cell.CELL_TYPE_STRING);
    cell34.setCellValue("SalaryEnd");
    Cell cell35 = row3.createCell(5, Cell.CELL_TYPE_STRING);
    cell35.setCellValue("BirthdayEnd");
    Cell cell36 = row3.createCell(6, Cell.CELL_TYPE_STRING);
    cell36.setCellValue("EntryDateEnd");

    ExcelExportParamCollection paramCollection = new ExcelExportParamCollection();
    paramCollection.setIndexColumnNum(0);
    paramCollection.setShowIndex(true);
    List<ExcelExportParameter> paramList = new ArrayList<ExcelExportParameter>();

    ExcelExportParameter nameParam = new ExcelExportParameter();
    nameParam.setCellIndex(1);
    nameParam.setName("name");
    nameParam.setType(0);
    paramList.add(nameParam);
    ExcelExportParameter genderParam = new ExcelExportParameter();
    genderParam.setCellIndex(2);
    genderParam.setName("gender");
    genderParam.setType(0);
    paramList.add(genderParam);
    ExcelExportParameter heightParam = new ExcelExportParameter();
    heightParam.setCellIndex(3);
    heightParam.setName("height");
    heightParam.setType(0);
    paramList.add(heightParam);
    ExcelExportParameter salaryParam = new ExcelExportParameter();
    salaryParam.setCellIndex(4);
    salaryParam.setName("salary");
    salaryParam.setType(0);
    paramList.add(salaryParam);
    ExcelExportParameter birthdayParam = new ExcelExportParameter();
    birthdayParam.setCellIndex(5);
    birthdayParam.setName("birthday");
    birthdayParam.setType(0);
    birthdayParam.setSourceDateFormat("yyyy/MM/dd HH:mm:ss");
    birthdayParam.setExportDateFormat("yyyy-MM-dd HH:mm:ss");
    paramList.add(birthdayParam);
    ExcelExportParameter entryDateParam = new ExcelExportParameter();
    entryDateParam.setCellIndex(6);
    entryDateParam.setName("entryDate");
    entryDateParam.setType(0);
    entryDateParam.setSourceDateFormat("yyyy-MM-dd HH:mm:ss");
    entryDateParam.setExportDateFormat("yyyy/MM/dd HH:mm:ss");
    paramList.add(entryDateParam);

    paramCollection.setEntityList(paramList);

    // Mock ExcelDataAnchorHandler
    when(mockAnchorHandler.fillAnchorValueInExcel((Map<String, Object>) any(), any(Workbook.class)))
        .thenAnswer(new Answer<Workbook>() {

          @Override
          public Workbook answer(InvocationOnMock invocation) throws Throwable {
            return invocation.getArgumentAt(1, Workbook.class);
          }

        });
    when(mockAnchorHandler.findDataRowStartLocation(any(Sheet.class))).thenReturn(2);

    // 执行Excel导出
    Workbook outputBook =
        standardExcelExportService.exportExcel(dataSet, valueMap, workbook, paramCollection);

    // 验证导出结果
    Sheet outputSheet = outputBook.getSheetAt(0);
    int validLastRowNum = outputSheet.getLastRowNum();
    assertEquals(11, validLastRowNum);

    Row validLastRow = outputSheet.getRow(10);
    assertEquals("EntryDateEnd", validLastRow.getCell(6).getStringCellValue());

    Row validDataRow1 = outputSheet.getRow(2);
    Cell validIndexCell1 = validDataRow1.getCell(0);
    assertEquals("1", validIndexCell1.getStringCellValue());
    Cell validNameCell1 = validDataRow1.getCell(1);
    assertEquals(IndexedColors.BRIGHT_GREEN.index, validNameCell1.getCellStyle().getFillForegroundColor());
    assertEquals("Employee1", validNameCell1.getStringCellValue());

    Row validDataRow5 = outputSheet.getRow(6);
    Cell validNameCell5 = validDataRow5.getCell(1);
    assertEquals("", validNameCell5.getStringCellValue());
    Cell validGenderCell5 = validDataRow5.getCell(2);
    assertEquals(IndexedColors.LIGHT_ORANGE.index, validGenderCell5.getCellStyle().getFillForegroundColor());
    assertEquals("true", validGenderCell5.getStringCellValue());
    Cell validHeightCell5 = validDataRow5.getCell(3);
    assertEquals("175.789", validHeightCell5.getStringCellValue());
    Cell validSalaryCell5 = validDataRow5.getCell(4);
    assertEquals("55555555.55555555", validSalaryCell5.getStringCellValue());
    Cell validBirthdayCell5 = validDataRow5.getCell(5);
    assertEquals(format.format(dataSet.get(4).getBirthday()), validBirthdayCell5.getStringCellValue());
    Cell validEntryDateCell5 = validDataRow5.getCell(6);
    String entryDate5 = validEntryDateCell5.getStringCellValue().replace('-', '/');
    assertEquals(entryDate5, validEntryDateCell5.getStringCellValue());

    // 输出到本地磁盘
//    OutputStream outStream = null;
//    try {
//      outStream = new FileOutputStream("E://excelOutputUnitTest.xls");
//      outputBook.write(outStream);
//    } catch (IOException ex) {
//      throw ex;
//    } finally {
//      outStream.close();
//      outputBook.close();
//    }
  }
  
  @SuppressWarnings({ "deprecation", "unchecked" })
  @Test
  public void testExportExcel4XSSF() throws IOException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    List<ExportTestStaff> dataSet = new ArrayList<ExportTestStaff>();
    for (int i = 1; i <= 8; i++) {
      ExportTestStaff staff = new ExportTestStaff();
      if (i == 5) {
        staff.setName(null);
      } else {
        staff.setName("Employee" + i);
      }
      staff.setGender(i % 2 != 0);
      staff.setHeight(170.789 + i);
      String indexStr = Integer.toString(i);
      // 小数点前8位，小数点后8位
      staff.setSalary(new BigDecimal(indexStr + indexStr + indexStr + indexStr + indexStr + indexStr
          + indexStr + indexStr + "." + indexStr + indexStr + indexStr + indexStr + indexStr + indexStr
          + indexStr + indexStr));
      Date birthday = new Date();
      birthday.setHours(i);
      staff.setBirthday(birthday);
      Date entryDate = new Date();
      entryDate.setDate(i);
      staff.setEntryDate(format.format(entryDate));
      dataSet.add(staff);
    }

    Map<String, Object> valueMap = new HashMap<String, Object>();
    valueMap.put("creator", "Tester");
    valueMap.put("total", 8);

    XSSFWorkbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet();
    sheet.setDefaultColumnWidth((short) 15);
    Row row0 = sheet.createRow(0);
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
    Cell cell00 = row0.createCell(0, Cell.CELL_TYPE_STRING);
    cell00.setCellValue("Title");
    Row row1 = sheet.createRow(1);
    Cell cell10 = row1.createCell(0, Cell.CELL_TYPE_STRING);
    cell10.setCellValue("Index");
    Cell cell11 = row1.createCell(1, Cell.CELL_TYPE_STRING);
    cell11.setCellValue("Name");
    Cell cell12 = row1.createCell(2, Cell.CELL_TYPE_STRING);
    cell12.setCellValue("Gender");
    Cell cell13 = row1.createCell(3, Cell.CELL_TYPE_STRING);
    cell13.setCellValue("Height");
    Cell cell14 = row1.createCell(4, Cell.CELL_TYPE_STRING);
    cell14.setCellValue("Salary");
    Cell cell15 = row1.createCell(5, Cell.CELL_TYPE_STRING);
    cell15.setCellValue("Birthday");
    Cell cell16 = row1.createCell(6, Cell.CELL_TYPE_STRING);
    cell16.setCellValue("EntryDate");

    Row row2 = sheet.createRow(2);

    Cell cell20 = row2.createCell(0);
    cell20.setCellValue("[[+]]");

    row2.createCell(2, Cell.CELL_TYPE_BOOLEAN);
    
    row2.createCell(3, Cell.CELL_TYPE_NUMERIC);

    row2.createCell(4, Cell.CELL_TYPE_NUMERIC);
    
    row2.createCell(5, Cell.CELL_TYPE_STRING);
    
    row2.createCell(6, Cell.CELL_TYPE_STRING);

    ExcelExportParamCollection paramCollection = new ExcelExportParamCollection();
    paramCollection.setIndexColumnNum(0);
    paramCollection.setShowIndex(true);
    List<ExcelExportParameter> paramList = new ArrayList<ExcelExportParameter>();

    ExcelExportParameter nameParam = new ExcelExportParameter();
    nameParam.setCellIndex(1);
    nameParam.setName("name");
    nameParam.setType(0);
    paramList.add(nameParam);
    ExcelExportParameter genderParam = new ExcelExportParameter();
    genderParam.setCellIndex(2);
    genderParam.setName("gender");
    genderParam.setType(0);
    paramList.add(genderParam);
    ExcelExportParameter heightParam = new ExcelExportParameter();
    heightParam.setCellIndex(3);
    heightParam.setName("height");
    heightParam.setType(0);
    paramList.add(heightParam);
    ExcelExportParameter salaryParam = new ExcelExportParameter();
    salaryParam.setCellIndex(4);
    salaryParam.setName("salary");
    salaryParam.setType(0);
    paramList.add(salaryParam);
    ExcelExportParameter birthdayParam = new ExcelExportParameter();
    birthdayParam.setCellIndex(5);
    birthdayParam.setName("birthday");
    birthdayParam.setType(0);
    birthdayParam.setSourceDateFormat("yyyy/MM/dd HH:mm:ss");
    birthdayParam.setExportDateFormat("yyyy-MM-dd HH:mm:ss");
    paramList.add(birthdayParam);
    ExcelExportParameter entryDateParam = new ExcelExportParameter();
    entryDateParam.setCellIndex(6);
    entryDateParam.setName("entryDate");
    entryDateParam.setType(0);
    entryDateParam.setSourceDateFormat("yyyy-MM-dd HH:mm:ss");
    entryDateParam.setExportDateFormat("yyyy/MM/dd HH:mm:ss");
    paramList.add(entryDateParam);

    paramCollection.setEntityList(paramList);

    // Mock ExcelDataAnchorHandler
    when(mockAnchorHandler.fillAnchorValueInExcel((Map<String, Object>) any(), any(Workbook.class)))
        .thenAnswer(new Answer<Workbook>() {

          @Override
          public Workbook answer(InvocationOnMock invocation) throws Throwable {
            return invocation.getArgumentAt(1, Workbook.class);
          }

        });
    when(mockAnchorHandler.findDataRowStartLocation(any(Sheet.class))).thenReturn(2);

    // 执行Excel导出
    Workbook outputBook =
        standardExcelExportService.exportExcel(dataSet, valueMap, workbook, paramCollection);

    // 验证导出结果
    Sheet outputSheet = outputBook.getSheetAt(0);
    int validLastRowNum = outputSheet.getLastRowNum();
    assertEquals(9, validLastRowNum);

    Row validDataRow1 = outputSheet.getRow(2);
    Cell validIndexCell1 = validDataRow1.getCell(0);
    assertEquals("1", validIndexCell1.getStringCellValue());
    Cell validNameCell1 = validDataRow1.getCell(1);
    assertEquals("Employee1", validNameCell1.getStringCellValue());

    Row validDataRow5 = outputSheet.getRow(6);
    Cell validNameCell5 = validDataRow5.getCell(1);
    assertEquals("", validNameCell5.getStringCellValue());
    Cell validGenderCell5 = validDataRow5.getCell(2);
    assertEquals("true", validGenderCell5.getStringCellValue());
    Cell validHeightCell5 = validDataRow5.getCell(3);
    assertEquals("175.789", validHeightCell5.getStringCellValue());
    Cell validSalaryCell5 = validDataRow5.getCell(4);
    assertEquals("55555555.55555555", validSalaryCell5.getStringCellValue());
    Cell validBirthdayCell5 = validDataRow5.getCell(5);
    assertEquals(format.format(dataSet.get(4).getBirthday()), validBirthdayCell5.getStringCellValue());
    Cell validEntryDateCell5 = validDataRow5.getCell(6);
    String entryDate5 = validEntryDateCell5.getStringCellValue().replace('-', '/');
    assertEquals(entryDate5, validEntryDateCell5.getStringCellValue());

    // 输出到本地磁盘
//    OutputStream outStream = null;
//    try {
//      outStream = new FileOutputStream("E://excelOutputUnitTest.xlsx");
//      outputBook.write(outStream);
//    } catch (IOException ex) {
//      throw ex;
//    } finally {
//      outStream.close();
//      outputBook.close();
//    }
  }
  
  @SuppressWarnings({ "deprecation", "unchecked" })
  @Test
  public void testExportExcel4XSSFBigData() throws IOException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    List<ExportTestStaff> dataSet = new ArrayList<ExportTestStaff>();
    int testDataCount = 50;
    for (int i = 1; i <= testDataCount; i++) {
      ExportTestStaff staff = new ExportTestStaff();
      staff.setName("Employee" + i);
      staff.setGender(false);
      staff.setHeight(i);
      String indexStr = Integer.toString(i);
      // 小数点前8位，小数点后8位
      staff.setSalary(new BigDecimal(indexStr));
      Date birthday = new Date();
      birthday.setHours(i);
      staff.setBirthday(birthday);
      Date entryDate = new Date();
      entryDate.setDate(i);
      staff.setEntryDate(format.format(entryDate));
      dataSet.add(staff);
    }

    Map<String, Object> valueMap = new HashMap<String, Object>();
    valueMap.put("creator", "Tester");
    valueMap.put("total", 8);

    XSSFWorkbook workbook = new XSSFWorkbook();
    Sheet sheet = workbook.createSheet();
    sheet.setDefaultColumnWidth((short) 15);
    Row row0 = sheet.createRow(0);
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
    Cell cell00 = row0.createCell(0, Cell.CELL_TYPE_STRING);
    cell00.setCellValue("Title");
    Row row1 = sheet.createRow(1);
    Cell cell10 = row1.createCell(0, Cell.CELL_TYPE_STRING);
    cell10.setCellValue("Index");
    Cell cell11 = row1.createCell(1, Cell.CELL_TYPE_STRING);
    cell11.setCellValue("Name");
    Cell cell12 = row1.createCell(2, Cell.CELL_TYPE_STRING);
    cell12.setCellValue("Gender");
    Cell cell13 = row1.createCell(3, Cell.CELL_TYPE_STRING);
    cell13.setCellValue("Height");
    Cell cell14 = row1.createCell(4, Cell.CELL_TYPE_STRING);
    cell14.setCellValue("Salary");
    Cell cell15 = row1.createCell(5, Cell.CELL_TYPE_STRING);
    cell15.setCellValue("Birthday");
    Cell cell16 = row1.createCell(6, Cell.CELL_TYPE_STRING);
    cell16.setCellValue("EntryDate");

    Row row2 = sheet.createRow(2);

    Cell cell20 = row2.createCell(0);
    cell20.setCellValue("[[+]]");

    row2.createCell(2, Cell.CELL_TYPE_BOOLEAN);
    
    row2.createCell(3, Cell.CELL_TYPE_NUMERIC);

    row2.createCell(4, Cell.CELL_TYPE_NUMERIC);
    
    row2.createCell(5, Cell.CELL_TYPE_STRING);
    
    row2.createCell(6, Cell.CELL_TYPE_STRING);

    ExcelExportParamCollection paramCollection = new ExcelExportParamCollection();
    paramCollection.setIndexColumnNum(0);
    paramCollection.setShowIndex(true);
    List<ExcelExportParameter> paramList = new ArrayList<ExcelExportParameter>();

    ExcelExportParameter nameParam = new ExcelExportParameter();
    nameParam.setCellIndex(1);
    nameParam.setName("name");
    nameParam.setType(0);
    paramList.add(nameParam);
    ExcelExportParameter genderParam = new ExcelExportParameter();
    genderParam.setCellIndex(2);
    genderParam.setName("gender");
    genderParam.setType(0);
    paramList.add(genderParam);
    ExcelExportParameter heightParam = new ExcelExportParameter();
    heightParam.setCellIndex(3);
    heightParam.setName("height");
    heightParam.setType(0);
    paramList.add(heightParam);
    ExcelExportParameter salaryParam = new ExcelExportParameter();
    salaryParam.setCellIndex(4);
    salaryParam.setName("salary");
    salaryParam.setType(0);
    paramList.add(salaryParam);
    ExcelExportParameter birthdayParam = new ExcelExportParameter();
    birthdayParam.setCellIndex(5);
    birthdayParam.setName("birthday");
    birthdayParam.setType(0);
    birthdayParam.setSourceDateFormat("yyyy/MM/dd HH:mm:ss");
    birthdayParam.setExportDateFormat("yyyy-MM-dd HH:mm:ss");
    paramList.add(birthdayParam);
    ExcelExportParameter entryDateParam = new ExcelExportParameter();
    entryDateParam.setCellIndex(6);
    entryDateParam.setName("entryDate");
    entryDateParam.setType(0);
    entryDateParam.setSourceDateFormat("yyyy-MM-dd HH:mm:ss");
    entryDateParam.setExportDateFormat("yyyy/MM/dd HH:mm:ss");
    paramList.add(entryDateParam);

    paramCollection.setEntityList(paramList);

    // Mock ExcelDataAnchorHandler
    when(mockAnchorHandler.fillAnchorValueInExcel((Map<String, Object>) any(), any(Workbook.class)))
        .thenAnswer(new Answer<Workbook>() {

          @Override
          public Workbook answer(InvocationOnMock invocation) throws Throwable {
            return invocation.getArgumentAt(1, Workbook.class);
          }

        });
    when(mockAnchorHandler.findDataRowStartLocation(any(Sheet.class))).thenReturn(2);

    // 执行Excel导出
    Workbook outputBook =
        standardExcelExportService.exportExcel(dataSet, valueMap, workbook, paramCollection);

    // 验证导出结果
    Sheet outputSheet = outputBook.getSheetAt(0);
    int validLastRowNum = outputSheet.getLastRowNum();
    assertEquals(testDataCount + 1, validLastRowNum);

    // 输出到本地磁盘
//    OutputStream outStream = null;
//    try {
//      outStream = new FileOutputStream("E://excelOutputBigDataUnitTest.xlsx");
//      outputBook.write(outStream);
//    } catch (IOException ex) {
//      throw ex;
//    } finally {
//      outStream.close();
//      outputBook.close();
//    }
  }
  
  @SuppressWarnings("unchecked")
  @Test
  public void testExportExcel4ExtColumn() throws IOException {

    List<ExportTestMaterialPlan> dataSet = new ArrayList<ExportTestMaterialPlan>();
    ExportTestMaterialPlan materialPlanTitle = new ExportTestMaterialPlan();
    materialPlanTitle.setMaterialName("MaterialName");
    materialPlanTitle.setSupplierName("SupplierName");
    List<String> quantitiesTitle = new ArrayList<String>();
    quantitiesTitle.add("9/1");
    quantitiesTitle.add("9/2");
    quantitiesTitle.add("9/3");
    quantitiesTitle.add("9/4");
    quantitiesTitle.add("9/5");
    quantitiesTitle.add("9/6");
    quantitiesTitle.add("9/7");
    quantitiesTitle.add("9/8");
    quantitiesTitle.add("9/9");
    quantitiesTitle.add("9/10");
    materialPlanTitle.setPlannedQuantitis(quantitiesTitle);
    dataSet.add(materialPlanTitle);
    
    int testDataCount = 50;
    
    for (int i = 1; i <= testDataCount; i++) {
      ExportTestMaterialPlan materialPlan = new ExportTestMaterialPlan();
      materialPlan.setMaterialName("Material" + i);
      materialPlan.setSupplierName("Supplier" + i);
      List<String> quantities = new ArrayList<String>();
      quantities.add(Integer.toString(i * 1));
      quantities.add(Integer.toString(i * 2));
      quantities.add(Integer.toString(i * 3));
      quantities.add(Integer.toString(i * 4));
      quantities.add(Integer.toString(i * 5));
      quantities.add(Integer.toString(i * 6));
      quantities.add(Integer.toString(i * 7));
      quantities.add(Integer.toString(i * 8));
      quantities.add(Integer.toString(i * 9));
      quantities.add(Integer.toString(i * 10));
      materialPlan.setPlannedQuantitis(quantities);
      dataSet.add(materialPlan);
    }

    Map<String, Object> valueMap = new HashMap<String, Object>();
    valueMap.put("creator", "Tester");
    valueMap.put("total", testDataCount);

    Workbook workbook = new HSSFWorkbook();
    Sheet sheet = workbook.createSheet();
    sheet.setDefaultColumnWidth((short) 15);
    Row row0 = sheet.createRow(0);
    sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 6));
    Cell cell00 = row0.createCell(0, Cell.CELL_TYPE_STRING);
    cell00.setCellValue("Title");

    Row row1 = sheet.createRow(1);

    Cell cell10 = row1.createCell(0);
    cell10.setCellValue("[[+]]");

    ExcelExportParamCollection paramCollection = new ExcelExportParamCollection();
    paramCollection.setIndexColumnNum(0);
    paramCollection.setShowIndex(true);
    List<ExcelExportParameter> paramList = new ArrayList<ExcelExportParameter>();

    ExcelExportParameter materialNameParam = new ExcelExportParameter();
    materialNameParam.setCellIndex(1);
    materialNameParam.setName("materialName");
    materialNameParam.setType(0);
    paramList.add(materialNameParam);
    ExcelExportParameter supplierNameParam = new ExcelExportParameter();
    supplierNameParam.setCellIndex(2);
    supplierNameParam.setName("supplierName");
    supplierNameParam.setType(0);
    paramList.add(supplierNameParam);
    ExcelExportParameter constantParam = new ExcelExportParameter();
    constantParam.setCellIndex(3);
    constantParam.setConstantValue("Y");
    constantParam.setType(1);
    paramList.add(constantParam);
    ExcelExportParameter plannedQuantitisParam = new ExcelExportParameter();
    plannedQuantitisParam.setCellIndex(4);
    plannedQuantitisParam.setName("plannedQuantitis");
    plannedQuantitisParam.setType(3);
    paramList.add(plannedQuantitisParam);

    paramCollection.setEntityList(paramList);

    // Mock ExcelDataAnchorHandler
    when(mockAnchorHandler.fillAnchorValueInExcel((Map<String, Object>) any(), any(Workbook.class)))
        .thenAnswer(new Answer<Workbook>() {

          @Override
          public Workbook answer(InvocationOnMock invocation) throws Throwable {
            return invocation.getArgumentAt(1, Workbook.class);
          }

        });
    when(mockAnchorHandler.findDataRowStartLocation(any(Sheet.class))).thenReturn(1);

    // 执行Excel导出
    Workbook outputBook =
        standardExcelExportService.exportExcel(dataSet, valueMap, workbook, paramCollection);

    // 验证导出结果
    Sheet outputSheet = outputBook.getSheetAt(0);
    int validLastRowNum = outputSheet.getLastRowNum();
    Row outputRow1 = outputSheet.getRow(1);
    Cell outputCell0113 = outputRow1.getCell(13);
    assertEquals("9/10", outputCell0113.getStringCellValue());
    assertEquals(0, outputRow1.getFirstCellNum());
    assertEquals(14, outputRow1.getLastCellNum());
    assertEquals(testDataCount + 1, validLastRowNum);

    // 输出到本地磁盘
    // OutputStream outStream = null;
    // try {
    // outStream = new FileOutputStream("E://excelOutputExtColumnUnitTest.xls");
    // outputBook.write(outStream);
    // } catch (IOException ex) {
    // throw ex;
    // } finally {
    // outStream.close();
    // outputBook.close();
    // }
  }
}
