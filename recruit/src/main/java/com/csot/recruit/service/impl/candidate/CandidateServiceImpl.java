package com.csot.recruit.service.impl.candidate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csot.recruit.common.util.DateKit;
import com.csot.recruit.dao.original.candidate.CandidateMapper;
import com.csot.recruit.dao.original.candidate.CandidatePostMapper;
import com.csot.recruit.dao.original.candidate.CandidateRecommendMapper;
import com.csot.recruit.dao.original.uniform.JobMapper;
import com.csot.recruit.dao.resume.EducationExperienceMapper;
import com.csot.recruit.dao.resume.WorkExperienceMapper;
import com.csot.recruit.model.original.candidate.Candidate;
import com.csot.recruit.model.original.candidate.CandidateColumns;
import com.csot.recruit.model.original.candidate.CandidateCriteria;
import com.csot.recruit.model.original.candidate.CandidatePost;
import com.csot.recruit.model.original.candidate.CandidateRecommend;
import com.csot.recruit.model.original.uniform.Job;
import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.model.vo.InterviewBookCandidateVo;
import com.csot.recruit.model.vo.InterviewBookListVo;
import com.csot.recruit.service.candidate.CandidateService;
import com.google.common.base.Throwables;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.dao.BaseUserMapper;
import org.amberframework.web.system.model.BaseUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service("candidateService")
public class CandidateServiceImpl implements CandidateService {
    private static final Logger logger = LoggerFactory.getLogger(CandidateServiceImpl.class);

    @Resource
    private CandidateMapper candidateMapper;
    
    @Resource
    private BaseUserMapper baseUserMapper ;
    
    @Resource
    private WorkExperienceMapper workMapper;
    
    @Resource
    private EducationExperienceMapper eduMapper;
    
    @Resource
    private CandidatePostMapper candidatePostMapper ;
    
    @Resource
    private CandidateRecommendMapper candidateRecommendMapper ;
    
    @Resource
    private JobMapper jobMapper ;
    
