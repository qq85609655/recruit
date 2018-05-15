package com.csot.gm.rawMaterial.service;

import java.util.List;

import com.csot.gm.materialManage.model.extension.partNo.PartNoExt;

public interface PartNoManageService {
  
  void deletePartNoById(String partNo);
  
  List<PartNoExt> selectPartNoListByStatus(String status);
  
}
