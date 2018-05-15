package com.csot.recruit.common.util;

import java.util.HashMap;

import com.csot.recruit.model.resume.ResumesData;

public class SearchParam{

    private String keyword;

    private String type;
    private int page;
    private int pagesize;
    private String sort;
    private String order;
    private ResumesData resumesData;

    private HashMap<String, Object> mustFilter = new HashMap<String, Object>();

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void must(String name, Object value) {
        mustFilter.put(name, value);
    }

    public HashMap<String, Object> getMustFilter() {
        return mustFilter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

	public ResumesData getResumesData() {
		return resumesData;
	}

	public void setResumesData(ResumesData resumesData) {
		this.resumesData = resumesData;
	}

}
