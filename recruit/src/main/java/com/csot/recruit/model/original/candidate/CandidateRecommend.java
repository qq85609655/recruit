package com.csot.recruit.model.original.candidate;

import java.io.Serializable;
import java.util.Date;

public class CandidateRecommend implements Serializable {
    private String id;

    private String candidatePostId;

    private String interviewer;

    private String resumeId;

    private String comments;

    private String feedback;

    private String turntoPostId;

    private String createUser;

    private Date createTime;

    private Date feedbackTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCandidatePostId() {
        return candidatePostId;
    }

    public void setCandidatePostId(String candidatePostId) {
        this.candidatePostId = candidatePostId;
    }

    public String getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(String interviewer) {
        this.interviewer = interviewer;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getTurntoPostId() {
        return turntoPostId;
    }

    public void setTurntoPostId(String turntoPostId) {
        this.turntoPostId = turntoPostId;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
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
        CandidateRecommend other = (CandidateRecommend) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCandidatePostId() == null ? other.getCandidatePostId() == null : this.getCandidatePostId().equals(other.getCandidatePostId()))
            && (this.getInterviewer() == null ? other.getInterviewer() == null : this.getInterviewer().equals(other.getInterviewer()))
            && (this.getResumeId() == null ? other.getResumeId() == null : this.getResumeId().equals(other.getResumeId()))
            && (this.getComments() == null ? other.getComments() == null : this.getComments().equals(other.getComments()))
            && (this.getFeedback() == null ? other.getFeedback() == null : this.getFeedback().equals(other.getFeedback()))
            && (this.getTurntoPostId() == null ? other.getTurntoPostId() == null : this.getTurntoPostId().equals(other.getTurntoPostId()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getFeedbackTime() == null ? other.getFeedbackTime() == null : this.getFeedbackTime().equals(other.getFeedbackTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCandidatePostId() == null) ? 0 : getCandidatePostId().hashCode());
        result = prime * result + ((getInterviewer() == null) ? 0 : getInterviewer().hashCode());
        result = prime * result + ((getResumeId() == null) ? 0 : getResumeId().hashCode());
        result = prime * result + ((getComments() == null) ? 0 : getComments().hashCode());
        result = prime * result + ((getFeedback() == null) ? 0 : getFeedback().hashCode());
        result = prime * result + ((getTurntoPostId() == null) ? 0 : getTurntoPostId().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getFeedbackTime() == null) ? 0 : getFeedbackTime().hashCode());
        return result;
    }
}