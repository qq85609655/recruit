package com.csot.recruit.model.position;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Distribute implements Serializable {
  
    private BigDecimal id;

    private Date distributeDate;

    private String publisher;

    private String result;

    private String publishSite;

    private String publishUrl;

    private String recruitPositionId;

    private String errorMessage;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getDistributeDate() {
        return distributeDate;
    }

    public void setDistributeDate(Date distributeDate) {
        this.distributeDate = distributeDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher == null ? null : publisher.trim();
    }

    public String getResult() {
      return result;
    }

    public void setResult(String result) {
      this.result = result;
    }

    public String getPublishSite() {
        return publishSite;
    }

    public void setPublishSite(String publishSite) {
        this.publishSite = publishSite == null ? null : publishSite.trim();
    }

    public String getPublishUrl() {
        return publishUrl;
    }

    public void setPublishUrl(String publishUrl) {
        this.publishUrl = publishUrl == null ? null : publishUrl.trim();
    }

    public String getRecruitPositionId() {
        return recruitPositionId;
    }

    public void setRecruitPositionId(String recruitPositionId) {
        this.recruitPositionId = recruitPositionId == null ? null : recruitPositionId.trim();
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage == null ? null : errorMessage.trim();
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
        Distribute other = (Distribute) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getDistributeDate() == null ? other.getDistributeDate() == null : this.getDistributeDate().equals(other.getDistributeDate()))
            && (this.getPublisher() == null ? other.getPublisher() == null : this.getPublisher().equals(other.getPublisher()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getPublishSite() == null ? other.getPublishSite() == null : this.getPublishSite().equals(other.getPublishSite()))
            && (this.getPublishUrl() == null ? other.getPublishUrl() == null : this.getPublishUrl().equals(other.getPublishUrl()))
            && (this.getRecruitPositionId() == null ? other.getRecruitPositionId() == null : this.getRecruitPositionId().equals(other.getRecruitPositionId()))
            && (this.getErrorMessage() == null ? other.getErrorMessage() == null : this.getErrorMessage().equals(other.getErrorMessage()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDistributeDate() == null) ? 0 : getDistributeDate().hashCode());
        result = prime * result + ((getPublisher() == null) ? 0 : getPublisher().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getPublishSite() == null) ? 0 : getPublishSite().hashCode());
        result = prime * result + ((getPublishUrl() == null) ? 0 : getPublishUrl().hashCode());
        result = prime * result + ((getRecruitPositionId() == null) ? 0 : getRecruitPositionId().hashCode());
        result = prime * result + ((getErrorMessage() == null) ? 0 : getErrorMessage().hashCode());
        return result;
    }
}