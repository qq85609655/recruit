package com.csot.recruit.service.impl.resume;

import org.springframework.stereotype.Service;

import com.csot.recruit.common.util.MappingField;
import com.csot.recruit.common.util.MappingObject;
import com.csot.recruit.common.util.SearchClient;
import com.csot.recruit.common.util.SearchService;

@Service
public class PositionSearchService extends SearchClient implements SearchService {
    public PositionSearchService() {
        this.indexName = "position";
    }

    @Override
    public MappingObject getMappingObject() {

        MappingObject mappingObject = new MappingObject();
        MappingField positionId = new MappingField("positionId", "string", 2.0, "index_ansj", "query_ansj");
        MappingField name = new MappingField("name", "string", 1.0, "index_ansj", "query_ansj");
        MappingField selectionStatus = new MappingField("selectionStatus", "string", 2.0, "index_ansj", "query_ansj");
        MappingField position = new MappingField("position", "string", 2.0, "index_ansj", "query_ansj");
        MappingField create_date = new MappingField("create_date", "date");
        MappingField age = new MappingField("age", "string");
        MappingField currentPosition = new MappingField("currentPosition", "string", true, 1.0, "index_ansj", "query_ansj");
        MappingField label = new MappingField("label", "string");
        MappingField company = new MappingField("company", "string");
        MappingField residence = new MappingField("residence", "string");
        MappingField highestEducation = new MappingField("highestEducation", "string");
		MappingField graduationSchool = new MappingField("graduationSchool", "string");
		MappingField experience = new MappingField("experience", "string");
        MappingField resumeOrigin = new MappingField("resumeOrigin", "string");
        MappingField salaryExpect = new MappingField("salaryExpect", "string");
        MappingField channel = new MappingField("channel", "string");
        MappingField professional = new MappingField("professional", "string");
        MappingField email = new MappingField("email", "string");
        MappingField currentIndustry = new MappingField("currentIndustry", "string");
        MappingField sex = new MappingField("sex", "string");
        MappingField industryExpect = new MappingField("industryExpect", "string");
        MappingField workplaceExpect = new MappingField("workplaceExpect", "string");
        mappingObject.addField(positionId);
        mappingObject.addField(name);
        mappingObject.addField(selectionStatus);
        mappingObject.addField(position);
        mappingObject.addField(create_date);
        mappingObject.addField(age);
        mappingObject.addField(currentPosition);
        mappingObject.addField(label);
        mappingObject.addField(company);
        mappingObject.addField(residence);
        mappingObject.addField(highestEducation);
		mappingObject.addField(graduationSchool);
		mappingObject.addField(experience);
        mappingObject.addField(resumeOrigin);
        mappingObject.addField(salaryExpect);
        mappingObject.addField(channel);
        mappingObject.addField(professional);
		mappingObject.addField(email);
		mappingObject.addField(currentIndustry);
        mappingObject.addField(sex);
        mappingObject.addField(industryExpect);
        mappingObject.addField(workplaceExpect);
        String[] excludes = new String[]{"file", "content"};
        mappingObject.setExcludes(excludes);
        return mappingObject;
    }

}
