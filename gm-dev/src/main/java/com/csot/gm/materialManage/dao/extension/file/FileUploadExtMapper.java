package com.csot.gm.materialManage.dao.extension.file;

import com.csot.gm.materialManage.model.extension.file.FileUploadExtCriteria;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

public interface FileUploadExtMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  int countByExample(FileUploadExtCriteria example);
}