package com.csot.gm.materialManage.dao.original.file;

import com.csot.gm.materialManage.model.original.file.FileUpload;
import com.csot.gm.materialManage.model.original.file.FileUploadCriteria;

import java.util.List;
import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.apache.ibatis.annotations.Param;

public interface FileUploadMapper extends MyBatisBaseMapper {
  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  int countByExample(FileUploadCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  int deleteByExample(FileUploadCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  int deleteByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  int insert(FileUpload record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  int insertSelective(FileUpload record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  List<FileUpload> selectByExample(FileUploadCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  FileUpload selectByPrimaryKey(String id);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  int updateByExampleSelective(@Param("record") FileUpload record,
      @Param("example") FileUploadCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  int updateByExample(@Param("record") FileUpload record,
      @Param("example") FileUploadCriteria example);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  int updateByPrimaryKeySelective(FileUpload record);

  /**
   * This method was generated by MyBatis Generator.
   * This method corresponds to the database table T_GM_FILE_UPLOAD
   *
   * @mbggenerated
   */
  int updateByPrimaryKey(FileUpload record);
}