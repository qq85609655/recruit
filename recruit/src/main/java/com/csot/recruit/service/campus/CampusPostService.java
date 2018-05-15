package com.csot.recruit.service.campus;

import com.csot.recruit.model.original.campus.CampusPost;

import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CampusPostService {
  MiniRtn2Grid<CampusPost> getGrid(MiniGridPageSort pageSort, String postId, String jobFamily,
      String organization);

  CampusPost getByPrimaryKey(String primaryKey);

  void create(CampusPost campusPost);

  void updateSelective(CampusPost campusPost);

  void remove(String primaryKey);

  AjaxRtnJson importCampusPost(MultipartFile multipartFile, String basePath) throws Exception;

  CampusPost getByPostIdAndJobFamily(String postId, String jobFamily);

  List<CampusPost> getPostByJobFamily(String jobFamilyId);

  List<CampusPost> getByPostJobFamilyOrganiztion(String postId, String jobFamilyId,
      String organizationId);
}
