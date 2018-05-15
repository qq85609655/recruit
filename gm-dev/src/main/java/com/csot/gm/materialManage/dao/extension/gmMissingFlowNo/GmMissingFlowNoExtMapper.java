package com.csot.gm.materialManage.dao.extension.gmMissingFlowNo;

import java.util.List;

import com.csot.gm.materialManage.model.extension.gmMissingFlowNo.GmMissingFlowNoExtCriteria;
import com.csot.gm.materialManage.model.original.gmMissingFlowNo.GmMissingFlowNo;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface GmMissingFlowNoExtMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_MISSING_FLOW_NO
   *
   * @mbggenerated
   */
  int countByExample(GmMissingFlowNoExtCriteria example);
  
  List<GmMissingFlowNo> selectByKeyCode(String keyCode);
  
}