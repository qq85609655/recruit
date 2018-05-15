package com.csot.recruit.model.original.flow.recruitdemand;

import java.io.Serializable;
import java.util.Date;

public class RecruitDemandLog implements Serializable {
    private String id;

    private String oldStr;

    private String newStr;

    private Date updateDate;

    private String modifiedId;

    private String demandId;

    private String updateField;

    private String modifiedName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOldStr() {
        return oldStr;
    }

    public void setOldStr(String oldStr) {
        this.oldStr = oldStr;
    }

    public String getNewStr() {
        return newStr;
    }

    public void setNewStr(String newStr) {
        this.newStr = newStr;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getModifiedId() {
        return modifiedId;
    }

    public void setModifiedId(String modifiedId) {
        this.modifiedId = modifiedId;
    }

    public String getDemandId() {
        return demandId;
    }

    public void setDemandId(String demandId) {
        this.demandId = demandId;
    }

    public String getUpdateField() {
        return updateField;
    }

    public void setUpdateField(String updateField) {
        this.updateField = updateField;
    }

    public String getModifiedName() {
        return modifiedName;
    }

    public void setModifiedName(String modifiedName) {
        this.modifiedName = modifiedName;
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
        RecruitDemandLog other = (RecruitDemandLog) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOldStr() == null ? other.getOldStr() == null : this.getOldStr().equals(other.getOldStr()))
            && (this.getNewStr() == null ? other.getNewStr() == null : this.getNewStr().equals(other.getNewStr()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getModifiedId() == null ? other.getModifiedId() == null : this.getModifiedId().equals(other.getModifiedId()))
            && (this.getDemandId() == null ? other.getDemandId() == null : this.getDemandId().equals(other.getDemandId()))
            && (this.getUpdateField() == null ? other.getUpdateField() == null : this.getUpdateField().equals(other.getUpdateField()))
            && (this.getModifiedName() == null ? other.getModifiedName() == null : this.getModifiedName().equals(other.getModifiedName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOldStr() == null) ? 0 : getOldStr().hashCode());
        result = prime * result + ((getNewStr() == null) ? 0 : getNewStr().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getModifiedId() == null) ? 0 : getModifiedId().hashCode());
        result = prime * result + ((getDemandId() == null) ? 0 : getDemandId().hashCode());
        result = prime * result + ((getUpdateField() == null) ? 0 : getUpdateField().hashCode());
        result = prime * result + ((getModifiedName() == null) ? 0 : getModifiedName().hashCode());
        return result;
    }
}