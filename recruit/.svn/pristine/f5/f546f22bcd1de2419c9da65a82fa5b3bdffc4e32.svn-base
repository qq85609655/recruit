package com.csot.recruit.model.position;

import java.io.Serializable;
import java.util.Date;

public class RecruitFlowConfig implements Serializable {
    private Integer id;

    // 招聘专员
    private String recruitPerson;

    // 其它招聘专
    private String recruitPersonOther;

    // 用人部门主管
    private String demandDepOwner;

    // 简历接收邮箱
    private String receiveEmail;

    // 面试评估模板
    private String interviewTemplate;

    // 创建 日期
    private Date createDate;

    // 关联的发布职位id
    private String recruitPositionId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRecruitPerson() {
        return recruitPerson;
    }

    public void setRecruitPerson(String recruitPerson) {
        this.recruitPerson = recruitPerson == null ? null : recruitPerson.trim();
    }

    public String getRecruitPersonOther() {
        return recruitPersonOther;
    }

    public void setRecruitPersonOther(String recruitPersonOther) {
        this.recruitPersonOther = recruitPersonOther == null ? null : recruitPersonOther.trim();
    }

    public String getDemandDepOwner() {
        return demandDepOwner;
    }

    public void setDemandDepOwner(String demandDepOwner) {
        this.demandDepOwner = demandDepOwner == null ? null : demandDepOwner.trim();
    }

    public String getReceiveEmail() {
        return receiveEmail;
    }

    public void setReceiveEmail(String receiveEmail) {
        this.receiveEmail = receiveEmail == null ? null : receiveEmail.trim();
    }

    public String getInterviewTemplate() {
        return interviewTemplate;
    }

    public void setInterviewTemplate(String interviewTemplate) {
        this.interviewTemplate = interviewTemplate == null ? null : interviewTemplate.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRecruitPositionId() {
        return recruitPositionId;
    }

    public void setRecruitPositionId(String recruitPositionId) {
        this.recruitPositionId = recruitPositionId == null ? null : recruitPositionId.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        RecruitFlowConfig other = (RecruitFlowConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRecruitPerson() == null ? other.getRecruitPerson() == null : this.getRecruitPerson().equals(other.getRecruitPerson()))
            && (this.getRecruitPersonOther() == null ? other.getRecruitPersonOther() == null : this.getRecruitPersonOther().equals(other.getRecruitPersonOther()))
            && (this.getDemandDepOwner() == null ? other.getDemandDepOwner() == null : this.getDemandDepOwner().equals(other.getDemandDepOwner()))
            && (this.getReceiveEmail() == null ? other.getReceiveEmail() == null : this.getReceiveEmail().equals(other.getReceiveEmail()))
            && (this.getInterviewTemplate() == null ? other.getInterviewTemplate() == null : this.getInterviewTemplate().equals(other.getInterviewTemplate()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getRecruitPositionId() == null ? other.getRecruitPositionId() == null : this.getRecruitPositionId().equals(other.getRecruitPositionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRecruitPerson() == null) ? 0 : getRecruitPerson().hashCode());
        result = prime * result + ((getRecruitPersonOther() == null) ? 0 : getRecruitPersonOther().hashCode());
        result = prime * result + ((getDemandDepOwner() == null) ? 0 : getDemandDepOwner().hashCode());
        result = prime * result + ((getReceiveEmail() == null) ? 0 : getReceiveEmail().hashCode());
        result = prime * result + ((getInterviewTemplate() == null) ? 0 : getInterviewTemplate().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getRecruitPositionId() == null) ? 0 : getRecruitPositionId().hashCode());
        return result;
    }
}