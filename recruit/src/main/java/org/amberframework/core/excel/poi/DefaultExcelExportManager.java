package org.amberframework.core.excel.poi;

import java.util.Collection;
import java.util.Map;

import org.amberframework.core.excel.poi.mapping.ExcelDataMappingResolver;
import org.amberframework.core.excel.poi.param.ExcelExportParamCollection;
import org.amberframework.core.excel.poi.template.ExcelTemplateProvider;
import org.apache.poi.ss.usermodel.Workbook;

public class DefaultExcelExportManager implements ExcelExportManager {

  private ExcelExportService excelExportService;

  @Override
  public Workbook exportExcel(Collection<?> dataset, Map<String, Object> valueMap,
      ExcelTemplateProvider templateProvider, ExcelDataMappingResolver mappingResolver) {
    Workbook workbook = templateProvider.doGetExcelTemplateClone();
    ExcelExportParamCollection paramCollection = mappingResolver.doGetExcelDataMapping();
    return excelExportService.exportExcel(dataset, valueMap, workbook, paramCollection);
  }

  public ExcelExportService getExcelExportService() {
    return excelExportService;
  }

  public void setExcelExportService(ExcelExportService excelExportService) {
    this.excelExportService = excelExportService;
  }

}
