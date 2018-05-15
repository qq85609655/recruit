package com.csot.recruit.service.impl.interview;

import java.util.List;

import com.csot.recruit.dao.original.interview.FamilyMemberMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.original.interview.FamilyMember;
import com.csot.recruit.model.original.interview.FamilyMemberColumns;
import com.csot.recruit.model.original.interview.FamilyMemberCriteria;
import com.csot.recruit.service.interview.FamilyMemberService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("familyMemberService")
public class FamilyMemberServiceImpl implements FamilyMemberService {
    private static final Logger logger = LoggerFactory.getLogger(FamilyMemberServiceImpl.class);

    @Resource
    private FamilyMemberMapper familyMemberMapper;

    @Override
    public MiniRtn2Grid<FamilyMember> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<FamilyMember> grid = new MiniRtn2Grid<FamilyMember>();
        FamilyMemberCriteria criteria = new FamilyMemberCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = FamilyMemberColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(familyMemberMapper.selectByExample(criteria));
        grid.setTotal(familyMemberMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public FamilyMember getByPrimaryKey(String primaryKey) {
        return familyMemberMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(FamilyMember familyMember) {
        familyMemberMapper.insert(familyMember);
    }

    @Override
    public void updateSelective(FamilyMember familyMember) {
        familyMemberMapper.updateByPrimaryKeySelective(familyMember);
    }

    @Override
    public void remove(String primaryKey) {
        familyMemberMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public List<FamilyMember> queryByPersonCode(String personCode) {
      List<FamilyMember> members=familyMemberMapper.selectByPersonCode(personCode);
      for(FamilyMember member:members){
        member.setRelationName(DatadictGroup.getTypeNameByTypeCode(member.getFamilyRelation(),"family-contacts"));
        member.setGenderName(DatadictGroup.getTypeNameByTypeCode(member.getMenberGender(),"sex-interview"));
      }
      return members;
    }
}