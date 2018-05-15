package com.csot.gm.base.dao.extension;


import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;
import org.amberframework.web.system.auth.model.original.resource.SysResource;

public interface MenuMapper extends MyBatisBaseMapper {
  /**
   * 通过url路径获取菜单列表
   * 
   * @param menuName
   * @return
   */
  
  List<SysResource> selectMenuByName(String name);
}
