package com.csot.recruit.model.resume;

import java.io.Serializable;
import java.util.Date;

public class EducationExperience implements Serializable {
    private String id;

    private Date eduStartDate;

    private Date eduEndDate;

    private String schoolName;

    private String schoolNameEn;

    private String education;
    
    private String educationName;

    private String major;

    private String majorEn;

    private String resumeId;

    private String eduType;
    
    private String eduTypeName;

    private String certificate;
    
    private String certNationality;

    private String fkTid;
    
    private String startDate;
    
    private String endDate;

    public String getStartDate() {
      return startDate;
    }

    public void setStartDate(String startDate) {
      this.startDate = startDate;
    }

    public String getEndDate() {
      return endDate;
    }

    public void setEndDate(String endDate) {
      this.endDate = endDate;
    }

    private static final long serialVersionUID = 1L;

    public String getCertNationality() {
      return certNationality;
    }

    public void setCertNationality(String certNationality) {
      this.certNationality = certNationality;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getEduStartDate() {
        return eduStartDate;
    }

    public void setEduStartDate(Date eduStartDate) {
        this.eduStartDate = eduStartDate;
    }

    public Date getEduEndDate() {
        return eduEndDate;
    }

    public void setEduEndDate(Date eduEndDate) {
        this.eduEndDate = eduEndDate;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolNameEn() {
        return schoolNameEn;
    }

    public void setSchoolNameEn(String schoolNameEn) {
        this.schoolNameEn = schoolNameEn;
    }

    public String getEducation() {
        return education;
    }

    public String getEducationName() {
      return educationName;
    }

    public void setEducationName(String educationName) {
      this.educationName = educationName;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajorEn() {
        return majorEn;
    }

    public void setMajorEn(String majorEn) {
        this.majorEn = majorEn;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getEduType() {
        return eduType;
    }

    public void setEduType(String eduType) {
        this.eduType = eduType;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getFkTid() {
        return fkTid;
    }

    public void setFkTid(String fkTid) {
        this.fkTid = fkTid;
    }

    public String getEduTypeName() {
      return eduTypeName;
    }

    public void setEduTypeName(String eduTypeName) {
      this.eduTypeName = eduTypeName;
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
        EducationExperience other = (EducationExperience) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEduStartDate() == null ? other.getEduStartDate() == null : this.getEduStartDate().equals(other.getEduStartDate()))
            && (this.getEduEndDate() == null ? other.getEduEndDate() == null : this.getEduEndDate().equals(other.getEduEndDate()))
            && (this.getSchoolName() == null ? other.getSchoolName() == null : this.getSchoolName().equals(other.getSchoolName()))
            && (this.getSchoolNameEn() == null ? other.getSchoolNameEn() == null : this.getSchoolNameEn().equals(other.getSchoolNameEn()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()))
            && (this.getMajor() == null ? other.getMajor() == null : this.getMajor().equals(other.getMajor()))
            && (this.getMajorEn() == null ? other.getMajorEn() == null : this.getMajorEn().equals(other.getMajorEn()))
            && (this.getResumeId() == null ? other.getResumeId() == null : this.getResumeId().equals(other.getResumeId()))
            && (this.getEduType() == null ? other.getEduType() == null : this.getEduType().equals(other.getEduType()))
            && (this.getCertificate() == null ? other.getCertificate() == null : this.getCertificate().equals(other.getCertificate()))
            && (this.getFkTid() == null ? other.getFkTid() == null : this.getFkTid().equals(other.getFkTid()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEduStartDate() == null) ? 0 : getEduStartDate().hashCode());
        result = prime * result + ((getEduEndDate() == null) ? 0 : getEduEndDate().hashCode());
        result = prime * result + ((getSchoolName() == null) ? 0 : getSchoolName().hashCode());
        result = prime * result + ((getSchoolNameEn() == null) ? 0 : getSchoolNameEn().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        result = prime * result + ((getMajor() == null) ? 0 : getMajor().hashCode());
        result = prime * result + ((getMajorEn() == null) ? 0 : getMajorEn().hashCode());
        result = prime * result + ((getResumeId() == null) ? 0 : getResumeId().hashCode());
        result = prime * result + ((getEduType() == null) ? 0 : getEduType().hashCode());
        result = prime * result + ((getCertificate() == null) ? 0 : getCertificate().hashCode());
        result = prime * result + ((getFkTid() == null) ? 0 : getFkTid().hashCode());
        return result;
    }
}