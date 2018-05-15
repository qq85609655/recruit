package com.csot.recruit.service.impl.resume;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.core.spring.service.impl.SpringPropertyResourceReader;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.csot.recruit.common.enums.LogLevel;
import com.csot.recruit.common.enums.OperateType;
import com.csot.recruit.common.exception.BusinessException;
import com.csot.recruit.common.service.CommonService;
import com.csot.recruit.common.util.CommonConstant;
import com.csot.recruit.common.util.DataUtils;
import com.csot.recruit.common.util.DateKit;
import com.csot.recruit.common.util.FileUtils;
import com.csot.recruit.common.util.PropertiesUtil;
import com.csot.recruit.common.util.ReadMailViaEWS;
import com.csot.recruit.common.util.SendMailUtil;
import com.csot.recruit.common.util.StringUtil;
import com.csot.recruit.dao.original.resume.BasicinforMapper;
import com.csot.recruit.dao.position.RecruitPositionMapper;
import com.csot.recruit.dao.resume.CertificationMapper;
import com.csot.recruit.dao.resume.EducationExperienceMapper;
import com.csot.recruit.dao.resume.ITSkillMapper;
import com.csot.recruit.dao.resume.LanguageSkillMapper;
import com.csot.recruit.dao.resume.ResumeMapper;
import com.csot.recruit.dao.resume.TrainingMapper;
import com.csot.recruit.dao.resume.WorkExperienceMapper;
import com.csot.recruit.dao.resume.WorkIntentionMapper;
import com.csot.recruit.model.datadict.DatadictGroup;
import com.csot.recruit.model.log.Log;
import com.csot.recruit.model.nresume.AdditionalInformation;
import com.csot.recruit.model.nresume.CareerObjective;
import com.csot.recruit.model.nresume.Certification;
import com.csot.recruit.model.nresume.Education;
import com.csot.recruit.model.nresume.EmailFile;
import com.csot.recruit.model.nresume.EmailItem;
import com.csot.recruit.model.nresume.EmailResume;
import com.csot.recruit.model.nresume.PersonalInformation;
import com.csot.recruit.model.nresume.Training;
import com.csot.recruit.model.original.resume.Basicinfor;
import com.csot.recruit.model.position.RecruitPosition;
import com.csot.recruit.model.position.RecruitPositionCriteria;
import com.csot.recruit.model.resume.EducationExperience;
import com.csot.recruit.model.resume.ITSkill;
import com.csot.recruit.model.resume.LanguageSkill;
import com.csot.recruit.model.resume.Resume;
import com.csot.recruit.model.resume.ResumeCLabel;
import com.csot.recruit.model.resume.ResumeColumns;
import com.csot.recruit.model.resume.ResumeCriteria;
import com.csot.recruit.model.resume.ResumeTemplate;
import com.csot.recruit.model.resume.WorkExperience;
import com.csot.recruit.model.resume.WorkIntention;
import com.csot.recruit.model.vo.ResumeApartVo;
import com.csot.recruit.model.vo.ResumeVo;
import com.csot.recruit.service.resume.MyResumeRepositoryService;
import com.csot.recruit.service.resume.ResumeService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.google.common.base.Throwables;

import freemarker.template.Template;

@Service("resumeService")
@Transactional
public class ResumeServiceImpl implements ResumeService {
    private static final Logger logger = LoggerFactory.getLogger(ResumeServiceImpl.class);

    @Resource
    private CommonService com;
    
    @Resource
    private ResumeMapper resumeMapper;
    
    @Resource
    private RecruitPositionMapper recruitPositionMapper;
    
    @Resource
    private MyResumeRepositoryService myResumeRepositoryService;

    @Resource
    private WorkExperienceMapper workExperienceMapper;
    
    @Resource
    private EducationExperienceMapper educationExperienceMapper;
    
    @Resource
    private WorkIntentionMapper workIntentionMapper;
    
    @Resource
    private CertificationMapper certificationMapper;
    
    @Resource
    private TrainingMapper trainingMapper;
    
    @Resource
    private ITSkillMapper ITskillMapper;
    
    @Resource
    private LanguageSkillMapper languageSkillMapper;
    
    @Resource
    private SpringPropertyResourceReader springPropertyResourceReader;
    
    @Resource
    private FreeMarkerConfigurer freemarkerConfig;
    
    @Resource
    private BasicinforMapper basicinforMapper ;
    
    @Override
    public MiniRtn2Grid<Resume> getGrid(MiniGridPageSort pageSort, String searchKey) {
        MiniRtn2Grid<Resume> grid = new MiniRtn2Grid<Resume>();
        ResumeCriteria criteria = new ResumeCriteria();
        // 查询条件
        if (StringUtils.hasText(searchKey)) {
            criteria.createCriteria().andIdEqualTo(searchKey);
        }
        // 分页和排序
         if (pageSort.isShowPager()) {
            Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
            criteria.setPage(page);
        }
        String sortColumn = ResumeColumns.getColumn(pageSort.getSortField());
        if (StringUtils.hasText(sortColumn)) {
            StringBuilder sortStrBldr = new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
            criteria.setOrderByClause(sortStrBldr.toString());
        }
        grid.setData(resumeMapper.selectByExample(criteria));
        grid.setTotal(resumeMapper.countByExample(criteria));
        return grid;
    }

