package com.csot.recruit.service.impl.resume;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.csot.recruit.common.enums.OperateType;
import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.common.util.DateKit;
import com.csot.recruit.common.util.FileUtils;
import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.common.util.Result;
import com.csot.recruit.common.util.SearchParam;
import com.csot.recruit.common.util.SearchResult;
import com.csot.recruit.dao.datadict.DatadictGroupTypeMapper;
import com.csot.recruit.dao.original.candidate.CandidateMapper;
import com.csot.recruit.dao.position.RecruitPositionMapper;
import com.csot.recruit.dao.resume.EducationExperienceMapper;
import com.csot.recruit.dao.resume.ITSkillMapper;
import com.csot.recruit.dao.resume.LanguageSkillMapper;
import com.csot.recruit.dao.resume.MyResumeRepositoryMapper;
import com.csot.recruit.dao.resume.ResumeMapper;
import com.csot.recruit.dao.resume.WorkExperienceMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.model.log.Log;
import com.csot.recruit.model.original.candidate.Candidate;
import com.csot.recruit.model.position.RecruitPosition;
import com.csot.recruit.model.resume.ClassifyData;
import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.model.resume.ITSkill;
import com.csot.recruit.model.resume.LanguageSkill;
import com.csot.recruit.model.resume.PositionSearch;
import com.csot.recruit.model.resume.Resume;
import com.csot.recruit.model.resume.ResumesData;
import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.model.resume.WorkIntention;
import com.csot.recruit.model.vo.ResumeDataVo;
import com.csot.recruit.service.resume.LabelService;
import com.csot.recruit.service.resume.MyResumeRepositoryService;

import javax.annotation.Resource;

import jodd.datetime.JDateTime;
import jodd.util.StringUtil;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("myResumeRepositoryService")
public class MyResumeRepositoryServiceImpl implements MyResumeRepositoryService {
    private static final Logger logger = LoggerFactory.getLogger(MyResumeRepositoryServiceImpl.class);

    @Resource
    private MyResumeRepositoryMapper myResumeRepositoryMapper;
    
    @Resource
    private RecruitPositionMapper recruitPositionMapper;
    
    @Resource
    private LabelService labelService;
    
    @Resource
    private LanguageSkillMapper resumeLanguageMapper;
    
    @Resource
    private WorkExperienceMapper workExperienceMapper;
    
    @Resource
    private EducationExperienceMapper educationExperienceMapper;
    
    @Resource
    private ResumeMapper resumeMapper;
    
    @Resource
    private ITSkillMapper skillMapper;
    
    @Resource
    private PositionSearchService positionSearchService;
    
    @Resource
    private DatadictGroupTypeMapper datadictGroupTypeMapper;
    
    @Resource
    private CandidateMapper candidateMapper ;

    @Override
    public MiniRtn2Grid<ResumesData> queryResumeRepositoryListByPage(MiniGridPageSort page,
        ResumesData resumesData) {
      List<String> idList = new ArrayList<String>();
      //将标签转换为数据字典里面的编码
      MiniRtn2Grid<ResumesData> miniGrid = new MiniRtn2Grid<ResumesData>();
      if(null != resumesData.getKeyword() && !resumesData.getKeyword().equals("")){
    	  SearchParam param = new SearchParam();
    	  param.setKeyword(resumesData.getKeyword().toLowerCase());
    	  param.setResumesData(resumesData);
    	  SearchResult searchResult = positionSearchService.searchInAllIndices(param);
    	  logger.info("searchResult:"+searchResult.getResult());
    	  for (int i = 0; i < searchResult.getResult().size(); i++) {
			idList.add((String) searchResult.getResult().get(i).get("positionId"));
		  }
    	  String lowerAge = resumesData.getLowerAge();
    	  String upperAge = resumesData.getUpperAge();
    	  String lowerExperience = resumesData.getLowerExperience();
    	  String upperExperience = resumesData.getUpperExperience();
    	  String lowerUpdateDate = resumesData.getLowerUpdateDate();
    	  String upperUpdateDate = resumesData.getUpperUpdateDate();
    	  resumesData = new ResumesData();
    	  resumesData.setLowerAge(lowerAge);
    	  resumesData.setUpperAge(upperAge);
    	  resumesData.setLowerExperience(lowerExperience);
    	  resumesData.setUpperExperience(upperExperience);
    	  resumesData.setLowerUpdateDate(lowerUpdateDate);
    	  resumesData.setUpperUpdateDate(upperUpdateDate);
    	  if(idList.size() <= 0){
//    		  resumesData.setIdList(null);
    		  miniGrid.setTotal(0);
    		  miniGrid.setData(null);
    		  return miniGrid;
    	  }else{
    		  resumesData.setIdList(idList);
    	  }
      }else{
    	  if(null != resumesData.getId() && !resumesData.getId().equals("")){
    		  idList.add(resumesData.getId());
        	  resumesData.setIdList(idList);
    	  }
      }
      Map<String, Object> map = getQueryData(page, resumesData);
      if(map !=null){
        
        List<ResumesData> resumesDataList = getDICTData(myResumeRepositoryMapper.queryResumesDataByPage(map));
        
        miniGrid.setData(resumesDataList);
        int total = myResumeRepositoryMapper.countResumesData(map);
        miniGrid.setTotal(total);
      }
      return miniGrid;
    }
    
    /**
     * 封装map数据
     */
    
    private Map<String,Object> getQueryData(MiniGridPageSort page,
        ResumesData resumesData){
      String[] arrSchoolName = null;
      String schoolName =  resumesData.getGraduationSchool();
      if(null != schoolName && !"".equals(schoolName.trim())){
        arrSchoolName = schoolName.split(",");
      }
      
      String professional =  resumesData.getProfessional();
      String[] arrProfessional = null;
      if(null !=professional && !"".equals(professional.trim())){
        arrProfessional = professional.split(",");
      }
      
      String industryExpect = resumesData.getIndustryExpect();
      String [] arrIndustryExpect = null;
      if(null != industryExpect && !"".equals(industryExpect.trim())){
        arrIndustryExpect = industryExpect.split(",");
      }
      
      String postExpect = resumesData.getPostExpect();
      String[] arrPostExpect = null;
      if(null != postExpect && !"".equals(postExpect.trim())){
        arrPostExpect = postExpect.split(",");
      }
      
      
      String label = resumesData.getLabel();
      String[] arrLabel= null;
      if(null != label && !"".equals(label.trim())){
        arrLabel = label.split(",");
        //将label转换成Label标签里面的
        arrLabel= getArrLabel(arrLabel,resumesData.getLabelSign());
        if(arrLabel.length == 0){
          return null;
        }
      }
      
      String highestEducation = resumesData.getHighestEducation();
      if(null != highestEducation && !"".equals(highestEducation.trim())){
        if(highestEducation.getBytes().length !=highestEducation.length()){
          resumesData.setHighestEducation(DatadictGroup.getTypeIdByTypeName(highestEducation, null));
        }
      }
      List<String>highestEducationList = getHighEducation(resumesData);
      Map<String, Object> map = new HashMap<String, Object>();
      map.put("idList", resumesData.getIdList());
      map.put("name", resumesData.getName());
      map.put("selectionStatus", resumesData.getSelectionStatus());
      map.put("label", resumesData.getLabel());
      map.put("company", resumesData.getCompany());
      map.put("residence", resumesData.getResidence());
      map.put("highestEducation", highestEducationList);
      map.put("resumeOrigin", resumesData.getResumeOrigin());
      map.put("channel", resumesData.getChannel());
      map.put("email", resumesData.getEmail());
      map.put("sex", resumesData.getSex());
      map.put("currentIndustry", resumesData.getCurrentIndustry());
      map.put("lowerUpdateDate", resumesData.getLowerUpdateDate());
      map.put("upperUpdateDate", resumesData.getUpperUpdateDate());
      map.put("lowerAge", resumesData.getLowerAge());
      map.put("upperAge", resumesData.getUpperAge());
      map.put("lowerExperience", resumesData.getLowerExperience());
      map.put("upperExperience", resumesData.getUpperExperience());
      map.put("keyWordsSign", resumesData.getKeyWordsSign());
      map.put("educationSign", resumesData.getEducationSign());
      map.put("labelSign", resumesData.getLabelSign());
      map.put("currentPosition", resumesData.getCurrentPosition());
      map.put("schoolName", arrSchoolName);
      map.put("postExpect", arrPostExpect);
      map.put("professional", arrProfessional);
      map.put("industryExpect", arrIndustryExpect);
      map.put("label", arrLabel);
      map.put("salaryExpect", resumesData.getSalaryExpect());
      map.put("keyword", resumesData.getKeyword());
      if( page!=null){
        map.put("pageIndex", page.getPageIndex());
        map.put("sortField", page.getSortField());
        map.put("pageSize", page.getPageSize());
        map.put("sortOrder", page.getSortOrder());
      }

      return map;
    }
    
