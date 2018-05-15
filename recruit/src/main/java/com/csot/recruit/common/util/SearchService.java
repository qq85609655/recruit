package com.csot.recruit.common.util;

import java.util.Map;

public interface SearchService {
    /**
     * 删除索引
     */
    public void deleteIndexById(String id);

    /**
     * 创建索引
     *
     * @param id
     * @param source
     */
    public void createIndex(String id, Map<String, Object> source);

    /**
     * 更新索引
     *
     * @param id
     * @param source
     */
    public void updateIndex(String id, Map<String, Object> source);

    /**
     * 全部搜索
     *
     * @param keyword
     * @return
     */
    public SearchResult searchInAllIndices(SearchParam param);

    /**
     * 只在指定的Indices中搜索
     *
     * @param keyword
     * @return
     */
    public SearchResult searchInIndices(SearchParam param);

    /**
     * 在指定的Indices、 type中搜索
     *
     * @param keyword
     * @return
     */
    public SearchResult searchInIndicesType(SearchParam param);
}