    @Override
    public Resume getByPrimaryKey(String primaryKey, HttpServletRequest request) {
        Resume resume = resumeMapper.selectByPrimaryKey(primaryKey);
        
        // 如果最高学历字段没有值，从教育经历中查找
        if(StringUtil.isEmpty(resume.getHighestEducation())) {
          if(resume.getEduExperienceList() != null && resume.getEduExperienceList().size() > 0) {
            resume.setHighestEducation(resume.getEduExperienceList().get(0).getEducation());
          }
        }
        
        // 最近就职的公司
        if(StringUtil.isEmpty(resume.getCurrentCompany())) {
          if(resume.getWorkExperienceList() != null && resume.getWorkExperienceList().size() > 0) {
            resume.setCurrentCompany(resume.getWorkExperienceList().get(0).getCompanyName());
            if(StringUtil.isEmpty(resume.getCurrentPosition())) {
              resume.setCurrentPosition(resume.getWorkExperienceList().get(0).getPositionName());
            }
          }
        }
        
        resume.setHighestEducation(DatadictGroup.getTypeNameByTypeId(resume.getHighestEducation())); // 最高学历                      
        resume.setSex(DatadictGroup.getTypeNameByTypeId(resume.getSex())); // 性别
        resume.setMaritalStatus(DatadictGroup.getTypeNameByTypeId(resume.getMaritalStatus())); // 婚姻状况
        resume.setSalaryExpect(DatadictGroup.getTypeNameByTypeId(resume.getSalaryExpect())); // 目标薪水
        resume.setReportTime(DatadictGroup.getTypeNameByTypeId(resume.getReportTime())); // 到岗时间
        if(null == resume.getAge() && null != resume.getBirthday()) {
          resume.setAge(DataUtils.getAge(resume.getBirthday()));
        }
        
        // 设置每段 工作经历的时长和币种
        for(WorkExperience w : resume.getWorkExperienceList()) {
          if(null != w.getJobStartDate() && null != w.getJobEndDate()) {
            w.setWorkLength(workLength(w.getJobEndDate(),w.getJobStartDate()));
          }
          w.setCurrency(DatadictGroup.getTypeNameByTypeId(w.getCurrency()));
        }
        
        // 设置教育经历中的学历
        for(EducationExperience e : resume.getEduExperienceList()) {
          e.setEducation(DatadictGroup.getTypeNameByTypeId(e.getEducation()));
        }
        
        // 评论记录的时间转换
        for(Log log : resume.getOpRecords()) {
          if(OperateType.COMMENT.getValue().equals(log.getOperatetype())) {
            log.setTime(toTimeStr(log.getOperatetime()));
          }
        }
        
        if(StringUtil.isNotEmpty(resume.getResumeDir())) { // 设置附件文件
          //String fileDir = request.getSession().getServletContext().getRealPath(File.separator + "resources" + File.separator + "upload" + File.separator + resume.getResumeDir());
          PropertiesUtil propertiesUtil = new PropertiesUtil("constant.properties");
          String fileDir = propertiesUtil.readProperty("resumeDir") + File.separator + resume.getResumeDir();
          File dir = new File(fileDir);
          File[] files = dir.listFiles();
          String basePath;
          String fileName;
          String name;
          if(null != files) {
            List<com.csot.recruit.model.resume.File> attachments = new ArrayList<com.csot.recruit.model.resume.File>();
            for (int i = 0; i < files.length; i++) {
              if (files[i].exists()) {
                fileName = files[i].getName();
                name = fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.lastIndexOf("."));
                if("resume".equals(name)) { // 如果是简历原文
                  resume.setResumeSize(FileUtils.FormetFileSize(files[i].length()));
                  basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
                  basePath +=  "/resources/upload/" + resume.getResumeDir() + fileName;
                  resume.setResumeDir(basePath); // 重置为简历原文的全路径 
                }
                else {
                  attachments.add(new com.csot.recruit.model.resume.File(files[i].getName(), FileUtils.FormetFileSize(files[i].length())));
                }
              }
              else {
                resume.setResumeDir("");
                resume.setResumeSize("无");
              }
            }
            resume.setAttachments(attachments);
          }
        }
        return resume;
    }
    
    @Override
    public Resume getByPrimaryKey(String primaryKey) {
        Resume resume = resumeMapper.selectByPrimaryKey(primaryKey);
        return resume;
    }
    
    /**
     * 计算两个时间差,用于显示在工作经历中
     * @param time1
     * @param time2
     * @return
     */
    public String workLength(Date date1, Date date2) {
      String str = "";
      int year,year1,year2,month,month1,month2;
      Calendar c = Calendar.getInstance();
      c.setTime(date1);
      year1 = c.get(Calendar.YEAR);
      month1 = c.get(Calendar.MONTH);
      c.setTime(date2);
      year2 = c.get(Calendar.YEAR);
      month2 = c.get(Calendar.MONTH);
      year = year1 - year2;
      if(0 == year) {
        str = (month1 - month2) + "月";
      } 
      else {
        month = 12*year + month1 - month2;
        str = (month/12) + "年" + (month%12) + "个月";
      }
      return str;
    }
    
    /**
     * 计算给定的时间与当前时间的时间差：刚刚（三分钟内）；三分钟前；五分钟前；十分钟前；半小时前；一小时前；三小时前；六小时前；一天前；三天前；一个月前；三个月前；半年前；一年前；二年前；三年前；五年前
     * @param date
     * @return
     */
    public String toTimeStr(Date date) {
      int y;
      String str = "刚刚";
      long sec = (new Date().getTime() - date.getTime())/1000;
      long [] arr = {5*365*24*60*60,3*365*24*60*60,2*365*24*60*60,365*24*60*60,180*24*60*60,90*24*60*60,30*24*60*60,10*24*60*60,5*24*60*60,3*24*60*60,2*24*60*60,24*60*60,6*60*60,3*60*60,60*60,30*60,10*60,5*60,3*60};
      String[] strs = {"五年前","三年前","二年前","一年前","半年前","三个月前","一个月前","十天前","五天前","三天前","两天前","一天前","六小时前","三小时前","一小时前","半小时前","十分钟前","五分钟前","三分钟前"};
      for(int i = 0; i < arr.length; i++) {
        y = (int)(sec/arr[i]);
        if(y > 0) {
          str = strs[i];
          break;
        }
      }
      return str;
    }
    
    @Override
    public void create(Resume resume) {
        resumeMapper.insertSelective(resume);
    }

    @Override
    public void updateSelective(Resume resume) {
        resumeMapper.updateByPrimaryKeySelective(resume);
    }

    @Override
    public void remove(String primaryKey) {
        
    }

	@Override
	public String createResumeByExcel(ResumeTemplate resumeTemplate)
			throws Exception {
		Resume resume = new Resume();
		resume.setId(resumeTemplate.getResumeId());
		resume.setName(resumeTemplate.getName());
		resume.setSex(resumeTemplate.getSex());
		resume.setAge(resumeTemplate.getAge());
		//现居住地存exel里面的所在省份和所在城市
		String residence = resumeTemplate.getProvince()+resumeTemplate.getCity();
		resume.setResidence(residence);
		resume.setAddress(resumeTemplate.getAddress());
		resume.setPhone(resumeTemplate.getMobilePhone());
		resume.setPhoneReserve(resumeTemplate.getTelphone());
		resume.setNation(resumeTemplate.getNation());
		resume.setEmail(resumeTemplate.getEmail());
		resume.setWorkExperience(resumeTemplate.getExperience());
		resume.setSalaryExpect(resumeTemplate.getExpectedSalary());
		resume.setHighestEducation(resumeTemplate.getEducation());
		//毕业学校
		resume.setGraduationSchool(resumeTemplate.getGraduationSchool());
		//专业
		resume.setProfessional(resumeTemplate.getProfessional());
		//最近公司
		resume.setCurrentCompany(resumeTemplate.getCompany());
		//当前月薪
		resume.setCurrentSalary(resumeTemplate.getCurrentSalary());
		//最近就职的职位名称
		resume.setCurrentPosition(resumeTemplate.getCurrentPosition());
		//招聘渠道
		resume.setChannel(resumeTemplate.getChannel());
		//简历语言
		resume.setResumeLanguage(resumeTemplate.getResumeLanguage());
		//推荐人邮箱
		resume.setRecommendEmail(resumeTemplate.getRecommendEmail());
		//推荐人姓名
		resume.setRecommend(resumeTemplate.getRecommend());
		//身份证号码
		resume.setIdNumber(resumeTemplate.getCardId());
		//应聘职位
		resume.setPositionid(resumeTemplate.getPosition());
		//如果简历语言为英文，则性别、所在省份、所在城市、民族、期望薪资、最高学历只需按格式填写中文即可，系统会根据你所选择的简历语言去翻译
		if(resumeTemplate.getResumeLanguage().equals("英文")){
			Pattern p = Pattern.compile("[a-zA-Z]"); 
			Matcher m = p.matcher(String.valueOf(resumeTemplate.getSex()));
	        if(!m.matches()){
	    	    return "性别请输入英文";
	        }
			resume.setSex(DatadictGroup.getTypeIdByTypeName(resumeTemplate.getSex(), "sex"));
			Matcher ma = p.matcher(String.valueOf(resumeTemplate.getEducation()));
			if(!ma.matches()){
	    	    return "最高学历请输入英文";
	        }
			resume.setHighestEducation(DatadictGroup.getTypeIdByTypeName(resumeTemplate.getEducation(), "education"));
		}
		resume.setStorageDate(new Date());
		resumeMapper.insertSelective(resume);
		return "";
	}

	@Override
	public String queryPositionByName(String positionName) {
		String positionId = "";
		RecruitPositionCriteria example = new RecruitPositionCriteria();
		example.createCriteria().andPositionNameEqualTo(positionName);
		List<RecruitPosition> list = recruitPositionMapper.selectByExample(example);
		if(list.size() > 0){
			positionId = list.get(0).getRecruitPositionId();
		}
		return positionId;
	}
	
	/**
     * 根据编码查询相应的职位
     * @param positionCode 职位编码
     * @return
     */
	public RecruitPosition getPositionByCode(String positionCode) {
	  return recruitPositionMapper.getPositionByCode(positionCode);
	}
	
    @Override
    public void deleTag(String resumeId, String resumeTags, String tagId) {
      resumeMapper.updateResumeLabel(resumeId, resumeTags);
      resumeMapper.removeResumeLabel(resumeId, tagId);
    }

    @Override
    public void updateTags(String resumeId, String resumeTags, String deletes, String adds) {
      resumeMapper.updateResumeLabel(resumeId, resumeTags);
      if(StringUtil.isNotEmpty(deletes)) {
        List<String> listDele = Arrays.asList(deletes.split(","));
        resumeMapper.removeResumeLabels(resumeId, listDele);
      }
      if(StringUtil.isNotEmpty(adds)) {
        List<String> listTagsId = Arrays.asList(adds.split(","));
        List<ResumeCLabel> tags = new ArrayList<ResumeCLabel>();
        for(String str : listTagsId) {
          tags.add(new ResumeCLabel(UUID.randomUUID().toString().replace("-", ""), resumeId, str));
        }
        resumeMapper.addResumeLabels(tags);
      }
    }
    
    /**
     * 添加候选人
     */
    public String addToCandidate(String resumeIds, String channel,String positionId) {
      Resume resume = new Resume();
      resume.setId(resumeIds);
      resume.setResumeStatus(1);
      if(positionId !=null && !"".equals(positionId)){
        resume.setPositionid(positionId);
      }
      if(null != channel && !channel.trim().equals("")) {
          resume.setChannel(channel);
      }
      try {
        updateResumeById(resume);
      } catch (Exception e) {
        logger.error("添加候选人异常" + e.getMessage());
        return e.getMessage();
      }
      return "true";
    }
    
	@Override
	public int updateResumeById(Resume resume) throws Exception {
		int count = 0;
		String [] resumeId = resume.getId().split(",");
		for(int i = 0; i < resumeId.length; i++){
			resume.setId(resumeId[i]);
			count = resumeMapper.updateByPrimaryKeySelective(resume);
			//删除索引
			myResumeRepositoryService.deleteIndex(resume.getId());
			com.addLog("加为候选人，关联职位", LogLevel.INFO.getValue(), OperateType.OPRECORD.getValue(), resumeId[i]); // 操作记录
		}
		if(count == 0){
			throw new Exception("修改简历数据异常");
		}
		return 1;
	}

	@Override
	public void createResume(List<String> resumeDirList) {
		Resume resume = new Resume();
		for(int i = 0; i < resumeDirList.size(); i++){
			resume.setId(UUID.randomUUID().toString().replace("-", ""));
			resume.setResumeDir(resumeDirList.get(i));
			resume.setStorageDate(new Date());
			//调用第三方提供的简历解析接口，之后再把解析的数据放到数据库保存
			resumeMapper.insertSelective(resume);
		}
	}

	@Override
	public String transmitResume(String resumeNames, String resumeIds, String txtSrEmail, 
			String sendResumeTemp, String postscript, String name, String projectUrl) throws Exception {
		String resumeName [] = resumeNames.split(",");
		String resumeId [] = resumeIds.split(",");
		PropertiesUtil propertiesUtil = new PropertiesUtil(
				"constant.properties");
		String filePath = "";
		for (int i = 0; i < resumeId.length; i++) {
			Resume resume = resumeMapper.selectByPrimaryKey(resumeId[i].trim());
			//判断该简历附件是否存在
			if(null != resume.getResumeDir() && !resume.getResumeDir().equals("")){
				String resumeDir = resume.getResumeDir();
				filePath = projectUrl+resumeDir.trim()+File.separator+"resume.html";
				filePath = filePath.replace("/", File.separator);
				
			}
			//邮件主题
			String subject = propertiesUtil.readProperty("subject");
			//邮件内容
			String sendHtml = propertiesUtil.readProperty("sendHtml");
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sendReason", postscript);
			String message = SendMailUtil.sendFtlMail(txtSrEmail, subject, sendResumeTemp, map,
					sendHtml, filePath, resumeName, name);
			if(!message.equals("")){
				throw new Exception(message);
			}
		}
		return "操作成功";
	}

