package com.csot.gm.esbws.service;

import java.util.List;

import com.csot.gm.esbws.entity.AccountInfoEntity;
import com.csot.gm.esbws.org.ESBESBESBImportOrgInfoRouteSrvInputItem;
import com.csot.gm.esbws.org.ErrorItem;
import com.csot.gm.esbws.org.ResponseItem;

public interface OrgInfoService {
  public void updateOrgInfo(ESBESBESBImportOrgInfoRouteSrvInputItem inputItem, String processId,
      List<ResponseItem> responseItemList, List<ErrorItem> errorItemList);

  AccountInfoEntity getParentItem(String code);

}
