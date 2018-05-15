package com.csot.recruit.service.campus;

import java.util.List;

import com.csot.recruit.model.extension.campus.CampusJobFamilyAchievement;
import org.apache.poi.ss.usermodel.Workbook;

import com.csot.recruit.model.extension.campus.CampusReportExt;

public interface CampusReportService {
  List<CampusReportExt> getGrid4Site(String yearth, String postId, String organizationId);

  List<CampusReportExt> getGrid4Post(String yearth, String siteId, String organizationId);

  CampusReportExt getReportByOrganizationSitePostYearth4Type(String organizationId, String siteId,
      String postId, String yearth, String type);

  List<CampusJobFamilyAchievement> getJobFamilyAchievementByYearth(String yearth);

}