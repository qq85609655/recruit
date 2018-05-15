package com.csot.recruit.service.impl.candidate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.dao.original.candidate.CandidateMapper;
import com.csot.recruit.dao.original.candidate.CandidatePostMapper;
import com.csot.recruit.dao.original.candidate.CandidateRecommendMapper;
import com.csot.recruit.dao.original.log.OperateHistoryMapper;
import com.csot.recruit.dao.original.uniform.JobMapper;
import com.csot.recruit.dao.resume.EducationExperienceMapper;
import com.csot.recruit.dao.resume.ResumeMapper;
import com.csot.recruit.dao.resume.WorkExperienceMapper;
import com.csot.recruit.model.original.candidate.Candidate;
import com.csot.recruit.model.original.candidate.CandidatePost;
import com.csot.recruit.model.original.candidate.CandidateRecommend;
import com.csot.recruit.model.original.candidate.CandidateRecommendColumns;
import com.csot.recruit.model.original.candidate.CandidateRecommendCriteria;
import com.csot.recruit.model.original.candidate.RecommendUnionIds;
import com.csot.recruit.model.original.log.OperateHistory;
import com.csot.recruit.model.original.uniform.Job;
import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.model.resume.Resume;
import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.model.vo.CandidateRecommendResumeVo;
import com.csot.recruit.model.vo.CandidateRecommendVo;
import com.csot.recruit.service.candidate.CandidateRecommendService;

import javax.annotation.Resource;

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

@Service("candidateRecommendService")
public class CandidateRecommendServiceImpl implements CandidateRecommendService {
    private static final Logger logger = LoggerFactory.getLogger(CandidateRecommendServiceImpl.class);

    @Resource
    private CandidateRecommendMapper candidateRecommendMapper;
    
    @Resource
    private CandidateMapper candidateMapper ;
    
    @Resource
    private ResumeMapper resumeMapper ;
    
    @Resource
    private CandidatePostMapper candidatePostMapper ;
    
    @Resource 
    private JobMapper jobMapper ;
    
    @Resource
    private WorkExperienceMapper workMapper;
    
    @Resource
    private EducationExperienceMapper eduMapper;
    
    @Resource
    private BaseUserMapper baseUserMapper ;
    
    @Resource
    private OperateHistoryMapper operateHistoryMapper ;
    
    

