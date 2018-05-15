package com.csot.gm.rawMaterial.model;

import java.util.Date;
import java.util.List;

import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;

/**
 * 料号信息保存
 * 
 * @author Barret
 *
 */
public class PartNoInfo {
  private String id;
  private String uid;
  private String partNo;
  private String partName;
  private String partType;
  private String cnDesc;
  private String enDesc;
  private String createCode;
  private String createName;
  private String plant;
  private String department;
  private String telephone;
  private Date createTime;
  private String partNoStatus;
  private String partId;
  private String hashCode;
  private List<PropertyValue> properties;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUid() {
    return uid;
  }

  public void setUid(String uid) {
    this.uid = uid;
  }

  public String getPartNo() {
    return partNo;
  }

  public void setPartNo(String partNo) {
    this.partNo = partNo;
  }

  public String getPartName() {
    return partName;
  }

  public void setPartName(String partName) {
    this.partName = partName;
  }

  public String getPartType() {
    return partType;
  }

  public void setPartType(String partType) {
    this.partType = partType;
  }

  public String getCnDesc() {
    return cnDesc;
  }

  public void setCnDesc(String cnDesc) {
    this.cnDesc = cnDesc;
  }

  public String getEnDesc() {
    return enDesc;
  }

  public void setEnDesc(String enDesc) {
    this.enDesc = enDesc;
  }

  public String getCreateCode() {
    return createCode;
  }

  public void setCreateCode(String createCode) {
    this.createCode = createCode;
  }

  public String getCreateName() {
    return createName;
  }

  public void setCreateName(String createName) {
    this.createName = createName;
  }

  public String getPlant() {
    return plant;
  }

  public void setPlant(String plant) {
    this.plant = plant;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public String getPartNoStatus() {
    return partNoStatus;
  }

  public void setPartNoStatus(String partNoStatus) {
    this.partNoStatus = partNoStatus;
  }

  public String getPartId() {
    return partId;
  }

  public void setPartId(String partId) {
    this.partId = partId;
  }

  public String getHashCode() {
    return hashCode;
  }

  public void setHashCode(String hashCode) {
    this.hashCode = hashCode;
  }

  public List<PropertyValue> getProperties() {
    return properties;
  }

  public void setProperties(List<PropertyValue> properties) {
    this.properties = properties;
  }
}
