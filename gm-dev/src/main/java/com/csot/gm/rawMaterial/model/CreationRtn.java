package com.csot.gm.rawMaterial.model;

/**
 * 调用生成料号和物料描述方法所返回的对象
 * 
 * @author Barret
 *
 */
public class CreationRtn {
  private boolean isSuccess;
  private String message;
  private String partNo;
  private String partName;
  private String cnDesc;
  private String enDesc;

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean isSuccess) {
    this.isSuccess = isSuccess;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
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
}
