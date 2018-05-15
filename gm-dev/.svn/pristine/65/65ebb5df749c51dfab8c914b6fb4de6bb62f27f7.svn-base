package com.csot.gm.materialManage.service.impl.typePartM;

import com.csot.gm.materialManage.dao.extension.typePartM.TypePartMExtMapper;
import com.csot.gm.materialManage.dao.original.typePartM.TypePartMMapper;
import com.csot.gm.materialManage.model.original.typePartM.TypePartM;
import com.csot.gm.materialManage.model.original.typePartM.TypePartMColumns;
import com.csot.gm.materialManage.model.original.typePartM.TypePartMCriteria;
import com.csot.gm.materialManage.service.typePartM.TypePartMService;

import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("typePartMService")
public class TypePartMServiceImpl implements TypePartMService {

  @Resource
  private TypePartMMapper typePartMMapper;
  @Resource
  private TypePartMExtMapper typePartMExtMapper;

  @Override
  public MiniRtn2Grid<TypePartM> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<TypePartM> grid = new MiniRtn2Grid<TypePartM>();
    TypePartMCriteria criteria = new TypePartMCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = TypePartMColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(typePartMMapper.selectByExample(criteria));
    grid.setTotal(typePartMMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public TypePartM getByPrimaryKey(String primaryKey) {
    return typePartMMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(TypePartM typePartM) {
    typePartM.setId(UUID.randomUUID().toString().replace("-", ""));
    typePartMMapper.insert(typePartM);
  }

  @Override
  public void updateSelective(TypePartM typePartM) {
    typePartMMapper.updateByPrimaryKeySelective(typePartM);
  }

  @Override
  public void remove(String primaryKey) {
    typePartMMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public void removeByPartId(String partId) {
    typePartMExtMapper.deleteByPartId(partId);
  }
}
