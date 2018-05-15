package com.csot.recruit.common.util;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;







import jodd.util.StringUtil;

import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.count.CountRequestBuilder;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.FilterBuilders;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.highlight.HighlightField;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;


//public abstract class SearchClient implements InitializingBean {
  public abstract class SearchClient{

    protected String indexName;

    protected String type;

    public static final int DEFAULT_PAGE_SIZE = 15;

    private static final Logger logger = LoggerFactory
            .getLogger(SearchClient.class);

    private ElasticSearchConfig elasticSearchConfig = new ElasticSearchConfig();

    public TransportClient getClient() {
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("client.transport.sniff", true).put("client", true)
                .put("data", false)
                .put("clusterName", elasticSearchConfig.getClusterName())
                .build();
        List<NetAddress> addresses = elasticSearchConfig.getAddressesList();
        TransportClient client = new TransportClient(settings);
        if (addresses == null || addresses.size() == 0) {
            logger.error("elasticsearch 配置文件错误");
            throw new RuntimeException("elasticsearch 配置文件错误");
        } else {
            for (NetAddress address : addresses) {
                client.addTransportAddress(new InetSocketTransportAddress(
                        address.getHostName(), address.getPort()));
            }
        }
        return client;
    }

    private void init() {

        Client client = getClient();
        try {
            type = elasticSearchConfig.getType();
            if (!isMappingExist(indexName, client)) {
                createMapping(client);
            }
        } finally {
            client.close();
        }

    }

    public boolean indexIsExists(String id) {
        Client client = getClient();
        GetResponse response = client.prepareGet(this.indexName, this.type, id)
                .execute().actionGet();
        boolean isExists = response.isExists();
        client.close();
        return isExists;
    }

    public void deleteIndexById(String id) {
        Client client = getClient();
        DeleteResponse response = client
                .prepareDelete(this.indexName, this.type, id).execute()
                .actionGet();
        client.close();
    }

    public void createIndex(String id, Map<String, Object> source) {
        Client client = getClient();
        if (!indexIsExists(id)) {
            client.prepareIndex(this.indexName, type, id).setSource(source)
                    .execute().actionGet();
        }
        client.close();
    }


    public void updateIndex(String id, Map<String, Object> source) {
        Client client = getClient();
        UpdateResponse response = client
                .prepareUpdate(this.indexName, type, id).setDoc(source)
                .execute().actionGet();
        client.close();
    }

    public SearchResult searchInAllIndices(SearchParam param) {
        Client client = getClient();
        CountRequestBuilder countRequestBuilder = client.prepareCount();
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch();
        return query(client, countRequestBuilder, searchRequestBuilder, param);
    }

    public SearchResult searchInIndices(SearchParam param) {
        Client client = getClient();
        CountRequestBuilder countRequestBuilder = client
                .prepareCount(this.indexName);
        SearchRequestBuilder searchRequestBuilder = client
                .prepareSearch(this.indexName);
        ;
        return query(client, countRequestBuilder, searchRequestBuilder, param);
    }

    public SearchResult searchInIndicesType(SearchParam param) {
        Client client = getClient();
        CountRequestBuilder countRequestBuilder = client.prepareCount(
                this.indexName).setTypes(this.type);
        SearchRequestBuilder searchRequestBuilder = client.prepareSearch(
                this.indexName).setTypes(this.type);
        return query(client, countRequestBuilder, searchRequestBuilder, param);
    }
    
    @SuppressWarnings("deprecation")
	private SearchResult query(Client client,
                               CountRequestBuilder countRequestBuilder,
                               SearchRequestBuilder searchRequestBuilder, SearchParam param) {

        int page = param.getPage() <= 0 ? 1 : param.getPage();
        int pagesize = param.getPagesize() <= 0 ? DEFAULT_PAGE_SIZE : param
                .getPagesize();

        SearchResult result = new SearchResult();
        BoolQueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.queryString(formatString(param.getResumesData().getKeyword())));
        if(null != param.getResumesData().getName() && !param.getResumesData().getName().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("name", param.getResumesData().getName().toLowerCase())));
        }
        if(null != param.getResumesData().getUpdateDate()){
        	query = query.must((QueryBuilders.matchPhraseQuery("create_date", param.getResumesData().getUpdateDate())));
        }
        if(null != param.getResumesData().getCurrentPosition() && !param.getResumesData().getCurrentPosition().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("currentPosition", param.getResumesData().getCurrentPosition().toLowerCase())));
        }
        if(null != param.getResumesData().getCompany() && !param.getResumesData().getCompany().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("company", param.getResumesData().getCompany().toLowerCase())));
        }
        if(null != param.getResumesData().getHighestEducation() && !param.getResumesData().getHighestEducation().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("highestEducation", param.getResumesData().getHighestEducation().toLowerCase())));
        }
        if(null != param.getResumesData().getLabel() && !param.getResumesData().getLabel().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("label", param.getResumesData().getLabel().toLowerCase())));
        }
        if(null != param.getResumesData().getProfessional() && !param.getResumesData().getProfessional().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("professional", param.getResumesData().getProfessional().toLowerCase())));
        }
        //工作经验
        /*if(null != param.getResumesData().getLowerExperience() && !param.getResumesData().getLowerExperience().equals("")){
        	query = query.must((QueryBuilders.termQuery("experience", param.getResumesData().getLowerExperience())));
        }
        if(null != param.getResumesData().getUpperExperience() && !param.getResumesData().getUpperExperience().equals("")){
        	query = query.must((QueryBuilders.termQuery("experience", param.getResumesData().getUpperExperience())));
        }*/
        if(null != param.getResumesData().getChannel() && !param.getResumesData().getChannel().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("channel", param.getResumesData().getChannel().toLowerCase())));
        }
        if(null != param.getResumesData().getEmail() && !param.getResumesData().getEmail().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("email", param.getResumesData().getEmail().toLowerCase())));
        }
        if(null != param.getResumesData().getCurrentIndustry() && !param.getResumesData().getCurrentIndustry().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("currentIndustry", param.getResumesData().getCurrentIndustry().toLowerCase())));
        }
        if(null != param.getResumesData().getResidence() && !param.getResumesData().getResidence().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("residence", param.getResumesData().getResidence().toLowerCase())));
        }
        if(null != param.getResumesData().getGraduationSchool() && !param.getResumesData().getGraduationSchool().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("graduationSchool", param.getResumesData().getGraduationSchool().toLowerCase())));
        }
        //年龄
        /*if(null != param.getResumesData().getLowerAge() && !param.getResumesData().getLowerAge().equals("")){
        	query = query.must((QueryBuilders.termQuery("age", param.getResumesData().getLowerAge())));
        }
        if(null != param.getResumesData().getUpperAge() && !param.getResumesData().getUpperAge().equals("")){
        	query = query.must((QueryBuilders.termQuery("age", param.getResumesData().getUpperAge())));
        }*/
        if(null != param.getResumesData().getPostExpect() && !param.getResumesData().getPostExpect().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("postExpect", param.getResumesData().getPostExpect().toLowerCase())));
        }
        if(null != param.getResumesData().getSex() && !param.getResumesData().getSex().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("sex", param.getResumesData().getSex().toLowerCase())));
        }
        if(null != param.getResumesData().getIndustryExpect() && !param.getResumesData().getIndustryExpect().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("industryExpect", param.getResumesData().getIndustryExpect().toLowerCase())));
        }
        //更新时间
        /*if(null != param.getResumesData().getLowerUpdateDate() && !param.getResumesData().getLowerUpdateDate().equals("")){
        	query = query.must((QueryBuilders.termQuery("create_date", param.getResumesData().getLowerUpdateDate())));
        }
        if(null != param.getResumesData().getUpperUpdateDate() && !param.getResumesData().getUpperUpdateDate().equals("")){
        	query = query.must((QueryBuilders.termQuery("create_date", param.getResumesData().getUpperUpdateDate())));
        }*/
        if(null != param.getResumesData().getWorkplaceExpect() && !param.getResumesData().getWorkplaceExpect().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("workplaceExpect", param.getResumesData().getWorkplaceExpect().toLowerCase())));
        }
        if(null != param.getResumesData().getSalaryExpect() && !param.getResumesData().getSalaryExpect().equals("")){
        	query = query.must((QueryBuilders.matchPhraseQuery("salaryExpect", param.getResumesData().getSalaryExpect().toLowerCase())));
        }
        countRequestBuilder.setQuery(query);
        Long hitCount = countRequestBuilder.execute().actionGet().getCount();
        searchRequestBuilder.setQuery(query).setFrom((page - 1) * pagesize)
                .setSize(pagesize)
                .addHighlightedField("name")
                .addHighlightedField("selectionStatus")
                .addHighlightedField("position")
                .addHighlightedField("age")
                .addHighlightedField("create_date")
                .addHighlightedField("age")
                .addHighlightedField("currentPosition")
                .addHighlightedField("label")
                .addHighlightedField("company")
                .addHighlightedField("residence")
                .addHighlightedField("highestEducation")
                .addHighlightedField("graduationSchool")
                .addHighlightedField("experience")
                .addHighlightedField("resumeOrigin")
                .addHighlightedField("salaryExpect")
                .addHighlightedField("channel")
                .addHighlightedField("professional")
                .addHighlightedField("email")
                .addHighlightedField("currentIndustry")
                .addHighlightedField("sex")
                .addHighlightedField("industryExpect")
                .addHighlightedField("workplaceExpect")
                /*.setHighlighterPreTags("{{$km$}}").setHighlighterPostTags("{{/$km$}}")*/;
        String sort = param.getSort();
        if (!StringUtil.isEmpty(sort)) {
            String order = param.getOrder();
            if (order != null && order.equals("desc")) {

                searchRequestBuilder.addSort(new FieldSortBuilder(sort)
                        .order(SortOrder.DESC));
            } else {

                searchRequestBuilder.addSort(new FieldSortBuilder(sort)
                        .order(SortOrder.ASC));
            }
        }

        SearchResponse search = searchRequestBuilder.execute().actionGet();
        SearchHits hits = search.getHits();

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (SearchHit hit : hits.hits()) {
            String fileContent = "";
            Map<String, HighlightField> hlsMap = hit.getHighlightFields();
           /* HighlightField hlf = hlsMap.get("file");
            if (hlf != null && hlf.getFragments() != null) {
                Text[] txs = hlf.getFragments();
                for (Text tx : txs) {
                    fileContent = StringUtil.join(fileContent, tx.string()).replaceAll("<", " &lt;").replaceAll(">", " &gt;");
                }
            }*/
            //姓名
            String name = "";
            HighlightField nameHlf = hlsMap.get("name");
            if (nameHlf != null && nameHlf.getFragments() != null) {
                Text[] txsd = nameHlf.getFragments();
                for (Text txd : txsd) {
                	name = StringUtil.join(name, txd.string());
                }
            }
            //甄选状态
            String selectionStatus = "";
            HighlightField selectionStatusHlf = hlsMap.get("selectionStatus");
            if (selectionStatusHlf != null && selectionStatusHlf.getFragments() != null) {
                Text[] txsd = selectionStatusHlf.getFragments();
                for (Text txd : txsd) {
                	selectionStatus = StringUtil.join(selectionStatus, txd.string());
                }
            }
            //职位
            String position = "";
            HighlightField positionHlf = hlsMap.get("position");
            if (positionHlf != null && positionHlf.getFragments() != null) {
                Text[] txsd = positionHlf.getFragments();
                for (Text txd : txsd) {
                	position = StringUtil.join(position, txd.string());
                }
            }
            //更新时间
            String createDate = "";
            HighlightField createDateHlf = hlsMap.get("create_date");
            if (createDateHlf != null && createDateHlf.getFragments() != null) {
                Text[] txsd = createDateHlf.getFragments();
                for (Text txd : txsd) {
                	createDate = StringUtil.join(createDate, txd.string());
                }
            }
            //年龄
            String age = "";
            HighlightField ageHlf = hlsMap.get("age");
            if (ageHlf != null && ageHlf.getFragments() != null) {
                Text[] txsd = ageHlf.getFragments();
                for (Text txd : txsd) {
                	age = StringUtil.join(age, txd.string());
                }
            }
            //职位或岗位
            String currentPosition = "";
            HighlightField currentPositionHlf = hlsMap.get("currentPosition");
            if (currentPositionHlf != null && currentPositionHlf.getFragments() != null) {
                Text[] txsd = currentPositionHlf.getFragments();
                for (Text txd : txsd) {
                	currentPosition = StringUtil.join(currentPosition, txd.string());
                }
            }
            //标签
            String label = "";
            HighlightField labelHlf = hlsMap.get("label");
            if (labelHlf != null && labelHlf.getFragments() != null) {
                Text[] txsd = labelHlf.getFragments();
                for (Text txd : txsd) {
                	label = StringUtil.join(label, txd.string());
                }
            }
            //就职公司
            String company = "";
            HighlightField companyHlf = hlsMap.get("company");
            if (companyHlf != null && companyHlf.getFragments() != null) {
                Text[] txsd = companyHlf.getFragments();
                for (Text txd : txsd) {
                	company = StringUtil.join(company, txd.string());
                }
            }
            //当前所在地
            String residence = "";
            HighlightField residenceHlf = hlsMap.get("residence");
            if (residenceHlf != null && residenceHlf.getFragments() != null) {
                Text[] txsd = residenceHlf.getFragments();
                for (Text txd : txsd) {
                	residence = StringUtil.join(residence, txd.string());
                }
            }
            //学历
            String highestEducation = "";
            HighlightField highestEducationHlf = hlsMap.get("highestEducation");
            if (highestEducationHlf != null && highestEducationHlf.getFragments() != null) {
                Text[] txsd = highestEducationHlf.getFragments();
                for (Text txd : txsd) {
                	highestEducation = StringUtil.join(highestEducation, txd.string());
                }
            }
            //毕业学校
            String graduationSchool = "";
            HighlightField graduationSchoolHlf = hlsMap.get("graduationSchool");
            if (graduationSchoolHlf != null && graduationSchoolHlf.getFragments() != null) {
                Text[] txsd = graduationSchoolHlf.getFragments();
                for (Text txd : txsd) {
                	graduationSchool = StringUtil.join(graduationSchool, txd.string());
                }
            }
            //工作经验
            String experience = "";
            HighlightField experienceHlf = hlsMap.get("experience");
            if (experienceHlf != null && experienceHlf.getFragments() != null) {
                Text[] txsd = experienceHlf.getFragments();
                for (Text txd : txsd) {
                	experience = StringUtil.join(experience, txd.string());
                }
            }
            //简历来源
            String resumeOrigin = "";
            HighlightField resumeOriginHlf = hlsMap.get("resumeOrigin");
            if (resumeOriginHlf != null && resumeOriginHlf.getFragments() != null) {
                Text[] txsd = resumeOriginHlf.getFragments();
                for (Text txd : txsd) {
                	resumeOrigin = StringUtil.join(resumeOrigin, txd.string());
                }
            }
            //期望薪资
            String salaryExpect = "";
            HighlightField salaryExpectHlf = hlsMap.get("salaryExpect");
            if (salaryExpectHlf != null && salaryExpectHlf.getFragments() != null) {
                Text[] txsd = salaryExpectHlf.getFragments();
                for (Text txd : txsd) {
                	salaryExpect = StringUtil.join(salaryExpect, txd.string());
                }
            }
            //招聘渠道
            String channel = "";
            HighlightField channelHlf = hlsMap.get("channel");
            if (channelHlf != null && channelHlf.getFragments() != null) {
                Text[] txsd = channelHlf.getFragments();
                for (Text txd : txsd) {
                	channel = StringUtil.join(channel, txd.string());
                }
            }
            //专业
            String professional = "";
            HighlightField professionalHlf = hlsMap.get("professional");
            if (professionalHlf != null && professionalHlf.getFragments() != null) {
                Text[] txsd = professionalHlf.getFragments();
                for (Text txd : txsd) {
                	professional = StringUtil.join(professional, txd.string());
                }
            }
            //邮箱
            String email = "";
            HighlightField emailHlf = hlsMap.get("email");
            if (emailHlf != null && emailHlf.getFragments() != null) {
                Text[] txsd = emailHlf.getFragments();
                for (Text txd : txsd) {
                	email = StringUtil.join(email, txd.string());
                }
            }
            //当前行业
            String currentIndustry = "";
            HighlightField currentIndustryHlf = hlsMap.get("currentIndustry");
            if (currentIndustryHlf != null && currentIndustryHlf.getFragments() != null) {
                Text[] txsd = currentIndustryHlf.getFragments();
                for (Text txd : txsd) {
                	currentIndustry = StringUtil.join(currentIndustry, txd.string());
                }
            }
            //性别
            String sex = "";
            HighlightField sexHlf = hlsMap.get("sex");
            if (sexHlf != null && sexHlf.getFragments() != null) {
                Text[] txsd = sexHlf.getFragments();
                for (Text txd : txsd) {
                	sex = StringUtil.join(sex, txd.string());
                }
            }
            //意向行业
            String industryExpect = "";
            HighlightField industryExpectHlf = hlsMap.get("industryExpect");
            if (industryExpectHlf != null && industryExpectHlf.getFragments() != null) {
                Text[] txsd = industryExpectHlf.getFragments();
                for (Text txd : txsd) {
                	industryExpect = StringUtil.join(industryExpect, txd.string());
                }
            }
            //意向工作地
            String workplaceExpect = "";
            HighlightField workplaceExpectHlf = hlsMap.get("workplaceExpect");
            if (workplaceExpectHlf != null && workplaceExpectHlf.getFragments() != null) {
                Text[] txsd = workplaceExpectHlf.getFragments();
                for (Text txd : txsd) {
                	workplaceExpect = StringUtil.join(workplaceExpect, txd.string());
                }
            }
            
            Map<String, Object> maps = hit.getSource();
            maps.put("name", name);
            maps.put("selectionStatus", selectionStatus);
            maps.put("position", position);
            maps.put("create_date", createDate);
            maps.put("age", age);
            maps.put("currentPosition", currentPosition);
            maps.put("label", label);
            maps.put("company", company);
            maps.put("residence", residence);
            maps.put("highestEducation", highestEducation);
            maps.put("graduationSchool", graduationSchool);
            maps.put("experience", experience);
            maps.put("resumeOrigin", resumeOrigin);
            maps.put("salaryExpect", salaryExpect);
            maps.put("channel", channel);
            maps.put("professional", professional);
            maps.put("email", email);
            maps.put("currentIndustry", currentIndustry);
            maps.put("sex", sex);
            maps.put("industryExpect", industryExpect);
            maps.put("workplaceExpect", workplaceExpect);
            list.add(maps);
        }
        result.setTotal(hitCount);
        result.setResult(list);
        client.close();
        return result;
    }

    private void createMapping(Client client) {

        client.admin().indices().prepareCreate(indexName)
                .addMapping(type, build()).execute().actionGet();
    }

    private XContentBuilder build() {
        XContentBuilder map = null;
        MappingObject mappingObject = getMappingObject();
        try {
            map = jsonBuilder().startObject().startObject(type);
            if (mappingObject.getExcludes() != null) {

                map.startObject("_source")
                        .field("excludes", mappingObject.getExcludes())
                        .endObject();
            }
            map.startObject("properties");
            for (MappingField field : mappingObject.getFields()) {

                map.startObject(field.getFieldName()).field("type",
                        field.getType());

                if (field.getType().equals("attachment")) {
                    map.startObject("fields").startObject(field.getFieldName())
                            .field("term_vector", "with_positions_offsets")
                            .field("store", "yes").endObject().endObject();
                } else {
                    if (field.isStore()) {
                        map.field("store", "yes");
                    }
                    if (field.getType().equals("date")) {
                        map.field("format", "dateOptionalTime");
                    }
                    if (field.getBoost() != 1.0) {
                        map.field("boost", field.getBoost());
                    }
                    if (!StringUtil.equals(field.getIndex_analyzer(), "index_ansj")) {
                        map.field("index_analyzer", field.getIndex_analyzer());
                    }
                    if (!StringUtil.equals(field.getSearch_analyzer(), "query_ansj")) {
                        map.field("search_analyzer", field.getSearch_analyzer());
                    }
                }
                map.endObject();
            }
            map.endObject().endObject().endObject();
        } catch (IOException e) {
            logger.error("IOException:{}",e);
        }

        return map;
    }

    /**
     * 获取分词
     *
     * @param keyword
     * @return
     */
    public List<AnalyzeResponse.AnalyzeToken> getTokens(String keyword) {
        AnalyzeResponse analyzeResponse = getClient().admin().indices()
                .prepareAnalyze(this.indexName, keyword).setAnalyzer("query_ansj")
                .execute().actionGet();
        return analyzeResponse.getTokens();
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        try {
//            init();
//        } catch (Exception e) {
//            logger.error("start error", e);
//        }
//    }

    public boolean isMappingExist(String indexName, Client client) {
        IndicesExistsResponse response = client.admin().indices().prepareExists(indexName).execute().actionGet();
        return response.isExists();

    }

    public abstract MappingObject getMappingObject();
    
    public String formatString(String value){
    	return"\""+value+"\"";
    }

}