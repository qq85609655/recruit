package com.csot.gm.materialManage.dao.extension.gmPartDescRule;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

import com.csot.gm.materialManage.model.extension.gmPartDescRule.GmPartDescRuleExt;
import com.csot.gm.materialManage.model.extension.gmPartDescRule.GmPartDescRuleExtCriteria;

public interface GmPartDescRuleExtMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_DESC_RULE
   *
   * @mbggenerated
   */
  int countByExample(GmPartDescRuleExtCriteria example);
  
  List<GmPartDescRuleExt> selectByKeyCode(String keyCode);
}