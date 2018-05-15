package com.csot.recruit.model.nresume;

import java.io.Serializable;

/**
 * 用于接收通过邮件解析后的对象
 * @author honglu
 *
 */
public class EmailResume implements Serializable {

  private static final long serialVersionUID = 1L;

  /** 工作地点    */
  private String jobArea;
  
  /** 应聘职位    */
  private String jobName;
  
  /** 来自于  */
  private String from;
  
  /** 解析后的简历对象   */
  private Resume resume;

  public String getJobArea() {
    return jobArea;
  }

  public void setJobArea(String jobArea) {
    this.jobArea = jobArea;
  }

  public String getJobName() {
    return jobName;
  }

  public void setJobName(String jobName) {
    this.jobName = jobName;
  }

  public String getFrom() {
    return from;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public Resume getResume() {
    return resume;
  }

  public void setResume(Resume resume) {
    this.resume = resume;
  }
  
}
