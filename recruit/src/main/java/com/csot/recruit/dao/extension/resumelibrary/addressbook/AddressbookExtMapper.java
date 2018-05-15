package com.csot.recruit.dao.extension.resumelibrary.addressbook;

import com.csot.recruit.model.extension.resumelibrary.addressbook.AddressbookExtCriteria;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface AddressbookExtMapper extends MyBatisBaseMapper {
    int countByExample(AddressbookExtCriteria example);
}