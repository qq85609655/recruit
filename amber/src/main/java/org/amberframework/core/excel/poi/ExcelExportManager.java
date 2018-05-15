package org.amberframework.core.excel.poi;

import java.util.Collection;
import java.util.Map;

import org.amberframework.core.excel.poi.mapping.ExcelDataMappingResolver;
import org.amberframework.core.excel.poi.template.ExcelTemplateProvider;
import org.apache.poi.ss.usermodel.Workbook;

public interface ExcelExportManager {

  /**
   * 根据数据源、固定填充值、Excel模板提供者和Excel映射配置解析器，进行Excel导出操作，得到最终的导出结果.
   * 
   * @param dataset 数据源
   * @param valueMap 固定填充值
   * @param templateProvider Excel模板提供者
   * @param mappingResolver Excel映射配置解析器
   * @return 导出结果的workbook
   */
  Workbook exportExcel(Collection<?> dataset, Map<String, Object> valueMap,
      ExcelTemplateProvider templateProvider, ExcelDataMappingResolver mappingResolver);
}
