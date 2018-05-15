package com.csot.gm.materialManage.model.extension.propertyRtn;

import java.io.Serializable;

public class PropertyRtnExt implements Serializable {
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_PROPERTY_RTN.ID
   *
   * @mbggenerated
   */
  private String id;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_PROPERTY_RTN.CREATE_UID
   *
   * @mbggenerated
   */
  private String createUid;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_PROPERTY_RTN.PROPERTY_NAME
   *
   * @mbggenerated
   */
  private String propertyName;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_PROPERTY_RTN.PROPERTY_TEXT
   *
   * @mbggenerated
   */
  private String propertyText;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_PROPERTY_RTN.PROPERTY_VALUE
   *
   * @mbggenerated
   */
  private String propertyValue;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database table
   * T_GM_PROPERTY_RTN
   *
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_PROPERTY_RTN.ID
   *
   * @return the value of T_GM_PROPERTY_RTN.ID
   *
   * @mbggenerated
   */
  public String getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_PROPERTY_RTN.ID
   *
   * @param id the value for T_GM_PROPERTY_RTN.ID
   *
   * @mbggenerated
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_PROPERTY_RTN.CREATE_UID
   *
   * @return the value of T_GM_PROPERTY_RTN.CREATE_UID
   *
   * @mbggenerated
   */
  public String getCreateUid() {
    return createUid;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_PROPERTY_RTN.CREATE_UID
   *
   * @param createUid the value for T_GM_PROPERTY_RTN.CREATE_UID
   *
   * @mbggenerated
   */
  public void setCreateUid(String createUid) {
    this.createUid = createUid;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_PROPERTY_RTN.PROPERTY_NAME
   *
   * @return the value of T_GM_PROPERTY_RTN.PROPERTY_NAME
   *
   * @mbggenerated
   */
  public String getPropertyName() {
    return propertyName;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_PROPERTY_RTN.PROPERTY_NAME
   *
   * @param propertyName the value for T_GM_PROPERTY_RTN.PROPERTY_NAME
   *
   * @mbggenerated
   */
  public void setPropertyName(String propertyName) {
    this.propertyName = propertyName;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_PROPERTY_RTN.PROPERTY_TEXT
   *
   * @return the value of T_GM_PROPERTY_RTN.PROPERTY_TEXT
   *
   * @mbggenerated
   */
  public String getPropertyText() {
    return propertyText;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_PROPERTY_RTN.PROPERTY_TEXT
   *
   * @param propertyText the value for T_GM_PROPERTY_RTN.PROPERTY_TEXT
   *
   * @mbggenerated
   */
  public void setPropertyText(String propertyText) {
    this.propertyText = propertyText;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_PROPERTY_RTN.PROPERTY_VALUE
   *
   * @return the value of T_GM_PROPERTY_RTN.PROPERTY_VALUE
   *
   * @mbggenerated
   */
  public String getPropertyValue() {
    return propertyValue;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_PROPERTY_RTN.PROPERTY_VALUE
   *
   * @param propertyValue the value for T_GM_PROPERTY_RTN.PROPERTY_VALUE
   *
   * @mbggenerated
   */
  public void setPropertyValue(String propertyValue) {
    this.propertyValue = propertyValue;
  }

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTY_RTN
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
    PropertyRtnExt other = (PropertyRtnExt) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getCreateUid() == null ? other.getCreateUid() == null : this.getCreateUid()
            .equals(other.getCreateUid()))
        && (this.getPropertyName() == null ? other.getPropertyName() == null : this
            .getPropertyName().equals(other.getPropertyName()))
        && (this.getPropertyText() == null ? other.getPropertyText() == null : this
            .getPropertyText().equals(other.getPropertyText()))
        && (this.getPropertyValue() == null ? other.getPropertyValue() == null : this
            .getPropertyValue().equals(other.getPropertyValue()));
  }

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_PROPERTY_RTN
   *
   * @mbggenerated
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getCreateUid() == null) ? 0 : getCreateUid().hashCode());
    result = prime * result + ((getPropertyName() == null) ? 0 : getPropertyName().hashCode());
    result = prime * result + ((getPropertyText() == null) ? 0 : getPropertyText().hashCode());
    result = prime * result + ((getPropertyValue() == null) ? 0 : getPropertyValue().hashCode());
    return result;
  }
}
