package com.csot.recruit.service.campus;

import com.csot.recruit.model.original.campus.CampusTask;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;

public interface CampusTaskService {
  MiniRtn2Grid<CampusTask> getGrid(MiniGridPageSort pageSort, String yearth, String organizationId,
                                   String siteId, String postId);

  List<CampusTask> getGrid4Sum(String yearth, String organizationId, String siteId, String postId);

  CampusTask getByPrimaryKey(String primaryKey);

  void create(CampusTask campusTask);

  void updateSelective(CampusTask campusTask);

  String remove(String ids);

  List<CampusTask> getCampusTaskBySiteId(String siteId);

  List<CampusTask> getCampusTaskByPostId(String postId);

  AjaxRtnJson importCampusTask(MultipartFile multipartFile, String basePath) throws Exception;

  List<CampusTask> getGrid4Yearth();

  List<CampusTask> getTaskByOrganizationSitePostYearth(String organizationId, String siteId,
                                                       String postId, String yearth);

  CampusTask checkTaskIsExsit(CampusTask task);

  void exportByTemplate(HttpServletResponse response, String exportFileName, Collection<?> dataset,
                        String xmlPath, String templatePath);
}
