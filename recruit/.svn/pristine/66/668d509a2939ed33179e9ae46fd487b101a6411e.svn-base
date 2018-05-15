package com.csot.recruit.model.original.resume;

import java.io.Serializable;

public class LabelRalation implements Serializable {
    private String id;

    private String labelIds;

    private String reservseId;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabelIds() {
        return labelIds;
    }

    public void setLabelIds(String labelIds) {
        this.labelIds = labelIds;
    }

    public String getReservseId() {
        return reservseId;
    }

    public void setReservseId(String reservseId) {
        this.reservseId = reservseId;
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
        LabelRalation other = (LabelRalation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLabelIds() == null ? other.getLabelIds() == null : this.getLabelIds().equals(other.getLabelIds()))
            && (this.getReservseId() == null ? other.getReservseId() == null : this.getReservseId().equals(other.getReservseId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLabelIds() == null) ? 0 : getLabelIds().hashCode());
        result = prime * result + ((getReservseId() == null) ? 0 : getReservseId().hashCode());
        return result;
    }
}