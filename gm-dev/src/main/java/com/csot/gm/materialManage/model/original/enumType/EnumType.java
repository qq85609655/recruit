package com.csot.gm.materialManage.model.original.enumType;

import java.io.Serializable;

public class EnumType implements Serializable {
  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_ENUM_TYPE.ID
   *
   * @mbggenerated
   */
  private String id;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database column
   * T_GM_ENUM_TYPE.ENUM_NAME
   *
   * @mbggenerated
   */
  private String enumName;

  /**
   * This field was generated by MyBatis Generator. This field corresponds to the database table
   * T_GM_ENUM_TYPE
   *
   * @mbggenerated
   */
  private static final long serialVersionUID = 1L;

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_ENUM_TYPE.ID
   *
   * @return the value of T_GM_ENUM_TYPE.ID
   *
   * @mbggenerated
   */
  public String getId() {
    return id;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_ENUM_TYPE.ID
   *
   * @param id the value for T_GM_ENUM_TYPE.ID
   *
   * @mbggenerated
   */
  public void setId(String id) {
    this.id = id;
  }

  /**
   * This method was generated by MyBatis Generator. This method returns the value of the database
   * column T_GM_ENUM_TYPE.ENUM_NAME
   *
   * @return the value of T_GM_ENUM_TYPE.ENUM_NAME
   *
   * @mbggenerated
   */
  public String getEnumName() {
    return enumName;
  }

  /**
   * This method was generated by MyBatis Generator. This method sets the value of the database
   * column T_GM_ENUM_TYPE.ENUM_NAME
   *
   * @param enumName the value for T_GM_ENUM_TYPE.ENUM_NAME
   *
   * @mbggenerated
   */
  public void setEnumName(String enumName) {
    this.enumName = enumName;
  }

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_ENUM_TYPE
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
    EnumType other = (EnumType) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getEnumName() == null ? other.getEnumName() == null : this.getEnumName().equals(
            other.getEnumName()));
  }

  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_ENUM_TYPE
   *
   * @mbggenerated
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getEnumName() == null) ? 0 : getEnumName().hashCode());
    return result;
  }
}
