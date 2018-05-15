package com.csot.recruit.model.resume;

import java.io.Serializable;

public class ClassifyData implements Serializable {

    private String name;

    private Integer totalCount;

    private static final long serialVersionUID = 1L;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getTotalCount() {
      return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
      this.totalCount = totalCount;
    }

 
}