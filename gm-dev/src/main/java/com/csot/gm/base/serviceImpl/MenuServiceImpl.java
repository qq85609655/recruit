package com.csot.gm.base.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.amberframework.web.system.auth.model.original.resource.SysResource;
import org.springframework.stereotype.Service;

import com.csot.gm.base.dao.extension.MenuMapper;
import com.csot.gm.base.service.MenuService;

@Service("MenuService")
public class MenuServiceImpl implements MenuService {

  @Resource
  private MenuMapper menuMapper;

  @Override
  public List<SysResource> getMenuByName(String url) {
    

      return menuMapper.selectMenuByName(url);

    
  }

  


}