    @Override
    public MiniRtn2Grid<Candidate> getGrid(MiniGridPageSort pageSort, String searchKey , String state) {
        MiniRtn2Grid<Candidate> grid = new MiniRtn2Grid<Candidate>();
        CandidateCriteria criteria = new CandidateCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = CandidateColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        
        List<Candidate> ls = candidateMapper.selectByExample(criteria);
        for(Candidate c : ls){
          //获取最后一份工作经历,将该工作经历显示为最新信息
          WorkExperience work = workMapper.selectLastWork(c.getResumeId());
          if(work != null){
            //填充公司名称
            c.setCurrentCompany(work.getCompanyName());
            //填充当前职位
            c.setCurrentPosition(work.getPositionName());
          }
          //获取最后一份教育经历
          EducationExperience edu = eduMapper.selectLastEdu(c.getResumeId());
          if(edu != null){
            //毕业学校
            c.setGraduationSchool(edu.getSchoolName());
            //专业
            c.setMajor(edu.getMajor());
            //学位
            c.setHighestEducation(edu.getEducation());
          }
          //获取锁定人信息
          BaseUser u = baseUserMapper.selectByPrimaryKey(c.getLockUser());
          if(u != null){
            c.setLockUserAccount(u.getAccount());
            c.setLockUserName(u.getName());
          }
          
        }
        
        grid.setData(ls);
        grid.setTotal(candidateMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Candidate getByPrimaryKey(String primaryKey) {
        return candidateMapper.selectByPrimaryKey(primaryKey);
    }

    @Override
    public void create(Candidate candidate) {
        candidateMapper.insert(candidate);
    }

    @Override
    public void updateSelective(Candidate candidate) {
        candidateMapper.updateByPrimaryKeySelective(candidate);
    }

    @Override
    public void remove(String primaryKey) {
        candidateMapper.deleteByPrimaryKey(primaryKey);
    }

    @Override
    public MiniRtn2Grid<InterviewBookListVo> queryCandidateListByPage(Map<String, Object> map) {
      MiniRtn2Grid<InterviewBookListVo> miniGrid = new MiniRtn2Grid<InterviewBookListVo>();
      List<InterviewBookCandidateVo> list = candidateMapper.queryCandidateListByPage(map);
      List<InterviewBookListVo> interviewBookList = new ArrayList<InterviewBookListVo>();
      if(list != null && list.size() > 0){
         InterviewBookListVo interviewBookListVo = null ;
         String[] ids ;
         BaseUser baseUser ;
         Map<String , Object> param = new HashMap<String,Object>();
        for(InterviewBookCandidateVo item : list){
          interviewBookListVo = new InterviewBookListVo();
          interviewBookListVo.setId(item.getId());
          interviewBookListVo.setPositonId(item.getPositionId());
          interviewBookListVo.setCandidateId(item.getCandidateId());
          param.put("candidateId", item.getCandidateId());
          param.put("positionId", item.getPositionId());
          CandidatePost cp = candidatePostMapper.selectCandidatePostByMap(param);
          if(cp != null){
            interviewBookListVo.setCpStatus(cp.getInterviewStatus());
          }
          Candidate candidate = candidateMapper.selectCandidateByPrimaryKey(item.getCandidateId());
          if(candidate != null){
            if(candidate.getLockUser()==null || candidate.getLockUser().equals("")){
              interviewBookListVo.setLockStatus("未锁定");
            }
            if(map.get("userId").equals(candidate.getLockUser())){
              interviewBookListVo.setLockStatus("自己锁定");
            }
             if(candidate.getLockUser()!=null&&!(map.get("userId").equals(candidate.getLockUser()))){
              interviewBookListVo.setLockStatus("被他人锁定");
            }
            
          }
          interviewBookListVo.setName(item.getName());
          interviewBookListVo.setcJobName(item.getcJobName());
          interviewBookListVo.setcOrgName(item.getcOrgName());
          interviewBookListVo.setContent(item.getContent());
          
          interviewBookListVo.setInterviewAddress(item.getInterviewAddress());
          StringBuffer sb = new StringBuffer() ;
          if(null!=item.getInterviewers()&& (!"".equals(item.getInterviewers()))){
            ids = item.getInterviewers().split(",");
            
            for(int i = 0 ;i < ids.length; i++ ){
              baseUser = baseUserMapper.selectByPrimaryKey(ids[i]);
              if(i!= ids.length-1){
                sb.append(baseUser.getName()+",");
              }else{
                sb.append(baseUser.getName());
              }
            }
          }
         
          interviewBookListVo.setInterviewers(sb.toString());
          if("1".equals(item.getInterviewStatus())){
            interviewBookListVo.setInterviewStatus("第"+item.getRounds()+"轮已取消");
          }
          if("0".equals(item.getInterviewStatus())){
            interviewBookListVo.setInterviewStatus("第"+item.getRounds()+"轮已安排");
          }
          if("2".equals(item.getInterviewStatus())){
            interviewBookListVo.setInterviewStatus("淘汰");
          }
          if("9".equals(item.getInterviewStatus())){
            interviewBookListVo.setInterviewStatus("第"+item.getRounds()+"轮未安排");
          }
          
          StringBuffer timeSb = new StringBuffer() ;
          if(null!=item.getInterviewDate()&& (!"".equals(item.getInterviewDate()))){
            timeSb.append(DateKit.dateToStr(item.getInterviewDate()));
            timeSb.append(" ");
            timeSb.append(item.getInterviewBTime());
            timeSb.append("~");
            timeSb.append(item.getInterviewETime());
          }
       
          interviewBookListVo.setInterviewTimes(timeSb.toString());
          interviewBookList.add(interviewBookListVo);
          
        }
      }
     
      miniGrid.setData(interviewBookList);
      miniGrid.setTotal(candidateMapper.countByPage(map));
      return miniGrid;
    }

    @Override
    public void updateCandidatePostSelective(CandidatePost candidatePost) {
      candidatePostMapper.updateByUnion(candidatePost);
    }

    @Override
    public void lockCandidate(String candidateId, String lockUserId) {
      if(StringUtils.isEmpty(candidateId) || StringUtils.isEmpty(lockUserId)){
        logger.error("锁定候选人操作出现异常,候选人id和当前用户id不能为空");
        Throwables.propagate(new RuntimeException("锁定候选人操作出现异常,候选人id和当前用户id不能为空"));
      }
      Map<String,Object> map = new HashMap<String,Object>();
      map.put("candidateId", candidateId);
      map.put("lockUserId", lockUserId);
      candidateMapper.lockCandidate(map);
    }

    @Override
    public void unlockCandidate(String candidateIds, String lockUserId) {
      if(StringUtils.isEmpty(candidateIds) || StringUtils.isEmpty(lockUserId)){
        logger.error("批量解锁候选人操作出现异常,候选人id和当前用户id不能为空");
        Throwables.propagate(new RuntimeException("批量解锁候选人操作出现异常,候选人id和当前用户id不能为空"));
      }
      Map<String,Object> map = new HashMap<String,Object>();
      map.put("candidateIds", candidateIds);
      map.put("lockUserId", lockUserId);
      candidateMapper.unlockCandidate(map);
    }

    @Override
    public List<CandidatePost> selectCandidatePostListByCandidateId(String candidateId) {
      return candidatePostMapper.selectCandidatePostListByCandidateId(candidateId);
    }

    @Override
    public CandidatePost selectCandidatePostByMap(Map<String, Object> param) {
      return candidatePostMapper.selectCandidatePostByMap(param);
    }

    @Override
    public MiniRtn2Grid<Candidate> getCandidateListGrid(Map<String, Object> map) {
      MiniRtn2Grid<Candidate> grid = new MiniRtn2Grid<Candidate>();
      List<Candidate> ls = candidateMapper.selectListByMap(map);
      for(Candidate c : ls){
        //获取最后一份工作经历,将该工作经历显示为最新信息
        WorkExperience work = workMapper.selectLastWork(c.getResumeId());
        if(work != null){
          //填充公司名称
          c.setCurrentCompany(work.getCompanyName());
          //填充当前职位
          c.setCurrentPosition(work.getPositionName());
        }
        //获取最后一份教育经历
        EducationExperience edu = eduMapper.selectLastEdu(c.getResumeId());
        if(edu != null){
          //毕业学校
          c.setGraduationSchool(edu.getSchoolName());
          //专业
          c.setMajor(edu.getMajor());
          //学位
          c.setHighestEducation(edu.getEducation());
        }
        //获取锁定人信息
        BaseUser u = baseUserMapper.selectByPrimaryKey(c.getLockUser());
        if(u != null){
          c.setLockUserAccount(u.getAccount());
          c.setLockUserName(u.getName());
        }
        Map<String,Object> param = new HashMap<String,Object>();
        param.put("candidatePostId", c.getId());
        CandidateRecommend cr = candidateRecommendMapper.selectByMap(param);
        if(null != cr){
          BaseUser baseUser = baseUserMapper.selectByPrimaryKey(cr.getInterviewer());
          c.setInterviewerName(baseUser == null?"":baseUser.getName());
          c.setRecommandStatus(cr.getFeedback());
          if(cr.getFeedback().equals("0")){
            c.setFeedbackStatus("已推荐未反馈");
          
            
          }else{
            c.setFeedbackStatus("已推荐已反馈");
          }
        }else{
          c.setFeedbackStatus("未推荐");
        }
        
        
      }
      
      grid.setData(ls);
      grid.setTotal(candidateMapper.countListByMap(map));
      return grid;
    }

    @Override
    public CandidatePost selectCandidatePostById(String id) {
      // TODO Auto-generated method stub
      return candidatePostMapper.selectByPrimaryKey(id);
    }

    @Override
    public MiniRtn2Grid<Candidate> getCandidateRepositoryGrid(Map<String, Object> map) {

      MiniRtn2Grid<Candidate> grid = new MiniRtn2Grid<Candidate>();
      //c.id as candidate_id,c.resume_id,c.lock_user,b.name,b.name_en,b.sex,b.phone,b.email
      List<Candidate> ls = candidateMapper.selectCandidateRepository(map);
      for(Candidate c : ls){
        //获取最后一份工作经历,将该工作经历显示为最新信息
        WorkExperience work = workMapper.selectLastWork(c.getResumeId());
        if(work != null){
          //填充公司名称
          c.setCurrentCompany(work.getCompanyName());
          //填充当前职位
          c.setCurrentPosition(work.getPositionName());
        }
        //获取最后一份教育经历
        EducationExperience edu = eduMapper.selectLastEdu(c.getResumeId());
        if(edu != null){
          //毕业学校
          c.setGraduationSchool(edu.getSchoolName());
          //专业
          c.setMajor(edu.getMajor());
          //学位
          c.setHighestEducation(edu.getEducation());
        }
        //获取锁定人信息
        BaseUser u = baseUserMapper.selectByPrimaryKey(c.getLockUser());
        if(u != null){
          c.setLockUserAccount(u.getAccount());
          c.setLockUserName(u.getName());
        }
    
       List<CandidatePost> cpList = candidatePostMapper.selectCandidatePostListByCandidateId(c.getCandidateId());
       StringBuffer sb = new StringBuffer();
       
       if(null != cpList && cpList.size() > 0 ){
         Job job = null ;
         for(int i = 0 ; i < cpList.size() ; i++){
           job = new Job();
           job = jobMapper.selectByCode(cpList.get(i).getPositionId());
           if(i != cpList.size() - 1){
             sb.append(job.getcJobname()+",");
           }else{
             sb.append(job.getcJobname());
           }
           
         }
       }
       c.setJobNames(sb.toString());
       
      }
      
      grid.setData(ls);
      grid.setTotal(candidateMapper.countCandidateRepository(map));
      return grid;
    
      
    }

    @Override
    public Candidate getCandidateByPrimaryKey(String primaryKey) {
      return candidateMapper.selectCandidateByPrimaryKey(primaryKey);
    }

    @Override
    public void addCandidatePost(CandidatePost cp) {
      candidatePostMapper.insertSelective(cp);
      
    }

    @Override
    public void batchOutCpByMap(Map<String, Object> cpparam) {
      candidatePostMapper.batchUpdateCpbyMap(cpparam);
      
    }
}