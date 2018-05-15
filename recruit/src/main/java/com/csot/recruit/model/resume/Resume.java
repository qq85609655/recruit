package com.csot.recruit.model.resume;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.csot.recruit.model.log.Log;
import com.csot.recruit.model.position.RecruitPosition;


public class Resume implements Serializable {
  
    private String id;

    private String name;

    private String nameEn;

    private String sex;

    private Date birthday;
    private String birthdayStr;
    
    private Date storageDate;

    private String maritalStatus;

    private String addressRegistered;

    private Integer workExperience;

    private String voucherType;

    private String voucherNumber;

    private String phone;

    private String phoneReserve;

    private String applyStatus;

    private String email;

    private String residence;

    private String postcode;

    private String address;

    private String addressEn;

    private String selfAssessment;

    private String selfAssessmentEn;

    private Integer age;

    private String highestEducation;

    private String nation;

    private String idNumber;

    private String idAddress;

    private String reportTime;

    private String workplaceExpect;

    private String postExpect;

    private String industryExpect;

    private String jobtypeExpect;

    private String salaryExpect;

    private String currency;

    private String headPortrait;

    /** 培训信息    */
    private String trainInfor;
    
    /** 技能信息    */
    private String skillInfor;

    /** 语言信息    */
    private String languageInfor;

    /** 证书信息    */
    private String certificateInfor;

    /** 获奖信息    */
    private String awardInfor;

    /** 爱好信息    */
    private String hobbyInfor;

    private BigDecimal selectionStatus;

    private String label;

    private String currentIndustry;

    private Date updateDate;

    /** 申请的职位    */
    private RecruitPosition applyPosition;
    
    private String positionid;

    private String currentCompany;
    
    private String currentPosition;

    private String resumeorigin;

    private String channel;
    
    /** 简历存放目录    */
    private String resumeDir;
    
    /** 文件列表    */
    private List<File> attachments;
    
    /** 简历大小    */
    private String resumeSize;
    
    /** 教育经历    */
    private List<EducationExperience> eduExperienceList;
    
    /** 工作经历   */
    private List<WorkExperience> workExperienceList;
    
    /** 工作意向    */
    private List<WorkIntention> workIntentionList;
    
    /** 语言    */
    private List<LanguageSkill> languageList;
    
    /** 标签    */
    private List<Label> labelList;
    
    /** 操作记录和评论    */
    private List<Log> opRecords;
    
    /** 毕业学校   */
    private String graduationSchool;
    
    /** 专业   */
    private String professional;
    
    /** 当前月薪   */
    private String currentSalary;
    
    /** 简历语言   */
    private String resumeLanguage;
    
    /** 推荐人姓名   */
    private String recommend;
    
    /** 推荐人邮箱   */
    private String recommendEmail;
    
    /** 身份证号    */
    private String cardId;
    
    private Integer upperExperience ;
       
    /** 背景概要   */
    private String selfEvaluation;
        
    /** 求职意向   */
    private String careerObject;
        
    /** 详细工作经历   */
    private String  experienceDetail;
    
    /** 项目经验   */
    private String projectExperience;
    
    /** 语言描述   */
    private String languageSkill;
        
    /** 其他技能信息   */
    private String skillText;

    /** 简历状态    */
    private int resumeStatus;

    /** 是否提供住房    */
    private String provideHouse;
    
    /** 国籍   */
    private String nationality;
    
    private String candidateId ;
    
    private String certificateType ;
    
    public String getBirthdayStr() {
      return birthdayStr;
    }

    public void setBirthdayStr(String birthdayStr) {
      this.birthdayStr = birthdayStr;
    }
    
    public String getCertificateType() {
      return certificateType;
    }

    public void setCertificateType(String certificateType) {
      this.certificateType = certificateType;
    }

    public String getCandidateId() {
      return candidateId;
    }

    public void setCandidateId(String candidateId) {
      this.candidateId = candidateId;
    }

    public String getCleanStatus() {
      return cleanStatus;
    }

    public void setCleanStatus(String cleanStatus) {
      this.cleanStatus = cleanStatus;
    }

