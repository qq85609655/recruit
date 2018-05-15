package com.csot.gm.rawMaterial.service;

import java.util.Map;

import com.csot.gm.rawMaterial.model.CreationRtn;
import com.csot.gm.rawMaterial.model.PageRtn;
import com.csot.gm.rawMaterial.model.CreationProInfo;
import com.csot.gm.rawMaterial.model.PartNoInfo;
import com.csot.gm.rawMaterial.model.UniqueProperty;

public interface TranslateObjectService {
  
  UniqueProperty translateRtnProMap2Unique(Map<String, String> proMap, String partId);

  CreationProInfo translateRtnProMap2CreationPro(Map<String, String> proMap, String preCode,
      String partId, String partType, String classId);

  PartNoInfo translateAll2SaveInfo(PageRtn pr, CreationRtn cr, String hashCode);
}
