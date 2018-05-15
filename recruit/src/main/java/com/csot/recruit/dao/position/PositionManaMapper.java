package com.csot.recruit.dao.position;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

import com.csot.recruit.model.position.PositionDistributeRecords;
import com.csot.recruit.model.position.PositionMana;

public interface PositionManaMapper extends MyBatisBaseMapper  {

	/***
     * 职位管理
     * @param pageSort 分页对象
     * @param positionMana 查询条件对象
     * @return
     */
	List<PositionMana> queryPositionManaList(PositionMana positionMana);
	
	/***
     * 职位管理
     * @param map 查询属性和分页属性
     * @return
     */
	List<PositionMana> queryPositionManaListByPage(Map<String, Object> map);
	
	/***
	 * 职位管理总个数
	 * @param positionMana
	 * @return
	 */
	int countPositionMana(PositionMana positionMana);
	
	/***
     * 职位分发
     * @param map 查询属性和分页属性
     * @return
     */
	List<PositionDistributeRecords> queryPositionDistributeListByPage(Map<String, Object> map);
	
	/***
	 * 职位分发总个数
	 * @param positionMana
	 * @return
	 */
	int countPositionDistribute(PositionDistributeRecords positionDistribute);
}
