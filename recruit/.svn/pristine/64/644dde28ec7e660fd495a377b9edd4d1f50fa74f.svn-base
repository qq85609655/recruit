package com.csot.recruit.model.position;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DepartmentRequire implements Serializable {
    private Integer id;
    
    // 部门
    private String department;

    // 职位内部编码
    private String positionCode;

    // 需求人数
    private Integer demands;

    // 职位生效日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date effectiveDate;
    
    private String effectDate;

    // 期望到岗日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expectDate;

    private String expecDate;
    
    // 需求类型
    private String demandType;

    private String recruitPositionId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = (positionCode == null ? null : positionCode.trim());
    }

    public Integer getDemands() {
        return demands;
    }

    public void setDemands(Integer demands) {
        this.demands = demands;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getEffectDate() {
      return effectDate;
    }

    public void setEffectDate(String effectDate) {
      this.effectDate = effectDate;
    }

    public Date getExpectDate() {
        return expectDate;
    }

    public void setExpectDate(Date expectDate) {
        this.expectDate = expectDate;
    }

    public String getExpecDate() {
      return expecDate;
    }

    public void setExpecDate(String expecDate) {
      this.expecDate = expecDate;
    }

    public String getDemandType() {
        return demandType;
    }

    public void setDemandType(String demandType) {
        this.demandType = demandType;
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
        DepartmentRequire other = (DepartmentRequire) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getPositionCode() == null ? other.getPositionCode() == null : this.getPositionCode().equals(other.getPositionCode()))
            && (this.getDemands() == null ? other.getDemands() == null : this.getDemands().equals(other.getDemands()))
            && (this.getEffectiveDate() == null ? other.getEffectiveDate() == null : this.getEffectiveDate().equals(other.getEffectiveDate()))
            && (this.getExpectDate() == null ? other.getExpectDate() == null : this.getExpectDate().equals(other.getExpectDate()))
            && (this.getDemandType() == null ? other.getDemandType() == null : this.getDemandType().equals(other.getDemandType()))
            && (this.getRecruitPositionId() == null ? other.getRecruitPositionId() == null : this.getRecruitPositionId().equals(other.getRecruitPositionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getPositionCode() == null) ? 0 : getPositionCode().hashCode());
        result = prime * result + ((getDemands() == null) ? 0 : getDemands().hashCode());
        result = prime * result + ((getEffectiveDate() == null) ? 0 : getEffectiveDate().hashCode());
        result = prime * result + ((getExpectDate() == null) ? 0 : getExpectDate().hashCode());
        result = prime * result + ((getDemandType() == null) ? 0 : getDemandType().hashCode());
        result = prime * result + ((getRecruitPositionId() == null) ? 0 : getRecruitPositionId().hashCode());
        return result;
    }
}