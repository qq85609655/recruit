package com.csot.recruit.service.position;

import com.csot.recruit.model.position.DepartmentRequire;
import com.csot.recruit.model.position.DepartmentRequireCriteria;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface DepartmentRequireService {
    MiniRtn2Grid<DepartmentRequire> getGrid(MiniGridPageSort pageSort, String searchKey);

    DepartmentRequire getByPrimaryKey(String primaryKey);

    void create(DepartmentRequire departmentRequire);

    void updateSelective(DepartmentRequire departmentRequire);

    void remove(String primaryKey);
    
    /***
     * 根据职位id获取职位所需的部门对象
     * @param recruitPositionId 职位ID
     * @return
     */
    DepartmentRequire getByRecruitPositionId(String recruitPositionId);
    
    /***
     * 根据条件删除部门对象
     * @param example
     */
    void removeByExample(DepartmentRequireCriteria example);
}