package com.csot.recruit.model.resume;

import java.io.Serializable;

public class WorkIntention implements Serializable {
    private String id;
    
    /** 意向工作地点    */
    private String workplaceExpect;

    /** 意向行业    */
    private String industryExpect;
    
    /** 意向工作类型    */
    private String jobtypeExpect;

    /** 意向岗位     */
    private String postExpect;

    /** 意向薪水    */
    private String salaryExpect;

    /** 到岗时间    */
    private String rpeortTime;
    
    /** 货币类型    */
    private String currency;

    private String resumeId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorkplaceExpect() {
        return workplaceExpect;
    }

    public void setWorkplaceExpect(String workplaceExpect) {
        this.workplaceExpect = workplaceExpect;
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

    public String getPostExpect() {
        return postExpect;
    }

    public void setPostExpect(String postExpect) {
        this.postExpect = postExpect;
    }

    public String getSalaryExpect() {
        return salaryExpect;
    }

    public void setSalaryExpect(String salaryExpect) {
        this.salaryExpect = salaryExpect;
    }

    public String getRpeortTime() {
        return rpeortTime;
    }

    public void setRpeortTime(String rpeortTime) {
        this.rpeortTime = rpeortTime;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
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
        WorkIntention other = (WorkIntention) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getWorkplaceExpect() == null ? other.getWorkplaceExpect() == null : this.getWorkplaceExpect().equals(other.getWorkplaceExpect()))
            && (this.getIndustryExpect() == null ? other.getIndustryExpect() == null : this.getIndustryExpect().equals(other.getIndustryExpect()))
            && (this.getJobtypeExpect() == null ? other.getJobtypeExpect() == null : this.getJobtypeExpect().equals(other.getJobtypeExpect()))
            && (this.getPostExpect() == null ? other.getPostExpect() == null : this.getPostExpect().equals(other.getPostExpect()))
            && (this.getSalaryExpect() == null ? other.getSalaryExpect() == null : this.getSalaryExpect().equals(other.getSalaryExpect()))
            && (this.getRpeortTime() == null ? other.getRpeortTime() == null : this.getRpeortTime().equals(other.getRpeortTime()))
            && (this.getCurrency() == null ? other.getCurrency() == null : this.getCurrency().equals(other.getCurrency()))
            && (this.getResumeId() == null ? other.getResumeId() == null : this.getResumeId().equals(other.getResumeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWorkplaceExpect() == null) ? 0 : getWorkplaceExpect().hashCode());
        result = prime * result + ((getIndustryExpect() == null) ? 0 : getIndustryExpect().hashCode());
        result = prime * result + ((getJobtypeExpect() == null) ? 0 : getJobtypeExpect().hashCode());
        result = prime * result + ((getPostExpect() == null) ? 0 : getPostExpect().hashCode());
        result = prime * result + ((getSalaryExpect() == null) ? 0 : getSalaryExpect().hashCode());
        result = prime * result + ((getRpeortTime() == null) ? 0 : getRpeortTime().hashCode());
        result = prime * result + ((getCurrency() == null) ? 0 : getCurrency().hashCode());
        result = prime * result + ((getResumeId() == null) ? 0 : getResumeId().hashCode());
        return result;
    }
}