package org.amberframework.core.excel.poi.mapping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.amberframework.core.excel.poi.param.ExcelExportParamCollection;
import org.amberframework.core.excel.poi.param.ExcelExportParameter;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClasspathXmlExcelDataMappingResolverTest {

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testNewInstance() {
    ClasspathXmlExcelDataMappingResolver classpathXmlExcelDataMappingResolver =
        ClasspathXmlExcelDataMappingResolver.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest01.xml");
    assertEquals("excelTemplate/unitTest/ForExcelExportUnitTest01.xml", classpathXmlExcelDataMappingResolver.fileName);
    assertEquals("", classpathXmlExcelDataMappingResolver.relativePath);
  }

  @Test
  public void testNewInstanceWithPath() {
    ClasspathXmlExcelDataMappingResolver classpathXmlExcelDataMappingResolver1 =
        ClasspathXmlExcelDataMappingResolver.newInstanceWithPath("ForExcelExportUnitTest02.xml", "excelTemplate/unitTest/excelTest");
    assertEquals("ForExcelExportUnitTest02.xml", classpathXmlExcelDataMappingResolver1.fileName);
    assertEquals("excelTemplate/unitTest/excelTest", classpathXmlExcelDataMappingResolver1.relativePath);

    ClasspathXmlExcelDataMappingResolver classpathXmlExcelDataMappingResolver2 =
        ClasspathXmlExcelDataMappingResolver.newInstanceWithPath("excelTemplate/unitTest/ForExcelExportUnitTest02.xml", null);
    assertEquals("excelTemplate/unitTest/ForExcelExportUnitTest02.xml", classpathXmlExcelDataMappingResolver2.fileName);
    assertEquals("", classpathXmlExcelDataMappingResolver2.relativePath);
  }

  @Test
  public void testDoGetExcelDataMapping() {
    {
      ClasspathXmlExcelDataMappingResolver classpathXmlExcelDataMappingResolver =
          ClasspathXmlExcelDataMappingResolver.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest01.xml");
      ExcelExportParamCollection excelExport = classpathXmlExcelDataMappingResolver.doGetExcelDataMapping();
      assertTrue(excelExport.isShowIndex());
      assertEquals(0, excelExport.getIndexColumnNum());
      List<ExcelExportParameter> params = excelExport.getEntityList();
      assertEquals(6, params.size());
      assertEquals("name", params.get(0).getName());
      assertEquals(1, params.get(0).getCellIndex());
      assertEquals(ExcelExportParameter.EXPORT_TYPE_PROPERTY_TEXT, params.get(0).getType());
      assertEquals("entryDate", params.get(5).getName());
      assertEquals(6, params.get(5).getCellIndex());
      assertEquals(ExcelExportParameter.EXPORT_TYPE_PROPERTY_TEXT, params.get(5).getType());
      assertEquals("yyyy-MM-dd HH:mm:ss", params.get(5).getSourceDateFormat());
      assertEquals("yyyy/MM/dd HH:mm:ss", params.get(5).getExportDateFormat());
    }

    {
      ClasspathXmlExcelDataMappingResolver classpathXmlExcelDataMappingResolver =
          ClasspathXmlExcelDataMappingResolver.newInstanceWithPath("ForExcelExportUnitTest02.xml",
              "excelTemplate/unitTest/excelTest");
      ExcelExportParamCollection excelExport = classpathXmlExcelDataMappingResolver.doGetExcelDataMapping();
      assertTrue(excelExport.isShowIndex());
      assertEquals(0, excelExport.getIndexColumnNum());
      List<ExcelExportParameter> params = excelExport.getEntityList();
      assertEquals(6, params.size());
      assertEquals("name", params.get(0).getName());
      assertEquals(1, params.get(0).getCellIndex());
      assertEquals(ExcelExportParameter.EXPORT_TYPE_PROPERTY_TEXT, params.get(0).getType());
      assertEquals("entryDate", params.get(5).getName());
      assertEquals(6, params.get(5).getCellIndex());
      assertEquals(ExcelExportParameter.EXPORT_TYPE_PROPERTY_TEXT, params.get(5).getType());
      assertEquals("yyyy-MM-dd HH:mm:ss", params.get(5).getSourceDateFormat());
      assertEquals("yyyy/MM/dd HH:mm:ss", params.get(5).getExportDateFormat());
    }
    
    {
      ClasspathXmlExcelDataMappingResolver classpathXmlExcelDataMappingResolver =
          ClasspathXmlExcelDataMappingResolver.newInstance("excelTemplate/unitTest/ForExcelExportUnitTest05.xml");
      ExcelExportParamCollection excelExport = classpathXmlExcelDataMappingResolver.doGetExcelDataMapping();
      assertTrue(excelExport.isShowIndex());
      assertEquals(0, excelExport.getIndexColumnNum());
      List<ExcelExportParameter> params = excelExport.getEntityList();
      assertEquals(8, params.size());
      assertEquals("my comments", params.get(6).getConstantValue());
      assertEquals(7, params.get(6).getCellIndex());
      assertEquals(ExcelExportParameter.EXPORT_TYPE_CONSTANT_TEXT, params.get(6).getType());
      assertEquals("my constants", params.get(7).getConstantValue());
      assertEquals(8, params.get(7).getCellIndex());
      assertEquals(ExcelExportParameter.EXPORT_TYPE_CONSTANT_TEXT, params.get(7).getType());
    }
  }

}
