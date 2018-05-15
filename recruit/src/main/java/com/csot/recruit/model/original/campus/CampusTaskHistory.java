package com.csot.recruit.model.original.campus;

import java.io.Serializable;
import java.util.Date;

public class CampusTaskHistory implements Serializable {
    private String id;

    private String siteId;

    private String siteName;

    private String postId;

    private String postName;

    private Integer taskNumberBa;

    private Integer taskNumberMa;

    private Integer taskNumberDo;

    private String yearth;

    private Integer taskNumberSum;

    private Integer taskNumberMail;

    private Integer taskNumberFemail;

    private Date changeDate;

    private String orgName;

    private String organization;

    private Integer taskNumberBaNew;

    private Integer taskNumberMaNew;

    private Integer taskNumberDoNew;

    private Integer taskNumberSumNew;

    private Integer taskNumberMailNew;

    private Integer taskNumberFemailNew;

    private String bigCenter;

    private String smallCenter;

    private String department;

    private String branch;

    private String education;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getYearth() {
        return yearth;
    }

    public void setYearth(String yearth) {
        this.yearth = yearth;
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

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
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

    public Integer getTaskNumberBaNew() {
        return taskNumberBaNew;
    }

    public void setTaskNumberBaNew(Integer taskNumberBaNew) {
        this.taskNumberBaNew = taskNumberBaNew;
    }

    public Integer getTaskNumberMaNew() {
        return taskNumberMaNew;
    }

    public void setTaskNumberMaNew(Integer taskNumberMaNew) {
        this.taskNumberMaNew = taskNumberMaNew;
    }

    public Integer getTaskNumberDoNew() {
        return taskNumberDoNew;
    }

    public void setTaskNumberDoNew(Integer taskNumberDoNew) {
        this.taskNumberDoNew = taskNumberDoNew;
    }

    public Integer getTaskNumberSumNew() {
        return taskNumberSumNew;
    }

    public void setTaskNumberSumNew(Integer taskNumberSumNew) {
        this.taskNumberSumNew = taskNumberSumNew;
    }

    public Integer getTaskNumberMailNew() {
        return taskNumberMailNew;
    }

    public void setTaskNumberMailNew(Integer taskNumberMailNew) {
        this.taskNumberMailNew = taskNumberMailNew;
    }

    public Integer getTaskNumberFemailNew() {
        return taskNumberFemailNew;
    }

    public void setTaskNumberFemailNew(Integer taskNumberFemailNew) {
        this.taskNumberFemailNew = taskNumberFemailNew;
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
        CampusTaskHistory other = (CampusTaskHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSiteId() == null ? other.getSiteId() == null : this.getSiteId().equals(other.getSiteId()))
            && (this.getSiteName() == null ? other.getSiteName() == null : this.getSiteName().equals(other.getSiteName()))
            && (this.getPostId() == null ? other.getPostId() == null : this.getPostId().equals(other.getPostId()))
            && (this.getPostName() == null ? other.getPostName() == null : this.getPostName().equals(other.getPostName()))
            && (this.getTaskNumberBa() == null ? other.getTaskNumberBa() == null : this.getTaskNumberBa().equals(other.getTaskNumberBa()))
            && (this.getTaskNumberMa() == null ? other.getTaskNumberMa() == null : this.getTaskNumberMa().equals(other.getTaskNumberMa()))
            && (this.getTaskNumberDo() == null ? other.getTaskNumberDo() == null : this.getTaskNumberDo().equals(other.getTaskNumberDo()))
            && (this.getYearth() == null ? other.getYearth() == null : this.getYearth().equals(other.getYearth()))
            && (this.getTaskNumberSum() == null ? other.getTaskNumberSum() == null : this.getTaskNumberSum().equals(other.getTaskNumberSum()))
            && (this.getTaskNumberMail() == null ? other.getTaskNumberMail() == null : this.getTaskNumberMail().equals(other.getTaskNumberMail()))
            && (this.getTaskNumberFemail() == null ? other.getTaskNumberFemail() == null : this.getTaskNumberFemail().equals(other.getTaskNumberFemail()))
            && (this.getChangeDate() == null ? other.getChangeDate() == null : this.getChangeDate().equals(other.getChangeDate()))
            && (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
            && (this.getOrganization() == null ? other.getOrganization() == null : this.getOrganization().equals(other.getOrganization()))
            && (this.getTaskNumberBaNew() == null ? other.getTaskNumberBaNew() == null : this.getTaskNumberBaNew().equals(other.getTaskNumberBaNew()))
            && (this.getTaskNumberMaNew() == null ? other.getTaskNumberMaNew() == null : this.getTaskNumberMaNew().equals(other.getTaskNumberMaNew()))
            && (this.getTaskNumberDoNew() == null ? other.getTaskNumberDoNew() == null : this.getTaskNumberDoNew().equals(other.getTaskNumberDoNew()))
            && (this.getTaskNumberSumNew() == null ? other.getTaskNumberSumNew() == null : this.getTaskNumberSumNew().equals(other.getTaskNumberSumNew()))
            && (this.getTaskNumberMailNew() == null ? other.getTaskNumberMailNew() == null : this.getTaskNumberMailNew().equals(other.getTaskNumberMailNew()))
            && (this.getTaskNumberFemailNew() == null ? other.getTaskNumberFemailNew() == null : this.getTaskNumberFemailNew().equals(other.getTaskNumberFemailNew()))
            && (this.getBigCenter() == null ? other.getBigCenter() == null : this.getBigCenter().equals(other.getBigCenter()))
            && (this.getSmallCenter() == null ? other.getSmallCenter() == null : this.getSmallCenter().equals(other.getSmallCenter()))
            && (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
            && (this.getBranch() == null ? other.getBranch() == null : this.getBranch().equals(other.getBranch()))
            && (this.getEducation() == null ? other.getEducation() == null : this.getEducation().equals(other.getEducation()));
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
        result = prime * result + ((getYearth() == null) ? 0 : getYearth().hashCode());
        result = prime * result + ((getTaskNumberSum() == null) ? 0 : getTaskNumberSum().hashCode());
        result = prime * result + ((getTaskNumberMail() == null) ? 0 : getTaskNumberMail().hashCode());
        result = prime * result + ((getTaskNumberFemail() == null) ? 0 : getTaskNumberFemail().hashCode());
        result = prime * result + ((getChangeDate() == null) ? 0 : getChangeDate().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getOrganization() == null) ? 0 : getOrganization().hashCode());
        result = prime * result + ((getTaskNumberBaNew() == null) ? 0 : getTaskNumberBaNew().hashCode());
        result = prime * result + ((getTaskNumberMaNew() == null) ? 0 : getTaskNumberMaNew().hashCode());
        result = prime * result + ((getTaskNumberDoNew() == null) ? 0 : getTaskNumberDoNew().hashCode());
        result = prime * result + ((getTaskNumberSumNew() == null) ? 0 : getTaskNumberSumNew().hashCode());
        result = prime * result + ((getTaskNumberMailNew() == null) ? 0 : getTaskNumberMailNew().hashCode());
        result = prime * result + ((getTaskNumberFemailNew() == null) ? 0 : getTaskNumberFemailNew().hashCode());
        result = prime * result + ((getBigCenter() == null) ? 0 : getBigCenter().hashCode());
        result = prime * result + ((getSmallCenter() == null) ? 0 : getSmallCenter().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getBranch() == null) ? 0 : getBranch().hashCode());
        result = prime * result + ((getEducation() == null) ? 0 : getEducation().hashCode());
        return result;
    }
}