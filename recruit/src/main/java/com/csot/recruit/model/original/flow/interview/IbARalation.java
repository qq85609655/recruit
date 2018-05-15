package com.csot.recruit.model.original.flow.interview;

import java.io.Serializable;

public class IbARalation implements Serializable {
    private String id;

    private String interviewBookId;

    private String attachmentId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInterviewBookId() {
        return interviewBookId;
    }

    public void setInterviewBookId(String interviewBookId) {
        this.interviewBookId = interviewBookId;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
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
        IbARalation other = (IbARalation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getInterviewBookId() == null ? other.getInterviewBookId() == null : this.getInterviewBookId().equals(other.getInterviewBookId()))
            && (this.getAttachmentId() == null ? other.getAttachmentId() == null : this.getAttachmentId().equals(other.getAttachmentId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getInterviewBookId() == null) ? 0 : getInterviewBookId().hashCode());
        result = prime * result + ((getAttachmentId() == null) ? 0 : getAttachmentId().hashCode());
        return result;
    }
}