package com.csot.recruit.model.resume;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class File implements Serializable{
  
  private static final long serialVersionUID = 1L;
  
  private String id;
  // 文件名称 
  private String fileName;
  
  // 文件类型
  private String fileType;
  
  // 文件大小
  private String fileSize;
  
  // 文件路径
  private String filePath;
  
  //创建者
  private String uploader;
  
  //上传时间
  private Date uploadTime;
  
  //文件
  private MultipartFile file;
  
  public File(){
    
  }
  
  public File(String fileName, String fileSize) {
    this.fileName = fileName;
    this.fileSize = fileSize;
  }
  
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

  public String getFileSize() {
    return fileSize;
  }

  public void setFileSize(String fileSize) {
    this.fileSize = fileSize;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public String getUploader() {
    return uploader;
  }

  public void setUploader(String uploader) {
    this.uploader = uploader;
  }

  public Date getUploadTime() {
    return uploadTime;
  }

  public void setUploadTime(Date uploadTime) {
    this.uploadTime = uploadTime;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public MultipartFile getFile() {
    return file;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
  }

  
}
