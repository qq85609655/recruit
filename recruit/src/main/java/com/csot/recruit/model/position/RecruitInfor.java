package com.csot.recruit.model.position;

import java.io.Serializable;

public class RecruitInfor implements Serializable {
    private Integer id;

    private String recruiter;

    private String recruiterOther;

    private String departmentManager;

    private String receiveEmail;

    private String interviewEvaluateTemplate;

    private String recruitPositionId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecruiter() {
        return recruiter;
    }

    public void setRecruiter(String recruiter) {
        this.recruiter = recruiter == null ? null : recruiter.trim();
    }

    public String getRecruiterOther() {
        return recruiterOther;
    }

    public void setRecruiterOther(String recruiterOther) {
        this.recruiterOther = recruiterOther == null ? null : recruiterOther.trim();
    }

    public String getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(String departmentManager) {
        this.departmentManager = departmentManager == null ? null : departmentManager.trim();
    }

    public String getReceiveEmail() {
        return receiveEmail;
    }

    public void setReceiveEmail(String receiveEmail) {
        this.receiveEmail = receiveEmail == null ? null : receiveEmail.trim();
    }

    public String getInterviewEvaluateTemplate() {
      return interviewEvaluateTemplate;
    }

    public void setInterviewEvaluateTemplate(String interviewEvaluateTemplate) {
      this.interviewEvaluateTemplate = interviewEvaluateTemplate;
    }

    public String getRecruitPositionId() {
        return recruitPositionId;
    }

    public void setRecruitPositionId(String recruitPositionId) {
        this.recruitPositionId = recruitPositionId == null ? null : recruitPositionId.trim();
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
        RecruitInfor other = (RecruitInfor) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRecruiter() == null ? other.getRecruiter() == null : this.getRecruiter().equals(other.getRecruiter()))
            && (this.getRecruiterOther() == null ? other.getRecruiterOther() == null : this.getRecruiterOther().equals(other.getRecruiterOther()))
            && (this.getDepartmentManager() == null ? other.getDepartmentManager() == null : this.getDepartmentManager().equals(other.getDepartmentManager()))
            && (this.getReceiveEmail() == null ? other.getReceiveEmail() == null : this.getReceiveEmail().equals(other.getReceiveEmail()))
            && (this.getInterviewEvaluateTemplate() == null ? other.getInterviewEvaluateTemplate() == null : this.getInterviewEvaluateTemplate().equals(other.getInterviewEvaluateTemplate()))
            && (this.getRecruitPositionId() == null ? other.getRecruitPositionId() == null : this.getRecruitPositionId().equals(other.getRecruitPositionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRecruiter() == null) ? 0 : getRecruiter().hashCode());
        result = prime * result + ((getRecruiterOther() == null) ? 0 : getRecruiterOther().hashCode());
        result = prime * result + ((getDepartmentManager() == null) ? 0 : getDepartmentManager().hashCode());
        result = prime * result + ((getReceiveEmail() == null) ? 0 : getReceiveEmail().hashCode());
        result = prime * result + ((getInterviewEvaluateTemplate() == null) ? 0 : getInterviewEvaluateTemplate().hashCode());
        result = prime * result + ((getRecruitPositionId() == null) ? 0 : getRecruitPositionId().hashCode());
        return result;
    }
}