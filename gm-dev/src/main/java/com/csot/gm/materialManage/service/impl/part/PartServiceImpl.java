package com.csot.gm.materialManage.service.impl.part;

import com.csot.gm.materialManage.dao.extension.typePartM.TypePartMExtMapper;
import com.csot.gm.materialManage.dao.original.part.PartMapper;
import com.csot.gm.materialManage.dao.original.partType.PartTypeMapper;
import com.csot.gm.materialManage.model.extension.typePartM.TypePartMExt;
import com.csot.gm.materialManage.model.original.part.Part;
import com.csot.gm.materialManage.model.original.part.PartColumns;
import com.csot.gm.materialManage.model.original.part.PartCriteria;
import com.csot.gm.materialManage.model.original.partType.PartType;
import com.csot.gm.materialManage.service.part.PartService;
import com.csot.gm.rawMaterial.model.Result4CheckPartType;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("partService")
public class PartServiceImpl implements PartService {

  @Resource
  private PartMapper partMapper;
  @Resource
  private TypePartMExtMapper typePartMExtMapper;
  @Resource
  private PartTypeMapper partTypeMapper;

  @Override
  public MiniRtn2Grid<Part> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<Part> grid = new MiniRtn2Grid<Part>();
    PartCriteria criteria = new PartCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.or().andIdEqualTo(searchKey);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = PartColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(partMapper.selectByExample(criteria));
    grid.setTotal(partMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public Part getByPrimaryKey(String primaryKey) {
    return partMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(Part part) {
    part.setId(UUID.randomUUID().toString().replace("-", ""));
    partMapper.insert(part);
  }

  @Override
  public void updateSelective(Part part) {
    partMapper.updateByPrimaryKeySelective(part);
  }

  @Override
  public void remove(String primaryKey) {
    partMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public Result4CheckPartType checkIsPLMType(String partId, String partType) {
    Result4CheckPartType result = new Result4CheckPartType();
    List<TypePartMExt> tpmList = typePartMExtMapper.getByPartId(partId);
    if (!tpmList.isEmpty()) {
      String partTypeId = tpmList.get(0).getPartTypeId();
      PartType pt = partTypeMapper.selectByPrimaryKey(partTypeId);
      // 创建维修料号自动通过
      if ("C4_WXLH".equals(pt.getPartTypeRealName())) {
        result.setPartType(pt.getPartTypeDisName());
        result.setPLMPartType(true);
        return result;
      }
      if (partType.equals(pt.getPartTypeRealName())) {
        result.setPartType(pt.getPartTypeDisName());
        result.setPLMPartType(true);
      } else {
        result.setPartType(pt.getPartTypeDisName());
        result.setPLMPartType(false);
      }
    } else {
      result.setPartType("");
      result.setPLMPartType(false);
    }
    return result;
  }
}
