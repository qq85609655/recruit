package com.csot.gm.materialManage.service.impl.gmlog;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.csot.gm.materialManage.dao.extension.propertiesM.PropertiesMExtMapper;
import com.csot.gm.materialManage.dao.original.enumType.EnumTypeMapper;
import com.csot.gm.materialManage.dao.original.enumValue.EnumValueMapper;
import com.csot.gm.materialManage.dao.original.gmlog.LogMapper;
import com.csot.gm.materialManage.dao.original.part.PartMapper;
import com.csot.gm.materialManage.dao.original.partNo.PartNoMapper;
import com.csot.gm.materialManage.dao.original.properties.PartPropertiesMapper;
import com.csot.gm.materialManage.dao.original.propertyValue.PropertyValueMapper;
import com.csot.gm.materialManage.model.extension.propertiesM.PropertiesMExt;
import com.csot.gm.materialManage.model.original.enumType.EnumType;
import com.csot.gm.materialManage.model.original.enumValue.EnumValue;
import com.csot.gm.materialManage.model.original.gmlog.Log;
import com.csot.gm.materialManage.model.original.gmlog.LogColumns;
import com.csot.gm.materialManage.model.original.gmlog.LogCriteria;
import com.csot.gm.materialManage.model.original.propertyValue.PropertyValue;
import com.csot.gm.materialManage.service.gmlog.LogService;

@Service("logService")
public class LogServiceImpl implements LogService {

  @Resource
  private LogMapper logMapper;
  @Resource
  private EnumTypeMapper enumTypeMapper;
  @Resource
  private EnumValueMapper enumValueMapper;
  @Resource
  private PartPropertiesMapper partPropertiesMapper;
  @Resource
  private PartMapper partMapper;
  @Resource
  private PropertiesMExtMapper propertiesMExtMapper;
  @Resource
  private PropertyValueMapper propertyValueMapper;
  @Resource
  private PartNoMapper partNoMapper;

