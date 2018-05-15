package com.csot.recruit.model.original.flow.employ;

import java.io.Serializable;
import java.util.Date;

public class EmployCandidate implements Serializable {
    private String id;

    private String name;

    private String pinyin;

    private String englishName;

    private String emailName; 

    private String isDevote;

    private String gender;

    private String birthday;

    private String phone;

    private String email;

    private String candidatePostId;

    private String candidatePostName;

    private String candidateOrgId;

    private String candidateOrgName;

    private String recruitSource;

    private String referrerId;

    private String referrerName;

    private String referrerOrgId;

    private String referrerOrgName;

    private String candidateType;

    private String isBeidiao;

    private String isEvaluating;

    private String creatorId;

    private Date createDate;

    private String modifiedId;

    private Date updateDate;

    private String employId;
    
    private String employRankId;
    
    private String grade;
    
    private String abroad;
    
    public String getAbroad() {
      return abroad;
    }

    public void setAbroad(String abroad) {
      this.abroad = abroad;
    }

    public String getEmployRankId() {
      return employRankId;
    }

    public void setEmployRankId(String employRankId) {
      this.employRankId = employRankId;
    }


    public String getGrade() {
      return grade;
    }

    public void setGrade(String grade) {
      this.grade = grade;
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

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getEmailName() {
        return emailName;
    }

    public void setEmailName(String emailName) {
        this.emailName = emailName;
    }

    public String getIsDevote() {
        return isDevote;
    }

    public void setIsDevote(String isDevote) {
        this.isDevote = isDevote;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
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

    public String getCandidatePostId() {
        return candidatePostId;
    }

    public void setCandidatePostId(String candidatePostId) {
        this.candidatePostId = candidatePostId;
    }

    public String getCandidatePostName() {
        return candidatePostName;
    }

    public void setCandidatePostName(String candidatePostName) {
        this.candidatePostName = candidatePostName;
    }

    public String getCandidateOrgId() {
        return candidateOrgId;
    }

    public void setCandidateOrgId(String candidateOrgId) {
        this.candidateOrgId = candidateOrgId;
    }

    public String getCandidateOrgName() {
        return candidateOrgName;
    }

    public void setCandidateOrgName(String candidateOrgName) {
        this.candidateOrgName = candidateOrgName;
    }

    public String getRecruitSource() {
        return recruitSource;
    }

    public void setRecruitSource(String recruitSource) {
        this.recruitSource = recruitSource;
    }

    public String getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(String referrerId) {
        this.referrerId = referrerId;
    }

    public String getReferrerName() {
        return referrerName;
    }

    public void setReferrerName(String referrerName) {
        this.referrerName = referrerName;
    }

    public String getReferrerOrgId() {
        return referrerOrgId;
    }

    public void setReferrerOrgId(String referrerOrgId) {
        this.referrerOrgId = referrerOrgId;
    }

    public String getReferrerOrgName() {
        return referrerOrgName;
    }

    public void setReferrerOrgName(String referrerOrgName) {
        this.referrerOrgName = referrerOrgName;
    }

    public String getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }

    public String getIsBeidiao() {
        return isBeidiao;
    }

    public void setIsBeidiao(String isBeidiao) {
        this.isBeidiao = isBeidiao;
    }

    public String getIsEvaluating() {
        return isEvaluating;
    }

    public void setIsEvaluating(String isEvaluating) {
        this.isEvaluating = isEvaluating;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getModifiedId() {
        return modifiedId;
    }

    public void setModifiedId(String modifiedId) {
        this.modifiedId = modifiedId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
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
        EmployCandidate other = (EmployCandidate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPinyin() == null ? other.getPinyin() == null : this.getPinyin().equals(other.getPinyin()))
            && (this.getEnglishName() == null ? other.getEnglishName() == null : this.getEnglishName().equals(other.getEnglishName()))
            && (this.getEmailName() == null ? other.getEmailName() == null : this.getEmailName().equals(other.getEmailName()))
            && (this.getIsDevote() == null ? other.getIsDevote() == null : this.getIsDevote().equals(other.getIsDevote()))
            && (this.getGender() == null ? other.getGender() == null : this.getGender().equals(other.getGender()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getCandidatePostId() == null ? other.getCandidatePostId() == null : this.getCandidatePostId().equals(other.getCandidatePostId()))
            && (this.getCandidatePostName() == null ? other.getCandidatePostName() == null : this.getCandidatePostName().equals(other.getCandidatePostName()))
            && (this.getCandidateOrgId() == null ? other.getCandidateOrgId() == null : this.getCandidateOrgId().equals(other.getCandidateOrgId()))
            && (this.getCandidateOrgName() == null ? other.getCandidateOrgName() == null : this.getCandidateOrgName().equals(other.getCandidateOrgName()))
            && (this.getRecruitSource() == null ? other.getRecruitSource() == null : this.getRecruitSource().equals(other.getRecruitSource()))
            && (this.getReferrerId() == null ? other.getReferrerId() == null : this.getReferrerId().equals(other.getReferrerId()))
            && (this.getReferrerName() == null ? other.getReferrerName() == null : this.getReferrerName().equals(other.getReferrerName()))
            && (this.getReferrerOrgId() == null ? other.getReferrerOrgId() == null : this.getReferrerOrgId().equals(other.getReferrerOrgId()))
            && (this.getReferrerOrgName() == null ? other.getReferrerOrgName() == null : this.getReferrerOrgName().equals(other.getReferrerOrgName()))
            && (this.getCandidateType() == null ? other.getCandidateType() == null : this.getCandidateType().equals(other.getCandidateType()))
            && (this.getIsBeidiao() == null ? other.getIsBeidiao() == null : this.getIsBeidiao().equals(other.getIsBeidiao()))
            && (this.getIsEvaluating() == null ? other.getIsEvaluating() == null : this.getIsEvaluating().equals(other.getIsEvaluating()))
            && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getModifiedId() == null ? other.getModifiedId() == null : this.getModifiedId().equals(other.getModifiedId()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getEmployId() == null ? other.getEmployId() == null : this.getEmployId().equals(other.getEmployId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPinyin() == null) ? 0 : getPinyin().hashCode());
        result = prime * result + ((getEnglishName() == null) ? 0 : getEnglishName().hashCode());
        result = prime * result + ((getEmailName() == null) ? 0 : getEmailName().hashCode());
        result = prime * result + ((getIsDevote() == null) ? 0 : getIsDevote().hashCode());
        result = prime * result + ((getGender() == null) ? 0 : getGender().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getCandidatePostId() == null) ? 0 : getCandidatePostId().hashCode());
        result = prime * result + ((getCandidatePostName() == null) ? 0 : getCandidatePostName().hashCode());
        result = prime * result + ((getCandidateOrgId() == null) ? 0 : getCandidateOrgId().hashCode());
        result = prime * result + ((getCandidateOrgName() == null) ? 0 : getCandidateOrgName().hashCode());
        result = prime * result + ((getRecruitSource() == null) ? 0 : getRecruitSource().hashCode());
        result = prime * result + ((getReferrerId() == null) ? 0 : getReferrerId().hashCode());
        result = prime * result + ((getReferrerName() == null) ? 0 : getReferrerName().hashCode());
        result = prime * result + ((getReferrerOrgId() == null) ? 0 : getReferrerOrgId().hashCode());
        result = prime * result + ((getReferrerOrgName() == null) ? 0 : getReferrerOrgName().hashCode());
        result = prime * result + ((getCandidateType() == null) ? 0 : getCandidateType().hashCode());
        result = prime * result + ((getIsBeidiao() == null) ? 0 : getIsBeidiao().hashCode());
        result = prime * result + ((getIsEvaluating() == null) ? 0 : getIsEvaluating().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getModifiedId() == null) ? 0 : getModifiedId().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getEmployId() == null) ? 0 : getEmployId().hashCode());
        return result;
    }
}