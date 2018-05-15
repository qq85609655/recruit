package com.csot.gm.rawMaterial.model;

import com.csot.gm.materialManage.model.original.part.Part;
import com.csot.gm.materialManage.model.original.typePartM.TypePartM;

public class PartAndType {
  private Part part;
  private TypePartM tpm;

  public Part getPart() {
    return part;
  }

  public void setPart(Part part) {
    this.part = part;
  }

  public TypePartM getTpm() {
    return tpm;
  }

  public void setTpm(TypePartM tpm) {
    this.tpm = tpm;
  }

}
