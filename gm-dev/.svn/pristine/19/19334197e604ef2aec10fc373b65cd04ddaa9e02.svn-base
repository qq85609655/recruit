package com.csot.gm.materialManage.service.document;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.csot.gm.materialManage.model.extension.document.File;

public interface FileService {

  /**
   * 根据文件名获取文件记录
   * 
   * @param fileName
   * @return
   */
  List<File> getFile(String fileName);

  /**
   * 将文件信息添加到数据库
   * 
   * @param file
   * @param basePath
   * @return
   */
  int addFileToDb(File file, String basePath);

  /**
   * 下载文件
   * 
   * @param response
   * @param id
   */
  void load(HttpServletResponse response, String id);

  /**
   * 删除文件
   * 
   * @param id
   * @return
   */
  boolean deletFile(String id);

  /**
   * 验证是否存在该文件名
   * 
   * @param fileNames
   * @return
   */
  boolean validateFileName(String fileName);

  /**
   * 获取swf文件
   * 
   * @param id
   * @return
   * @throws Exception
   */
  String getFileSwfUrl(String id) throws Exception;

}
