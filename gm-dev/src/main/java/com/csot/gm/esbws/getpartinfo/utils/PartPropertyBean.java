package com.csot.gm.esbws.getpartinfo.utils;

public class PartPropertyBean {

  private String trueValue = "";
  private String displayValue = "";

  public PartPropertyBean() {
    super();
  }

  public String getTrueValue() {
    return trueValue;
  }

  public void setTrueValue(String trueValue) {
    this.trueValue = trueValue;
  }

  public String getDisplayValue() {
    return displayValue;
  }

  public void setDisplayValue(String displayValue) {
    this.displayValue = displayValue;
  }

  @Override
  public String toString() {
    // TODO Auto-generated method stub
    return "trueValue:" + trueValue + "  displayValue:" + displayValue;
  }

}
