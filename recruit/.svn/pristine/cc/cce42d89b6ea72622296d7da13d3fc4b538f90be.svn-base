package com.csot.recruit.service.resume;

import java.util.List;
import java.util.Map;

import com.csot.recruit.model.resume.Label;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface LabelService {
    MiniRtn2Grid<Label> getGrid(MiniGridPageSort pageSort, String searchKey);

    Label getByPrimaryKey(String primaryKey);

    void create(Label label);

    void updateSelective(Label label);

    void remove(String primaryKey);
    
    List<Label> getLabelList();
    
    /***
     * 根据条件查询类别是否存在
     * @param label
     * @return
     */
    int getLabelCount(Label label);
    
    /**
     * 根据labelId获取 
     * @param labels labelId的数组
     * @param sign 标识符，0代表获取（id，name）的map，1代表获取(name,id)的map
     * @return
     */
    Map<String,Object> getLabelListByIds(List<String> labels);
    
    Map<String,Object> getLabelListByLabelNames(List<String> labelNames);
}