  @Override
  public MiniRtn2Grid<Log> getGrid(MiniGridPageSort pageSort, String searchKey) {
    MiniRtn2Grid<Log> grid = new MiniRtn2Grid<Log>();
    LogCriteria criteria = new LogCriteria();
    // 查询条件
    if (StringUtils.hasText(searchKey)) {
      criteria.createCriteria().andContentLikeInsensitive("%" + searchKey + "%");
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = LogColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(logMapper.selectByExample(criteria));
    grid.setTotal(logMapper.countByExample(criteria));
    return grid;
  }

  @Override
  public Log getByPrimaryKey(String primaryKey) {
    return logMapper.selectByPrimaryKey(primaryKey);
  }

  @Override
  public void create(Log log) {
    log.setId(UUID.randomUUID().toString().replace("-", ""));
    logMapper.insert(log);
  }

  @Override
  public void updateSelective(Log log) {
    logMapper.updateByPrimaryKeySelective(log);
  }

  @Override
  public void remove(String primaryKey) {
    logMapper.deleteByPrimaryKey(primaryKey);
  }

  @Override
  public void logEnumType(SysUser sysUser, EnumType et, String operation) {
    Log log = new Log();
    log.setUserName(sysUser.getAccount());
    log.setCreateTime(new Date());
    log.setOperation(operation);
    if ("更新".equals(operation)) {
      String oldEnumName = enumTypeMapper.selectByPrimaryKey(et.getId()).getEnumName();
      String newEnumName = et.getEnumName();
      log.setContent("枚举类[" + oldEnumName + "]更新为[" + newEnumName + "]");
    } else {
      log.setContent("枚举类[" + et.getEnumName() + "]");
    }
    create(log);

  }

  @Override
  public void logEnumValue(SysUser sysUser, EnumValue ev, String operation) {
    Log log = new Log();
    log.setUserName(sysUser.getAccount());
    log.setCreateTime(new Date());
    log.setOperation(operation);
    if ("更新".equals(operation)) {
      String oldEnumText = enumValueMapper.selectByPrimaryKey(ev.getId()).getEnumText();
      String oldEnumValue = enumValueMapper.selectByPrimaryKey(ev.getId()).getEnumValue();
      String newEnumText = ev.getEnumText();
      String newEnumValue = ev.getEnumValue();
      log.setContent("枚举类[" + enumTypeMapper.selectByPrimaryKey(ev.getEnumTypeId()).getEnumName()
          + "];枚举显示值[" + oldEnumText + "]更新为[" + newEnumText + "];枚举真实值[" + oldEnumValue + "]更新为["
          + newEnumValue + "]");
    } else {
      log.setContent("枚举类[" + enumTypeMapper.selectByPrimaryKey(ev.getEnumTypeId()).getEnumName()
          + "];枚举显示值[" + ev.getEnumText() + "];枚举真实值[" + ev.getEnumValue() + "]");
    }
    create(log);

  }

  @Override
  public void logPropertyMap(SysUser sysUser, String proId, String etId, String operation) {

    String proDisName = partPropertiesMapper.selectByPrimaryKey(proId).getPropertyDisName();
    String partId = partPropertiesMapper.selectByPrimaryKey(proId).getPartId();
    String partDesc = partMapper.selectByPrimaryKey(partId).getPartDesc();
    String preCode = partMapper.selectByPrimaryKey(partId).getPartPrefixCode();
    String newEnumTypeName = enumTypeMapper.selectByPrimaryKey(etId).getEnumName();
    List<PropertiesMExt> oldMap = propertiesMExtMapper.getEnumIdByPropertyId(proId);
    String oldEnumTypeName = "";
    if (!oldMap.isEmpty()) {
      oldEnumTypeName = enumTypeMapper.selectByPrimaryKey(oldMap.get(0).getEnumId()).getEnumName();
    }

    Log log = new Log();
    log.setUserName(sysUser.getAccount());
    log.setCreateTime(new Date());
    log.setOperation(operation);
    log.setContent("level 3：" + partDesc + "[" + preCode + "]的属性[" + proDisName + "]的枚举类["
        + oldEnumTypeName + "]更新为[" + newEnumTypeName + "]");
    create(log);

  }

  @Override
  public void logUpdateUniqueProValue(SysUser sysUser, PropertyValue[] propertyValueList) {

    String partNo = partNoMapper.selectByPrimaryKey(propertyValueList[0].getPartNoId()).getPartNo();

    for (int i = 0; i < propertyValueList.length; i++) {
      String propertyName =
          propertyValueMapper.selectByPrimaryKey(propertyValueList[i].getId()).getPropertyName();
      String oldProValue =
          propertyValueMapper.selectByPrimaryKey(propertyValueList[i].getId()).getPropertyValue();
      String newProValue = propertyValueList[i].getPropertyValue();

      Log log = new Log();
      log.setUserName(sysUser.getAccount());
      log.setCreateTime(new Date());
      log.setOperation("更新");
      log.setContent("料号:[" + partNo + "]的属性[" + propertyName + "];属性值[" + oldProValue + "]更新为["
          + newProValue + "]");
      create(log);
    }

  }

  /**
   * 更改料号level3的对应日志
   */
  @Override
  public void logUpdateLevel3Name(SysUser sysUser, String partNum, String newMsg, String oldMsg,
      String operation) {
    Log log = new Log();
    log.setUserName(sysUser.getAccount());
    log.setCreateTime(new Date());
    log.setOperation(operation);

    if ("更新".equals(operation)) {
      // 设置日志内容
      log.setContent("料号：" + partNum + "的原分类为(" + oldMsg + ")" + "修改后分类为(" + newMsg + ")");
    } else {
      log.setContent("料号：" + partNum + "的原分类为(" + oldMsg + ")");
    }

    create(log);

  }

  /**
   * 导入枚举值，当显示值长度>30时，在日志管理内提示相应的枚举值已经超过30个字符
   */
  @Override
  public void logUploadEnum(EnumValue ev, SysUser sysUser, String operation) {
    Log log = new Log();
    log.setUserName(sysUser.getAccount());
    log.setCreateTime(new Date());
    log.setOperation(operation);

    if ("新增".equals(operation)) {
      // 设置日志内容
      log.setContent("枚举显示值：" + ev.getEnumText() + "长度超过30个字符");
    } else {
      log.setContent("枚举显示值：" + "[" + ev.getEnumText() + "]" + "或真实值：" + "[" + ev.getEnumValue()
          + "]" + "已存在系统");
    }

    create(log);
  }

  /*
   * 删除料号时，在日志管理内显示删除的料号
   */
  @Override
  public void logDeletePartNo(String partNo, SysUser sysUser) {
    Log log = new Log();
    log.setUserName(sysUser.getAccount());
    log.setCreateTime(new Date());
    log.setOperation("删除");

    log.setContent("料号:" + partNo + "已删除!");

    create(log);
  }

}
