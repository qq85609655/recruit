package com.csot.recruit.model.original.uniform;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Job implements Serializable {
    private BigDecimal id;

    private String cJobname;

    private String cOldOrgcode;
    
    private String cOrgcode;
    
    private String cOrgname;

    private String cOldJobcode;

    private String cJobcode;

    private String cIsResponsible;

    private String cAvailable;

    private BigDecimal cSort;

    private String cKey;

    private String cRemark;

    private String cStatus;

    private String jobid;

    private String isTempJob;

    private Date cOperatortime;

    private String fdPrimaryKey;

    private String fdStatus;

    private Date fdExcuteTime;

    private String fdIsUpdated;

    private String fdUpdateEmpNo;

    private Date fdUpdateTime;

    private String reserved1;

    private String reserved2;

    private String reserved3;

    private String reserved4;

    private String reserved5;

    private String reserved6;

    private String reserved7;

    private String reserved8;

    private String reserved9;

    private String reserved10;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getcJobname() {
        return cJobname;
    }

    public void setcJobname(String cJobname) {
        this.cJobname = cJobname;
    }

    public String getcOldOrgcode() {
        return cOldOrgcode;
    }

    public void setcOldOrgcode(String cOldOrgcode) {
        this.cOldOrgcode = cOldOrgcode;
    }

    public String getcOrgcode() {
        return cOrgcode;
    }

    public void setcOrgcode(String cOrgcode) {
        this.cOrgcode = cOrgcode;
    }

    public String getcOldJobcode() {
        return cOldJobcode;
    }

    public void setcOldJobcode(String cOldJobcode) {
        this.cOldJobcode = cOldJobcode;
    }

    public String getcJobcode() {
        return cJobcode;
    }

    public void setcJobcode(String cJobcode) {
        this.cJobcode = cJobcode;
    }

    public String getcIsResponsible() {
        return cIsResponsible;
    }

    public void setcIsResponsible(String cIsResponsible) {
        this.cIsResponsible = cIsResponsible;
    }

    public String getcAvailable() {
        return cAvailable;
    }

    public void setcAvailable(String cAvailable) {
        this.cAvailable = cAvailable;
    }

    public BigDecimal getcSort() {
        return cSort;
    }

    public void setcSort(BigDecimal cSort) {
        this.cSort = cSort;
    }

    public String getcKey() {
        return cKey;
    }

    public void setcKey(String cKey) {
        this.cKey = cKey;
    }

    public String getcRemark() {
        return cRemark;
    }

    public void setcRemark(String cRemark) {
        this.cRemark = cRemark;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }

    public String getJobid() {
        return jobid;
    }

    public void setJobid(String jobid) {
        this.jobid = jobid;
    }

    public String getIsTempJob() {
        return isTempJob;
    }

    public void setIsTempJob(String isTempJob) {
        this.isTempJob = isTempJob;
    }

    public Date getcOperatortime() {
        return cOperatortime;
    }

    public void setcOperatortime(Date cOperatortime) {
        this.cOperatortime = cOperatortime;
    }

    public String getFdPrimaryKey() {
        return fdPrimaryKey;
    }

    public void setFdPrimaryKey(String fdPrimaryKey) {
        this.fdPrimaryKey = fdPrimaryKey;
    }

    public String getFdStatus() {
        return fdStatus;
    }

    public void setFdStatus(String fdStatus) {
        this.fdStatus = fdStatus;
    }

    public Date getFdExcuteTime() {
        return fdExcuteTime;
    }

    public void setFdExcuteTime(Date fdExcuteTime) {
        this.fdExcuteTime = fdExcuteTime;
    }

    public String getFdIsUpdated() {
        return fdIsUpdated;
    }

    public void setFdIsUpdated(String fdIsUpdated) {
        this.fdIsUpdated = fdIsUpdated;
    }

    public String getFdUpdateEmpNo() {
        return fdUpdateEmpNo;
    }

    public void setFdUpdateEmpNo(String fdUpdateEmpNo) {
        this.fdUpdateEmpNo = fdUpdateEmpNo;
    }

    public Date getFdUpdateTime() {
        return fdUpdateTime;
    }

    public void setFdUpdateTime(Date fdUpdateTime) {
        this.fdUpdateTime = fdUpdateTime;
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

    public String getReserved4() {
        return reserved4;
    }

    public void setReserved4(String reserved4) {
        this.reserved4 = reserved4;
    }

    public String getReserved5() {
        return reserved5;
    }

    public void setReserved5(String reserved5) {
        this.reserved5 = reserved5;
    }

    public String getReserved6() {
        return reserved6;
    }

    public void setReserved6(String reserved6) {
        this.reserved6 = reserved6;
    }

    public String getReserved7() {
        return reserved7;
    }

    public void setReserved7(String reserved7) {
        this.reserved7 = reserved7;
    }

    public String getReserved8() {
        return reserved8;
    }

    public void setReserved8(String reserved8) {
        this.reserved8 = reserved8;
    }

    public String getReserved9() {
        return reserved9;
    }

    public void setReserved9(String reserved9) {
        this.reserved9 = reserved9;
    }

    public String getReserved10() {
        return reserved10;
    }

    public void setReserved10(String reserved10) {
        this.reserved10 = reserved10;
    }

    public String getcOrgname() {
      return cOrgname;
    }

    public void setcOrgname(String cOrgname) {
      this.cOrgname = cOrgname;
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
        Job other = (Job) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getcJobname() == null ? other.getcJobname() == null : this.getcJobname().equals(other.getcJobname()))
            && (this.getcOldOrgcode() == null ? other.getcOldOrgcode() == null : this.getcOldOrgcode().equals(other.getcOldOrgcode()))
            && (this.getcOrgcode() == null ? other.getcOrgcode() == null : this.getcOrgcode().equals(other.getcOrgcode()))
            && (this.getcOldJobcode() == null ? other.getcOldJobcode() == null : this.getcOldJobcode().equals(other.getcOldJobcode()))
            && (this.getcJobcode() == null ? other.getcJobcode() == null : this.getcJobcode().equals(other.getcJobcode()))
            && (this.getcIsResponsible() == null ? other.getcIsResponsible() == null : this.getcIsResponsible().equals(other.getcIsResponsible()))
            && (this.getcAvailable() == null ? other.getcAvailable() == null : this.getcAvailable().equals(other.getcAvailable()))
            && (this.getcSort() == null ? other.getcSort() == null : this.getcSort().equals(other.getcSort()))
            && (this.getcKey() == null ? other.getcKey() == null : this.getcKey().equals(other.getcKey()))
            && (this.getcRemark() == null ? other.getcRemark() == null : this.getcRemark().equals(other.getcRemark()))
            && (this.getcStatus() == null ? other.getcStatus() == null : this.getcStatus().equals(other.getcStatus()))
            && (this.getJobid() == null ? other.getJobid() == null : this.getJobid().equals(other.getJobid()))
            && (this.getIsTempJob() == null ? other.getIsTempJob() == null : this.getIsTempJob().equals(other.getIsTempJob()))
            && (this.getcOperatortime() == null ? other.getcOperatortime() == null : this.getcOperatortime().equals(other.getcOperatortime()))
            && (this.getFdPrimaryKey() == null ? other.getFdPrimaryKey() == null : this.getFdPrimaryKey().equals(other.getFdPrimaryKey()))
            && (this.getFdStatus() == null ? other.getFdStatus() == null : this.getFdStatus().equals(other.getFdStatus()))
            && (this.getFdExcuteTime() == null ? other.getFdExcuteTime() == null : this.getFdExcuteTime().equals(other.getFdExcuteTime()))
            && (this.getFdIsUpdated() == null ? other.getFdIsUpdated() == null : this.getFdIsUpdated().equals(other.getFdIsUpdated()))
            && (this.getFdUpdateEmpNo() == null ? other.getFdUpdateEmpNo() == null : this.getFdUpdateEmpNo().equals(other.getFdUpdateEmpNo()))
            && (this.getFdUpdateTime() == null ? other.getFdUpdateTime() == null : this.getFdUpdateTime().equals(other.getFdUpdateTime()))
            && (this.getReserved1() == null ? other.getReserved1() == null : this.getReserved1().equals(other.getReserved1()))
            && (this.getReserved2() == null ? other.getReserved2() == null : this.getReserved2().equals(other.getReserved2()))
            && (this.getReserved3() == null ? other.getReserved3() == null : this.getReserved3().equals(other.getReserved3()))
            && (this.getReserved4() == null ? other.getReserved4() == null : this.getReserved4().equals(other.getReserved4()))
            && (this.getReserved5() == null ? other.getReserved5() == null : this.getReserved5().equals(other.getReserved5()))
            && (this.getReserved6() == null ? other.getReserved6() == null : this.getReserved6().equals(other.getReserved6()))
            && (this.getReserved7() == null ? other.getReserved7() == null : this.getReserved7().equals(other.getReserved7()))
            && (this.getReserved8() == null ? other.getReserved8() == null : this.getReserved8().equals(other.getReserved8()))
            && (this.getReserved9() == null ? other.getReserved9() == null : this.getReserved9().equals(other.getReserved9()))
            && (this.getReserved10() == null ? other.getReserved10() == null : this.getReserved10().equals(other.getReserved10()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getcJobname() == null) ? 0 : getcJobname().hashCode());
        result = prime * result + ((getcOldOrgcode() == null) ? 0 : getcOldOrgcode().hashCode());
        result = prime * result + ((getcOrgcode() == null) ? 0 : getcOrgcode().hashCode());
        result = prime * result + ((getcOldJobcode() == null) ? 0 : getcOldJobcode().hashCode());
        result = prime * result + ((getcJobcode() == null) ? 0 : getcJobcode().hashCode());
        result = prime * result + ((getcIsResponsible() == null) ? 0 : getcIsResponsible().hashCode());
        result = prime * result + ((getcAvailable() == null) ? 0 : getcAvailable().hashCode());
        result = prime * result + ((getcSort() == null) ? 0 : getcSort().hashCode());
        result = prime * result + ((getcKey() == null) ? 0 : getcKey().hashCode());
        result = prime * result + ((getcRemark() == null) ? 0 : getcRemark().hashCode());
        result = prime * result + ((getcStatus() == null) ? 0 : getcStatus().hashCode());
        result = prime * result + ((getJobid() == null) ? 0 : getJobid().hashCode());
        result = prime * result + ((getIsTempJob() == null) ? 0 : getIsTempJob().hashCode());
        result = prime * result + ((getcOperatortime() == null) ? 0 : getcOperatortime().hashCode());
        result = prime * result + ((getFdPrimaryKey() == null) ? 0 : getFdPrimaryKey().hashCode());
        result = prime * result + ((getFdStatus() == null) ? 0 : getFdStatus().hashCode());
        result = prime * result + ((getFdExcuteTime() == null) ? 0 : getFdExcuteTime().hashCode());
        result = prime * result + ((getFdIsUpdated() == null) ? 0 : getFdIsUpdated().hashCode());
        result = prime * result + ((getFdUpdateEmpNo() == null) ? 0 : getFdUpdateEmpNo().hashCode());
        result = prime * result + ((getFdUpdateTime() == null) ? 0 : getFdUpdateTime().hashCode());
        result = prime * result + ((getReserved1() == null) ? 0 : getReserved1().hashCode());
        result = prime * result + ((getReserved2() == null) ? 0 : getReserved2().hashCode());
        result = prime * result + ((getReserved3() == null) ? 0 : getReserved3().hashCode());
        result = prime * result + ((getReserved4() == null) ? 0 : getReserved4().hashCode());
        result = prime * result + ((getReserved5() == null) ? 0 : getReserved5().hashCode());
        result = prime * result + ((getReserved6() == null) ? 0 : getReserved6().hashCode());
        result = prime * result + ((getReserved7() == null) ? 0 : getReserved7().hashCode());
        result = prime * result + ((getReserved8() == null) ? 0 : getReserved8().hashCode());
        result = prime * result + ((getReserved9() == null) ? 0 : getReserved9().hashCode());
        result = prime * result + ((getReserved10() == null) ? 0 : getReserved10().hashCode());
        return result;
    }
}