package com.csot.recruit.service.impl.flow.employ;

import java.util.List;

import com.csot.recruit.dao.original.flow.employ.EmployCandidateMapper;
import com.csot.recruit.model.original.flow.employ.EmployCandidate;
import com.csot.recruit.model.original.flow.employ.EmployCandidateColumns;
import com.csot.recruit.model.original.flow.employ.EmployCandidateCriteria;
import com.csot.recruit.service.flow.employ.EmployCandidateService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("employCandidateService")
public class EmployCandidateServiceImpl implements EmployCandidateService {
    private static final Logger logger = LoggerFactory.getLogger(EmployCandidateServiceImpl.class);

    @Resource
    private EmployCandidateMapper employCandidateMapper;

    @Override
    public MiniRtn2Grid<EmployCandidate> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<EmployCandidate> grid = new MiniRtn2Grid<EmployCandidate>();
        EmployCandidateCriteria criteria = new EmployCandidateCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = EmployCandidateColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(employCandidateMapper.selectByExample(criteria));
        grid.setTotal(employCandidateMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public EmployCandidate getByPrimaryKey(String primaryKey) {
        return employCandidateMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(EmployCandidate employCandidate) {
        employCandidateMapper.insert(employCandidate);
    }

    @Override
    public void updateSelective(EmployCandidate employCandidate) {
        employCandidateMapper.updateByPrimaryKeySelective(employCandidate);
    }

    @Override
    public void remove(String primaryKey) {
        employCandidateMapper.deleteByPrimaryKey(primaryKey);
    }

    /**
     * 根据employid获取候选人信息
     */
    @Override
    public EmployCandidate getByEmploy(String id) {
      EmployCandidateCriteria example=new EmployCandidateCriteria();
      example.createCriteria().andEmployIdEqualTo(id);
      List<EmployCandidate> employCandidates = employCandidateMapper.selectByExample(example);
      if(employCandidates!=null&&employCandidates.size()>0){
        return employCandidates.get(0);
      }
      return null;
    }
}