package com.csot.recruit.model.extension.template;

import java.io.Serializable;

public class TemplateTypeExt implements Serializable {
    private String id;

    private String typeName;

    private String typt;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypt() {
        return typt;
    }

    public void setTypt(String typt) {
        this.typt = typt;
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
        TemplateTypeExt other = (TemplateTypeExt) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTypeName() == null ? other.getTypeName() == null : this.getTypeName().equals(other.getTypeName()))
            && (this.getTypt() == null ? other.getTypt() == null : this.getTypt().equals(other.getTypt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTypeName() == null) ? 0 : getTypeName().hashCode());
        result = prime * result + ((getTypt() == null) ? 0 : getTypt().hashCode());
        return result;
    }
}