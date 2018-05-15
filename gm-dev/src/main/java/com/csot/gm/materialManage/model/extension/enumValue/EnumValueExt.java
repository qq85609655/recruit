package com.csot.gm.materialManage.model.extension.enumValue;

import java.io.Serializable;

public class EnumValueExt implements Serializable {
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_ENUM_VALUE.ID
   *
   * @mbggenerated
   */
  private String id;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_ENUM_VALUE.ENUM_VALUE
   *
   * @mbggenerated
   */
  private String enumValue;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_ENUM_VALUE.ENUM_TEXT
   *
   * @mbggenerated
   */
  private String enumText;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_ENUM_VALUE.ENUM_TYPE_ID
   *
   * @mbggenerated
   */
  private String enumTypeId;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database table
   * T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_ENUM_VALUE.ID
   *
   * @return the value of T_GM_ENUM_VALUE.ID
   *
   * @mbggenerated
   */
  public String getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_ENUM_VALUE.ID
   *
   * @param id the value for T_GM_ENUM_VALUE.ID
   *
   * @mbggenerated
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_ENUM_VALUE.ENUM_VALUE
   *
   * @return the value of T_GM_ENUM_VALUE.ENUM_VALUE
   *
   * @mbggenerated
   */
  public String getEnumValue() {
    return enumValue;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_ENUM_VALUE.ENUM_VALUE
   *
   * @param enumValue the value for T_GM_ENUM_VALUE.ENUM_VALUE
   *
   * @mbggenerated
   */
  public void setEnumValue(String enumValue) {
    this.enumValue = enumValue;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_ENUM_VALUE.ENUM_TEXT
   *
   * @return the value of T_GM_ENUM_VALUE.ENUM_TEXT
   *
   * @mbggenerated
   */
  public String getEnumText() {
    return enumText;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_ENUM_VALUE.ENUM_TEXT
   *
   * @param enumText the value for T_GM_ENUM_VALUE.ENUM_TEXT
   *
   * @mbggenerated
   */
  public void setEnumText(String enumText) {
    this.enumText = enumText;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_ENUM_VALUE.ENUM_TYPE_ID
   *
   * @return the value of T_GM_ENUM_VALUE.ENUM_TYPE_ID
   *
   * @mbggenerated
   */
  public String getEnumTypeId() {
    return enumTypeId;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_ENUM_VALUE.ENUM_TYPE_ID
   *
   * @param enumTypeId the value for T_GM_ENUM_VALUE.ENUM_TYPE_ID
   *
   * @mbggenerated
   */
  public void setEnumTypeId(String enumTypeId) {
    this.enumTypeId = enumTypeId;
  }

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_ENUM_VALUE
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
    EnumValueExt other = (EnumValueExt) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getEnumValue() == null ? other.getEnumValue() == null : this.getEnumValue()
            .equals(other.getEnumValue()))
        && (this.getEnumText() == null ? other.getEnumText() == null : this.getEnumText().equals(
            other.getEnumText()))
        && (this.getEnumTypeId() == null ? other.getEnumTypeId() == null : this.getEnumTypeId()
            .equals(other.getEnumTypeId()));
  }

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getEnumValue() == null) ? 0 : getEnumValue().hashCode());
    result = prime * result + ((getEnumText() == null) ? 0 : getEnumText().hashCode());
    result = prime * result + ((getEnumTypeId() == null) ? 0 : getEnumTypeId().hashCode());
    return result;
  }
}
