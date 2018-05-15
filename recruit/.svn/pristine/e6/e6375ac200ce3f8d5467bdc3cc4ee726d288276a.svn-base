package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.ClassifyData;
import com.csot.recruit.model.resume.PositionSearch;
import com.csot.recruit.model.resume.ResumesData;

import java.util.List;
import java.util.Map;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface MyResumeRepositoryMapper extends MyBatisBaseMapper {

  /**
   * 根据ID查询ResumesData
   * @param id
   * @return
   */
   ResumesData queryResumesDataById(String id);
  
  /***
   * 简历库
   * @param map 查询属性和分页属性
   * @return
   */
  List<ResumesData> queryResumesDataByPage(Map<String,Object>map);

    /***
     * 根据条件查询满足条件的记录数
     * @param map
     * @return
     */
  Integer countResumesData(Map<String,Object>map);
  
  /**
   * 分类查询职位信息
   * @param map
   * @return
   */
  List<ClassifyData> queryClassifyByPosition(Map<String,Object>map);
  
  /**
   * 分类查询毕业学校
   * @param map
   * @return
   */
  List<ClassifyData> queryClassifyGraduationSchool(Map<String,Object>map);
  
  /**
   * 分类查询最高学历
   * @param map
   * @return
   */
  List<ClassifyData> queryClassifyHighestEducation(Map<String,Object>map);
  
  /**
   * 当前所在地
   * @param map
   * @return
   */
  List<ClassifyData> queryClassifyResidencer(Map<String,Object>map);
  
  /**
   * 分类查询简历来源
   * @param map
   * @return
   */
  List<ClassifyData>  queryClassifyChannel(Map<String,Object>map);
  
  /**
   * 分类查询标签
   */
  List<ClassifyData>  queryClassifyLabel (Map<String,Object>map);
  
  /***
   * 添加人才库索引
   * @param positionId 人才库id
   */
  void insertPositionSearch(String positionId);
  
  /***
   * 查询要建立索引的人才库id
   * @return
   */
  List<PositionSearch> querySearchPosition();
  
  /***
   * 查询要建立索引的人才库id是否已创建
   * @param positionId
   * @return
   */
  int querySearchPositionById(String positionId);
  
  /***
   * 更改已建立索引的人才库状态
   * @param positionId企业人才库id
   */
  void updatePositionIsSearch(String positionId);
  
  /***
   * 如果调用创建索引失败则 isSearch++
   * @param positionId 人才库id
   */
  void updatePositionAddIsSearch(String positionId);
  
  /***
   * 查询简历人才库所有数据(不带分页)
   * @return
   */
  List<ResumesData> queryResumesData();
}