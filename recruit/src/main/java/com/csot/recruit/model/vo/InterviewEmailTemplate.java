package com.csot.recruit.model.vo;

import java.io.Serializable;

public class InterviewEmailTemplate implements Serializable{
  
  /**
   * 
   */
  private static final long serialVersionUID = -9100102539880218519L;
  private String name ;
  private String address ;
  private String interviewtime ;
  private String interviewee ;
  private String reason ;
  
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getInterviewtime() {
    return interviewtime;
  }
  public void setInterviewtime(String interviewtime) {
    this.interviewtime = interviewtime;
  }
  public String getInterviewee() {
    return interviewee;
  }
  public void setInterviewee(String interviewee) {
    this.interviewee = interviewee;
  }
  public String getReason() {
    return reason;
  }
  public void setReason(String reason) {
    this.reason = reason;
  }


}
