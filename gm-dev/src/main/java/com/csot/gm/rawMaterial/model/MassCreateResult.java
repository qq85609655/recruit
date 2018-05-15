package com.csot.gm.rawMaterial.model;

import org.apache.poi.ss.usermodel.Sheet;

public class MassCreateResult {
  private boolean isSuccess;
  private Sheet sheet;

  public Sheet getSheet() {
    return sheet;
  }

  public void setSheet(Sheet sheet) {
    this.sheet = sheet;
  }

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean isSuccess) {
    this.isSuccess = isSuccess;
  }

}
