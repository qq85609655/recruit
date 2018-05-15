package com.csot.gm.materialManage.service.impl.propertiesM;

import com.csot.gm.materialManage.dao.extension.enumType.EnumTypeExtMapper;
import com.csot.gm.materialManage.dao.extension.propertiesM.PropertiesMExtMapper;
import com.csot.gm.materialManage.dao.original.propertiesM.PropertiesMMapper;
import com.csot.gm.materialManage.model.extension.enumType.EnumTypeExt;
import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.model.original.propertiesM.PropertiesM;
import com.csot.gm.materialManage.model.original.propertiesM.PropertiesMColumns;
import com.csot.gm.materialManage.model.original.propertiesM.PropertiesMCriteria;
import com.csot.gm.materialManage.service.propertiesM.PropertiesMService;
import com.csot.gm.rawMaterial.model.PartClassTree;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("propertiesMService")
public class PropertiesMServiceImpl implements PropertiesMService {

  @Resource
  private PropertiesMMapper propertiesMMapper;
  @Resource
  private PropertiesMExtMapper propertiesMExtMapper;
  @Resource
  private EnumTypeExtMapper enumTypeExtMapper;

  @Override
  public MiniRtn2Grid<PropertiesM> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<PropertiesM> grid = new MiniRtn2Grid<PropertiesM>();
    PropertiesMCriteria criteria = new PropertiesMCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PropertiesMColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(propertiesMMapper.selectByExample(criteria));
    grid.setTotal(propertiesMMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public PropertiesM getByPrimaryKey(String primaryKey) {
    return propertiesMMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PropertiesM propertiesM) {
    propertiesM.setId(UUID.randomUUID().toString().replace("-", ""));
    propertiesMMapper.insert(propertiesM);
  }

  @Override
  public void updateSelective(PropertiesM propertiesM) {
    propertiesMMapper.updateByPrimaryKeySelective(propertiesM);
  }

  @Override
  public void remove(String primaryKey) {
    propertiesMMapper.deleteByPrimaryKey(primaryKey);
  }

  /**
   * 获取所有枚举类List
   */
  @Override
  public List<PartClassTree> getEnumTypeList() {
    List<PartClassTree> list = new ArrayList<PartClassTree>();
    List<EnumTypeExt> etList = enumTypeExtMapper.selectAllEnumType();
    if (!etList.isEmpty()) {
      for (int i = 0; i < etList.size(); i++) {
        String enumTypeId = etList.get(i).getId();
        String enumTypeName = etList.get(i).getEnumName();
        PartClassTree parentTree = new PartClassTree();
        parentTree.setId(enumTypeId);
        parentTree.setName(enumTypeName);
        list.add(parentTree);
      }
    }

    return list;
  }

  /**
   * 更新属性的恶对应枚举值
   * 
   * @param enumTypeId
   * @param propertyId
   */
  @Override
  public void updateEnumTypeByPropertyId(String enumTypeId, String propertyId) {
    List<PropertiesMExt> data = propertiesMExtMapper.getEnumIdByPropertyId(propertyId);
    if (!data.isEmpty()) {
      propertiesMExtMapper.updateEnumTypeByPropertyId(propertyId, enumTypeId);
    } else {
      PropertiesM pm = new PropertiesM();
      pm.setEnumId(enumTypeId);
      pm.setPropertyId(propertyId);
      pm.setId(UUID.randomUUID().toString().replace("-", ""));
      propertiesMMapper.insert(pm);
    }

  }

  /**
   * 根据属性id获取对应的属性值枚举类id
   */
  @Override
  public List<PropertiesMExt> getByPropertyId(String propertyId) {
    return propertiesMExtMapper.getEnumIdByPropertyId(propertyId);
  }
}
