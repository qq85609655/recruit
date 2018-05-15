package org.amberframework.core.excel.poi;

import java.util.Collection;
import java.util.Map;

import org.amberframework.core.excel.poi.param.ExcelExportParamCollection;
import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelExportService {

  /**
   * 导出Excel.
   * 
   * @param dataSet 数据源
   * @param valueMap 需要单独替换的数据
   * @param templateClone Excel导出模板
   * @param paramCollection 数据导出映射集合
   * @return 添加数据后的Excel workbook
   */
  Workbook exportExcel(Collection<?> dataSet, Map<String, Object> valueMap, Workbook templateClone,
      ExcelExportParamCollection paramCollection);
}
