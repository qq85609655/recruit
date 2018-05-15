package com.csot.recruit.service.impl.interview;

import java.util.List;

import com.csot.recruit.dao.original.interview.EmergentContactsMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.original.interview.EmergentContacts;
import com.csot.recruit.model.original.interview.EmergentContactsColumns;
import com.csot.recruit.model.original.interview.EmergentContactsCriteria;
import com.csot.recruit.service.interview.EmergentContactsService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("emergentContactsService")
public class EmergentContactsServiceImpl implements EmergentContactsService {
    private static final Logger logger = LoggerFactory.getLogger(EmergentContactsServiceImpl.class);

    @Resource
    private EmergentContactsMapper emergentContactsMapper;

    @Override
    public MiniRtn2Grid<EmergentContacts> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<EmergentContacts> grid = new MiniRtn2Grid<EmergentContacts>();
        EmergentContactsCriteria criteria = new EmergentContactsCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = EmergentContactsColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(emergentContactsMapper.selectByExample(criteria));
        grid.setTotal(emergentContactsMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public EmergentContacts getByPrimaryKey(String primaryKey) {
        return emergentContactsMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(EmergentContacts emergentContacts) {
        emergentContactsMapper.insert(emergentContacts);
    }

    @Override
    public void updateSelective(EmergentContacts emergentContacts) {
        emergentContactsMapper.updateByPrimaryKeySelective(emergentContacts);
    }

    @Override
    public void remove(String primaryKey) {
        emergentContactsMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<EmergentContacts> queryByPersonCode(String personCode) {
      List<EmergentContacts> contacts=emergentContactsMapper.selectByPersonCode(personCode);
      for(EmergentContacts contact:contacts){
        contact.setRelationName(DatadictGroup.getTypeNameByTypeCode(contact.getEmergentRelation(),"emergent-contacts"));
      }
      return contacts;

    }

    @Override
    public void deleteByPersonCode(String personCode) {
      EmergentContactsCriteria criteria = new EmergentContactsCriteria();
      criteria.createCriteria().andPersonCodeEqualTo(personCode);
      emergentContactsMapper.deleteByExample(criteria);
      
    }
}