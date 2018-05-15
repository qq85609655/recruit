package com.csot.recruit.common.util;

import java.util.ArrayList;
import java.util.List;

public class MappingObject {

    private List<MappingField> fields = new ArrayList<MappingField>();

    private String[] excludes;

    public List<MappingField> getFields() {
        return fields;
    }

    public void setFields(List<MappingField> fields) {
        this.fields = fields;
    }

    public String[] getExcludes() {
        return excludes;
    }

    public void setExcludes(String[] excludes) {
        this.excludes = excludes;
    }

    public void addField(MappingField field) {

        fields.add(field);
    }
}
