package com.csot.gm.materialManage.service.impl.enumType;

import com.csot.gm.materialManage.dao.extension.enumType.EnumTypeExtMapper;
import com.csot.gm.materialManage.dao.extension.enumValue.EnumValueExtMapper;
import com.csot.gm.materialManage.dao.extension.propertiesM.PropertiesMExtMapper;
import com.csot.gm.materialManage.dao.original.enumType.EnumTypeMapper;
import com.csot.gm.materialManage.dao.original.part.PartMapper;
import com.csot.gm.materialManage.dao.original.properties.PartPropertiesMapper;
import com.csot.gm.materialManage.model.extension.enumType.EnumTypeExt;
import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.model.original.enumType.EnumType;
import com.csot.gm.materialManage.model.original.enumType.EnumTypeColumns;
import com.csot.gm.materialManage.model.original.enumType.EnumTypeCriteria;
import com.csot.gm.materialManage.service.enumType.EnumTypeService;
import com.csot.gm.rawMaterial.model.EnumTypeMember;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("enumTypeService")
public class EnumTypeServiceImpl implements EnumTypeService {

  @Resource
  private EnumTypeMapper enumTypeMapper;
  @Resource
  private EnumTypeExtMapper enumTypeExtMapper;
  @Resource
  private PropertiesMExtMapper propertiesMExtMapper;
  @Resource
  private EnumValueExtMapper enumValueExtMapper;
  @Resource
  private PartPropertiesMapper partPropertiesMapper;
  @Resource
  private PartMapper partMapper;


  @Override
  public MiniRtn2Grid<EnumType> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<EnumType> grid = new MiniRtn2Grid<EnumType>();
    EnumTypeCriteria criteria = new EnumTypeCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andEnumNameLikeInsensitive("%" + searchKey + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = EnumTypeColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(enumTypeMapper.selectByExample(criteria));
    grid.setTotal(enumTypeMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public EnumType getByPrimaryKey(String primaryKey) {
    return enumTypeMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(EnumType enumType) {
    enumType.setId(UUID.randomUUID().toString().replace("-", ""));
    enumTypeMapper.insert(enumType);
  }

  @Override
  public void updateSelective(EnumType enumType) {
    enumTypeMapper.updateByPrimaryKeySelective(enumType);
  }

  @Override
  public void remove(String primaryKey) {
    // 先删除属性类下面的属性值
    enumValueExtMapper.deleteEnumValueByType(primaryKey);
    // 再删除属性类
    enumTypeMapper.deleteByPrimaryKey(primaryKey);
  }

  /**
   * 检查该枚举类是否正在被属性使用
   */
  @Override
  public boolean enumTypeIsUsing(String enumTypeId) {
    List<PropertiesMExt> list = propertiesMExtMapper.getPropertyIdByEnumId(enumTypeId);
    if (!list.isEmpty()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 获取枚举类的属性成员列表
   */
  @Override
  public List<EnumTypeMember> getEnumTypeMemberGrid(String enumTypeId) {
    List<EnumTypeMember> list = new ArrayList<EnumTypeMember>();
    String enumTypeName = enumTypeMapper.selectByPrimaryKey(enumTypeId).getEnumName();
    List<PropertiesMExt> pmeList = propertiesMExtMapper.getPropertyIdByEnumId(enumTypeId);
    if (!pmeList.isEmpty()) {
      for (int i = 0; i < pmeList.size(); i++) {
        String propertyId = pmeList.get(i).getPropertyId();
        String propertyName = partPropertiesMapper.selectByPrimaryKey(propertyId).getPropertyName();
        String partId = partPropertiesMapper.selectByPrimaryKey(propertyId).getPartId();
        String partName = partMapper.selectByPrimaryKey(partId).getPartDesc();
        EnumTypeMember etm = new EnumTypeMember();
        etm.setEnumTypeId(enumTypeId);
        etm.setEnumTypeName(enumTypeName);
        etm.setPartId(partId);
        etm.setPartName(partName);
        etm.setPropertyId(propertyId);
        etm.setPropertyName(propertyName);
        list.add(etm);
      }
    }
    return list;
  }

  @Override
  public boolean enumTypeIsExist(String enumTypeName) {
    List<EnumTypeExt> list = enumTypeExtMapper.selectByDesc(enumTypeName);
    if (list.isEmpty()) {
      return false;
    } else {
      return true;
    }
  }
}
