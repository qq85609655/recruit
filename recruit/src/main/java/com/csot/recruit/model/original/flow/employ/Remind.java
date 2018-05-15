package com.csot.recruit.model.original.flow.employ;

import java.io.Serializable;
import java.util.Date;

public class Remind implements Serializable {
    private String id;

    private String remindDate;

    private String remindContent;

    private String remindUser;

    private String remindUserName;

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

    public String getRemindDate() {
        return remindDate;
    }

    public void setRemindDate(String remindDate) {
        this.remindDate = remindDate;
    }

    public String getRemindContent() {
        return remindContent;
    }

    public void setRemindContent(String remindContent) {
        this.remindContent = remindContent;
    }

    public String getRemindUser() {
        return remindUser;
    }

    public void setRemindUser(String remindUser) {
        this.remindUser = remindUser;
    }

    public String getRemindUserName() {
        return remindUserName;
    }

    public void setRemindUserName(String remindUserName) {
        this.remindUserName = remindUserName;
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
        Remind other = (Remind) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRemindDate() == null ? other.getRemindDate() == null : this.getRemindDate().equals(other.getRemindDate()))
            && (this.getRemindContent() == null ? other.getRemindContent() == null : this.getRemindContent().equals(other.getRemindContent()))
            && (this.getRemindUser() == null ? other.getRemindUser() == null : this.getRemindUser().equals(other.getRemindUser()))
            && (this.getRemindUserName() == null ? other.getRemindUserName() == null : this.getRemindUserName().equals(other.getRemindUserName()))
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
        result = prime * result + ((getRemindDate() == null) ? 0 : getRemindDate().hashCode());
        result = prime * result + ((getRemindContent() == null) ? 0 : getRemindContent().hashCode());
        result = prime * result + ((getRemindUser() == null) ? 0 : getRemindUser().hashCode());
        result = prime * result + ((getRemindUserName() == null) ? 0 : getRemindUserName().hashCode());
        result = prime * result + ((getCreatorId() == null) ? 0 : getCreatorId().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getModifiedId() == null) ? 0 : getModifiedId().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}