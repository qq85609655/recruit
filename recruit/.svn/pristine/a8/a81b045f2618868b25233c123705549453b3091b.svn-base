package com.csot.recruit.service.resume;

import java.util.List;
import java.util.Map;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;

import com.csot.recruit.common.util.Result;
import com.csot.recruit.model.resume.PositionSearch;
import com.csot.recruit.model.resume.ResumesData;
import com.csot.recruit.model.vo.ResumeDataVo;

public interface MyResumeRepositoryService {
  /**
   * 分页查询简历相关信息
   * @param page
   * @param resumesData
   * @return
   */
  MiniRtn2Grid<ResumesData> queryResumeRepositoryListByPage(MiniGridPageSort page, ResumesData resumesData);
  
  /**
   * 查询简历相关的分类信息
   * @param resumesData
   * @return
   */
  Map<String,Object> queryClassifyByPosition(ResumesData resumesData);


  /**
   * 添加简历
   * @param resume
   * @param skillList
   * @param workExperienceList
   * @param educationExperienceList
   * @param resumeLanguageList
   */
 String createResumeAndRelate(ResumesData resumesData) ;
  
 /**
  * 根据ID查询简历相关信息
  * @param id
  * @return
  */
  ResumesData queryResumesDataById(String id);
  
  /**
   * 创建或更新索引
   *
   * @param positionId 企业人才库id
   * @param operationType 操作类型(0表示创建索引，1表示更新索引)
   * @return
   */
  Result createIndexImpl(String positionId, int operationType);
  
  /***
   * 删除索引
   * @param positionId 企业人才库id
   * @throws Exception
   */
  void deleteIndex(String positionId) throws Exception;
  
  /***
   * 查询要建立索引的人才库id
   * @return
   */
  List<PositionSearch> querySearchPosition();
  
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

  String saveOrUpdateResume(ResumeDataVo resumeDataVo,SysUser sysUser);
  
}