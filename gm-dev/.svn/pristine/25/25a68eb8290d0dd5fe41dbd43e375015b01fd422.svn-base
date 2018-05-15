package com.csot.gm.materialManage.service.impl.enumValue;

import com.csot.gm.materialManage.dao.extension.enumValue.EnumValueExtMapper;
import com.csot.gm.materialManage.dao.original.enumValue.EnumValueMapper;
import com.csot.gm.materialManage.model.extension.enumValue.EnumValueExt;
import com.csot.gm.materialManage.model.original.enumValue.EnumValue;
import com.csot.gm.materialManage.model.original.enumValue.EnumValueColumns;
import com.csot.gm.materialManage.model.original.enumValue.EnumValueCriteria;
import com.csot.gm.materialManage.service.enumValue.EnumValueService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.excel.poi.ExcelExportManager;
import org.amberframework.core.excel.poi.mapping.ClasspathXmlExcelDataMappingResolver;
import org.amberframework.core.excel.poi.mapping.ExcelDataMappingResolver;
import org.amberframework.core.excel.poi.template.ClasspathExcelTemplateProvider;
import org.amberframework.core.excel.poi.template.ExcelTemplateProvider;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("enumValueService")
public class EnumValueServiceImpl implements EnumValueService {

  @Resource
  private EnumValueMapper enumValueMapper;
  @Resource
  private EnumValueExtMapper enumValueExtMapper;
  @Resource
  private ExcelExportManager excelExportManager;

  @Override
  public MiniRtn2Grid<EnumValue> getGrid(MiniGridPageSort pageSort, String searchKey,
      String enumTypeId) {
    MiniRtn2Grid<EnumValue> grid = new MiniRtn2Grid<EnumValue>();
    EnumValueCriteria criteria = new EnumValueCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    if (StringUtils.hasText(enumTypeId)) {
      criteria.or().andEnumTypeIdEqualTo(enumTypeId);
    }

    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = EnumValueColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(enumValueMapper.selectByExample(criteria));
    grid.setTotal(enumValueMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public EnumValue getByPrimaryKey(String primaryKey) {
    return enumValueMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(EnumValue enumValue) {
    enumValue.setId(UUID.randomUUID().toString().replace("-", ""));
    enumValueMapper.insert(enumValue);
  }

  @Override
  public void updateSelective(EnumValue enumValue) {
    enumValueMapper.updateByPrimaryKeySelective(enumValue);
  }

  @Override
  public void remove(String primaryKey) {
    enumValueMapper.deleteByPrimaryKey(primaryKey);
  }

  /**
   * 根据枚举类ID获取枚举值List
   */
  @Override
  public List<EnumValue> getByEnumTypeId(String enumTypeId) {
    EnumValueCriteria criteria = new EnumValueCriteria();
    criteria.or().andEnumTypeIdEqualTo(enumTypeId);
    return enumValueMapper.selectByExample(criteria);
  }

  @Override
  public boolean isEnumTextExist(EnumValue enumValue) {
    if (StringUtils.hasText(enumValue.getId())) {
      List<EnumValueExt> list =
          enumValueExtMapper.getByEnumButId(enumValue.getEnumValue(), enumValue.getEnumText(),
              enumValue.getId());
      return !list.isEmpty();
    } else {
      List<EnumValueExt> list =
          enumValueExtMapper.getByTypeIdAndEnumText(enumValue.getEnumTypeId(),
              enumValue.getEnumText());
      List<EnumValueExt> list2 =
          enumValueExtMapper.getByTypeIdAndEnumValue(enumValue.getEnumTypeId(),
              enumValue.getEnumValue());
      if (list.isEmpty() && list2.isEmpty()) {
        return false;
      } else {
        return true;
      }
    }
  }

  @Override
  public List<EnumValue> getByEnumTypeIdAndEnumValueLike(String enumTypeId, String enumValue) {
    EnumValueCriteria criteria = new EnumValueCriteria();
    List<EnumValueExt> evList = enumValueExtMapper.getByLikeEnumTextAndValue("%" + enumValue.toUpperCase() + "%");
    if (evList.isEmpty()) {
      return new ArrayList<EnumValue>();
    }
    for (EnumValueExt ev : evList) {
      criteria.or().andEnumTypeIdEqualTo(enumTypeId).andEnumTextEqualTo(ev.getEnumText());
    }
    return enumValueMapper.selectByExample(criteria);
  }

  @Override
  public Workbook exportEnumValueByTemplate(List<EnumValue> list) {
    ExcelTemplateProvider classpathExcelTemplateProvider =
        ClasspathExcelTemplateProvider.newInstance("excelTemplate/EnumValueExportTemplate.xls", 0);

    ExcelDataMappingResolver classpathXmlExcelDataMappingResolver =
        ClasspathXmlExcelDataMappingResolver.newInstance("excelTemplate/EnumValueExportTemplate.xml");

    return excelExportManager.exportExcel(list, null, classpathExcelTemplateProvider,
        classpathXmlExcelDataMappingResolver);
  }

}
