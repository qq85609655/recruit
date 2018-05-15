package com.csot.recruit.service.impl.flow.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.csot.recruit.common.util.DateKit;
import com.csot.recruit.dao.original.candidate.CandidateMapper;
import com.csot.recruit.dao.original.flow.interview.IbARalationMapper;
import com.csot.recruit.dao.original.flow.interview.InterviewBookMapper;
import com.csot.recruit.model.original.flow.interview.IbARalation;
import com.csot.recruit.model.original.flow.interview.InterviewBook;
import com.csot.recruit.model.original.flow.interview.InterviewBookColumns;
import com.csot.recruit.model.original.flow.interview.InterviewBookCriteria;
import com.csot.recruit.model.vo.InterviewBookVo;
import com.csot.recruit.service.flow.interview.InterviewBookService;

import javax.annotation.Resource;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.dao.BaseUserMapper;
import org.amberframework.web.system.model.BaseUser;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

@Service("interviewBookService")
public class InterviewBookServiceImpl implements InterviewBookService {
    private static final Logger logger = LoggerFactory.getLogger(InterviewBookServiceImpl.class);

    @Resource
    private InterviewBookMapper interviewBookMapper;
    
    @Resource
    private IbARalationMapper ibARalationMapper ;
    
    @Resource
    private CandidateMapper candidateMapper  ;

    @Override
    public MiniRtn2Grid<InterviewBook> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<InterviewBook> grid = new MiniRtn2Grid<InterviewBook>();
        InterviewBookCriteria criteria = new InterviewBookCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = InterviewBookColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(interviewBookMapper.selectByExample(criteria));
        grid.setTotal(interviewBookMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public InterviewBook getByPrimaryKey(String primaryKey) {
        return interviewBookMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(InterviewBook interviewBook) {
        interviewBookMapper.insert(interviewBook);
    }

    @Override
    public void updateSelective(InterviewBook interviewBook) {
        interviewBookMapper.updateByPrimaryKeySelective(interviewBook);
    }

    @Override
    public void remove(String primaryKey) {
        interviewBookMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    @Transactional
    public String saveOrUpdate(SysUser sysUser,InterviewBookVo interviewBookVo) throws Exception {
    
      if(null == sysUser.getWorkCode() && "".equals(sysUser.getWorkCode())){
        return "";
      }
      if(StringUtils.hasText(interviewBookVo.getSecondETimeStr())){
        interviewBookVo.setSecondETime(DateKit.strToTime(interviewBookVo.getSecondETimeStr()+":00"));
      }
      if(StringUtils.hasText(interviewBookVo.getSecondRTimeStr())){
        interviewBookVo.setSecondRTime(DateKit.strToTime(interviewBookVo.getSecondRTimeStr()+":00"));
      }
      if(StringUtils.hasText(interviewBookVo.getInterviewDateStr())){
        interviewBookVo.setInterviewDate(DateKit.strToDate(interviewBookVo.getInterviewDateStr()));
      }
      if (StringUtils.hasText(interviewBookVo.getId())) {
        /**
         * 更新步骤如下：
         * 1.删除原始数据（IB_A_RALATION）
         * 2.录入数据
         * 3.更新interviewBook
         */
        ibARalationMapper.deleteByInterviewBookId(interviewBookVo.getId());
        
        if(interviewBookVo.getAttchmentIds()!= null && 
            (!interviewBookVo.getAttchmentIds().equals(""))){
          String[] ids = interviewBookVo.getAttchmentIds().split(",");
          IbARalation ibARalation = null ;
          for(String id : ids){
            ibARalation = new IbARalation();
            ibARalation.setAttachmentId(id);
            ibARalation.setInterviewBookId(interviewBookVo.getId());
            ibARalationMapper.insertSelective(ibARalation);
          }
        }
        
       InterviewBook interviewBook = new InterviewBook();
       BeanUtils.copyProperties(interviewBook, interviewBookVo);
       if(interviewBookVo.getSaveType().equals("save")){
         interviewBook.setInterviewStatus("0");
       }else{
         interviewBook.setInterviewStatus("9");
       }
       interviewBookMapper.updateByPrimaryKeySelective(interviewBook);
       return interviewBook.getId() ;
      }else{
        /**
         * 新增步骤如下：
         * 1.新增interviewBook
         * 2.录入数据（IB_A_RALATION）
         */
        
        String[] interviewersStrArray = interviewBookVo.getInterviewers().split("_");
        String[] interviewDateStrArray = interviewBookVo.getInterviewDateStr().split("_");
        String[] interviewBTimeArray = interviewBookVo.getInterviewBTime().split("_");
        String[] interviewETimeArray = interviewBookVo.getInterviewETime().split("_");
        String[] interviewAddressArray = interviewBookVo.getInterviewAddress().split("_");
       
        InterviewBook interviewBook = new InterviewBook();
        BeanUtils.copyProperties(interviewBook, interviewBookVo);
        List<String> interviewBookIds = new ArrayList<String>();
        List<InterviewBook> list =  new ArrayList<InterviewBook>();
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("candidateId", interviewBookVo.getInterviewee());
        param.put("positionId", interviewBookVo.getPositionId());
        
        for(int i = 0 ; i < interviewersStrArray.length ; i++){
          String interviewBookId = UUID.randomUUID().toString().replace("-", "");
          list = interviewBookMapper.selectInterviewBookListByMap(param);
          if(list != null && list.size() > 0){
            interviewBook.setRounds(Integer.toString(list.size()+1));
          }else{
            interviewBook.setRounds("1");
          }
          interviewBook.setInterviewers(interviewersStrArray[i]);
          if(null!= interviewDateStrArray[i] && !("".equals(interviewDateStrArray[i]))){
            interviewBook.setInterviewDate(DateKit.strToDate(interviewDateStrArray[i]));
          }
          interviewBook.setInterviewBTime(interviewBTimeArray[i]);
          interviewBook.setInterviewETime(interviewETimeArray[i]);
          interviewBook.setInterviewAddress(interviewAddressArray[i]);
          interviewBook.setId(interviewBookId);
          if(interviewBookVo.getSaveType().equals("save")){
            interviewBook.setInterviewStatus("0");
          }else{
            interviewBook.setInterviewStatus("9");
          }
          
          interviewBook.setWorkCode(sysUser.getWorkCode());
          interviewBookIds.add(interviewBookId);
          
          interviewBookMapper.insertSelective(interviewBook);
          
        }
       
        if(interviewBookVo.getAttchmentIds()!= null && 
            (!interviewBookVo.getAttchmentIds().equals(""))){
          String[] ids = interviewBookVo.getAttchmentIds().split(",");
          IbARalation ibARalation = null ;
          for(String id : ids){
            ibARalation = new IbARalation();
            for(String item : interviewBookIds){
              ibARalation.setAttachmentId(id);
              ibARalation.setInterviewBookId(item);
              ibARalation.setId(UUID.randomUUID().toString().replace("-", ""));
              ibARalationMapper.insertSelective(ibARalation);
            }
           
          }
        }
       return interviewBookIds.get(0); 
      
      }
      
    }

    @Override
    public List<InterviewBook> selectInterviewBookListByMap(Map<String, Object> param) {
      // TODO Auto-generated method stub
      return interviewBookMapper.selectInterviewBookListByMap(param);
    }

    @Override
    public void batchUpdateInterviewBook(Map<String, Object> param) {
      interviewBookMapper.batchUpdateInterviewBook(param);
      
    }
}