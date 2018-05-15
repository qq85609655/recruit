package com.csot.gm.util;

import java.util.Objects;

/**
 * Created by WangYu on 2015/11/4.
 */
public class LiquidCrystalTestBean {
  private String type; // 类型
  private String boxSize; // 盒厚
  private String supplier; // 供应商
  private String version; // 型号
  private String rm; // RM

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getBoxSize() {
    return boxSize;
  }

  public void setBoxSize(String boxSize) {
    this.boxSize = boxSize;
  }

  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

  public String getRm() {
    return rm;
  }

  public void setRm(String rm) {
    this.rm = rm;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null || getClass() != obj.getClass())
      return false;

    LiquidCrystalTestBean that = (LiquidCrystalTestBean) obj;

    if (type != null ? !type.equals(that.type) : that.type != null)
      return false;
    if (boxSize != null ? !boxSize.equals(that.boxSize) : that.boxSize != null)
      return false;
    if (supplier != null ? !supplier.equals(that.supplier) : that.supplier != null)
      return false;
    if (version != null ? !version.equals(that.version) : that.version != null)
      return false;
    return !(rm != null ? !rm.equals(that.rm) : that.rm != null);

  }

  @Override
  public int hashCode() {
    return Objects.hash(boxSize, rm, supplier, type, version);
  }
}
