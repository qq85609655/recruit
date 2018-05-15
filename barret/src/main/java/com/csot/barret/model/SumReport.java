package com.csot.barret.model;

/**
 * Created by xiongyinchun on 2018/2/8.
 */
public class SumReport {
  private String company;
  private String partType;
  private int partPropValue;
  private int partNoAdd;
  private int partNoUpdate;
  private int plantExtend;
  private int plantUpdate;
  private int statusFreeze;
  private int releaseFreeze;
  private int forbidOrder;
  private int releaseOrder;

  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public String getPartType() {
    return partType;
  }

  public void setPartType(String partType) {
    this.partType = partType;
  }

  public int getPartPropValue() {
    return partPropValue;
  }

  public void setPartPropValue(int partPropValue) {
    this.partPropValue = partPropValue;
  }

  public int getPartNoAdd() {
    return partNoAdd;
  }

  public void setPartNoAdd(int partNoAdd) {
    this.partNoAdd = partNoAdd;
  }

  public int getPartNoUpdate() {
    return partNoUpdate;
  }

  public void setPartNoUpdate(int partNoUpdate) {
    this.partNoUpdate = partNoUpdate;
  }

  public int getPlantExtend() {
    return plantExtend;
  }

  public void setPlantExtend(int plantExtend) {
    this.plantExtend = plantExtend;
  }

  public int getPlantUpdate() {
    return plantUpdate;
  }

  public void setPlantUpdate(int plantUpdate) {
    this.plantUpdate = plantUpdate;
  }

  public int getStatusFreeze() {
    return statusFreeze;
  }

  public void setStatusFreeze(int statusFreeze) {
    this.statusFreeze = statusFreeze;
  }

  public int getReleaseFreeze() {
    return releaseFreeze;
  }

  public void setReleaseFreeze(int releaseFreeze) {
    this.releaseFreeze = releaseFreeze;
  }

  public int getForbidOrder() {
    return forbidOrder;
  }

  public void setForbidOrder(int forbidOrder) {
    this.forbidOrder = forbidOrder;
  }

  public int getReleaseOrder() {
    return releaseOrder;
  }

  public void setReleaseOrder(int releaseOrder) {
    this.releaseOrder = releaseOrder;
  }
}
