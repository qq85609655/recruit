package com.csot.gm.materialManage.service.userInfo;

import com.csot.gm.materialManage.model.original.userInfo.UserInfo;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;

public interface UserInfoService {
  MiniRtn2Grid<UserInfo> getGrid(MiniGridPageSort pageSort, String searchKey);

  UserInfo getByPrimaryKey(String primaryKey);

  void create(UserInfo userInfo);

  void updateSelective(UserInfo userInfo);

  void remove(String primaryKey);

  com.csot.gm.rawMaterial.model.UserInfo getByUserCode(String userCode);
}