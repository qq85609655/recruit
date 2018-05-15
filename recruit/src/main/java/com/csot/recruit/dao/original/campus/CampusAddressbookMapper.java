package com.csot.recruit.dao.original.campus;

import com.csot.recruit.model.original.campus.CampusAddressbook;
import com.csot.recruit.model.original.campus.CampusAddressbookCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface CampusAddressbookMapper extends MyBatisBaseMapper {
    int countByExample(CampusAddressbookCriteria example);

    int deleteByExample(CampusAddressbookCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(CampusAddressbook record);

    int insertSelective(CampusAddressbook record);

    List<CampusAddressbook> selectByExample(CampusAddressbookCriteria example);

    CampusAddressbook selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") CampusAddressbook record, @Param("example") CampusAddressbookCriteria example);

    int updateByExample(@Param("record") CampusAddressbook record, @Param("example") CampusAddressbookCriteria example);

    int updateByPrimaryKeySelective(CampusAddressbook record);

    int updateByPrimaryKey(CampusAddressbook record);
}