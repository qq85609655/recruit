package com.csot.gm.materialManage.dao.extension.partType;

import java.util.List;

import com.csot.gm.materialManage.model.extension.partType.PartTypeExt;
import com.csot.gm.materialManage.model.extension.partType.PartTypeExtCriteria;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface PartTypeExtMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_PART_TYPE
   *
   * @mbggenerated
   */
  int countByExample(PartTypeExtCriteria example);
  
  List<PartTypeExt> getPartTypeByRealName(String realName);
}