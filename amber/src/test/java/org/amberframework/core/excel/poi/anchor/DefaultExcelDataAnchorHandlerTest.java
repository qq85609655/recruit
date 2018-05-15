package org.amberframework.core.excel.poi.anchor;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.amberframework.core.excel.poi.template.ClasspathExcelTemplateProvider;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DefaultExcelDataAnchorHandlerTest {

  private Workbook workbook;

  @Before
  public void setUp() throws Exception {
    ClasspathExcelTemplateProvider classpathExcelTemplateProvider =
        ClasspathExcelTemplateProvider.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest01.xls", 1);
    workbook = classpathExcelTemplateProvider.doGetExcelTemplateClone();

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testFillAnchorValueInExcelLessValue() {
    DefaultExcelDataAnchorHandler anchorHandler = new DefaultExcelDataAnchorHandler();
    Map<String, Object> valueMap = new HashMap<String, Object>();
    valueMap.put("name", "Jeck");
    Workbook outputBook = anchorHandler.fillAnchorValueInExcel(valueMap, workbook);

    Sheet sheet = outputBook.getSheetAt(0);
    assertEquals("Jeck", sheet.getRow(1).getCell(1).getStringCellValue());
    assertEquals("", sheet.getRow(1).getCell(3).getStringCellValue());
  }

  @Test
  public void testFillAnchorValueInExcel() {
    DefaultExcelDataAnchorHandler anchorHandler = new DefaultExcelDataAnchorHandler();
    Map<String, Object> valueMap = new HashMap<String, Object>();
    valueMap.put("name", "Jeck");
    valueMap.put("date", "2015-09-01 16:02:00");
    Workbook outputBook = anchorHandler.fillAnchorValueInExcel(valueMap, workbook);

    Sheet sheet = outputBook.getSheetAt(0);
    assertEquals("Jeck", sheet.getRow(1).getCell(1).getStringCellValue());
    assertEquals("2015-09-01 16:02:00", sheet.getRow(1).getCell(3).getStringCellValue());
  }

  @Test
  public void testFindDataRowStartLocation() {
    DefaultExcelDataAnchorHandler anchorHandler = new DefaultExcelDataAnchorHandler();
    Sheet sheet = workbook.getSheetAt(0);
    assertEquals(3, anchorHandler.findDataRowStartLocation(sheet));
  }

  @Test
  public void testFindDataRowStartLocationNoAnchor() {
    {
      ClasspathExcelTemplateProvider classpathExcelTemplateProvider1 =
          ClasspathExcelTemplateProvider.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest01.xls", 3);
      Workbook workbook1 = classpathExcelTemplateProvider1.doGetExcelTemplateClone();
      DefaultExcelDataAnchorHandler anchorHandler1 = new DefaultExcelDataAnchorHandler();
      Sheet sheet1 = workbook1.getSheetAt(0);
      assertEquals(2, anchorHandler1.findDataRowStartLocation(sheet1));
    }
    {
      ClasspathExcelTemplateProvider classpathExcelTemplateProvider2 =
          ClasspathExcelTemplateProvider.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest01.xls", 4);
      Workbook workbook2 = classpathExcelTemplateProvider2.doGetExcelTemplateClone();
      DefaultExcelDataAnchorHandler anchorHandler2 = new DefaultExcelDataAnchorHandler();
      Sheet sheet2 = workbook2.getSheetAt(0);
      assertEquals(0, anchorHandler2.findDataRowStartLocation(sheet2));
    }
  }

}
