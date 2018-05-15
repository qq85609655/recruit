package com.csot.recruit.model.original.flow.employ;

import java.io.Serializable;
import java.util.Date;

public class EmployDemand implements Serializable {
    private String id;

    private String employId;

    private String demandId;

    private String employeeType;

    private String district;

    private String applyOrganizationName;

    private String applyOrganizationId;

    private String applyPostId;

    private String applyPostName;

    private String rankId;

    private String recruitDemandReason;

    private String creatorId;

    private Date createDate;

    private String modifiedId;

    private Date updateDate;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployId() {
        return employId;
    }

    public void setEmployId(String employId) {
        this.employId = employId;
    }

    public String getDemandId() {
        return demandId;
    }

    public void setDemandId(String demandId) {
        this.demandId = demandId;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getApplyOrganizationName() {
        return applyOrganizationName;
    }

    public void setApplyOrganizationName(String applyOrganizationName) {
        this.applyOrganizationName = applyOrganizationName;
    }

    public String getApplyOrganizationId() {
        return applyOrganizationId;
    }

    public void setApplyOrganizationId(String applyOrganizationId) {
        this.applyOrganizationId = applyOrganizationId;
    }

    public String getApplyPostId() {
        return applyPostId;
    }

    public void setApplyPostId(String applyPostId) {
        this.applyPostId = applyPostId;
    }

    public String getApplyPostName() {
        return applyPostName;
    }

    public void setApplyPostName(String applyPostName) {
        this.applyPostName = applyPostName;
    }

    public String getRankId() {
        return rankId;
    }

    public void setRankId(String rankId) {
        this.rankId = rankId;
    }

    public String getRecruitDemandReason() {
        return recruitDemandReason;
    }

    public void setRecruitDemandReason(String recruitDemandReason) {
        this.recruitDemandReason = recruitDemandReason;
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
        EmployDemand other = (EmployDemand) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmployId() == null ? other.getEmployId() == null : this.getEmployId().equals(other.getEmployId()))
            && (this.getDemandId() == null ? other.getDemandId() == null : this.getDemandId().equals(other.getDemandId()))
            && (this.getEmployeeType() == null ? other.getEmployeeType() == null : this.getEmployeeType().equals(other.getEmployeeType()))
            && (this.getDistrict() == null ? other.getDistrict() == null : this.getDistrict().equals(other.getDistrict()))
            && (this.getApplyOrganizationName() == null ? other.getApplyOrganizationName() == null : this.getApplyOrganizationName().equals(other.getApplyOrganizationName()))
            && (this.getApplyOrganizationId() == null ? other.getApplyOrganizationId() == null : this.getApplyOrganizationId().equals(other.getApplyOrganizationId()))
            && (this.getApplyPostId() == null ? other.getApplyPostId() == null : this.getApplyPostId().equals(other.getApplyPostId()))
            && (this.getApplyPostName() == null ? other.getApplyPostName() == null : this.getApplyPostName().equals(other.getApplyPostName()))
            && (this.getRankId() == null ? other.getRankId() == null : this.getRankId().equals(other.getRankId()))
            && (this.getRecruitDemandReason() == null ? other.getRecruitDemandReason() == null : this.getRecruitDemandReason().equals(other.getRecruitDemandReason()))
            && (this.getCreatorId() == null ? other.getCreatorId() == null : this.getCreatorId().equals(other.getCreatorId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getModifiedId() == null ? other.getModifiedId() == null : this.getModifiedId().equals(other.getModifiedId()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmployId() == null) ? 0 : getEmployId().hashCode());
        result = prime * result + ((getDemandId() == null) ? 0 : getDemandId().hashCode());
        result = prime * result + ((getEmployeeType() == null) ? 0 : getEmployeeType().hashCode());
        result = prime * result + ((getDistrict() == null) ? 0 : getDistrict().hashCode());
        result = prime * result + ((getApplyOrganizationName() == null) ? 0 : getApplyOrganizationName().hashCode());
        result = prime * result + ((getApplyOrganizationId() == null) ? 0 : getApplyOrganizationId().hashCode());
        result = prime * result + ((getApplyPostId() == null) ? 0 : getApplyPostId().hashCode());
        result = prime * result + ((getApplyPostName() == null) ? 0 : getApplyPostName().hashCode());
        result = prime * result + ((getRankId() == null) ? 0 : getRankId().hashCode());
        result = prime * result + ((getRecruitDemandReason() == null) ? 0 : getRecruitDemandReason().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getModifiedId() == null) ? 0 : getModifiedId().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}