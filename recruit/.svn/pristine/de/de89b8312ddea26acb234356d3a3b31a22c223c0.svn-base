package com.csot.recruit.dao.original.uniform;

import com.csot.recruit.model.original.uniform.Organization;
import com.csot.recruit.model.original.uniform.OrganizationCriteria;
import java.math.BigDecimal;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper extends MyBatisBaseMapper {
    int countByExample(OrganizationCriteria example);

    int deleteByExample(OrganizationCriteria example);

    int deleteByPrimaryKey(BigDecimal id);

    int insert(Organization record);

    int insertSelective(Organization record);

    List<Organization> selectByExample(OrganizationCriteria example);

    Organization selectByPrimaryKey(BigDecimal id);

    int updateByExampleSelective(@Param("record") Organization record, @Param("example") OrganizationCriteria example);

    int updateByExample(@Param("record") Organization record, @Param("example") OrganizationCriteria example);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
}