package com.csot.gm.rawMaterial.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.csot.gm.materialManage.dao.extension.partNo.PartNoExtMapper;
import com.csot.gm.materialManage.dao.extension.propertyValue.PropertyValueExtMapper;
import com.csot.gm.materialManage.dao.original.partNo.PartNoMapper;
import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;
import com.csot.gm.rawMaterial.service.PartNoManageService;

@Service("PartNoManageService")
public class PartNoManageServiceImpl implements PartNoManageService {

  private static final Logger logger = LoggerFactory.getLogger(PartNoManageServiceImpl.class);
  
  @Resource
  private PartNoExtMapper partNoExtMapper;
  @Resource
  private PropertyValueExtMapper propertyValueExtMapper;
  @Resource
  private PartNoMapper partNoMapper;
  
  @Override
  public void deletePartNoById(String partNoId) {
    propertyValueExtMapper.deleteByPartNoId(partNoId);
    partNoMapper.deleteByPrimaryKey(partNoId);
    logger.info("Id为：" + partNoId + "的料号已经被删除成功。");

  }

  @Override
  public List<PartNoExt> selectPartNoListByStatus(String status) {
    return partNoExtMapper.selectPartNoListByStatus(status);
  }

}
