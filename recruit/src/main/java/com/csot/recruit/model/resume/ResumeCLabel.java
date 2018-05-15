package com.csot.recruit.model.resume;

import java.io.Serializable;

public class ResumeCLabel implements Serializable {
  
  private static final long serialVersionUID = -5836306504799114042L;

  private String labelResumeId;
  
  private String resumeId;
  
  private String labelId;

  public ResumeCLabel(String labelResumeId, String resumeId, String labelId) {
    this.labelResumeId = labelResumeId;
    this.resumeId = resumeId;
    this.labelId = labelId;
  }

  public String getLabelResumeId() {
    return labelResumeId;
  }

  public void setLabelResumeId(String labelResumeId) {
    this.labelResumeId = labelResumeId;
  }

  public String getResumeId() {
    return resumeId;
  }

  public void setResumeId(String resumeId) {
    this.resumeId = resumeId;
  }

  public String getLabelId() {
    return labelId;
  }

  public void setLabelId(String labelId) {
    this.labelId = labelId;
  }
  
}
