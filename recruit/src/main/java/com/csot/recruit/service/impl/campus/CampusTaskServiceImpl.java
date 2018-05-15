package com.csot.recruit.service.impl.campus;

import com.csot.recruit.common.util.CampusUtils;
import com.csot.recruit.common.util.CommonConstant;
import com.csot.recruit.common.util.ExcelReadUtils;
import com.csot.recruit.dao.extension.campus.CampusTaskExtMapper;
import com.csot.recruit.dao.original.campus.CampusTaskMapper;
import com.csot.recruit.model.datadict.DatadictGroupType;
import com.csot.recruit.model.original.campus.*;
import com.csot.recruit.service.campus.CampusPostService;
import com.csot.recruit.service.campus.CampusSiteService;
import com.csot.recruit.service.campus.CampusTaskHistoryService;
import com.csot.recruit.service.campus.CampusTaskService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.csot.recruit.service.datadict.DatadictGroupTypeService;
import org.amberframework.core.common.model.AjaxRtnJson;
import org.amberframework.core.excel.poi.ExcelExportManager;
import org.amberframework.core.excel.poi.mapping.ClasspathXmlExcelDataMappingResolver;
import org.amberframework.core.excel.poi.mapping.ExcelDataMappingResolver;
import org.amberframework.core.excel.poi.template.ClasspathExcelTemplateProvider;
import org.amberframework.core.excel.poi.template.ExcelTemplateProvider;
import org.amberframework.core.mybatis.pojo.Page;
import org.amberframework.web.miniui.pojo.MiniGridPageSort;
import org.amberframework.web.miniui.pojo.MiniRtn2Grid;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Service("campusTaskService") public class CampusTaskServiceImpl implements CampusTaskService {
  private static final Logger logger = LoggerFactory.getLogger(CampusTaskServiceImpl.class);

  @Resource private CampusTaskMapper campusTaskMapper;
  @Resource private CampusTaskExtMapper campusTaskExtMapper;
  @Resource private CampusSiteService campusSiteService;
  @Resource private DatadictGroupTypeService datadictGroupTypeService;
  @Resource private CampusPostService campusPostService;
  @Resource private ExcelExportManager excelExportManager;
  @Resource private CampusTaskHistoryService campusTaskHistoryService;

  @Override public MiniRtn2Grid<CampusTask> getGrid(MiniGridPageSort pageSort, String yearth,
      String organizationId, String siteId, String postId) {
    MiniRtn2Grid<CampusTask> grid = new MiniRtn2Grid<>();
    CampusTaskCriteria criteria = new CampusTaskCriteria();
    CampusTaskCriteria.Criteria criter = criteria.or();
    // 查询条件
    if (StringUtils.hasText(yearth)) {
      criter.andYearthEqualTo(yearth);
    }
    if (StringUtils.hasText(organizationId)) {
      criter.andOrganizationEqualTo(organizationId);
    }
    if (StringUtils.hasText(siteId)) {
      criter.andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    // 分页和排序
    if (pageSort.isShowPager()) {
      Page page = Page.newInstanceWithPageIndex(pageSort.getPageIndex(), pageSort.getPageSize());
      criteria.setPage(page);
    }
    String sortColumn = CampusTaskColumns.getColumn(pageSort.getSortField());
    if (StringUtils.hasText(sortColumn)) {
      StringBuilder sortStrBldr =
          new StringBuilder(sortColumn).append(" ").append(pageSort.getSortOrder());
      criteria.setOrderByClause(sortStrBldr.toString());
    }
    grid.setData(campusTaskMapper.selectByExample(criteria));
    grid.setTotal(campusTaskMapper.countByExample(criteria));
    return grid;
  }

  @Override public CampusTask getByPrimaryKey(String primaryKey) {
    return campusTaskMapper.selectByPrimaryKey(primaryKey);
  }

  @Override public void create(CampusTask campusTask) {
    // 人数为空处理spinner bug
    if (null == campusTask.getTaskNumberSum()) {
      campusTask.setTaskNumberSum(0);
    }
    if (null == campusTask.getTaskNumberMail()) {
      campusTask.setTaskNumberMail(0);
    }
    if (null == campusTask.getTaskNumberFemail()) {
      campusTask.setTaskNumberFemail(0);
    }
    campusTaskMapper.insert(campusTask);
  }

  @Override public void updateSelective(CampusTask campusTask) {
    // 人数为空处理spinner bug
    if (null == campusTask.getTaskNumberSum()) {
      campusTask.setTaskNumberSum(0);
    }
    if (null == campusTask.getTaskNumberMail()) {
      campusTask.setTaskNumberMail(0);
    }
    if (null == campusTask.getTaskNumberFemail()) {
      campusTask.setTaskNumberFemail(0);
    }
    // 检查任务人数是否有变更；若有变更需记录
    // 获取原有任务人数
    CampusTask oldTask = campusTaskMapper.selectByPrimaryKey(campusTask.getId());
    Integer oldSum = oldTask.getTaskNumberSum();
    Integer oldMail = oldTask.getTaskNumberMail();
    Integer oldFemail = oldTask.getTaskNumberFemail();
    if (!(oldSum == campusTask.getTaskNumberSum()
            && oldMail == campusTask.getTaskNumberMail() && oldFemail == campusTask.getTaskNumberFemail())) {

      CampusTaskHistory cth = new CampusTaskHistory();
      cth.setId(UUID.randomUUID().toString().replace("-", ""));
      cth.setChangeDate(new Date());
      cth.setYearth(oldTask.getYearth());
      cth.setOrganization(oldTask.getOrganization());
      cth.setOrgName(oldTask.getOrgName());
      cth.setPostId(oldTask.getPostId());
      cth.setPostName(oldTask.getPostName());
      cth.setSiteId(oldTask.getSiteId());
      cth.setSiteName(oldTask.getSiteName());
      cth.setBigCenter(oldTask.getBigCenter());
      cth.setSmallCenter(oldTask.getSmallCenter());
      cth.setDepartment(oldTask.getDepartment());
      cth.setBranch(oldTask.getBranch());
      cth.setEducation(oldTask.getReserved1());
      cth.setTaskNumberSum(oldSum);
      cth.setTaskNumberFemail(oldFemail);
      cth.setTaskNumberMail(oldMail);
      cth.setTaskNumberSumNew(campusTask.getTaskNumberSum());
      cth.setTaskNumberMailNew(campusTask.getTaskNumberMail());
      cth.setTaskNumberFemailNew(campusTask.getTaskNumberFemail());
      campusTaskHistoryService.create(cth);
    }
    campusTaskMapper.updateByPrimaryKeySelective(campusTask);
  }

  @Override public String remove(String ids) {
    String[] idArr = ids.split(",");
    String msg = "";
    int deleteCount = 0;
    for (int i = 0; i < idArr.length; i++) {
      CampusTask campusTask = campusTaskMapper.selectByPrimaryKey(idArr[i]);
      // 检查站点是否已停用,停用站点的任务不允许修改
      String siteName = campusTask.getSiteName();
      CampusSite site = campusSiteService.getBySiteIdOrName("", siteName);
      if (!"1".equals(site.getStatus())) {
        msg = msg + "站点[" + siteName + "]已停用，不可删除;";
      } else {
        campusTaskMapper.deleteByPrimaryKey(idArr[i]);
        deleteCount++;
      }
    }
    if (deleteCount == idArr.length) {
      msg = "删除成功!";
    }
    return msg;
  }

  @Override public List<CampusTask> getCampusTaskBySiteId(String siteId) {
    CampusTaskCriteria criteria = new CampusTaskCriteria();
    criteria.or().andSiteIdEqualTo(siteId);
    return campusTaskMapper.selectByExample(criteria);
  }

  @Override public List<CampusTask> getCampusTaskByPostId(String postId) {
    CampusTaskCriteria criteria = new CampusTaskCriteria();
    criteria.or().andPostIdEqualTo(postId);
    return campusTaskMapper.selectByExample(criteria);
  }

  @SuppressWarnings("resource") @Override
  public AjaxRtnJson importCampusTask(MultipartFile multipartFile, String basePath)
      throws Exception {
    String msg = "";
    String sourceName = multipartFile.getOriginalFilename();
    File file = new File(basePath);
    if (!file.exists()) {
      file.mkdirs();
    }
    String path = basePath + File.separator + sourceName;
    multipartFile.transferTo(new File(path));
    FileInputStream in = new FileInputStream(path);
    Workbook wb = null;
    int count = 0;
    if (path.endsWith(".xls")) {
      wb = new HSSFWorkbook(in);
    } else if (path.endsWith(".xlsx")) {
      wb = new XSSFWorkbook(in);
    } else {
      return new AjaxRtnJson(false, "上传文件格式有误！");
    }
    Sheet sheet = wb.getSheetAt(0);
    int rowNum = sheet.getLastRowNum();
    if (rowNum < 2) {
      logger.error("上传文件为空！");
      return new AjaxRtnJson(false, "上传文件为空！");
    } else {
      for (int i = 2; i <= rowNum; i++) {
        Row row = sheet.getRow(i);
        String siteName = ExcelReadUtils.getValue(row.getCell(0));
        String orgName = ExcelReadUtils.getValue(row.getCell(1));
        String bigCenter = ExcelReadUtils.getValue(row.getCell(2));
        String smallCenter = ExcelReadUtils.getValue(row.getCell(3));
        String department = ExcelReadUtils.getValue(row.getCell(4));
        String branch = ExcelReadUtils.getValue(row.getCell(5));
        String jobFamily = ExcelReadUtils.getValue(row.getCell(6));
        String jobClass = ExcelReadUtils.getValue(row.getCell(7));
        String jobSubclass = ExcelReadUtils.getValue(row.getCell(8));
        String jobDescribe = ExcelReadUtils.getValue(row.getCell(9));
        String nightShift = ExcelReadUtils.getValue(row.getCell(10));
        String dustFree = ExcelReadUtils.getValue(row.getCell(11));
        String education = ExcelReadUtils.getValue(row.getCell(12));
        String taskNumberSum = ExcelReadUtils.getValue(row.getCell(13));
        String taskNumberMail = ExcelReadUtils.getValue(row.getCell(14));
        String taskNumberFemail = ExcelReadUtils.getValue(row.getCell(15));
        String specialRequire = ExcelReadUtils.getValue(row.getCell(16));
        String preferredMajor = ExcelReadUtils.getValue(row.getCell(17));
        String alternativeMajor = ExcelReadUtils.getValue(row.getCell(18));
        String remark = ExcelReadUtils.getValue(row.getCell(19));

        Integer taskNumberSumInt =
            StringUtils.hasText(taskNumberSum) ? Integer.parseInt(taskNumberSum) : 0;
        Integer taskNumberMailInt =
            StringUtils.hasText(taskNumberMail) ? Integer.parseInt(taskNumberMail) : 0;
        Integer taskNumberFemailInt =
            StringUtils.hasText(taskNumberFemail) ? Integer.parseInt(taskNumberFemail) : 0;
        String yearth = CampusUtils.getCurrentYearth();

        // 校验唯一性校验字段是否已填
        if (!StringUtils.hasText(siteName)) {
          msg = msg + (i+1) + "行未填写站点；";
          continue;
        }
        if (!StringUtils.hasText(orgName)) {
          msg = msg + (i+1) + "行未填写组织；";
          continue;
        }
        if (!StringUtils.hasText(bigCenter)) {
          msg = msg + (i+1) + "行未填写大中心；";
          continue;
        }
        if (!StringUtils.hasText(smallCenter)) {
          msg = msg + (i+1) + "行未填写小中心；";
          continue;
        }
        if (!StringUtils.hasText(department)) {
          msg = msg + (i+1) + "行未填写部门；";
          continue;
        }
        if (!StringUtils.hasText(branch)) {
          msg = msg + (i+1) + "行未填写科室；";
          continue;
        }
        if (!StringUtils.hasText(jobFamily)) {
          msg = msg + (i+1) + "行未填写职位族；";
          continue;
        }
        if (!StringUtils.hasText(jobClass)) {
          msg = msg + (i+1) + "行未填写职位类；";
          continue;
        }

        if (!(StringUtils.hasText(education) && (CommonConstant.EDUCATION_BA.equals(education)
                || CommonConstant.EDUCATION_MA.equals(education) || CommonConstant.EDUCATION_DO.equals(education)))) {
          msg = msg + (i+1) + "行未填写正确学历（本科/硕士/博士）；";
          continue;
        }

        if (taskNumberSumInt < taskNumberMailInt + taskNumberFemailInt) {
          msg = msg + (i+1) + "行任务总数应不小于男女总和；";
          continue;
        }

        // 校验组织、站点、职位族、职位类是否存在
        CampusSite site = campusSiteService.getBySiteIdOrName("", siteName);
        DatadictGroupType jf =
            datadictGroupTypeService.getTypeByGorupCodeAndName("post_family", jobFamily);
        DatadictGroupType post =
            datadictGroupTypeService.getTypeByGorupCodeAndName("pose_type", jobClass);
        DatadictGroupType org =
            datadictGroupTypeService.getTypeByGorupCodeAndName("campus_company", orgName);
        if (null == site || null == post || null == org || null == jf || !"1".equals(site.getStatus())) {
          if (null == site) {
            msg = msg + siteName + "站点不存在；";
          } else if (!"1".equals(site.getStatus())) {
            msg = msg + siteName + "站点已停用；";
          }
          if (null == jf) {
            msg = msg + jobFamily + "职位族不存在；";
          }
          if (null == post) {
            msg = msg + jobClass + "职位类不存在；";
          }
          if (null == org) {
            msg = msg + orgName + "组织不存在；";
          }
          continue;
        }

        // 校验该职位族对应的职位类是否已创建为岗位
        CampusPost campusPost =
            campusPostService.getByPostIdAndJobFamily(post.getTypeId(), jf.getTypeId());
        if (null == campusPost) {
          msg = msg + "职位族[" + jobFamily + "]下的职位类[" + jobClass + "]岗位未创建；";
          continue;
        }

        CampusTask task = new CampusTask();
        task.setYearth(yearth);
        task.setPostId(post.getTypeId());
        task.setPostName(jobClass);
        task.setSiteId(site.getSiteId());
        task.setSiteName(siteName);
        task.setOrganization(org.getTypeId());
        task.setOrgName(orgName);
        task.setBigCenter(bigCenter);
        task.setSmallCenter(smallCenter);
        task.setDepartment(department);
        task.setBranch(branch);
        task.setJobFamily(jobFamily);
        task.setJobClass(jobClass);
        task.setJobSubclass(jobSubclass);
        task.setJobDescribe(jobDescribe);
        task.setNightShift(nightShift);
        task.setDustFree(dustFree);
        task.setReserved1(education);
        task.setTaskNumberSum(taskNumberSumInt);
        task.setTaskNumberMail(taskNumberMailInt);
        task.setTaskNumberFemail(taskNumberFemailInt);
        task.setSpecialRequire(specialRequire);
        task.setPreferredMajor(preferredMajor);
        task.setAlternativeMajor(alternativeMajor);
        task.setRemark(remark);

        CampusTask isExsit = checkTaskIsExsit(task);
        if (null == isExsit) {
          task.setId(UUID.randomUUID().toString().replace("-", ""));
          campusTaskMapper.insert(task);
        } else {
          task.setId(isExsit.getId());
          updateSelective(task);
        }
        count++;
      }
    }
    return new AjaxRtnJson(true, "成功更新" + count + "条任务； " + msg);
  }

  @Override public List<CampusTask> getGrid4Yearth() {
    return campusTaskExtMapper.selectAllYearth();
  }

  @Override
  public List<CampusTask> getTaskByOrganizationSitePostYearth(String organizationId, String siteId,
      String postId, String yearth) {
    CampusTaskCriteria criteria = new CampusTaskCriteria();
    CampusTaskCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(organizationId)) {
      criter.andOrganizationEqualTo(organizationId);
    }
    if (StringUtils.hasText(siteId)) {
      criter.andSiteIdEqualTo(siteId);
    }
    if (StringUtils.hasText(postId)) {
      criter.andPostIdEqualTo(postId);
    }
    if (StringUtils.hasText(yearth)) {
      criter.andYearthEqualTo(yearth);
    }
    List<CampusTask> list = campusTaskMapper.selectByExample(criteria);
    return list;
  }

  @Override public CampusTask checkTaskIsExsit(CampusTask task) {
    CampusTaskCriteria criteria = new CampusTaskCriteria();
    CampusTaskCriteria.Criteria criter = criteria.or();
    if (StringUtils.hasText(task.getYearth())) {
      criter.andYearthEqualTo(task.getYearth());
    }
    if (StringUtils.hasText(task.getPostId())) {
      criter.andPostIdEqualTo(task.getPostId());
    }
    if (StringUtils.hasText(task.getSiteId())) {
      criter.andSiteIdEqualTo(task.getSiteId());
    }
    if (StringUtils.hasText(task.getOrganization())) {
      criter.andOrganizationEqualTo(task.getOrganization());
    }
    if (StringUtils.hasText(task.getBigCenter())) {
      criter.andBigCenterEqualTo(task.getBigCenter());
    }
    if (StringUtils.hasText(task.getSmallCenter())) {
      criter.andSmallCenterEqualTo(task.getSmallCenter());
    }
    if (StringUtils.hasText(task.getDepartment())) {
      criter.andDepartmentEqualTo(task.getDepartment());
    }
    if (StringUtils.hasText(task.getBranch())) {
      criter.andBranchEqualTo(task.getBranch());
    }
    if (StringUtils.hasText(task.getReserved1())) {
      criter.andReserved1EqualTo(task.getReserved1());
    }
    List<CampusTask> list = campusTaskMapper.selectByExample(criteria);
    if (list.isEmpty()) {
      return null;
    }
    return list.get(0);
  }

  @Override public void exportByTemplate(HttpServletResponse response, String exportFileName,
      Collection<?> dataset, String xmlPath, String templatePath) {

    ExcelTemplateProvider classpathExcelTemplateProvider =
        ClasspathExcelTemplateProvider.newInstance(templatePath, 0);
    ExcelDataMappingResolver classpathXmlExcelDataMappingResolver =
        ClasspathXmlExcelDataMappingResolver.newInstance(xmlPath);
    Workbook wb = excelExportManager.exportExcel(dataset, null, classpathExcelTemplateProvider,
        classpathXmlExcelDataMappingResolver);

    response.setContentType("application/vnd.ms-excel");
    OutputStream ops = null;
    try {
      response.setHeader("content-disposition", "attachment;filename=" + exportFileName);
      ops = response.getOutputStream();
      wb.write(ops);
    } catch (IOException e) {
      logger.error(e.getMessage(), e);
    } finally {
      try {
        ops.close();
        wb.close();
      } catch (IOException e) {
        logger.error(e.getMessage(), e);
      }
    }
  }

  @Override public List<CampusTask> getGrid4Sum(String yearth, String organizationId, String siteId,
      String postId) {
    if (!StringUtils.hasText(yearth)) {
      yearth = "%";
    }
    if (!StringUtils.hasText(organizationId)) {
      organizationId = "%";
    }
    if (!StringUtils.hasText(siteId)) {
      siteId = "%";
    }
    if (!StringUtils.hasText(postId)) {
      postId = "%";
    }
    return campusTaskMapper.getTaskSum(organizationId, postId, siteId, yearth);
  }

}