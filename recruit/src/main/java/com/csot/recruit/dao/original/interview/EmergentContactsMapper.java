package com.csot.recruit.dao.original.interview;

import com.csot.recruit.model.original.interview.EmergentContacts;
import com.csot.recruit.model.original.interview.EmergentContactsCriteria;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface EmergentContactsMapper extends MyBatisBaseMapper {
    int countByExample(EmergentContactsCriteria example);

    int deleteByExample(EmergentContactsCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(EmergentContacts record);

    int insertSelective(EmergentContacts record);

    List<EmergentContacts> selectByExample(EmergentContactsCriteria example);

    EmergentContacts selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") EmergentContacts record, @Param("example") EmergentContactsCriteria example);

    int updateByExample(@Param("record") EmergentContacts record, @Param("example") EmergentContactsCriteria example);

    int updateByPrimaryKeySelective(EmergentContacts record);

    int updateByPrimaryKey(EmergentContacts record);

    List<EmergentContacts> selectByPersonCode(String personCode);

}