    /**
     * 获取最高学历的查询字符串
     * @param resumesData
     * @return
     */
    private List<String> getHighEducation(ResumesData resumesData){
      StringBuffer highEducationSql = new StringBuffer();
      Integer sign = resumesData.getEducationSign();
      String highEducationField = resumesData.getHighestEducation();
      if(highEducationField !=null && highEducationField.length()>0){
        String groupId = getHighEducationCode(highEducationField,0);
        if(!"".equals(groupId)){
          List<DatadictGroupType> highEducationDatadict = datadictGroupTypeMapper.getDatadictGroupTypeByGroupId(groupId);
          if(highEducationDatadict !=null && highEducationDatadict.size()>0){
            if(sign !=null && sign==1){
              String code = getHighEducationCode(highEducationField,4);
              if(code !=null && code.length()>0){
                for(DatadictGroupType dg :highEducationDatadict){
                    String dgCode = dg.getTypeId();
                    if(dgCode !=null && !"".equals(dgCode)){
                      dgCode = dgCode.substring(dgCode.length()-code.length(),dgCode.length());
                      int num1 = Integer.parseInt(code);
                      int num2 = Integer.parseInt(dgCode);
                      if(num2>=num1){
                        highEducationSql.append(dg.getTypeId()).append(",").append(dg.getTypeName()).append(",");
                      }
                    }
                }
              }
            }else{
              highEducationSql = highEducationSql.append(highEducationField).append(",").append(DatadictGroup.getTypeNameByTypeId(highEducationField)).append(",");
            }
          }
        }
      }
      List<String> highestEducation =null;
      String sql = highEducationSql.toString();
      if(sql !=null && !"".equals(sql)){
        String[] educationField = sql.split(",");
        if(educationField !=null && educationField.length>0){
          highestEducation = new ArrayList<String>();
          for(int i=0;i<educationField.length-1;i++){
            highestEducation.add(educationField[i]);
          }
        }
      }
      return highestEducation;
    }
    
    /**
     * 切割学历字符
     * @param highEducationField
     * @param k
     * @return
     */
    private String getHighEducationCode(String highEducationField,int k){
      String groupId = "";
      if(highEducationField !=null){
        String groupCode = highEducationField.substring(k, k+1);
        if("0".equals(groupCode)){
          groupCode = highEducationField.substring(k+1, k+2);
          if("0".equals(groupCode)){
            groupId = highEducationField.substring(k+2, k+3);
          }else{
            groupId = highEducationField.substring(k+1, k+3);
          }
        }else{
          groupId = highEducationField.substring(k,k+3);
        }
      }
      return groupId;
    }
    
   //获取标签数组
    private String[] getArrLabel(String[] arr,Integer labelSign){
      String [] arrLabel = null; 
      if(arr !=null && arr.length>0){
        arrLabel = new String[arr.length]; 
        List<String> labelList = new ArrayList<String>();
        int j = 0;
        for(int i=0;i<arr.length;i++){
          labelList.add(arr[i]);
        }
        if(labelList !=null && labelList.size()>0){
          Map<String,Object> labelMap = labelService.getLabelListByLabelNames(labelList);
          if(labelSign == ResumesData.NOTCONTAINALL){
            for(int i=0;i<labelList.size();i++){
              if(labelMap !=null && !labelMap.isEmpty()){
                String labelId = labelList.get(i);
                if(labelId !=null && !"".equals(labelId)){
                  if(labelMap.get(labelId) !=null){
                    arrLabel[j] = labelMap.get(labelId).toString();
                    j++;
                  }
                }
              }
            }
          }else{
            for(int i=0;i<labelList.size();i++){
              if( labelMap !=null &&!labelMap.isEmpty()){
                String labelId = labelList.get(i);
                if(labelId !=null && !"".equals(labelId)){
                  if(labelMap.get(labelId) !=null){
                    arrLabel[j] = labelMap.get(labelId).toString();
                    j++;
                  }else{
                    return null;
                  }
                }
              }
            }
          }
        }
      }
      
      return arrLabel;
    }
    
