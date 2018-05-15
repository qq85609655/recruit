package com.csot.gm.rawMaterial.service;

import java.util.Map;

import com.csot.gm.rawMaterial.model.CreationProInfo;
import com.csot.gm.rawMaterial.model.CreationRtn;

public interface PartNoCreateService {
  
  CreationRtn createPartNoAndDesc(CreationProInfo cpi);
  
  String getPartNoPreCode(String pagePreCode, Map<String, String[]> properties);
  
}
