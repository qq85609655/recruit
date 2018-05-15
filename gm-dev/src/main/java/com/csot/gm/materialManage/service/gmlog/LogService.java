package com.csot.gm.materialManage.service.gmlog;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.springframework.transaction.annotation.Transactional;

import com.csot.gm.materialManage.model.original.enumType.EnumType;
import com.csot.gm.materialManage.model.original.enumValue.EnumValue;
import com.csot.gm.materialManage.model.original.gmlog.Log;
import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;

public interface LogService {
  MiniRtn2Grid<Log> getGrid(MiniGridPageSort pageSort, String searchKey);

  Log getByPrimaryKey(String primaryKey);

  /**
   * 日志记录
   * 
   * @param log
   */
  @Transactional
  void create(Log log);

  void updateSelective(Log log);

  void remove(String primaryKey);

  void logEnumType(SysUser sysUser, EnumType et, String operation);

  void logEnumValue(SysUser sysUser, EnumValue ev, String operation);

  void logPropertyMap(SysUser sysUser, String proId, String etId, String operation);

  void logUpdateUniqueProValue(SysUser sysUser, PropertyValue[] propertyValueList);

  void logUpdateLevel3Name(SysUser sysUser, String partNum, String newMsg, String oldMsg,
      String string);

  void logUploadEnum(EnumValue ev, SysUser sysUser, String operation);

  void logDeletePartNo(String partNo, SysUser sysUser);


}
