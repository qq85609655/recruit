package com.csot.recruit.common.util;


public class MappingField {

    private String fieldName;

    private String type;

    private boolean store = false;

    private double boost = 1.0;

    private String index_analyzer = "index_ansj";

    private String search_analyzer = "query_ansj";

    public MappingField(String fieldName, String type, boolean store, double boost, String index_analyzer, String search_analyzer) {
        this.fieldName = fieldName;
        this.type = type;
        this.store = store;
        this.boost = boost;
        this.index_analyzer = index_analyzer;
        this.search_analyzer = search_analyzer;
    }

    public MappingField(String fieldName, String type, double boost, String index_analyzer, String search_analyzer) {
        this.fieldName = fieldName;
        this.type = type;
        this.boost = boost;
        this.index_analyzer = index_analyzer;
        this.search_analyzer = search_analyzer;
    }


    public MappingField(String fieldName, String type) {
        this.fieldName = fieldName;
        this.type = type;
    }

    public MappingField(String fieldName, String type, double boost) {
        this.fieldName = fieldName;
        this.type = type;
        this.boost = boost;
    }


    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStore() {
        return store;
    }

    public void setStore(boolean store) {
        this.store = store;
    }


    /**
     * @return the boost
     */
    public double getBoost() {
        return boost;
    }

    /**
     * @param boost the boost to set
     */
    public void setBoost(double boost) {
        this.boost = boost;
    }

    public String getIndex_analyzer() {
        return index_analyzer;
    }

    public void setIndex_analyzer(String index_analyzer) {
        this.index_analyzer = index_analyzer;
    }

    public String getSearch_analyzer() {
        return search_analyzer;
    }

    public void setSearch_analyzer(String search_analyzer) {
        this.search_analyzer = search_analyzer;
    }


}
