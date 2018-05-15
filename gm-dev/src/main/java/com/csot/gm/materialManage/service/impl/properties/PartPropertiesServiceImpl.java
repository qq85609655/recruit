package com.csot.gm.materialManage.service.impl.properties;

import com.csot.gm.materialManage.dao.extension.properties.PartPropertiesExtMapper;
import com.csot.gm.materialManage.dao.extension.propertiesM.PropertiesMExtMapper;
import com.csot.gm.materialManage.dao.original.properties.PartPropertiesMapper;
import com.csot.gm.materialManage.dao.original.propertiesM.PropertiesMMapper;
import com.csot.gm.materialManage.model.extension.properties.PartPropertiesExt;
import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.model.original.properties.PartProperties;
import com.csot.gm.materialManage.model.original.properties.PartPropertiesColumns;
import com.csot.gm.materialManage.model.original.properties.PartPropertiesCriteria;
import com.csot.gm.materialManage.service.properties.PartPropertiesService;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("partPropertiesService")
public class PartPropertiesServiceImpl implements PartPropertiesService {

  @Resource
  private PartPropertiesMapper partPropertiesMapper;
  @Resource
  private PartPropertiesExtMapper partPropertiesExtMapper;
  @Resource
  private PropertiesMExtMapper propertiesMExtMapper;
  @Resource
  private PropertiesMMapper propertiesMMapper;

  @Override
  public MiniRtn2Grid<PartProperties> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<PartProperties> grid = new MiniRtn2Grid<PartProperties>();
    PartPropertiesCriteria criteria = new PartPropertiesCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PartPropertiesColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(partPropertiesMapper.selectByExample(criteria));
    grid.setTotal(partPropertiesMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public PartProperties getByPrimaryKey(String primaryKey) {
    return partPropertiesMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(PartProperties partProperties) {
    partProperties.setId(UUID.randomUUID().toString().replace("-", ""));
    partPropertiesMapper.insert(partProperties);
  }

  @Override
  public void updateSelective(PartProperties partProperties) {
    partPropertiesMapper.updateByPrimaryKeySelective(partProperties);
  }

  @Override
  public void remove(String primaryKey) {
    // 如果属性有匹配下拉，先删除下拉与属性的mapping
    List<PropertiesMExt> list = propertiesMExtMapper.getEnumIdByPropertyId(primaryKey);
    if (!list.isEmpty()) {
      propertiesMMapper.deleteByPrimaryKey(list.get(0).getId());
    }
    partPropertiesMapper.deleteByPrimaryKey(primaryKey);
  }

  /**
   * 根据物料ID获取所有的属性
   * 
   * @param partId
   * @return
   */
  @Override
  public List<PartPropertiesExt> getByPartId(String partId) {
    return partPropertiesExtMapper.getPropertiesByPartId(partId);
  }

  @Override
  public String getProUnit(String partId, String proName) {
    List<PartPropertiesExt> list =
        partPropertiesExtMapper.getPropertyByPartIdAndProName(partId, proName);
    String proUnit = "";
    if (!list.isEmpty()) {
      proUnit = list.get(0).getPropertyUnit();
    }
    return proUnit;
  }
}
