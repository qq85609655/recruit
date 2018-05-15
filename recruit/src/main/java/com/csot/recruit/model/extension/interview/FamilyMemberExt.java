package com.csot.recruit.model.extension.interview;

import java.io.Serializable;

public class FamilyMemberExt implements Serializable {
    private String id;

    private String personCode;

    private String menberName;

    private String familyRelation;

    private String menberGender;

    private String menberBirthday;

    private String menberAddress;

    private String emergentFlag;

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

    public String getMenberName() {
        return menberName;
    }

    public void setMenberName(String menberName) {
        this.menberName = menberName;
    }

    public String getFamilyRelation() {
        return familyRelation;
    }

    public void setFamilyRelation(String familyRelation) {
        this.familyRelation = familyRelation;
    }

    public String getMenberGender() {
        return menberGender;
    }

    public void setMenberGender(String menberGender) {
        this.menberGender = menberGender;
    }

    public String getMenberBirthday() {
        return menberBirthday;
    }

    public void setMenberBirthday(String menberBirthday) {
        this.menberBirthday = menberBirthday;
    }

    public String getMenberAddress() {
        return menberAddress;
    }

    public void setMenberAddress(String menberAddress) {
        this.menberAddress = menberAddress;
    }

    public String getEmergentFlag() {
        return emergentFlag;
    }

    public void setEmergentFlag(String emergentFlag) {
        this.emergentFlag = emergentFlag;
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
        FamilyMemberExt other = (FamilyMemberExt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPersonCode() == null ? other.getPersonCode() == null : this.getPersonCode().equals(other.getPersonCode()))
            && (this.getMenberName() == null ? other.getMenberName() == null : this.getMenberName().equals(other.getMenberName()))
            && (this.getFamilyRelation() == null ? other.getFamilyRelation() == null : this.getFamilyRelation().equals(other.getFamilyRelation()))
            && (this.getMenberGender() == null ? other.getMenberGender() == null : this.getMenberGender().equals(other.getMenberGender()))
            && (this.getMenberBirthday() == null ? other.getMenberBirthday() == null : this.getMenberBirthday().equals(other.getMenberBirthday()))
            && (this.getMenberAddress() == null ? other.getMenberAddress() == null : this.getMenberAddress().equals(other.getMenberAddress()))
            && (this.getEmergentFlag() == null ? other.getEmergentFlag() == null : this.getEmergentFlag().equals(other.getEmergentFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPersonCode() == null) ? 0 : getPersonCode().hashCode());
        result = prime * result + ((getMenberName() == null) ? 0 : getMenberName().hashCode());
        result = prime * result + ((getFamilyRelation() == null) ? 0 : getFamilyRelation().hashCode());
        result = prime * result + ((getMenberGender() == null) ? 0 : getMenberGender().hashCode());
        result = prime * result + ((getMenberBirthday() == null) ? 0 : getMenberBirthday().hashCode());
        result = prime * result + ((getMenberAddress() == null) ? 0 : getMenberAddress().hashCode());
        result = prime * result + ((getEmergentFlag() == null) ? 0 : getEmergentFlag().hashCode());
        return result;
    }
}