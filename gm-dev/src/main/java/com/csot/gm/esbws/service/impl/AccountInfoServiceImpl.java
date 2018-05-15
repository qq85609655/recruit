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
import com.csot.gm.esbws.account.ESBESBESBImportUserAccountInfoRouteSrvInputItem;
import com.csot.gm.esbws.account.ErrorItem;
import com.csot.gm.esbws.account.ResponseItem;
import com.csot.gm.esbws.service.AccountInfoService;

@Service("accountInfoService")
public class AccountInfoServiceImpl implements AccountInfoService {

  private static final Logger LOG = Logger.getLogger(AccountInfoServiceImpl.class.getName());
  private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Resource
  AccountInfoDao accountInfoDao;

  @Transactional
  @Override
  public void updateAccountInfo(ESBESBESBImportUserAccountInfoRouteSrvInputItem inputItem,
      String processId, List<ResponseItem> responseItemList, List<ErrorItem> errorItemList) {

    // 数据校验，判断imputItem是否为null，直接添加ErrorItem并返回
    if (null == inputItem) {
      ErrorItem errorItem = new ErrorItem();
      errorItem.setERRORMESSAGE("导入对象[inputItem]不能为NULL");
      errorItemList.add(errorItem);
      return;
    }

    String priKey = inputItem.getPRIKEY() == null ? "" : inputItem.getPRIKEY().toString();

    // 数据校验，如果不通过，直接添加ErrorItem并返回
    if (StringUtils.isEmpty(inputItem.getCCODE())) {
      ErrorItem errorItem = new ErrorItem();
      errorItem.setCLOGINNAME(inputItem.getCLOGINNAME());
      errorItem.setPRIKEY(priKey);
      errorItem.setENTITYNAME(inputItem.getCNAME());
      errorItem.setERRORMESSAGE("工号[CCODE]不能为空");
      errorItemList.add(errorItem);
      return;
    }

    try {

      String operateType = inputItem.getOPERATETYPE();
      if ("D".equals(operateType)) {
        accountInfoDao.removeAccountInfo(inputItem.getCCODE());
        ResponseItem responseItem = new ResponseItem();
        responseItem.setCLOGINNAME(inputItem.getCLOGINNAME());
        responseItem.setPRIKEY(priKey);
        responseItem.setREQUESTID(processId);
        responseItemList.add(responseItem);
        return;
      }

      AccountInfoEntity accountInfoEntity = new AccountInfoEntity();
      accountInfoEntity.setCode(inputItem.getCCODE());
      accountInfoEntity.setPcode(inputItem.getCUNITCODE());
      accountInfoEntity.setMobile(inputItem.getCMOBILE());
      accountInfoEntity.setName(inputItem.getCNAME());
      accountInfoEntity.setTelephone(inputItem.getCTELEPHONE());
      accountInfoEntity.setUpdateTime(format.format(new Date()));

      AccountInfoEntity user = accountInfoDao.queryItemByCode(inputItem.getCCODE());
      if (null == user) {
        accountInfoEntity.setId(UUID.randomUUID().toString().replace("-", ""));
        accountInfoEntity.setType("P");
        accountInfoDao.createAccountInfo(accountInfoEntity);
        LOG.debug("create user: " + accountInfoEntity.getCode());
      } else {
        accountInfoDao.updateAccountInfo(accountInfoEntity);
        LOG.debug("update user: " + accountInfoEntity.getCode());
      }

      ResponseItem responseItem = new ResponseItem();
      responseItem.setCLOGINNAME(inputItem.getCLOGINNAME());
      responseItem.setPRIKEY(priKey);
      responseItem.setREQUESTID(processId);
      responseItemList.add(responseItem);
    } catch (Exception ex) {
      ErrorItem errorItem = new ErrorItem();
      errorItem.setCLOGINNAME(inputItem.getCLOGINNAME());
      errorItem.setPRIKEY(priKey);
      errorItem.setENTITYNAME(inputItem.getCNAME());
      errorItem.setERRORMESSAGE(ex.getMessage());
      errorItemList.add(errorItem);

      RuntimeException newEx = new RuntimeException();
      newEx.initCause(ex);
      throw newEx;
    }

    return;
  }

  @Override
  public void createAccount(AccountInfoEntity accountInfoEntity) {
    accountInfoDao.createAccountInfo(accountInfoEntity);    
  }
}
