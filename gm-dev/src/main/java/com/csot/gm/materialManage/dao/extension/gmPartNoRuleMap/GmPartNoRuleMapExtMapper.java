package com.csot.gm.materialManage.dao.extension.gmPartNoRuleMap;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

import com.csot.gm.materialManage.model.extension.gmPartNoRuleMap.GmPartNoRuleMapExtCriteria;
import com.csot.gm.materialManage.model.original.gmPartNoRuleMap.GmPartNoRuleMap;

public interface GmPartNoRuleMapExtMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_NO_RULE_MAP
   *
   * @mbggenerated
   */
  int countByExample(GmPartNoRuleMapExtCriteria example);
  
  List<GmPartNoRuleMap> selectByKeyCode(String keyCode);
}