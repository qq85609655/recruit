package org.amberframework.core.excel.poi.template;

import static org.junit.Assert.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClasspathExcelTemplateProviderTest {

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testDoGetExcelTemplateCloneWithPath() {
    {
      ClasspathExcelTemplateProvider classpathExcelTemplateProvider1 =
          ClasspathExcelTemplateProvider.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest01.xls", 1);
      Workbook workbook = classpathExcelTemplateProvider1.doGetExcelTemplateClone();
      assertEquals(1, workbook.getNumberOfSheets());
      Sheet sheet = workbook.getSheetAt(0);
      Row row0 = sheet.getRow(0);
      assertEquals("Header2", row0.getCell(0).getStringCellValue());
      Row row3 = sheet.getRow(3);
      assertEquals("[[+]]", row3.getCell(0).getStringCellValue());
    }

    {
      ClasspathExcelTemplateProvider classpathExcelTemplateProvider2 =
          ClasspathExcelTemplateProvider.newInstanceWithPath("ForExcelExportUnitTest02.xls", 0, "excelTemplate/unitTest/excelTest");
      Workbook workbook = classpathExcelTemplateProvider2.doGetExcelTemplateClone();
      assertEquals(1, workbook.getNumberOfSheets());
      Sheet sheet = workbook.getSheetAt(0);
      Row row4 = sheet.getRow(4);
      assertEquals("Footer1", row4.getCell(0).getStringCellValue());
      Row row3 = sheet.getRow(1);
      assertEquals("{${name}}", row3.getCell(1).getStringCellValue());
      assertEquals("{${date}}", row3.getCell(3).getStringCellValue());
    }

  }
  
  @Test
  public void testNewInstance() {
    ClasspathExcelTemplateProvider classpathExcelTemplateProvider1 =
        ClasspathExcelTemplateProvider.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest01.xls", 1);
    assertEquals("excelTemplate/unitTest/ForExcelExportUnitTest01.xls", classpathExcelTemplateProvider1.fileName);
    assertEquals("", classpathExcelTemplateProvider1.relativePath);
    assertEquals(1, classpathExcelTemplateProvider1.sheetIndex);
    
    ClasspathExcelTemplateProvider classpathExcelTemplateProvider2 =
        ClasspathExcelTemplateProvider.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest01.xls", -1);
    assertEquals(0, classpathExcelTemplateProvider2.sheetIndex);
  }
  
  @Test
  public void testNewInstanceWithPath() {
    ClasspathExcelTemplateProvider classpathExcelTemplateProvider1 =
        ClasspathExcelTemplateProvider.newInstanceWithPath("ForExcelExportUnitTest02.xls", 2, "excelTemplate/unitTest/excelTest");
    assertEquals("ForExcelExportUnitTest02.xls", classpathExcelTemplateProvider1.fileName);
    assertEquals("excelTemplate/unitTest/excelTest", classpathExcelTemplateProvider1.relativePath);
    assertEquals(2, classpathExcelTemplateProvider1.sheetIndex);
    
    ClasspathExcelTemplateProvider classpathExcelTemplateProvider2 =
        ClasspathExcelTemplateProvider.newInstanceWithPath("excelTemplate/unitTest/ForExcelExportUnitTest01.xls", -2, null);
    assertEquals(0, classpathExcelTemplateProvider2.sheetIndex);
    assertEquals("", classpathExcelTemplateProvider2.relativePath);
  }

}
