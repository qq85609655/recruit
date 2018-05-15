package com.csot.gm.esbws.dao;

import java.util.List;

import org.amberframework.core.mybatis.dao.MyBatisBaseMapper;

import com.csot.gm.esbws.entity.AccountInfoEntity;

public interface AccountInfoDao extends MyBatisBaseMapper {

  AccountInfoEntity queryItemByCode(String code);

  List<AccountInfoEntity> queryChildItemsByCode(String code);

  public void createAccountInfo(AccountInfoEntity accountInfoEntity);

  public void updateAccountInfo(AccountInfoEntity accountInfoEntity);

  public void removeAccountInfo(String code);

}
