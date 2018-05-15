package com.csot.gm.materialManage.service.impl.valueEnumM;

import com.csot.gm.materialManage.dao.extension.valueEnumM.ValueEnumMExtMapper;
import com.csot.gm.materialManage.dao.original.valueEnumM.ValueEnumMMapper;
import com.csot.gm.materialManage.model.original.valueEnumM.ValueEnumM;
import com.csot.gm.materialManage.model.original.valueEnumM.ValueEnumMColumns;
import com.csot.gm.materialManage.model.original.valueEnumM.ValueEnumMCriteria;
import com.csot.gm.materialManage.service.valueEnumM.ValueEnumMService;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("valueEnumMService")
public class ValueEnumMServiceImpl implements ValueEnumMService {
  private static final Logger logger = LoggerFactory.getLogger(ValueEnumMServiceImpl.class);

  @Resource
  private ValueEnumMMapper valueEnumMMapper;
  @Resource
  private ValueEnumMExtMapper valueEnumMExtMapper;

  @Override
  public MiniRtn2Grid<ValueEnumM> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<ValueEnumM> grid = new MiniRtn2Grid<ValueEnumM>();
    ValueEnumMCriteria criteria = new ValueEnumMCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = ValueEnumMColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(valueEnumMMapper.selectByExample(criteria));
    grid.setTotal(valueEnumMMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public ValueEnumM getByPrimaryKey(String primaryKey) {
    return valueEnumMMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(ValueEnumM valueEnumM) {
    valueEnumM.setId(UUID.randomUUID().toString().replace("-", ""));
    valueEnumMMapper.insert(valueEnumM);
  }

  @Override
  public void updateSelective(ValueEnumM valueEnumM) {
    valueEnumMMapper.updateByPrimaryKeySelective(valueEnumM);
  }

  @Override
  public void remove(String primaryKey) {
    valueEnumMMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public ValueEnumM getByValueId(String valueId) {
    List<ValueEnumM> list = valueEnumMExtMapper.getByValueId(valueId);
    if (list.size() == 1) {
      return list.get(0);
    } else {
      logger.error("联动关系有误");
      return null;
    }
  }

  @Override
  public void updateValueEnumMByValueId(String enumTypeId, String valueId) {
    List<ValueEnumM> data = valueEnumMExtMapper.getByValueId(valueId);
    if (!data.isEmpty()) {
      valueEnumMExtMapper.updateValueEnumMByValueId(valueId, enumTypeId);
    } else {
      ValueEnumM vem = new ValueEnumM();
      vem.setEnumTypeId(enumTypeId);
      vem.setEnumValueId(valueId);
      vem.setId(UUID.randomUUID().toString().replace("-", ""));
      valueEnumMMapper.insert(vem);
    }

  }
}
