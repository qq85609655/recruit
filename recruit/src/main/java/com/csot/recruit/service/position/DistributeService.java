package com.csot.recruit.service.position;

import java.util.List;

import com.csot.recruit.model.position.Distribute;
import com.csot.recruit.model.position.DistributeCriteria;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface DistributeService {
    MiniRtn2Grid<Distribute> getGrid(MiniGridPageSort pageSort, String searchKey);

    Distribute getByPrimaryKey(String primaryKey);

    void create(Distribute distribute);

    void updateSelective(Distribute distribute);

    void remove(String primaryKey);
    
    /***
     * 鏍规嵁鏉′欢鍒犻櫎鑱屼綅鍒嗗彂璁板綍
     * @param criteria
     */
    void removeByExample(DistributeCriteria criteria);
    
    /***
     * 根据条件查询分发对象
     * @param criteria 分发条件对象
     * @return
     */
    List<Distribute> getByExample(DistributeCriteria criteria);
}