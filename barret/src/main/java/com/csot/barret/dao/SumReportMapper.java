package com.csot.barret.dao;

import com.csot.barret.core.mybatis.annotation.MyBatisRepository;
import org.apache.ibatis.annotations.Param;


/**
 * Created by xiongyinchun on 2018/2/8.
 */
@MyBatisRepository
public interface SumReportMapper {
  int getBomValueAdd(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotBomValueAdd(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotProductValueAdd(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getBomPartNoAdd(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotBomPartNoAdd(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotProductPartNoAdd(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getBomPartNoUpdate(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotBomPartNoUpdate(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotProductPartNoUpdate(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getBomPlantExtend(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotBomPlantExtend(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotProductPlantExtend(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getBomPlantUpdate(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotBomPlantUpdate(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotProductPlantUpdate(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotBomStatusFreeze(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotProductStatusFreeze(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotBomReleaseFreeze(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotProductReleaseFreeze(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotBomForbidOrder(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotProductForbidOrder(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotBomReleaseOrder(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
  int getNotProductReleaseOrder(@Param("startTime") String startTime, @Param("endTime") String endTime, @Param("status") String status, @Param("companyName") String companyName);
}