    /**
     * 将resumeData里面的编码转换成name
     * @param resumesDataList
     * @return
     */
    private List<ResumesData> getDICTData(List<ResumesData> resumesDataList){
      if(resumesDataList !=null && resumesDataList.size()>0){
        for(ResumesData pm : resumesDataList){
          if(StringUtil.isEmpty(pm.getHighestEducation())) { // 如果最高学历字段没有值，从教育经历中查找 
            if(pm.getEducationExperience() != null && pm.getEducationExperience().size() > 0) {
              pm.setHighestEducation(pm.getEducationExperience().get(0).getEducation());
            }
          }
          pm.setHighestEducation(DatadictGroup.getTypeNameByTypeId(pm.getHighestEducation())); // 学历         
          
          pm.setSex(DatadictGroup.getTypeNameByTypeId(pm.getSex())); // 性别
          pm.setMaritalStatus(DatadictGroup.getTypeNameByTypeId(pm.getMaritalStatus())); // 婚姻状况
          
          if(0 == pm.getAge() && null != pm.getBirthday()) { 
            pm.setAge(DataUtils.getAge(pm.getBirthday()));
          } 
          
          // 标签
          if(pm.getLabel() !=null && !"".equals(pm.getLabel())){
            pm.setLabelId(pm.getLabel());
            String[] arrLabel = pm.getLabel().split(",");
            List<String> labelList = new ArrayList<>();
            if(arrLabel !=null && arrLabel.length>0){
              for(int i=0;i<arrLabel.length;i++){
                labelList.add(arrLabel[i]);
              }
            }
            if(labelList !=null && labelList.size()>0){
              Map<String,Object> labelMap = labelService.getLabelListByIds(labelList);
              StringBuffer label = new StringBuffer(); 
              if(!labelMap.isEmpty()){
                for(Map.Entry<String, Object> entry : labelMap.entrySet()){
                  label.append(entry.getValue()).append(",");
                }
                pm.setLabel(label.toString());
              }
            }
          }
          
          //关联职位
          String recruitPositionId = pm.getPositionId();
          if(StringUtil.isNotEmpty(recruitPositionId)){
            RecruitPosition recruitPosition = recruitPositionMapper.selectByPrimaryKey(recruitPositionId);
            if(recruitPosition !=null){
              String positionName = recruitPosition.getPositionName();
              if(StringUtil.isNotEmpty(positionName)){
                pm.setPosition(positionName);
              }else{
                pm.setPosition("");
              }
            }else{
              // pm.setPosition("");   简历解析后的简历可能关联不上职位，这里暂不置空
              pm.setPosition(pm.getPositionId());
            }
          }else{
            pm.setPosition("");
          }
          
          // 选择一所学校在主数据中显示(原则上显示最后就读的学校)
          if(pm.getEducationExperience() !=null && pm.getEducationExperience().size()>0){
            Long endTime=(long) 0;
            for(EducationExperience ed : pm.getEducationExperience()){
              if(ed.getSchoolName() !=null && !"".equals(ed.getSchoolName())){
                if(ed.getEduEndDate()!=null){
                  if(ed.getEduEndDate().getTime()>endTime){
                    endTime = ed.getEduEndDate().getTime();
                    pm.setGraduationSchool(ed.getSchoolName());
                  }
                }else{
                  pm.setGraduationSchool(ed.getSchoolName());
                  break;
                }
              }
            }
          }
          // 最近就职公司和最近就职职位
          if(pm.getWorkExperience() !=null && pm.getWorkExperience().size()>0){
            Long endTime=(long) 0;
            for(WorkExperience we : pm.getWorkExperience()){
              if(we.getCompanyName() !=null && !"".equals(we.getCompanyName())){
                if(we.getJobEndDate()!=null){
                  if(we.getJobEndDate().getTime()>endTime){
                    endTime = we.getJobEndDate().getTime();
                    pm.setCompany(we.getCompanyName());
                    pm.setCurrentPosition(we.getPositionName());
                  }
                }else{
                  pm.setCompany(we.getCompanyName());
                  pm.setCurrentPosition(we.getPositionName());
                  break;
                }
              }
            }
          }
          if(pm.getWorkIntention() !=null && pm.getWorkIntention().size()>0){
            int salary = 0;
            for(WorkIntention wi: pm.getWorkIntention()){
              if(wi.getSalaryExpect() !=null && !"".equals(wi.getSalaryExpect())){
                String salaryStr = wi.getSalaryExpect();
                if(salaryStr !=null && !"".equals(salaryStr)){
                  int s = Integer.parseInt(salaryStr.substring(salaryStr.length()-1, salaryStr.length()));
                  if(s>salary){
                    salary = s;
                  }
                }
              }
            }
            if(salary == 0) {
              pm.setSalaryExpect(null);
            }
            else {
              pm.setSalaryExpect(salary + "");
            }
          }
        }
      }
      return resumesDataList;
    }

    //查询职位等信息
    @Override
    public Map<String, Object> queryClassifyByPosition(ResumesData resumesData) {
      Map<String,Object> dataMap = new HashMap<String, Object>();
      Map<String,Object> map = getQueryData(null,resumesData);
      //获取职位信息
      List<ClassifyData> positionList = myResumeRepositoryMapper.queryClassifyByPosition(map);
      List<ClassifyData> graduationSchoolList = myResumeRepositoryMapper.queryClassifyGraduationSchool(map);
      List<ClassifyData> channelList = myResumeRepositoryMapper.queryClassifyChannel(map);
      List<ClassifyData> highestEducationList = myResumeRepositoryMapper.queryClassifyHighestEducation(map);
      List<ClassifyData> residencerList = myResumeRepositoryMapper.queryClassifyResidencer(map);
      List<ClassifyData> labelList = myResumeRepositoryMapper.queryClassifyLabel(map);
      List<String> labelIds = new ArrayList<String>();
      if(labelList !=null && labelList.size()>0){
        for(int i=0;i<labelList.size();i++){
          String labelId = labelList.get(i).getName() ;
          if(labelId  !=null && !"".equals(labelId)){
            labelIds.add(labelId);
          }
        }
       Map<String,Object> labelMap= labelService.getLabelListByIds(labelIds);
       if(labelList !=null && labelList.size()>0){
         for(int i=0;i<labelList.size();i++){
           if( labelMap !=null && !labelMap.isEmpty() ){
             ClassifyData classifyData = labelList.get(i);
             if(classifyData !=null){
               if(labelMap.get(classifyData.getName()) !=null){
                 classifyData.setName(labelMap.get(classifyData.getName()).toString());
               }
             }
           }
         }
       }
      }
      if(highestEducationList !=null && highestEducationList.size()>0){
        for(int i=0;i<highestEducationList.size();i++){
          String education = highestEducationList.get(i).getName();
          highestEducationList.get(i).setName(DatadictGroup.getTypeNameByTypeId(education));
        }
      }
      dataMap.put("highestEducation", highestEducationList);
      dataMap.put("position", positionList);
      dataMap.put("graduationSchool", graduationSchoolList);
      dataMap.put("channel", channelList);
      dataMap.put("residencer", residencerList);
      dataMap.put("label",labelList);
      return dataMap;
    }

    @Override
    @Transactional
    public String createResumeAndRelate(ResumesData resumesData) {
      // TODO Auto-generated method stub
      String id ="";
      //用于判断是新增还是编辑之后保存
      String uId="";
      if(resumesData !=null){
        //如Id非空则为编辑简历，Id为空则为新增简历
        if(resumesData.getId() !=null && !"".equals(resumesData.getId())){
          uId = resumesData.getId();
          id = uId;
        }else{
          String u_id = UUID.randomUUID().toString().replace("-", "");
          resumesData.setId(u_id);
          id = u_id;
        }
        //将ResumesData中的数据封装到Resume中
        Resume resume = getResume(resumesData);
        //获取技能的数据
        List<ITSkill> skillList = getSkills(resumesData);
        //获取工作经历的数据
        List<WorkExperience> workExperienceList = getWorkExperiences(resumesData);
        //获取教育经历的数据
        List<EducationExperience> educationExperienceList = getEducationExperiences(resumesData);
        //获取语言技能的数据
        List<LanguageSkill> resumeLanguageList = getResumeLanguages(resumesData);

      //如果数据库中有这份简历则更新简历，否则新增简历
        if(resume !=null){
          String highestEducation = getHighestEducation(educationExperienceList);
          if(highestEducation !=null){
            resume.setHighestEducation(highestEducation);
          }
          Integer age = getAgeByBrithday(resume.getBirthday());
          if(age !=null && age>0){
            resume.setAge(age);
          }
          if(uId !=null && !"".equals(uId)){
            resume.setUpdateDate(new Date());
            updateResume(resume);
            //修改索引
            this.createIndexImpl(resume.getId(), 1);
          }else{
            //保存简历
            resumeMapper.insertSelective(resume);
          }
        //保存工作经历
          if(workExperienceList !=null && workExperienceList.size()>0){
            for(WorkExperience we :workExperienceList){
              workExperienceMapper.insertSelective(we);
            }
          }
          //保存工作经历
          if(educationExperienceList !=null && educationExperienceList.size()>0){
            for(EducationExperience education : educationExperienceList){
              educationExperienceMapper.insertSelective(education);
            }
          }
         //保存语言技能
          if(resumeLanguageList !=null && resumeLanguageList.size()>0){
            for(LanguageSkill record:resumeLanguageList){
              resumeLanguageMapper.insertSelective(record);
            }
          }
         //保存技能信息
          if(skillList !=null && skillList.size()>0){
            for(ITSkill skill:skillList){
              skillMapper.insertSelective(skill);
            }
          }
        }
      }
      return id;
    }
    
    
    private Integer getAgeByBrithday(Date brithday){
      if(brithday !=null){
        Date date=new Date(); 
        long day=(date.getTime()-brithday.getTime())/(24*60*60*1000) + 1; 
        Integer year=(int) (day/365f);
        return year;
      }
      return null;
    }
    
