package com.csot.recruit.service.impl.datadict;

import java.util.List;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.csot.recruit.dao.datadict.DatadictGroupMapper;
import com.csot.recruit.dao.datadict.DatadictGroupTypeMapper;
import com.csot.recruit.model.datadict.DataConfig;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.datadict.DatadictGroupColumns;
import com.csot.recruit.model.datadict.DatadictGroupCriteria;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.service.datadict.DatadictGroupService;

@Service("datadictGroupService")
@Transactional
public class DatadictGroupServiceImpl implements DatadictGroupService {
    private static final Logger logger = LoggerFactory.getLogger(DatadictGroupServiceImpl.class);

    @Resource
    private DatadictGroupMapper datadictGroupMapper;
    @Resource
    private DatadictGroupTypeMapper datadictGroupTypeMapper;

    @Override
    public MiniRtn2Grid<DatadictGroup> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<DatadictGroup> grid = new MiniRtn2Grid<DatadictGroup>();
        DatadictGroupCriteria criteria = new DatadictGroupCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andGroupIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = DatadictGroupColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(datadictGroupMapper.selectByExample(criteria));
        grid.setTotal(datadictGroupMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public DatadictGroup getByPrimaryKey(String primaryKey) {
        return datadictGroupMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(DatadictGroup datadictGroup) {
        datadictGroupMapper.insert(datadictGroup);
    }

    @Override
    public void updateSelective(DatadictGroup datadictGroup) {
        datadictGroupMapper.updateByPrimaryKeySelective(datadictGroup);
    }

    @Override
    public void remove(String primaryKey) {
		datadictGroupMapper.deleteByPrimaryKey(primaryKey);
    }

	@Override
	public List<DataConfig> queryDatadictGroupList() {
		List<DataConfig> list = datadictGroupMapper.queryDatadictGroupList();
		list.addAll(datadictGroupMapper.queryDatadictGroupTypeList());
		return list;
	}

	@Override
	public int getDatadictGroupCount(DatadictGroup datadictGroup) {
		return datadictGroupMapper.countDatadictGroup(datadictGroup);
	}

	@Override
	public int getGroupTypeCountByGroupId(String groupId) {
		List<DatadictGroupType> list = datadictGroupTypeMapper.queryGroupTypeListByGroupId(groupId);
		return list.size();
	}

}