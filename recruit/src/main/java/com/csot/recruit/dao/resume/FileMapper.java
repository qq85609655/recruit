package com.csot.recruit.dao.resume;

import com.csot.recruit.model.resume.File;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface FileMapper extends MyBatisBaseMapper {
  /**
   * 获得所有的标准文档
   * @return
   */
  List<File> getAllFile();
  
  /**
   * 添加标准文档
   */
  int addFileToDb(File file);
  
  
  /**
   * 获取文件名称
   * @return
   */
  String getFileName(String id);
  
  /**
   * 删除相应的文件记录
   * @param id
   * @return
   */
  int deleteFileById(String id);
  
  /**
   * 根据文件文件记录数
   * @param fileName
   * @return
   */
  int countRecordByFileName(String fileName);

}