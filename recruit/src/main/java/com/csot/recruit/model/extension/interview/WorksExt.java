package com.csot.recruit.model.extension.interview;

import java.io.Serializable;

public class WorksExt implements Serializable {
    private String id;

    private String personCode;

    private String workIndex;

    private String workstartdate;

    private String workenddate;

    private String companyName;

    private String finalSalary;

    private String department;

    private String finalPosition;

    private String reportTo;

    private String subordinates;

    private String seniority;

    private String responsibilities;

    private String leaveReason;

    private String reterence;

    private String relationship;

    private String reterencePhone;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPersonCode() {
        return personCode;
    }

    public void setPersonCode(String personCode) {
        this.personCode = personCode;
    }

    public String getWorkIndex() {
        return workIndex;
    }

    public void setWorkIndex(String workIndex) {
        this.workIndex = workIndex;
    }

    public String getWorkstartdate() {
        return workstartdate;
    }

    public void setWorkstartdate(String workstartdate) {
        this.workstartdate = workstartdate;
    }

    public String getWorkenddate() {
        return workenddate;
    }

    public void setWorkenddate(String workenddate) {
        this.workenddate = workenddate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(String finalSalary) {
        this.finalSalary = finalSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getFinalPosition() {
        return finalPosition;
    }

    public void setFinalPosition(String finalPosition) {
        this.finalPosition = finalPosition;
    }

    public String getReportTo() {
        return reportTo;
    }

    public void setReportTo(String reportTo) {
        this.reportTo = reportTo;
    }

    public String getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(String subordinates) {
        this.subordinates = subordinates;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public String getResponsibilities() {
        return responsibilities;
    }

    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getReterence() {
        return reterence;
    }

    public void setReterence(String reterence) {
        this.reterence = reterence;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getReterencePhone() {
        return reterencePhone;
    }

    public void setReterencePhone(String reterencePhone) {
        this.reterencePhone = reterencePhone;
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
        WorksExt other = (WorksExt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonCode() == null ? other.getPersonCode() == null : this.getPersonCode().equals(other.getPersonCode()))
            && (this.getWorkIndex() == null ? other.getWorkIndex() == null : this.getWorkIndex().equals(other.getWorkIndex()))
            && (this.getWorkstartdate() == null ? other.getWorkstartdate() == null : this.getWorkstartdate().equals(other.getWorkstartdate()))
            && (this.getWorkenddate() == null ? other.getWorkenddate() == null : this.getWorkenddate().equals(other.getWorkenddate()))
            && (this.getCompanyName() == null ? other.getCompanyName() == null : this.getCompanyName().equals(other.getCompanyName()))
            && (this.getFinalSalary() == null ? other.getFinalSalary() == null : this.getFinalSalary().equals(other.getFinalSalary()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getFinalPosition() == null ? other.getFinalPosition() == null : this.getFinalPosition().equals(other.getFinalPosition()))
            && (this.getReportTo() == null ? other.getReportTo() == null : this.getReportTo().equals(other.getReportTo()))
            && (this.getSubordinates() == null ? other.getSubordinates() == null : this.getSubordinates().equals(other.getSubordinates()))
            && (this.getSeniority() == null ? other.getSeniority() == null : this.getSeniority().equals(other.getSeniority()))
            && (this.getResponsibilities() == null ? other.getResponsibilities() == null : this.getResponsibilities().equals(other.getResponsibilities()))
            && (this.getLeaveReason() == null ? other.getLeaveReason() == null : this.getLeaveReason().equals(other.getLeaveReason()))
            && (this.getReterence() == null ? other.getReterence() == null : this.getReterence().equals(other.getReterence()))
            && (this.getRelationship() == null ? other.getRelationship() == null : this.getRelationship().equals(other.getRelationship()))
            && (this.getReterencePhone() == null ? other.getReterencePhone() == null : this.getReterencePhone().equals(other.getReterencePhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonCode() == null) ? 0 : getPersonCode().hashCode());
        result = prime * result + ((getWorkIndex() == null) ? 0 : getWorkIndex().hashCode());
        result = prime * result + ((getWorkstartdate() == null) ? 0 : getWorkstartdate().hashCode());
        result = prime * result + ((getWorkenddate() == null) ? 0 : getWorkenddate().hashCode());
        result = prime * result + ((getCompanyName() == null) ? 0 : getCompanyName().hashCode());
        result = prime * result + ((getFinalSalary() == null) ? 0 : getFinalSalary().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getFinalPosition() == null) ? 0 : getFinalPosition().hashCode());
        result = prime * result + ((getReportTo() == null) ? 0 : getReportTo().hashCode());
        result = prime * result + ((getSubordinates() == null) ? 0 : getSubordinates().hashCode());
        result = prime * result + ((getSeniority() == null) ? 0 : getSeniority().hashCode());
        result = prime * result + ((getResponsibilities() == null) ? 0 : getResponsibilities().hashCode());
        result = prime * result + ((getLeaveReason() == null) ? 0 : getLeaveReason().hashCode());
        result = prime * result + ((getReterence() == null) ? 0 : getReterence().hashCode());
        result = prime * result + ((getRelationship() == null) ? 0 : getRelationship().hashCode());
        result = prime * result + ((getReterencePhone() == null) ? 0 : getReterencePhone().hashCode());
        return result;
    }
}