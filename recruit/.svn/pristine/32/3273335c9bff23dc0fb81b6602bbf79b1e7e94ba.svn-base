package com.csot.recruit.model.original.interview;

import java.io.Serializable;

public class EmergentContacts implements Serializable {
    private String id;

    private String personCode;

    private String emergentName;

    private String emergentRelation;
    
    private String relationName;

    private String emergentPhone;

    private String emergentAddress;

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

    public String getEmergentName() {
        return emergentName;
    }

    public void setEmergentName(String emergentName) {
        this.emergentName = emergentName;
    }

    public String getEmergentRelation() {
        return emergentRelation;
    }

    public void setEmergentRelation(String emergentRelation) {
        this.emergentRelation = emergentRelation;
    }

    public String getEmergentPhone() {
        return emergentPhone;
    }

    public void setEmergentPhone(String emergentPhone) {
        this.emergentPhone = emergentPhone;
    }

    public String getEmergentAddress() {
        return emergentAddress;
    }

    public void setEmergentAddress(String emergentAddress) {
        this.emergentAddress = emergentAddress;
    }

    public String getRelationName() {
      return relationName;
    }

    public void setRelationName(String relationName) {
      this.relationName = relationName;
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
        EmergentContacts other = (EmergentContacts) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonCode() == null ? other.getPersonCode() == null : this.getPersonCode().equals(other.getPersonCode()))
            && (this.getEmergentName() == null ? other.getEmergentName() == null : this.getEmergentName().equals(other.getEmergentName()))
            && (this.getEmergentRelation() == null ? other.getEmergentRelation() == null : this.getEmergentRelation().equals(other.getEmergentRelation()))
            && (this.getEmergentPhone() == null ? other.getEmergentPhone() == null : this.getEmergentPhone().equals(other.getEmergentPhone()))
            && (this.getEmergentAddress() == null ? other.getEmergentAddress() == null : this.getEmergentAddress().equals(other.getEmergentAddress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonCode() == null) ? 0 : getPersonCode().hashCode());
        result = prime * result + ((getEmergentName() == null) ? 0 : getEmergentName().hashCode());
        result = prime * result + ((getEmergentRelation() == null) ? 0 : getEmergentRelation().hashCode());
        result = prime * result + ((getEmergentPhone() == null) ? 0 : getEmergentPhone().hashCode());
        result = prime * result + ((getEmergentAddress() == null) ? 0 : getEmergentAddress().hashCode());
        return result;
    }
}