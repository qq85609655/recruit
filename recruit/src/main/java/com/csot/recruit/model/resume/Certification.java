package com.csot.recruit.model.resume;

import java.io.Serializable;
import java.util.Date;

public class Certification implements Serializable {
    private String id;

    private String name;

    private Date receivingdate;
    
    private String recivingDateStr ;

    private String score;

    private String resumeId;

    private String type;
    
    private String typeName;
    
    private String num;

    private String authorityOrg;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReceivingdate() {
        return receivingdate;
    }

    public void setReceivingdate(Date receivingdate) {
        this.receivingdate = receivingdate;
    }
    
    public String getRecivingDateStr() {
      return recivingDateStr;
    }

    public void setRecivingDateStr(String recivingDateStr) {
      this.recivingDateStr = recivingDateStr;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getAuthorityOrg() {
        return authorityOrg;
    }

    public void setAuthorityOrg(String authorityOrg) {
        this.authorityOrg = authorityOrg;
    }

    public String getTypeName() {
      return typeName;
    }

    public void setTypeName(String typeName) {
      this.typeName = typeName;
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
        Certification other = (Certification) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getReceivingdate() == null ? other.getReceivingdate() == null : this.getReceivingdate().equals(other.getReceivingdate()))
            && (this.getScore() == null ? other.getScore() == null : this.getScore().equals(other.getScore()))
            && (this.getResumeId() == null ? other.getResumeId() == null : this.getResumeId().equals(other.getResumeId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getAuthorityOrg() == null ? other.getAuthorityOrg() == null : this.getAuthorityOrg().equals(other.getAuthorityOrg()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getReceivingdate() == null) ? 0 : getReceivingdate().hashCode());
        result = prime * result + ((getScore() == null) ? 0 : getScore().hashCode());
        result = prime * result + ((getResumeId() == null) ? 0 : getResumeId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getAuthorityOrg() == null) ? 0 : getAuthorityOrg().hashCode());
        return result;
    }
}