@Override
  public String deleAttachment(String resumeId, String fileName, String basePath) {
    if(basePath.isEmpty()) {
      return "文件根目录不存在！";
    }
    String filePath = resumeMapper.getResumeDir(resumeId);
    if(filePath.isEmpty()) {
      return "该简历没有附件！";
    }
    String fileUrl = basePath + File.separator + filePath + File.separator + fileName;
    File file = new File(fileUrl);
    if(!file.exists()) {
      return "文件不存在！";
    }
    else {
      file.delete();
      return "true";
    }
  }

  /**
   * 添加评论
   */
  @Override
  public String addResumeComment(String resumeId, String content, Integer privacylevel) {
    try {
      com.addLog(content, LogLevel.INFO.getValue(), privacylevel, OperateType.COMMENT.getValue(), resumeId);
    } catch (Exception e) {
      logger.error("添加评论异常" + e.getMessage());
      return e.getMessage();
    }
    return "true";
  }
  
  /**
   * 简历入库
   * @param presume 邮件简历对象
   * @param fileDir 保存的中间路径
   * @param origin 简历来源
   * @return
   */
  public String createResume(com.csot.recruit.model.nresume.Resume presume, String fileDir) {
    String result = "true";
    Resume resume = new Resume();
    resume.setResumeorigin(presume.getResumeSource()); // 简历来源
    resume.setChannel(presume.getChannel()); // 招聘渠道
    
    PersonalInformation pInfor = presume.getPersonalInfomation();
    AdditionalInformation addInfor =presume.getAdditionalInformation();
    Education[] educations = presume.getEducations();
    com.csot.recruit.model.nresume.WorkExperience[] workExperiences = presume.getWorkExperiences();
    CareerObjective co = presume.getCareerObjective();
    Certification[] certifications = addInfor.getCertifications();
    com.csot.recruit.model.nresume.LanguageSkill[] languageSkills = addInfor.getLanguageSkills();
    com.csot.recruit.model.nresume.ITSkill[] itSkills = addInfor.getItSkills();
    Training[] trainings = addInfor.getTrainings();
    
    resume.setId(UUID.randomUUID().toString().replace("-", ""));
    resume.setResumeDir(fileDir);
    resume.setStorageDate(new Date());
    resume.setPositionid(presume.getPositionId());
    
    resume.setAddress(pInfor.getAddress());
    resume.setPhoneReserve(pInfor.getAlternativePhone());
    resume.setBirthday(pInfor.getDateOfBirth());
    resume.setResidence(pInfor.getResidency().getValue().toString());
    resume.setVoucherType(pInfor.getIdType().getValue().toString());
    resume.setVoucherType(pInfor.getIdNumber());
    resume.setAddressRegistered(pInfor.getHuKou().getValue().toString());
    resume.setMaritalStatus(DatadictGroup.getTypeIdByTypeCode(pInfor.getMaritalStatus().getValue().toString(),"marital-status"));
    resume.setNationality(pInfor.getNationality().getValue().toString());
    resume.setPhone(pInfor.getPhone());
    resume.setPostcode(pInfor.getPostcode());
    resume.setSex(DatadictGroup.getTypeIdByTypeCode(pInfor.getGender().getValue().toString(),"sex"));
    resume.setName(pInfor.getName());
    resume.setEmail(pInfor.getEmail());
    resume.setWorkExperience(pInfor.getYearsOfWorkExperience());
    
    resume.setSelfAssessment(addInfor.getSelfAssessment());
    resume.setExperienceDetail(addInfor.getWorkExperienceDetail());
    
    resumeMapper.insertSelective(resume);
   
    // 保存教育经历
    if(null != educations) {
      for(Education e : educations) {
        EducationExperience ee = new EducationExperience();
        ee.setId(UUID.randomUUID().toString().replace("-", ""));
        ee.setResumeId(resume.getId());
        ee.setEducation(DatadictGroup.getTypeIdByTypeCode(e.getDegree().getValue().toString(), "education"));
        ee.setEduStartDate(e.getStartingDate());
        ee.setEduEndDate(e.getEndingDate());
        ee.setMajor(e.getMajor());
        ee.setSchoolName(e.getSchool());
        educationExperienceMapper.insertSelective(ee);
      }
    }
    
    // 保存工作经历
    if(null != workExperiences) {
      for(com.csot.recruit.model.nresume.WorkExperience w : workExperiences) {
        WorkExperience we = new WorkExperience();
        we.setId(UUID.randomUUID().toString().replace("-", ""));
        we.setResumeId(resume.getId());
        we.setCompanyName(w.getCompany());
        we.setCompanyNature(DatadictGroup.getTypeIdByTypeCode(w.getCompanyType().getValue().toString(), "company_type"));
        we.setJobDuty(w.getJobDescription());
        we.setWorkPerformace(w.getAchievement());
        we.setJobStartDate(w.getStartingDate());
        we.setJobEndDate(w.getEndingDate());
        we.setPositionName(w.getJobTitle());
        we.setSalary(w.getMonthlySalary());
        we.setDebriefer(w.getDirectReportTo());
        we.setIndustry(DatadictGroup.getTypeIdByTypeCode(w.getIndustry().getValue().toString(), "industry"));
        we.setSubordinate(w.getNumberOfSubordinates());
        we.setWorkplace(w.getLocation().getDisplayValue());
        workExperienceMapper.insertSelective(we);
      }
    }
    
    // 求职意向
    if(null != co) {
      String jobType = "";
      String positions = "";
      if(null != co.getDesiredTypeOfEmployment()) {
        for(String s : co.getDesiredTypeOfEmployment()) {
          jobType += DatadictGroup.getTypeIdByTypeCode(s,"recruit-obj") + ",";
        }
        jobType = jobType.substring(0,jobType.length()-1);
      }
      if(null != co.getDesiredPosition()) {
        for(String s : co.getDesiredPosition()) {
          positions += s + ",";
        }
        positions = positions.substring(0,jobType.length()-1);
      }
      WorkIntention wi = new WorkIntention();
      wi.setId(UUID.randomUUID().toString().replace("-", ""));
      wi.setResumeId(resume.getId());
      wi.setCurrency(DatadictGroup.getTypeIdByTypeCode(co.getDesiredSalaryCurrency().getValue().toString(),"currency_type"));
      wi.setIndustryExpect(DatadictGroup.getTypeIdByTypeCode(co.getDesiredIndustry() + "","industry"));
      wi.setJobtypeExpect(jobType);
      wi.setPostExpect(positions);
      wi.setRpeortTime(co.getAvailability().getValue().toString());
      wi.setSalaryExpect(co.getDesiredSalary());
      wi.setWorkplaceExpect(co.getDesiredLocation());
      workIntentionMapper.insertSelective(wi);
    }
    
    // 证书
    if(null != certifications) {
      for(Certification c : certifications) {
        Certification cf = new Certification();
        cf.setId(UUID.randomUUID().toString().replace("-", ""));
        cf.setResumeId(resume.getId());
        cf.setName(c.getName());
        cf.setScore(c.getScore());
        cf.setReceivingDate(c.getReceivingDate());
        certificationMapper.insertSelective(cf);
      }
    }
    
    
    // 保存语言技能
    if(null != languageSkills) {
      for(com.csot.recruit.model.nresume.LanguageSkill l: languageSkills) {
        LanguageSkill ls = new LanguageSkill();
        ls.setId(UUID.randomUUID().toString().replace("-", ""));
        ls.setResumeId(resume.getId());
        ls.setLanguageName(DatadictGroup.getTypeIdByTypeCode(l.getLanguage(), "language"));
        ls.setLanguageLevel(DatadictGroup.getTypeIdByTypeCode(l.getLanguageLevel(),"english-level"));
        ls.setOralLevel(DatadictGroup.getTypeIdByTypeCode(l.getOralLevel(),"oral_level"));
        languageSkillMapper.insertSelective(ls);
      }
    }
    
    // 保存IT技能信息
    if(null != itSkills) {
      for(com.csot.recruit.model.nresume.ITSkill  i: itSkills) {
        ITSkill is = new ITSkill();
        is.setId(UUID.randomUUID().toString().replace("-", ""));
        is.setResumeId(resume.getId());
        is.setRank(DatadictGroup.getTypeIdByTypeCode(i.getLevel(), "skill_level"));
        is.setSkill(i.getSkill());  //这里没有转, 数据量太大，还没有入库
        is.setExperience(i.getExperience());
        ITskillMapper.insertSelective(is);
      }
    }
    
    // 保存培训信息
    if(null != trainings) {
      for(Training train : trainings) {
        train.setId(UUID.randomUUID().toString().replace("-", ""));
        train.setResumeId(resume.getId());
        trainingMapper.insertSelective(train);
      }
    }
    
    myResumeRepositoryService.createIndexImpl(resume.getId(), 0);
    return result;
  }
  
  @Override
  public void downloadResume(String resumePath, String resumeName, HttpServletResponse res,
      HttpServletRequest req) throws IOException {
    if(StringUtil.isEmpty(resumePath)) {
      return;
    }
    //String basePath = req.getSession().getServletContext().getRealPath("/");
    //String fileUrl = basePath + resumePath.substring(resumePath.indexOf("/resources/upload/") + 1, resumePath.length());
    PropertiesUtil propertiesUtil = new PropertiesUtil("constant.properties");
    String basePath = propertiesUtil.readProperty("resumeDir"); 
    String fileUrl = basePath + resumePath.substring(resumePath.indexOf("/resources/upload/") + "/resources/upload/".length() -1 , resumePath.length());
    String fileType = resumePath.substring(resumePath.lastIndexOf("."), resumePath.length());
    String fileName = java.net.URLEncoder.encode(resumeName, "UTF-8");
    String userAgent = req.getHeader("User-Agent").toLowerCase();
    if (userAgent.indexOf("msie") != -1)  // IE浏览器，只能采用URLEncoder编码  
    {  
       fileName =  java.net.URLEncoder.encode(resumeName, "UTF-8");
    }  
    else if (userAgent.indexOf("mozilla") != -1)  // FireFox浏览器，可以使用MimeUtility或filename*或ISO编码的中文输出  
    {  
       fileName = new String(resumeName.getBytes("UTF-8"),"ISO8859-1");
    } 
    else if (userAgent.indexOf("safari") != -1 )  // Safari浏览器，只能采用ISO编码的中文输出  
    {  
       fileName = new String(resumeName.getBytes("UTF-8"),"ISO8859-1");  
    }  
    else if (userAgent.indexOf("applewebkit") != -1 )  // Chrome浏览器，只能采用MimeUtility编码或ISO编码的中文输出  
    {  
       fileName = MimeUtility.encodeText(resumeName);  
    } 

    File file = new File(fileUrl);
    if(!file.exists()) {
      return;
    }
    logger.info("downloadFile:" + fileUrl + " size:" + file.length());
    res.reset(); 
    res.setHeader("Content-Disposition", "attachment;filename=" + fileName + fileType);
    res.setContentType("json; charset=utf-8"); 
    OutputStream os = res.getOutputStream();  
    try {  
      os.write(org.apache.commons.io.FileUtils.readFileToByteArray(file));  
      os.flush();  
    } catch(IOException io) {
        
    }
    finally {  
      if (os != null) {  
        os.close();  
      }  
    }
    
  }

  @Override
  public int parseResumeByEmail(String userName, String password, String server) throws BusinessException {
    //String basePath = System.getProperty("webapp.root") + "resources/upload/";
    PropertiesUtil propertiesUtil = new PropertiesUtil("constant.properties");
    String basePath = propertiesUtil.readProperty("resumeDir");
    String siteKeys[] = propertiesUtil.readProperty("recruitSiteKey").split(",");
    ReadMailViaEWS redMail  = new ReadMailViaEWS();
    List<EmailItem> emails = new ArrayList<EmailItem>();
    try {
      emails = redMail.readMail(userName, password, server, basePath);
      for(EmailItem item : emails) {
        String strAttach = "";
        item.getAttachments().add(new EmailFile("resume_" + new Date().getTime() + ".html",FileUtils.toBase64String(item.getBody()))); // 将内容也加到附件中去
        for(EmailFile attach : item.getAttachments()) {
          strAttach += "{'Name':'" + (StringUtil.isEmpty(attach.getName())?"":attach.getName()) + "','Data':'" + (StringUtil.isEmpty(attach.getData())? "":attach.getData()) + "','Encoding':'" + (StringUtil.isEmpty(attach.getEncoding())?"":attach.getEncoding()) + "'},";
        }
        if(strAttach.length() > 0){
          strAttach = strAttach.substring(0, strAttach.length() - 1);
        }
        String strData = "{'Subject':'" + (StringUtil.isEmpty(item.getSubject())?"":item.getSubject()) + "'," +
                          "'From':'" + item.getFrom() + "'," +
                          "'Body':''," + //(StringUtil.isEmpty(item.getBody())?"":item.getBody()) +" '," +   这里是html时雇得易解析有问题，就不传值了，这块内容在附件中也放了一份,不影响
                          "'BodyEncoding':''," +
                          "'AlternateView':{'Encoding':'UTF-8','ContentData':''}," +
                          "'Attachments':[" + strAttach + "]"
                       + "}"; 
        EmailResume resumeEmail = com.parseResumeByMail(strData);
        for(String key : siteKeys) { // 设置招聘渠道
          if(item.getSubject().toLowerCase().indexOf(key) > -1) {
            resumeEmail.setFrom(key);
            resumeEmail.getResume().setChannel(key);
            break;
          }
        }
        String jobName = resumeEmail.getJobName();
        if(item.getSubject().toLowerCase().indexOf("cjol") > -1) { // 当为CJOL时，简析后没有jobName,取主题中的职位名称
          jobName = item.getSubject().split("：")[0]; // 中文'：'
        }
        if(StringUtil.isNotEmpty(jobName)) { 
          int m = jobName.lastIndexOf('('); // 如果是本系统分发的职位，职位名称会是这样    '职位名称(职位编码)'
          int n = jobName.lastIndexOf(')');
          RecruitPosition position = null;
          String code = "";
          if(m > -1 && n > -1 && n > m) { 
            code = jobName.substring(m + 1, jobName.length() - 1);
            position = getPositionByCode(code);
            if(null != position) {
              resumeEmail.getResume().setPositionId(position.getRecruitPositionId()); // 关联上系统内部的职位, 
            }
          }
        }
        createResume(resumeEmail,item.getSaveDir());
      }
      logger.info("本次从邮箱中解析了" + emails.size() + "份简历！");
    } catch (Exception e) {
      throw new BusinessException(e.getMessage());
    }
    return emails.size();
  }

  @Override
  public String createResume(EmailResume resumeEmail, String fileDir) {
    com.csot.recruit.model.nresume.Resume resume = resumeEmail.getResume();
    resume.setResumeSource("邮件导入"); // 设置简历来源
    return createResume(resume, fileDir); 
  }

  @Override
  public List<ResumeApartVo> selectResumeListByCandidateId(String candidateId) {
    return resumeMapper.selectByCandidateId(candidateId);
  }

  @Override
  public ResumeVo getResumeVo(String resumeId) {
    ResumeVo rv = new ResumeVo();
    Resume resume = resumeMapper.selectByPrimaryKey(resumeId);
    
    rv.setName(resume.getName());
    rv.setWorkExperience(resume.getWorkExperience().toString());
    rv.setAddress(resume.getAddress());
    rv.setPhone(resume.getPhone());
    rv.setEmail(resume.getEmail());
    rv.setResumeorigin(resume.getResumeorigin());
    rv.setChannel(resume.getChannel());
    rv.setUpdateDate(DateKit.timeToStr(resume.getUpdateDate()));
    rv.setStorageDate(DateKit.timeToStr(resume.getStorageDate()));
    rv.setPositionId(resume.getPositionid());
    //获取最后一份教育经历
    EducationExperience edu = educationExperienceMapper.selectLastEdu(resumeId);
    if(edu != null){
      //毕业学校
      rv.setSchool(edu.getSchoolName());
      //专业
      rv.setMajor(edu.getMajor());
      //学位
      rv.setHighestEducation(edu.getEducation());
    }    
    // 最近就职的公司
    if(StringUtil.isEmpty(resume.getCurrentCompany())) {
      if(resume.getWorkExperienceList() != null && resume.getWorkExperienceList().size() > 0) {
        rv.setCurrentCompany(resume.getWorkExperienceList().get(0).getCompanyName());
        if(StringUtil.isEmpty(resume.getCurrentPosition())) {
          rv.setCurrentPosition(resume.getWorkExperienceList().get(0).getPositionName());
        }
      }
    }
    
    rv.setHighestEducation(DatadictGroup.getTypeNameByTypeId(rv.getHighestEducation())); // 最高学历                      
    rv.setSex(DatadictGroup.getTypeNameByTypeId(rv.getSex())); // 性别
   
    if(null == resume.getAge() && null != resume.getBirthday()) {
      rv.setAge(DataUtils.getAge(resume.getBirthday()));
    }

    return rv;
  }

  @Override
  public Resume getZhResume(String id, HttpServletRequest request) {
    
    Basicinfor basicinfor = basicinforMapper.selectByPrimaryKey(id);
    Resume resume = new Resume();
    if(basicinfor != null){
       BeanUtils.copyProperties(basicinfor, resume);
       resume.setWorkExperience(basicinfor.getWorkExperience().intValue());
       //Resume resume = resumeMapper.selectByPrimaryKey(id);
       resume.setSex(DatadictGroup.getTypeNameByTypeId(resume.getSex())); // 性别
       resume.setMaritalStatus(DatadictGroup.getTypeNameByTypeId(resume.getMaritalStatus())); // 婚姻状况
       resume.setSalaryExpect(DatadictGroup.getTypeNameByTypeId(resume.getSalaryExpect())); // 目标薪水
       resume.setReportTime(DatadictGroup.getTypeNameByTypeId(resume.getReportTime())); // 到岗时间
       if(null == resume.getAge() && null != resume.getBirthday()) {
         resume.setAge(DataUtils.getAge(resume.getBirthday()));
       }
       List<WorkExperience> weList = workExperienceMapper.selectByResumeId(id);
       if(weList != null && weList.size() > 0){
         
         for(WorkExperience we : weList){
        // 设置每段 工作经历的时长和币种  
           if(null != we.getJobStartDate() && null != we.getJobEndDate()) {
             we.setWorkLength(workLength(we.getJobEndDate(),we.getJobStartDate()));
           }
           we.setCurrency(DatadictGroup.getTypeNameByTypeId(we.getCurrency()));
         
         }
         resume.setWorkExperienceList(weList);
       }
       
       List<EducationExperience> eeList = educationExperienceMapper.selectByResumeId(id);
       if(eeList != null && eeList.size() > 0){
         // 设置教育经历中的学历
         for(EducationExperience e : eeList) {
           e.setEducation(DatadictGroup.getTypeNameByTypeId(e.getEducation()));
         }
         
       }
       resume.setEduExperienceList(eeList);
    }
   /* if(StringUtil.isNotEmpty(resume.getResumeDir())) { // 设置附件文件
      //String fileDir = request.getSession().getServletContext().getRealPath(File.separator + "resources" + File.separator + "upload" + File.separator + resume.getResumeDir());
      PropertiesUtil propertiesUtil = new PropertiesUtil("constant.properties");
      String fileDir = propertiesUtil.readProperty("resumeDir") + File.separator + resume.getResumeDir();
      File dir = new File(fileDir);
      File[] files = dir.listFiles();
      String basePath;
      String fileName;
      String name;
      if(null != files) {
        List<com.csot.recruit.model.resume.File> attachments = new ArrayList<com.csot.recruit.model.resume.File>();
        for (int i = 0; i < files.length; i++) {
          if (files[i].exists()) {
            fileName = files[i].getName();
            name = fileName.substring(fileName.lastIndexOf(File.separator) + 1, fileName.lastIndexOf("."));
            if("resume".equals(name)) { // 如果是简历原文
              resume.setResumeSize(FileUtils.FormetFileSize(files[i].length()));
              basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
              basePath +=  "/resources/upload/" + resume.getResumeDir() + fileName;
              resume.setResumeDir(basePath); // 重置为简历原文的全路径 
            }
            else {
              attachments.add(new com.csot.recruit.model.resume.File(files[i].getName(), FileUtils.FormetFileSize(files[i].length())));
            }
          }
          else {
            resume.setResumeDir("");
            resume.setResumeSize("无");
          }
        }
        resume.setAttachments(attachments);
      }
    }*/
    return resume;
  }
  
  @Override
  public String outputStandardResume(String resumeId){
    String rootPath = springPropertyResourceReader.getProperty("recruit.file.root.path");
    String uuidName = UUID.randomUUID().toString().replace("-", "")+".doc";
    String filePath = rootPath + File.separator + CommonConstant.STANDARD_RESUME_DIR + File.separator + uuidName;
    
    //简历基本信息
    Resume resume = resumeMapper.selectByPrimaryKey(resumeId);
    
    //工作经历
    List<WorkExperience> works = workExperienceMapper.selectByResumeId(resumeId);
    
    
    Map<String,Object> dataMap=new HashMap<String,Object>();
    
    dataMap.put("resume", resume);
    dataMap.put("works", works);
    
    Template template = null;
    //获取模板
    try {
      freemarkerConfig.getConfiguration().setDateFormat("yyyy-MM-dd");
      template = freemarkerConfig.getConfiguration().getTemplate(CommonConstant.STANDARD_RESUME_FTL,new Locale("Zh_cn"), "UTF-8");
      Writer out = null;
      FileOutputStream fo = new FileOutputStream(filePath);
      out = new BufferedWriter(new OutputStreamWriter(fo)); 
      template.process(dataMap, out);
      // 关闭流
      out.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return filePath;
  }
  
  
}