    private String cleanStatus ;
    
    
    private static final long serialVersionUID = 1L;

    public Integer getUpperExperience() {
        return upperExperience;
    }

    public void setUpperExperience(Integer upperExperience) {
        this.upperExperience = upperExperience;
    }
  
    public String getSelfEvaluation() {
        return selfEvaluation;
    }
  
    public void setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation;
    }
  
    public String getCareerObject() {
        return careerObject;
    }
  
    public void setCareerObject(String careerObject) {
        this.careerObject = careerObject;
    }
  
    public String getExperienceDetail() {
        return experienceDetail;
    }
  
    public void setExperienceDetail(String experienceDetail) {
        this.experienceDetail = experienceDetail;
    }
  
    public String getProjectExperience() {
        return projectExperience;
    }
  
    public void setProjectExperience(String projectExperience) {
        this.projectExperience = projectExperience;
    }
  
    public String getLanguageSkill() {
        return languageSkill;
    }
  
    public void setLanguageSkill(String languageSkill) {
        this.languageSkill = languageSkill;
    }
  
    public String getSkillText() {
        return skillText;
    }

    public void setSkillText(String skillText) {
        this.skillText = skillText;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the storageDate
     */
    public Date getStorageDate() {
      return storageDate;
    }

    /**
     * @param storageDate the storageDate to set
     */
    public void setStorageDate(Date storageDate) {
      this.storageDate = storageDate;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddressRegistered() {
        return addressRegistered;
    }

    public void setAddressRegistered(String addressRegistered) {
        this.addressRegistered = addressRegistered;
    }

    public Integer getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(Integer workExperience) {
        this.workExperience = workExperience;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhoneReserve() {
        return phoneReserve;
    }

    public void setPhoneReserve(String phoneReserve) {
        this.phoneReserve = phoneReserve;
    }

    public String getApplyStatus() {
        return applyStatus;
    }

    public void setApplyStatus(String applyStatus) {
        this.applyStatus = applyStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressEn() {
        return addressEn;
    }

    public void setAddressEn(String addressEn) {
        this.addressEn = addressEn;
    }

    public String getSelfAssessment() {
        return selfAssessment;
    }

    public void setSelfAssessment(String selfAssessment) {
        this.selfAssessment = selfAssessment;
    }

    public String getSelfAssessmentEn() {
        return selfAssessmentEn;
    }

    public void setSelfAssessmentEn(String selfAssessmentEn) {
        this.selfAssessmentEn = selfAssessmentEn;
    }

    public Integer getAge() {
      return age;
    }

    public void setAge(Integer age) {
      this.age = age;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(String idAddress) {
        this.idAddress = idAddress;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getWorkplaceExpect() {
        return workplaceExpect;
    }

    public void setWorkplaceExpect(String workplaceExpect) {
        this.workplaceExpect = workplaceExpect;
    }

    public String getPostExpect() {
        return postExpect;
    }

    public void setPostExpect(String postExpect) {
        this.postExpect = postExpect;
    }

    public String getIndustryExpect() {
        return industryExpect;
    }

    public void setIndustryExpect(String industryExpect) {
        this.industryExpect = industryExpect;
    }

    public String getJobtypeExpect() {
        return jobtypeExpect;
    }

    public void setJobtypeExpect(String jobtypeExpect) {
        this.jobtypeExpect = jobtypeExpect;
    }

    public String getSalaryExpect() {
        return salaryExpect;
    }

    public void setSalaryExpect(String salaryExpect) {
        this.salaryExpect = salaryExpect;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getTrainInfor() {
        return trainInfor;
    }

    public void setTrainInfor(String trainInfor) {
        this.trainInfor = trainInfor;
    }

    public String getSkillInfor() {
        return skillInfor;
    }

    public void setSkillInfor(String skillInfor) {
        this.skillInfor = skillInfor;
    }

    public String getLanguageInfor() {
        return languageInfor;
    }

    public void setLanguageInfor(String languageInfor) {
        this.languageInfor = languageInfor;
    }

    public String getCertificateInfor() {
        return certificateInfor;
    }

    public void setCertificateInfor(String certificateInfor) {
        this.certificateInfor = certificateInfor;
    }

    public String getAwardInfor() {
        return awardInfor;
    }

    public void setAwardInfor(String awardInfor) {
        this.awardInfor = awardInfor;
    }

    public String getHobbyInfor() {
        return hobbyInfor;
    }

    public void setHobbyInfor(String hobbyInfor) {
        this.hobbyInfor = hobbyInfor;
    }

    public BigDecimal getSelectionStatus() {
        return selectionStatus;
    }

    public void setSelectionStatus(BigDecimal selectionStatus) {
        this.selectionStatus = selectionStatus;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCurrentIndustry() {
        return currentIndustry;
    }

    public void setCurrentIndustry(String currentIndustry) {
        this.currentIndustry = currentIndustry;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public RecruitPosition getApplyPosition() {
      return applyPosition;
    }

    public void setApplyPosition(RecruitPosition applyPosition) {
      this.applyPosition = applyPosition;
    }

    public String getPositionid() {
        return positionid;
    }

    public void setPositionid(String positionid) {
        this.positionid = positionid;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public String getCurrentPosition() {
      return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
      this.currentPosition = currentPosition;
    }

    public String getResumeorigin() {
        return resumeorigin;
    }

    public void setResumeorigin(String resumeorigin) {
        this.resumeorigin = resumeorigin;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getResumeDir() {
      return resumeDir;
    }

    public void setResumeDir(String resumeDir) {
      this.resumeDir = resumeDir;
    }

    public List<File> getAttachments() {
      return attachments;
    }

    public void setAttachments(List<File> files) {
      this.attachments = files;
    }

    public String getResumeSize() {
      return resumeSize;
    }

    public void setResumeSize(String resumeSize) {
      this.resumeSize = resumeSize;
    }

    public List<EducationExperience> getEduExperienceList() {
      return eduExperienceList;
    }

    public void setEduExperienceList(List<EducationExperience> eduExperienceList) {
      this.eduExperienceList = eduExperienceList;
    }

    public List<WorkExperience> getWorkExperienceList() {
      return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
      this.workExperienceList = workExperienceList;
    }

    public List<WorkIntention> getWorkIntentionList() {
      return workIntentionList;
    }

    public void setWorkIntentionList(List<WorkIntention> workIntentionList) {
      this.workIntentionList = workIntentionList;
    }

    public List<LanguageSkill> getLanguageList() {
      return languageList;
    }

    public void setLanguageList(List<LanguageSkill> languageList) {
      this.languageList = languageList;
    }

    public List<Label> getLabelList() {
      return labelList;
    }

    public void setLabelList(List<Label> labelList) {
      this.labelList = labelList;
    }
    
    public List<Log> getOpRecords() {
      return opRecords;
    }

    public void setOpRecords(List<Log> opRecords) {
      this.opRecords = opRecords;
    }

    public String getGraduationSchool() {
        return graduationSchool;
    }

    public void setGraduationSchool(String graduationSchool) {
        this.graduationSchool = graduationSchool;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(String currentSalary) {
        this.currentSalary = currentSalary;
    }

    public String getResumeLanguage() {
        return resumeLanguage;
    }

    public void setResumeLanguage(String resumeLanguage) {
        this.resumeLanguage = resumeLanguage;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getRecommendEmail() {
        return recommendEmail;
    }

    public void setRecommendEmail(String recommendEmail) {
        this.recommendEmail = recommendEmail;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public int getResumeStatus() {
        return resumeStatus;
    }

    public void setResumeStatus(int resumeStatus) {
        this.resumeStatus = resumeStatus;
    }

    public String getProvideHouse() {
      return provideHouse;
    }
  
    public void setProvideHouse(String provideHouse) {
      this.provideHouse = provideHouse;
    }

  /**
     * @return the nationality
     */
    public String getNationality() {
      return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
      this.nationality = nationality;
    }

  @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Resume other = (Resume) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getMaritalStatus() == null ? other.getMaritalStatus() == null : this.getMaritalStatus().equals(other.getMaritalStatus()))
            && (this.getAddressRegistered() == null ? other.getAddressRegistered() == null : this.getAddressRegistered().equals(other.getAddressRegistered()))
            && (this.getWorkExperience() == null ? other.getWorkExperience() == null : this.getWorkExperience().equals(other.getWorkExperience()))
            && (this.getVoucherType() == null ? other.getVoucherType() == null : this.getVoucherType().equals(other.getVoucherType()))
            && (this.getVoucherNumber() == null ? other.getVoucherNumber() == null : this.getVoucherNumber().equals(other.getVoucherNumber()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getPhoneReserve() == null ? other.getPhoneReserve() == null : this.getPhoneReserve().equals(other.getPhoneReserve()))
            && (this.getApplyStatus() == null ? other.getApplyStatus() == null : this.getApplyStatus().equals(other.getApplyStatus()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getResidence() == null ? other.getResidence() == null : this.getResidence().equals(other.getResidence()))
            && (this.getPostcode() == null ? other.getPostcode() == null : this.getPostcode().equals(other.getPostcode()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getAddressEn() == null ? other.getAddressEn() == null : this.getAddressEn().equals(other.getAddressEn()))
            && (this.getSelfAssessment() == null ? other.getSelfAssessment() == null : this.getSelfAssessment().equals(other.getSelfAssessment()))
            && (this.getSelfAssessmentEn() == null ? other.getSelfAssessmentEn() == null : this.getSelfAssessmentEn().equals(other.getSelfAssessmentEn()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getHighestEducation() == null ? other.getHighestEducation() == null : this.getHighestEducation().equals(other.getHighestEducation()))
            && (this.getNation() == null ? other.getNation() == null : this.getNation().equals(other.getNation()))
            && (this.getIdNumber() == null ? other.getIdNumber() == null : this.getIdNumber().equals(other.getIdNumber()))
            && (this.getIdAddress() == null ? other.getIdAddress() == null : this.getIdAddress().equals(other.getIdAddress()))
            && (this.getReportTime() == null ? other.getReportTime() == null : this.getReportTime().equals(other.getReportTime()))
            && (this.getWorkplaceExpect() == null ? other.getWorkplaceExpect() == null : this.getWorkplaceExpect().equals(other.getWorkplaceExpect()))
            && (this.getPostExpect() == null ? other.getPostExpect() == null : this.getPostExpect().equals(other.getPostExpect()))
            && (this.getIndustryExpect() == null ? other.getIndustryExpect() == null : this.getIndustryExpect().equals(other.getIndustryExpect()))
            && (this.getJobtypeExpect() == null ? other.getJobtypeExpect() == null : this.getJobtypeExpect().equals(other.getJobtypeExpect()))
            && (this.getSalaryExpect() == null ? other.getSalaryExpect() == null : this.getSalaryExpect().equals(other.getSalaryExpect()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getHeadPortrait() == null ? other.getHeadPortrait() == null : this.getHeadPortrait().equals(other.getHeadPortrait()))
            && (this.getTrainInfor() == null ? other.getTrainInfor() == null : this.getTrainInfor().equals(other.getTrainInfor()))
            && (this.getSkillInfor() == null ? other.getSkillInfor() == null : this.getSkillInfor().equals(other.getSkillInfor()))
            && (this.getLanguageInfor() == null ? other.getLanguageInfor() == null : this.getLanguageInfor().equals(other.getLanguageInfor()))
            && (this.getCertificateInfor() == null ? other.getCertificateInfor() == null : this.getCertificateInfor().equals(other.getCertificateInfor()))
            && (this.getAwardInfor() == null ? other.getAwardInfor() == null : this.getAwardInfor().equals(other.getAwardInfor()))
            && (this.getHobbyInfor() == null ? other.getHobbyInfor() == null : this.getHobbyInfor().equals(other.getHobbyInfor()))
            && (this.getSelectionStatus() == null ? other.getSelectionStatus() == null : this.getSelectionStatus().equals(other.getSelectionStatus()))
            && (this.getLabel() == null ? other.getLabel() == null : this.getLabel().equals(other.getLabel()))
            && (this.getCurrentIndustry() == null ? other.getCurrentIndustry() == null : this.getCurrentIndustry().equals(other.getCurrentIndustry()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getPositionid() == null ? other.getPositionid() == null : this.getPositionid().equals(other.getPositionid()))
            && (this.getCurrentCompany() == null ? other.getCurrentCompany() == null : this.getCurrentCompany().equals(other.getCurrentCompany()))
            && (this.getResumeorigin() == null ? other.getResumeorigin() == null : this.getResumeorigin().equals(other.getResumeorigin()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getMaritalStatus() == null) ? 0 : getMaritalStatus().hashCode());
        result = prime * result + ((getAddressRegistered() == null) ? 0 : getAddressRegistered().hashCode());
        result = prime * result + ((getWorkExperience() == null) ? 0 : getWorkExperience().hashCode());
        result = prime * result + ((getVoucherType() == null) ? 0 : getVoucherType().hashCode());
        result = prime * result + ((getVoucherNumber() == null) ? 0 : getVoucherNumber().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getPhoneReserve() == null) ? 0 : getPhoneReserve().hashCode());
        result = prime * result + ((getApplyStatus() == null) ? 0 : getApplyStatus().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getResidence() == null) ? 0 : getResidence().hashCode());
        result = prime * result + ((getPostcode() == null) ? 0 : getPostcode().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getAddressEn() == null) ? 0 : getAddressEn().hashCode());
        result = prime * result + ((getSelfAssessment() == null) ? 0 : getSelfAssessment().hashCode());
        result = prime * result + ((getSelfAssessmentEn() == null) ? 0 : getSelfAssessmentEn().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getHighestEducation() == null) ? 0 : getHighestEducation().hashCode());
        result = prime * result + ((getNation() == null) ? 0 : getNation().hashCode());
        result = prime * result + ((getIdNumber() == null) ? 0 : getIdNumber().hashCode());
        result = prime * result + ((getIdAddress() == null) ? 0 : getIdAddress().hashCode());
        result = prime * result + ((getReportTime() == null) ? 0 : getReportTime().hashCode());
        result = prime * result + ((getWorkplaceExpect() == null) ? 0 : getWorkplaceExpect().hashCode());
        result = prime * result + ((getPostExpect() == null) ? 0 : getPostExpect().hashCode());
        result = prime * result + ((getIndustryExpect() == null) ? 0 : getIndustryExpect().hashCode());
        result = prime * result + ((getJobtypeExpect() == null) ? 0 : getJobtypeExpect().hashCode());
        result = prime * result + ((getSalaryExpect() == null) ? 0 : getSalaryExpect().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getHeadPortrait() == null) ? 0 : getHeadPortrait().hashCode());
        result = prime * result + ((getTrainInfor() == null) ? 0 : getTrainInfor().hashCode());
        result = prime * result + ((getSkillInfor() == null) ? 0 : getSkillInfor().hashCode());
        result = prime * result + ((getLanguageInfor() == null) ? 0 : getLanguageInfor().hashCode());
        result = prime * result + ((getCertificateInfor() == null) ? 0 : getCertificateInfor().hashCode());
        result = prime * result + ((getAwardInfor() == null) ? 0 : getAwardInfor().hashCode());
        result = prime * result + ((getHobbyInfor() == null) ? 0 : getHobbyInfor().hashCode());
        result = prime * result + ((getSelectionStatus() == null) ? 0 : getSelectionStatus().hashCode());
        result = prime * result + ((getLabel() == null) ? 0 : getLabel().hashCode());
        result = prime * result + ((getCurrentIndustry() == null) ? 0 : getCurrentIndustry().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getPositionid() == null) ? 0 : getPositionid().hashCode());
        result = prime * result + ((getCurrentCompany() == null) ? 0 : getCurrentCompany().hashCode());
        result = prime * result + ((getResumeorigin() == null) ? 0 : getResumeorigin().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        return result;
    }
}