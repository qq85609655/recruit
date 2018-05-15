package org.amberframework.core.excel.poi;

import java.util.List;

public class ExportTestMaterialPlan {

  private String materialName;
  private String supplierName;
  private List<String> plannedQuantitis;

  public String getMaterialName() {
    return materialName;
  }

  public void setMaterialName(String materialName) {
    this.materialName = materialName;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  public List<String> getPlannedQuantitis() {
    return plannedQuantitis;
  }

  public void setPlannedQuantitis(List<String> plannedQuantitis) {
    this.plannedQuantitis = plannedQuantitis;
  }
}
