package com.csot.gm.materialManage.model.original.clean;

import java.io.Serializable;

public class Clean implements Serializable {
  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column T_GM_CLEAN.ID
   *
   * @mbggenerated
   */
  private String id;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column T_GM_CLEAN.PART_NO
   *
   * @mbggenerated
   */
  private String partNo;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column T_GM_CLEAN.BRAND
   *
   * @mbggenerated
   */
  private String brand;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column T_GM_CLEAN.SPEC
   *
   * @mbggenerated
   */
  private String spec;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column T_GM_CLEAN.STATUS
   *
   * @mbggenerated
   */
  private String status;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database column T_GM_CLEAN.INFO
   *
   * @mbggenerated
   */
  private String info;

  /**
   * This field was generated by MyBatis Generator.
   * This field corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column T_GM_CLEAN.ID
   *
   * @return the value of T_GM_CLEAN.ID
   *
   * @mbggenerated
   */
  public String getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column T_GM_CLEAN.ID
   *
   * @param id the value for T_GM_CLEAN.ID
   *
   * @mbggenerated
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column T_GM_CLEAN.PART_NO
   *
   * @return the value of T_GM_CLEAN.PART_NO
   *
   * @mbggenerated
   */
  public String getPartNo() {
    return partNo;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column T_GM_CLEAN.PART_NO
   *
   * @param partNo the value for T_GM_CLEAN.PART_NO
   *
   * @mbggenerated
   */
  public void setPartNo(String partNo) {
    this.partNo = partNo;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column T_GM_CLEAN.BRAND
   *
   * @return the value of T_GM_CLEAN.BRAND
   *
   * @mbggenerated
   */
  public String getBrand() {
    return brand;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column T_GM_CLEAN.BRAND
   *
   * @param brand the value for T_GM_CLEAN.BRAND
   *
   * @mbggenerated
   */
  public void setBrand(String brand) {
    this.brand = brand;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column T_GM_CLEAN.SPEC
   *
   * @return the value of T_GM_CLEAN.SPEC
   *
   * @mbggenerated
   */
  public String getSpec() {
    return spec;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column T_GM_CLEAN.SPEC
   *
   * @param spec the value for T_GM_CLEAN.SPEC
   *
   * @mbggenerated
   */
  public void setSpec(String spec) {
    this.spec = spec;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column T_GM_CLEAN.STATUS
   *
   * @return the value of T_GM_CLEAN.STATUS
   *
   * @mbggenerated
   */
  public String getStatus() {
    return status;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column T_GM_CLEAN.STATUS
   *
   * @param status the value for T_GM_CLEAN.STATUS
   *
   * @mbggenerated
   */
  public void setStatus(String status) {
    this.status = status;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method returns the value of the database column T_GM_CLEAN.INFO
   *
   * @return the value of T_GM_CLEAN.INFO
   *
   * @mbggenerated
   */
  public String getInfo() {
    return info;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method sets the value of the database column T_GM_CLEAN.INFO
   *
   * @param info the value for T_GM_CLEAN.INFO
   *
   * @mbggenerated
   */
  public void setInfo(String info) {
    this.info = info;
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
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
    Clean other = (Clean) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
      && (this.getPartNo() == null ? other.getPartNo() == null : this.getPartNo().equals(other.getPartNo()))
      && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
      && (this.getSpec() == null ? other.getSpec() == null : this.getSpec().equals(other.getSpec()))
      && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
      && (this.getInfo() == null ? other.getInfo() == null : this.getInfo().equals(other.getInfo()));
  }

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_CLEAN
   *
   * @mbggenerated
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getPartNo() == null) ? 0 : getPartNo().hashCode());
    result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
    result = prime * result + ((getSpec() == null) ? 0 : getSpec().hashCode());
    result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
    result = prime * result + ((getInfo() == null) ? 0 : getInfo().hashCode());
    return result;
  }
}