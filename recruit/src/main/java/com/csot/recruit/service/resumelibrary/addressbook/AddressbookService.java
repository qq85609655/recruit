package com.csot.recruit.service.resumelibrary.addressbook;

import com.csot.recruit.model.original.resumelibrary.addressbook.Addressbook;

import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.web.multipart.MultipartFile;

public interface AddressbookService {
  MiniRtn2Grid<Addressbook> getGrid(MiniGridPageSort pageSort, String personName, String company,
      String remark);

  Addressbook getByPrimaryKey(String primaryKey);

  void create(Addressbook addressbook);

  void updateSelective(Addressbook addressbook);

  void remove(String primaryKey);

  int importAddressbook(MultipartFile multipartFile, String basePath, String importer) throws Exception;
}
