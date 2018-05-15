package com.csot.recruit.model.original.campus;

import java.io.Serializable;

public class CampusTask implements Serializable {
    private String id;

    private String siteId;

    private String siteName;

    private String postId;

    private String postName;

    private Integer taskNumberBa;

    private Integer taskNumberMa;

    private Integer taskNumberDo;

    private String remark;

    private String reserved1;

    private String reserved2;

    private String reserved3;

    private String status;

    private String yearth;

    private String orgName;

    private String organization;

    private String bigCenter;

    private String smallCenter;

    private String department;

    private String branch;

    private String jobFamily;

    private String jobClass;

    private String jobSubclass;

    private String jobDescribe;

    private String nightShift;

    private String dustFree;

    private Integer taskNumberSum;

    private Integer taskNumberMail;

    private Integer taskNumberFemail;

    private String specialRequire;

    private String preferredMajor;

    private String alternativeMajor;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
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

    public Integer getTaskNumberBa() {
        return taskNumberBa;
    }

    public void setTaskNumberBa(Integer taskNumberBa) {
        this.taskNumberBa = taskNumberBa;
    }

    public Integer getTaskNumberMa() {
        return taskNumberMa;
    }

    public void setTaskNumberMa(Integer taskNumberMa) {
        this.taskNumberMa = taskNumberMa;
    }

    public Integer getTaskNumberDo() {
        return taskNumberDo;
    }

