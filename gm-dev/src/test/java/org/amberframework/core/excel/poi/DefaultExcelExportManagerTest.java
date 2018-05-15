package org.amberframework.core.excel.poi;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.amberframework.core.excel.poi.mapping.ClasspathXmlExcelDataMappingResolver;
import org.amberframework.core.excel.poi.mapping.ExcelDataMappingResolver;
import org.amberframework.core.excel.poi.template.ClasspathExcelTemplateProvider;
import org.amberframework.core.excel.poi.template.ExcelTemplateProvider;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:test-spring-context.xml" })
public class DefaultExcelExportManagerTest {

  @Resource
  private ExcelExportManager excelExportManager;

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testExportExcelValueMapLess() throws IOException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    List<ExportTestStaff> dataSet = new ArrayList<ExportTestStaff>();
    for (int i = 1; i <= 8; i++) {
      ExportTestStaff staff = new ExportTestStaff();
      staff.setName("Employee" + i);
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
    valueMap.put("name", "Tester");
    valueMap.put("total", 8);

    ExcelTemplateProvider classpathExcelTemplateProvider =
        ClasspathExcelTemplateProvider.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest05.xls", 0);

    ExcelDataMappingResolver classpathXmlExcelDataMappingResolver =
        ClasspathXmlExcelDataMappingResolver.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest05.xml");

    Workbook workbook =
        excelExportManager.exportExcel(dataSet, valueMap, classpathExcelTemplateProvider,
            classpathXmlExcelDataMappingResolver);

    Sheet outputSheet = workbook.getSheetAt(0);
    int validLastRowNum = outputSheet.getLastRowNum();
    assertEquals(11, validLastRowNum);

    Row validLastRow = outputSheet.getRow(10);
    assertEquals("IndexEndTester", validLastRow.getCell(0).getStringCellValue());
    assertEquals("Name8End", validLastRow.getCell(1).getStringCellValue());
    assertEquals("GenderTester8End", validLastRow.getCell(2).getStringCellValue());
    assertEquals("BirthdayEnd", validLastRow.getCell(5).getStringCellValue());
    assertEquals("EntryDateEnd", validLastRow.getCell(6).getStringCellValue());

    Row validDataRow1 = outputSheet.getRow(2);
    Cell validIndexCell1 = validDataRow1.getCell(0);
    assertEquals("1", validIndexCell1.getStringCellValue());
    Cell validNameCell1 = validDataRow1.getCell(1);
    assertEquals(IndexedColors.BRIGHT_GREEN.index, validNameCell1.getCellStyle().getFillForegroundColor());
    assertEquals("Employee1", validNameCell1.getStringCellValue());
    Cell validCommentsCell1 = validDataRow1.getCell(7);
    assertEquals("my comments", validCommentsCell1.getStringCellValue());
    Cell validConstantsCell1 = validDataRow1.getCell(8);
    assertEquals("my constants", validConstantsCell1.getStringCellValue());

    Row validDataRow5 = outputSheet.getRow(6);
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
    Cell validCommentsCell5 = validDataRow1.getCell(7);
    assertEquals("my comments", validCommentsCell5.getStringCellValue());
    Cell validConstantsCell5 = validDataRow1.getCell(8);
    assertEquals("my constants", validConstantsCell5.getStringCellValue());

    // 输出到本地磁盘
    // OutputStream outStream = null;
    // try {
    // outStream = new FileOutputStream("E://excelOutputManagerUnitTest1.xls");
    // workbook.write(outStream);
    // } catch (IOException ex) {
    // throw ex;
    // } finally {
    // outStream.close();
    // workbook.close();
    // }
  }

  @Test
  public void testExportExcelWithPath() throws IOException {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    List<ExportTestStaff> dataSet = new ArrayList<ExportTestStaff>();
    for (int i = 1; i <= 8; i++) {
      ExportTestStaff staff = new ExportTestStaff();
      staff.setName("Employee" + i);
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
    valueMap.put("name", "Tester");
    valueMap.put("date", "2015-09-02 17:21:00");
    valueMap.put("total", 8);

    ClasspathExcelTemplateProvider classpathExcelTemplateProvider =
        ClasspathExcelTemplateProvider.newInstanceWithPath("ForExcelExportUnitTest04.xls", 1, "excelTemplate/unitTest/excelTest");

    ClasspathXmlExcelDataMappingResolver classpathXmlExcelDataMappingResolver =
        ClasspathXmlExcelDataMappingResolver.newInstanceWithPath("ForExcelExportUnitTest02.xml", "excelTemplate/unitTest/excelTest");

    Workbook workbook =
        excelExportManager.exportExcel(dataSet, valueMap, classpathExcelTemplateProvider,
            classpathXmlExcelDataMappingResolver);

    Sheet outputSheet = workbook.getSheetAt(0);
    int validLastRowNum = outputSheet.getLastRowNum();
    assertEquals(11, validLastRowNum);

    Row validLastRow = outputSheet.getRow(10);
    assertEquals("IndexEndTester", validLastRow.getCell(0).getStringCellValue());
    assertEquals("Name8End", validLastRow.getCell(1).getStringCellValue());
    assertEquals("GenderTester8End", validLastRow.getCell(2).getStringCellValue());
    assertEquals("2015-09-02 17:21:00BirthdayEnd", validLastRow.getCell(5).getStringCellValue());
    assertEquals("EntryDateEnd", validLastRow.getCell(6).getStringCellValue());

    Row validDataRow1 = outputSheet.getRow(2);
    Cell validIndexCell1 = validDataRow1.getCell(0);
    assertEquals("1", validIndexCell1.getStringCellValue());
    Cell validNameCell1 = validDataRow1.getCell(1);
    assertEquals(IndexedColors.BRIGHT_GREEN.index, validNameCell1.getCellStyle().getFillForegroundColor());
    assertEquals("Employee1", validNameCell1.getStringCellValue());

    Row validDataRow5 = outputSheet.getRow(6);
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
    Cell validCommentsCell5 = validDataRow5.getCell(7);
    assertNotNull(validCommentsCell5);
    assertEquals("", validCommentsCell5.getStringCellValue());

    // 输出到本地磁盘
    // OutputStream outStream = null;
    // try {
    // outStream = new FileOutputStream("E://excelOutputManagerUnitTest2.xls");
    // workbook.write(outStream);
    // } catch (IOException ex) {
    // throw ex;
    // } finally {
    // outStream.close();
    // workbook.close();
    // }
  }

}