    /**
     * 获取最高学历
     * @param educationExperienceList
     * @return
     */
    private String getHighestEducation(List<EducationExperience> educationExperienceList){
      if(educationExperienceList !=null && educationExperienceList.size()>0){
        int j=0;
        if(educationExperienceList !=null && educationExperienceList.size()>0){
          Long startDate1 = 0L;
          for(int i=0;i<educationExperienceList.size();i++){
            EducationExperience education = educationExperienceList.get(i);
            if(education !=null ){
              if(education.getEduStartDate()!=null){
                Long startDate = education.getEduStartDate().getTime();
                if(startDate>startDate1){
                  startDate1 = startDate;
                  j = i;
                  }
                }
              }
            }
          }
        if(educationExperienceList.get(j) !=null){
          return educationExperienceList.get(j).getEducation();
        }
      }
      return null;
    }
    
    //封装简历基本信息的数据
    private Resume getResume(ResumesData resumesData){
      Resume resume = new Resume();
      if(null !=resumesData.getName() && !"".equals(resumesData.getName())){
        //基础信息
        resume.setId(resumesData.getId());
        resume.setName(resumesData.getName());
        resume.setSex(resumesData.getSex());
        if(resumesData.getBirthday() !=null && !"".equals(resumesData.getBirthday())){
          resume.setBirthday(resumesData.getBirthday());
        }
        resume.setMaritalStatus(resumesData.getMaritalStatus());
        if(resumesData.getWorkYears() !=null && !"".equals(resumesData.getWorkYears())){
          resume.setWorkExperience(Integer.parseInt(resumesData.getWorkYears()));
        }
        resume.setPhone(resumesData.getPhone());
        resume.setSex(resumesData.getSex());
        resume.setPhoneReserve(resumesData.getPhoneReseave());
        resume.setEmail(resumesData.getEmail());
        resume.setResidence(resumesData.getResidence());
        resume.setAddress(resumesData.getAddress());
        resume.setNation(resumesData.getNation());
        resume.setIdNumber(resumesData.getIdNumber());
        resume.setIdAddress(resumesData.getIdAddress());
        
        //附加信息
        resume.setSelfEvaluation(resumesData.getSelfEvaluation());
        resume.setCareerObject(resumesData.getCareerObject());
        resume.setExperienceDetail(resumesData.getExperienceDetail());
        resume.setProjectExperience(resumesData.getProjectExperience());
        resume.setTrainInfor(resumesData.getTrainInfo());
        resume.setLanguageList(resumesData.getLanguageSkill());
        resume.setAwardInfor(resumesData.getAwardInfo());
        resume.setSkillText(resumesData.getSkillText());
        resume.setCertificateInfor(resumesData.getCertificateInfo());
        resume.setHobbyInfor(resumesData.getHobbyInfo());
      }else{
        resume = null;
      }
      return resume;
    }
    
    //封装技能数据
    private List<ITSkill> getSkills(ResumesData resumesData){
      List<ITSkill> skillList = new ArrayList<ITSkill>();
      if(null != resumesData.getSkillInfo() && !"".equals(resumesData.getSkillInfo())){
        String skillInfo = resumesData.getSkillInfo();
        String rank = resumesData.getRank();
        if(skillInfo !=null && rank !=null){
          String si[] = skillInfo.split(",",-1);
          String r[] = rank.split(",",-1);
          if(si.length == r.length){
            for(int i=0;i<si.length-1;i++){
              ITSkill skill = new ITSkill();
              String u_id = UUID.randomUUID().toString().replace("-", "");
              skill.setId(u_id);
              skill.setSkill(si[i]);
              skill.setRank(r[i]);
              skill.setResumeId(resumesData.getId());
              skillList.add(skill);
            }
          }else{
            skillList = null;
          }
        }else{
          skillList = null;
        }
      }else{
        skillList = null;
      }
      return skillList;
    }
    
