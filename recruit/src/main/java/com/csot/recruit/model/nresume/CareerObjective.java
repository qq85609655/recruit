package com.csot.recruit.model.nresume;

import java.io.Serializable;

/**
 * 描述简历中的职业目标信息
 * @author honglu
 *
 */
public class CareerObjective implements Serializable {
  
  private static final long serialVersionUID = 1L;

  /** 意向薪水    */
  private String desiredSalary;
  
  /** 货币类型    */
  private PropertyData desiredSalaryCurrency;
  
  /** 意向工作类型    */
  private String[] desiredTypeOfEmployment;
  
  /** 意向工作地点    */
  private String desiredLocation;
  
  /** 意向行业    */
  private String[] desiredIndustry;
  
  /** 意向岗位     */
  private String[] desiredPosition;
  
  /** 到岗时间    */
  private PropertyData Availability;

  public String getDesiredSalary() {
    return desiredSalary;
  }

  public void setDesiredSalary(String desiredSalary) {
    this.desiredSalary = desiredSalary;
  }

  /**
   * @return the desiredSalaryCurrency
   */
  public PropertyData getDesiredSalaryCurrency() {
    return desiredSalaryCurrency;
  }

  /**
   * @param desiredSalaryCurrency the desiredSalaryCurrency to set
   */
  public void setDesiredSalaryCurrency(PropertyData desiredSalaryCurrency) {
    this.desiredSalaryCurrency = desiredSalaryCurrency;
  }

  public String[] getDesiredTypeOfEmployment() {
    return desiredTypeOfEmployment;
  }

  public void setDesiredTypeOfEmployment(String[] desiredTypeOfEmployment) {
    this.desiredTypeOfEmployment = desiredTypeOfEmployment;
  }

  public String getDesiredLocation() {
    return desiredLocation;
  }

  public void setDesiredLocation(String desiredLocation) {
    this.desiredLocation = desiredLocation;
  }

  public String[] getDesiredIndustry() {
    return desiredIndustry;
  }

  public void setDesiredIndustry(String[] desiredIndustry) {
    this.desiredIndustry = desiredIndustry;
  }

  public String[] getDesiredPosition() {
    return desiredPosition;
  }

  public void setDesiredPosition(String[] desiredPosition) {
    this.desiredPosition = desiredPosition;
  }

  /**
   * @return the availability
   */
  public PropertyData getAvailability() {
    return Availability;
  }

  /**
   * @param availability the availability to set
   */
  public void setAvailability(PropertyData availability) {
    Availability = availability;
  }
}
