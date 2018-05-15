package com.csot.recruit.model.resume;

import java.util.List;

public class ResumeUploadResult {
  
  private String basePath;
  
  private String validateResult;
  
  private String saveDir;
  
  private String saveFileResult;
  
  private List<java.io.File> fileList;

  public String getBasePath() {
    return basePath;
  }

  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }

  public String getValidateResult() {
    return validateResult;
  }

  public void setValidateResult(String validateResult) {
    this.validateResult = validateResult;
  }

  public String getSaveDir() {
    return saveDir;
  }

  public void setSaveDir(String saveDir) {
    this.saveDir = saveDir;
  }

  public String getSaveFileResult() {
    return saveFileResult;
  }

  public void setSaveFileResult(String saveFileResult) {
    this.saveFileResult = saveFileResult;
  }

  public List<java.io.File> getFileList() {
    return fileList;
  }

  public void setFileList(List<java.io.File> fileList) {
    this.fileList = fileList;
  }
}
