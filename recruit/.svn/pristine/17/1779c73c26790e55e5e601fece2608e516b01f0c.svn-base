package com.csot.recruit.model.original.log;

import java.io.Serializable;
import java.util.Date;

public class OperateHistory implements Serializable {
    private String id;

    /**操作类型*/
    private String operatorType;

    /**操作用户id*/
    private String operatorUser;

    /**操作内容*/
    private String operatorContent;

    /**关联业务id*/
    private String relatedId;

    /**操作时间*/
    private Date operatorTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorUser() {
        return operatorUser;
    }

    public void setOperatorUser(String operatorUser) {
        this.operatorUser = operatorUser;
    }

    public String getOperatorContent() {
        return operatorContent;
    }

    public void setOperatorContent(String operatorContent) {
        this.operatorContent = operatorContent;
    }

    public String getRelatedId() {
        return relatedId;
    }

    public void setRelatedId(String relatedId) {
        this.relatedId = relatedId;
    }

    public Date getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(Date operatorTime) {
        this.operatorTime = operatorTime;
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
        OperateHistory other = (OperateHistory) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOperatorType() == null ? other.getOperatorType() == null : this.getOperatorType().equals(other.getOperatorType()))
            && (this.getOperatorUser() == null ? other.getOperatorUser() == null : this.getOperatorUser().equals(other.getOperatorUser()))
            && (this.getOperatorContent() == null ? other.getOperatorContent() == null : this.getOperatorContent().equals(other.getOperatorContent()))
            && (this.getRelatedId() == null ? other.getRelatedId() == null : this.getRelatedId().equals(other.getRelatedId()))
            && (this.getOperatorTime() == null ? other.getOperatorTime() == null : this.getOperatorTime().equals(other.getOperatorTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOperatorType() == null) ? 0 : getOperatorType().hashCode());
        result = prime * result + ((getOperatorUser() == null) ? 0 : getOperatorUser().hashCode());
        result = prime * result + ((getOperatorContent() == null) ? 0 : getOperatorContent().hashCode());
        result = prime * result + ((getRelatedId() == null) ? 0 : getRelatedId().hashCode());
        result = prime * result + ((getOperatorTime() == null) ? 0 : getOperatorTime().hashCode());
        return result;
    }
}