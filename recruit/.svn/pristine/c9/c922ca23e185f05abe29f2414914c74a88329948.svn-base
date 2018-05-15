package com.csot.recruit.dao.original.resume;

import com.csot.recruit.model.original.resume.Basicinfor;
import com.csot.recruit.model.original.resume.BasicinforCriteria;
import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface BasicinforMapper extends MyBatisBaseMapper {
    int countByExample(BasicinforCriteria example);

    int deleteByExample(BasicinforCriteria example);

    int deleteByPrimaryKey(String id);

    int insert(Basicinfor record);

    int insertSelective(Basicinfor record);

    List<Basicinfor> selectByExample(BasicinforCriteria example);

    Basicinfor selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Basicinfor record, @Param("example") BasicinforCriteria example);

    int updateByExample(@Param("record") Basicinfor record, @Param("example") BasicinforCriteria example);

    int updateByPrimaryKeySelective(Basicinfor record);

    int updateByPrimaryKey(Basicinfor record);
}