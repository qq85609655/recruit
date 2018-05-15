package com.csot.recruit.model.extension.campus;

import java.io.Serializable;

public class CampusPostExt implements Serializable {
    private String id;
    
    private String postId;

    private String postName;

    private String remark;

    private String reserved1;

    private String reserved2;

    private String reserved3;

    private String status;

    private String organization;

    private String bigCenter;

    private String smallCenter;

    private String jobFamily;

    private String jobClass;

    private String jobSubclass;

    private String recruitQuantity;

    private String educationAdvise;

    private String schoolAdvise;

    private String sexAdvise;

    private String preferredMajor;

    private String alternativeMajor;

    private String otherDemand;

    private String postDescribe;

    private String specialCondition;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPostId() {
      return postId;
    }

    public void setPostId(String postId) {
      this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getReserved1() {
        return reserved1;
    }

    public void setReserved1(String reserved1) {
        this.reserved1 = reserved1;
    }

    public String getReserved2() {
        return reserved2;
    }

    public void setReserved2(String reserved2) {
        this.reserved2 = reserved2;
    }

    public String getReserved3() {
        return reserved3;
    }

    public void setReserved3(String reserved3) {
        this.reserved3 = reserved3;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getBigCenter() {
        return bigCenter;
    }

    public void setBigCenter(String bigCenter) {
        this.bigCenter = bigCenter;
    }

    public String getSmallCenter() {
        return smallCenter;
    }

    public void setSmallCenter(String smallCenter) {
        this.smallCenter = smallCenter;
    }

    public String getJobFamily() {
        return jobFamily;
    }

    public void setJobFamily(String jobFamily) {
        this.jobFamily = jobFamily;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getJobSubclass() {
        return jobSubclass;
    }

    public void setJobSubclass(String jobSubclass) {
        this.jobSubclass = jobSubclass;
    }

    public String getRecruitQuantity() {
        return recruitQuantity;
    }

    public void setRecruitQuantity(String recruitQuantity) {
        this.recruitQuantity = recruitQuantity;
    }

    public String getEducationAdvise() {
        return educationAdvise;
    }

    public void setEducationAdvise(String educationAdvise) {
        this.educationAdvise = educationAdvise;
    }

    public String getSchoolAdvise() {
        return schoolAdvise;
    }

    public void setSchoolAdvise(String schoolAdvise) {
        this.schoolAdvise = schoolAdvise;
    }

    public String getSexAdvise() {
        return sexAdvise;
    }

    public void setSexAdvise(String sexAdvise) {
        this.sexAdvise = sexAdvise;
    }

    public String getPreferredMajor() {
        return preferredMajor;
    }

    public void setPreferredMajor(String preferredMajor) {
        this.preferredMajor = preferredMajor;
    }

    public String getAlternativeMajor() {
        return alternativeMajor;
    }

    public void setAlternativeMajor(String alternativeMajor) {
        this.alternativeMajor = alternativeMajor;
    }

    public String getOtherDemand() {
        return otherDemand;
    }

    public void setOtherDemand(String otherDemand) {
        this.otherDemand = otherDemand;
    }

    public String getPostDescribe() {
        return postDescribe;
    }

    public void setPostDescribe(String postDescribe) {
        this.postDescribe = postDescribe;
    }

    public String getSpecialCondition() {
        return specialCondition;
    }

    public void setSpecialCondition(String specialCondition) {
        this.specialCondition = specialCondition;
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
        CampusPostExt other = (CampusPostExt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getPostName() == null ? other.getPostName() == null : this.getPostName().equals(other.getPostName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getReserved1() == null ? other.getReserved1() == null : this.getReserved1().equals(other.getReserved1()))
            && (this.getReserved2() == null ? other.getReserved2() == null : this.getReserved2().equals(other.getReserved2()))
            && (this.getReserved3() == null ? other.getReserved3() == null : this.getReserved3().equals(other.getReserved3()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOrganization() == null ? other.getOrganization() == null : this.getOrganization().equals(other.getOrganization()))
            && (this.getBigCenter() == null ? other.getBigCenter() == null : this.getBigCenter().equals(other.getBigCenter()))
            && (this.getSmallCenter() == null ? other.getSmallCenter() == null : this.getSmallCenter().equals(other.getSmallCenter()))
            && (this.getJobFamily() == null ? other.getJobFamily() == null : this.getJobFamily().equals(other.getJobFamily()))
            && (this.getJobClass() == null ? other.getJobClass() == null : this.getJobClass().equals(other.getJobClass()))
            && (this.getJobSubclass() == null ? other.getJobSubclass() == null : this.getJobSubclass().equals(other.getJobSubclass()))
            && (this.getRecruitQuantity() == null ? other.getRecruitQuantity() == null : this.getRecruitQuantity().equals(other.getRecruitQuantity()))
            && (this.getEducationAdvise() == null ? other.getEducationAdvise() == null : this.getEducationAdvise().equals(other.getEducationAdvise()))
            && (this.getSchoolAdvise() == null ? other.getSchoolAdvise() == null : this.getSchoolAdvise().equals(other.getSchoolAdvise()))
            && (this.getSexAdvise() == null ? other.getSexAdvise() == null : this.getSexAdvise().equals(other.getSexAdvise()))
            && (this.getPreferredMajor() == null ? other.getPreferredMajor() == null : this.getPreferredMajor().equals(other.getPreferredMajor()))
            && (this.getAlternativeMajor() == null ? other.getAlternativeMajor() == null : this.getAlternativeMajor().equals(other.getAlternativeMajor()))
            && (this.getOtherDemand() == null ? other.getOtherDemand() == null : this.getOtherDemand().equals(other.getOtherDemand()))
            && (this.getPostDescribe() == null ? other.getPostDescribe() == null : this.getPostDescribe().equals(other.getPostDescribe()))
            && (this.getSpecialCondition() == null ? other.getSpecialCondition() == null : this.getSpecialCondition().equals(other.getSpecialCondition()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getPostName() == null) ? 0 : getPostName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getReserved1() == null) ? 0 : getReserved1().hashCode());
        result = prime * result + ((getReserved2() == null) ? 0 : getReserved2().hashCode());
        result = prime * result + ((getReserved3() == null) ? 0 : getReserved3().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOrganization() == null) ? 0 : getOrganization().hashCode());
        result = prime * result + ((getBigCenter() == null) ? 0 : getBigCenter().hashCode());
        result = prime * result + ((getSmallCenter() == null) ? 0 : getSmallCenter().hashCode());
        result = prime * result + ((getJobFamily() == null) ? 0 : getJobFamily().hashCode());
        result = prime * result + ((getJobClass() == null) ? 0 : getJobClass().hashCode());
        result = prime * result + ((getJobSubclass() == null) ? 0 : getJobSubclass().hashCode());
        result = prime * result + ((getRecruitQuantity() == null) ? 0 : getRecruitQuantity().hashCode());
        result = prime * result + ((getEducationAdvise() == null) ? 0 : getEducationAdvise().hashCode());
        result = prime * result + ((getSchoolAdvise() == null) ? 0 : getSchoolAdvise().hashCode());
        result = prime * result + ((getSexAdvise() == null) ? 0 : getSexAdvise().hashCode());
        result = prime * result + ((getPreferredMajor() == null) ? 0 : getPreferredMajor().hashCode());
        result = prime * result + ((getAlternativeMajor() == null) ? 0 : getAlternativeMajor().hashCode());
        result = prime * result + ((getOtherDemand() == null) ? 0 : getOtherDemand().hashCode());
        result = prime * result + ((getPostDescribe() == null) ? 0 : getPostDescribe().hashCode());
        result = prime * result + ((getSpecialCondition() == null) ? 0 : getSpecialCondition().hashCode());
        return result;
    }
}