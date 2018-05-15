package com.csot.recruit.model.extension.interview;

import java.io.Serializable;

public class RecommendExt implements Serializable {
    private String id;

    private String personCode;

    private String recommended;

    private String recommendRelation;

    private String recommendPosition;

    private String recommendPhone;

    private String recommendAddress;

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

    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public String getRecommendRelation() {
        return recommendRelation;
    }

    public void setRecommendRelation(String recommendRelation) {
        this.recommendRelation = recommendRelation;
    }

    public String getRecommendPosition() {
        return recommendPosition;
    }

    public void setRecommendPosition(String recommendPosition) {
        this.recommendPosition = recommendPosition;
    }

    public String getRecommendPhone() {
        return recommendPhone;
    }

    public void setRecommendPhone(String recommendPhone) {
        this.recommendPhone = recommendPhone;
    }

    public String getRecommendAddress() {
        return recommendAddress;
    }

    public void setRecommendAddress(String recommendAddress) {
        this.recommendAddress = recommendAddress;
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
        RecommendExt other = (RecommendExt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonCode() == null ? other.getPersonCode() == null : this.getPersonCode().equals(other.getPersonCode()))
            && (this.getRecommended() == null ? other.getRecommended() == null : this.getRecommended().equals(other.getRecommended()))
            && (this.getRecommendRelation() == null ? other.getRecommendRelation() == null : this.getRecommendRelation().equals(other.getRecommendRelation()))
            && (this.getRecommendPosition() == null ? other.getRecommendPosition() == null : this.getRecommendPosition().equals(other.getRecommendPosition()))
            && (this.getRecommendPhone() == null ? other.getRecommendPhone() == null : this.getRecommendPhone().equals(other.getRecommendPhone()))
            && (this.getRecommendAddress() == null ? other.getRecommendAddress() == null : this.getRecommendAddress().equals(other.getRecommendAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonCode() == null) ? 0 : getPersonCode().hashCode());
        result = prime * result + ((getRecommended() == null) ? 0 : getRecommended().hashCode());
        result = prime * result + ((getRecommendRelation() == null) ? 0 : getRecommendRelation().hashCode());
        result = prime * result + ((getRecommendPosition() == null) ? 0 : getRecommendPosition().hashCode());
        result = prime * result + ((getRecommendPhone() == null) ? 0 : getRecommendPhone().hashCode());
        result = prime * result + ((getRecommendAddress() == null) ? 0 : getRecommendAddress().hashCode());
        return result;
    }
}