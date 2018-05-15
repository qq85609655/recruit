package com.csot.recruit.service.impl.flow.employ;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.csot.recruit.dao.original.candidate.CandidateMapper;
import com.csot.recruit.dao.original.candidate.CandidatePostMapper;
import com.csot.recruit.dao.original.flow.employ.EmployMapper;
import com.csot.recruit.dao.original.flow.employ.EmployRefuseOfferMapper;
import com.csot.recruit.model.original.candidate.CandidatePost;
import com.csot.recruit.model.original.flow.employ.Employ;
import com.csot.recruit.model.original.flow.employ.EmployRefuseOffer;
import com.csot.recruit.model.original.flow.employ.EmployRefuseOfferColumns;
import com.csot.recruit.model.original.flow.employ.EmployRefuseOfferCriteria;
import com.csot.recruit.service.flow.employ.EmployRefuseOfferService;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("employRefuseOfferService")
public class EmployRefuseOfferServiceImpl implements EmployRefuseOfferService {
    private static final Logger logger = LoggerFactory.getLogger(EmployRefuseOfferServiceImpl.class);

    @Resource
    private EmployRefuseOfferMapper employRefuseOfferMapper;
    @Resource
    private EmployMapper employMapper;
    @Resource
    private CandidatePostMapper candidatePostMapper ;
    @Resource
    private CandidateMapper candidateMapper;
    @Override
    public MiniRtn2Grid<EmployRefuseOffer> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<EmployRefuseOffer> grid = new MiniRtn2Grid<EmployRefuseOffer>();
        EmployRefuseOfferCriteria criteria = new EmployRefuseOfferCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = EmployRefuseOfferColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(employRefuseOfferMapper.selectByExample(criteria));
        grid.setTotal(employRefuseOfferMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public EmployRefuseOffer getByPrimaryKey(String primaryKey) {
        return employRefuseOfferMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(EmployRefuseOffer employRefuseOffer) {
        employRefuseOfferMapper.insert(employRefuseOffer);
    }

    @Override
    public void updateSelective(EmployRefuseOffer employRefuseOffer) {
        employRefuseOfferMapper.updateByPrimaryKeySelective(employRefuseOffer);
    }

    @Override
    public void remove(String primaryKey) {
        employRefuseOfferMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public EmployRefuseOffer getByEmployeId(String employId) {
      // TODO Auto-generated method stub
      return employRefuseOfferMapper.getByEmployeId(employId);
    }

    @Override
    public void refuseOffer(EmployRefuseOffer employRefuseOffer) {
      //保存原因
      employRefuseOfferMapper.insert(employRefuseOffer);
      //淘汰候选人
      Employ employ = employMapper.selectByPrimaryKey(employRefuseOffer.getEmployId());
      CandidatePost candidatePost = new CandidatePost();
      candidatePost.setCandidateId(employ.getCandidateId());
      candidatePost.setInterviewStatus(CandidatePost.interviewStatus.WEEDOUT.valueStr());
      candidatePost.setPositionId(employ.getEmployPostId());
      candidatePost.setOperatorDate(new Date());
      candidatePostMapper.updateByUnion(candidatePost);
      //更改录用记录状态
      employ.setUpdateDate(new Date());
      employ.setStage(Employ.stage.REFUSEOFFER.valueStr());
      employMapper.updateByPrimaryKeySelective(employ);
      //解锁候选人
      Map<String,Object> map = new HashMap<String,Object>();
      map.put("candidateIds", candidatePost.getCandidateId());
      map.put("lockUserId", employRefuseOffer.getCreatorId());
      candidateMapper.unlockCandidate(map);
    }

    @Override
    public void refuseEntry(EmployRefuseOffer employRefuseOffer) {
    //保存原因
      employRefuseOfferMapper.insert(employRefuseOffer);
      //淘汰候选人
      Employ employ = employMapper.selectByPrimaryKey(employRefuseOffer.getEmployId());
      CandidatePost candidatePost = new CandidatePost();
      candidatePost.setCandidateId(employ.getCandidateId());
      candidatePost.setInterviewStatus("20");
      candidatePost.setPositionId(employ.getEmployPostId());
      candidatePost.setOperatorDate(new Date());
      candidatePostMapper.updateByUnion(candidatePost);
      //更改录用记录状态
      employ.setUpdateDate(new Date());
      employ.setStage(Employ.stage.REFUSEENTRY.valueStr());
      employMapper.updateByPrimaryKeySelective(employ);
    //解锁候选人
      Map<String,Object> map = new HashMap<String,Object>();
      map.put("candidateIds", candidatePost.getCandidateId());
      map.put("lockUserId", employRefuseOffer.getCreatorId());
      candidateMapper.unlockCandidate(map);
    }
}