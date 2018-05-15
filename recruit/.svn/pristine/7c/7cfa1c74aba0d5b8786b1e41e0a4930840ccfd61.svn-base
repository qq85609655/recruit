package com.csot.recruit.dao.original.flow.employ;

import com.csot.recruit.model.original.flow.employ.Remind;
import com.csot.recruit.model.original.flow.employ.RemindCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface RemindMapper extends MyBatisBaseMapper {
    int countByExample(RemindCriteria example);

    int deleteByExample(RemindCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Remind record);

    int insertSelective(Remind record);

    List<Remind> selectByExample(RemindCriteria example);

    Remind selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Remind record, @Param("example") RemindCriteria example);

    int updateByExample(@Param("record") Remind record, @Param("example") RemindCriteria example);

    int updateByPrimaryKeySelective(Remind record);

    int updateByPrimaryKey(Remind record);
}