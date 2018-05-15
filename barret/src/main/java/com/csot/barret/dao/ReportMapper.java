package com.csot.barret.dao;

import com.csot.barret.core.mybatis.annotation.MyBatisRepository;
import com.csot.barret.model.Report;

import java.util.List;

/**
 * Created by xiongyinchun on 2018/2/7.
 */
@MyBatisRepository
public interface ReportMapper {
  List<Report> selectBaseUser();
}

