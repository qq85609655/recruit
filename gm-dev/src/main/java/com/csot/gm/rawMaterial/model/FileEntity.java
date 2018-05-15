package com.csot.gm.rawMaterial.model;

import java.io.InputStream;

public class FileEntity {

  private String fileName;
  private String fileType;
  private String filePath;
  private InputStream inputStream;
  
  public String getFileName() {
    return fileName;
  }
  
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }
  
  public String getFileType() {
    return fileType;
  }
  
  public void setFileType(String fileType) {
    this.fileType = fileType;
  }
  
  public String getFilePath() {
    return filePath;
  }
  
  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }
  
  public InputStream getInputStream() {
    return inputStream;
  }
  
  public void setInputStream(InputStream inputStream) {
    this.inputStream = inputStream;
  }
  
}
