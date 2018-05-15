package com.csot.recruit.service.campus;

import com.csot.recruit.model.original.campus.CampusTaskFirst;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CampusTaskFirstService {
  MiniRtn2Grid<CampusTaskFirst> getGrid(MiniGridPageSort pageSort, String yearth, String organizationId,
                                        String siteId, String postId);

  CampusTaskFirst getByPrimaryKey(String primaryKey);

  void create(CampusTaskFirst campusTaskFirst);

  void updateSelective(CampusTaskFirst campusTaskFirst);

  void remove(String ids);

  AjaxRtnJson importCampusTaskFirst(MultipartFile multipartFile, String basePath) throws Exception;

  List<CampusTaskFirst> getTaskFirstByOrganizationSitePostYearth(String organizationId, String siteId,
                                                                 String postId, String yearth);
}