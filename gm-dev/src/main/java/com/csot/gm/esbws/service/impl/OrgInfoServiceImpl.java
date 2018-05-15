package com.csot.gm.esbws.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.csot.gm.esbws.dao.AccountInfoDao;
import com.csot.gm.esbws.entity.AccountInfoEntity;
import com.csot.gm.esbws.org.ESBESBESBImportOrgInfoRouteSrvInputItem;
import com.csot.gm.esbws.org.ErrorItem;
import com.csot.gm.esbws.org.ResponseItem;
import com.csot.gm.esbws.service.OrgInfoService;

@Service("orgInfoService")
public class OrgInfoServiceImpl implements OrgInfoService {
  
  private static final Logger LOG = Logger.getLogger(OrgInfoServiceImpl.class.getName());
  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Resource
  AccountInfoDao accountInfoDao;

  @Transactional
  @Override
  public void updateOrgInfo(ESBESBESBImportOrgInfoRouteSrvInputItem inputItem, String processId,
      List<ResponseItem> responseItemList, List<ErrorItem> errorItemList) {

    // 数据校验，判断imputItem是否为null，直接添加ErrorItem并返回
    if (null == inputItem) {
      ErrorItem errorItem = new ErrorItem();
      errorItem.setERRORMESSAGE("导入对象[inputItem]不能为NULL");
      errorItemList.add(errorItem);
      return;
    }

    String priKey = inputItem.getPRIKEY() == null ? "" : inputItem.getPRIKEY().toString();

    // 数据校验，如果不通过，直接添加ErrorItem并返回
    if (StringUtils.isEmpty(inputItem.getCORGCODE())) {
      ErrorItem errorItem = new ErrorItem();
      errorItem.setENTITYNAME(inputItem.getCORGNAME());
      errorItem.setPRIKEY(priKey);
      errorItem.setERRORMESSAGE("组织编码[CORGCODE]不能为空");
      errorItemList.add(errorItem);
      return;
    }

    try {

      String operateType = inputItem.getOPERATETYPE();
      if ("D".equals(operateType)) {
        
        accountInfoDao.removeAccountInfo(inputItem.getCORGCODE());
        ResponseItem responseItem = new ResponseItem();
        responseItem.setCORGCODE(inputItem.getCORGNAME());
        responseItem.setPRIKEY(priKey);
        responseItem.setREQUESTID(processId);
        responseItemList.add(responseItem);
        return;
      }

      AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
      accountInfoEntity.setCode(inputItem.getCORGCODE());
      accountInfoEntity.setPcode(inputItem.getCORGPARENTCODE());
      accountInfoEntity.setName(inputItem.getCORGNAME());
      accountInfoEntity.setUpdateTime(format.format(new Date()));

      AccountInfoEntity user = accountInfoDao.queryItemByCode(inputItem.getCORGCODE());
      if (null == user) {
        accountInfoEntity.setId(UUID.randomUUID().toString().replace("-", ""));
        accountInfoEntity.setType("O");
        accountInfoDao.createAccountInfo(accountInfoEntity);
        LOG.debug("create org: " + accountInfoEntity.getCode());
      } else {
        accountInfoDao.updateAccountInfo(accountInfoEntity);
        LOG.debug("update org: " + accountInfoEntity.getCode());
      }

      ResponseItem responseItem = new ResponseItem();
      responseItem.setCORGCODE(inputItem.getCORGCODE());
      responseItem.setPRIKEY(priKey);
      responseItem.setREQUESTID(processId);
      responseItemList.add(responseItem);
    } catch (Exception ex) {
      ErrorItem errorItem = new ErrorItem();
      errorItem.setCORGCODE(inputItem.getCORGCODE());
      errorItem.setPRIKEY(priKey);
      errorItem.setENTITYNAME(inputItem.getCORGNAME());
      errorItem.setERRORMESSAGE(ex.getMessage());
      errorItemList.add(errorItem);

      RuntimeException newEx = new RuntimeException();
      newEx.initCause(ex);
      throw newEx;
    }

    return;
  }

  @Override
  public AccountInfoEntity getParentItem(String code) {
    AccountInfoEntity account = accountInfoDao.queryItemByCode(code);
    AccountInfoEntity parentItem = null;
    if (account != null) {
      String pcode = account.getPcode();
      LOG.debug("pcode: " + pcode); 
      parentItem = accountInfoDao.queryItemByCode(pcode);
    } 
    return parentItem;
  }

}
