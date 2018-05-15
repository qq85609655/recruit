package com.csot.recruit.model.resume;

public class ImportResume {
	
	private Long id;
	//关联职位
	private String jobId;
	//招聘渠道
	private String recruitChannel;
	//简历来源
	private String resumeSource;
	//员工姓名
	private String userName;
	//公司邮箱
	private String email;
	//选择简历
	private String resumeFormat;
	//简历文本内容 
	private String resumetext;
	//重复简历
	private int forceReplace;
	//导入类型
	private int importType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getRecruitChannel() {
		return recruitChannel;
	}
	public void setRecruitChannel(String recruitChannel) {
		this.recruitChannel = recruitChannel;
	}
	public String getResumeSource() {
		return resumeSource;
	}
	public void setResumeSource(String resumeSource) {
		this.resumeSource = resumeSource;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getResumeFormat() {
		return resumeFormat;
	}
	public void setResumeFormat(String resumeFormat) {
		this.resumeFormat = resumeFormat;
	}
	public String getResumetext() {
    return resumetext;
  }
  public void setResumetext(String resumetext) {
    this.resumetext = resumetext;
  }
  public int getForceReplace() {
		return forceReplace;
	}
	public void setForceReplace(int forceReplace) {
		this.forceReplace = forceReplace;
	}
	public int getImportType() {
		return importType;
	}
	public void setImportType(int importType) {
		this.importType = importType;
	}
	
	
}
