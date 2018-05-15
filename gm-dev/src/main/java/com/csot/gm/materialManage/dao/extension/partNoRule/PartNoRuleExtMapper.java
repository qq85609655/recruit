package com.csot.gm.materialManage.dao.extension.partNoRule;

import java.util.List;

import com.csot.gm.materialManage.model.extension.partNoRule.PartNoRuleExt;
import com.csot.gm.materialManage.model.extension.partNoRule.PartNoRuleExtCriteria;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface PartNoRuleExtMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_NO_RULE
   *
   * @mbggenerated
   */
  int countByExample(PartNoRuleExtCriteria example);
  
  List<PartNoRuleExt> selectByKeyCode(String keyCode);
}