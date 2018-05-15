package com.csot.recruit.dao.original.resumelibrary.addressbook;

import com.csot.recruit.model.original.resumelibrary.addressbook.Addressbook;
import com.csot.recruit.model.original.resumelibrary.addressbook.AddressbookCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface AddressbookMapper extends MyBatisBaseMapper {
    int countByExample(AddressbookCriteria example);

    int deleteByExample(AddressbookCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Addressbook record);

    int insertSelective(Addressbook record);

    List<Addressbook> selectByExample(AddressbookCriteria example);

    Addressbook selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Addressbook record, @Param("example") AddressbookCriteria example);

    int updateByExample(@Param("record") Addressbook record, @Param("example") AddressbookCriteria example);

    int updateByPrimaryKeySelective(Addressbook record);

    int updateByPrimaryKey(Addressbook record);
}