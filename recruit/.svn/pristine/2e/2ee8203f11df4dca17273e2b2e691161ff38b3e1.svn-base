package com.csot.recruit.service.position;

import com.csot.recruit.model.position.RecruitInfor;
import com.csot.recruit.model.position.RecruitInforCriteria;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface RecruitInforService {
    MiniRtn2Grid<RecruitInfor> getGrid(MiniGridPageSort pageSort, String searchKey);

    RecruitInfor getByPrimaryKey(String primaryKey);

    void create(RecruitInfor recruitInfor);

    void updateSelective(RecruitInfor recruitInfor);

    void remove(String primaryKey);
    
    /***
	 * 根据条件删除职位的招聘信息
	 * @param criteria
	 */
	void removeByExample(RecruitInforCriteria criteria);
}