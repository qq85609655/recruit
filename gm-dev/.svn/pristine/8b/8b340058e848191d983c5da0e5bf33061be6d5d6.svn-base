package com.csot.gm.materialManage.dao.extension.document;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

import com.csot.gm.materialManage.model.extension.document.File;

public interface FileMapper extends MyBatisBaseMapper {
  /**
   * 获得所有的文档记录
   * 
   * @return
   */
  List<File> getAllFile();

  /**
   * 添加文档记录
   * 
   * @param file
   * @return
   */
  int addFileToDb(File file);

  /**
   * 通过Id获取文件记录
   * 
   * @param id
   * @return
   */
  File getFileById(String id);

  /**
   * 通过fileName获取文件记录
   * 
   * @param fileName
   * @return
   */
  List<File> getFileByName(String fileName);

  /**
   * 删除相应的文件记录
   * 
   * @param id
   * @return
   */
  int deleteFileById(String id);

  /**
   * 根据文件文件记录数
   * 
   * @param fileName
   * @return
   */
  int countRecordByFileName(String fileName);

}