    @Override
    public MiniRtn2Grid<CandidateRecommend> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<CandidateRecommend> grid = new MiniRtn2Grid<CandidateRecommend>();
        CandidateRecommendCriteria criteria = new CandidateRecommendCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = CandidateRecommendColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(candidateRecommendMapper.selectByExample(criteria));
        grid.setTotal(candidateRecommendMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public CandidateRecommend getByPrimaryKey(String primaryKey) {
        return candidateRecommendMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(CandidateRecommend candidateRecommend) {
        candidateRecommendMapper.insert(candidateRecommend);
    }

    @Override
    public void updateSelective(CandidateRecommend candidateRecommend) {
        candidateRecommendMapper.updateByPrimaryKeySelective(candidateRecommend);
    }

    @Override
    public void remove(String primaryKey) {
        candidateRecommendMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    @Transactional
    public int saveOrUpdate(SysUser sysUser, CandidateRecommendVo candidateRecommendVo) throws Exception {
    
      if(null == sysUser.getWorkCode() && "".equals(sysUser.getWorkCode())){
        return 0;
      }
      CandidateRecommend candidateRecommend = new CandidateRecommend();
      BeanUtils.copyProperties(candidateRecommend, candidateRecommendVo);
      if (StringUtils.hasText(candidateRecommendVo.getId())) {
       
        candidateRecommendMapper.updateByPrimaryKeySelective(candidateRecommend);
       return 1 ;
      }else{
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("candidatePostId", candidateRecommendVo.getCandidatePostId());
        CandidateRecommend cr = candidateRecommendMapper.selectByMap(param);
        if(null != cr){
         cr.setCandidatePostId(candidateRecommend.getCandidatePostId());
         cr.setComments(candidateRecommend.getComments());
         cr.setCreateTime(new Date());
         cr.setCreateUser(sysUser.getId());
         cr.setFeedback("0");
         cr.setInterviewer(candidateRecommend.getInterviewer());
         cr.setResumeId(candidateRecommend.getResumeId());
         cr.setTurntoPostId(" ");
         candidateRecommendMapper.updateByPrimaryKeySelective(cr);
        }else{
          candidateRecommend.setId(UUID.randomUUID().toString().replace("-", ""));
          candidateRecommend.setCreateTime(new Date());
          candidateRecommend.setCreateUser(sysUser.getId());
          candidateRecommendMapper.insertSelective(candidateRecommend);
        }
        
        BaseUser baseUser = new BaseUser();
        baseUser = baseUserMapper.selectByPrimaryKey(candidateRecommendVo.getInterviewer());
        OperateHistory operateHistory = new OperateHistory();
        operateHistory.setId(UUID.randomUUID().toString().replace("-", ""));
        operateHistory.setOperatorContent(sysUser.getAccount() + "推荐给"+baseUser.getName());
        operateHistory.setOperatorTime(DataUtils.gettimestamp());
        operateHistory.setOperatorUser(sysUser.getId());
        operateHistory.setOperatorType("推荐给面试官");
        operateHistory.setRelatedId(candidateRecommendVo.getCandidateId());
        operateHistoryMapper.insertSelective(operateHistory);
        
        
        
       return 1 ; 
      
      }
      
    }

    @Override
    public MiniRtn2Grid<CandidateRecommendResumeVo> getGridCandidateRecommendVo  (
        Map<String, Object> map)throws Exception {
      MiniRtn2Grid<CandidateRecommendResumeVo> miniGrid = new MiniRtn2Grid<CandidateRecommendResumeVo>();
      List<CandidateRecommendResumeVo> crrList = new ArrayList<CandidateRecommendResumeVo>();
      List<RecommendUnionIds> list = candidateRecommendMapper.selectListByPage(map);
      
      if(list != null && list.size() > 0){
        CandidateRecommendResumeVo candidateRecommendResumeVo = null ;
        Candidate candidate = null ;
        Resume resume = null ;
        CandidatePost candidatePost = null ;
        Job job = null ;
        WorkExperience work = null ;
        EducationExperience edu = null ;
        CandidateRecommend candidateRecommend = null ;
        for(RecommendUnionIds item : list){
          candidateRecommendResumeVo = new CandidateRecommendResumeVo();
          candidate = new Candidate();
          candidate = candidateMapper.selectByPrimaryKey(item.getCandidateId());
          resume = new Resume();
          resume = resumeMapper.selectByPrimaryKey(item.getResumeId());
          candidatePost = candidatePostMapper.selectByPrimaryKey(item.getCandidatePostId());
          job = new Job();
          if(candidatePost != null){
            job = jobMapper.selectByCode(candidatePost.getPositionId());
          }
          
          work = new WorkExperience();
          work = workMapper.selectLastWork(item.getResumeId());
          BeanUtils.copyProperties(candidateRecommendResumeVo, item);
          if(resume != null){
            candidateRecommendResumeVo.setName(resume.getName());
            candidateRecommendResumeVo.setSex(resume.getSex());
            candidateRecommendResumeVo.setAge(resume.getAge());
          }
          if(job != null){
            candidateRecommendResumeVo.setInterviewPositionName(job.getcJobname());
          }
          
          if(work != null){
            //填充公司名称
            candidateRecommendResumeVo.setCommpany(work.getCompanyName());
            //填充当前职位
            candidateRecommendResumeVo.setCurPositionName(work.getPositionName());
          }
          
          //获取最后一份教育经历
           edu =new EducationExperience();
           edu = eduMapper.selectLastEdu(item.getResumeId());
          if(edu != null){
            //毕业学校
            candidateRecommendResumeVo.setSchool(edu.getSchoolName());
          
            //学位
            candidateRecommendResumeVo.setQualifications(edu.getEducation());
          }
          
         candidateRecommend = new CandidateRecommend();
         candidateRecommend =  candidateRecommendMapper.selectByPrimaryKey(item.getCandidateRecommendId());
         
         if(candidateRecommend != null){
           candidateRecommendResumeVo.setComment(candidateRecommend.getComments());
           if(candidateRecommend.getFeedback().equals("0")){
             candidateRecommendResumeVo.setStatus("未反馈");
           }
           if(candidateRecommend.getFeedback().equals("1")){
             candidateRecommendResumeVo.setStatus("安排面试");
           }
           if(candidateRecommend.getFeedback().equals("2")){
             candidateRecommendResumeVo.setStatus("转岗");
           }
           if(candidateRecommend.getFeedback().equals("3")){
             candidateRecommendResumeVo.setStatus("淘汰");
           }
         }
         
         crrList.add(candidateRecommendResumeVo);
        }
       
      }
      miniGrid.setData(crrList);
      miniGrid.setTotal(candidateRecommendMapper.countByPage(map));
      return miniGrid;
    }

    @Override
    public void batchUpdateRecommend(Map<String, Object> param) {
      candidateRecommendMapper.batchUpdateRecommend(param);
    }

    @Override
    public CandidateRecommend getByMap(Map<String, Object> param) {
      return candidateRecommendMapper.selectByMap(param);
    }
}