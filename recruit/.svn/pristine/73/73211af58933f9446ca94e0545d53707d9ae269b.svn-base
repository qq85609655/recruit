package com.csot.recruit.service.campus;


import java.util.List;

import com.csot.recruit.model.original.campus.CampusStudent;

import org.amberframework.core.bind.annotation.CurrentUser;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

public interface CampusStudentService {
  MiniRtn2Grid<CampusStudent> getGrid(MiniGridPageSort pageSort, String siteName, String postName,
      String stuName, String school, String org, String center, String yearth, String showType,
      String radioValue1, String radioValue2, String radioValue3, String radioValue4,
      String radioValue5, String radioValue6, String radioValue7, String radioValue8);

  CampusStudent getByPrimaryKey(String primaryKey);

  void create(CampusStudent campusStudent);

  void updateSelective(CampusStudent campusStudent);

  void remove(String primaryKey);

  String importStudentInfo(MultipartFile multipartFile, String basePath,
      @CurrentUser SysUser sysUser);

  List<CampusStudent> getStuInfoByStudentList(List<String> studentIdList);

}
