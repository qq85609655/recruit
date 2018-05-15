package com.csot.recruit.model.original.flow.employ;

import java.util.List;

import com.csot.recruit.model.original.attachment.Attachment;

public class EmployVo {
  private Employ employ;

  private EmployCandidate candidate;

  private EmployDemand demand;

  List<EmployEducation> employEducations;

  List<EmployWork> employWorks;

  List<Attachment> attachments;
  
  public List<Attachment> getAttachments() {
    return attachments;
  }

  public void setAttachments(List<Attachment> attachments) {
    this.attachments = attachments;
  }

  public Employ getEmploy() {
    return employ;
  }

  public void setEmploy(Employ employ) {
    this.employ = employ;
  }

  public EmployCandidate getCandidate() {
    return candidate;
  }

  public void setCandidate(EmployCandidate candidate) {
    this.candidate = candidate;
  }

  public EmployDemand getDemand() {
    return demand;
  }

  public void setDemand(EmployDemand demand) {
    this.demand = demand;
  }

  public List<EmployEducation> getEmployEducations() {
    return employEducations;
  }

  public void setEmployEducations(List<EmployEducation> employEducations) {
    this.employEducations = employEducations;
  }

  public List<EmployWork> getEmployWorks() {
    return employWorks;
  }

  public void setEmployWorks(List<EmployWork> employWorks) {
    this.employWorks = employWorks;
  }

}