    //封装工作经历信息
    private List<WorkExperience> getWorkExperiences(ResumesData resumesData){
      List<WorkExperience> workExperience = new ArrayList<WorkExperience>();
      String resumeId = resumesData.getId();
      if(null != resumesData.getCompanys() && !"".equals(resumesData.getCompanys())){
        String companys = resumesData.getCompanys();
        String expStartDates = resumesData.getExpStartDates();
        String expEndDates = resumesData.getExpEndDates();
        String industries = resumesData.getIndustries();
        String roleNames = resumesData.getRoleNames();
        String locations = resumesData.getLocations();
        String companyTypeIds = resumesData.getCompanyTypeIds();
        String responsibilitys = resumesData.getResponsibilitys();
        String reportObjects = resumesData.getReportObjects();
        String subordinates = resumesData.getSubordinates();
        String salary = resumesData.getSalary();
        String currencyTypes = resumesData.getCurrencyTypes();
        String achievements = resumesData.getAchievements();
        
        if(companys !=null && expStartDates !=null && expEndDates !=null && industries !=null && roleNames !=null
            && locations !=null && companyTypeIds!=null && responsibilitys !=null && reportObjects !=null 
            && subordinates !=null && salary !=null && currencyTypes !=null && achievements !=null){
            String co[] = companys.split(",",-1);
            String eStarts[] = expStartDates.split(",",-1);
            String eEnds[] = expEndDates.split(",",-1);
            String inds[] = industries.split(",",-1);
            String rols[] = roleNames.split(",",-1);
            String locats[] = locations.split(",",-1);
            String cTypeIds[] = companyTypeIds.split(",",-1);
            String res[] = responsibilitys.split(",",-1);
            String rOb[] = reportObjects.split(",",-1);
            String sub[] = subordinates.split(",",-1);
            String sal[] = salary.split(",",-1);
            String curr[] = currencyTypes.split(",",-1);
            String ach[] = achievements.split(",",-1);
            int count = co.length;
            //判断收集的数据是否有误
            if(count==eStarts.length && count == eEnds.length && count ==inds.length 
                && count == rols.length && count == locats.length && count == cTypeIds.length && count == res.length
                && count == rOb.length && count == sub.length && count == sal.length && count == curr.length 
                && count == ach.length
             ){
              for(int i=0;i<co.length-1;i++){
                WorkExperience we = new WorkExperience();
                String u_id = UUID.randomUUID().toString().replace("-", "");
                we.setId(u_id);
                we.setCompanyName(co[i]);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                 we.setJobStartDate(sdf.parse(eStarts[i]));
                 we.setJobEndDate(sdf.parse(eEnds[i]));
                } catch (ParseException e) {
                 // TODO Auto-generated catch block
                  e.printStackTrace();
                }
                we.setIndustry(inds[i]); 
                we.setPositionName(rols[i]);
                we.setWorkplace(locats[i]);
                we.setCompanyNature(cTypeIds[i]);
                we.setJobDuty(res[i]);
                we.setDebriefer(rOb[i]);
                if(sub[i] !=null && !"".equals(sub[i].trim()) ){
                  we.setSubordinate(Integer.parseInt(sub[i].trim()));
                }
                if(sal[i] !=null && !"".equals(sal[i] )){
                  int s = Integer.parseInt(sal[i]);
                  if(s<1500){
                    we.setSalary("007-001");
                  }else if(s<2499){
                    we.setSalary("007-002");
                  }else if(s<3999){
                    we.setSalary("007-003");
                  }else if(s<5999){
                    we.setSalary("007-004");
                  }else if(s<7999){
                    we.setSalary("007-005");
                  }else if(s<9999){
                    we.setSalary("007-006");
                  }else if(s<14999){
                    we.setSalary("007-007");
                  }else if(s<19999){
                    we.setSalary("007-008");
                  }else if(s<29999){
                    we.setSalary("007-009");
                  }else if(s<50000){
                    we.setSalary("007-010");
                  }else{
                    we.setSalary("007-011");
                  }
                }
                we.setCurrency(curr[i]);
                we.setWorkPerformace(ach[i]);
                we.setResumeId(resumeId);
                workExperience.add(we);
              }
            }else{
              workExperience = null;
            }
        }else{
          workExperience = null;
        }
      }else{
        workExperience = null;
      }
      return workExperience;
    }
    
    //封装教育经历数据
    private List<EducationExperience> getEducationExperiences(ResumesData resumesData){
      List<EducationExperience> eduExp = new ArrayList<EducationExperience>();
      String resumeId = resumesData.getId();
      if(null != resumesData.getGraduationSchool() && !"".equals(resumesData.getGraduationSchool())){
        //获取数据
        String startYearMonth = resumesData.getStartYearMonth();
        String endYearMonth = resumesData.getEndYearMonth();
        String degreeName = resumesData.getDegreeName();
        String graduationSchool = resumesData.getGraduationSchool();
        String professional = resumesData.getProfessional();
        //切割字符串
        if(startYearMonth !=null && endYearMonth !=null && degreeName !=null && graduationSchool !=null && professional !=null){
          String stym[] = startYearMonth.split(",");
          String edym[] = endYearMonth.split(",");
          String dn[] = degreeName.split(",");
          String gs[] = graduationSchool.split(",");
          String pf[] = professional.split(",");
          int count = stym.length;
          if(count ==edym.length && count == dn.length && count == gs.length && count == pf.length){
            for(int i=0;i<count;i++){
              EducationExperience educationExp = new EducationExperience();
              String u_id = UUID.randomUUID().toString().replace("-", "");;
              educationExp.setId(u_id);
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
              try {
               educationExp.setEduStartDate(sdf.parse(stym[i]));
               educationExp.setEduEndDate(sdf.parse(edym[i]));
               } catch (ParseException e) {
                 // TODO Auto-generated catch block
                 e.printStackTrace();
               }
              educationExp.setEducation(dn[i]);
              educationExp.setMajor(pf[i]);
              educationExp.setSchoolName(gs[i]);
              educationExp.setResumeId(resumeId);
              eduExp.add(educationExp);
            }
          }else{
            eduExp = null;
          }
        }else{
          eduExp = null;
        }
      }else{
        eduExp = null;
      }
      return eduExp;
    }
    
    //封装简历的语言数据
    private List<LanguageSkill> getResumeLanguages(ResumesData resumesData){
      List<LanguageSkill> resumeLang= new ArrayList<LanguageSkill>();
      String resumeId = resumesData.getId();
      if(null != resumesData.getLanguageName() && !"".equals(resumesData.getLanguageName())){
        String languageName = resumesData.getLanguageName();
        String languageLevel = resumesData.getLanguageLevel();
        String oralLevel = resumesData.getOralLevel();
        if(languageName !=null && languageLevel !=null && oralLevel !=null){
          String langNa[] = languageName.split(",",-1);
          String langLev[] = languageLevel.split(",",-1);
          String oralLev[] = oralLevel.split(",",-1);
          int count = langNa.length;
          if(count == langLev.length && count == oralLev.length){
            for(int i=0;i<count-1;i++){
              LanguageSkill resumeLanguage = new LanguageSkill();
              String u_id = UUID.randomUUID().toString().replace("-", "");;
              resumeLanguage.setId(u_id);
              resumeLanguage.setLanguageName(langNa[i].trim());
              resumeLanguage.setLanguageLevel(langLev[i].trim());
              resumeLanguage.setOralLevel(oralLev[i].trim());
              resumeLanguage.setResumeId(resumeId);
              resumeLang.add(resumeLanguage);
            }
          }else{
            resumeLang = null;
          }
        }else{
          resumeLang = null;
        }
      }else{
        resumeLang = null;
      }
      return resumeLang;
    } 
    
    @Override
    public ResumesData queryResumesDataById(String id) {
      ResumesData resumesData = myResumeRepositoryMapper.queryResumesDataById(id);
      if(resumesData !=null){
        //将工作经历中的公司性质由变成名字
        List<WorkExperience> workExperienceList = resumesData.getWorkExperience();
        if(workExperienceList !=null && workExperienceList.size()>0){
          for(int i=0;i<workExperienceList.size();i++){
            WorkExperience workExperience = workExperienceList.get(i);
            if(workExperience !=null){
              String companyNature = workExperience.getCompanyNature();
              String currencyType = workExperience.getCurrency();
              if(companyNature !=null){
                workExperienceList.get(i).setCompanyNatureName(DatadictGroup.getTypeNameByTypeId(companyNature));
              }
              if(currencyType !=null && !"".equals(currencyType)){
                workExperienceList.get(i).setCurrencyTypeName(DatadictGroup.getTypeNameByTypeId(currencyType));
              }
            }
            
          }
        }
        //将语言技能中的编码变为姓名
        List<LanguageSkill> languageSkillList = resumesData.getLanguageSkill();
        if(languageSkillList!=null && languageSkillList.size()>0){
          for(int i=0;i<languageSkillList.size();i++){
            LanguageSkill languageSkill = languageSkillList.get(i);
            if(languageSkill !=null){
              String languageLevel = languageSkill.getLanguageLevel();
              String languageName = languageSkill.getLanguageName();
              String oralLevel = languageSkill.getOralLevel();
              if(languageLevel !=null && !"".equals(languageLevel)){
                languageSkillList.get(i).setLanguageLevelName(DatadictGroup.getTypeNameByTypeId(languageLevel));
              }
              if(languageName !=null && !"".equals(languageName)){
                languageSkillList.get(i).setName(DatadictGroup.getTypeNameByTypeId(languageName));
              }
              if(oralLevel !=null && !"".equals(oralLevel)){
                languageSkillList.get(i).setOralLevelName(DatadictGroup.getTypeNameByTypeId(oralLevel));
              }
            }
          }
        }
        //将技能中的熟练程度的编码转换为名称
        List<ITSkill> skillList = resumesData.getSkill();
        if(skillList !=null && skillList.size()>0){
          for(int i=0;i<skillList.size();i++){
            ITSkill skill = skillList.get(i);
            if(skill !=null){
              String rank = skill.getRank();
              if(rank !=null && !"".equals(rank)){
                resumesData.getSkill().get(i).setRankName(DatadictGroup.getTypeNameByTypeId(rank));
              }
            }
          }
        }
        
        //将教育经历中的学位编码转换为对应
        List<EducationExperience> educationExperienceList = resumesData.getEducationExperience();
        if(educationExperienceList !=null && educationExperienceList.size()>0){
          for(int i=0;i<educationExperienceList.size();i++){
            EducationExperience educationExperience = educationExperienceList.get(i);
            if(educationExperience !=null){
              String education = educationExperience.getEducation();
              if(education !=null && !"".equals(education)){
                resumesData.getEducationExperience().get(i).setEducationName(DatadictGroup.getTypeNameByTypeId(education));
              }
            }
          }
        }
        //将基础信息中的婚姻状况编码转换为名称
        String marrage = resumesData.getMaritalStatus();
        if(marrage !=null && !"".equals(marrage)){
          resumesData.setMaritalName(DatadictGroup.getTypeNameByTypeId(marrage));
        }
        
        //将基础信息中的性别编码转换为名称
        String sex = resumesData.getSex();
        if(sex !=null && !"".equals(sex)){
          resumesData.setSexName(DatadictGroup.getTypeNameByTypeId(sex));
        }
        /*//将出生日期格式化
        String birthday = resumesData.getBirthday();
        if(birthday !=null){
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
          try {
            Date date = sdf.parse(birthday);
            birthday = sdf.format(date);
            resumesData.setBirthday(birthday);
          } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }*/
      }
      return resumesData;
    }

    private void updateResume(Resume resume) {
      resumeMapper.updateByPrimaryKeySelective(resume);
      String id = resume.getId();
      workExperienceMapper.deleteByResumeId(id); 
      educationExperienceMapper.deleteByResumeId(id); 
      resumeLanguageMapper.deleteByResumeId(id);
      skillMapper.deleteByResumeId(id);
    }
    
    
    @Override
    public Result createIndexImpl(String positionId, int operationType) {
        Result result = new Result();
        Map<String, Object> source = new HashMap<String, Object>();
        ResumesData resumesData = new ResumesData();
        List<String> idList = new ArrayList<String>();
        idList.add(positionId);
        resumesData.setIdList(idList);
        ResumesData resumesData1 = null;
        MiniGridPageSort page = new MiniGridPageSort();
        page.setPageIndex(0);
        page.setPageSize(1);
        Map<String, Object> map = getQueryData(page, resumesData);
        List<ResumesData> resumesDataList = null;
        if(map !=null){
        	resumesDataList = getDICTData(myResumeRepositoryMapper.queryResumesDataByPage(map));
        }
        if(resumesDataList !=null && resumesDataList.size() > 0){
        	resumesData1 = resumesDataList.get(0);
        }
        if (resumesData1 == null) {
            logger.debug("position表里id为：" + positionId + "的数据不存在");
            return result;
        }
        source.put("positionId", resumesData1.getId());
        String name = resumesData1.getName();
        if(null != name && !name.equals("")){
        	source.put("name", name.toLowerCase());
        }
        source.put("selectionStatus", resumesData1.getSelectionStatus());
        String position = resumesData1.getPosition();
        if(null != position && !position.equals("")){
        	source.put("position", position.toLowerCase());
        }else{
        	source.put("position", position);
        }
        source.put("age", resumesData1.getAge());
        String currentPosition = resumesData1.getCurrentPosition();
        if(null != currentPosition && !currentPosition.equals("")){
        	source.put("currentPosition", currentPosition.toLowerCase());
        }else{
        	source.put("currentPosition", currentPosition);
        }
        source.put("content_type", "text/html");
        JDateTime convertToDate = null;
        if(null != resumesData1.getUpdateDate()){
        	convertToDate = new JDateTime(resumesData1.getUpdateDate());
        }else{
        	convertToDate = new JDateTime();
        }
    	source.put("create_date", convertToDate.convertToDate());
    	String label = resumesData1.getLabel();
        if(null != label && !label.equals("")){
        	source.put("label", label.toLowerCase());
        }else{
        	source.put("label", label);
        }
        String company = resumesData1.getCompany();
        if(null != company && !company.equals("")){
        	source.put("company", company.toLowerCase());
        }else{
        	source.put("company", company);
        }
        String residence = resumesData1.getResidence();
        if(null != residence && !residence.equals("")){
        	source.put("residence", residence.toLowerCase());
        }else{
        	source.put("residence", residence);
        }
        String highestEducation = resumesData1.getHighestEducation();
        if(null != highestEducation && !highestEducation.equals("")){
        	source.put("highestEducation", highestEducation.toLowerCase());
        }else{
        	source.put("highestEducation", highestEducation);
        }
        String graduationSchool = resumesData1.getGraduationSchool();
        if(null != graduationSchool && !graduationSchool.equals("")){
        	source.put("graduationSchool", graduationSchool.toLowerCase());
        }else{
        	source.put("graduationSchool", graduationSchool);
        }
        source.put("experience", resumesData1.getExperience());
        String resumeOrigin = resumesData1.getResumeOrigin();
        if(null != resumeOrigin && !resumeOrigin.equals("")){
        	source.put("resumeOrigin", resumeOrigin.toLowerCase());
        }else{
        	source.put("resumeOrigin", resumeOrigin);
        }
        source.put("salaryExpect", resumesData1.getSalaryExpect());
        String channel = resumesData1.getChannel();
        if(null != channel && !channel.equals("")){
        	source.put("channel", channel.toLowerCase());
        }else{
        	source.put("channel", channel);
        }
        String professional = resumesData1.getProfessional();
        if(null != professional && !professional.equals("")){
        	source.put("professional", professional.toLowerCase());
        }else{
        	source.put("professional", professional);
        }
        String email = resumesData1.getEmail();
        if(null != email && !email.equals("")){
        	source.put("email", email.toLowerCase());
        }else{
        	source.put("email", email);
        }
        String currentIndustry = resumesData1.getCurrentIndustry();
        if(null != currentIndustry && !currentIndustry.equals("")){
        	source.put("currentIndustry", currentIndustry.toLowerCase());
        }else{
        	source.put("currentIndustry", currentIndustry);
        }
        String sex = resumesData1.getSex();
        if(null != sex && !sex.equals("")){
        	source.put("sex", sex.toLowerCase());
        }else{
        	source.put("sex", sex);
        }
        String industryExpect = resumesData1.getIndustryExpect();
        if(null != industryExpect && !industryExpect.equals("")){
        	source.put("industryExpect", industryExpect.toLowerCase());
        }else{
        	source.put("industryExpect", industryExpect);
        }
        String workplaceExpect = resumesData1.getWorkplaceExpect();
        if(null != workplaceExpect && !workplaceExpect.equals("")){
        	source.put("workplaceExpect", workplaceExpect.toLowerCase());
        }else{
        	source.put("workplaceExpect", workplaceExpect);
        }
        try {
        	if(operationType == 0){
        		positionSearchService.createIndex(positionId, source);
        	}else{
        		positionSearchService.updateIndex(positionId, source);
        	}
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMsg("createIndex error");
            logger.error("createIndex error:", e);
        }

        return result;
    }

	@Override
	public void deleteIndex(String positionId) throws Exception {
		positionSearchService.deleteIndexById(positionId);
	}
	@Override
	public List<PositionSearch> querySearchPosition() {
		return myResumeRepositoryMapper.querySearchPosition();
	}

	@Override
	public void updatePositionIsSearch(String positionId) {
		myResumeRepositoryMapper.updatePositionIsSearch(positionId);
	}

	@Override
	public void updatePositionAddIsSearch(String positionId) {
		myResumeRepositoryMapper.updatePositionAddIsSearch(positionId);
	}

  @Override
  @Transactional
  public String saveOrUpdateResume(ResumeDataVo resumeDataVo,SysUser sysUser) {

    // TODO Auto-generated method stub
    String id ="";
    String cId = "";
    //用于判断是新增还是编辑之后保存
    String uId="";
    if(resumeDataVo !=null){
      //如Id非空则为编辑简历，Id为空则为新增简历
      if(resumeDataVo.getId() !=null && !"".equals(resumeDataVo.getId())){
        uId = resumeDataVo.getId();
        id = uId;
      }else{
        String u_id = UUID.randomUUID().toString().replace("-", "");
        resumeDataVo.setId(u_id);
        id = u_id;
      }
      //将ResumesData中的数据封装到Resume中
      Resume resume = getResumeByVo(resumeDataVo);
      
      //获取技能的数据
      List<ITSkill> skillList = getSkillsByVo(resumeDataVo);
      //获取工作经历的数据
      List<WorkExperience> workExperienceList = getWorkExperiencesByVo(resumeDataVo);
      //获取教育经历的数据
      List<EducationExperience> educationExperienceList = getEducationExperiencesByVo(resumeDataVo);
      //获取语言技能的数据
      List<LanguageSkill> resumeLanguageList = getResumeLanguagesByVo(resumeDataVo);

    //如果数据库中有这份简历则更新简历，否则新增简历
      if(resume !=null){
        String highestEducation = getHighestEducation(educationExperienceList);
        if(highestEducation !=null){
          resume.setHighestEducation(highestEducation);
        }
        Integer age = getAgeByBrithday(resume.getBirthday());
        if(age !=null && age>0){
          resume.setAge(age);
        }
        if(uId !=null && !"".equals(uId)){
          resume.setUpdateDate(new Date());
          updateResume(resume);
          //修改索引
          this.createIndexImpl(resume.getId(), 1);
          
          if("1".equals(resumeDataVo.getIsLock())){
            resume = resumeMapper.selectByPrimaryKey(id);
            if(resume != null){
              Map<String,Object> map = new HashMap<String, Object>();
              map.put("lockUserId", sysUser.getId());
              map.put("candidateId", resume.getCandidateId());
             candidateMapper.lockCandidate(map);
             cId =  resume.getCandidateId();
            }
          }
          
          
        }else{
          //保存简历
          String candidateId = UUID.randomUUID().toString().replace("-", "");
          resume.setStorageDate(new Date());
          resume.setCandidateId(candidateId);
          resumeMapper.insertSelective(resume);
          
          Candidate candidate = new Candidate();
          candidate.setId(candidateId);
          candidate.setResumeId(id);
          if("1".equals(resumeDataVo.getIsLock())){
          candidate.setLockUser(sysUser.getId());
          candidate.setLockTime(new Date());
          }
          candidateMapper.insertCandidateSelective(candidate);
          cId = candidateId ;
          
          
          
        }
      //保存工作经历
        if(workExperienceList !=null && workExperienceList.size()>0){
          for(WorkExperience we :workExperienceList){
            workExperienceMapper.insertSelective(we);
          }
        }
        //保存工作经历
        if(educationExperienceList !=null && educationExperienceList.size()>0){
          for(EducationExperience education : educationExperienceList){
            educationExperienceMapper.insertSelective(education);
          }
        }
       //保存语言技能
        if(resumeLanguageList !=null && resumeLanguageList.size()>0){
          for(LanguageSkill record:resumeLanguageList){
            resumeLanguageMapper.insertSelective(record);
          }
        }
       //保存技能信息
        if(skillList !=null && skillList.size()>0){
          for(ITSkill skill:skillList){
            skillMapper.insertSelective(skill);
          }
        }
      }
    }
    return cId;
  
  }
  
  private List<LanguageSkill> getResumeLanguagesByVo(ResumeDataVo resumeDataVo) {
    List<LanguageSkill> resumeLang= new ArrayList<LanguageSkill>();
    String resumeId = resumeDataVo.getId();
    if(null != resumeDataVo.getLanguageName() && !"".equals(resumeDataVo.getLanguageName())){
      String languageName = resumeDataVo.getLanguageName();
      String languageLevel = resumeDataVo.getLanguageLevel();
      String oralLevel = resumeDataVo.getOralLevel();
      if(languageName !=null && languageLevel !=null && oralLevel !=null){
        String langNa[] = languageName.split(",",-1);
        String langLev[] = languageLevel.split(",",-1);
        String oralLev[] = oralLevel.split(",",-1);
        int count = langNa.length;
        if(count == langLev.length && count == oralLev.length){
          for(int i=0;i<count-1;i++){
            LanguageSkill resumeLanguage = new LanguageSkill();
            String u_id = UUID.randomUUID().toString().replace("-", "");;
            resumeLanguage.setId(u_id);
            resumeLanguage.setLanguageName(langNa[i].trim());
            resumeLanguage.setLanguageLevel(langLev[i].trim());
            resumeLanguage.setOralLevel(oralLev[i].trim());
            resumeLanguage.setResumeId(resumeId);
            resumeLang.add(resumeLanguage);
          }
        }else{
          resumeLang = null;
        }
      }else{
        resumeLang = null;
      }
    }else{
      resumeLang = null;
    }
    return resumeLang;
  }

  private List<EducationExperience> getEducationExperiencesByVo(ResumeDataVo resumeDataVo) {
    List<EducationExperience> eduExp = new ArrayList<EducationExperience>();
    String resumeId = resumeDataVo.getId();
    if(null != resumeDataVo.getGraduationSchool() && !"".equals(resumeDataVo.getGraduationSchool())){
      //获取数据
      String startYearMonth = resumeDataVo.getStartYearMonth();
      String endYearMonth = resumeDataVo.getEndYearMonth();
      String degreeName = resumeDataVo.getDegreeName();
      String eduTypeName = resumeDataVo.getEduTypeName();
      String eduType = resumeDataVo.getEduType();
      String graduationSchool = resumeDataVo.getGraduationSchool();
      String professional = resumeDataVo.getProfessional();
      //切割字符串
      if(startYearMonth !=null && endYearMonth !=null && degreeName !=null && graduationSchool !=null && professional !=null
          &&eduTypeName !=null && eduType !=null){
        String stym[] = startYearMonth.split(",");
        String edym[] = endYearMonth.split(",");
        String dn[] = degreeName.split(",");
        String gs[] = graduationSchool.split(",");
        String pf[] = professional.split(",");
        String en[] = eduTypeName.split(",");
        String et[] = eduType.split(",");
        int count = stym.length;
        if(count ==edym.length && count == dn.length && count == gs.length && count == pf.length && count== en.length && count == et.length){
          for(int i=0;i<count;i++){
            EducationExperience educationExp = new EducationExperience();
            String u_id = UUID.randomUUID().toString().replace("-", "");;
            educationExp.setId(u_id);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
            try {
             educationExp.setEduStartDate(sdf.parse(stym[i]));
             educationExp.setEduEndDate(sdf.parse(edym[i]));
             educationExp.setEduType(et[i]);
             } catch (ParseException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
             }
            educationExp.setEducation(dn[i]);
            educationExp.setMajor(pf[i]);
            educationExp.setSchoolName(gs[i]);
            educationExp.setResumeId(resumeId);
            eduExp.add(educationExp);
          }
        }else{
          eduExp = null;
        }
      }else{
        eduExp = null;
      }
    }else{
      eduExp = null;
    }
    return eduExp;
  }

  private List<WorkExperience> getWorkExperiencesByVo(ResumeDataVo resumeDataVo) {
    List<WorkExperience> workExperience = new ArrayList<WorkExperience>();
    String resumeId = resumeDataVo.getId();
    if(null != resumeDataVo.getCompanys() && !"".equals(resumeDataVo.getCompanys())){
      String companys = resumeDataVo.getCompanys();
      String expStartDates = resumeDataVo.getExpStartDates();
      String expEndDates = resumeDataVo.getExpEndDates();
      String industries = resumeDataVo.getIndustries();
      String roleNames = resumeDataVo.getRoleNames();
      String locations = resumeDataVo.getLocations();
      String companyTypeIds = resumeDataVo.getCompanyTypeIds();
      String responsibilitys = resumeDataVo.getResponsibilitys();
      String reportObjects = resumeDataVo.getReportObjects();
      String subordinates = resumeDataVo.getSubordinates();
      String salary = resumeDataVo.getSalary();
      String currencyTypes = resumeDataVo.getCurrencyTypes();
      String achievements = resumeDataVo.getAchievements();
      
      if(companys !=null && expStartDates !=null && expEndDates !=null && industries !=null && roleNames !=null
          && locations !=null && companyTypeIds!=null && responsibilitys !=null && reportObjects !=null 
          && subordinates !=null && salary !=null && currencyTypes !=null && achievements !=null){
          String co[] = companys.split(",",-1);
          String eStarts[] = expStartDates.split(",",-1);
          String eEnds[] = expEndDates.split(",",-1);
          String inds[] = industries.split(",",-1);
          String rols[] = roleNames.split(",",-1);
          String locats[] = locations.split(",",-1);
          String cTypeIds[] = companyTypeIds.split(",",-1);
          String res[] = responsibilitys.split(",",-1);
          String rOb[] = reportObjects.split(",",-1);
          String sub[] = subordinates.split(",",-1);
          String sal[] = salary.split(",",-1);
          String curr[] = currencyTypes.split(",",-1);
          String ach[] = achievements.split(",",-1);
          int count = co.length;
          //判断收集的数据是否有误
          if(count==eStarts.length && count == eEnds.length && count ==inds.length 
              && count == rols.length && count == locats.length && count == cTypeIds.length && count == res.length
              && count == rOb.length && count == sub.length && count == sal.length && count == curr.length 
              && count == ach.length
           ){
            for(int i=0;i<co.length-1;i++){
              WorkExperience we = new WorkExperience();
              String u_id = UUID.randomUUID().toString().replace("-", "");
              we.setId(u_id);
              we.setCompanyName(co[i]);
              SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
              try {
               we.setJobStartDate(sdf.parse(eStarts[i]));
               we.setJobEndDate(sdf.parse(eEnds[i]));
              } catch (ParseException e) {
               // TODO Auto-generated catch block
                e.printStackTrace();
              }
              we.setIndustry(inds[i]); 
              we.setPositionName(rols[i]);
              we.setWorkplace(locats[i]);
              we.setCompanyNature(cTypeIds[i]);
              we.setJobDuty(res[i]);
              we.setDebriefer(rOb[i]);
              if(sub[i] !=null && !"".equals(sub[i].trim()) ){
                we.setSubordinate(Integer.parseInt(sub[i].trim()));
              }
              if(sal[i] !=null && !"".equals(sal[i] )){
                int s = Integer.parseInt(sal[i]);
                if(s<1500){
                  we.setSalary("007-001");
                }else if(s<2499){
                  we.setSalary("007-002");
                }else if(s<3999){
                  we.setSalary("007-003");
                }else if(s<5999){
                  we.setSalary("007-004");
                }else if(s<7999){
                  we.setSalary("007-005");
                }else if(s<9999){
                  we.setSalary("007-006");
                }else if(s<14999){
                  we.setSalary("007-007");
                }else if(s<19999){
                  we.setSalary("007-008");
                }else if(s<29999){
                  we.setSalary("007-009");
                }else if(s<50000){
                  we.setSalary("007-010");
                }else{
                  we.setSalary("007-011");
                }
              }
              we.setCurrency(curr[i]);
              we.setWorkPerformace(ach[i]);
              we.setResumeId(resumeId);
              workExperience.add(we);
            }
          }else{
            workExperience = null;
          }
      }else{
        workExperience = null;
      }
    }else{
      workExperience = null;
    }
    return workExperience;
  }

  private List<ITSkill> getSkillsByVo(ResumeDataVo resumeDataVo) {
    List<ITSkill> skillList = new ArrayList<ITSkill>();
    if(null != resumeDataVo.getSkillInfo() && !"".equals(resumeDataVo.getSkillInfo())){
      String skillInfo = resumeDataVo.getSkillInfo();
      String rank = resumeDataVo.getRank();
      if(skillInfo !=null && rank !=null){
        String si[] = skillInfo.split(",",-1);
        String r[] = rank.split(",",-1);
        if(si.length == r.length){
          for(int i=0;i<si.length-1;i++){
            ITSkill skill = new ITSkill();
            String u_id = UUID.randomUUID().toString().replace("-", "");
            skill.setId(u_id);
            skill.setSkill(si[i]);
            skill.setRank(r[i]);
            skill.setResumeId(resumeDataVo.getId());
            skillList.add(skill);
          }
        }else{
          skillList = null;
        }
      }else{
        skillList = null;
      }
    }else{
      skillList = null;
    }
    return skillList;
  }

  /**
   * 获取简历的基本信息
   * @param resumeDataVo
   * @return
   */
  private Resume getResumeByVo(ResumeDataVo resumeDataVo) {
    Resume resume = new Resume();
    if(null !=resumeDataVo.getName() && !"".equals(resumeDataVo.getName())){
      //基础信息
      resume.setId(resumeDataVo.getId());
      resume.setName(resumeDataVo.getName());
      resume.setNationality(resumeDataVo.getNationality());
      resume.setVoucherType(resumeDataVo.getCertificateType());
      resume.setVoucherNumber(resumeDataVo.getIdNumber());
      resume.setPositionid(resumeDataVo.getPositionId());
      
      resume.setSex(resumeDataVo.getSex());
      if(resumeDataVo.getBirthday() !=null && !"".equals(resumeDataVo.getBirthday())){
        resume.setBirthday(DateKit.strToDate(resumeDataVo.getBirthday()));
      }
      resume.setMaritalStatus(resumeDataVo.getMaritalStatus());
      if(resumeDataVo.getWorkYears() !=null && !"".equals(resumeDataVo.getWorkYears())){
        resume.setWorkExperience(Integer.parseInt(resumeDataVo.getWorkYears()));
      }
      resume.setPhone(resumeDataVo.getPhone());
      resume.setSex(resumeDataVo.getSex());
      resume.setPhoneReserve(resumeDataVo.getPhoneReseave());
      resume.setEmail(resumeDataVo.getEmail());
      resume.setResidence(resumeDataVo.getResidence());
      resume.setAddress(resumeDataVo.getAddress());
      resume.setNation(resumeDataVo.getNation());
      //resume.setIdNumber(resumeDataVo.getIdNumber());
      resume.setIdAddress(resumeDataVo.getIdAddress());
      
      //附加信息
      resume.setSelfEvaluation(resumeDataVo.getSelfEvaluation());
      resume.setCareerObject(resumeDataVo.getCareerObject());
      resume.setExperienceDetail(resumeDataVo.getExperienceDetail());
      resume.setProjectExperience(resumeDataVo.getProjectExperience());
      resume.setTrainInfor(resumeDataVo.getTrainInfo());
      //resume.setLanguageList(resumeDataVo.getLanguageSkill());
      resume.setAwardInfor(resumeDataVo.getAwardInfo());
      resume.setSkillText(resumeDataVo.getSkillText());
      resume.setCertificateInfor(resumeDataVo.getCertificateInfo());
      resume.setHobbyInfor(resumeDataVo.getHobbyInfo());
    }else{
      resume = null;
    }
    return resume;
  }
}