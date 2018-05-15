package com.csot.recruit.model.original.candidate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Candidate implements Serializable {
    private String id;
    
    private String candidateId;
    
    private String resumeId;

    private String name;

    private String nameEn;

    private String sex;

    private BigDecimal age;

    private String positionid;

    private String currentCompany;

    private String currentPosition;

    private BigDecimal workExperience;

    private String highestEducation;

    private String graduationSchool;
    
    private String major;

    private String professional;

    private String phone;

    private String email;

    private String resumeorigin;

    private String channel;

    private Date storageDate;

    private BigDecimal resumeStatus;

    private BigDecimal postStatus;

    private Date changeTime;
    
    /**候选人状态*/
    private String candidateStatus;
    
    /**操作人id*/
    private String operatorUser;
    
    /**操作时间*/
    private Date operatorTime;
    
    /**锁定人ID*/
    private String lockUser;
    
    /**锁定人姓名*/
    private String lockUserName;
    
    /**锁定人账号*/
    private String lockUserAccount;
    
    /**锁定时间*/
    private Date lockTime;
    
    private String feedbackStatus ;
    
    private String jobNames ;
    
    private String resumeDir ;
    
    private String interviewerName ;
    
    private String recommandStatus ;
    
    private String interviewStatus ;

    public String getInterviewStatus() {
      return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
      this.interviewStatus = interviewStatus;
    }

    public String getJobNames() {
      return jobNames;
    }

    public String getResumeDir() {
      return resumeDir;
    }

    public void setResumeDir(String resumeDir) {
      this.resumeDir = resumeDir;
    }

    public void setJobNames(String jobNames) {
      this.jobNames = jobNames;
    }

    public String getFeedbackStatus() {
      return feedbackStatus;
    }

    public void setFeedbackStatus(String feedbackStatus) {
      this.feedbackStatus = feedbackStatus;
    }

    public String getLockUserName() {
      return lockUserName;
    }

    public void setLockUserName(String lockUserName) {
      this.lockUserName = lockUserName;
    }

    public String getLockUserAccount() {
      return lockUserAccount;
    }

    public void setLockUserAccount(String lockUserAccount) {
      this.lockUserAccount = lockUserAccount;
    }

    public Date getOperatorTime() {
      return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
      this.operatorTime = operatorTime;
    }

    public String getLockUser() {
      return lockUser;
    }

    public void setLockUser(String lockUser) {
      this.lockUser = lockUser;
    }

    public Date getLockTime() {
      return lockTime;
    }

    public void setLockTime(Date lockTime) {
      this.lockTime = lockTime;
    }

    public String getCandidateStatus() {
      return candidateStatus;
    }

    public void setCandidateStatus(String candidateStatus) {
      this.candidateStatus = candidateStatus;
    }

    public String getOperatorUser() {
      return operatorUser;
    }

    public void setOperatorUser(String operatorUser) {
      this.operatorUser = operatorUser;
    }

    public String getMajor() {
      return major;
    }

    public void setMajor(String major) {
      this.major = major;
    }

    public String getResumeId() {
      return resumeId;
    }

    public void setResumeId(String resumeId) {
      this.resumeId = resumeId;
    }

    public String getCandidateId() {
      return candidateId;
    }

    public void setCandidateId(String candidateId) {
      this.candidateId = candidateId;
    }

    private static final long serialVersionUID = 1L;

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

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
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

    public BigDecimal getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(BigDecimal workExperience) {
        this.workExperience = workExperience;
    }

    public String getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) {
        this.highestEducation = highestEducation;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getStorageDate() {
        return storageDate;
    }

    public void setStorageDate(Date storageDate) {
        this.storageDate = storageDate;
    }

    public BigDecimal getResumeStatus() {
        return resumeStatus;
    }

    public void setResumeStatus(BigDecimal resumeStatus) {
        this.resumeStatus = resumeStatus;
    }

    public BigDecimal getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(BigDecimal postStatus) {
        this.postStatus = postStatus;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }
    
    public String getInterviewerName() {
      return interviewerName;
    }

    public void setInterviewerName(String interviewerName) {
      this.interviewerName = interviewerName;
    }

    public String getRecommandStatus() {
      return recommandStatus;
    }

    public void setRecommandStatus(String recommandStatus) {
      this.recommandStatus = recommandStatus;
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
        Candidate other = (Candidate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getPositionid() == null ? other.getPositionid() == null : this.getPositionid().equals(other.getPositionid()))
            && (this.getCurrentCompany() == null ? other.getCurrentCompany() == null : this.getCurrentCompany().equals(other.getCurrentCompany()))
            && (this.getCurrentPosition() == null ? other.getCurrentPosition() == null : this.getCurrentPosition().equals(other.getCurrentPosition()))
            && (this.getWorkExperience() == null ? other.getWorkExperience() == null : this.getWorkExperience().equals(other.getWorkExperience()))
            && (this.getHighestEducation() == null ? other.getHighestEducation() == null : this.getHighestEducation().equals(other.getHighestEducation()))
            && (this.getGraduationSchool() == null ? other.getGraduationSchool() == null : this.getGraduationSchool().equals(other.getGraduationSchool()))
            && (this.getProfessional() == null ? other.getProfessional() == null : this.getProfessional().equals(other.getProfessional()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getResumeorigin() == null ? other.getResumeorigin() == null : this.getResumeorigin().equals(other.getResumeorigin()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getStorageDate() == null ? other.getStorageDate() == null : this.getStorageDate().equals(other.getStorageDate()))
            && (this.getResumeStatus() == null ? other.getResumeStatus() == null : this.getResumeStatus().equals(other.getResumeStatus()))
            && (this.getPostStatus() == null ? other.getPostStatus() == null : this.getPostStatus().equals(other.getPostStatus()))
            && (this.getChangeTime() == null ? other.getChangeTime() == null : this.getChangeTime().equals(other.getChangeTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getPositionid() == null) ? 0 : getPositionid().hashCode());
        result = prime * result + ((getCurrentCompany() == null) ? 0 : getCurrentCompany().hashCode());
        result = prime * result + ((getCurrentPosition() == null) ? 0 : getCurrentPosition().hashCode());
        result = prime * result + ((getWorkExperience() == null) ? 0 : getWorkExperience().hashCode());
        result = prime * result + ((getHighestEducation() == null) ? 0 : getHighestEducation().hashCode());
        result = prime * result + ((getGraduationSchool() == null) ? 0 : getGraduationSchool().hashCode());
        result = prime * result + ((getProfessional() == null) ? 0 : getProfessional().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getResumeorigin() == null) ? 0 : getResumeorigin().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getStorageDate() == null) ? 0 : getStorageDate().hashCode());
        result = prime * result + ((getResumeStatus() == null) ? 0 : getResumeStatus().hashCode());
        result = prime * result + ((getPostStatus() == null) ? 0 : getPostStatus().hashCode());
        result = prime * result + ((getChangeTime() == null) ? 0 : getChangeTime().hashCode());
        return result;
    }
}