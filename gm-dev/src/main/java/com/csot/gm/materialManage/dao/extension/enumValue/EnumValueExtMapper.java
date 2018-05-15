package com.csot.gm.materialManage.dao.extension.enumValue;

import java.util.List;

import com.csot.gm.materialManage.model.extension.enumValue.EnumValueExt;
import com.csot.gm.materialManage.model.extension.enumValue.EnumValueExtCriteria;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EnumValueExtMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator. This method corresponds to the database table
   * T_GM_ENUM_VALUE
   *
   * @mbggenerated
   */
  int countByExample(EnumValueExtCriteria example);

  List<EnumValueExt> getEnumValueByType(String enumType);

  int deleteEnumValueByType(String enumType);

  List<EnumValueExt> getByTypeIdAndEnumText(@Param("enumTypeId") String enumTypeId,
      @Param("enumText") String enumText);

  List<EnumValueExt> getByLikeEnumText(String enumText);

  List<EnumValueExt> getByLikeEnumTextAndValue(String enumText);

  List<EnumValueExt> getEnumTextAndValueByBrandSpec(String brandValue, String specValue);

  List<EnumValueExt> getByTypeIdAndEnumValue(@Param("enumTypeId") String enumTypeId,
      @Param("enumValue") String enumValue);

  List<EnumValueExt> getByTypeIdAndEnumValueLike(@Param("enumTypeId") String enumTypeId,
      @Param("enumValue") String enumValue);
  
  List<EnumValueExt> getByEnumButId(@Param("enumValue") String enumValue, @Param("enumText") String enumText,
      @Param("enumValueId") String enumValueId);
}
