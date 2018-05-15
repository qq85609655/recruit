package com.csot.recruit.model.resume;

import java.io.Serializable;

public class LanguageSkill implements Serializable {
   
    private String id;

    /** 语言    */
    private String languageName;

    /** 水平    */
    private String languageLevel;

    /** 口语水平    */
    private String oralLevel;
    
    private String resumeId;
    
    //用于展示数据时展示其对应的名称
    private String name;
    
    private String languageLevelName;
    
    private String oralLevelName;

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getLanguageLevelName() {
      return languageLevelName;
    }

    public void setLanguageLevelName(String languageLevelName) {
      this.languageLevelName = languageLevelName;
    }

    public String getOralLevelName() {
      return oralLevelName;
    }

    public void setOralLevelName(String oralLevelName) {
      this.oralLevelName = oralLevelName;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageLevel() {
        return languageLevel;
    }

    public void setLanguageLevel(String languageLevel) {
        this.languageLevel = languageLevel;
    }

    public String getOralLevel() {
        return oralLevel;
    }

    public void setOralLevel(String oralLevel) {
        this.oralLevel = oralLevel;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
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
        LanguageSkill other = (LanguageSkill) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLanguageName() == null ? other.getLanguageName() == null : this.getLanguageName().equals(other.getLanguageName()))
            && (this.getLanguageLevel() == null ? other.getLanguageLevel() == null : this.getLanguageLevel().equals(other.getLanguageLevel()))
            && (this.getOralLevel() == null ? other.getOralLevel() == null : this.getOralLevel().equals(other.getOralLevel()))
            && (this.getResumeId() == null ? other.getResumeId() == null : this.getResumeId().equals(other.getResumeId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getLanguageName() == null) ? 0 : getLanguageName().hashCode());
        result = prime * result + ((getLanguageLevel() == null) ? 0 : getLanguageLevel().hashCode());
        result = prime * result + ((getOralLevel() == null) ? 0 : getOralLevel().hashCode());
        result = prime * result + ((getResumeId() == null) ? 0 : getResumeId().hashCode());
        return result;
    }
}