    public void setTaskNumberDo(Integer taskNumberDo) {
        this.taskNumberDo = taskNumberDo;
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

    public String getYearth() {
        return yearth;
    }

    public void setYearth(String yearth) {
        this.yearth = yearth;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
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

    public String getJobDescribe() {
        return jobDescribe;
    }

    public void setJobDescribe(String jobDescribe) {
        this.jobDescribe = jobDescribe;
    }

    public String getNightShift() {
        return nightShift;
    }

    public void setNightShift(String nightShift) {
        this.nightShift = nightShift;
    }

    public String getDustFree() {
        return dustFree;
    }

    public void setDustFree(String dustFree) {
        this.dustFree = dustFree;
    }

    public Integer getTaskNumberSum() {
        return taskNumberSum;
    }

    public void setTaskNumberSum(Integer taskNumberSum) {
        this.taskNumberSum = taskNumberSum;
    }

    public Integer getTaskNumberMail() {
        return taskNumberMail;
    }

    public void setTaskNumberMail(Integer taskNumberMail) {
        this.taskNumberMail = taskNumberMail;
    }

    public Integer getTaskNumberFemail() {
        return taskNumberFemail;
    }

    public void setTaskNumberFemail(Integer taskNumberFemail) {
        this.taskNumberFemail = taskNumberFemail;
    }

    public String getSpecialRequire() {
        return specialRequire;
    }

    public void setSpecialRequire(String specialRequire) {
        this.specialRequire = specialRequire;
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
        CampusTask other = (CampusTask) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSiteId() == null ? other.getSiteId() == null : this.getSiteId().equals(other.getSiteId()))
            && (this.getSiteName() == null ? other.getSiteName() == null : this.getSiteName().equals(other.getSiteName()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getPostName() == null ? other.getPostName() == null : this.getPostName().equals(other.getPostName()))
            && (this.getTaskNumberBa() == null ? other.getTaskNumberBa() == null : this.getTaskNumberBa().equals(other.getTaskNumberBa()))
            && (this.getTaskNumberMa() == null ? other.getTaskNumberMa() == null : this.getTaskNumberMa().equals(other.getTaskNumberMa()))
            && (this.getTaskNumberDo() == null ? other.getTaskNumberDo() == null : this.getTaskNumberDo().equals(other.getTaskNumberDo()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getReserved1() == null ? other.getReserved1() == null : this.getReserved1().equals(other.getReserved1()))
            && (this.getReserved2() == null ? other.getReserved2() == null : this.getReserved2().equals(other.getReserved2()))
            && (this.getReserved3() == null ? other.getReserved3() == null : this.getReserved3().equals(other.getReserved3()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getYearth() == null ? other.getYearth() == null : this.getYearth().equals(other.getYearth()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getOrganization() == null ? other.getOrganization() == null : this.getOrganization().equals(other.getOrganization()))
            && (this.getBigCenter() == null ? other.getBigCenter() == null : this.getBigCenter().equals(other.getBigCenter()))
            && (this.getSmallCenter() == null ? other.getSmallCenter() == null : this.getSmallCenter().equals(other.getSmallCenter()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getBranch() == null ? other.getBranch() == null : this.getBranch().equals(other.getBranch()))
            && (this.getJobFamily() == null ? other.getJobFamily() == null : this.getJobFamily().equals(other.getJobFamily()))
            && (this.getJobClass() == null ? other.getJobClass() == null : this.getJobClass().equals(other.getJobClass()))
            && (this.getJobSubclass() == null ? other.getJobSubclass() == null : this.getJobSubclass().equals(other.getJobSubclass()))
            && (this.getJobDescribe() == null ? other.getJobDescribe() == null : this.getJobDescribe().equals(other.getJobDescribe()))
            && (this.getNightShift() == null ? other.getNightShift() == null : this.getNightShift().equals(other.getNightShift()))
            && (this.getDustFree() == null ? other.getDustFree() == null : this.getDustFree().equals(other.getDustFree()))
            && (this.getTaskNumberSum() == null ? other.getTaskNumberSum() == null : this.getTaskNumberSum().equals(other.getTaskNumberSum()))
            && (this.getTaskNumberMail() == null ? other.getTaskNumberMail() == null : this.getTaskNumberMail().equals(other.getTaskNumberMail()))
            && (this.getTaskNumberFemail() == null ? other.getTaskNumberFemail() == null : this.getTaskNumberFemail().equals(other.getTaskNumberFemail()))
            && (this.getSpecialRequire() == null ? other.getSpecialRequire() == null : this.getSpecialRequire().equals(other.getSpecialRequire()))
            && (this.getPreferredMajor() == null ? other.getPreferredMajor() == null : this.getPreferredMajor().equals(other.getPreferredMajor()))
            && (this.getAlternativeMajor() == null ? other.getAlternativeMajor() == null : this.getAlternativeMajor().equals(other.getAlternativeMajor()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getSiteId() == null) ? 0 : getSiteId().hashCode());
        result = prime * result + ((getSiteName() == null) ? 0 : getSiteName().hashCode());
        result = prime * result + ((getPostId() == null) ? 0 : getPostId().hashCode());
        result = prime * result + ((getPostName() == null) ? 0 : getPostName().hashCode());
        result = prime * result + ((getTaskNumberBa() == null) ? 0 : getTaskNumberBa().hashCode());
        result = prime * result + ((getTaskNumberMa() == null) ? 0 : getTaskNumberMa().hashCode());
        result = prime * result + ((getTaskNumberDo() == null) ? 0 : getTaskNumberDo().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getReserved1() == null) ? 0 : getReserved1().hashCode());
        result = prime * result + ((getReserved2() == null) ? 0 : getReserved2().hashCode());
        result = prime * result + ((getReserved3() == null) ? 0 : getReserved3().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getYearth() == null) ? 0 : getYearth().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getOrganization() == null) ? 0 : getOrganization().hashCode());
        result = prime * result + ((getBigCenter() == null) ? 0 : getBigCenter().hashCode());
        result = prime * result + ((getSmallCenter() == null) ? 0 : getSmallCenter().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getBranch() == null) ? 0 : getBranch().hashCode());
        result = prime * result + ((getJobFamily() == null) ? 0 : getJobFamily().hashCode());
        result = prime * result + ((getJobClass() == null) ? 0 : getJobClass().hashCode());
        result = prime * result + ((getJobSubclass() == null) ? 0 : getJobSubclass().hashCode());
        result = prime * result + ((getJobDescribe() == null) ? 0 : getJobDescribe().hashCode());
        result = prime * result + ((getNightShift() == null) ? 0 : getNightShift().hashCode());
        result = prime * result + ((getDustFree() == null) ? 0 : getDustFree().hashCode());
        result = prime * result + ((getTaskNumberSum() == null) ? 0 : getTaskNumberSum().hashCode());
        result = prime * result + ((getTaskNumberMail() == null) ? 0 : getTaskNumberMail().hashCode());
        result = prime * result + ((getTaskNumberFemail() == null) ? 0 : getTaskNumberFemail().hashCode());
        result = prime * result + ((getSpecialRequire() == null) ? 0 : getSpecialRequire().hashCode());
        result = prime * result + ((getPreferredMajor() == null) ? 0 : getPreferredMajor().hashCode());
        result = prime * result + ((getAlternativeMajor() == null) ? 0 : getAlternativeMajor().hashCode());
        return result;
    }
}